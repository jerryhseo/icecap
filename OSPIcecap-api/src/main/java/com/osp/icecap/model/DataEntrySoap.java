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
 * This class is used by SOAP remote services, specifically {@link com.osp.icecap.service.http.DataEntryServiceSoap}.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataEntrySoap implements Serializable {

	public static DataEntrySoap toSoapModel(DataEntry model) {
		DataEntrySoap soapModel = new DataEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDataEntryId(model.getDataEntryId());
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
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setDataPackId(model.getDataPackId());
		soapModel.setDataSectionId(model.getDataSectionId());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataCollectionId(model.getDataCollectionId());
		soapModel.setAccessURL(model.getAccessURL());
		soapModel.setSequenceId(model.getSequenceId());
		soapModel.setAccessType(model.getAccessType());
		soapModel.setCopiedFrom(model.getCopiedFrom());
		soapModel.setHasMetaData(model.isHasMetaData());

		return soapModel;
	}

	public static DataEntrySoap[] toSoapModels(DataEntry[] models) {
		DataEntrySoap[] soapModels = new DataEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataEntrySoap[][] toSoapModels(DataEntry[][] models) {
		DataEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataEntrySoap[] toSoapModels(List<DataEntry> models) {
		List<DataEntrySoap> soapModels = new ArrayList<DataEntrySoap>(
			models.size());

		for (DataEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataEntrySoap[soapModels.size()]);
	}

	public DataEntrySoap() {
	}

	public long getPrimaryKey() {
		return _dataEntryId;
	}

	public void setPrimaryKey(long pk) {
		setDataEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDataEntryId() {
		return _dataEntryId;
	}

	public void setDataEntryId(long dataEntryId) {
		_dataEntryId = dataEntryId;
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

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public long getDataPackId() {
		return _dataPackId;
	}

	public void setDataPackId(long dataPackId) {
		_dataPackId = dataPackId;
	}

	public long getDataSectionId() {
		return _dataSectionId;
	}

	public void setDataSectionId(long dataSectionId) {
		_dataSectionId = dataSectionId;
	}

	public long getDataSetId() {
		return _dataSetId;
	}

	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	public void setDataCollectionId(long dataCollectionId) {
		_dataCollectionId = dataCollectionId;
	}

	public String getAccessURL() {
		return _accessURL;
	}

	public void setAccessURL(String accessURL) {
		_accessURL = accessURL;
	}

	public String getSequenceId() {
		return _sequenceId;
	}

	public void setSequenceId(String sequenceId) {
		_sequenceId = sequenceId;
	}

	public String getAccessType() {
		return _accessType;
	}

	public void setAccessType(String accessType) {
		_accessType = accessType;
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

	private String _uuid;
	private long _dataEntryId;
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
	private long _dataTypeId;
	private long _dataPackId;
	private long _dataSectionId;
	private long _dataSetId;
	private long _dataCollectionId;
	private String _accessURL;
	private String _sequenceId;
	private String _accessType;
	private long _copiedFrom;
	private boolean _hasMetaData;

}