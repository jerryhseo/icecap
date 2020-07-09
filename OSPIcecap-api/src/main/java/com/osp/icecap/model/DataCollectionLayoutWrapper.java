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
 * This class is a wrapper for {@link DataCollectionLayout}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataCollectionLayout
 * @generated
 */
@ProviderType
public class DataCollectionLayoutWrapper
	extends BaseModelWrapper<DataCollectionLayout>
	implements DataCollectionLayout, ModelWrapper<DataCollectionLayout> {

	public DataCollectionLayoutWrapper(
		DataCollectionLayout dataCollectionLayout) {

		super(dataCollectionLayout);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataCollectionId", getDataCollectionId());
		attributes.put("layout", getLayout());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataCollectionId = (Long)attributes.get("dataCollectionId");

		if (dataCollectionId != null) {
			setDataCollectionId(dataCollectionId);
		}

		String layout = (String)attributes.get("layout");

		if (layout != null) {
			setLayout(layout);
		}
	}

	/**
	 * Returns the data collection ID of this data collection layout.
	 *
	 * @return the data collection ID of this data collection layout
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the layout of this data collection layout.
	 *
	 * @return the layout of this data collection layout
	 */
	@Override
	public String getLayout() {
		return model.getLayout();
	}

	/**
	 * Returns the primary key of this data collection layout.
	 *
	 * @return the primary key of this data collection layout
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data collection ID of this data collection layout.
	 *
	 * @param dataCollectionId the data collection ID of this data collection layout
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the layout of this data collection layout.
	 *
	 * @param layout the layout of this data collection layout
	 */
	@Override
	public void setLayout(String layout) {
		model.setLayout(layout);
	}

	/**
	 * Sets the primary key of this data collection layout.
	 *
	 * @param primaryKey the primary key of this data collection layout
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected DataCollectionLayoutWrapper wrap(
		DataCollectionLayout dataCollectionLayout) {

		return new DataCollectionLayoutWrapper(dataCollectionLayout);
	}

}