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
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.osp.icecap.exception.NoSuchDataAnalysisLayoutException;
import com.osp.icecap.exception.NoSuchDataSectionException;
import com.osp.icecap.exception.NoSuchMetaDataException;
import com.osp.icecap.exception.NoSuchMetaDataFieldException;
import com.osp.icecap.model.DataAnalysisLayout;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.model.DataPack;
import com.osp.icecap.model.DataSection;
import com.osp.icecap.model.DataSet;
import com.osp.icecap.model.MetaData;
import com.osp.icecap.service.DataAnalysisLayoutLocalService;
import com.osp.icecap.service.DataEntryLocalService;
import com.osp.icecap.service.DataPackLocalService;
import com.osp.icecap.service.DataSectionLocalService;
import com.osp.icecap.service.DataTypeLocalService;
import com.osp.icecap.service.MetaDataLocalService;
import com.osp.icecap.service.base.DataSectionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

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
			String name,
			String version, 
			long copiedFrom,
			JSONObject metaDataJSON,
			String layout,
			ServiceContext sc) throws PortalException {
		long dataSectionId = super.counterLocalService.increment();
		DataSection dataSection = super.dataSectionPersistence.create(dataSectionId);

		dataSection.setCompanyId(sc.getCompanyId());
		dataSection.setGroupId(sc.getScopeGroupId());
		
		User user = super.userLocalService.getUser(sc.getUserId());
		Date now = new Date();

		dataSection.setUserId(user.getUserId());
		dataSection.setUserName(user.getFullName());
		dataSection.setCreateDate(now);
		dataSection.setModifiedDate(now);
		
		dataSection = this.assignDataSectionAttributes(
				dataSection, 
				dataCollectionId, 
				dataSetId, 
				name, 
				version, 
				copiedFrom, 
				metaDataJSON, 
				layout);
		
		super.dataSectionPersistence.update(dataSection, sc);
		
		// Add resource to the database to control permissions
		super.resourceLocalService.addResources(
								user.getCompanyId(), 
								user.getGroupId(), 
								user.getUserId(),
							    DataSection.class.getName(), 
							    dataSection.getDataSectionId(), 
							    false, true, true);
		
		return dataSection;
	}
	
	public DataSection removeDataSection( long dataSectionId ) throws PortalException {
		DataSection dataSection = super.dataSectionPersistence.findByPrimaryKey(dataSectionId);
		
		return this.removeDataSection(dataSection);
	}
	
	private DataSection removeDataSection( DataSection dataSection ) throws PortalException {
		this.metaDataLocalService.removeMetaData(dataSection.getUuid());
		this.dataAnalysisLayoutLocalService.removeDataAnalysisLayout(dataSection.getUuid());
		this.dataPackLocalService.removeDataPacksByDataSectionId(dataSection.getDataSectionId());
		
		super.dataSectionPersistence.remove(dataSection);
		
		//Remove resources for conrolling permissions. Other
		super.resourceLocalService.deleteResource(
								dataSection.getCompanyId(),
								DataSection.class.getName(), 
							    ResourceConstants.SCOPE_INDIVIDUAL,
							    dataSection.getDataSectionId());
		
		return dataSection;
	}
	
	private void removeDataSectionList( List<DataSection> dataSectionLIST ) throws PortalException {
		for( DataSection dataSection : dataSectionLIST ) {
			this.removeDataSection(dataSection);
		}
	}
	
	public void removeDataSectionsByDataCollectionId( long dataCollectionId ) throws PortalException {
		List<DataSection> dataSectionLIST = super.dataSectionPersistence.findByDataCollectionId(dataCollectionId);
		this.removeDataSectionList(dataSectionLIST);
	}
	
	public void removeDataSectionsByDataSetId( long dataSetId ) throws PortalException {
		List<DataSection> dataSectionLIST = super.dataSectionPersistence.findByDataSetId(dataSetId);
		this.removeDataSectionList(dataSectionLIST);
	}
	
	public DataSection updateDataSection(
			long dataSectionId,
			long dataCollectionId, 
			long dataSetId, 
			String name,
			String version, 
			long copiedFrom,
			JSONObject metaDataJSON,
			String layout,
			ServiceContext sc) throws NoSuchDataSectionException, NoSuchMetaDataFieldException {
		
		DataSection dataSection = super.dataSectionPersistence.findByPrimaryKey(dataSectionId);
		dataSection.setModifiedDate(sc.getModifiedDate());
		
		dataSection = this.assignDataSectionAttributes(
				dataSection, 
				dataCollectionId, 
				dataSetId, 
				name, 
				version, 
				copiedFrom, 
				metaDataJSON, 
				layout);

		super.dataSectionPersistence.update(dataSection, sc);
		
		// Update resource to the database to control permissions
		super.resourceLocalService.updateResources(
										dataSection.getCompanyId(), 
										dataSection.getGroupId(), 
									    DataSection.class.getName(), 
									    dataSet.getDataSetId(), 
									    sc.getModelPermissions());
		
		return dataSection;
	}
	
	public List<DataSection> getDataSectionVarients( long dataSectionId ){
		return super.dataSectionPersistence.findByCopiedFrom(dataSectionId);
	}
	public List<DataSection> getDataSectionVarients( long dataSectionId, int start, int end ){
		return super.dataSectionPersistence.findByCopiedFrom(dataSectionId, start, end);
	}
	public int getDataSectionVariantsCount( long dataSectionId ) {
		return super.dataSectionPersistence.countByCopiedFrom(dataSectionId);
	}
	
	public List<DataPack> getDataPacksByDataSectionId( long dataSectionId ){
		return super.dataPackPersistence.findByDataSectionId(dataSectionId);
	}
	public List<DataPack> getDataPacksByDataSectionId( long dataSectionId, int start, int end ){
		return super.dataPackPersistence.findByDataSectionId(dataSectionId, start, end);
	}
	public int getDataPacksCountByDataSectionId( long dataSectionId ) {
		return super.dataPackPersistence.countByDataSectionId(dataSectionId);
	}

	public List<DataEntry> getDataEntriesByDataSectionId( long dataSectionId ){
		return super.dataEntryPersistence.findByDataSectionId(dataSectionId);
	}
	public List<DataEntry> getDataEntriesByDataSectionId( long dataSectionId, int start, int end ){
		return super.dataEntryPersistence.findByDataSectionId(dataSectionId, start, end);
	}
	public int getDataEntriesCountByDataSectionId( long dataSectionId ) {
		return super.dataEntryPersistence.countByDataSectionId(dataSectionId);
	}

	
	private DataSection assignDataSectionAttributes(
			DataSection dataSection,
			long dataCollectionId,
			long dataSetid,
			String name, 
			String version,
			long copiedFrom,
			JSONObject metaDataJSON,
			String layout ) throws NoSuchMetaDataFieldException {
		
		dataSection.setDataCollectionId(dataCollectionId);
		dataSection.setName(name);
		dataSection.setVersion(version);
		dataSection.setCopiedFrom(copiedFrom);
		
		if( Validator.isNotNull(metaDataJSON) ) {
			dataSection.setHasMetaData(true);
			MetaData metaData = super.metaDataPersistence.create(dataSection.getUuid());
			metaData.setMetaData(metaDataJSON);
			super.metaDataPersistence.update(metaData);
		}
		else {
			dataSection.setHasMetaData(false);
		}
		
		DataAnalysisLayout dataAnalysisLayout = super.dataAnalysisLayoutPersistence.create(dataSection.getUuid());
		dataAnalysisLayout.setLayout(layout);
		super.dataAnalysisLayoutPersistence.update(dataAnalysisLayout);
		
		return dataSection;
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