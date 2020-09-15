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

package com.osp.icecap.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DataType. This utility wraps
 * <code>com.osp.icecap.service.impl.DataTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see DataTypeLocalService
 * @generated
 */
@ProviderType
public class DataTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.DataTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataType the data type
	 * @return the data type that was added
	 */
	public static com.osp.icecap.model.DataType addDataType(
		com.osp.icecap.model.DataType dataType) {

		return getService().addDataType(dataType);
	}

	public static com.osp.icecap.model.DataType addDataType(
			String dataTypeName, String dataTypeVersion,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String samplePath,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addDataType(
			dataTypeName, dataTypeVersion, descriptionMap, samplePath, sc);
	}

	public static com.osp.icecap.model.DataType copyDataType(
			long dataTypeId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().copyDataType(dataTypeId, sc);
	}

	public static int countDataTypesByName(String name) {
		return getService().countDataTypesByName(name);
	}

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeId the primary key for the new data type
	 * @return the new data type
	 */
	public static com.osp.icecap.model.DataType createDataType(
		long dataTypeId) {

		return getService().createDataType(dataTypeId);
	}

	/**
	 * Deletes the data type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataType the data type
	 * @return the data type that was removed
	 */
	public static com.osp.icecap.model.DataType deleteDataType(
		com.osp.icecap.model.DataType dataType) {

		return getService().deleteDataType(dataType);
	}

	/**
	 * Deletes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the data type
	 * @return the data type that was removed
	 * @throws PortalException if a data type with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataType deleteDataType(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDataType(dataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.osp.icecap.model.DataType fetchDataType(long dataTypeId) {
		return getService().fetchDataType(dataTypeId);
	}

	/**
	 * Returns the data type matching the UUID and group.
	 *
	 * @param uuid the data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public static com.osp.icecap.model.DataType fetchDataTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDataTypeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the data type with the primary key.
	 *
	 * @param dataTypeId the primary key of the data type
	 * @return the data type
	 * @throws PortalException if a data type with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataType getDataType(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataType(dataTypeId);
	}

	public static com.osp.icecap.model.DataType getDataType(
			String name, String version)
		throws com.osp.icecap.exception.NoSuchDataTypeException {

		return getService().getDataType(name, version);
	}

	/**
	 * Returns the data type matching the UUID and group.
	 *
	 * @param uuid the data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data type
	 * @throws PortalException if a matching data type could not be found
	 */
	public static com.osp.icecap.model.DataType getDataTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of data types
	 */
	public static java.util.List<com.osp.icecap.model.DataType> getDataTypes(
		int start, int end) {

		return getService().getDataTypes(start, end);
	}

	public static java.util.List<com.osp.icecap.model.DataType>
		getDataTypesByName(String name) {

		return getService().getDataTypesByName(name);
	}

	public static java.util.List<com.osp.icecap.model.DataType>
		getDataTypesByName(String name, int start, int end) {

		return getService().getDataTypesByName(name, start, end);
	}

	/**
	 * Returns all the data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the data types
	 * @param companyId the primary key of the company
	 * @return the matching data types, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icecap.model.DataType>
		getDataTypesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getDataTypesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the data types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data types, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icecap.model.DataType>
		getDataTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icecap.model.DataType> orderByComparator) {

		return getService().getDataTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	public static int getDataTypesCount() {
		return getService().getDataTypesCount();
	}

	public static com.liferay.portal.kernel.json.JSONObject
			getDataTypeStructureJSON(long dataTypeId)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getDataTypeStructureJSON(dataTypeId);
	}

	public static String getDataTypeStructureSTR(long dataTypeId) {
		return getService().getDataTypeStructureSTR(dataTypeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getDataTypeVisualizersJSON(long dataTypeId) {

		return getService().getDataTypeVisualizersJSON(dataTypeId);
	}

	public static String getDataTypeVisualizersSTR(long dataTypeId) {
		return getService().getDataTypeVisualizersSTR(dataTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.osp.icecap.model.DataType removeDataType(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeDataType(dataTypeId);
	}

	public static int removeDataTypeByName(String dataTypeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeDataTypeByName(dataTypeName);
	}

	public static com.osp.icecap.model.DataType removeDataTypeByNameVersion(
			String dataTypeName, String dataTypeVersion)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeDataTypeByNameVersion(
			dataTypeName, dataTypeVersion);
	}

	/**
	 * Updates the data type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataType the data type
	 * @return the data type that was updated
	 */
	public static com.osp.icecap.model.DataType updateDataType(
		com.osp.icecap.model.DataType dataType) {

		return getService().updateDataType(dataType);
	}

	public static com.osp.icecap.model.DataType updateDataType(
			long dataTypeId, String dataTypeName, String dataTypeVersion,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String samplePath,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateDataType(
			dataTypeId, dataTypeName, dataTypeVersion, descriptionMap,
			samplePath, sc);
	}

	public static DataTypeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DataTypeLocalService, DataTypeLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataTypeLocalService.class);

		ServiceTracker<DataTypeLocalService, DataTypeLocalService>
			serviceTracker =
				new ServiceTracker<DataTypeLocalService, DataTypeLocalService>(
					bundle.getBundleContext(), DataTypeLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}