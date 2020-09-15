package com.osp.icecap.web.datatype.sde.portlet.commands.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.osp.icecap.constants.OSPIcecapPortletKeys;
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
	       "javax.portlet.name=" + OSPIcecapPortletKeys.DATATYPE_STRUCTURE_EDITOR_PORTLET_KEY,
	       "mvc.command.name="+ OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_STRUCTURE_EDITOR
	    },
	    service = MVCRenderCommand.class
)
public class ViewDataTypeStructureEditorRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long dataTypeId = ParamUtil.getLong(renderRequest, OSPIcecapWebConstants.PARAM_DATATYPE_ID, OSPIcecapWebConstants.ZERO);
		String showback = ParamUtil.getString(renderRequest, OSPIcecapWebConstants.PARAM_SHOWBACK, StringPool.BLANK);
		String dataTypeStructure = "";
		String editorMode = "edit";
		
		dataTypeStructure = _dataTypeLocalService.getDataTypeStructureSTR(dataTypeId);
		
		if( Validator.isBlank(dataTypeStructure) && dataTypeId == 0) {
			System.out.println("Data Type Structure Editor Mode: CREATE");
			editorMode = "cteate";
		}
		

		System.out.println("This is the SDE!!");
		
		return OSPIcecapWebConstants.JSP_PATH_DATATYPE_STRUCTURE_EDITOR;
	}

	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
}
