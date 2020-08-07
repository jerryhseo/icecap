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
import com.osp.icecap.exception.NoSuchMetaDataFieldException;
import com.osp.icecap.model.DataAnalysisLayout;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.model.DataPack;
import com.osp.icecap.model.MetaData;
import com.osp.icecap.service.DataAnalysisLayoutLocalService;
import com.osp.icecap.service.DataEntryLocalService;
import com.osp.icecap.service.MetaDataLocalService;
import com.osp.icecap.service.base.DataPackLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data pack local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataPackLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataPackLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataPack",
	service = AopService.class
)
public class DataPackLocalServiceImpl extends DataPackLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public DataPack addDataPack(
		long dataCollectionId,
		long dataSetId,
		long dataSectionId,
		String name,
		String version,
		long copiedFrom,
		JSONObject metaDataJSON,
		String layout,
		ServiceContext sc) throws PortalException {
		
		long dataPackId = super.counterLocalService.increment();
		DataPack dataPack = super.dataPackPersistence.create(dataPackId);
		
		User user = super.userLocalService.getUser(sc.getUserId());
		Date now = new Date();
		
		dataPack.setCompanyId(sc.getCompanyId());
		dataPack.setGroupId(sc.getScopeGroupId());
		dataPack.setUserId(user.getUserId());
		dataPack.setUserName(user.getFirstName());
		dataPack.setCreateDate(now);
		dataPack.setModifiedDate(now);
		
		dataPack = this.assignDataPackAttributes(
						dataPack, 
						dataCollectionId, 
						dataSetId, 
						dataSectionId, 
						name, 
						version, 
						copiedFrom, 
						metaDataJSON, 
						layout);
		
		super.dataPackPersistence.update(dataPack, sc);
		
		// Add resource to the database to control permissions
		super.resourceLocalService.addResources(
										user.getCompanyId(), 
										user.getGroupId(), 
										user.getUserId(),
									    DataPack.class.getName(), 
									    dataPack.getPrimaryKey(), 
									    false, true, true);

		//Register the data pack as an asset
		AssetEntry assetEntry = super.assetEntryLocalService.updateEntry(
				dataPack.getUserId(), 
				dataPack.getGroupId(), 
				dataPack.getCreateDate(),
				dataPack.getModifiedDate(), 
				DataPack.class.getName(),
				dataPack.getPrimaryKey(), 
				dataPack.getUuid(), 
				0,
			    sc.getAssetCategoryIds(), 
			    sc.getAssetTagNames(), 
			    true, true, null, null, null, null, 
			    ContentTypes.TEXT_HTML,
			    dataPack.getName(), 
			    null, null, null, null, 0, 0, null);
		
		super.assetLinkLocalService.updateLinks(
				user.getPrimaryKey(), 
				assetEntry.getEntryId(),
                sc.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		return dataPack;
	}
	
	public DataPack removeDataPack( long dataPackId ) throws PortalException {
		DataPack dataPack = super.dataPackPersistence.findByPrimaryKey(dataPackId);
		return this.removeDataPack(dataPack);
	}
	
	@Indexable(type = IndexableType.DELETE)
	private DataPack removeDataPack( DataPack dataPack ) throws PortalException {
		this.metaDataLocalService.removeMetaData(dataPack.getUuid());
		this.dataAnalysisLayoutLocalService.removeDataAnalysisLayout(dataPack.getUuid());
		this.dataEntryLocalService.removeDataEntriesByDataPackId(dataPack.getDataPackId());
		super.dataPackPersistence.remove(dataPack);
		
		//Remove resources for conrolling permissions. Other
		super.resourceLocalService.deleteResource(
										dataPack.getCompanyId(),
										DataPack.class.getName(), 
									    ResourceConstants.SCOPE_INDIVIDUAL,
									    dataPack.getPrimaryKey() );
		
		//Unregister the data pack from asset framework
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				DataPack.class.getName(), dataPack.getPrimaryKey());

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		assetEntryLocalService.deleteEntry(assetEntry);
				
		return dataPack;
	}
	
	private void removeDataPackList( List<DataPack> dataPackLIST ) throws PortalException {
		for( DataPack dataPack : dataPackLIST ) {
			this.removeDataPack(dataPack);
		}
	}
	
	public void removeDataPacksByDataCollectionId( long dataCollectionId ) throws PortalException {
		List<DataPack> dataPackLIST = super.dataPackPersistence.findByDataCollectionId(dataCollectionId);
		this.removeDataPackList(dataPackLIST);
	}
	
	public void removeDataPacksByDataSetId( long dataSetId ) throws PortalException {
		List<DataPack> dataPackLIST = super.dataPackPersistence.findByDataSetId(dataSetId);
		this.removeDataPackList(dataPackLIST);
	}

	public void removeDataPacksByDataSectionId( long dataSectionId ) throws PortalException {
		List<DataPack> dataPackLIST = super.dataPackPersistence.findByDataSectionId(dataSectionId);
		this.removeDataPackList(dataPackLIST);
	}

	@Indexable(type = IndexableType.REINDEX)
	public DataPack updateDataPack(
			long dataPackId,
			long dataCollectionId,
			long dataSetId,
			long dataSectionId,
			String name,
			String version,
			long copiedFrom,
			JSONObject metaDataJSON,
			String layout,
			ServiceContext sc) throws PortalException {
		DataPack dataPack = super.dataPackPersistence.findByPrimaryKey(dataPackId);
		
		dataPack = this.assignDataPackAttributes(
				dataPack, 
				dataCollectionId, 
				dataSetId, 
				dataSectionId, 
				name, 
				version, 
				copiedFrom, 
				metaDataJSON, 
				layout);
		dataPack.setModifiedDate(sc.getModifiedDate());
		
		super.dataPackPersistence.update(dataPack, sc);
		
		// Update resource to the database to control permissions
		super.resourceLocalService.updateResources(
												dataPack.getCompanyId(), 
												dataPack.getGroupId(), 
											    DataPack.class.getName(), 
											    dataPack.getPrimaryKey(), 
											    sc.getModelPermissions());
		
		//Update asset information of the data pack
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				dataPack.getUserId(),
				dataPack.getGroupId(), 
				dataPack.getCreateDate(),
				dataPack.getModifiedDate(), 
				DataPack.class.getName(),
				dataPackId, 
				dataPack.getUuid(), 
				0,
                sc.getAssetCategoryIds(),
                sc.getAssetTagNames(), 
                true, true, 
                dataPack.getCreateDate(), 
                null, null, null, 
                ContentTypes.TEXT_HTML, 
                dataPack.getName(), 
                null, null, null, null, 0, 0, 
                sc.getAssetPriority());

		assetLinkLocalService.updateLinks(sc.getUserId(),
                assetEntry.getEntryId(), sc.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
				
		return dataPack;
	}
	
	public List<DataPack> getDataPacksByDataSectionId( long dataSectionId ){
		return super.dataPackPersistence.findByDataSectionId(dataSectionId);
	}
	public List<DataPack> getDataPacksByDataSectionId( long dataSectionId, int start, int end ){
		return super.dataPackPersistence.findByDataSectionId(dataSectionId, start, end);
	}
	public int getDataPacksCountByDataSectionId( long dataSectionId ){
		return super.dataPackPersistence.countByDataSectionId(dataSectionId);
	}
	
	public List<DataEntry> getDataEntriesByDataPackId( long dataPackId ){
		return super.dataEntryPersistence.findByDataPackId(dataPackId);
	}
	public List<DataEntry> getDataEntriesByDataPackId( long dataPackId, int start, int end ){
		return super.dataEntryPersistence.findByDataPackId(dataPackId, start, end);
	}
	public int getDataEntriesCountByDataPackId( long dataPackId ){
		return super.dataEntryPersistence.countByDataPackId(dataPackId);
	}
	
	private DataPack assignDataPackAttributes(
			DataPack dataPack,
			long dataCollectionId,
			long dataSetId,
			long dataSectionId,
			String name, 
			String version,
			long copiedFrom,
			JSONObject metaDataJSON,
			String layout ) throws NoSuchMetaDataFieldException {
		
		dataPack.setDataCollectionId(dataCollectionId);
		dataPack.setDataSetId(dataSetId);
		dataPack.setDataSectionId(dataSectionId);
		dataPack.setName(name);
		dataPack.setVersion(version);
		dataPack.setCopiedFrom(copiedFrom);
		
		if( Validator.isNotNull(metaDataJSON) ) {
			dataPack.setHasMetaData(true);
			MetaData metaData = super.metaDataPersistence.create(dataPack.getUuid());
			metaData.setMetaData(metaDataJSON);
			super.metaDataPersistence.update(metaData);
		}
		else {
			dataPack.setHasMetaData(false);
		}
		
		DataAnalysisLayout dataAnalysisLayout = super.dataAnalysisLayoutPersistence.create(dataPack.getUuid());
		dataAnalysisLayout.setLayout(layout);
		super.dataAnalysisLayoutPersistence.update(dataAnalysisLayout);
		
		return dataPack;
	}
	
	@BeanReference
	private volatile MetaDataLocalService metaDataLocalService;
	
	@BeanReference
	private volatile DataAnalysisLayoutLocalService dataAnalysisLayoutLocalService;
	
	@BeanReference
	private volatile DataEntryLocalService dataEntryLocalService;
}