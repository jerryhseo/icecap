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
 * The extended model interface for the DataEntry service. Represents a row in the &quot;ICECAP_DataEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Jerry H. Seo
 * @see DataEntryModel
 * @generated
 */
@ImplementationClassName("com.osp.icecap.model.impl.DataEntryImpl")
@ProviderType
public interface DataEntry extends DataEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.osp.icecap.model.impl.DataEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataEntry, String> UUID_ACCESSOR =
		new Accessor<DataEntry, String>() {

			@Override
			public String get(DataEntry dataEntry) {
				return dataEntry.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DataEntry> getTypeClass() {
				return DataEntry.class;
			}

		};

	public static final Accessor<DataEntry, Long> DATA_ENTRY_ID_ACCESSOR =
		new Accessor<DataEntry, Long>() {

			@Override
			public Long get(DataEntry dataEntry) {
				return dataEntry.getDataEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataEntry> getTypeClass() {
				return DataEntry.class;
			}

		};

}