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

/**
 * This class is used by SOAP remote services.
 *
 * @author Jerry H. Seo
 * @generated
 */
public class DataAnalysisLayoutSoap implements Serializable {

	public static DataAnalysisLayoutSoap toSoapModel(DataAnalysisLayout model) {
		DataAnalysisLayoutSoap soapModel = new DataAnalysisLayoutSoap();

		soapModel.setDataUuid(model.getDataUuid());
		soapModel.setDataCollectionId(model.getDataCollectionId());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataSectionId(model.getDataSectionId());
		soapModel.setDataPackId(model.getDataPackId());
		soapModel.setLayout(model.getLayout());

		return soapModel;
	}

	public static DataAnalysisLayoutSoap[] toSoapModels(
		DataAnalysisLayout[] models) {

		DataAnalysisLayoutSoap[] soapModels =
			new DataAnalysisLayoutSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataAnalysisLayoutSoap[][] toSoapModels(
		DataAnalysisLayout[][] models) {

		DataAnalysisLayoutSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DataAnalysisLayoutSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataAnalysisLayoutSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataAnalysisLayoutSoap[] toSoapModels(
		List<DataAnalysisLayout> models) {

		List<DataAnalysisLayoutSoap> soapModels =
			new ArrayList<DataAnalysisLayoutSoap>(models.size());

		for (DataAnalysisLayout model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DataAnalysisLayoutSoap[soapModels.size()]);
	}

	public DataAnalysisLayoutSoap() {
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

	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	public void setDataCollectionId(long dataCollectionId) {
		_dataCollectionId = dataCollectionId;
	}

	public long getDataSetId() {
		return _dataSetId;
	}

	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	public long getDataSectionId() {
		return _dataSectionId;
	}

	public void setDataSectionId(long dataSectionId) {
		_dataSectionId = dataSectionId;
	}

	public long getDataPackId() {
		return _dataPackId;
	}

	public void setDataPackId(long dataPackId) {
		_dataPackId = dataPackId;
	}

	public String getLayout() {
		return _layout;
	}

	public void setLayout(String layout) {
		_layout = layout;
	}

	private String _dataUuid;
	private long _dataCollectionId;
	private long _dataSetId;
	private long _dataSectionId;
	private long _dataPackId;
	private String _layout;

}