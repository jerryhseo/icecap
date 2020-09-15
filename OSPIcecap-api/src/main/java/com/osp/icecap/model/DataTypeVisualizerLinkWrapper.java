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
 * This class is a wrapper for {@link DataTypeVisualizerLink}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeVisualizerLink
 * @generated
 */
@ProviderType
public class DataTypeVisualizerLinkWrapper
	extends BaseModelWrapper<DataTypeVisualizerLink>
	implements DataTypeVisualizerLink, ModelWrapper<DataTypeVisualizerLink> {

	public DataTypeVisualizerLinkWrapper(
		DataTypeVisualizerLink dataTypeVisualizerLink) {

		super(dataTypeVisualizerLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"dataTypeVisualizerLinkId", getDataTypeVisualizerLinkId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("visualizerName", getVisualizerName());
		attributes.put("visualizerVersion", getVisualizerVersion());
		attributes.put("defaultVisualizer", isDefaultVisualizer());
		attributes.put("editable", isEditable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataTypeVisualizerLinkId = (Long)attributes.get(
			"dataTypeVisualizerLinkId");

		if (dataTypeVisualizerLinkId != null) {
			setDataTypeVisualizerLinkId(dataTypeVisualizerLinkId);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		String visualizerName = (String)attributes.get("visualizerName");

		if (visualizerName != null) {
			setVisualizerName(visualizerName);
		}

		String visualizerVersion = (String)attributes.get("visualizerVersion");

		if (visualizerVersion != null) {
			setVisualizerVersion(visualizerVersion);
		}

		Boolean defaultVisualizer = (Boolean)attributes.get(
			"defaultVisualizer");

		if (defaultVisualizer != null) {
			setDefaultVisualizer(defaultVisualizer);
		}

		Boolean editable = (Boolean)attributes.get("editable");

		if (editable != null) {
			setEditable(editable);
		}
	}

	/**
	 * Returns the data type ID of this data type visualizer link.
	 *
	 * @return the data type ID of this data type visualizer link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the data type visualizer link ID of this data type visualizer link.
	 *
	 * @return the data type visualizer link ID of this data type visualizer link
	 */
	@Override
	public long getDataTypeVisualizerLinkId() {
		return model.getDataTypeVisualizerLinkId();
	}

	/**
	 * Returns the default visualizer of this data type visualizer link.
	 *
	 * @return the default visualizer of this data type visualizer link
	 */
	@Override
	public boolean getDefaultVisualizer() {
		return model.getDefaultVisualizer();
	}

	/**
	 * Returns the editable of this data type visualizer link.
	 *
	 * @return the editable of this data type visualizer link
	 */
	@Override
	public boolean getEditable() {
		return model.getEditable();
	}

	/**
	 * Returns the primary key of this data type visualizer link.
	 *
	 * @return the primary key of this data type visualizer link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the visualizer name of this data type visualizer link.
	 *
	 * @return the visualizer name of this data type visualizer link
	 */
	@Override
	public String getVisualizerName() {
		return model.getVisualizerName();
	}

	/**
	 * Returns the visualizer version of this data type visualizer link.
	 *
	 * @return the visualizer version of this data type visualizer link
	 */
	@Override
	public String getVisualizerVersion() {
		return model.getVisualizerVersion();
	}

	/**
	 * Returns <code>true</code> if this data type visualizer link is default visualizer.
	 *
	 * @return <code>true</code> if this data type visualizer link is default visualizer; <code>false</code> otherwise
	 */
	@Override
	public boolean isDefaultVisualizer() {
		return model.isDefaultVisualizer();
	}

	/**
	 * Returns <code>true</code> if this data type visualizer link is editable.
	 *
	 * @return <code>true</code> if this data type visualizer link is editable; <code>false</code> otherwise
	 */
	@Override
	public boolean isEditable() {
		return model.isEditable();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data type ID of this data type visualizer link.
	 *
	 * @param dataTypeId the data type ID of this data type visualizer link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the data type visualizer link ID of this data type visualizer link.
	 *
	 * @param dataTypeVisualizerLinkId the data type visualizer link ID of this data type visualizer link
	 */
	@Override
	public void setDataTypeVisualizerLinkId(long dataTypeVisualizerLinkId) {
		model.setDataTypeVisualizerLinkId(dataTypeVisualizerLinkId);
	}

	/**
	 * Sets whether this data type visualizer link is default visualizer.
	 *
	 * @param defaultVisualizer the default visualizer of this data type visualizer link
	 */
	@Override
	public void setDefaultVisualizer(boolean defaultVisualizer) {
		model.setDefaultVisualizer(defaultVisualizer);
	}

	/**
	 * Sets whether this data type visualizer link is editable.
	 *
	 * @param editable the editable of this data type visualizer link
	 */
	@Override
	public void setEditable(boolean editable) {
		model.setEditable(editable);
	}

	/**
	 * Sets the primary key of this data type visualizer link.
	 *
	 * @param primaryKey the primary key of this data type visualizer link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the visualizer name of this data type visualizer link.
	 *
	 * @param visualizerName the visualizer name of this data type visualizer link
	 */
	@Override
	public void setVisualizerName(String visualizerName) {
		model.setVisualizerName(visualizerName);
	}

	/**
	 * Sets the visualizer version of this data type visualizer link.
	 *
	 * @param visualizerVersion the visualizer version of this data type visualizer link
	 */
	@Override
	public void setVisualizerVersion(String visualizerVersion) {
		model.setVisualizerVersion(visualizerVersion);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSONObject() {
		return model.toJSONObject();
	}

	@Override
	protected DataTypeVisualizerLinkWrapper wrap(
		DataTypeVisualizerLink dataTypeVisualizerLink) {

		return new DataTypeVisualizerLinkWrapper(dataTypeVisualizerLink);
	}

}