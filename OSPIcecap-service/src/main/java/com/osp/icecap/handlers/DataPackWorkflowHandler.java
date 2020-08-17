package com.osp.icecap.handlers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.osp.icecap.model.DataPack;
import com.osp.icecap.service.DataPackLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = WorkflowHandler.class)
public class DataPackWorkflowHandler extends BaseWorkflowHandler<DataPack> {
	
	@Reference
	private DataPackLocalService _dataPackLocalService;

	@Override
	public String getClassName() {
		return DataPack.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public DataPack updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		long userId = GetterUtil.getLong(
		        (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		    long classPK = GetterUtil.getLong(
		        (String)workflowContext.get(
		            WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		    ServiceContext serviceContext = (ServiceContext)workflowContext.get(
		        WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

		    return null /* _dataPackLocalService.updateStatus(
		        userId, classPK, status, serviceContext) */;
	}
}
