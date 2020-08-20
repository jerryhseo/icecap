package com.osp.icecap.web.datatype.admin.portlet.commands.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.osp.icecap.constants.OSPIcecapPortletKeys;
import com.osp.icecap.model.DataType;
import com.osp.icecap.service.DataTypeLocalService;
import com.osp.icecap.web.constants.OSPIcecapWebConstants;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY,
	       "mvc.command.name="+ OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_EDIT
	    },
	    service = MVCRenderCommand.class
)
public class EditDataTypeRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		int dataTypeId = ParamUtil.getInteger(renderRequest, OSPIcecapWebConstants.PARAM_DATATYPE_ID, OSPIcecapWebConstants.ZERO);
		String showback = ParamUtil.getString(renderRequest, OSPIcecapWebConstants.PARAM_SHOWBACK);

		DataType dataType = null;
		
		try{
			dataType = _dataTypeLocalService.getDataType(dataTypeId);
		} catch( PortalException e ){
			dataType = null;
		}
		
		renderRequest.setAttribute(OSPIcecapWebConstants.PARAM_DATATYPE, dataType);
		renderRequest.setAttribute(OSPIcecapWebConstants.PARAM_SHOWBACK, showback);
		
		return OSPIcecapWebConstants.JSP_PATH_EDIT_DATATYPE;
	}

	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
