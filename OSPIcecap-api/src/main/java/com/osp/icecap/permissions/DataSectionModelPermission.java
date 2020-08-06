package com.osp.icecap.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.osp.icecap.model.DataSection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DataSectionModelPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, DataSection dataSection, String actionId) throws PortalException {

        return _dataSectionModelResourcePermission.contains(permissionChecker, dataSection, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long dataSectionId, String actionId) throws PortalException {

        return _dataSectionModelResourcePermission.contains(permissionChecker, dataSectionId, actionId);
    }

    @Reference(
            target = "(model.class.name=com.osp.icecap.model.DataSection)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<DataSection> modelResourcePermission) {

    	_dataSectionModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<DataSection>_dataSectionModelResourcePermission;
}
