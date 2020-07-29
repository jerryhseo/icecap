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
import com.osp.icecap.exception.NoSuchDataAnalysisLayoutException;
import com.osp.icecap.exception.NoSuchDataCollectionException;
import com.osp.icecap.exception.NoSuchMetaDataException;
import com.osp.icecap.exception.NoSuchMetaDataFieldException;
import com.osp.icecap.model.DataAnalysisLayout;
import com.osp.icecap.model.DataCollection;
import com.osp.icecap.model.DataSet;
import com.osp.icecap.model.MetaData;
import com.osp.icecap.service.base.DataCollectionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data collection local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataCollectionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataCollectionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataCollection",
	service = AopService.class
)
public class DataCollectionLocalServiceImpl
	extends DataCollectionLocalServiceBaseImpl {

	public DataCollection addDataCollection( 
			String name, 
			String version,
			long organizationId,
			JSONObject metaDataJSON,
			String layout,
			ServiceContext sc ) throws PortalException {
		long collectionId = super.counterLocalService.increment();
		
		DataCollection collection = super.dataCollectionPersistence.create(collectionId);
		
		collection.setCompanyId(sc.getCompanyId());
		collection.setGroupId(sc.getScopeGroupId());
		collection.setUserId(sc.getUserId());
		
		User user = super.userLocalService.getUser(sc.getUserId());
		collection.setUserName(user.getFullName());
		collection.setCreateDate(new Date());
		
		collection = this.assignDataCollectionAttributes(collection, name, version, organizationId, metaDataJSON, layout);

		return super.dataCollectionPersistence.update(collection, sc);
	}
	
	/**
	 * Removes all DataCollection related stuff.
	 * DataAnalysysLayout
	 * DataSet
	 * DataPack
	 * DataEntry
	 */
	public DataCollection removeDataCollection( long dataCollectionId ) throws PortalException {
		super.metaDataPersistence.removeByDataCollectionId(dataCollectionId);
		super.dataSetPersistence.removeByDataCollectionId(dataCollectionId);
		super.dataSectionPersistence.removeByDataCollectionId(dataCollectionId);
		super.dataPackPersistence.removeByDataCollectionId(dataCollectionId);
		super.dataEntryPersistence.removeByDataCollectionId(dataCollectionId);
		super.dataAnalysisLayoutPersistence.removeByDataCollectionId(dataCollectionId);
		return super.dataCollectionPersistence.remove(dataCollectionId);
	}
	
	public DataCollection updateDataCollection(
			long dataCollectionId,
			String name, 
			String version,
			long organizationId,
			JSONObject metaDataJSON,
			String layout,
			ServiceContext sc  ) throws NoSuchDataCollectionException, NoSuchMetaDataFieldException {
		
		DataCollection dataCollection = super.dataCollectionPersistence.findByPrimaryKey(dataCollectionId);

		dataCollection = this.assignDataCollectionAttributes(dataCollection, name, version, organizationId, metaDataJSON, layout);
		
		dataCollection.setModifiedDate(sc.getModifiedDate());
		super.dataCollectionPersistence.update(dataCollection, sc);

		/* indexes for the collection updated here. */

		return dataCollection;
	}
	
	public List<DataCollection> getDataCollectionsAll(){
		return super.dataCollectionPersistence.findAll();
	}
	public List<DataCollection> getDataCollectionsAll(int start, int end){
		return super.dataCollectionPersistence.findAll(start, end);
	}
	public int getDataCollectionCountAll() {
		return super.dataCollectionPersistence.countAll();
	}
	
	public List<DataCollection> getDataCollectionsByName( String dataCollectionName ){
		return super.dataCollectionPersistence.findByName(dataCollectionName);
	}
	public List<DataCollection> getDataCollectionsByName(String dataCollectionName, int start, int end){
		return super.dataCollectionPersistence.findByName(dataCollectionName,start, end);
	}
	public int getDataCollectionCountByName(String dataCollectionName) {
		return super.dataCollectionPersistence.countByName(dataCollectionName);
	}
	
	public List<DataCollection> getDataCollectionsByGroupId( long groupId ){
		return super.dataCollectionPersistence.findByGroupId(groupId);
	}
	public List<DataCollection> getDataCollectionsByGroupId( long groupId, int start, int end ){
		return super.dataCollectionPersistence.findByGroupId(groupId, start, end);
	}
	public int getDataCollectionCountByGroupId( long groupId ){
		return super.dataCollectionPersistence.countByGroupId(groupId);
	}
	
	public List<DataCollection> getDataCollectionsByUserId( long userId ){
		return super.dataCollectionPersistence.findByUserId(userId);
	}
	public List<DataCollection> getDataCollectionsByUserId( long userId, int start, int end ){
		return super.dataCollectionPersistence.findByUserId(userId, start, end);
	}
	public int getDataCollectionCountByUserId( long userId ){
		return super.dataCollectionPersistence.countByUserId(userId);
	}
	
	public List<DataCollection> getDataCollectionVariants( long dataCollectionId ){
		return super.dataCollectionPersistence.findByVariants(dataCollectionId);
	}
	public List<DataCollection> getDataCollectionVariants( long dataCollectionId, int start, int end ){
		return super.dataCollectionPersistence.findByVariants(dataCollectionId, start, end);
	}
	public int getDataCollectionVariantCount( long dataCollectionId ){
		return super.dataCollectionPersistence.countByVariants(dataCollectionId);
	}
	
	public List<DataSet> getDataSetsByDataCollectionId( long dataCollectionId ){
		return super.dataSetPersistence.findByDataCollectionId(dataCollectionId);
	}
	public List<DataSet> getDataSetsByDataCollectionId( long dataCollectionId, int start, int end ){
		return super.dataSetPersistence.findByDataCollectionId(dataCollectionId, start, end);
	}
	public int getDataSetsCountByDataCollectionId( long dataCollectionId ){
		return super.dataSetPersistence.countByDataCollectionId(dataCollectionId);
	}
	
	public DataCollection getDataCollectionByNameVersion( String dataCollectionName, String dataCollectionVersion ) throws NoSuchDataCollectionException {
		return super.dataCollectionPersistence.findByNameVersion(dataCollectionName, dataCollectionVersion);
	}
	
	public String getDataCollectionLayout( long dataCollectionId ) throws NoSuchDataCollectionException, NoSuchDataAnalysisLayoutException {
		DataCollection dataCollection = super.dataCollectionPersistence.findByPrimaryKey(dataCollectionId);
		DataAnalysisLayout analysisLayout = super.dataAnalysisLayoutPersistence.findByPrimaryKey(dataCollection.getUuid());
		
		return analysisLayout.getLayout();
	}
	
	public MetaData getDataCollectionMetaData( long dataCollectionId ) throws NoSuchDataCollectionException, NoSuchMetaDataException {
		DataCollection dataCollection = super.dataCollectionPersistence.findByPrimaryKey(dataCollectionId);
		MetaData metaData = super.metaDataPersistence.findByPrimaryKey(dataCollection.getUuid());
		
		return metaData;
	}
	
	private DataCollection assignDataCollectionAttributes(
			DataCollection dataCollection,
			String name, 
			String version,
			long organizationId,
			JSONObject metaDataJSON,
			String layout) throws NoSuchMetaDataFieldException {
		dataCollection.setName(name);
		dataCollection.setVersion(version);
		
		if( Validator.isNotNull(metaDataJSON) ) {
			dataCollection.setHasMetaData(true);
			MetaData metaData = super.metaDataPersistence.create(dataCollection.getUuid());
			metaData.setMetaData(metaDataJSON);
			super.metaDataPersistence.update(metaData);
		}
		else {
			dataCollection.setHasMetaData(false);
		}
		
		if(Validator.isBlank(layout) ) {
			dataCollection.setHasLayout(false);
		}
		else {
			DataAnalysisLayout dataAnalysisLayout = super.dataAnalysisLayoutPersistence.create(dataCollection.getUuid());
			dataAnalysisLayout.setLayout(layout);
			super.dataAnalysisLayoutPersistence.update(dataAnalysisLayout);
		}
		
		return dataCollection;
	}
}