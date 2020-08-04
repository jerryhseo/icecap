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

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link DataPack}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataPack
 * @generated
 */
@ProviderType
public class DataPackWrapper
	extends BaseModelWrapper<DataPack>
	implements DataPack, ModelWrapper<DataPack> {

	public DataPackWrapper(DataPack dataPack) {
		super(dataPack);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dataPackId", getDataPackId());
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
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataSectionId", getDataSectionId());
		attributes.put("name", getName());
		attributes.put("version", getVersion());
		attributes.put("component", getComponent());
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

		Long dataPackId = (Long)attributes.get("dataPackId");

		if (dataPackId != null) {
			setDataPackId(dataPackId);
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

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataSectionId = (Long)attributes.get("dataSectionId");

		if (dataSectionId != null) {
			setDataSectionId(dataSectionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String component = (String)attributes.get("component");

		if (component != null) {
			setComponent(component);
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
	 * Returns the company ID of this data pack.
	 *
	 * @return the company ID of this data pack
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the component of this data pack.
	 *
	 * @return the component of this data pack
	 */
	@Override
	public String getComponent() {
		return model.getComponent();
	}

	/**
	 * Returns the copied from of this data pack.
	 *
	 * @return the copied from of this data pack
	 */
	@Override
	public long getCopiedFrom() {
		return model.getCopiedFrom();
	}

	/**
	 * Returns the create date of this data pack.
	 *
	 * @return the create date of this data pack
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data collection ID of this data pack.
	 *
	 * @return the data collection ID of this data pack
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the data pack ID of this data pack.
	 *
	 * @return the data pack ID of this data pack
	 */
	@Override
	public long getDataPackId() {
		return model.getDataPackId();
	}

	/**
	 * Returns the data section ID of this data pack.
	 *
	 * @return the data section ID of this data pack
	 */
	@Override
	public long getDataSectionId() {
		return model.getDataSectionId();
	}

	/**
	 * Returns the data set ID of this data pack.
	 *
	 * @return the data set ID of this data pack
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the group ID of this data pack.
	 *
	 * @return the group ID of this data pack
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has meta data of this data pack.
	 *
	 * @return the has meta data of this data pack
	 */
	@Override
	public boolean getHasMetaData() {
		return model.getHasMetaData();
	}

	/**
	 * Returns the modified date of this data pack.
	 *
	 * @return the modified date of this data pack
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this data pack.
	 *
	 * @return the name of this data pack
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this data pack.
	 *
	 * @return the primary key of this data pack
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this data pack.
	 *
	 * @return the status of this data pack
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this data pack.
	 *
	 * @return the status by user ID of this data pack
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this data pack.
	 *
	 * @return the status by user name of this data pack
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this data pack.
	 *
	 * @return the status by user uuid of this data pack
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this data pack.
	 *
	 * @return the status date of this data pack
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this data pack.
	 *
	 * @return the user ID of this data pack
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data pack.
	 *
	 * @return the user name of this data pack
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data pack.
	 *
	 * @return the user uuid of this data pack
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this data pack.
	 *
	 * @return the uuid of this data pack
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this data pack.
	 *
	 * @return the version of this data pack
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this data pack is approved.
	 *
	 * @return <code>true</code> if this data pack is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this data pack is denied.
	 *
	 * @return <code>true</code> if this data pack is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this data pack is a draft.
	 *
	 * @return <code>true</code> if this data pack is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this data pack is expired.
	 *
	 * @return <code>true</code> if this data pack is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this data pack is has meta data.
	 *
	 * @return <code>true</code> if this data pack is has meta data; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasMetaData() {
		return model.isHasMetaData();
	}

	/**
	 * Returns <code>true</code> if this data pack is inactive.
	 *
	 * @return <code>true</code> if this data pack is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this data pack is incomplete.
	 *
	 * @return <code>true</code> if this data pack is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this data pack is pending.
	 *
	 * @return <code>true</code> if this data pack is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this data pack is scheduled.
	 *
	 * @return <code>true</code> if this data pack is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this data pack.
	 *
	 * @param companyId the company ID of this data pack
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the component of this data pack.
	 *
	 * @param component the component of this data pack
	 */
	@Override
	public void setComponent(String component) {
		model.setComponent(component);
	}

	/**
	 * Sets the copied from of this data pack.
	 *
	 * @param copiedFrom the copied from of this data pack
	 */
	@Override
	public void setCopiedFrom(long copiedFrom) {
		model.setCopiedFrom(copiedFrom);
	}

	/**
	 * Sets the create date of this data pack.
	 *
	 * @param createDate the create date of this data pack
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data collection ID of this data pack.
	 *
	 * @param dataCollectionId the data collection ID of this data pack
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the data pack ID of this data pack.
	 *
	 * @param dataPackId the data pack ID of this data pack
	 */
	@Override
	public void setDataPackId(long dataPackId) {
		model.setDataPackId(dataPackId);
	}

	/**
	 * Sets the data section ID of this data pack.
	 *
	 * @param dataSectionId the data section ID of this data pack
	 */
	@Override
	public void setDataSectionId(long dataSectionId) {
		model.setDataSectionId(dataSectionId);
	}

	/**
	 * Sets the data set ID of this data pack.
	 *
	 * @param dataSetId the data set ID of this data pack
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the group ID of this data pack.
	 *
	 * @param groupId the group ID of this data pack
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this data pack is has meta data.
	 *
	 * @param hasMetaData the has meta data of this data pack
	 */
	@Override
	public void setHasMetaData(boolean hasMetaData) {
		model.setHasMetaData(hasMetaData);
	}

	/**
	 * Sets the modified date of this data pack.
	 *
	 * @param modifiedDate the modified date of this data pack
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this data pack.
	 *
	 * @param name the name of this data pack
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this data pack.
	 *
	 * @param primaryKey the primary key of this data pack
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this data pack.
	 *
	 * @param status the status of this data pack
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this data pack.
	 *
	 * @param statusByUserId the status by user ID of this data pack
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this data pack.
	 *
	 * @param statusByUserName the status by user name of this data pack
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this data pack.
	 *
	 * @param statusByUserUuid the status by user uuid of this data pack
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this data pack.
	 *
	 * @param statusDate the status date of this data pack
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this data pack.
	 *
	 * @param userId the user ID of this data pack
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data pack.
	 *
	 * @param userName the user name of this data pack
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data pack.
	 *
	 * @param userUuid the user uuid of this data pack
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this data pack.
	 *
	 * @param uuid the uuid of this data pack
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this data pack.
	 *
	 * @param version the version of this data pack
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
	protected DataPackWrapper wrap(DataPack dataPack) {
		return new DataPackWrapper(dataPack);
	}

}