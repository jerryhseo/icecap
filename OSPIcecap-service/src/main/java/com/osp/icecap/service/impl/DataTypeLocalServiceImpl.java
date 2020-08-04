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
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.osp.icecap.model.DataType;
import com.osp.icecap.service.base.DataTypeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

	@Indexable(type = IndexableType.REINDEX)
	public DataType addDataType( 
			String dataTypeName, 
			String dataTypeVersion,
			Map<Locale, String> descriptionMap,
			String samplePath,
			ServiceContext sc) throws PortalException {
		long dataTypeId = super.counterLocalService.increment();
		DataType dataType = super.dataTypePersistence.create(dataTypeId);
		
		// dataType.setUuid(sc.getUuid());
		System.out.println("New Added Data Type: "+dataTypeId+", "+dataType.getUuid());
		
		dataType.setName(dataTypeName);
		dataType.setVersion(dataTypeVersion);
		dataType.setDescriptionMap(descriptionMap);
		dataType.setSamplePath(samplePath);
		
		User user = super.userLocalService.getUser(sc.getUserId());
		
		dataType.setCompanyId(sc.getCompanyId());
		dataType.setGroupId(sc.getScopeGroupId());
		dataType.setUserId(sc.getUserId());
		dataType.setUserName(user.getFullName());
		
		Date now = new Date();
		dataType.setCreateDate(now);
		dataType.setModifiedDate(now);

		dataType.setStatus(WorkflowConstants.STATUS_APPROVED);
		/*
		dataType.setStatus(WorkflowConstants.STATUS_DRAFT);
		dataType.setStatusByUserId(user.getUserId());
		dataType.setStatusByUserName(user.getFullName());
		dataType.setStatusDate(now);
		*/

		super.addDataType(dataType);

		/*
		super.assetEntryLocalService.updateEntry(
				dataType.getUserId(), dataType.getGroupId(), dataType.getCreateDate(),
				dataType.getModifiedDate(), DataType.class.getName(),
				dataType.getPrimaryKey(), dataType.getUuid(), 0,
			    assetCategoryIds, assetTagNames, true, true, null, null,
			    page.getCreateDate(), null, ContentTypes.TEXT_HTML,
			    page.getTitle(), null, null, null, null, 0, 0, null);

			Indexer<JournalArticle> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			    WikiPage.class);

		indexer.reindex(page);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				dataType.getCompanyId(),
				dataType.getGroupId(), 
				dataType.getUserId(),
				DataType.class.getName(), 
				dataType.getPrimaryKey(), 
				dataType,
				sc);
		*/
		return dataType;
	}
	
	public DataType removeDataType( DataType dataType ) throws PortalException {
		return this.removeDataType(dataType.getDataTypeId());
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DataType removeDataType( long dataTypeId ) throws PortalException {
		DataType dataType = super.dataTypePersistence.remove(dataTypeId);
		
		return dataType;
	}
	
	public DataType removeDataType( String dataTypeName, String dataTypeVersion ) throws PortalException {
		DataType dataType = super.dataTypePersistence.fetchByNameVersion(dataTypeName, dataTypeVersion);
		this.removeDataType( dataType.getDataTypeId() );
		
		return dataType;
	}
	
	public int removeDataType( String dataTypeName ) throws PortalException {
		List<DataType> dataTypes = super.dataTypePersistence.findByName(dataTypeName);
		
		for( DataType dataType : dataTypes ) {
			this.removeDataType(dataType.getDataTypeId());
		}
		
		return dataTypes.size();
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataType updateDataType(
			long dataTypeId,
			String dataTypeName,
			String dataTypeVersion,
			Map<Locale, String> descriptionMap,
			String samplePath,
			ServiceContext sc ) {
		DataType dataType = super.fetchDataType(dataTypeId);
		dataType.setName(dataTypeName);
		dataType.setVersion(dataTypeVersion);
		dataType.setDescriptionMap(descriptionMap);
		dataType.setSamplePath(samplePath);
		
		dataType.setModifiedDate(new Date());;
		
		super.updateDataType(dataType);
		
		return dataType;
	}
	
	/*
	public DataType updateStatus( long userId, long dataTypeId, int status, ServiceContext sc ) throws PortalException {
		User user = userLocalService.getUser(userId);
		DataType dataType = getDataType(dataTypeId);
		dataType.setStatus(status);
		
		dataType.setStatusByUserId(userId);
		dataType.setStatusByUserName(user.getFullName());
		dataType.setStatusDate(sc.getModifiedDate());
		
		return null;
	}
	*/
	
	public DataType copyDataType( long dataTypeId, ServiceContext sc ) throws PortalException {
		DataType dataType = super.fetchDataType(dataTypeId);
		DataType copiedDataType = this.addDataType(dataType.getName(), "", dataType.getDescriptionMap(), dataType.getSamplePath(), sc);
		
		return copiedDataType;
	}
}