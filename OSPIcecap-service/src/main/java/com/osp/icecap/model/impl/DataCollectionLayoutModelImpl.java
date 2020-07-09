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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.osp.icecap.model.DataCollectionLayout;
import com.osp.icecap.model.DataCollectionLayoutModel;
import com.osp.icecap.model.DataCollectionLayoutSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the DataCollectionLayout service. Represents a row in the &quot;ICECAP_DataCollectionLayout&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DataCollectionLayoutModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataCollectionLayoutImpl}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataCollectionLayoutImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DataCollectionLayoutModelImpl
	extends BaseModelImpl<DataCollectionLayout>
	implements DataCollectionLayoutModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data collection layout model instance should use the <code>DataCollectionLayout</code> interface instead.
	 */
	public static final String TABLE_NAME = "ICECAP_DataCollectionLayout";

	public static final Object[][] TABLE_COLUMNS = {
		{"dataCollectionId", Types.BIGINT}, {"layout", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dataCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("layout", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ICECAP_DataCollectionLayout (dataCollectionId LONG not null primary key,layout VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table ICECAP_DataCollectionLayout";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dataCollectionLayout.dataCollectionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ICECAP_DataCollectionLayout.dataCollectionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DataCollectionLayout toModel(
		DataCollectionLayoutSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		DataCollectionLayout model = new DataCollectionLayoutImpl();

		model.setDataCollectionId(soapModel.getDataCollectionId());
		model.setLayout(soapModel.getLayout());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DataCollectionLayout> toModels(
		DataCollectionLayoutSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<DataCollectionLayout> models = new ArrayList<DataCollectionLayout>(
			soapModels.length);

		for (DataCollectionLayoutSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public DataCollectionLayoutModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dataCollectionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDataCollectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataCollectionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DataCollectionLayout.class;
	}

	@Override
	public String getModelClassName() {
		return DataCollectionLayout.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DataCollectionLayout, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DataCollectionLayout, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataCollectionLayout, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DataCollectionLayout)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DataCollectionLayout, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DataCollectionLayout, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DataCollectionLayout)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DataCollectionLayout, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DataCollectionLayout, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DataCollectionLayout>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DataCollectionLayout.class.getClassLoader(),
			DataCollectionLayout.class, ModelWrapper.class);

		try {
			Constructor<DataCollectionLayout> constructor =
				(Constructor<DataCollectionLayout>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<DataCollectionLayout, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DataCollectionLayout, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DataCollectionLayout, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DataCollectionLayout, Object>>();
		Map<String, BiConsumer<DataCollectionLayout, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<DataCollectionLayout, ?>>();

		attributeGetterFunctions.put(
			"dataCollectionId", DataCollectionLayout::getDataCollectionId);
		attributeSetterBiConsumers.put(
			"dataCollectionId",
			(BiConsumer<DataCollectionLayout, Long>)
				DataCollectionLayout::setDataCollectionId);
		attributeGetterFunctions.put("layout", DataCollectionLayout::getLayout);
		attributeSetterBiConsumers.put(
			"layout",
			(BiConsumer<DataCollectionLayout, String>)
				DataCollectionLayout::setLayout);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	@Override
	public void setDataCollectionId(long dataCollectionId) {
		_dataCollectionId = dataCollectionId;
	}

	@JSON
	@Override
	public String getLayout() {
		if (_layout == null) {
			return "";
		}
		else {
			return _layout;
		}
	}

	@Override
	public void setLayout(String layout) {
		_layout = layout;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, DataCollectionLayout.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DataCollectionLayout toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DataCollectionLayoutImpl dataCollectionLayoutImpl =
			new DataCollectionLayoutImpl();

		dataCollectionLayoutImpl.setDataCollectionId(getDataCollectionId());
		dataCollectionLayoutImpl.setLayout(getLayout());

		dataCollectionLayoutImpl.resetOriginalValues();

		return dataCollectionLayoutImpl;
	}

	@Override
	public int compareTo(DataCollectionLayout dataCollectionLayout) {
		long primaryKey = dataCollectionLayout.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataCollectionLayout)) {
			return false;
		}

		DataCollectionLayout dataCollectionLayout = (DataCollectionLayout)obj;

		long primaryKey = dataCollectionLayout.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<DataCollectionLayout> toCacheModel() {
		DataCollectionLayoutCacheModel dataCollectionLayoutCacheModel =
			new DataCollectionLayoutCacheModel();

		dataCollectionLayoutCacheModel.dataCollectionId = getDataCollectionId();

		dataCollectionLayoutCacheModel.layout = getLayout();

		String layout = dataCollectionLayoutCacheModel.layout;

		if ((layout != null) && (layout.length() == 0)) {
			dataCollectionLayoutCacheModel.layout = null;
		}

		return dataCollectionLayoutCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DataCollectionLayout, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DataCollectionLayout, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataCollectionLayout, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((DataCollectionLayout)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DataCollectionLayout, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DataCollectionLayout, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataCollectionLayout, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((DataCollectionLayout)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, DataCollectionLayout>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _dataCollectionId;
	private String _layout;
	private DataCollectionLayout _escapedModel;

}