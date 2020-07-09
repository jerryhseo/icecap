/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.osp.icecap.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.osp.icecap.exception.NoSuchDataTypeException;
import com.osp.icecap.exception.NoSuchDataTypeStructureException;
import com.osp.icecap.model.DataType;
import com.osp.icecap.service.base.DataTypeLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataType",
	service = AopService.class
)
public class DataTypeLocalServiceImpl extends DataTypeLocalServiceBaseImpl {

	public DataType createDataType( String dataTypeName, String dataTypeVersion, ServiceContext sc) throws PortalException {
		long dataTypeId = super.counterLocalService.increment();
		DataType dataType = super.dataTypePersistence.create(dataTypeId);
		
		dataType.setUuid(sc.getUuid());
		dataType.setName(dataTypeName);
		dataType.setVersion(dataTypeVersion);
		
		User user = super.userLocalService.getUser(sc.getUserId());
		
		dataType.setCompanyId(sc.getCompanyId());
		dataType.setGroupId(sc.getScopeGroupId());
		dataType.setUserId(sc.getUserId());
		dataType.setUserName(user.getFullName());
		
		return dataType;
	}
	
	public DataType addDataType( DataType dataType ) {
		super.addDataType(dataType);
		
		return dataType;
	}
	
	public DataType removeDataType( DataType dataType ) {
		DataType deletedDataType = super.deleteDataType(dataType);
		
		try {
			super.dataTypePersistence.remove(dataType.getDataTypeId());
			
		} catch (NoSuchDataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deletedDataType;
	}
	
	public DataType removeDataType( long dataTypeId ) throws PortalException {
		DataType dataType = super.fetchDataType(dataTypeId);
		
		removeDataType( dataType );
		
		return dataType;
	}
	
	public DataType removeDataType( String dataTypeName, String dataTypeVersion ) {
		DataType dataType = super.dataTypePersistence.fetchByNameVersion(dataTypeName, dataTypeVersion);
		removeDataType( dataType );
		
		return dataType;
	}
	
	public int removeDataType( String dataTypeName ) {
		List<DataType> dataTypes = super.dataTypePersistence.findByName(dataTypeName);
		
		for( DataType dataType : dataTypes ) {
			removeDataType(dataType);
		}
		
		return dataTypes.size();
	}
	
	public DataType updateDataType( DataType dataType) {
		DataType updatedDataType = super.updateDataType(dataType);
		
		return updatedDataType;
	}
}