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

		attributes.put("dataEntryId", getDataEntryId());
		attributes.put("dataCollectionName", getDataCollectionName());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("path", getPath());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("recordCount", getRecordCount());
		attributes.put("sequenceDelimeter", getSequenceDelimeter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataEntryId = (Long)attributes.get("dataEntryId");

		if (dataEntryId != null) {
			setDataEntryId(dataEntryId);
		}

		String dataCollectionName = (String)attributes.get(
			"dataCollectionName");

		if (dataCollectionName != null) {
			setDataCollectionName(dataCollectionName);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Integer sequenceNo = (Integer)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		Integer recordCount = (Integer)attributes.get("recordCount");

		if (recordCount != null) {
			setRecordCount(recordCount);
		}

		String sequenceDelimeter = (String)attributes.get("sequenceDelimeter");

		if (sequenceDelimeter != null) {
			setSequenceDelimeter(sequenceDelimeter);
		}
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
	 * Returns the create date of this data entry.
	 *
	 * @return the create date of this data entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data collection name of this data entry.
	 *
	 * @return the data collection name of this data entry
	 */
	@Override
	public String getDataCollectionName() {
		return model.getDataCollectionName();
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
	 * Returns the group ID of this data entry.
	 *
	 * @return the group ID of this data entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the path of this data entry.
	 *
	 * @return the path of this data entry
	 */
	@Override
	public String getPath() {
		return model.getPath();
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
	 * Returns the record count of this data entry.
	 *
	 * @return the record count of this data entry
	 */
	@Override
	public int getRecordCount() {
		return model.getRecordCount();
	}

	/**
	 * Returns the sequence delimeter of this data entry.
	 *
	 * @return the sequence delimeter of this data entry
	 */
	@Override
	public String getSequenceDelimeter() {
		return model.getSequenceDelimeter();
	}

	/**
	 * Returns the sequence no of this data entry.
	 *
	 * @return the sequence no of this data entry
	 */
	@Override
	public int getSequenceNo() {
		return model.getSequenceNo();
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
	 * Returns the user uuid of this data entry.
	 *
	 * @return the user uuid of this data entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
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
	 * Sets the create date of this data entry.
	 *
	 * @param createDate the create date of this data entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data collection name of this data entry.
	 *
	 * @param dataCollectionName the data collection name of this data entry
	 */
	@Override
	public void setDataCollectionName(String dataCollectionName) {
		model.setDataCollectionName(dataCollectionName);
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
	 * Sets the group ID of this data entry.
	 *
	 * @param groupId the group ID of this data entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the path of this data entry.
	 *
	 * @param path the path of this data entry
	 */
	@Override
	public void setPath(String path) {
		model.setPath(path);
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
	 * Sets the record count of this data entry.
	 *
	 * @param recordCount the record count of this data entry
	 */
	@Override
	public void setRecordCount(int recordCount) {
		model.setRecordCount(recordCount);
	}

	/**
	 * Sets the sequence delimeter of this data entry.
	 *
	 * @param sequenceDelimeter the sequence delimeter of this data entry
	 */
	@Override
	public void setSequenceDelimeter(String sequenceDelimeter) {
		model.setSequenceDelimeter(sequenceDelimeter);
	}

	/**
	 * Sets the sequence no of this data entry.
	 *
	 * @param sequenceNo the sequence no of this data entry
	 */
	@Override
	public void setSequenceNo(int sequenceNo) {
		model.setSequenceNo(sequenceNo);
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
	 * Sets the user uuid of this data entry.
	 *
	 * @param userUuid the user uuid of this data entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DataEntryWrapper wrap(DataEntry dataEntry) {
		return new DataEntryWrapper(dataEntry);
	}

}