package com.osp.icecap.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.osp.icecap.model.DataEntry;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DataEntryModelPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, DataEntry dataEntry, String actionId) throws PortalException {

        return _dataEntryModelResourcePermission.contains(permissionChecker, dataEntry, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long dataEntryId, String actionId) throws PortalException {

        return _dataEntryModelResourcePermission.contains(permissionChecker, dataEntryId, actionId);
    }

    @Reference(
            target = "(model.class.name=com.osp.icecap.model.DataEntry)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<DataEntry> modelResourcePermission) {

    	_dataEntryModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<DataEntry>_dataEntryModelResourcePermission;
}
