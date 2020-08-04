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

import com.osp.icecap.model.DataCollection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing DataCollection in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataCollectionCacheModel
	implements CacheModel<DataCollection>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataCollectionCacheModel)) {
			return false;
		}

		DataCollectionCacheModel dataCollectionCacheModel =
			(DataCollectionCacheModel)obj;

		if (dataCollectionId == dataCollectionCacheModel.dataCollectionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataCollectionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataCollectionId=");
		sb.append(dataCollectionId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", version=");
		sb.append(version);
		sb.append(", copiedFrom=");
		sb.append(copiedFrom);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", hasMetaData=");
		sb.append(hasMetaData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataCollection toEntityModel() {
		DataCollectionImpl dataCollectionImpl = new DataCollectionImpl();

		if (uuid == null) {
			dataCollectionImpl.setUuid("");
		}
		else {
			dataCollectionImpl.setUuid(uuid);
		}

		dataCollectionImpl.setDataCollectionId(dataCollectionId);
		dataCollectionImpl.setCompanyId(companyId);
		dataCollectionImpl.setGroupId(groupId);
		dataCollectionImpl.setUserId(userId);

		if (userName == null) {
			dataCollectionImpl.setUserName("");
		}
		else {
			dataCollectionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataCollectionImpl.setCreateDate(null);
		}
		else {
			dataCollectionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataCollectionImpl.setModifiedDate(null);
		}
		else {
			dataCollectionImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataCollectionImpl.setStatus(status);
		dataCollectionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataCollectionImpl.setStatusByUserName("");
		}
		else {
			dataCollectionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataCollectionImpl.setStatusDate(null);
		}
		else {
			dataCollectionImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			dataCollectionImpl.setName("");
		}
		else {
			dataCollectionImpl.setName(name);
		}

		if (version == null) {
			dataCollectionImpl.setVersion("");
		}
		else {
			dataCollectionImpl.setVersion(version);
		}

		dataCollectionImpl.setCopiedFrom(copiedFrom);
		dataCollectionImpl.setOrganizationId(organizationId);
		dataCollectionImpl.setHasMetaData(hasMetaData);

		dataCollectionImpl.resetOriginalValues();

		return dataCollectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataCollectionId = objectInput.readLong();

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
		name = objectInput.readUTF();
		version = objectInput.readUTF();

		copiedFrom = objectInput.readLong();

		organizationId = objectInput.readLong();

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

		objectOutput.writeLong(dataCollectionId);

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

		objectOutput.writeLong(organizationId);

		objectOutput.writeBoolean(hasMetaData);
	}

	public String uuid;
	public long dataCollectionId;
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
	public String name;
	public String version;
	public long copiedFrom;
	public long organizationId;
	public boolean hasMetaData;

}