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
import com.osp.icecap.exception.NoSuchDataTypeLinkException;
import com.osp.icecap.model.DataTypeLink;
import com.osp.icecap.service.base.DataTypeLinkLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data type link local service.
 *
 * <p>
 * 
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeLinkLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataTypeLink",
	service = AopService.class
)
public class DataTypeLinkLocalServiceImpl
	extends DataTypeLinkLocalServiceBaseImpl {
	
	public DataTypeLink addDataTypeLink( String dataUuid, long dataTypeId) {
		DataTypeLink dataTypeLink = super.createDataTypeLink(dataUuid);
		dataTypeLink.setDataTypeId(dataTypeId);
		
		return super.addDataTypeLink(dataTypeLink);
	}
	
	public DataTypeLink removeDataTypeLink( String dataUuid ) throws PortalException {
		return super.deleteDataTypeLink(dataUuid);
	}
	
	public DataTypeLink updateDataTypeLink( String dataUuid, long dataTypeId ) throws PortalException {
		DataTypeLink dataTypeLink = super.getDataTypeLink(dataUuid);
		dataTypeLink.setDataTypeId(dataTypeId);
		
		return super.updateDataTypeLink(dataTypeLink);
	}
}