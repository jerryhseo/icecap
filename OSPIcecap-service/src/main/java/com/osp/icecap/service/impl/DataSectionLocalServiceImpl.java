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
import com.osp.icecap.exception.NoSuchDataSectionException;
import com.osp.icecap.exception.NoSuchDataTypeLinkException;
import com.osp.icecap.model.DataSection;
import com.osp.icecap.service.base.DataSectionLocalServiceBaseImpl;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data section local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataSectionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataSectionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataSection",
	service = AopService.class
)
public class DataSectionLocalServiceImpl
	extends DataSectionLocalServiceBaseImpl {
	
	public DataSection addDataSection(
			long dataCollectionId, 
			long dataSetId, 
			Map<Locale, String> titleMap, 
			Map<Locale, String> descriptionMap, 
			String version, 
			long copiedFrom, 
			ServiceContext sc) throws PortalException {
		long dataSectionId = super.counterLocalService.increment();
		DataSection dataSection = super.dataSectionPersistence.create(dataSectionId);

		dataSection.setCompanyId(sc.getCompanyId());
		dataSection.setGroupId(sc.getScopeGroupId());
		
		User user = super.userLocalService.getUser(sc.getUserId());
		dataSection.setUserId(user.getUserId());
		dataSection.setUserName(user.getFullName());
		
		Date now = new Date();
		dataSection.setCreateDate(now);
		dataSection.setModifiedDate(now);
		
		dataSection.setDataCollectionId(dataCollectionId);
		dataSection.setDataSetId(dataSetId);
		dataSection.setTitleMap(titleMap);
		dataSection.setDescriptionMap(descriptionMap);
		dataSection.setVersion(version);
		
		return super.dataSectionPersistence.update(dataSection);
	}
	
	public DataSection removeDataSection( long dataSectionId ) throws NoSuchDataSectionException {
		super.dataPackPersistence.removeByDataSectionId(dataSectionId);
		super.dataEntryPersistence.removeByDataSectionId(dataSectionId);
		
		DataSection dataSection = super.dataSectionPersistence.findByPrimaryKey(dataSectionId);
		try {
			super.dataTypeLinkPersistence.remove(dataSection.getUuid());
		} catch (NoSuchDataTypeLinkException e) {
			System.out.println("Data Type Link does not exist for section: "+dataSection.getDataSectionId());
		}
		
		try {
			super.dataAnalysisLayoutPersistence.remove(dataSection.getUuid());
		} catch (NoSuchDataAnalysisLayoutException e) {
			System.out.println("Data Analysis Layout does not exist for section: "+dataSection.getDataSectionId());
		}
		
		return super.dataSectionPersistence.remove(dataSectionId);
	}
	
	public DataSection updateDataSection(
			long dataSectionId,
			long dataCollectionId, 
			long dataSetId, 
			Map<Locale, String> titleMap, 
			Map<Locale, String> descriptionMap, 
			String version, 
			long copiedFrom, 
			ServiceContext sc) throws NoSuchDataSectionException {
		
		DataSection dataSection = super.dataSectionPersistence.findByPrimaryKey(dataSectionId);
		dataSection.setModifiedDate(sc.getModifiedDate());
		
		dataSection.setDataCollectionId(dataCollectionId);
		dataSection.setDataSetId(dataSetId);
		dataSection.setTitleMap(titleMap);
		dataSection.setDescriptionMap(descriptionMap);
		dataSection.setVersion(version);

		return super.dataSectionPersistence.update(dataSection, sc);
	}
}