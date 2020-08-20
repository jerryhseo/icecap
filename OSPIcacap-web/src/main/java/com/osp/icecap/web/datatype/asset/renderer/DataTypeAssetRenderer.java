package com.osp.icecap.web.datatype.asset.renderer;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.osp.icecap.constants.OSPIcecapActionKeys;
import com.osp.icecap.constants.OSPIcecapPortletKeys;
import com.osp.icecap.model.DataType;
import com.osp.icecap.web.constants.OSPIcecapWebConstants;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataTypeAssetRenderer extends BaseJSPAssetRenderer<DataType> {

	@Override
	public DataType getAssetObject() {
		return _dataType;
	}

	@Override
	public long getGroupId() {
		return _dataType.getGroupId();
	}

	@Override
	public long getUserId() {
		return _dataType.getGroupId();
	}

	@Override
	public String getUserName() {
		return _dataType.getUserName();
	}

	@Override
	public String getUuid() {
		return _dataType.getUuid();
	}

	@Override
	public String getClassName() {
		return DataType.class.getName();
	}

	@Override
	public long getClassPK() {
		return _dataType.getPrimaryKey();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return _dataType.getName() + ", v." + _dataType.getVersion();
	}

	@Override
	public String getTitle(Locale locale) {
		return _dataType.getName() + ", v." + _dataType.getVersion();
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		if (template.equals(TEMPLATE_FULL_CONTENT) ||
			 template.equals(TEMPLATE_ABSTRACT) ||
			 template.equals(TEMPLATE_PREVIEW) ) {
		      httpServletRequest.setAttribute(OSPIcecapWebConstants.ATTR_DATATYPE, _dataType);

		      return OSPIcecapWebConstants.JSP_FOLDER_PATH_DATATYPE_PORTLET_ASSET + template + ".jsp";
		    } else {
		      return null;
		    }
	}
	
	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse 
	  response, String template) throws Exception {
	    request.setAttribute(OSPIcecapWebConstants.ATTR_DATATYPE, _dataType);
	    request.setAttribute(OSPIcecapWebConstants.ATTR_HTML_UTIL, HtmlUtil.getHtml());
	    request.setAttribute(OSPIcecapWebConstants.ATTR_STRING_UTIL, new StringUtil());
	    return super.include(request, response, template);
	}

	public DataTypeAssetRenderer(DataType dataType, ModelResourcePermission<DataType> modelResourcePermission) {
		_dataType = dataType;
		_dataTypeModelResourcePermission = modelResourcePermission;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException {
		try {
	        return _dataTypeModelResourcePermission.contains(
	            permissionChecker, _dataType, OSPIcecapActionKeys.UPDATE_DATATYPE);
	    }
	    catch (Exception e) {
	    }

	    return false;
	}
	
	@Override
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		LiferayPortletURL renderURL = liferayPortletResponse.createRenderURL(OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY);
		
		MutableRenderParameters renderParams = renderURL.getRenderParameters(); 
		renderParams.setValue(OSPIcecapWebConstants.PARAM_MVCPATH, OSPIcecapWebConstants.JSP_PATH_EDIT_DATATYPE);
		renderParams.setValue(OSPIcecapWebConstants.PARAM_DATATYPE_ID, String.valueOf(_dataType.getPrimaryKey()));
		renderParams.setValue(OSPIcecapWebConstants.PARAM_SHOWBACK, Boolean.FALSE.toString());

		return renderURL;
	}
	
	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
	  LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
	    try {
	      long plid = PortalUtil.getPlidFromPortletId(_dataType.getGroupId(),
	          OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY);

	      PortletURL portletURL;
	      if (plid == LayoutConstants.DEFAULT_PLID) {
	        portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
	        		OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY, PortletRequest.RENDER_PHASE);
	      } else {
	        portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
	        		OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY, plid, PortletRequest.RENDER_PHASE);
	      }

	      MutableRenderParameters renderParams =  portletURL.getRenderParameters();
	      renderParams.setValue(OSPIcecapWebConstants.PARAM_MVCPATH, OSPIcecapWebConstants.JSP_PATH_DATATYPE_ADMIN_VIEW);
	      renderParams.setValue(OSPIcecapWebConstants.PARAM_DATATYPE_ID, String.valueOf(_dataType.getPrimaryKey()));

	      String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

	      renderParams.setValue(OSPIcecapWebConstants.PARAM_REDIRECT, currentUrl);

	      return portletURL.toString();

	    } catch (PortalException e) {

	        logger.log(Level.SEVERE, e.getMessage());

	    } catch (SystemException e) {

	        logger.log(Level.SEVERE, e.getMessage());

	    }

	    return noSuchEntryRedirect;
	}
	
	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {

	    return super.getURLView(liferayPortletResponse, windowState);
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException {
		try {
	        return _dataTypeModelResourcePermission.contains(
	            permissionChecker, _dataType, OSPIcecapActionKeys.VIEW);
	    }
	    catch (Exception e) {
	    }

	    return true;
	}
	
	private DataType _dataType;
	private final ModelResourcePermission<DataType> _dataTypeModelResourcePermission;   
	private Logger logger = Logger.getLogger(this.getClass().getName());
}
