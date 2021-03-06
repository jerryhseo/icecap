package com.osp.icecap.web.datatype.admin.portlet.commands.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.osp.icecap.constants.OSPIcecapPortletKeys;
import com.osp.icecap.model.DataType;
import com.osp.icecap.service.DataTypeLocalService;
import com.osp.icecap.web.constants.OSPIcecapWebConstants;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY,
	       "mvc.command.name="+ OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_VIEW_LIST
	    },
	    service = MVCRenderCommand.class
)
public class ViewDataTypeListRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		int startIndex = ParamUtil.getInteger(renderRequest, OSPIcecapWebConstants.PARAM_START_INDEX, OSPIcecapWebConstants.DEFAULT_START_INDEX);
		int itemsPerPage = ParamUtil.getInteger(renderRequest, OSPIcecapWebConstants.PARAM_ITEMS_PER_PAGE, OSPIcecapWebConstants.DEFAULT_ITEMS_PER_PAGE);
		
		System.out.println("Start: "+startIndex);
		System.out.println("Items Per Page: "+itemsPerPage);
		List<DataType> dataTypeList = _dataTypeLocalService.getDataTypes(startIndex, itemsPerPage);
		System.out.println("Datatype Count: "+dataTypeList.size());
		
		renderRequest.setAttribute(OSPIcecapWebConstants.PARAM_START_INDEX, startIndex);
		renderRequest.setAttribute(OSPIcecapWebConstants.PARAM_ITEMS_PER_PAGE, itemsPerPage);
		renderRequest.setAttribute(OSPIcecapWebConstants.PARAM_DATATYPE_LIST, dataTypeList);
		
		return OSPIcecapWebConstants.JSP_PATH_DATATYPE_ADMIN_VIEW;
	}

	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
