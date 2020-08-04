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

import com.osp.icecap.model.DataPack;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing DataPack in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataPackCacheModel
	implements CacheModel<DataPack>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataPackCacheModel)) {
			return false;
		}

		DataPackCacheModel dataPackCacheModel = (DataPackCacheModel)obj;

		if (dataPackId == dataPackCacheModel.dataPackId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataPackId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataPackId=");
		sb.append(dataPackId);
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
		sb.append(", dataSectionId=");
		sb.append(dataSectionId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", version=");
		sb.append(version);
		sb.append(", component=");
		sb.append(component);
		sb.append(", copiedFrom=");
		sb.append(copiedFrom);
		sb.append(", hasMetaData=");
		sb.append(hasMetaData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataPack toEntityModel() {
		DataPackImpl dataPackImpl = new DataPackImpl();

		if (uuid == null) {
			dataPackImpl.setUuid("");
		}
		else {
			dataPackImpl.setUuid(uuid);
		}

		dataPackImpl.setDataPackId(dataPackId);
		dataPackImpl.setCompanyId(companyId);
		dataPackImpl.setGroupId(groupId);
		dataPackImpl.setUserId(userId);

		if (userName == null) {
			dataPackImpl.setUserName("");
		}
		else {
			dataPackImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataPackImpl.setCreateDate(null);
		}
		else {
			dataPackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataPackImpl.setModifiedDate(null);
		}
		else {
			dataPackImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataPackImpl.setStatus(status);
		dataPackImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataPackImpl.setStatusByUserName("");
		}
		else {
			dataPackImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataPackImpl.setStatusDate(null);
		}
		else {
			dataPackImpl.setStatusDate(new Date(statusDate));
		}

		dataPackImpl.setDataCollectionId(dataCollectionId);
		dataPackImpl.setDataSetId(dataSetId);
		dataPackImpl.setDataSectionId(dataSectionId);

		if (name == null) {
			dataPackImpl.setName("");
		}
		else {
			dataPackImpl.setName(name);
		}

		if (version == null) {
			dataPackImpl.setVersion("");
		}
		else {
			dataPackImpl.setVersion(version);
		}

		if (component == null) {
			dataPackImpl.setComponent("");
		}
		else {
			dataPackImpl.setComponent(component);
		}

		dataPackImpl.setCopiedFrom(copiedFrom);
		dataPackImpl.setHasMetaData(hasMetaData);

		dataPackImpl.resetOriginalValues();

		return dataPackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataPackId = objectInput.readLong();

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

		dataSectionId = objectInput.readLong();
		name = objectInput.readUTF();
		version = objectInput.readUTF();
		component = objectInput.readUTF();

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

		objectOutput.writeLong(dataPackId);

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

		objectOutput.writeLong(dataSectionId);

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

		if (component == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(component);
		}

		objectOutput.writeLong(copiedFrom);

		objectOutput.writeBoolean(hasMetaData);
	}

	public String uuid;
	public long dataPackId;
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
	public long dataSectionId;
	public String name;
	public String version;
	public String component;
	public long copiedFrom;
	public boolean hasMetaData;

}