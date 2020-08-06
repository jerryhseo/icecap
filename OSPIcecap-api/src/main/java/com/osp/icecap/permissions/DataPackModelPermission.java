package com.osp.icecap.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.osp.icecap.model.DataPack;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DataPackModelPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, DataPack dataPack, String actionId) throws PortalException {

        return _dataPackModelResourcePermission.contains(permissionChecker, dataPack, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long dataPackId, String actionId) throws PortalException {

        return _dataPackModelResourcePermission.contains(permissionChecker, dataPackId, actionId);
    }

    @Reference(
            target = "(model.class.name=com.osp.icecap.model.DataPack)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<DataPack> modelResourcePermission) {

    	_dataPackModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<DataPack>_dataPackModelResourcePermission;
}
