package com.osp.icecap.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.osp.icecap.model.DataCollection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DataCollectionModelPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, DataCollection dataCollection, String actionId) throws PortalException {

        return _dataCollectionModelResourcePermission.contains(permissionChecker, dataCollection, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long dataCollectionId, String actionId) throws PortalException {

        return _dataCollectionModelResourcePermission.contains(permissionChecker, dataCollectionId, actionId);
    }

    @Reference(
            target = "(model.class.name=com.osp.icecap.model.DataCollection)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<DataCollection> modelResourcePermission) {

    	_dataCollectionModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<DataCollection>_dataCollectionModelResourcePermission;
}
