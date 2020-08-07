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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.osp.icecap.constants.MetaDataKeys;
import com.osp.icecap.exception.NoSuchMetaDataFieldException;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.model.DataPack;
import com.osp.icecap.model.MetaData;
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

	@Indexable(type = IndexableType.REINDEX)
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
		
		super.dataEntryPersistence.update(dataEntry, sc);
		
		// Add resource to the database to control permissions
		super.resourceLocalService.addResources(
												user.getCompanyId(), 
												user.getGroupId(), 
												user.getUserId(),
											    DataEntry.class.getName(), 
											    dataEntry.getPrimaryKey(), 
											    false, true, true);
		
		//Register the data entry as an asset
		String dataEntryTitle = "";
		if( Validator.isNotNull(metaDataJSON) ) {
			dataEntryTitle =  metaDataJSON.getString(MetaDataKeys.TITLE);
		}
		
		AssetEntry assetEntry = super.assetEntryLocalService.updateEntry(
				dataEntry.getUserId(), 
				dataEntry.getGroupId(), 
				dataEntry.getCreateDate(),
				dataEntry.getModifiedDate(), 
				DataEntry.class.getName(),
				dataEntry.getPrimaryKey(), 
				dataEntry.getUuid(), 
				0,
			    sc.getAssetCategoryIds(), 
			    sc.getAssetTagNames(), 
			    true, true, null, null, null, null, 
			    ContentTypes.TEXT_HTML,
			    dataEntryTitle, 
			    null, null, null, null, 0, 0, null);
		
		super.assetLinkLocalService.updateLinks(
				user.getPrimaryKey(), 
				assetEntry.getEntryId(),
                sc.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		return dataEntry;
	}
	
	public DataEntry removeDataEntry( long dataEntryId ) throws PortalException {
		DataEntry dataEntry = super.dataEntryPersistence.findByPrimaryKey(dataEntryId);
		
		return this.removeDataEntry( dataEntry );
	}
	
	@Indexable(type = IndexableType.DELETE)
	private DataEntry removeDataEntry( DataEntry dataEntry ) throws PortalException {
		if( dataEntry.getHasMetaData() ) {
			this.metaDataLocalService.removeMetaData(dataEntry.getUuid());
		}
		
		super.dataEntryPersistence.remove(dataEntry);
		
		//Remove resources for conrolling permissions. Other
		super.resourceLocalService.deleteResource(
												dataEntry.getCompanyId(),
												DataPack.class.getName(), 
											    ResourceConstants.SCOPE_INDIVIDUAL,
											    dataEntry.getPrimaryKey() );
		
		//Unregister the data entry from asset framework
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				DataEntry.class.getName(), dataEntry.getPrimaryKey());

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		assetEntryLocalService.deleteEntry(assetEntry);
		
		return dataEntry;
	}
	
	private void removeDataEntryList( List<DataEntry> dataEntryLIST ) throws PortalException {
		for( DataEntry dataEntry : dataEntryLIST) {
			this.removeDataEntry(dataEntry);
		}
	}
	
	public void removeDataEntriesByDataCollectionId( long dataCollectionId ) throws PortalException {
		List<DataEntry> dataEntryLIST = super.dataEntryPersistence.findByDataCollectionId(dataCollectionId);
		this.removeDataEntryList(dataEntryLIST);
	}
	
	public void removeDataEntriesByDataSetId( long dataSetId ) throws PortalException {
		List<DataEntry> dataEntryLIST = super.dataEntryPersistence.findByDataSetId(dataSetId);
		this.removeDataEntryList(dataEntryLIST);
	}
	
	public void removeDataEntriesByDataSectionId( long dataSectionId ) throws PortalException {
		List<DataEntry> dataEntryLIST = super.dataEntryPersistence.findByDataSetId(dataSectionId);
		this.removeDataEntryList(dataEntryLIST);
	}
	
	public void removeDataEntriesByDataPackId( long dataPackId ) throws PortalException {
		List<DataEntry> dataEntryLIST = super.dataEntryPersistence.findByDataPackId(dataPackId);
		this.removeDataEntryList(dataEntryLIST);
	}
	
	@Indexable(type = IndexableType.REINDEX)
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
			ServiceContext sc ) throws PortalException {
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
		
		super.dataEntryPersistence.update(dataEntry, sc);
		
		// Update resource to the database to control permissions
		super.resourceLocalService.updateResources(
														dataEntry.getCompanyId(), 
														dataEntry.getGroupId(), 
													    DataEntry.class.getName(), 
													    dataEntry.getPrimaryKey(), 
													    sc.getModelPermissions());
		
		//Update asset information of the data entry
		String dataEntryTitle = "";
		if( Validator.isNotNull(metaDataJSON) ) {
			dataEntryTitle =  metaDataJSON.getString(MetaDataKeys.TITLE);
		}
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				dataEntry.getUserId(),
				dataEntry.getGroupId(), 
				dataEntry.getCreateDate(),
				dataEntry.getModifiedDate(), 
				DataEntry.class.getName(),
				dataEntryId, 
				dataEntry.getUuid(), 
				0,
                sc.getAssetCategoryIds(),
                sc.getAssetTagNames(), 
                true, true, 
                dataEntry.getCreateDate(), 
                null, null, null, 
                ContentTypes.TEXT_HTML, 
               dataEntryTitle, 
                null, null, null, null, 0, 0, 
                sc.getAssetPriority());

		assetLinkLocalService.updateLinks(sc.getUserId(),
                assetEntry.getEntryId(), sc.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
				
		return dataEntry;
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
	private volatile MetaDataLocalService metaDataLocalService;
}