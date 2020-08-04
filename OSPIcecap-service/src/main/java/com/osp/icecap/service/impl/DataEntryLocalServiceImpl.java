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
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.osp.icecap.exception.NoSuchDataEntryException;
import com.osp.icecap.exception.NoSuchMetaDataException;
import com.osp.icecap.exception.NoSuchMetaDataFieldException;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.model.MetaData;
import com.osp.icecap.service.DataAnalysisLayoutLocalService;
import com.osp.icecap.service.DataEntryLocalService;
import com.osp.icecap.service.DataPackLocalService;
import com.osp.icecap.service.DataSectionLocalService;
import com.osp.icecap.service.DataTypeLocalService;
import com.osp.icecap.service.MetaDataLocalService;
import com.osp.icecap.service.base.DataEntryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

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
			JSONObject metaDataJSON,
			ServiceContext sc ) throws PortalException {
		long dataEntryId = super.counterLocalService.increment();
		DataEntry dataEntry = super.dataEntryPersistence.create(dataEntryId);
		
		dataEntry.setCompanyId(sc.getCompanyId());
		dataEntry.setGroupId(sc.getScopeGroupId());
		User user = super.userLocalService.getUser(sc.getUserId());
		dataEntry.setUserId(user.getUserId());
		dataEntry.setCreateDate(new Date());
		
		dataEntry = this.assignDataEntryAttributes(
						dataEntry, 
						dataCollectionId, 
						dataSetId, 
						dataSectionId, 
						dataPackId, 
						dataTypeId, 
						accessURL, 
						sequenceId, 
						accessType, 
						copiedFrom, 
						metaDataJSON);
		
		super.dataEntryPersistence.update(dataEntry);
		
		return dataEntry;
	}
	
	public DataEntry removeDataEntry( long dataEntryId ) throws NoSuchDataEntryException, NoSuchMetaDataException {
		DataEntry dataEntry = super.dataEntryPersistence.findByPrimaryKey(dataEntryId);
		
		return this.removeDataEntry( dataEntry );
	}
	
	private DataEntry removeDataEntry( DataEntry dataEntry ) throws NoSuchMetaDataException {
		if( dataEntry.getHasMetaData() ) {
			this.metaDataLocalService.removeMetaData(dataEntry.getUuid());
		}
		
		super.dataEntryPersistence.remove(dataEntry);
		return dataEntry;
	}
	
	private void removeDataEntryList( List<DataEntry> dataEntryLIST ) throws NoSuchMetaDataException {
		for( DataEntry dataEntry : dataEntryLIST) {
			this.removeDataEntry(dataEntry);
		}
	}
	
	public void removeDataEntriesByDataCollectionId( long dataCollectionId ) throws NoSuchMetaDataException {
		List<DataEntry> dataEntryLIST = super.dataEntryPersistence.findByDataCollectionId(dataCollectionId);
		this.removeDataEntryList(dataEntryLIST);
	}
	
	public void removeDataEntriesByDataSetId( long dataSetId ) throws NoSuchMetaDataException {
		List<DataEntry> dataEntryLIST = super.dataEntryPersistence.findByDataSetId(dataSetId);
		this.removeDataEntryList(dataEntryLIST);
	}
	
	public void removeDataEntriesByDataSectionId( long dataSectionId ) throws NoSuchMetaDataException {
		List<DataEntry> dataEntryLIST = super.dataEntryPersistence.findByDataSetId(dataSectionId);
		this.removeDataEntryList(dataEntryLIST);
	}
	
	public void removeDataEntriesByDataPackId( long dataPackId ) throws NoSuchMetaDataException {
		List<DataEntry> dataEntryLIST = super.dataEntryPersistence.findByDataPackId(dataPackId);
		this.removeDataEntryList(dataEntryLIST);
	}
	
	public DataEntry updateDataEntry(
			long dataEntryId,
			long dataCollectionId, 
			long dataSetId, 
			long dataSectionId, 
			long dataPackId, 
			long dataTypeId,
			String accessURL,
			String sequenceId,
			String accessType,
			long copiedFrom,
			JSONObject metaDataJSON,
			ServiceContext sc ) throws NoSuchMetaDataFieldException {
		DataEntry dataEntry = super.dataEntryPersistence.fetchByPrimaryKey(dataEntryId);

		dataEntry = this.assignDataEntryAttributes(
						dataEntry, 
						dataCollectionId, 
						dataSetId, 
						dataSectionId, 
						dataPackId, 
						dataTypeId, 
						accessURL, 
						sequenceId, 
						accessType, 
						copiedFrom, 
						metaDataJSON);
		
		dataEntry.setModifiedDate(sc.getModifiedDate());
		
		return super.dataEntryPersistence.update(dataEntry);
	}

	private DataEntry assignDataEntryAttributes(
			DataEntry dataEntry,
			long dataCollectionId, 
			long dataSetId, 
			long dataSectionId, 
			long dataPackId, 
			long dataTypeId,
			String accessURL,
			String sequenceId,
			String accessType,
			long copiedFrom,
			JSONObject metaDataJSON) throws NoSuchMetaDataFieldException{
		dataEntry.setDataCollectionId(dataCollectionId);
		dataEntry.setDataSetId(dataSetId);
		dataEntry.setDataSectionId(dataSectionId);
		dataEntry.setDataPackId(dataPackId);
		dataEntry.setDataTypeId(dataTypeId);
		
		dataEntry.setAccessURL(accessURL);
		dataEntry.setSequenceId(sequenceId);
		dataEntry.setAccessURL(accessType);
		dataEntry.setCopiedFrom(copiedFrom);

		if( Validator.isNotNull(metaDataJSON) ) {
			dataEntry.setHasMetaData(true);
			MetaData metaData = super.metaDataPersistence.create(dataEntry.getUuid());
			metaData.setMetaData(metaDataJSON);
			super.metaDataPersistence.update(metaData);
		}
		else {
			dataEntry.setHasMetaData(false);;
		}
		
		return dataEntry;
	}
	
	@BeanReference
	private volatile DataTypeLocalService dataTypeLocalService;
	
	@BeanReference
	private volatile MetaDataLocalService metaDataLocalService;
	
	@BeanReference
	private volatile DataAnalysisLayoutLocalService dataAnalysisLayoutLocalService;
	
	@BeanReference
	private volatile DataSectionLocalService dataSectionLocalService;
	
	@BeanReference
	private volatile DataPackLocalService dataPackLocalService;
	
	@BeanReference
	private volatile DataEntryLocalService dataEntryLocalService;
}