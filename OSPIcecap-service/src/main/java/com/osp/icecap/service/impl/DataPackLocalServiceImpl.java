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

import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.osp.icecap.exception.NoSuchDataAnalysisLayoutException;
import com.osp.icecap.exception.NoSuchDataPackException;
import com.osp.icecap.exception.NoSuchMetaDataFieldException;
import com.osp.icecap.model.DataAnalysisLayout;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.model.DataPack;
import com.osp.icecap.model.DataSection;
import com.osp.icecap.model.MetaData;
import com.osp.icecap.service.base.DataPackLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
		
		return super.dataPackPersistence.update(dataPack, sc);
	}
	
	public DataPack removeDataPack( long dataPackId ) throws NoSuchDataPackException {
		super.dataEntryPersistence.removeByDataPackId(dataPackId);
		super.metaDataPersistence.removeByDataPackId(dataPackId);
		super.dataAnalysisLayoutPersistence.removeByDataPackId(dataPackId);
		
		return super.dataPackPersistence.remove(dataPackId);
	}
	
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
			ServiceContext sc) throws NoSuchDataPackException, NoSuchMetaDataFieldException {
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
		
		return super.dataPackPersistence.update(dataPack, sc);
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
		
		if(Validator.isBlank(layout) ) {
			dataPack.setHasLayout(false);
		}
		else {
			DataAnalysisLayout dataAnalysisLayout = super.dataAnalysisLayoutPersistence.create(dataPack.getUuid());
			dataAnalysisLayout.setLayout(layout);
			super.dataAnalysisLayoutPersistence.update(dataAnalysisLayout);
		}
		
		return dataPack;
	}
}