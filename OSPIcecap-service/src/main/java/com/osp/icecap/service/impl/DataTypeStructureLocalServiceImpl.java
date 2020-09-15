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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.osp.icecap.exception.NoSuchDataTypeStructureException;
import com.osp.icecap.model.DataTypeStructure;
import com.osp.icecap.service.base.DataTypeStructureLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data type structure local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataTypeStructureLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeStructureLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataTypeStructure",
	service = AopService.class
)
public class DataTypeStructureLocalServiceImpl
	extends DataTypeStructureLocalServiceBaseImpl {

	public DataTypeStructure addDataTypeStructure( long dataTypeId, String jsonStructure ) {
		DataTypeStructure dataStructure = super.createDataTypeStructure(dataTypeId);
		dataStructure.setStructure(jsonStructure);
		
		return super.addDataTypeStructure(dataStructure);
	}
	
	public DataTypeStructure removeDataTypeStructure( long dataTypeId ) throws PortalException {
		return super.deleteDataTypeStructure(dataTypeId);
	}
	
	public DataTypeStructure updateDataTypeStructure( long dataTypeId, String jsonStructure ) {
		DataTypeStructure structure = super.createDataTypeStructure(dataTypeId);
		structure.setStructure(jsonStructure);
		
		super.updateDataTypeStructure(structure);
		
		return structure;
	}
	
	public String getDataTypeStructureSTR( long dataTypeId ) {
		DataTypeStructure dataTypeStructure;
		try {
			dataTypeStructure = super.dataTypeStructurePersistence.findByPrimaryKey(dataTypeId);
		} catch (NoSuchDataTypeStructureException e) {
			return StringPool.BLANK;
		}
		
		return dataTypeStructure.getStructure();
	}
	
	public JSONObject getDataTypeStructureJSON( long dataTypeId ) throws JSONException {
		DataTypeStructure dataTypeStructure;
		try {
			dataTypeStructure = super.dataTypeStructurePersistence.findByPrimaryKey(dataTypeId);
		} catch (NoSuchDataTypeStructureException e) {
			return null;
		}
		
		JSONObject structureJSON = JSONFactoryUtil.createJSONObject(dataTypeStructure.getStructure());
		
		return structureJSON;
	}
}