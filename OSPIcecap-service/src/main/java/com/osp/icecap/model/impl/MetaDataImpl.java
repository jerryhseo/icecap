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

import com.liferay.portal.kernel.json.JSONObject;
import com.osp.icecap.constants.MetaDataKeys;
import com.osp.icecap.exception.NoSuchMetaDataFieldException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model implementation for the MetaData service. Represents a row in the &quot;ICECAP_MetaData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.model.MetaData</code> interface.
 * </p>
 *
 * @author Jerry H. Seo
 */
@ProviderType
public class MetaDataImpl extends MetaDataBaseImpl {

	public MetaDataImpl() {
	}

	public void setMetaData( JSONObject metaDataJSON ) throws NoSuchMetaDataFieldException {
		Iterator<String> keys = metaDataJSON.keys();
		
		while( keys.hasNext() ) {
			String key = keys.next();
			
			switch( key ) {
			case MetaDataKeys.CREATED:
				super.setCreated(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.CREATOR:
				super.setCreator(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.DATE_ACCEPTED:
				super.setDateAccepted(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.DATE_COPYRIGHTED:
				super.setDateCopyrighted(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.DATE_SUBMITTED:
				super.setDateSubmitted(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.DESCRIPTION:
				super.setDescriptionMap((HashMap<Locale, String>)metaDataJSON.get(key));
				break;
			case MetaDataKeys.DOI:
				super.setDoi(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.FORMAT:
				super.setFormat(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.ISSUED:
				super.setIssued(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.LICENSE:
				super.setLicense(metaDataJSON.getString(key));
				break;
			case MetaDataKeys.SUMMARY:
				super.setSummaryMap((HashMap<Locale, String>)metaDataJSON.get(key));
				break;
			case MetaDataKeys.TITLE:
				super.setTitleMap((HashMap<Locale, String>)metaDataJSON.get(key));
				break;
			case MetaDataKeys.VERSION:
				super.setVersion(metaDataJSON.getString(key));
				break;
			default:	
				throw new NoSuchMetaDataFieldException(key);
			}
		}
	}
}