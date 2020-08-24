package com.osp.icecap.web.datatype.admin.portlet.commands.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.osp.icecap.constants.OSPIcecapPortletKeys;
import com.osp.icecap.model.DataType;
import com.osp.icecap.service.DataTypeLocalService;
import com.osp.icecap.web.constants.OSPIcecapWebConstants;

import java.io.InputStream;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.servlet.http.Part;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + OSPIcecapPortletKeys.DATATYPE_ADMIN_PORTLET_KEY,
	        "mvc.command.name="+OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_EDIT
	    },
	    service = MVCActionCommand.class
	)
public class EditDataTypeMVCActionCommand extends BaseMVCActionCommand {
	@Reference
	DataTypeLocalService _dataTypeLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String command = ParamUtil.getString(actionRequest, OSPIcecapWebConstants.PARAM_COMMAND);
		String showback = ParamUtil.getString(actionRequest, OSPIcecapWebConstants.PARAM_SHOWBACK);
		String dataTypeName = ParamUtil.getString(actionRequest, OSPIcecapWebConstants.PARAM_DATATYPE_NAME);
		String dataTypeVersion = ParamUtil.getString(actionRequest, OSPIcecapWebConstants.PARAM_DATATYPE_VERSION);
		Map<Locale, String> dataTypeDescription = LocalizationUtil.getLocalizationMap(actionRequest, OSPIcecapWebConstants.PARAM_DATATYPE_DESCRIPTION);
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String srcFileName = uploadPortletRequest.getFileName("uploadSampleFile");
		System.out.println("File Name To Be Uploaded: "+ srcFileName );
		
		System.out.println("Command: "+ command);
		System.out.println("Data Type Name: "+dataTypeName);
		System.out.println("Data Type Version: "+dataTypeVersion);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DataType.class.getName(), actionRequest);
		
		Date date = serviceContext.getCreateDate();
		if( Validator.isNull(date) ) {
			System.out.println("No created date!!!");
			date = new Date();
			serviceContext.setCreateDate(date);
			serviceContext.setModifiedDate(date);
		}
		System.out.println("Created Date: "+date.toString());
		
		//_dataTypeLocalService.addDataType(dataTypeName, dataTypeVersion, dataTypeDescription, "", serviceContext);
		
		MutableRenderParameters renderParameters = actionResponse.getRenderParameters();
		renderParameters.setValue("mvcRenderCommandName", OSPIcecapWebConstants.MVC_COMMAND_DATATYPE_ADMIN_EDIT);
		renderParameters.setValue("showback", showback);
	}
}
