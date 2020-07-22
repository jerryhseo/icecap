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
public class DataAnalysisLayoutSoap implements Serializable {

	public static DataAnalysisLayoutSoap toSoapModel(DataAnalysisLayout model) {
		DataAnalysisLayoutSoap soapModel = new DataAnalysisLayoutSoap();

		soapModel.setDataUuid(model.getDataUuid());
		soapModel.setLayout(model.getLayout());
		soapModel.setApplyLevel(model.getApplyLevel());

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

	public String getLayout() {
		return _layout;
	}

	public void setLayout(String layout) {
		_layout = layout;
	}

	public String getApplyLevel() {
		return _applyLevel;
	}

	public void setApplyLevel(String applyLevel) {
		_applyLevel = applyLevel;
	}

	private String _dataUuid;
	private String _layout;
	private String _applyLevel;

}