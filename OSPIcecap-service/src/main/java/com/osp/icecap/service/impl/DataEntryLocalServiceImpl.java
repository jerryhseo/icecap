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
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.service.base.DataEntryLocalServiceBaseImpl;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataEntry",
	service = AopService.class
)
public class DataEntryLocalServiceImpl extends DataEntryLocalServiceBaseImpl {

	public DataEntry addDataEntry( 
			long dataCollectionId, 
			long dataSetId, 
			long dataSectionId, 
			long dataPackId, 
			long dataTypeId,
			String accessURL,
			String sequenceId,
			String accessType,
			long copiedFrom,
			JSONObject metaData,
			ServiceContext sc ) throws PortalException {
		long dataEntryId = super.counterLocalService.increment();
		DataEntry dataEntry = super.dataEntryPersistence.create(dataEntryId);
		
		dataEntry.setDataCollectionId(dataCollectionId);
		dataEntry.setDataSetId(dataSetId);
		dataEntry.setDataSectionId(dataSectionId);
		dataEntry.setDataPackId(dataPackId);
		
		dataEntry.setAccessURL(accessURL);
		dataEntry.setSequenceId(sequenceId);
		dataEntry.setAccessURL(accessType);
		dataEntry.setCopiedFrom(copiedFrom);
		
		if( Validator.isNotNull(descriptionMap) ) {
			dataEntry.setHasDescription(true);
			
			super.dataEntryDescriptionPersistence.addDataEntryDescriptionMap( descriptionMap );
		}
		else {
			dataEntry.setHasDescription(false);
		}
		
		dataEntry.setCompanyId(sc.getCompanyId());
		dataEntry.setGroupId(sc.getScopeGroupId());
		User user = super.userLocalService.getUser(sc.getUserId());
		dataEntry.setUserId(user.getUserId());
		dataEntry.setCreateDate(new Date());
		
		super.dataEntryPersistence.update(dataEntry);
		
		return dataEntry;
	}
	
	public DataEntry removeDataEntry( long dataEntryId ) {
		DataEntry dataEntry = super.dataEntryPersistence.fetchByPrimaryKey(dataEntryId);
		
		return super.dataEntryPersistence.remove( dataEntry );
	}
	
	public DataEntry updateDataEntry(
			long dataEntryId,
			long dataCollectionId, 
			long dataSetId, 
			long dataSectionId, 
			long dataPackId, 
			ServiceContext sc ) {
		DataEntry dataEntry = super.dataEntryPersistence.fetchByPrimaryKey(dataEntryId);
		
		dataEntry.setDataCollectionId(dataCollectionId);
		dataEntry.setDataSetId(dataSetId);
		dataEntry.setDataSectionId(dataSectionId);
		dataEntry.setDataPackId(dataPackId);
		
		dataEntry.setModifiedDate(sc.getModifiedDate());
		
		return super.dataEntryPersistence.update(dataEntry);
	}
}