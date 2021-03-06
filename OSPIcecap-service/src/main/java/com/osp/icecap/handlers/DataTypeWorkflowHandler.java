package com.osp.icecap.handlers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.osp.icecap.model.DataType;
import com.osp.icecap.service.DataTypeLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = WorkflowHandler.class)
public class DataTypeWorkflowHandler extends BaseWorkflowHandler<DataType> {
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

	@Override
	public String getClassName() {
		return DataType.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public DataType updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		long userId = GetterUtil.getLong(
		        (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		    long classPK = GetterUtil.getLong(
		        (String)workflowContext.get(
		            WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		    ServiceContext serviceContext = (ServiceContext)workflowContext.get(
		        WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

		    return null /* _dataTypeLocalService.updateStatus(
		        userId, classPK, status, serviceContext) */;
	}
}
