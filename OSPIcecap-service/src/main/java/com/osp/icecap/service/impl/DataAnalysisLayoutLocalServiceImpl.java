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

package com.osp.icecap.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.osp.icecap.exception.NoSuchDataAnalysisLayoutException;
import com.osp.icecap.model.DataAnalysisLayout;
import com.osp.icecap.service.base.DataAnalysisLayoutLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the data analysis layout local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icecap.service.DataAnalysisLayoutLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataAnalysisLayoutLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icecap.model.DataAnalysisLayout",
	service = AopService.class
)
public class DataAnalysisLayoutLocalServiceImpl
	extends DataAnalysisLayoutLocalServiceBaseImpl {

	public JSONObject addDataAnalysisLayout( String dataUuidStr, String layoutStr ) throws JSONException {
		DataAnalysisLayout layout = super.dataAnalysisLayoutPersistence.create(dataUuidStr);
		
		JSONObject layoutJSON = null;
		
		layoutJSON = JSONFactoryUtil.createJSONObject(layoutStr);
		layout.setLayout(layoutJSON.toString());
		
		super.dataAnalysisLayoutPersistence.update( layout );
		
		return  layoutJSON;
	}
	
	public DataAnalysisLayout removeDataAnalysisLayout( String dataUuid ) throws NoSuchDataAnalysisLayoutException {
		return super.dataAnalysisLayoutPersistence.remove(dataUuid);
	}
	
	public JSONObject updateDataAnalysisLayout( String dataUuidStr, String layoutStr) throws NoSuchDataAnalysisLayoutException, JSONException {
		DataAnalysisLayout layout = super.dataAnalysisLayoutPersistence.findByPrimaryKey(dataUuidStr);
		
		JSONObject layoutJSON = null;
		
		layoutJSON = JSONFactoryUtil.createJSONObject(layoutStr);
		layout.setLayout(layoutJSON.toString());
		super.dataAnalysisLayoutPersistence.update( layout );
		
		return  layoutJSON;
	}
	
	public JSONObject getDataAnalysisLayoutJSON( String dataUuidStr ) throws NoSuchDataAnalysisLayoutException, JSONException {
		DataAnalysisLayout layout = super.dataAnalysisLayoutPersistence.findByPrimaryKey(dataUuidStr);
		
		JSONObject layoutJSON = null;
		
		layoutJSON = JSONFactoryUtil.createJSONObject(layout.getLayout());
		
		return  layoutJSON;
	}
	
	public String getDataAnalysisLayoutStr( String dataUuidStr ) throws NoSuchDataAnalysisLayoutException{
		DataAnalysisLayout layout = super.dataAnalysisLayoutPersistence.findByPrimaryKey(dataUuidStr);
		
		return  layout.getLayout();
	}
}