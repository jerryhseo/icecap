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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataSet}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataSet
 * @generated
 */
public class DataSetWrapper
	extends BaseModelWrapper<DataSet>
	implements DataSet, ModelWrapper<DataSet> {

	public DataSetWrapper(DataSet dataSet) {
		super(dataSet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("dataCollectionId", getDataCollectionId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("name", getName());
		attributes.put("version", getVersion());
		attributes.put("copiedFrom", getCopiedFrom());
		attributes.put("hasMetaData", isHasMetaData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long dataCollectionId = (Long)attributes.get("dataCollectionId");

		if (dataCollectionId != null) {
			setDataCollectionId(dataCollectionId);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long copiedFrom = (Long)attributes.get("copiedFrom");

		if (copiedFrom != null) {
			setCopiedFrom(copiedFrom);
		}

		Boolean hasMetaData = (Boolean)attributes.get("hasMetaData");

		if (hasMetaData != null) {
			setHasMetaData(hasMetaData);
		}
	}

	/**
	 * Returns the company ID of this data set.
	 *
	 * @return the company ID of this data set
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the copied from of this data set.
	 *
	 * @return the copied from of this data set
	 */
	@Override
	public long getCopiedFrom() {
		return model.getCopiedFrom();
	}

	/**
	 * Returns the create date of this data set.
	 *
	 * @return the create date of this data set
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data collection ID of this data set.
	 *
	 * @return the data collection ID of this data set
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the data set ID of this data set.
	 *
	 * @return the data set ID of this data set
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the data type ID of this data set.
	 *
	 * @return the data type ID of this data set
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the group ID of this data set.
	 *
	 * @return the group ID of this data set
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has meta data of this data set.
	 *
	 * @return the has meta data of this data set
	 */
	@Override
	public boolean getHasMetaData() {
		return model.getHasMetaData();
	}

	/**
	 * Returns the modified date of this data set.
	 *
	 * @return the modified date of this data set
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this data set.
	 *
	 * @return the name of this data set
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this data set.
	 *
	 * @return the primary key of this data set
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this data set.
	 *
	 * @return the status of this data set
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this data set.
	 *
	 * @return the status by user ID of this data set
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this data set.
	 *
	 * @return the status by user name of this data set
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this data set.
	 *
	 * @return the status by user uuid of this data set
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this data set.
	 *
	 * @return the status date of this data set
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this data set.
	 *
	 * @return the user ID of this data set
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data set.
	 *
	 * @return the user name of this data set
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data set.
	 *
	 * @return the user uuid of this data set
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this data set.
	 *
	 * @return the uuid of this data set
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this data set.
	 *
	 * @return the version of this data set
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this data set is approved.
	 *
	 * @return <code>true</code> if this data set is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this data set is denied.
	 *
	 * @return <code>true</code> if this data set is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this data set is a draft.
	 *
	 * @return <code>true</code> if this data set is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this data set is expired.
	 *
	 * @return <code>true</code> if this data set is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this data set is has meta data.
	 *
	 * @return <code>true</code> if this data set is has meta data; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasMetaData() {
		return model.isHasMetaData();
	}

	/**
	 * Returns <code>true</code> if this data set is inactive.
	 *
	 * @return <code>true</code> if this data set is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this data set is incomplete.
	 *
	 * @return <code>true</code> if this data set is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this data set is pending.
	 *
	 * @return <code>true</code> if this data set is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this data set is scheduled.
	 *
	 * @return <code>true</code> if this data set is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this data set.
	 *
	 * @param companyId the company ID of this data set
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the copied from of this data set.
	 *
	 * @param copiedFrom the copied from of this data set
	 */
	@Override
	public void setCopiedFrom(long copiedFrom) {
		model.setCopiedFrom(copiedFrom);
	}

	/**
	 * Sets the create date of this data set.
	 *
	 * @param createDate the create date of this data set
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data collection ID of this data set.
	 *
	 * @param dataCollectionId the data collection ID of this data set
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the data set ID of this data set.
	 *
	 * @param dataSetId the data set ID of this data set
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the data type ID of this data set.
	 *
	 * @param dataTypeId the data type ID of this data set
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the group ID of this data set.
	 *
	 * @param groupId the group ID of this data set
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this data set is has meta data.
	 *
	 * @param hasMetaData the has meta data of this data set
	 */
	@Override
	public void setHasMetaData(boolean hasMetaData) {
		model.setHasMetaData(hasMetaData);
	}

	/**
	 * Sets the modified date of this data set.
	 *
	 * @param modifiedDate the modified date of this data set
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this data set.
	 *
	 * @param name the name of this data set
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this data set.
	 *
	 * @param primaryKey the primary key of this data set
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this data set.
	 *
	 * @param status the status of this data set
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this data set.
	 *
	 * @param statusByUserId the status by user ID of this data set
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this data set.
	 *
	 * @param statusByUserName the status by user name of this data set
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this data set.
	 *
	 * @param statusByUserUuid the status by user uuid of this data set
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this data set.
	 *
	 * @param statusDate the status date of this data set
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this data set.
	 *
	 * @param userId the user ID of this data set
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data set.
	 *
	 * @param userName the user name of this data set
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data set.
	 *
	 * @param userUuid the user uuid of this data set
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this data set.
	 *
	 * @param uuid the uuid of this data set
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this data set.
	 *
	 * @param version the version of this data set
	 */
	@Override
	public void setVersion(String version) {
		model.setVersion(version);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DataSetWrapper wrap(DataSet dataSet) {
		return new DataSetWrapper(dataSet);
	}

}