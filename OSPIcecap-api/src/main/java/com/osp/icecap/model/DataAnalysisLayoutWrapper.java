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
		attributes.put("layout", getLayout());
		attributes.put("applyLevel", getApplyLevel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String dataUuid = (String)attributes.get("dataUuid");

		if (dataUuid != null) {
			setDataUuid(dataUuid);
		}

		String layout = (String)attributes.get("layout");

		if (layout != null) {
			setLayout(layout);
		}

		String applyLevel = (String)attributes.get("applyLevel");

		if (applyLevel != null) {
			setApplyLevel(applyLevel);
		}
	}

	/**
	 * Returns the apply level of this data analysis layout.
	 *
	 * @return the apply level of this data analysis layout
	 */
	@Override
	public String getApplyLevel() {
		return model.getApplyLevel();
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
	 * Sets the apply level of this data analysis layout.
	 *
	 * @param applyLevel the apply level of this data analysis layout
	 */
	@Override
	public void setApplyLevel(String applyLevel) {
		model.setApplyLevel(applyLevel);
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