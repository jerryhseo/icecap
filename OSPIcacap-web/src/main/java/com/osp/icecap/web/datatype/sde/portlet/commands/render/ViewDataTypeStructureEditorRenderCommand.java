package com.osp.icecap.web.datatype.sde.portlet.commands.render;

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
	       "javax.portlet.name=" + OSPIcecapPortletKeys.DATATYPE_STRUCTURE_EDITOR_PORTLET_KEY,
	       "mvc.command.name="+ OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_STRUCTURE_EDITOR
	    },
	    service = MVCRenderCommand.class
)
public class ViewDataTypeStructureEditorRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		int startIndex = ParamUtil.getInteger(renderRequest, OSPIcecapWebConstants.PARAM_START_INDEX, OSPIcecapWebConstants.DEFAULT_START_INDEX);
		int itemsPerPage = ParamUtil.getInteger(renderRequest, OSPIcecapWebConstants.PARAM_ITEMS_PER_PAGE, OSPIcecapWebConstants.DEFAULT_ITEMS_PER_PAGE);
		
		List<DataType> dataTypeList = _dataTypeLocalService.getDataTypes(startIndex, itemsPerPage);
		
		renderRequest.setAttribute(OSPIcecapWebConstants.PARAM_START_INDEX, startIndex);
		renderRequest.setAttribute(OSPIcecapWebConstants.PARAM_ITEMS_PER_PAGE, itemsPerPage);
		renderRequest.setAttribute(OSPIcecapWebConstants.PARAM_DATATYPE_LIST, dataTypeList);
		
		return OSPIcecapWebConstants.JSP_PATH_DATATYPE_STRUCTURE_EDITOR;
	}

	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
