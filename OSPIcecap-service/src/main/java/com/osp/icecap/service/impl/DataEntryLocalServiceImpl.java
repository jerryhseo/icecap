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
import com.liferay.portal.kernel.service.ServiceContext;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.service.base.DataEntryLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataEntry",
	service = AopService.class
)
public class DataEntryLocalServiceImpl extends DataEntryLocalServiceBaseImpl {

	public DataEntry createDataEntry( String dataCollectionName, ServiceContext sc ) {
		long dataEntryId = super.counterLocalService.increment();
		DataEntry dataEntry = super.createDataEntry(dataEntryId);
		
		dataEntry.setDataCollectionName(dataCollectionName);
		dataEntry.setCompanyId(sc.getCompanyId());
		dataEntry.setGroupId(sc.getScopeGroupId());
		dataEntry.setUserId(sc.getUserId());
		dataEntry.setCreateDate(new Date());
		
		return dataEntry;
	}
	
	public DataEntry removeDataEntry( DataEntry dataEntry ) {
		super.deleteDataEntry(dataEntry);
		
		return dataEntry;
	}
	
	public DataEntry removeDataEntry( long dataEntryId ) {
		DataEntry dataEntry = super.fetchDataEntry(dataEntryId);
		
		return removeDataEntry( dataEntry );
	}
}