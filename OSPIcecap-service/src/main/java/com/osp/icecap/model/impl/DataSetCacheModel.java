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

import com.osp.icecap.model.DataSet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing DataSet in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataSetCacheModel implements CacheModel<DataSet>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataSetCacheModel)) {
			return false;
		}

		DataSetCacheModel dataSetCacheModel = (DataSetCacheModel)obj;

		if (dataSetId == dataSetCacheModel.dataSetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataSetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", version=");
		sb.append(version);
		sb.append(", description=");
		sb.append(description);
		sb.append(", copiedFrom=");
		sb.append(copiedFrom);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataSet toEntityModel() {
		DataSetImpl dataSetImpl = new DataSetImpl();

		if (uuid == null) {
			dataSetImpl.setUuid("");
		}
		else {
			dataSetImpl.setUuid(uuid);
		}

		dataSetImpl.setDataSetId(dataSetId);
		dataSetImpl.setCompanyId(companyId);
		dataSetImpl.setGroupId(groupId);
		dataSetImpl.setUserId(userId);

		if (userName == null) {
			dataSetImpl.setUserName("");
		}
		else {
			dataSetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataSetImpl.setCreateDate(null);
		}
		else {
			dataSetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataSetImpl.setModifiedDate(null);
		}
		else {
			dataSetImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataSetImpl.setStatus(status);
		dataSetImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataSetImpl.setStatusByUserName("");
		}
		else {
			dataSetImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataSetImpl.setStatusDate(null);
		}
		else {
			dataSetImpl.setStatusDate(new Date(statusDate));
		}

		dataSetImpl.setDataCollectionId(dataCollectionId);

		if (title == null) {
			dataSetImpl.setTitle("");
		}
		else {
			dataSetImpl.setTitle(title);
		}

		if (version == null) {
			dataSetImpl.setVersion("");
		}
		else {
			dataSetImpl.setVersion(version);
		}

		if (description == null) {
			dataSetImpl.setDescription("");
		}
		else {
			dataSetImpl.setDescription(description);
		}

		dataSetImpl.setCopiedFrom(copiedFrom);

		dataSetImpl.resetOriginalValues();

		return dataSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataSetId = objectInput.readLong();

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
		title = objectInput.readUTF();
		version = objectInput.readUTF();
		description = objectInput.readUTF();

		copiedFrom = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dataSetId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(copiedFrom);
	}

	public String uuid;
	public long dataSetId;
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
	public String title;
	public String version;
	public String description;
	public long copiedFrom;

}