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
 * This class is a wrapper for {@link DataAnalysisLayout}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataAnalysisLayout
 * @generated
 */
@ProviderType
public class DataAnalysisLayoutWrapper
	extends BaseModelWrapper<DataAnalysisLayout>
	implements DataAnalysisLayout, ModelWrapper<DataAnalysisLayout> {

	public DataAnalysisLayoutWrapper(DataAnalysisLayout dataAnalysisLayout) {
		super(dataAnalysisLayout);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataUuid", getDataUuid());
		attributes.put("dataCollectionId", getDataCollectionId());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataSectionId", getDataSectionId());
		attributes.put("dataPackId", getDataPackId());
		attributes.put("layout", getLayout());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String dataUuid = (String)attributes.get("dataUuid");

		if (dataUuid != null) {
			setDataUuid(dataUuid);
		}

		Long dataCollectionId = (Long)attributes.get("dataCollectionId");

		if (dataCollectionId != null) {
			setDataCollectionId(dataCollectionId);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataSectionId = (Long)attributes.get("dataSectionId");

		if (dataSectionId != null) {
			setDataSectionId(dataSectionId);
		}

		Long dataPackId = (Long)attributes.get("dataPackId");

		if (dataPackId != null) {
			setDataPackId(dataPackId);
		}

		String layout = (String)attributes.get("layout");

		if (layout != null) {
			setLayout(layout);
		}
	}

	/**
	 * Returns the data collection ID of this data analysis layout.
	 *
	 * @return the data collection ID of this data analysis layout
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the data pack ID of this data analysis layout.
	 *
	 * @return the data pack ID of this data analysis layout
	 */
	@Override
	public long getDataPackId() {
		return model.getDataPackId();
	}

	/**
	 * Returns the data section ID of this data analysis layout.
	 *
	 * @return the data section ID of this data analysis layout
	 */
	@Override
	public long getDataSectionId() {
		return model.getDataSectionId();
	}

	/**
	 * Returns the data set ID of this data analysis layout.
	 *
	 * @return the data set ID of this data analysis layout
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the data uuid of this data analysis layout.
	 *
	 * @return the data uuid of this data analysis layout
	 */
	@Override
	public String getDataUuid() {
		return model.getDataUuid();
	}

	/**
	 * Returns the layout of this data analysis layout.
	 *
	 * @return the layout of this data analysis layout
	 */
	@Override
	public String getLayout() {
		return model.getLayout();
	}

	/**
	 * Returns the primary key of this data analysis layout.
	 *
	 * @return the primary key of this data analysis layout
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
	 * Sets the data collection ID of this data analysis layout.
	 *
	 * @param dataCollectionId the data collection ID of this data analysis layout
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the data pack ID of this data analysis layout.
	 *
	 * @param dataPackId the data pack ID of this data analysis layout
	 */
	@Override
	public void setDataPackId(long dataPackId) {
		model.setDataPackId(dataPackId);
	}

	/**
	 * Sets the data section ID of this data analysis layout.
	 *
	 * @param dataSectionId the data section ID of this data analysis layout
	 */
	@Override
	public void setDataSectionId(long dataSectionId) {
		model.setDataSectionId(dataSectionId);
	}

	/**
	 * Sets the data set ID of this data analysis layout.
	 *
	 * @param dataSetId the data set ID of this data analysis layout
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the data uuid of this data analysis layout.
	 *
	 * @param dataUuid the data uuid of this data analysis layout
	 */
	@Override
	public void setDataUuid(String dataUuid) {
		model.setDataUuid(dataUuid);
	}

	/**
	 * Sets the layout of this data analysis layout.
	 *
	 * @param layout the layout of this data analysis layout
	 */
	@Override
	public void setLayout(String layout) {
		model.setLayout(layout);
	}

	/**
	 * Sets the primary key of this data analysis layout.
	 *
	 * @param primaryKey the primary key of this data analysis layout
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected DataAnalysisLayoutWrapper wrap(
		DataAnalysisLayout dataAnalysisLayout) {

		return new DataAnalysisLayoutWrapper(dataAnalysisLayout);
	}

}