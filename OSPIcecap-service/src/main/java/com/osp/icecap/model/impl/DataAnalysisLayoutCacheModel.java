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

import com.osp.icecap.model.DataAnalysisLayout;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DataAnalysisLayout in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
public class DataAnalysisLayoutCacheModel
	implements CacheModel<DataAnalysisLayout>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataAnalysisLayoutCacheModel)) {
			return false;
		}

		DataAnalysisLayoutCacheModel dataAnalysisLayoutCacheModel =
			(DataAnalysisLayoutCacheModel)obj;

		if (dataUuid.equals(dataAnalysisLayoutCacheModel.dataUuid)) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{dataUuid=");
		sb.append(dataUuid);
		sb.append(", dataCollectionId=");
		sb.append(dataCollectionId);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataSectionId=");
		sb.append(dataSectionId);
		sb.append(", dataPackId=");
		sb.append(dataPackId);
		sb.append(", layout=");
		sb.append(layout);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataAnalysisLayout toEntityModel() {
		DataAnalysisLayoutImpl dataAnalysisLayoutImpl =
			new DataAnalysisLayoutImpl();

		if (dataUuid == null) {
			dataAnalysisLayoutImpl.setDataUuid("");
		}
		else {
			dataAnalysisLayoutImpl.setDataUuid(dataUuid);
		}

		dataAnalysisLayoutImpl.setDataCollectionId(dataCollectionId);
		dataAnalysisLayoutImpl.setDataSetId(dataSetId);
		dataAnalysisLayoutImpl.setDataSectionId(dataSectionId);
		dataAnalysisLayoutImpl.setDataPackId(dataPackId);

		if (layout == null) {
			dataAnalysisLayoutImpl.setLayout("");
		}
		else {
			dataAnalysisLayoutImpl.setLayout(layout);
		}

		dataAnalysisLayoutImpl.resetOriginalValues();

		return dataAnalysisLayoutImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataUuid = objectInput.readUTF();

		dataCollectionId = objectInput.readLong();

		dataSetId = objectInput.readLong();

		dataSectionId = objectInput.readLong();

		dataPackId = objectInput.readLong();
		layout = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (dataUuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataUuid);
		}

		objectOutput.writeLong(dataCollectionId);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeLong(dataSectionId);

		objectOutput.writeLong(dataPackId);

		if (layout == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(layout);
		}
	}

	public String dataUuid;
	public long dataCollectionId;
	public long dataSetId;
	public long dataSectionId;
	public long dataPackId;
	public String layout;

}