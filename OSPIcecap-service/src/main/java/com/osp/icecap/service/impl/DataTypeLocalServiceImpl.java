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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.osp.icecap.exception.NoSuchDataTypeException;
import com.osp.icecap.model.DataType;
import com.osp.icecap.model.DataTypeVisualizerLink;
import com.osp.icecap.service.DataTypeStructureLocalService;
import com.osp.icecap.service.base.DataTypeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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

		super.dataTypePersistence.update(dataType, sc);

		//Register the data type as an asset
		AssetEntry assetEntry = super.assetEntryLocalService.updateEntry(
				dataType.getUserId(), 
				dataType.getGroupId(), 
				dataType.getCreateDate(),
				dataType.getModifiedDate(), 
				DataType.class.getName(),
				dataType.getPrimaryKey(), 
				dataType.getUuid(), 
				0,
			    sc.getAssetCategoryIds(), 
			    sc.getAssetTagNames(), 
			    true, true, null, null, null, null, 
			    ContentTypes.TEXT_HTML,
			    dataType.getName(), 
			    null, null, null, null, 0, 0, null);
		super.assetLinkLocalService.updateLinks(
				user.getPrimaryKey(), 
				assetEntry.getEntryId(),
                sc.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);

		/*
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
	
	public DataType removeDataType( long dataTypeId ) throws PortalException {
		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);
		
		this.removeDataType(dataType);
		return dataType;
	}
	
	@Indexable(type = IndexableType.DELETE)
	private DataType removeDataType( DataType dataType ) throws PortalException {
		this.dataTypeStructureLocalService.removeDataTypeStructure(dataType.getPrimaryKey());
		
		//Unregister the data type from asset framework
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				DataType.class.getName(), dataType.getPrimaryKey());

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		assetEntryLocalService.deleteEntry(assetEntry);
		
		return super.deleteDataType(dataType);
	}
	
	public DataType removeDataTypeByNameVersion( String dataTypeName, String dataTypeVersion ) throws PortalException {
		DataType dataType = super.dataTypePersistence.fetchByNameVersion(dataTypeName, dataTypeVersion);
		return this.removeDataType( dataType );
	}
	
	public int removeDataTypeByName( String dataTypeName ) throws PortalException {
		List<DataType> dataTypes = super.dataTypePersistence.findByName(dataTypeName);
		
		for( DataType dataType : dataTypes ) {
			this.removeDataType(dataType);
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
			ServiceContext sc ) throws PortalException {
		DataType dataType = super.fetchDataType(dataTypeId);
		dataType.setName(dataTypeName);
		dataType.setVersion(dataTypeVersion);
		dataType.setDescriptionMap(descriptionMap);
		dataType.setSamplePath(samplePath);
		
		dataType.setModifiedDate(new Date());;
		
		super.dataTypePersistence.update(dataType, sc);
		
		//Update asset information of the data type
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				dataType.getUserId(),
				dataType.getGroupId(), 
				dataType.getCreateDate(),
				dataType.getModifiedDate(), 
				DataType.class.getName(),
				dataTypeId, 
				dataType.getUuid(), 
				0,
                sc.getAssetCategoryIds(),
                sc.getAssetTagNames(), 
                true, true, 
                dataType.getCreateDate(), 
                null, null, null, 
                ContentTypes.TEXT_HTML, 
                dataType.getName(), 
                null, null, null, null, 0, 0, 
                sc.getAssetPriority());

		assetLinkLocalService.updateLinks(sc.getUserId(),
                assetEntry.getEntryId(), sc.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
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
	
	public List<DataType> getDataTypesByName( String name ){
		return super.dataTypePersistence.findByName(name);
	}
	public List<DataType> getDataTypesByName( String name, int start, int end ){
		return super.dataTypePersistence.findByName(name, start, end);
	}
	public int countDataTypesByName( String name ) {
		return super.dataTypePersistence.countByName(name);
	}
	
	public DataType getDataType( String name, String version) throws NoSuchDataTypeException {
		return super.dataTypePersistence.findByNameVersion(name, version);
	}
	
	public JSONObject getDataTypeStructureJSON( long dataTypeId ) throws JSONException {
		return dataTypeStructureLocalService.getDataTypeStructureJSON(dataTypeId);
	}
	
	public String getDataTypeStructureSTR( long dataTypeId ) {
		return dataTypeStructureLocalService.getDataTypeStructureSTR(dataTypeId);
	}
	
	public String getDataTypeVisualizersSTR( long dataTypeId ) {
		
		JSONArray visualizersJSON = getDataTypeVisualizersJSON(dataTypeId);
		
		return visualizersJSON.toString();
	}

	public JSONArray getDataTypeVisualizersJSON( long dataTypeId ) {
		
		List<DataTypeVisualizerLink> visualizers = super.dataTypeVisualizerLinkPersistence.findByDataTypeId(dataTypeId);
		
		JSONArray visualizersJSON = JSONFactoryUtil.createJSONArray();
		
		for( DataTypeVisualizerLink link : visualizers ) {
			JSONObject linkJSON = link.toJSONObject();
			visualizersJSON.put(linkJSON);
		}
		
		return visualizersJSON;
	}

	@Reference
	private volatile DataTypeStructureLocalService dataTypeStructureLocalService;
}