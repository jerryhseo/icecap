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
 * This class is a wrapper for {@link DataCollection}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataCollection
 * @generated
 */
@ProviderType
public class DataCollectionWrapper
	extends BaseModelWrapper<DataCollection>
	implements DataCollection, ModelWrapper<DataCollection> {

	public DataCollectionWrapper(DataCollection dataCollection) {
		super(dataCollection);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dataCollectionId", getDataCollectionId());
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
		attributes.put("name", getName());
		attributes.put("version", getVersion());
		attributes.put("copiedFrom", getCopiedFrom());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("hasMetaData", isHasMetaData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dataCollectionId = (Long)attributes.get("dataCollectionId");

		if (dataCollectionId != null) {
			setDataCollectionId(dataCollectionId);
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

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Boolean hasMetaData = (Boolean)attributes.get("hasMetaData");

		if (hasMetaData != null) {
			setHasMetaData(hasMetaData);
		}
	}

	/**
	 * Returns the company ID of this data collection.
	 *
	 * @return the company ID of this data collection
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the copied from of this data collection.
	 *
	 * @return the copied from of this data collection
	 */
	@Override
	public long getCopiedFrom() {
		return model.getCopiedFrom();
	}

	/**
	 * Returns the create date of this data collection.
	 *
	 * @return the create date of this data collection
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data collection ID of this data collection.
	 *
	 * @return the data collection ID of this data collection
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the group ID of this data collection.
	 *
	 * @return the group ID of this data collection
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has meta data of this data collection.
	 *
	 * @return the has meta data of this data collection
	 */
	@Override
	public boolean getHasMetaData() {
		return model.getHasMetaData();
	}

	/**
	 * Returns the modified date of this data collection.
	 *
	 * @return the modified date of this data collection
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this data collection.
	 *
	 * @return the name of this data collection
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the organization ID of this data collection.
	 *
	 * @return the organization ID of this data collection
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this data collection.
	 *
	 * @return the primary key of this data collection
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this data collection.
	 *
	 * @return the status of this data collection
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this data collection.
	 *
	 * @return the status by user ID of this data collection
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this data collection.
	 *
	 * @return the status by user name of this data collection
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this data collection.
	 *
	 * @return the status by user uuid of this data collection
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this data collection.
	 *
	 * @return the status date of this data collection
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this data collection.
	 *
	 * @return the user ID of this data collection
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data collection.
	 *
	 * @return the user name of this data collection
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data collection.
	 *
	 * @return the user uuid of this data collection
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this data collection.
	 *
	 * @return the uuid of this data collection
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version of this data collection.
	 *
	 * @return the version of this data collection
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this data collection is approved.
	 *
	 * @return <code>true</code> if this data collection is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this data collection is denied.
	 *
	 * @return <code>true</code> if this data collection is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this data collection is a draft.
	 *
	 * @return <code>true</code> if this data collection is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this data collection is expired.
	 *
	 * @return <code>true</code> if this data collection is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this data collection is has meta data.
	 *
	 * @return <code>true</code> if this data collection is has meta data; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasMetaData() {
		return model.isHasMetaData();
	}

	/**
	 * Returns <code>true</code> if this data collection is inactive.
	 *
	 * @return <code>true</code> if this data collection is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this data collection is incomplete.
	 *
	 * @return <code>true</code> if this data collection is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this data collection is pending.
	 *
	 * @return <code>true</code> if this data collection is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this data collection is scheduled.
	 *
	 * @return <code>true</code> if this data collection is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this data collection.
	 *
	 * @param companyId the company ID of this data collection
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the copied from of this data collection.
	 *
	 * @param copiedFrom the copied from of this data collection
	 */
	@Override
	public void setCopiedFrom(long copiedFrom) {
		model.setCopiedFrom(copiedFrom);
	}

	/**
	 * Sets the create date of this data collection.
	 *
	 * @param createDate the create date of this data collection
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data collection ID of this data collection.
	 *
	 * @param dataCollectionId the data collection ID of this data collection
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the group ID of this data collection.
	 *
	 * @param groupId the group ID of this data collection
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this data collection is has meta data.
	 *
	 * @param hasMetaData the has meta data of this data collection
	 */
	@Override
	public void setHasMetaData(boolean hasMetaData) {
		model.setHasMetaData(hasMetaData);
	}

	/**
	 * Sets the modified date of this data collection.
	 *
	 * @param modifiedDate the modified date of this data collection
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this data collection.
	 *
	 * @param name the name of this data collection
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the organization ID of this data collection.
	 *
	 * @param organizationId the organization ID of this data collection
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this data collection.
	 *
	 * @param primaryKey the primary key of this data collection
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this data collection.
	 *
	 * @param status the status of this data collection
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this data collection.
	 *
	 * @param statusByUserId the status by user ID of this data collection
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this data collection.
	 *
	 * @param statusByUserName the status by user name of this data collection
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this data collection.
	 *
	 * @param statusByUserUuid the status by user uuid of this data collection
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this data collection.
	 *
	 * @param statusDate the status date of this data collection
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this data collection.
	 *
	 * @param userId the user ID of this data collection
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data collection.
	 *
	 * @param userName the user name of this data collection
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data collection.
	 *
	 * @param userUuid the user uuid of this data collection
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this data collection.
	 *
	 * @param uuid the uuid of this data collection
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version of this data collection.
	 *
	 * @param version the version of this data collection
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
	protected DataCollectionWrapper wrap(DataCollection dataCollection) {
		return new DataCollectionWrapper(dataCollection);
	}

}