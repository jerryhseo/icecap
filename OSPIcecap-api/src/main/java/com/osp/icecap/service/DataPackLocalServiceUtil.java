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
 * Provides the local service utility for DataPack. This utility wraps
 * <code>com.osp.icecap.service.impl.DataPackLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see DataPackLocalService
 * @generated
 */
@ProviderType
public class DataPackLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.DataPackLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data pack to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was added
	 */
	public static com.osp.icecap.model.DataPack addDataPack(
		com.osp.icecap.model.DataPack dataPack) {

		return getService().addDataPack(dataPack);
	}

	public static com.osp.icecap.model.DataPack addDataPack(
			long dataCollectionId, long dataSetId, long dataSectionId,
			String name, String version, long copiedFrom,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			String layout, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addDataPack(
			dataCollectionId, dataSetId, dataSectionId, name, version,
			copiedFrom, metaDataJSON, layout, sc);
	}

	/**
	 * Creates a new data pack with the primary key. Does not add the data pack to the database.
	 *
	 * @param dataPackId the primary key for the new data pack
	 * @return the new data pack
	 */
	public static com.osp.icecap.model.DataPack createDataPack(
		long dataPackId) {

		return getService().createDataPack(dataPackId);
	}

	/**
	 * Deletes the data pack from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was removed
	 */
	public static com.osp.icecap.model.DataPack deleteDataPack(
		com.osp.icecap.model.DataPack dataPack) {

		return getService().deleteDataPack(dataPack);
	}

	/**
	 * Deletes the data pack with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack that was removed
	 * @throws PortalException if a data pack with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataPack deleteDataPack(long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDataPack(dataPackId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataPackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataPackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.osp.icecap.model.DataPack fetchDataPack(long dataPackId) {
		return getService().fetchDataPack(dataPackId);
	}

	/**
	 * Returns the data pack matching the UUID and group.
	 *
	 * @param uuid the data pack's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static com.osp.icecap.model.DataPack fetchDataPackByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDataPackByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.osp.icecap.model.DataEntry>
		getDataEntriesByDataPackId(long dataPackId) {

		return getService().getDataEntriesByDataPackId(dataPackId);
	}

	public static java.util.List<com.osp.icecap.model.DataEntry>
		getDataEntriesByDataPackId(long dataPackId, int start, int end) {

		return getService().getDataEntriesByDataPackId(dataPackId, start, end);
	}

	public static int getDataEntriesCountByDataPackId(long dataPackId) {
		return getService().getDataEntriesCountByDataPackId(dataPackId);
	}

	/**
	 * Returns the data pack with the primary key.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack
	 * @throws PortalException if a data pack with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataPack getDataPack(long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataPack(dataPackId);
	}

	/**
	 * Returns the data pack matching the UUID and group.
	 *
	 * @param uuid the data pack's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack
	 * @throws PortalException if a matching data pack could not be found
	 */
	public static com.osp.icecap.model.DataPack getDataPackByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataPackByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the data packs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataPackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of data packs
	 */
	public static java.util.List<com.osp.icecap.model.DataPack> getDataPacks(
		int start, int end) {

		return getService().getDataPacks(start, end);
	}

	public static java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByDataSectionId(long dataSectionId) {

		return getService().getDataPacksByDataSectionId(dataSectionId);
	}

	public static java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByDataSectionId(long dataSectionId, int start, int end) {

		return getService().getDataPacksByDataSectionId(
			dataSectionId, start, end);
	}

	/**
	 * Returns all the data packs matching the UUID and company.
	 *
	 * @param uuid the UUID of the data packs
	 * @param companyId the primary key of the company
	 * @return the matching data packs, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getDataPacksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of data packs matching the UUID and company.
	 *
	 * @param uuid the UUID of the data packs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data packs, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icecap.model.DataPack> orderByComparator) {

		return getService().getDataPacksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data packs.
	 *
	 * @return the number of data packs
	 */
	public static int getDataPacksCount() {
		return getService().getDataPacksCount();
	}

	public static int getDataPacksCountByDataSectionId(long dataSectionId) {
		return getService().getDataPacksCountByDataSectionId(dataSectionId);
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

	public static com.osp.icecap.model.DataPack removeDataPack(long dataPackId)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getService().removeDataPack(dataPackId);
	}

	/**
	 * Updates the data pack in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was updated
	 */
	public static com.osp.icecap.model.DataPack updateDataPack(
		com.osp.icecap.model.DataPack dataPack) {

		return getService().updateDataPack(dataPack);
	}

	public static com.osp.icecap.model.DataPack updateDataPack(
			long dataPackId, long dataCollectionId, long dataSetId,
			long dataSectionId, String name, String version, long copiedFrom,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			String layout, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.osp.icecap.exception.NoSuchDataPackException,
			   com.osp.icecap.exception.NoSuchMetaDataFieldException {

		return getService().updateDataPack(
			dataPackId, dataCollectionId, dataSetId, dataSectionId, name,
			version, copiedFrom, metaDataJSON, layout, sc);
	}

	public static DataPackLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DataPackLocalService, DataPackLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataPackLocalService.class);

		ServiceTracker<DataPackLocalService, DataPackLocalService>
			serviceTracker =
				new ServiceTracker<DataPackLocalService, DataPackLocalService>(
					bundle.getBundleContext(), DataPackLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}