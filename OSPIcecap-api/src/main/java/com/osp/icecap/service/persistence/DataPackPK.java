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

package com.osp.icecap.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class DataPackPK implements Comparable<DataPackPK>, Serializable {

	public long dataPackId;
	public String version;

	public DataPackPK() {
	}

	public DataPackPK(long dataPackId, String version) {
		this.dataPackId = dataPackId;
		this.version = version;
	}

	public long getDataPackId() {
		return dataPackId;
	}

	public void setDataPackId(long dataPackId) {
		this.dataPackId = dataPackId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public int compareTo(DataPackPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (dataPackId < pk.dataPackId) {
			value = -1;
		}
		else if (dataPackId > pk.dataPackId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = version.compareTo(pk.version);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataPackPK)) {
			return false;
		}

		DataPackPK pk = (DataPackPK)obj;

		if ((dataPackId == pk.dataPackId) && version.equals(pk.version)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, dataPackId);
		hashCode = HashUtil.hash(hashCode, version);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("dataPackId=");

		sb.append(dataPackId);
		sb.append(", version=");

		sb.append(version);

		sb.append("}");

		return sb.toString();
	}

}