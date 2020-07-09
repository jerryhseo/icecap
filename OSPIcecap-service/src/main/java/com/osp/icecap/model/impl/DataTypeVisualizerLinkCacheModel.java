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

import com.osp.icecap.model.DataTypeVisualizerLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing DataTypeVisualizerLink in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataTypeVisualizerLinkCacheModel
	implements CacheModel<DataTypeVisualizerLink>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataTypeVisualizerLinkCacheModel)) {
			return false;
		}

		DataTypeVisualizerLinkCacheModel dataTypeVisualizerLinkCacheModel =
			(DataTypeVisualizerLinkCacheModel)obj;

		if (dataTypeVisualizerLinkId ==
				dataTypeVisualizerLinkCacheModel.dataTypeVisualizerLinkId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataTypeVisualizerLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{dataTypeVisualizerLinkId=");
		sb.append(dataTypeVisualizerLinkId);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", visualizerName=");
		sb.append(visualizerName);
		sb.append(", visualizerVersion=");
		sb.append(visualizerVersion);
		sb.append(", defaultVisualizer=");
		sb.append(defaultVisualizer);
		sb.append(", editable=");
		sb.append(editable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataTypeVisualizerLink toEntityModel() {
		DataTypeVisualizerLinkImpl dataTypeVisualizerLinkImpl =
			new DataTypeVisualizerLinkImpl();

		dataTypeVisualizerLinkImpl.setDataTypeVisualizerLinkId(
			dataTypeVisualizerLinkId);
		dataTypeVisualizerLinkImpl.setDataTypeId(dataTypeId);

		if (visualizerName == null) {
			dataTypeVisualizerLinkImpl.setVisualizerName("");
		}
		else {
			dataTypeVisualizerLinkImpl.setVisualizerName(visualizerName);
		}

		if (visualizerVersion == null) {
			dataTypeVisualizerLinkImpl.setVisualizerVersion("");
		}
		else {
			dataTypeVisualizerLinkImpl.setVisualizerVersion(visualizerVersion);
		}

		dataTypeVisualizerLinkImpl.setDefaultVisualizer(defaultVisualizer);
		dataTypeVisualizerLinkImpl.setEditable(editable);

		dataTypeVisualizerLinkImpl.resetOriginalValues();

		return dataTypeVisualizerLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataTypeVisualizerLinkId = objectInput.readLong();

		dataTypeId = objectInput.readLong();
		visualizerName = objectInput.readUTF();
		visualizerVersion = objectInput.readUTF();

		defaultVisualizer = objectInput.readBoolean();

		editable = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataTypeVisualizerLinkId);

		objectOutput.writeLong(dataTypeId);

		if (visualizerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(visualizerName);
		}

		if (visualizerVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(visualizerVersion);
		}

		objectOutput.writeBoolean(defaultVisualizer);

		objectOutput.writeBoolean(editable);
	}

	public long dataTypeVisualizerLinkId;
	public long dataTypeId;
	public String visualizerName;
	public String visualizerVersion;
	public boolean defaultVisualizer;
	public boolean editable;

}