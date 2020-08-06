package com.osp.icecap.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.osp.icecap.model.DataType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DataTypeModelPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, DataType dataType, String actionId) throws PortalException {

        return _dataTypeModelResourcePermission.contains(permissionChecker, dataType, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long dataTypeId, String actionId) throws PortalException {

        return _dataTypeModelResourcePermission.contains(permissionChecker, dataTypeId, actionId);
    }

    @Reference(
            target = "(model.class.name=com.osp.icecap.model.DataType)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<DataType> modelResourcePermission) {

    	_dataTypeModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<DataType>_dataTypeModelResourcePermission;
}
