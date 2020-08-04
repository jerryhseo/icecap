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
import com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException;
import com.osp.icecap.model.DataTypeVisualizerLink;
import com.osp.icecap.service.base.DataTypeVisualizerLinkLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data type visualizer link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataTypeVisualizerLinkLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeVisualizerLinkLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataTypeVisualizerLink",
	service = AopService.class
)
public class DataTypeVisualizerLinkLocalServiceImpl
	extends DataTypeVisualizerLinkLocalServiceBaseImpl {

	public DataTypeVisualizerLink addDataTypeVisualizerLink( long dataTypeId, String visualizerName, String visualizerVersion, boolean editable ) {
		long linkId = super.counterLocalService.increment();
		DataTypeVisualizerLink link = super.createDataTypeVisualizerLink(linkId);
		
		link.setDataTypeId(dataTypeId);
		link.setVisualizerName(visualizerName);
		link.setVisualizerVersion(visualizerVersion);
		link.setEditable(editable);
		
		return link;
	}
	
	public void removeDataTypeVisualizerLinks( long dataTypeId ) {
		super.dataTypeVisualizerLinkPersistence.removeByDataTypeId(dataTypeId);
		
		return;
	}
	
	public void removeDataTypeVisualizerLinks( String visualizerName, String visualizerVersion ) throws NoSuchDataTypeVisualizerLinkException {
		super.dataTypeVisualizerLinkPersistence.removeByVisualizerNameVersion(visualizerName, visualizerVersion);
		
		return;
	}

	public void removeDataTypeVisualizerLinks( String visualizerName ) throws NoSuchDataTypeVisualizerLinkException {
		super.dataTypeVisualizerLinkPersistence.removeByVisualizerName(visualizerName);
		
		return;
	}
	
	public DataTypeVisualizerLink removeDataTypeVisualizerLink( long dataTypeVisualizerLinkId ) throws PortalException {
		return super.deleteDataTypeVisualizerLink(dataTypeVisualizerLinkId);
	}

	public DataTypeVisualizerLink updateDataTypeVisualizerLink( long dataTypeVisualizerLinkId,  long dataTypeId, String visualizerName, String visualizerVersion, boolean editable ) throws PortalException {
		DataTypeVisualizerLink link = super.getDataTypeVisualizerLink(dataTypeVisualizerLinkId);
		
		link.setDataTypeId(dataTypeId);
		link.setVisualizerName(visualizerName);
		link.setVisualizerVersion(visualizerVersion);
		link.setEditable(editable);
		
		return super.updateDataTypeVisualizerLink(link);
	}

}