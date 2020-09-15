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
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataTypeSoap implements Serializable {

	public static DataTypeSoap toSoapModel(DataType model) {
		DataTypeSoap soapModel = new DataTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setName(model.getName());
		soapModel.setVersion(model.getVersion());
		soapModel.setExtension(model.getExtension());
		soapModel.setSamplePath(model.getSamplePath());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static DataTypeSoap[] toSoapModels(DataType[] models) {
		DataTypeSoap[] soapModels = new DataTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataTypeSoap[][] toSoapModels(DataType[][] models) {
		DataTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataTypeSoap[] toSoapModels(List<DataType> models) {
		List<DataTypeSoap> soapModels = new ArrayList<DataTypeSoap>(
			models.size());

		for (DataType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataTypeSoap[soapModels.size()]);
	}

	public DataTypeSoap() {
	}

	public long getPrimaryKey() {
		return _dataTypeId;
	}

	public void setPrimaryKey(long pk) {
		setDataTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public String getExtension() {
		return _extension;
	}

	public void setExtension(String extension) {
		_extension = extension;
	}

	public String getSamplePath() {
		return _samplePath;
	}

	public void setSamplePath(String samplePath) {
		_samplePath = samplePath;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _dataTypeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private String _name;
	private String _version;
	private String _extension;
	private String _samplePath;
	private String _description;

}