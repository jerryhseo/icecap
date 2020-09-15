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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DataTypeVisualizerLink service. Represents a row in the &quot;ICECAP_DataTypeVisualizerLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Jerry H. Seo
 * @see DataTypeVisualizerLinkModel
 * @generated
 */
@ImplementationClassName("com.osp.icecap.model.impl.DataTypeVisualizerLinkImpl")
@ProviderType
public interface DataTypeVisualizerLink
	extends DataTypeVisualizerLinkModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.osp.icecap.model.impl.DataTypeVisualizerLinkImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataTypeVisualizerLink, Long>
		DATA_TYPE_VISUALIZER_LINK_ID_ACCESSOR =
			new Accessor<DataTypeVisualizerLink, Long>() {

				@Override
				public Long get(DataTypeVisualizerLink dataTypeVisualizerLink) {
					return dataTypeVisualizerLink.getDataTypeVisualizerLinkId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<DataTypeVisualizerLink> getTypeClass() {
					return DataTypeVisualizerLink.class;
				}

			};

	public com.liferay.portal.kernel.json.JSONObject toJSONObject();

}