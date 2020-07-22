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
import com.osp.icecap.exception.NoSuchDataAnalysisLayoutException;
import com.osp.icecap.exception.NoSuchDataPackException;
import com.osp.icecap.model.DataPack;
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
		Map<Locale, String> titleMap,
		Map<Locale, String> descriptionMap,
		String version,
		long copiedFrom,
		ServiceContext sc) throws PortalException {
		
		long dataPackId = super.counterLocalService.increment();
		DataPack dataPack = super.dataPackPersistence.create(dataPackId);
		
		User user = super.userLocalService.getUser(sc.getUserId());
		Date now = new Date();
		
		dataPack.setCompanyId(sc.getCompanyId());
		dataPack.setGroupId(sc.getScopeGroupId());
		dataPack.setUserId(user.getUserId());
		dataPack.setUserName(user.getFirstName());
		dataPack.setDataCollectionId(dataCollectionId);
		dataPack.setDataSetId(dataSetId);
		dataPack.setDataSectionId(dataSectionId);
		dataPack.setTitleMap(titleMap);
		dataPack.setDescriptionMap(descriptionMap);
		dataPack.setVersion(version);
		dataPack.setCopiedFrom(copiedFrom);
		dataPack.setCreateDate(now);
		dataPack.setModifiedDate(now);
		
		return super.dataPackPersistence.update(dataPack);
	}
	
	public DataPack removeDataPack( long dataPackId ) throws NoSuchDataPackException {
		super.dataEntryPersistence.removeByDataPackId(dataPackId);
		DataPack dataPack =super.dataPackPersistence.remove(dataPackId); 
		try {
			super.dataAnalysisLayoutPersistence.remove(dataPack.getUuid());
		} catch (NoSuchDataAnalysisLayoutException e) {
			System.out.println("Data Analysis Layout does not exist for the data pack: "+dataPack.getDataPackId());
		}
		return dataPack;
	}
	
	public void removeDataPacksByDataCollectionId( long dataCollectionId ) {
		super.dataEntryPersistence.removeByDataCollectionId(dataCollectionId);
		super.dataPackPersistence.removeByDataCollectionId(dataCollectionId);
	}
	
	public void removeDataPacksByDataSetId( long dataSetId ) {
		super.dataPackPersistence.removeByDataSetId(dataSetId);
	}
	
	public void removeDataPacksByDataSectionId( long dataSectionId ) {
		super.dataPackPersistence.removeByDataSectionId(dataSectionId);
	}
	
	public DataPack updateDataPack(
			long dataPackId,
			Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap,
			String version,
			ServiceContext sc) throws NoSuchDataPackException {
		DataPack dataPack = super.dataPackPersistence.findByPrimaryKey(dataPackId);
		
		dataPack.setTitleMap(titleMap);
		dataPack.setDescriptionMap(descriptionMap);
		dataPack.setVersion(version);
		dataPack.setModifiedDate(sc.getModifiedDate());
		
		return super.dataPackPersistence.update(dataPack, sc);
	}
	
}