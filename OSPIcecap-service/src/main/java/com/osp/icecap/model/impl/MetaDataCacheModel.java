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

import com.osp.icecap.model.MetaData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing MetaData in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class MetaDataCacheModel
	implements CacheModel<MetaData>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetaDataCacheModel)) {
			return false;
		}

		MetaDataCacheModel metaDataCacheModel = (MetaDataCacheModel)obj;

		if (dataUuid.equals(metaDataCacheModel.dataUuid)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataUuid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{dataUuid=");
		sb.append(dataUuid);
		sb.append(", creator=");
		sb.append(creator);
		sb.append(", created=");
		sb.append(created);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", doi=");
		sb.append(doi);
		sb.append(", dateAccepted=");
		sb.append(dateAccepted);
		sb.append(", dateCopyrighted=");
		sb.append(dateCopyrighted);
		sb.append(", dateSubmitted=");
		sb.append(dateSubmitted);
		sb.append(", format=");
		sb.append(format);
		sb.append(", version=");
		sb.append(version);
		sb.append(", issued=");
		sb.append(issued);
		sb.append(", license=");
		sb.append(license);
		sb.append(", datePattern=");
		sb.append(datePattern);
		sb.append(", dataCollectionId=");
		sb.append(dataCollectionId);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataSectionId=");
		sb.append(dataSectionId);
		sb.append(", dataPackId=");
		sb.append(dataPackId);
		sb.append(", dataEntryId=");
		sb.append(dataEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MetaData toEntityModel() {
		MetaDataImpl metaDataImpl = new MetaDataImpl();

		if (dataUuid == null) {
			metaDataImpl.setDataUuid("");
		}
		else {
			metaDataImpl.setDataUuid(dataUuid);
		}

		if (creator == null) {
			metaDataImpl.setCreator("");
		}
		else {
			metaDataImpl.setCreator(creator);
		}

		if (created == null) {
			metaDataImpl.setCreated("");
		}
		else {
			metaDataImpl.setCreated(created);
		}

		if (title == null) {
			metaDataImpl.setTitle("");
		}
		else {
			metaDataImpl.setTitle(title);
		}

		if (description == null) {
			metaDataImpl.setDescription("");
		}
		else {
			metaDataImpl.setDescription(description);
		}

		if (summary == null) {
			metaDataImpl.setSummary("");
		}
		else {
			metaDataImpl.setSummary(summary);
		}

		if (doi == null) {
			metaDataImpl.setDoi("");
		}
		else {
			metaDataImpl.setDoi(doi);
		}

		if (dateAccepted == null) {
			metaDataImpl.setDateAccepted("");
		}
		else {
			metaDataImpl.setDateAccepted(dateAccepted);
		}

		if (dateCopyrighted == null) {
			metaDataImpl.setDateCopyrighted("");
		}
		else {
			metaDataImpl.setDateCopyrighted(dateCopyrighted);
		}

		if (dateSubmitted == null) {
			metaDataImpl.setDateSubmitted("");
		}
		else {
			metaDataImpl.setDateSubmitted(dateSubmitted);
		}

		if (format == null) {
			metaDataImpl.setFormat("");
		}
		else {
			metaDataImpl.setFormat(format);
		}

		if (version == null) {
			metaDataImpl.setVersion("");
		}
		else {
			metaDataImpl.setVersion(version);
		}

		if (issued == null) {
			metaDataImpl.setIssued("");
		}
		else {
			metaDataImpl.setIssued(issued);
		}

		if (license == null) {
			metaDataImpl.setLicense("");
		}
		else {
			metaDataImpl.setLicense(license);
		}

		if (datePattern == null) {
			metaDataImpl.setDatePattern("");
		}
		else {
			metaDataImpl.setDatePattern(datePattern);
		}

		metaDataImpl.setDataCollectionId(dataCollectionId);
		metaDataImpl.setDataSetId(dataSetId);
		metaDataImpl.setDataSectionId(dataSectionId);
		metaDataImpl.setDataPackId(dataPackId);
		metaDataImpl.setDataEntryId(dataEntryId);

		metaDataImpl.resetOriginalValues();

		return metaDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataUuid = objectInput.readUTF();
		creator = objectInput.readUTF();
		created = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		summary = objectInput.readUTF();
		doi = objectInput.readUTF();
		dateAccepted = objectInput.readUTF();
		dateCopyrighted = objectInput.readUTF();
		dateSubmitted = objectInput.readUTF();
		format = objectInput.readUTF();
		version = objectInput.readUTF();
		issued = objectInput.readUTF();
		license = objectInput.readUTF();
		datePattern = objectInput.readUTF();

		dataCollectionId = objectInput.readLong();

		dataSetId = objectInput.readLong();

		dataSectionId = objectInput.readLong();

		dataPackId = objectInput.readLong();

		dataEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (dataUuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataUuid);
		}

		if (creator == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(creator);
		}

		if (created == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(created);
		}

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

		if (summary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(summary);
		}

		if (doi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(doi);
		}

		if (dateAccepted == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dateAccepted);
		}

		if (dateCopyrighted == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dateCopyrighted);
		}

		if (dateSubmitted == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dateSubmitted);
		}

		if (format == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(format);
		}

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (issued == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(issued);
		}

		if (license == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(license);
		}

		if (datePattern == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(datePattern);
		}

		objectOutput.writeLong(dataCollectionId);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeLong(dataSectionId);

		objectOutput.writeLong(dataPackId);

		objectOutput.writeLong(dataEntryId);
	}

	public String dataUuid;
	public String creator;
	public String created;
	public String title;
	public String description;
	public String summary;
	public String doi;
	public String dateAccepted;
	public String dateCopyrighted;
	public String dateSubmitted;
	public String format;
	public String version;
	public String issued;
	public String license;
	public String datePattern;
	public long dataCollectionId;
	public long dataSetId;
	public long dataSectionId;
	public long dataPackId;
	public long dataEntryId;

}