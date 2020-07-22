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

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing DataAnalysisLayout in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
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
		StringBundler sb = new StringBundler(7);

		sb.append("{dataUuid=");
		sb.append(dataUuid);
		sb.append(", layout=");
		sb.append(layout);
		sb.append(", applyLevel=");
		sb.append(applyLevel);
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

		if (layout == null) {
			dataAnalysisLayoutImpl.setLayout("");
		}
		else {
			dataAnalysisLayoutImpl.setLayout(layout);
		}

		if (applyLevel == null) {
			dataAnalysisLayoutImpl.setApplyLevel("");
		}
		else {
			dataAnalysisLayoutImpl.setApplyLevel(applyLevel);
		}

		dataAnalysisLayoutImpl.resetOriginalValues();

		return dataAnalysisLayoutImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataUuid = objectInput.readUTF();
		layout = objectInput.readUTF();
		applyLevel = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (dataUuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataUuid);
		}

		if (layout == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(layout);
		}

		if (applyLevel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applyLevel);
		}
	}

	public String dataUuid;
	public String layout;
	public String applyLevel;

}