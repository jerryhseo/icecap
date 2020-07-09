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
		StringBundler sb = new StringBundler(33);

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
		sb.append(", name=");
		sb.append(name);
		sb.append(", variantFrom=");
		sb.append(variantFrom);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", storageType=");
		sb.append(storageType);
		sb.append(", dataTypeName=");
		sb.append(dataTypeName);
		sb.append(", dataTypeVersion=");
		sb.append(dataTypeVersion);
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

		if (name == null) {
			dataCollectionImpl.setName("");
		}
		else {
			dataCollectionImpl.setName(name);
		}

		dataCollectionImpl.setVariantFrom(variantFrom);

		if (title == null) {
			dataCollectionImpl.setTitle("");
		}
		else {
			dataCollectionImpl.setTitle(title);
		}

		if (description == null) {
			dataCollectionImpl.setDescription("");
		}
		else {
			dataCollectionImpl.setDescription(description);
		}

		if (storageType == null) {
			dataCollectionImpl.setStorageType("");
		}
		else {
			dataCollectionImpl.setStorageType(storageType);
		}

		dataCollectionImpl.setDataTypeName(dataTypeName);
		dataCollectionImpl.setDataTypeVersion(dataTypeVersion);

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
		name = objectInput.readUTF();

		variantFrom = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		storageType = objectInput.readUTF();

		dataTypeName = objectInput.readLong();

		dataTypeVersion = objectInput.readLong();
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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(variantFrom);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (storageType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(storageType);
		}

		objectOutput.writeLong(dataTypeName);

		objectOutput.writeLong(dataTypeVersion);
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
	public String name;
	public long variantFrom;
	public String title;
	public String description;
	public String storageType;
	public long dataTypeName;
	public long dataTypeVersion;

}