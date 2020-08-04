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
 * Provides the local service utility for DataCollection. This utility wraps
 * <code>com.osp.icecap.service.impl.DataCollectionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see DataCollectionLocalService
 * @generated
 */
@ProviderType
public class DataCollectionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.DataCollectionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data collection to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was added
	 */
	public static com.osp.icecap.model.DataCollection addDataCollection(
		com.osp.icecap.model.DataCollection dataCollection) {

		return getService().addDataCollection(dataCollection);
	}

	public static com.osp.icecap.model.DataCollection addDataCollection(
			String name, String version, long organizationId,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			String layout, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addDataCollection(
			name, version, organizationId, metaDataJSON, layout, sc);
	}

	/**
	 * Creates a new data collection with the primary key. Does not add the data collection to the database.
	 *
	 * @param dataCollectionId the primary key for the new data collection
	 * @return the new data collection
	 */
	public static com.osp.icecap.model.DataCollection createDataCollection(
		long dataCollectionId) {

		return getService().createDataCollection(dataCollectionId);
	}

	/**
	 * Deletes the data collection from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was removed
	 */
	public static com.osp.icecap.model.DataCollection deleteDataCollection(
		com.osp.icecap.model.DataCollection dataCollection) {

		return getService().deleteDataCollection(dataCollection);
	}

	/**
	 * Deletes the data collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection that was removed
	 * @throws PortalException if a data collection with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataCollection deleteDataCollection(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDataCollection(dataCollectionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.osp.icecap.model.DataCollection fetchDataCollection(
		long dataCollectionId) {

		return getService().fetchDataCollection(dataCollectionId);
	}

	/**
	 * Returns the data collection matching the UUID and group.
	 *
	 * @param uuid the data collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public static com.osp.icecap.model.DataCollection
		fetchDataCollectionByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchDataCollectionByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the data collection with the primary key.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection
	 * @throws PortalException if a data collection with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataCollection getDataCollection(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataCollection(dataCollectionId);
	}

	public static com.osp.icecap.model.DataCollection
			getDataCollectionByNameVersion(
				String dataCollectionName, String dataCollectionVersion)
		throws com.osp.icecap.exception.NoSuchDataCollectionException {

		return getService().getDataCollectionByNameVersion(
			dataCollectionName, dataCollectionVersion);
	}

	/**
	 * Returns the data collection matching the UUID and group.
	 *
	 * @param uuid the data collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data collection
	 * @throws PortalException if a matching data collection could not be found
	 */
	public static com.osp.icecap.model.DataCollection
			getDataCollectionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataCollectionByUuidAndGroupId(uuid, groupId);
	}

	public static int getDataCollectionCountAll() {
		return getService().getDataCollectionCountAll();
	}

	public static int getDataCollectionCountByGroupId(long groupId) {
		return getService().getDataCollectionCountByGroupId(groupId);
	}

	public static int getDataCollectionCountByName(String dataCollectionName) {
		return getService().getDataCollectionCountByName(dataCollectionName);
	}

	public static int getDataCollectionCountByUserId(long userId) {
		return getService().getDataCollectionCountByUserId(userId);
	}

	public static String getDataCollectionLayout(long dataCollectionId)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException,
			   com.osp.icecap.exception.NoSuchDataCollectionException {

		return getService().getDataCollectionLayout(dataCollectionId);
	}

	public static com.osp.icecap.model.MetaData getDataCollectionMetaData(
			long dataCollectionId)
		throws com.osp.icecap.exception.NoSuchDataCollectionException,
			   com.osp.icecap.exception.NoSuchMetaDataException {

		return getService().getDataCollectionMetaData(dataCollectionId);
	}

	/**
	 * Returns a range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of data collections
	 */
	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollections(int start, int end) {

		return getService().getDataCollections(start, end);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsAll() {

		return getService().getDataCollectionsAll();
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsAll(int start, int end) {

		return getService().getDataCollectionsAll(start, end);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByGroupId(long groupId) {

		return getService().getDataCollectionsByGroupId(groupId);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByGroupId(long groupId, int start, int end) {

		return getService().getDataCollectionsByGroupId(groupId, start, end);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByName(String dataCollectionName) {

		return getService().getDataCollectionsByName(dataCollectionName);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByName(
			String dataCollectionName, int start, int end) {

		return getService().getDataCollectionsByName(
			dataCollectionName, start, end);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByUserId(long userId) {

		return getService().getDataCollectionsByUserId(userId);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByUserId(long userId, int start, int end) {

		return getService().getDataCollectionsByUserId(userId, start, end);
	}

	/**
	 * Returns all the data collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data collections
	 * @param companyId the primary key of the company
	 * @return the matching data collections, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getDataCollectionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data collections
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data collections, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icecap.model.DataCollection> orderByComparator) {

		return getService().getDataCollectionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data collections.
	 *
	 * @return the number of data collections
	 */
	public static int getDataCollectionsCount() {
		return getService().getDataCollectionsCount();
	}

	public static int getDataCollectionVariantCount(long dataCollectionId) {
		return getService().getDataCollectionVariantCount(dataCollectionId);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionVariants(long dataCollectionId) {

		return getService().getDataCollectionVariants(dataCollectionId);
	}

	public static java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionVariants(long dataCollectionId, int start, int end) {

		return getService().getDataCollectionVariants(
			dataCollectionId, start, end);
	}

	public static java.util.List<com.osp.icecap.model.DataSet>
		getDataSetsByDataCollectionId(long dataCollectionId) {

		return getService().getDataSetsByDataCollectionId(dataCollectionId);
	}

	public static java.util.List<com.osp.icecap.model.DataSet>
		getDataSetsByDataCollectionId(
			long dataCollectionId, int start, int end) {

		return getService().getDataSetsByDataCollectionId(
			dataCollectionId, start, end);
	}

	public static int getDataSetsCountByDataCollectionId(
		long dataCollectionId) {

		return getService().getDataSetsCountByDataCollectionId(
			dataCollectionId);
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

	/**
	 * Removes all DataCollection related stuff.
	 * DataAnalysysLayout
	 * DataSet
	 * DataPack
	 * DataEntry
	 */
	public static com.osp.icecap.model.DataCollection removeDataCollection(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeDataCollection(dataCollectionId);
	}

	/**
	 * Updates the data collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was updated
	 */
	public static com.osp.icecap.model.DataCollection updateDataCollection(
		com.osp.icecap.model.DataCollection dataCollection) {

		return getService().updateDataCollection(dataCollection);
	}

	public static com.osp.icecap.model.DataCollection updateDataCollection(
			long dataCollectionId, String name, String version,
			long organizationId,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			String layout, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateDataCollection(
			dataCollectionId, name, version, organizationId, metaDataJSON,
			layout, sc);
	}

	public static DataCollectionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataCollectionLocalService, DataCollectionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DataCollectionLocalService.class);

		ServiceTracker<DataCollectionLocalService, DataCollectionLocalService>
			serviceTracker =
				new ServiceTracker
					<DataCollectionLocalService, DataCollectionLocalService>(
						bundle.getBundleContext(),
						DataCollectionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}