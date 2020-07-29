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
 * This class is used by SOAP remote services, specifically {@link com.osp.icecap.service.http.DataSectionServiceSoap}.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataSectionSoap implements Serializable {

	public static DataSectionSoap toSoapModel(DataSection model) {
		DataSectionSoap soapModel = new DataSectionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDataSectionId(model.getDataSectionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setDataCollectionId(model.getDataCollectionId());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setName(model.getName());
		soapModel.setVersion(model.getVersion());
		soapModel.setCopiedFrom(model.getCopiedFrom());
		soapModel.setHasMetaData(model.isHasMetaData());
		soapModel.setHasLayout(model.isHasLayout());

		return soapModel;
	}

	public static DataSectionSoap[] toSoapModels(DataSection[] models) {
		DataSectionSoap[] soapModels = new DataSectionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataSectionSoap[][] toSoapModels(DataSection[][] models) {
		DataSectionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataSectionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataSectionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataSectionSoap[] toSoapModels(List<DataSection> models) {
		List<DataSectionSoap> soapModels = new ArrayList<DataSectionSoap>(
			models.size());

		for (DataSection model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataSectionSoap[soapModels.size()]);
	}

	public DataSectionSoap() {
	}

	public long getPrimaryKey() {
		return _dataSectionId;
	}

	public void setPrimaryKey(long pk) {
		setDataSectionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDataSectionId() {
		return _dataSectionId;
	}

	public void setDataSectionId(long dataSectionId) {
		_dataSectionId = dataSectionId;
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

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
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

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
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

	public long getCopiedFrom() {
		return _copiedFrom;
	}

	public void setCopiedFrom(long copiedFrom) {
		_copiedFrom = copiedFrom;
	}

	public boolean getHasMetaData() {
		return _hasMetaData;
	}

	public boolean isHasMetaData() {
		return _hasMetaData;
	}

	public void setHasMetaData(boolean hasMetaData) {
		_hasMetaData = hasMetaData;
	}

	public boolean getHasLayout() {
		return _hasLayout;
	}

	public boolean isHasLayout() {
		return _hasLayout;
	}

	public void setHasLayout(boolean hasLayout) {
		_hasLayout = hasLayout;
	}

	private String _uuid;
	private long _dataSectionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _dataCollectionId;
	private long _dataSetId;
	private long _dataTypeId;
	private String _name;
	private String _version;
	private long _copiedFrom;
	private boolean _hasMetaData;
	private boolean _hasLayout;

}