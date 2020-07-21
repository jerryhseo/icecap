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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.osp.icecap.exception.NoSuchDataSetException;
import com.osp.icecap.model.DataSet;
import com.osp.icecap.service.base.DataSetLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data set local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataSetLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataSetLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataSet",
	service = AopService.class
)
public class DataSetLocalServiceImpl extends DataSetLocalServiceBaseImpl {
	public DataSet addDataSet( long dataCollectionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String version, long copiedFrom, ServiceContext sc) throws PortalException {
		long dataSetId = super.counterLocalService.increment();
		DataSet dataSet = super.dataSetPersistence.create(dataSetId);
		
		User user = super.userLocalService.getUser(sc.getUserId());
		Date now = new Date();
		
		dataSet.setCompanyId(sc.getCompanyId());
		dataSet.setGroupId(sc.getScopeGroupId());
		dataSet.setUserId(user.getUserId());
		dataSet.setUserName(user.getFullName());
		dataSet.setCreateDate(now);
		dataSet.setModifiedDate(now);
		dataSet.setDataCollectionId(dataCollectionId);
		dataSet.setTitleMap(titleMap);
		dataSet.setDescriptionMap(descriptionMap);
		dataSet.setVersion(version);
		dataSet.setCopiedFrom(copiedFrom);
		
		dataSet.setStatus(WorkflowConstants.STATUS_APPROVED);
		
		return super.dataSetPersistence.update(dataSet, sc);
	}
	
	public DataSet removeDataSet( long dataSetId ) throws NoSuchDataSetException {
		super.dataSectionPersistence.removeByDataSetId(dataSetId);
		super.dataPackPersistence.removeByDataSetId(dataSetId);
		super.dataEntryPersistence.removeByDataSetId(dataSetId);

		return super.dataSetPersistence.remove(dataSetId);
	}
	
	public DataSet updateDataSet( long dataSetId, long dataCollectionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String version, ServiceContext sc){
		DataSet dataSet = super.dataSetPersistence.fetchByPrimaryKey(dataSetId);
		
		dataSet.setModifiedDate(sc.getModifiedDate());
		dataSet.setDataCollectionId(dataCollectionId);
		dataSet.setTitleMap(titleMap);
		dataSet.setDescriptionMap(descriptionMap);
		dataSet.setVersion(version);

		return super.dataSetPersistence.update(dataSet);
	}
	
	public List<DataSet> getDataSetsByOrigin( long originId ){
		return super.dataSetPersistence.findByCopiedFrom(originId);
	}
	public List<DataSet> getDataSetsByOrigin( long originId, int start, int end ){
		return super.dataSetPersistence.findByCopiedFrom(originId, start, end);
	}
	public int getDataSetsCountByOrigin( long originId ){
		return super.dataSetPersistence.countByCopiedFrom(originId);
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

}