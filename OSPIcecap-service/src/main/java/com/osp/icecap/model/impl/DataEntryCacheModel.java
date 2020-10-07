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

package com.osp.icecap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.osp.icecap.model.DataEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataEntry in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
public class DataEntryCacheModel
	implements CacheModel<DataEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataEntryCacheModel)) {
			return false;
		}

		DataEntryCacheModel dataEntryCacheModel = (DataEntryCacheModel)obj;

		if (dataEntryId == dataEntryCacheModel.dataEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataEntryId=");
		sb.append(dataEntryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", dataPackId=");
		sb.append(dataPackId);
		sb.append(", dataSectionId=");
		sb.append(dataSectionId);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataCollectionId=");
		sb.append(dataCollectionId);
		sb.append(", accessURL=");
		sb.append(accessURL);
		sb.append(", sequenceId=");
		sb.append(sequenceId);
		sb.append(", accessType=");
		sb.append(accessType);
		sb.append(", copiedFrom=");
		sb.append(copiedFrom);
		sb.append(", hasMetaData=");
		sb.append(hasMetaData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataEntry toEntityModel() {
		DataEntryImpl dataEntryImpl = new DataEntryImpl();

		if (uuid == null) {
			dataEntryImpl.setUuid("");
		}
		else {
			dataEntryImpl.setUuid(uuid);
		}

		dataEntryImpl.setDataEntryId(dataEntryId);
		dataEntryImpl.setCompanyId(companyId);
		dataEntryImpl.setGroupId(groupId);
		dataEntryImpl.setUserId(userId);

		if (userName == null) {
			dataEntryImpl.setUserName("");
		}
		else {
			dataEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataEntryImpl.setCreateDate(null);
		}
		else {
			dataEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataEntryImpl.setModifiedDate(null);
		}
		else {
			dataEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataEntryImpl.setStatus(status);
		dataEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataEntryImpl.setStatusByUserName("");
		}
		else {
			dataEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataEntryImpl.setStatusDate(null);
		}
		else {
			dataEntryImpl.setStatusDate(new Date(statusDate));
		}

		dataEntryImpl.setDataTypeId(dataTypeId);
		dataEntryImpl.setDataPackId(dataPackId);
		dataEntryImpl.setDataSectionId(dataSectionId);
		dataEntryImpl.setDataSetId(dataSetId);
		dataEntryImpl.setDataCollectionId(dataCollectionId);

		if (accessURL == null) {
			dataEntryImpl.setAccessURL("");
		}
		else {
			dataEntryImpl.setAccessURL(accessURL);
		}

		if (sequenceId == null) {
			dataEntryImpl.setSequenceId("");
		}
		else {
			dataEntryImpl.setSequenceId(sequenceId);
		}

		if (accessType == null) {
			dataEntryImpl.setAccessType("");
		}
		else {
			dataEntryImpl.setAccessType(accessType);
		}

		dataEntryImpl.setCopiedFrom(copiedFrom);
		dataEntryImpl.setHasMetaData(hasMetaData);

		dataEntryImpl.resetOriginalValues();

		return dataEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataEntryId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		dataTypeId = objectInput.readLong();

		dataPackId = objectInput.readLong();

		dataSectionId = objectInput.readLong();

		dataSetId = objectInput.readLong();

		dataCollectionId = objectInput.readLong();
		accessURL = objectInput.readUTF();
		sequenceId = objectInput.readUTF();
		accessType = objectInput.readUTF();

		copiedFrom = objectInput.readLong();

		hasMetaData = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dataEntryId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(dataTypeId);

		objectOutput.writeLong(dataPackId);

		objectOutput.writeLong(dataSectionId);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeLong(dataCollectionId);

		if (accessURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accessURL);
		}

		if (sequenceId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sequenceId);
		}

		if (accessType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accessType);
		}

		objectOutput.writeLong(copiedFrom);

		objectOutput.writeBoolean(hasMetaData);
	}

	public String uuid;
	public long dataEntryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long dataTypeId;
	public long dataPackId;
	public long dataSectionId;
	public long dataSetId;
	public long dataCollectionId;
	public String accessURL;
	public String sequenceId;
	public String accessType;
	public long copiedFrom;
	public boolean hasMetaData;

}