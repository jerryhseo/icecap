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

import com.osp.icecap.model.DataSection;
import com.osp.icecap.model.DataSectionModel;
import com.osp.icecap.model.DataSectionSoap;

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
 * The base model implementation for the DataSection service. Represents a row in the &quot;ICECAP_DataSection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DataSectionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataSectionImpl}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataSectionImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DataSectionModelImpl
	extends BaseModelImpl<DataSection> implements DataSectionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data section model instance should use the <code>DataSection</code> interface instead.
	 */
	public static final String TABLE_NAME = "ICECAP_DataSection";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"dataSectionId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"dataCollectionId", Types.BIGINT}, {"dataSetId", Types.BIGINT},
		{"dataTypeId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"version", Types.VARCHAR}, {"copiedFrom", Types.BIGINT},
		{"hasMetaData", Types.BOOLEAN}, {"hasLayout", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dataSectionId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("dataTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("version", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("copiedFrom", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("hasMetaData", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("hasLayout", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ICECAP_DataSection (uuid_ VARCHAR(75) null,dataSectionId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,dataCollectionId LONG,dataSetId LONG,dataTypeId LONG,name VARCHAR(75) null,version VARCHAR(75) null,copiedFrom LONG,hasMetaData BOOLEAN,hasLayout BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table ICECAP_DataSection";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dataSection.dataSectionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ICECAP_DataSection.dataSectionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long COPIEDFROM_COLUMN_BITMASK = 2L;

	public static final long DATACOLLECTIONID_COLUMN_BITMASK = 4L;

	public static final long DATASETID_COLUMN_BITMASK = 8L;

	public static final long GROUPID_COLUMN_BITMASK = 16L;

	public static final long NAME_COLUMN_BITMASK = 32L;

	public static final long STATUS_COLUMN_BITMASK = 64L;

	public static final long USERID_COLUMN_BITMASK = 128L;

	public static final long UUID_COLUMN_BITMASK = 256L;

	public static final long DATASECTIONID_COLUMN_BITMASK = 512L;

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
	public static DataSection toModel(DataSectionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DataSection model = new DataSectionImpl();

		model.setUuid(soapModel.getUuid());
		model.setDataSectionId(soapModel.getDataSectionId());
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
		model.setDataTypeId(soapModel.getDataTypeId());
		model.setName(soapModel.getName());
		model.setVersion(soapModel.getVersion());
		model.setCopiedFrom(soapModel.getCopiedFrom());
		model.setHasMetaData(soapModel.isHasMetaData());
		model.setHasLayout(soapModel.isHasLayout());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DataSection> toModels(DataSectionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DataSection> models = new ArrayList<DataSection>(
			soapModels.length);

		for (DataSectionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public DataSectionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dataSectionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDataSectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataSectionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DataSection.class;
	}

	@Override
	public String getModelClassName() {
		return DataSection.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DataSection, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DataSection, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataSection, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DataSection)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DataSection, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DataSection, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DataSection)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DataSection, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DataSection, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DataSection>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DataSection.class.getClassLoader(), DataSection.class,
			ModelWrapper.class);

		try {
			Constructor<DataSection> constructor =
				(Constructor<DataSection>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DataSection, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DataSection, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DataSection, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DataSection, Object>>();
		Map<String, BiConsumer<DataSection, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DataSection, ?>>();

		attributeGetterFunctions.put("uuid", DataSection::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<DataSection, String>)DataSection::setUuid);
		attributeGetterFunctions.put(
			"dataSectionId", DataSection::getDataSectionId);
		attributeSetterBiConsumers.put(
			"dataSectionId",
			(BiConsumer<DataSection, Long>)DataSection::setDataSectionId);
		attributeGetterFunctions.put("companyId", DataSection::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DataSection, Long>)DataSection::setCompanyId);
		attributeGetterFunctions.put("groupId", DataSection::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<DataSection, Long>)DataSection::setGroupId);
		attributeGetterFunctions.put("userId", DataSection::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<DataSection, Long>)DataSection::setUserId);
		attributeGetterFunctions.put("userName", DataSection::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DataSection, String>)DataSection::setUserName);
		attributeGetterFunctions.put("createDate", DataSection::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DataSection, Date>)DataSection::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DataSection::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DataSection, Date>)DataSection::setModifiedDate);
		attributeGetterFunctions.put("status", DataSection::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<DataSection, Integer>)DataSection::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", DataSection::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<DataSection, Long>)DataSection::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", DataSection::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<DataSection, String>)DataSection::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", DataSection::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<DataSection, Date>)DataSection::setStatusDate);
		attributeGetterFunctions.put(
			"dataCollectionId", DataSection::getDataCollectionId);
		attributeSetterBiConsumers.put(
			"dataCollectionId",
			(BiConsumer<DataSection, Long>)DataSection::setDataCollectionId);
		attributeGetterFunctions.put("dataSetId", DataSection::getDataSetId);
		attributeSetterBiConsumers.put(
			"dataSetId",
			(BiConsumer<DataSection, Long>)DataSection::setDataSetId);
		attributeGetterFunctions.put("dataTypeId", DataSection::getDataTypeId);
		attributeSetterBiConsumers.put(
			"dataTypeId",
			(BiConsumer<DataSection, Long>)DataSection::setDataTypeId);
		attributeGetterFunctions.put("name", DataSection::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<DataSection, String>)DataSection::setName);
		attributeGetterFunctions.put("version", DataSection::getVersion);
		attributeSetterBiConsumers.put(
			"version",
			(BiConsumer<DataSection, String>)DataSection::setVersion);
		attributeGetterFunctions.put("copiedFrom", DataSection::getCopiedFrom);
		attributeSetterBiConsumers.put(
			"copiedFrom",
			(BiConsumer<DataSection, Long>)DataSection::setCopiedFrom);
		attributeGetterFunctions.put(
			"hasMetaData", DataSection::getHasMetaData);
		attributeSetterBiConsumers.put(
			"hasMetaData",
			(BiConsumer<DataSection, Boolean>)DataSection::setHasMetaData);
		attributeGetterFunctions.put("hasLayout", DataSection::getHasLayout);
		attributeSetterBiConsumers.put(
			"hasLayout",
			(BiConsumer<DataSection, Boolean>)DataSection::setHasLayout);

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
	public long getDataSectionId() {
		return _dataSectionId;
	}

	@Override
	public void setDataSectionId(long dataSectionId) {
		_dataSectionId = dataSectionId;
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
	public long getDataTypeId() {
		return _dataTypeId;
	}

	@Override
	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
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

	@JSON
	@Override
	public boolean getHasLayout() {
		return _hasLayout;
	}

	@JSON
	@Override
	public boolean isHasLayout() {
		return _hasLayout;
	}

	@Override
	public void setHasLayout(boolean hasLayout) {
		_hasLayout = hasLayout;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DataSection.class.getName()));
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
			getCompanyId(), DataSection.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DataSection toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DataSectionImpl dataSectionImpl = new DataSectionImpl();

		dataSectionImpl.setUuid(getUuid());
		dataSectionImpl.setDataSectionId(getDataSectionId());
		dataSectionImpl.setCompanyId(getCompanyId());
		dataSectionImpl.setGroupId(getGroupId());
		dataSectionImpl.setUserId(getUserId());
		dataSectionImpl.setUserName(getUserName());
		dataSectionImpl.setCreateDate(getCreateDate());
		dataSectionImpl.setModifiedDate(getModifiedDate());
		dataSectionImpl.setStatus(getStatus());
		dataSectionImpl.setStatusByUserId(getStatusByUserId());
		dataSectionImpl.setStatusByUserName(getStatusByUserName());
		dataSectionImpl.setStatusDate(getStatusDate());
		dataSectionImpl.setDataCollectionId(getDataCollectionId());
		dataSectionImpl.setDataSetId(getDataSetId());
		dataSectionImpl.setDataTypeId(getDataTypeId());
		dataSectionImpl.setName(getName());
		dataSectionImpl.setVersion(getVersion());
		dataSectionImpl.setCopiedFrom(getCopiedFrom());
		dataSectionImpl.setHasMetaData(isHasMetaData());
		dataSectionImpl.setHasLayout(isHasLayout());

		dataSectionImpl.resetOriginalValues();

		return dataSectionImpl;
	}

	@Override
	public int compareTo(DataSection dataSection) {
		long primaryKey = dataSection.getPrimaryKey();

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

		if (!(obj instanceof DataSection)) {
			return false;
		}

		DataSection dataSection = (DataSection)obj;

		long primaryKey = dataSection.getPrimaryKey();

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
		DataSectionModelImpl dataSectionModelImpl = this;

		dataSectionModelImpl._originalUuid = dataSectionModelImpl._uuid;

		dataSectionModelImpl._originalCompanyId =
			dataSectionModelImpl._companyId;

		dataSectionModelImpl._setOriginalCompanyId = false;

		dataSectionModelImpl._originalGroupId = dataSectionModelImpl._groupId;

		dataSectionModelImpl._setOriginalGroupId = false;

		dataSectionModelImpl._originalUserId = dataSectionModelImpl._userId;

		dataSectionModelImpl._setOriginalUserId = false;

		dataSectionModelImpl._setModifiedDate = false;

		dataSectionModelImpl._originalStatus = dataSectionModelImpl._status;

		dataSectionModelImpl._setOriginalStatus = false;

		dataSectionModelImpl._originalDataCollectionId =
			dataSectionModelImpl._dataCollectionId;

		dataSectionModelImpl._setOriginalDataCollectionId = false;

		dataSectionModelImpl._originalDataSetId =
			dataSectionModelImpl._dataSetId;

		dataSectionModelImpl._setOriginalDataSetId = false;

		dataSectionModelImpl._originalName = dataSectionModelImpl._name;

		dataSectionModelImpl._originalCopiedFrom =
			dataSectionModelImpl._copiedFrom;

		dataSectionModelImpl._setOriginalCopiedFrom = false;

		dataSectionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DataSection> toCacheModel() {
		DataSectionCacheModel dataSectionCacheModel =
			new DataSectionCacheModel();

		dataSectionCacheModel.uuid = getUuid();

		String uuid = dataSectionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dataSectionCacheModel.uuid = null;
		}

		dataSectionCacheModel.dataSectionId = getDataSectionId();

		dataSectionCacheModel.companyId = getCompanyId();

		dataSectionCacheModel.groupId = getGroupId();

		dataSectionCacheModel.userId = getUserId();

		dataSectionCacheModel.userName = getUserName();

		String userName = dataSectionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dataSectionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dataSectionCacheModel.createDate = createDate.getTime();
		}
		else {
			dataSectionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dataSectionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dataSectionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dataSectionCacheModel.status = getStatus();

		dataSectionCacheModel.statusByUserId = getStatusByUserId();

		dataSectionCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = dataSectionCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			dataSectionCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			dataSectionCacheModel.statusDate = statusDate.getTime();
		}
		else {
			dataSectionCacheModel.statusDate = Long.MIN_VALUE;
		}

		dataSectionCacheModel.dataCollectionId = getDataCollectionId();

		dataSectionCacheModel.dataSetId = getDataSetId();

		dataSectionCacheModel.dataTypeId = getDataTypeId();

		dataSectionCacheModel.name = getName();

		String name = dataSectionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			dataSectionCacheModel.name = null;
		}

		dataSectionCacheModel.version = getVersion();

		String version = dataSectionCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			dataSectionCacheModel.version = null;
		}

		dataSectionCacheModel.copiedFrom = getCopiedFrom();

		dataSectionCacheModel.hasMetaData = isHasMetaData();

		dataSectionCacheModel.hasLayout = isHasLayout();

		return dataSectionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DataSection, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DataSection, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataSection, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DataSection)this));
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
		Map<String, Function<DataSection, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DataSection, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataSection, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DataSection)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, DataSection>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _dataSectionId;
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
	private long _dataTypeId;
	private String _name;
	private String _originalName;
	private String _version;
	private long _copiedFrom;
	private long _originalCopiedFrom;
	private boolean _setOriginalCopiedFrom;
	private boolean _hasMetaData;
	private boolean _hasLayout;
	private long _columnBitmask;
	private DataSection _escapedModel;

}