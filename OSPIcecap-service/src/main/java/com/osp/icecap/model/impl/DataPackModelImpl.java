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
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import com.osp.icecap.model.DataPack;
import com.osp.icecap.model.DataPackModel;
import com.osp.icecap.model.DataPackSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the DataPack service. Represents a row in the &quot;ICECAP_DataPack&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DataPackModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataPackImpl}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataPackImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DataPackModelImpl
	extends BaseModelImpl<DataPack> implements DataPackModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data pack model instance should use the <code>DataPack</code> interface instead.
	 */
	public static final String TABLE_NAME = "ICECAP_DataPack";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"dataPackId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"dataCollectionId", Types.BIGINT}, {"dataSetId", Types.BIGINT},
		{"dataSectionId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"version", Types.VARCHAR}, {"component", Types.VARCHAR},
		{"copiedFrom", Types.BIGINT}, {"hasMetaData", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dataPackId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dataCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dataSetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dataSectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("version", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("component", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("copiedFrom", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("hasMetaData", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ICECAP_DataPack (uuid_ VARCHAR(75) null,dataPackId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,dataCollectionId LONG,dataSetId LONG,dataSectionId LONG,name VARCHAR(75) null,version VARCHAR(75) null,component VARCHAR(75) null,copiedFrom LONG,hasMetaData BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table ICECAP_DataPack";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dataPack.dataPackId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ICECAP_DataPack.dataPackId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long COPIEDFROM_COLUMN_BITMASK = 2L;

	public static final long DATACOLLECTIONID_COLUMN_BITMASK = 4L;

	public static final long DATASECTIONID_COLUMN_BITMASK = 8L;

	public static final long DATASETID_COLUMN_BITMASK = 16L;

	public static final long GROUPID_COLUMN_BITMASK = 32L;

	public static final long NAME_COLUMN_BITMASK = 64L;

	public static final long STATUS_COLUMN_BITMASK = 128L;

	public static final long USERID_COLUMN_BITMASK = 256L;

	public static final long UUID_COLUMN_BITMASK = 512L;

	public static final long DATAPACKID_COLUMN_BITMASK = 1024L;

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
	public static DataPack toModel(DataPackSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DataPack model = new DataPackImpl();

		model.setUuid(soapModel.getUuid());
		model.setDataPackId(soapModel.getDataPackId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setDataCollectionId(soapModel.getDataCollectionId());
		model.setDataSetId(soapModel.getDataSetId());
		model.setDataSectionId(soapModel.getDataSectionId());
		model.setName(soapModel.getName());
		model.setVersion(soapModel.getVersion());
		model.setComponent(soapModel.getComponent());
		model.setCopiedFrom(soapModel.getCopiedFrom());
		model.setHasMetaData(soapModel.isHasMetaData());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DataPack> toModels(DataPackSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DataPack> models = new ArrayList<DataPack>(soapModels.length);

		for (DataPackSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public DataPackModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dataPackId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDataPackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataPackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DataPack.class;
	}

	@Override
	public String getModelClassName() {
		return DataPack.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DataPack, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DataPack, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataPack, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((DataPack)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DataPack, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DataPack, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DataPack)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DataPack, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DataPack, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DataPack>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DataPack.class.getClassLoader(), DataPack.class,
			ModelWrapper.class);

		try {
			Constructor<DataPack> constructor =
				(Constructor<DataPack>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DataPack, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DataPack, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DataPack, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DataPack, Object>>();
		Map<String, BiConsumer<DataPack, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DataPack, ?>>();

		attributeGetterFunctions.put("uuid", DataPack::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<DataPack, String>)DataPack::setUuid);
		attributeGetterFunctions.put("dataPackId", DataPack::getDataPackId);
		attributeSetterBiConsumers.put(
			"dataPackId", (BiConsumer<DataPack, Long>)DataPack::setDataPackId);
		attributeGetterFunctions.put("companyId", DataPack::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<DataPack, Long>)DataPack::setCompanyId);
		attributeGetterFunctions.put("groupId", DataPack::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<DataPack, Long>)DataPack::setGroupId);
		attributeGetterFunctions.put("userId", DataPack::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<DataPack, Long>)DataPack::setUserId);
		attributeGetterFunctions.put("userName", DataPack::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<DataPack, String>)DataPack::setUserName);
		attributeGetterFunctions.put("createDate", DataPack::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<DataPack, Date>)DataPack::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", DataPack::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DataPack, Date>)DataPack::setModifiedDate);
		attributeGetterFunctions.put("status", DataPack::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<DataPack, Integer>)DataPack::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", DataPack::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<DataPack, Long>)DataPack::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", DataPack::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<DataPack, String>)DataPack::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", DataPack::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate", (BiConsumer<DataPack, Date>)DataPack::setStatusDate);
		attributeGetterFunctions.put(
			"dataCollectionId", DataPack::getDataCollectionId);
		attributeSetterBiConsumers.put(
			"dataCollectionId",
			(BiConsumer<DataPack, Long>)DataPack::setDataCollectionId);
		attributeGetterFunctions.put("dataSetId", DataPack::getDataSetId);
		attributeSetterBiConsumers.put(
			"dataSetId", (BiConsumer<DataPack, Long>)DataPack::setDataSetId);
		attributeGetterFunctions.put(
			"dataSectionId", DataPack::getDataSectionId);
		attributeSetterBiConsumers.put(
			"dataSectionId",
			(BiConsumer<DataPack, Long>)DataPack::setDataSectionId);
		attributeGetterFunctions.put("name", DataPack::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<DataPack, String>)DataPack::setName);
		attributeGetterFunctions.put("version", DataPack::getVersion);
		attributeSetterBiConsumers.put(
			"version", (BiConsumer<DataPack, String>)DataPack::setVersion);
		attributeGetterFunctions.put("component", DataPack::getComponent);
		attributeSetterBiConsumers.put(
			"component", (BiConsumer<DataPack, String>)DataPack::setComponent);
		attributeGetterFunctions.put("copiedFrom", DataPack::getCopiedFrom);
		attributeSetterBiConsumers.put(
			"copiedFrom", (BiConsumer<DataPack, Long>)DataPack::setCopiedFrom);
		attributeGetterFunctions.put("hasMetaData", DataPack::getHasMetaData);
		attributeSetterBiConsumers.put(
			"hasMetaData",
			(BiConsumer<DataPack, Boolean>)DataPack::setHasMetaData);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getDataPackId() {
		return _dataPackId;
	}

	@Override
	public void setDataPackId(long dataPackId) {
		_dataPackId = dataPackId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	@Override
	public void setDataCollectionId(long dataCollectionId) {
		_columnBitmask |= DATACOLLECTIONID_COLUMN_BITMASK;

		if (!_setOriginalDataCollectionId) {
			_setOriginalDataCollectionId = true;

			_originalDataCollectionId = _dataCollectionId;
		}

		_dataCollectionId = dataCollectionId;
	}

	public long getOriginalDataCollectionId() {
		return _originalDataCollectionId;
	}

	@JSON
	@Override
	public long getDataSetId() {
		return _dataSetId;
	}

	@Override
	public void setDataSetId(long dataSetId) {
		_columnBitmask |= DATASETID_COLUMN_BITMASK;

		if (!_setOriginalDataSetId) {
			_setOriginalDataSetId = true;

			_originalDataSetId = _dataSetId;
		}

		_dataSetId = dataSetId;
	}

	public long getOriginalDataSetId() {
		return _originalDataSetId;
	}

	@JSON
	@Override
	public long getDataSectionId() {
		return _dataSectionId;
	}

	@Override
	public void setDataSectionId(long dataSectionId) {
		_columnBitmask |= DATASECTIONID_COLUMN_BITMASK;

		if (!_setOriginalDataSectionId) {
			_setOriginalDataSectionId = true;

			_originalDataSectionId = _dataSectionId;
		}

		_dataSectionId = dataSectionId;
	}

	public long getOriginalDataSectionId() {
		return _originalDataSectionId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getVersion() {
		if (_version == null) {
			return "";
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_version = version;
	}

	@JSON
	@Override
	public String getComponent() {
		if (_component == null) {
			return "";
		}
		else {
			return _component;
		}
	}

	@Override
	public void setComponent(String component) {
		_component = component;
	}

	@JSON
	@Override
	public long getCopiedFrom() {
		return _copiedFrom;
	}

	@Override
	public void setCopiedFrom(long copiedFrom) {
		_columnBitmask |= COPIEDFROM_COLUMN_BITMASK;

		if (!_setOriginalCopiedFrom) {
			_setOriginalCopiedFrom = true;

			_originalCopiedFrom = _copiedFrom;
		}

		_copiedFrom = copiedFrom;
	}

	public long getOriginalCopiedFrom() {
		return _originalCopiedFrom;
	}

	@JSON
	@Override
	public boolean getHasMetaData() {
		return _hasMetaData;
	}

	@JSON
	@Override
	public boolean isHasMetaData() {
		return _hasMetaData;
	}

	@Override
	public void setHasMetaData(boolean hasMetaData) {
		_hasMetaData = hasMetaData;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DataPack.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DataPack.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DataPack toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DataPack>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DataPackImpl dataPackImpl = new DataPackImpl();

		dataPackImpl.setUuid(getUuid());
		dataPackImpl.setDataPackId(getDataPackId());
		dataPackImpl.setCompanyId(getCompanyId());
		dataPackImpl.setGroupId(getGroupId());
		dataPackImpl.setUserId(getUserId());
		dataPackImpl.setUserName(getUserName());
		dataPackImpl.setCreateDate(getCreateDate());
		dataPackImpl.setModifiedDate(getModifiedDate());
		dataPackImpl.setStatus(getStatus());
		dataPackImpl.setStatusByUserId(getStatusByUserId());
		dataPackImpl.setStatusByUserName(getStatusByUserName());
		dataPackImpl.setStatusDate(getStatusDate());
		dataPackImpl.setDataCollectionId(getDataCollectionId());
		dataPackImpl.setDataSetId(getDataSetId());
		dataPackImpl.setDataSectionId(getDataSectionId());
		dataPackImpl.setName(getName());
		dataPackImpl.setVersion(getVersion());
		dataPackImpl.setComponent(getComponent());
		dataPackImpl.setCopiedFrom(getCopiedFrom());
		dataPackImpl.setHasMetaData(isHasMetaData());

		dataPackImpl.resetOriginalValues();

		return dataPackImpl;
	}

	@Override
	public int compareTo(DataPack dataPack) {
		long primaryKey = dataPack.getPrimaryKey();

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

		if (!(obj instanceof DataPack)) {
			return false;
		}

		DataPack dataPack = (DataPack)obj;

		long primaryKey = dataPack.getPrimaryKey();

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
		DataPackModelImpl dataPackModelImpl = this;

		dataPackModelImpl._originalUuid = dataPackModelImpl._uuid;

		dataPackModelImpl._originalCompanyId = dataPackModelImpl._companyId;

		dataPackModelImpl._setOriginalCompanyId = false;

		dataPackModelImpl._originalGroupId = dataPackModelImpl._groupId;

		dataPackModelImpl._setOriginalGroupId = false;

		dataPackModelImpl._originalUserId = dataPackModelImpl._userId;

		dataPackModelImpl._setOriginalUserId = false;

		dataPackModelImpl._setModifiedDate = false;

		dataPackModelImpl._originalStatus = dataPackModelImpl._status;

		dataPackModelImpl._setOriginalStatus = false;

		dataPackModelImpl._originalDataCollectionId =
			dataPackModelImpl._dataCollectionId;

		dataPackModelImpl._setOriginalDataCollectionId = false;

		dataPackModelImpl._originalDataSetId = dataPackModelImpl._dataSetId;

		dataPackModelImpl._setOriginalDataSetId = false;

		dataPackModelImpl._originalDataSectionId =
			dataPackModelImpl._dataSectionId;

		dataPackModelImpl._setOriginalDataSectionId = false;

		dataPackModelImpl._originalName = dataPackModelImpl._name;

		dataPackModelImpl._originalCopiedFrom = dataPackModelImpl._copiedFrom;

		dataPackModelImpl._setOriginalCopiedFrom = false;

		dataPackModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DataPack> toCacheModel() {
		DataPackCacheModel dataPackCacheModel = new DataPackCacheModel();

		dataPackCacheModel.uuid = getUuid();

		String uuid = dataPackCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dataPackCacheModel.uuid = null;
		}

		dataPackCacheModel.dataPackId = getDataPackId();

		dataPackCacheModel.companyId = getCompanyId();

		dataPackCacheModel.groupId = getGroupId();

		dataPackCacheModel.userId = getUserId();

		dataPackCacheModel.userName = getUserName();

		String userName = dataPackCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dataPackCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dataPackCacheModel.createDate = createDate.getTime();
		}
		else {
			dataPackCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dataPackCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dataPackCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dataPackCacheModel.status = getStatus();

		dataPackCacheModel.statusByUserId = getStatusByUserId();

		dataPackCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = dataPackCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			dataPackCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			dataPackCacheModel.statusDate = statusDate.getTime();
		}
		else {
			dataPackCacheModel.statusDate = Long.MIN_VALUE;
		}

		dataPackCacheModel.dataCollectionId = getDataCollectionId();

		dataPackCacheModel.dataSetId = getDataSetId();

		dataPackCacheModel.dataSectionId = getDataSectionId();

		dataPackCacheModel.name = getName();

		String name = dataPackCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			dataPackCacheModel.name = null;
		}

		dataPackCacheModel.version = getVersion();

		String version = dataPackCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			dataPackCacheModel.version = null;
		}

		dataPackCacheModel.component = getComponent();

		String component = dataPackCacheModel.component;

		if ((component != null) && (component.length() == 0)) {
			dataPackCacheModel.component = null;
		}

		dataPackCacheModel.copiedFrom = getCopiedFrom();

		dataPackCacheModel.hasMetaData = isHasMetaData();

		return dataPackCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DataPack, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DataPack, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataPack, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DataPack)this));
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
		Map<String, Function<DataPack, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DataPack, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataPack, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DataPack)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DataPack>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _dataPackId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _dataCollectionId;
	private long _originalDataCollectionId;
	private boolean _setOriginalDataCollectionId;
	private long _dataSetId;
	private long _originalDataSetId;
	private boolean _setOriginalDataSetId;
	private long _dataSectionId;
	private long _originalDataSectionId;
	private boolean _setOriginalDataSectionId;
	private String _name;
	private String _originalName;
	private String _version;
	private String _component;
	private long _copiedFrom;
	private long _originalCopiedFrom;
	private boolean _setOriginalCopiedFrom;
	private boolean _hasMetaData;
	private long _columnBitmask;
	private DataPack _escapedModel;

}