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

		soapModel.setDataEntryId(model.getDataEntryId());
		soapModel.setDataCollectionName(model.getDataCollectionName());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setPath(model.getPath());
		soapModel.setSequenceNo(model.getSequenceNo());
		soapModel.setRecordCount(model.getRecordCount());
		soapModel.setSequenceDelimeter(model.getSequenceDelimeter());

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

	public long getDataEntryId() {
		return _dataEntryId;
	}

	public void setDataEntryId(long dataEntryId) {
		_dataEntryId = dataEntryId;
	}

	public String getDataCollectionName() {
		return _dataCollectionName;
	}

	public void setDataCollectionName(String dataCollectionName) {
		_dataCollectionName = dataCollectionName;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	public int getSequenceNo() {
		return _sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		_sequenceNo = sequenceNo;
	}

	public int getRecordCount() {
		return _recordCount;
	}

	public void setRecordCount(int recordCount) {
		_recordCount = recordCount;
	}

	public String getSequenceDelimeter() {
		return _sequenceDelimeter;
	}

	public void setSequenceDelimeter(String sequenceDelimeter) {
		_sequenceDelimeter = sequenceDelimeter;
	}

	private long _dataEntryId;
	private String _dataCollectionName;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private String _path;
	private int _sequenceNo;
	private int _recordCount;
	private String _sequenceDelimeter;

}