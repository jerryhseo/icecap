package com.osp.icecap.web.datatype.asset.renderer;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.osp.icecap.constants.OSPIcecapConstants;
import com.osp.icecap.constants.OSPIcecapPortletKeys;
import com.osp.icecap.model.DataType;
import com.osp.icecap.permissions.DataTypeModelPermission;
import com.osp.icecap.service.DataTypeLocalService;
import com.osp.icecap.web.constants.OSPIcecapWebConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, 
property = {"javax.portlet.name=" + OSPIcecapPortletKeys.DATA_TYPE_ADMIN_PORTLET_KEY}, 
service = AssetRendererFactory.class
)
public class DataTypeAssetRendererFactory extends BaseAssetRendererFactory<DataType> {
	 public DataTypeAssetRendererFactory() {
		setClassName(CLASS_NAME);
		setLinkable(_LINKABLE);
		setPortletId(OSPIcecapPortletKeys.DATA_TYPE_ADMIN_PORTLET_KEY); setSearchable(true);
		setSelectable(true); 
	 }

	@Override
	public AssetRenderer<DataType> getAssetRenderer(long classPK, int type) throws PortalException {
		DataType dataType = _dataTypeLocalService.getDataType(classPK);

		DataTypeAssetRenderer dataTypeAssetRenderer = 
		  new DataTypeAssetRenderer(dataType, _dataTypeModelResourcePermission);

		dataTypeAssetRenderer.setAssetRendererType(type);
		dataTypeAssetRenderer.setServletContext(_servletContext);

		return dataTypeAssetRenderer;
	}
	
	@Override
	public String getClassName() {
	    return CLASS_NAME;
	}
	
	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, 
	long classPK, String actionId) throws Exception {

		DataType dataType = _dataTypeLocalService.getDataType(classPK);
		long groupId = dataType.getGroupId();
		return DataTypeModelPermission.contains(permissionChecker, groupId, actionId);
	}
	
	@Override
	public PortletURL getURLAdd(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, long classTypeId) {
		PortletURL portletURL = null;

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

			portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay),
					OSPIcecapPortletKeys.DATA_TYPE_ADMIN_PORTLET_KEY, PortletRequest.RENDER_PHASE);
			
			MutableRenderParameters renderParams = portletURL.getRenderParameters(); 
			renderParams.setValue(OSPIcecapWebConstants.PARAM_MVCPATH, OSPIcecapWebConstants.MVCPATH_EDIT_DATATYPE);
			renderParams.setValue(OSPIcecapWebConstants.PARAM_SHOWBACK, Boolean.FALSE.toString());

		} catch (PortalException e) {
			logger.log(Level.SEVERE, e.getMessage()); 
		}

		return portletURL;
	}

	@Override
	public boolean isLinkable() {
	    return _LINKABLE;
	}

	@Override
	public String getIconCssClass() {
	  return "bookmarks";
	}

	@Reference(
			target = "(osgi.web.symbolicname="+OSPIcecapConstants.SYMBOLIC_NAME_ICECAP_WEB+")",
			unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
	    _servletContext = servletContext;
	}

	@Reference(unbind = "-")
	protected void setDataTypeLocalService(DataTypeLocalService dataTypeLocalService) {
	    _dataTypeLocalService = dataTypeLocalService; 
	}

	private ServletContext _servletContext;
	private DataTypeLocalService _dataTypeLocalService;
	private static final boolean _LINKABLE = true;
	public static final String CLASS_NAME = DataType.class.getName();
	public static final String TYPE = "DataType";
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private ModelResourcePermission<DataType> _dataTypeModelResourcePermission;
}
