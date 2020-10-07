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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MetaData. This utility wraps
 * <code>com.osp.icecap.service.impl.MetaDataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see MetaDataLocalService
 * @generated
 */
public class MetaDataLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.MetaDataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the meta data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param metaData the meta data
	 * @return the meta data that was added
	 */
	public static com.osp.icecap.model.MetaData addMetaData(
		com.osp.icecap.model.MetaData metaData) {

		return getService().addMetaData(metaData);
	}

	public static com.osp.icecap.model.MetaData addMetaData(
			String dataUuid,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON)
		throws com.osp.icecap.exception.NoSuchMetaDataFieldException {

		return getService().addMetaData(dataUuid, metaDataJSON);
	}

	/**
	 * Creates a new meta data with the primary key. Does not add the meta data to the database.
	 *
	 * @param dataUuid the primary key for the new meta data
	 * @return the new meta data
	 */
	public static com.osp.icecap.model.MetaData createMetaData(
		String dataUuid) {

		return getService().createMetaData(dataUuid);
	}

	/**
	 * Deletes the meta data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metaData the meta data
	 * @return the meta data that was removed
	 */
	public static com.osp.icecap.model.MetaData deleteMetaData(
		com.osp.icecap.model.MetaData metaData) {

		return getService().deleteMetaData(metaData);
	}

	/**
	 * Deletes the meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data that was removed
	 * @throws PortalException if a meta data with the primary key could not be found
	 */
	public static com.osp.icecap.model.MetaData deleteMetaData(String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMetaData(dataUuid);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.MetaDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.MetaDataModelImpl</code>.
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

	public static com.osp.icecap.model.MetaData fetchMetaData(String dataUuid) {
		return getService().fetchMetaData(dataUuid);
	}

	/**
	 * Returns the meta data with the primary key.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data
	 * @throws PortalException if a meta data with the primary key could not be found
	 */
	public static com.osp.icecap.model.MetaData getMetaData(String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMetaData(dataUuid);
	}

	/**
	 * Returns a range of all the meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.MetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of meta datas
	 */
	public static java.util.List<com.osp.icecap.model.MetaData> getMetaDatas(
		int start, int end) {

		return getService().getMetaDatas(start, end);
	}

	/**
	 * Returns the number of meta datas.
	 *
	 * @return the number of meta datas
	 */
	public static int getMetaDatasCount() {
		return getService().getMetaDatasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void removeByDataCollectionId(long dataCollectionId) {
		getService().removeByDataCollectionId(dataCollectionId);
	}

	public static void removeByDataPackId(long dataPackId) {
		getService().removeByDataPackId(dataPackId);
	}

	public static void removeByDataSectionId(long dataSectionId) {
		getService().removeByDataSectionId(dataSectionId);
	}

	public static void removeByDataSetId(long dataSetId) {
		getService().removeByDataSetId(dataSetId);
	}

	public static com.osp.icecap.model.MetaData removeMetaData(
		com.osp.icecap.model.MetaData metaData) {

		return getService().removeMetaData(metaData);
	}

	public static com.osp.icecap.model.MetaData removeMetaData(String dataUuid)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getService().removeMetaData(dataUuid);
	}

	/**
	 * Updates the meta data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param metaData the meta data
	 * @return the meta data that was updated
	 */
	public static com.osp.icecap.model.MetaData updateMetaData(
		com.osp.icecap.model.MetaData metaData) {

		return getService().updateMetaData(metaData);
	}

	public static com.osp.icecap.model.MetaData updateMetaData(
			String dataUuid,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON)
		throws com.osp.icecap.exception.NoSuchMetaDataException,
			   com.osp.icecap.exception.NoSuchMetaDataFieldException {

		return getService().updateMetaData(dataUuid, metaDataJSON);
	}

	public static MetaDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MetaDataLocalService, MetaDataLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MetaDataLocalService.class);

		ServiceTracker<MetaDataLocalService, MetaDataLocalService>
			serviceTracker =
				new ServiceTracker<MetaDataLocalService, MetaDataLocalService>(
					bundle.getBundleContext(), MetaDataLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}