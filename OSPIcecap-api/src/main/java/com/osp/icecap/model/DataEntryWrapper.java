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
 * This class is a wrapper for {@link DataEntry}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataEntry
 * @generated
 */
@ProviderType
public class DataEntryWrapper
	extends BaseModelWrapper<DataEntry>
	implements DataEntry, ModelWrapper<DataEntry> {

	public DataEntryWrapper(DataEntry dataEntry) {
		super(dataEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dataEntryId", getDataEntryId());
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
		attributes.put("dataPackId", getDataPackId());
		attributes.put("dataSectionId", getDataSectionId());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataCollectionId", getDataCollectionId());
		attributes.put("accessURL", getAccessURL());
		attributes.put("pathType", getPathType());
		attributes.put("copiedFrom", getCopiedFrom());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dataEntryId = (Long)attributes.get("dataEntryId");

		if (dataEntryId != null) {
			setDataEntryId(dataEntryId);
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

		Long dataPackId = (Long)attributes.get("dataPackId");

		if (dataPackId != null) {
			setDataPackId(dataPackId);
		}

		Long dataSectionId = (Long)attributes.get("dataSectionId");

		if (dataSectionId != null) {
			setDataSectionId(dataSectionId);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataCollectionId = (Long)attributes.get("dataCollectionId");

		if (dataCollectionId != null) {
			setDataCollectionId(dataCollectionId);
		}

		String accessURL = (String)attributes.get("accessURL");

		if (accessURL != null) {
			setAccessURL(accessURL);
		}

		String pathType = (String)attributes.get("pathType");

		if (pathType != null) {
			setPathType(pathType);
		}

		Long copiedFrom = (Long)attributes.get("copiedFrom");

		if (copiedFrom != null) {
			setCopiedFrom(copiedFrom);
		}
	}

	/**
	 * Returns the access url of this data entry.
	 *
	 * @return the access url of this data entry
	 */
	@Override
	public String getAccessURL() {
		return model.getAccessURL();
	}

	/**
	 * Returns the company ID of this data entry.
	 *
	 * @return the company ID of this data entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the copied from of this data entry.
	 *
	 * @return the copied from of this data entry
	 */
	@Override
	public long getCopiedFrom() {
		return model.getCopiedFrom();
	}

	/**
	 * Returns the create date of this data entry.
	 *
	 * @return the create date of this data entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data collection ID of this data entry.
	 *
	 * @return the data collection ID of this data entry
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the data entry ID of this data entry.
	 *
	 * @return the data entry ID of this data entry
	 */
	@Override
	public long getDataEntryId() {
		return model.getDataEntryId();
	}

	/**
	 * Returns the data pack ID of this data entry.
	 *
	 * @return the data pack ID of this data entry
	 */
	@Override
	public long getDataPackId() {
		return model.getDataPackId();
	}

	/**
	 * Returns the data section ID of this data entry.
	 *
	 * @return the data section ID of this data entry
	 */
	@Override
	public long getDataSectionId() {
		return model.getDataSectionId();
	}

	/**
	 * Returns the data set ID of this data entry.
	 *
	 * @return the data set ID of this data entry
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the group ID of this data entry.
	 *
	 * @return the group ID of this data entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this data entry.
	 *
	 * @return the modified date of this data entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the path type of this data entry.
	 *
	 * @return the path type of this data entry
	 */
	@Override
	public String getPathType() {
		return model.getPathType();
	}

	/**
	 * Returns the primary key of this data entry.
	 *
	 * @return the primary key of this data entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this data entry.
	 *
	 * @return the status of this data entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this data entry.
	 *
	 * @return the status by user ID of this data entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this data entry.
	 *
	 * @return the status by user name of this data entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this data entry.
	 *
	 * @return the status by user uuid of this data entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this data entry.
	 *
	 * @return the status date of this data entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this data entry.
	 *
	 * @return the user ID of this data entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data entry.
	 *
	 * @return the user name of this data entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data entry.
	 *
	 * @return the user uuid of this data entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this data entry.
	 *
	 * @return the uuid of this data entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this data entry is approved.
	 *
	 * @return <code>true</code> if this data entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this data entry is denied.
	 *
	 * @return <code>true</code> if this data entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this data entry is a draft.
	 *
	 * @return <code>true</code> if this data entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this data entry is expired.
	 *
	 * @return <code>true</code> if this data entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this data entry is inactive.
	 *
	 * @return <code>true</code> if this data entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this data entry is incomplete.
	 *
	 * @return <code>true</code> if this data entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this data entry is pending.
	 *
	 * @return <code>true</code> if this data entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this data entry is scheduled.
	 *
	 * @return <code>true</code> if this data entry is scheduled; <code>false</code> otherwise
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
	 * Sets the access url of this data entry.
	 *
	 * @param accessURL the access url of this data entry
	 */
	@Override
	public void setAccessURL(String accessURL) {
		model.setAccessURL(accessURL);
	}

	/**
	 * Sets the company ID of this data entry.
	 *
	 * @param companyId the company ID of this data entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the copied from of this data entry.
	 *
	 * @param copiedFrom the copied from of this data entry
	 */
	@Override
	public void setCopiedFrom(long copiedFrom) {
		model.setCopiedFrom(copiedFrom);
	}

	/**
	 * Sets the create date of this data entry.
	 *
	 * @param createDate the create date of this data entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data collection ID of this data entry.
	 *
	 * @param dataCollectionId the data collection ID of this data entry
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the data entry ID of this data entry.
	 *
	 * @param dataEntryId the data entry ID of this data entry
	 */
	@Override
	public void setDataEntryId(long dataEntryId) {
		model.setDataEntryId(dataEntryId);
	}

	/**
	 * Sets the data pack ID of this data entry.
	 *
	 * @param dataPackId the data pack ID of this data entry
	 */
	@Override
	public void setDataPackId(long dataPackId) {
		model.setDataPackId(dataPackId);
	}

	/**
	 * Sets the data section ID of this data entry.
	 *
	 * @param dataSectionId the data section ID of this data entry
	 */
	@Override
	public void setDataSectionId(long dataSectionId) {
		model.setDataSectionId(dataSectionId);
	}

	/**
	 * Sets the data set ID of this data entry.
	 *
	 * @param dataSetId the data set ID of this data entry
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the group ID of this data entry.
	 *
	 * @param groupId the group ID of this data entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this data entry.
	 *
	 * @param modifiedDate the modified date of this data entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the path type of this data entry.
	 *
	 * @param pathType the path type of this data entry
	 */
	@Override
	public void setPathType(String pathType) {
		model.setPathType(pathType);
	}

	/**
	 * Sets the primary key of this data entry.
	 *
	 * @param primaryKey the primary key of this data entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this data entry.
	 *
	 * @param status the status of this data entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this data entry.
	 *
	 * @param statusByUserId the status by user ID of this data entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this data entry.
	 *
	 * @param statusByUserName the status by user name of this data entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this data entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this data entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this data entry.
	 *
	 * @param statusDate the status date of this data entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this data entry.
	 *
	 * @param userId the user ID of this data entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data entry.
	 *
	 * @param userName the user name of this data entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data entry.
	 *
	 * @param userUuid the user uuid of this data entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this data entry.
	 *
	 * @param uuid the uuid of this data entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DataEntryWrapper wrap(DataEntry dataEntry) {
		return new DataEntryWrapper(dataEntry);
	}

}