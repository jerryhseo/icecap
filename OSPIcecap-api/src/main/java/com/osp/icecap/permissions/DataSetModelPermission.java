package com.osp.icecap.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.osp.icecap.model.DataSet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DataSetModelPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, DataSet dataSet, String actionId) throws PortalException {

        return _dataSetModelResourcePermission.contains(permissionChecker, dataSet, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long dataSetId, String actionId) throws PortalException {

        return _dataSetModelResourcePermission.contains(permissionChecker, dataSetId, actionId);
    }

    @Reference(
            target = "(model.class.name=com.osp.icecap.model.DataSet)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<DataSet> modelResourcePermission) {

    	_dataSetModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<DataSet>_dataSetModelResourcePermission;
}
