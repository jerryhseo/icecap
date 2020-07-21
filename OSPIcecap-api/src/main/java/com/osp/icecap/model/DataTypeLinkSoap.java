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

package com.osp.icecap.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataTypeLinkSoap implements Serializable {

	public static DataTypeLinkSoap toSoapModel(DataTypeLink model) {
		DataTypeLinkSoap soapModel = new DataTypeLinkSoap();

		soapModel.setDataUuid(model.getDataUuid());
		soapModel.setDataTypeId(model.getDataTypeId());

		return soapModel;
	}

	public static DataTypeLinkSoap[] toSoapModels(DataTypeLink[] models) {
		DataTypeLinkSoap[] soapModels = new DataTypeLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataTypeLinkSoap[][] toSoapModels(DataTypeLink[][] models) {
		DataTypeLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataTypeLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataTypeLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataTypeLinkSoap[] toSoapModels(List<DataTypeLink> models) {
		List<DataTypeLinkSoap> soapModels = new ArrayList<DataTypeLinkSoap>(
			models.size());

		for (DataTypeLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataTypeLinkSoap[soapModels.size()]);
	}

	public DataTypeLinkSoap() {
	}

	public String getPrimaryKey() {
		return _dataUuid;
	}

	public void setPrimaryKey(String pk) {
		setDataUuid(pk);
	}

	public String getDataUuid() {
		return _dataUuid;
	}

	public void setDataUuid(String dataUuid) {
		_dataUuid = dataUuid;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	private String _dataUuid;
	private long _dataTypeId;

}