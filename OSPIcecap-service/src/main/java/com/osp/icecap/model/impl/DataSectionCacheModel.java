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

import com.osp.icecap.model.DataSection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataSection in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
public class DataSectionCacheModel
	implements CacheModel<DataSection>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataSectionCacheModel)) {
			return false;
		}

		DataSectionCacheModel dataSectionCacheModel =
			(DataSectionCacheModel)obj;

		if (dataSectionId == dataSectionCacheModel.dataSectionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataSectionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataSectionId=");
		sb.append(dataSectionId);
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
		sb.append(", dataCollectionId=");
		sb.append(dataCollectionId);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", version=");
		sb.append(version);
		sb.append(", copiedFrom=");
		sb.append(copiedFrom);
		sb.append(", hasMetaData=");
		sb.append(hasMetaData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataSection toEntityModel() {
		DataSectionImpl dataSectionImpl = new DataSectionImpl();

		if (uuid == null) {
			dataSectionImpl.setUuid("");
		}
		else {
			dataSectionImpl.setUuid(uuid);
		}

		dataSectionImpl.setDataSectionId(dataSectionId);
		dataSectionImpl.setCompanyId(companyId);
		dataSectionImpl.setGroupId(groupId);
		dataSectionImpl.setUserId(userId);

		if (userName == null) {
			dataSectionImpl.setUserName("");
		}
		else {
			dataSectionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataSectionImpl.setCreateDate(null);
		}
		else {
			dataSectionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataSectionImpl.setModifiedDate(null);
		}
		else {
			dataSectionImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataSectionImpl.setStatus(status);
		dataSectionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataSectionImpl.setStatusByUserName("");
		}
		else {
			dataSectionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataSectionImpl.setStatusDate(null);
		}
		else {
			dataSectionImpl.setStatusDate(new Date(statusDate));
		}

		dataSectionImpl.setDataCollectionId(dataCollectionId);
		dataSectionImpl.setDataSetId(dataSetId);
		dataSectionImpl.setDataTypeId(dataTypeId);

		if (name == null) {
			dataSectionImpl.setName("");
		}
		else {
			dataSectionImpl.setName(name);
		}

		if (version == null) {
			dataSectionImpl.setVersion("");
		}
		else {
			dataSectionImpl.setVersion(version);
		}

		dataSectionImpl.setCopiedFrom(copiedFrom);
		dataSectionImpl.setHasMetaData(hasMetaData);

		dataSectionImpl.resetOriginalValues();

		return dataSectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataSectionId = objectInput.readLong();

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

		dataCollectionId = objectInput.readLong();

		dataSetId = objectInput.readLong();

		dataTypeId = objectInput.readLong();
		name = objectInput.readUTF();
		version = objectInput.readUTF();

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

		objectOutput.writeLong(dataSectionId);

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

		objectOutput.writeLong(dataCollectionId);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeLong(dataTypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeLong(copiedFrom);

		objectOutput.writeBoolean(hasMetaData);
	}

	public String uuid;
	public long dataSectionId;
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
	public long dataCollectionId;
	public long dataSetId;
	public long dataTypeId;
	public String name;
	public String version;
	public long copiedFrom;
	public boolean hasMetaData;

}