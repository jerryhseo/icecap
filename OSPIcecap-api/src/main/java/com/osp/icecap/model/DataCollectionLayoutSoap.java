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
 * This class is used by SOAP remote services, specifically {@link com.osp.icecap.service.http.DataCollectionLayoutServiceSoap}.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataCollectionLayoutSoap implements Serializable {

	public static DataCollectionLayoutSoap toSoapModel(
		DataCollectionLayout model) {

		DataCollectionLayoutSoap soapModel = new DataCollectionLayoutSoap();

		soapModel.setDataCollectionId(model.getDataCollectionId());
		soapModel.setLayout(model.getLayout());

		return soapModel;
	}

	public static DataCollectionLayoutSoap[] toSoapModels(
		DataCollectionLayout[] models) {

		DataCollectionLayoutSoap[] soapModels =
			new DataCollectionLayoutSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataCollectionLayoutSoap[][] toSoapModels(
		DataCollectionLayout[][] models) {

		DataCollectionLayoutSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DataCollectionLayoutSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataCollectionLayoutSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataCollectionLayoutSoap[] toSoapModels(
		List<DataCollectionLayout> models) {

		List<DataCollectionLayoutSoap> soapModels =
			new ArrayList<DataCollectionLayoutSoap>(models.size());

		for (DataCollectionLayout model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DataCollectionLayoutSoap[soapModels.size()]);
	}

	public DataCollectionLayoutSoap() {
	}

	public long getPrimaryKey() {
		return _dataCollectionId;
	}

	public void setPrimaryKey(long pk) {
		setDataCollectionId(pk);
	}

	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	public void setDataCollectionId(long dataCollectionId) {
		_dataCollectionId = dataCollectionId;
	}

	public String getLayout() {
		return _layout;
	}

	public void setLayout(String layout) {
		_layout = layout;
	}

	private long _dataCollectionId;
	private String _layout;

}