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

import com.osp.icecap.model.DataType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataType in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
public class DataTypeCacheModel
	implements CacheModel<DataType>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataTypeCacheModel)) {
			return false;
		}

		DataTypeCacheModel dataTypeCacheModel = (DataTypeCacheModel)obj;

		if (dataTypeId == dataTypeCacheModel.dataTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
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
		sb.append(", version=");
		sb.append(version);
		sb.append(", extension=");
		sb.append(extension);
		sb.append(", samplePath=");
		sb.append(samplePath);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataType toEntityModel() {
		DataTypeImpl dataTypeImpl = new DataTypeImpl();

		if (uuid == null) {
			dataTypeImpl.setUuid("");
		}
		else {
			dataTypeImpl.setUuid(uuid);
		}

		dataTypeImpl.setDataTypeId(dataTypeId);
		dataTypeImpl.setCompanyId(companyId);
		dataTypeImpl.setGroupId(groupId);
		dataTypeImpl.setUserId(userId);

		if (userName == null) {
			dataTypeImpl.setUserName("");
		}
		else {
			dataTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataTypeImpl.setCreateDate(null);
		}
		else {
			dataTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataTypeImpl.setModifiedDate(null);
		}
		else {
			dataTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataTypeImpl.setStatus(status);

		if (name == null) {
			dataTypeImpl.setName("");
		}
		else {
			dataTypeImpl.setName(name);
		}

		if (version == null) {
			dataTypeImpl.setVersion("");
		}
		else {
			dataTypeImpl.setVersion(version);
		}

		if (extension == null) {
			dataTypeImpl.setExtension("");
		}
		else {
			dataTypeImpl.setExtension(extension);
		}

		if (samplePath == null) {
			dataTypeImpl.setSamplePath("");
		}
		else {
			dataTypeImpl.setSamplePath(samplePath);
		}

		if (description == null) {
			dataTypeImpl.setDescription("");
		}
		else {
			dataTypeImpl.setDescription(description);
		}

		dataTypeImpl.resetOriginalValues();

		return dataTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataTypeId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();
		name = objectInput.readUTF();
		version = objectInput.readUTF();
		extension = objectInput.readUTF();
		samplePath = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dataTypeId);

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

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (extension == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(extension);
		}

		if (samplePath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(samplePath);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long dataTypeId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public String name;
	public String version;
	public String extension;
	public String samplePath;
	public String description;

}