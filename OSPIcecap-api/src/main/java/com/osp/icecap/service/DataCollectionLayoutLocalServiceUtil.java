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
 * Provides the local service utility for DataCollectionLayout. This utility wraps
 * <code>com.osp.icecap.service.impl.DataCollectionLayoutLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see DataCollectionLayoutLocalService
 * @generated
 */
@ProviderType
public class DataCollectionLayoutLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.DataCollectionLayoutLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data collection layout to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionLayout the data collection layout
	 * @return the data collection layout that was added
	 */
	public static com.osp.icecap.model.DataCollectionLayout
		addDataCollectionLayout(
			com.osp.icecap.model.DataCollectionLayout dataCollectionLayout) {

		return getService().addDataCollectionLayout(dataCollectionLayout);
	}

	public static com.osp.icecap.model.DataCollectionLayout
		addDataCollectionLayout(long dataCollectionId, String jsonLayout) {

		return getService().addDataCollectionLayout(
			dataCollectionId, jsonLayout);
	}

	/**
	 * Creates a new data collection layout with the primary key. Does not add the data collection layout to the database.
	 *
	 * @param dataCollectionId the primary key for the new data collection layout
	 * @return the new data collection layout
	 */
	public static com.osp.icecap.model.DataCollectionLayout
		createDataCollectionLayout(long dataCollectionId) {

		return getService().createDataCollectionLayout(dataCollectionId);
	}

	/**
	 * Deletes the data collection layout from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionLayout the data collection layout
	 * @return the data collection layout that was removed
	 */
	public static com.osp.icecap.model.DataCollectionLayout
		deleteDataCollectionLayout(
			com.osp.icecap.model.DataCollectionLayout dataCollectionLayout) {

		return getService().deleteDataCollectionLayout(dataCollectionLayout);
	}

	/**
	 * Deletes the data collection layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionId the primary key of the data collection layout
	 * @return the data collection layout that was removed
	 * @throws PortalException if a data collection layout with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataCollectionLayout
			deleteDataCollectionLayout(long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDataCollectionLayout(dataCollectionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.osp.icecap.model.DataCollectionLayout
		fetchDataCollectionLayout(long dataCollectionId) {

		return getService().fetchDataCollectionLayout(dataCollectionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the data collection layout with the primary key.
	 *
	 * @param dataCollectionId the primary key of the data collection layout
	 * @return the data collection layout
	 * @throws PortalException if a data collection layout with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataCollectionLayout
			getDataCollectionLayout(long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataCollectionLayout(dataCollectionId);
	}

	/**
	 * Returns a range of all the data collection layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collection layouts
	 * @param end the upper bound of the range of data collection layouts (not inclusive)
	 * @return the range of data collection layouts
	 */
	public static java.util.List<com.osp.icecap.model.DataCollectionLayout>
		getDataCollectionLayouts(int start, int end) {

		return getService().getDataCollectionLayouts(start, end);
	}

	/**
	 * Returns the number of data collection layouts.
	 *
	 * @return the number of data collection layouts
	 */
	public static int getDataCollectionLayoutsCount() {
		return getService().getDataCollectionLayoutsCount();
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

	public static com.osp.icecap.model.DataCollectionLayout
			removeDataCollectionLayout(long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeDataCollectionLayout(dataCollectionId);
	}

	/**
	 * Updates the data collection layout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionLayout the data collection layout
	 * @return the data collection layout that was updated
	 */
	public static com.osp.icecap.model.DataCollectionLayout
		updateDataCollectionLayout(
			com.osp.icecap.model.DataCollectionLayout dataCollectionLayout) {

		return getService().updateDataCollectionLayout(dataCollectionLayout);
	}

	public static com.osp.icecap.model.DataCollectionLayout
		updateDataCollectionLayout(long dataCollectionId, String jsonLayout) {

		return getService().updateDataCollectionLayout(
			dataCollectionId, jsonLayout);
	}

	public static DataCollectionLayoutLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataCollectionLayoutLocalService, DataCollectionLayoutLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DataCollectionLayoutLocalService.class);

		ServiceTracker
			<DataCollectionLayoutLocalService, DataCollectionLayoutLocalService>
				serviceTracker =
					new ServiceTracker
						<DataCollectionLayoutLocalService,
						 DataCollectionLayoutLocalService>(
							 bundle.getBundleContext(),
							 DataCollectionLayoutLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}