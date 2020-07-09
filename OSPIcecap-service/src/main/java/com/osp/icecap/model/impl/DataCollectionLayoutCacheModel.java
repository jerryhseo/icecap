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

import com.osp.icecap.model.DataCollectionLayout;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing DataCollectionLayout in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataCollectionLayoutCacheModel
	implements CacheModel<DataCollectionLayout>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataCollectionLayoutCacheModel)) {
			return false;
		}

		DataCollectionLayoutCacheModel dataCollectionLayoutCacheModel =
			(DataCollectionLayoutCacheModel)obj;

		if (dataCollectionId ==
				dataCollectionLayoutCacheModel.dataCollectionId) {

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
		StringBundler sb = new StringBundler(5);

		sb.append("{dataCollectionId=");
		sb.append(dataCollectionId);
		sb.append(", layout=");
		sb.append(layout);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataCollectionLayout toEntityModel() {
		DataCollectionLayoutImpl dataCollectionLayoutImpl =
			new DataCollectionLayoutImpl();

		dataCollectionLayoutImpl.setDataCollectionId(dataCollectionId);

		if (layout == null) {
			dataCollectionLayoutImpl.setLayout("");
		}
		else {
			dataCollectionLayoutImpl.setLayout(layout);
		}

		dataCollectionLayoutImpl.resetOriginalValues();

		return dataCollectionLayoutImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataCollectionId = objectInput.readLong();
		layout = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataCollectionId);

		if (layout == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(layout);
		}
	}

	public long dataCollectionId;
	public String layout;

}