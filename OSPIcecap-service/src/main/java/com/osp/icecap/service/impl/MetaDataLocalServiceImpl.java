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
import com.liferay.portal.kernel.json.JSONObject;
import com.osp.icecap.exception.NoSuchMetaDataException;
import com.osp.icecap.exception.NoSuchMetaDataFieldException;
import com.osp.icecap.model.MetaData;
import com.osp.icecap.service.base.MetaDataLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the meta data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.MetaDataLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see MetaDataLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.MetaData",
	service = AopService.class
)
public class MetaDataLocalServiceImpl extends MetaDataLocalServiceBaseImpl {

	public MetaData addMetaData( String dataUuid, JSONObject metaDataJSON ) throws NoSuchMetaDataFieldException {
		MetaData metaData = super.metaDataPersistence.create(dataUuid);
		
		metaData.setMetaData(metaDataJSON);
		
		super.metaDataPersistence.update(metaData);
		return metaData;
	}
	
	public MetaData removeMetaData( String dataUuid ) throws NoSuchMetaDataException {
		return super.metaDataPersistence.remove(dataUuid);
	}
	public MetaData removeMetaData( MetaData metaData ){
		return super.metaDataPersistence.remove(metaData);
	}
	
	public void removeByDataCollectionId( long dataCollectionId ) {
		super.metaDataPersistence.removeByDataCollectionId(dataCollectionId);
	}
	
	public void removeByDataSetId( long dataSetId ) {
		super.metaDataPersistence.removeByDataSetId(dataSetId);
	}
	
	public void removeByDataSectionId( long dataSectionId ) {
		super.metaDataPersistence.removeByDataSectionId(dataSectionId);
	}
	
	public void removeByDataPackId( long dataPackId ) {
		super.metaDataPersistence.removeByDataPackId(dataPackId);
	}
	
	public MetaData updateMetaData( String dataUuid, JSONObject metaDataJSON ) throws NoSuchMetaDataException, NoSuchMetaDataFieldException {
		MetaData metaData = super.metaDataPersistence.findByPrimaryKey(dataUuid);
		metaData.setMetaData(metaDataJSON);
		
		super.metaDataPersistence.update(metaData);
		return metaData;
	}
}