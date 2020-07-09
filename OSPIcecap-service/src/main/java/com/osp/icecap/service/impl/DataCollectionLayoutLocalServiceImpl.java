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
import com.osp.icecap.model.DataCollectionLayout;
import com.osp.icecap.service.base.DataCollectionLayoutLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data collection layout local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataCollectionLayoutLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataCollectionLayoutLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataCollectionLayout",
	service = AopService.class
)
public class DataCollectionLayoutLocalServiceImpl
	extends DataCollectionLayoutLocalServiceBaseImpl {

	public DataCollectionLayout addDataCollectionLayout( long dataCollectionId, String jsonLayout ) {
		DataCollectionLayout layout = super.createDataCollectionLayout(dataCollectionId);
		
		layout.setLayout(jsonLayout);
		
		return super.addDataCollectionLayout(layout);
	}
	
	public DataCollectionLayout removeDataCollectionLayout( long dataCollectionId ) throws PortalException {
		return super.deleteDataCollectionLayout(dataCollectionId);
	}
	
	public DataCollectionLayout updateDataCollectionLayout( long dataCollectionId, String jsonLayout ) {
		DataCollectionLayout layout = super.fetchDataCollectionLayout(dataCollectionId);
		layout.setLayout(jsonLayout);
		
		return super.updateDataCollectionLayout(layout); 
	}
}