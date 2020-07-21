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

package com.osp.icecap.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link DataTypeLink}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeLink
 * @generated
 */
@ProviderType
public class DataTypeLinkWrapper
	extends BaseModelWrapper<DataTypeLink>
	implements DataTypeLink, ModelWrapper<DataTypeLink> {

	public DataTypeLinkWrapper(DataTypeLink dataTypeLink) {
		super(dataTypeLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataUuid", getDataUuid());
		attributes.put("dataTypeId", getDataTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String dataUuid = (String)attributes.get("dataUuid");

		if (dataUuid != null) {
			setDataUuid(dataUuid);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}
	}

	/**
	 * Returns the data type ID of this data type link.
	 *
	 * @return the data type ID of this data type link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the data uuid of this data type link.
	 *
	 * @return the data uuid of this data type link
	 */
	@Override
	public String getDataUuid() {
		return model.getDataUuid();
	}

	/**
	 * Returns the primary key of this data type link.
	 *
	 * @return the primary key of this data type link
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data type ID of this data type link.
	 *
	 * @param dataTypeId the data type ID of this data type link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the data uuid of this data type link.
	 *
	 * @param dataUuid the data uuid of this data type link
	 */
	@Override
	public void setDataUuid(String dataUuid) {
		model.setDataUuid(dataUuid);
	}

	/**
	 * Sets the primary key of this data type link.
	 *
	 * @param primaryKey the primary key of this data type link
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected DataTypeLinkWrapper wrap(DataTypeLink dataTypeLink) {
		return new DataTypeLinkWrapper(dataTypeLink);
	}

}