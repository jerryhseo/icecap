package com.osp.icecap.web.datatype.renderer;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.osp.icecap.constants.OSPIcecapActionKeys;
import com.osp.icecap.constants.OSPIcecapPortletKeys;
import com.osp.icecap.model.DataType;

import java.util.Locale;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderURL;
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
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
		      httpServletRequest.setAttribute("dataType", _dataType);

		      return "/asset/DataType/" + template + ".jsp";
		    } else {
		      return null;
		    }
	}
	
	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse 
	  response, String template) throws Exception {
	    request.setAttribute("dataType", _dataType);
	    request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
	    request.setAttribute("StringUtil", new StringUtil());
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
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		LiferayPortletURL renderURL = liferayPortletResponse.createRenderURL(OSPIcecapPortletKeys.DATA_TYPE_ADMIN_PORTLET_KEY);
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			    getControlPanelPlid(liferayPortletRequest), OSPIcecapPortletKeys.DATA_TYPE_ADMIN_PORTLET_KEY,
			    PortletRequest.RENDER_PHASE);
		
			renderURL.set
			portletURL.setParameter("mvcPath", "/DataType/admin/edit_datatype.jsp");
			portletURL.setParameter("guestbookId", String.valueOf(_guestbook.getGuestbookId()));
			portletURL.setParameter("showback", Boolean.FALSE.toString());

			return portletURL;
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
