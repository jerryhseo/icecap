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

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing DataEntry in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
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
		StringBundler sb = new StringBundler(21);

		sb.append("{dataEntryId=");
		sb.append(dataEntryId);
		sb.append(", dataCollectionName=");
		sb.append(dataCollectionName);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", path=");
		sb.append(path);
		sb.append(", sequenceNo=");
		sb.append(sequenceNo);
		sb.append(", recordCount=");
		sb.append(recordCount);
		sb.append(", sequenceDelimeter=");
		sb.append(sequenceDelimeter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataEntry toEntityModel() {
		DataEntryImpl dataEntryImpl = new DataEntryImpl();

		dataEntryImpl.setDataEntryId(dataEntryId);

		if (dataCollectionName == null) {
			dataEntryImpl.setDataCollectionName("");
		}
		else {
			dataEntryImpl.setDataCollectionName(dataCollectionName);
		}

		dataEntryImpl.setCompanyId(companyId);
		dataEntryImpl.setGroupId(groupId);
		dataEntryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dataEntryImpl.setCreateDate(null);
		}
		else {
			dataEntryImpl.setCreateDate(new Date(createDate));
		}

		if (path == null) {
			dataEntryImpl.setPath("");
		}
		else {
			dataEntryImpl.setPath(path);
		}

		dataEntryImpl.setSequenceNo(sequenceNo);
		dataEntryImpl.setRecordCount(recordCount);

		if (sequenceDelimeter == null) {
			dataEntryImpl.setSequenceDelimeter("");
		}
		else {
			dataEntryImpl.setSequenceDelimeter(sequenceDelimeter);
		}

		dataEntryImpl.resetOriginalValues();

		return dataEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataEntryId = objectInput.readLong();
		dataCollectionName = objectInput.readUTF();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		path = objectInput.readUTF();

		sequenceNo = objectInput.readInt();

		recordCount = objectInput.readInt();
		sequenceDelimeter = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataEntryId);

		if (dataCollectionName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataCollectionName);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		if (path == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(path);
		}

		objectOutput.writeInt(sequenceNo);

		objectOutput.writeInt(recordCount);

		if (sequenceDelimeter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sequenceDelimeter);
		}
	}

	public long dataEntryId;
	public String dataCollectionName;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public String path;
	public int sequenceNo;
	public int recordCount;
	public String sequenceDelimeter;

}