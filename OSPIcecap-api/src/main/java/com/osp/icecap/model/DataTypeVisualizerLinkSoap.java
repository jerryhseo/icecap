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
public class DataTypeVisualizerLinkSoap implements Serializable {

	public static DataTypeVisualizerLinkSoap toSoapModel(
		DataTypeVisualizerLink model) {

		DataTypeVisualizerLinkSoap soapModel = new DataTypeVisualizerLinkSoap();

		soapModel.setDataTypeVisualizerLinkId(
			model.getDataTypeVisualizerLinkId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setVisualizerName(model.getVisualizerName());
		soapModel.setVisualizerVersion(model.getVisualizerVersion());
		soapModel.setDefaultVisualizer(model.isDefaultVisualizer());
		soapModel.setEditable(model.isEditable());

		return soapModel;
	}

	public static DataTypeVisualizerLinkSoap[] toSoapModels(
		DataTypeVisualizerLink[] models) {

		DataTypeVisualizerLinkSoap[] soapModels =
			new DataTypeVisualizerLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataTypeVisualizerLinkSoap[][] toSoapModels(
		DataTypeVisualizerLink[][] models) {

		DataTypeVisualizerLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DataTypeVisualizerLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataTypeVisualizerLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataTypeVisualizerLinkSoap[] toSoapModels(
		List<DataTypeVisualizerLink> models) {

		List<DataTypeVisualizerLinkSoap> soapModels =
			new ArrayList<DataTypeVisualizerLinkSoap>(models.size());

		for (DataTypeVisualizerLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DataTypeVisualizerLinkSoap[soapModels.size()]);
	}

	public DataTypeVisualizerLinkSoap() {
	}

	public long getPrimaryKey() {
		return _dataTypeVisualizerLinkId;
	}

	public void setPrimaryKey(long pk) {
		setDataTypeVisualizerLinkId(pk);
	}

	public long getDataTypeVisualizerLinkId() {
		return _dataTypeVisualizerLinkId;
	}

	public void setDataTypeVisualizerLinkId(long dataTypeVisualizerLinkId) {
		_dataTypeVisualizerLinkId = dataTypeVisualizerLinkId;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public String getVisualizerName() {
		return _visualizerName;
	}

	public void setVisualizerName(String visualizerName) {
		_visualizerName = visualizerName;
	}

	public String getVisualizerVersion() {
		return _visualizerVersion;
	}

	public void setVisualizerVersion(String visualizerVersion) {
		_visualizerVersion = visualizerVersion;
	}

	public boolean getDefaultVisualizer() {
		return _defaultVisualizer;
	}

	public boolean isDefaultVisualizer() {
		return _defaultVisualizer;
	}

	public void setDefaultVisualizer(boolean defaultVisualizer) {
		_defaultVisualizer = defaultVisualizer;
	}

	public boolean getEditable() {
		return _editable;
	}

	public boolean isEditable() {
		return _editable;
	}

	public void setEditable(boolean editable) {
		_editable = editable;
	}

	private long _dataTypeVisualizerLinkId;
	private long _dataTypeId;
	private String _visualizerName;
	private String _visualizerVersion;
	private boolean _defaultVisualizer;
	private boolean _editable;

}