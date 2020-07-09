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
import com.liferay.portal.kernel.service.ServiceContext;
import com.osp.icecap.model.DataCollection;
import com.osp.icecap.service.base.DataCollectionLocalServiceBaseImpl;

import java.util.Date;

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

	public DataCollection createDataCollection( String collectionName, ServiceContext sc ) {
		long collectionId = super.counterLocalService.increment();
		
		DataCollection collection = super.createDataCollection(collectionId);
		
		collection.setName(collectionName);
		collection.setCompanyId(sc.getCompanyId());
		collection.setGroupId(sc.getScopeGroupId());
		collection.setUserId(sc.getUserId());
		collection.setCreateDate(new Date());
		
		return collection;
	}
	
	public DataCollection addDataCollection( DataCollection collection ) {
		collection.setModifiedDate(new Date());
		super.addDataCollection(collection);
		
		return collection;
	}
	
	public DataCollection removeDataCollection( DataCollection collection ) {
		DataCollection deletedCollection = super.deleteDataCollection(collection);
		
		/* indexes for the collection deleted here and
		 * resources for the collection deleted too.
		 */
		
		return deletedCollection;
	}
	
	public DataCollection removeDataCollection( long collectionId ) throws PortalException {
		DataCollection collection = super.getDataCollection(collectionId);
		
		return removeDataCollection(collection);
	}
	
	public DataCollection removeDataCollection( String collectionName ) {
		DataCollection collection = super.dataCollectionPersistence.fetchByName(collectionName);
		
		return removeDataCollection(collection);
	}
	
	public DataCollection updateDataCollection( DataCollection collection ) {
		collection.setModifiedDate(new Date());
		super.updateDataCollection(collection);

		/* indexes for the collection updated here. */

		return collection;
	}
}