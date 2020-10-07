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
 * Provides the local service utility for DataAnalysisLayout. This utility wraps
 * <code>com.osp.icecap.service.impl.DataAnalysisLayoutLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see DataAnalysisLayoutLocalService
 * @generated
 */
public class DataAnalysisLayoutLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.DataAnalysisLayoutLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data analysis layout to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was added
	 */
	public static com.osp.icecap.model.DataAnalysisLayout addDataAnalysisLayout(
		com.osp.icecap.model.DataAnalysisLayout dataAnalysisLayout) {

		return getService().addDataAnalysisLayout(dataAnalysisLayout);
	}

	public static com.liferay.portal.kernel.json.JSONObject
			addDataAnalysisLayout(String dataUuidStr, String layoutStr)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().addDataAnalysisLayout(dataUuidStr, layoutStr);
	}

	/**
	 * Creates a new data analysis layout with the primary key. Does not add the data analysis layout to the database.
	 *
	 * @param dataUuid the primary key for the new data analysis layout
	 * @return the new data analysis layout
	 */
	public static com.osp.icecap.model.DataAnalysisLayout
		createDataAnalysisLayout(String dataUuid) {

		return getService().createDataAnalysisLayout(dataUuid);
	}

	/**
	 * Deletes the data analysis layout from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was removed
	 */
	public static com.osp.icecap.model.DataAnalysisLayout
		deleteDataAnalysisLayout(
			com.osp.icecap.model.DataAnalysisLayout dataAnalysisLayout) {

		return getService().deleteDataAnalysisLayout(dataAnalysisLayout);
	}

	/**
	 * Deletes the data analysis layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout that was removed
	 * @throws PortalException if a data analysis layout with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataAnalysisLayout
			deleteDataAnalysisLayout(String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDataAnalysisLayout(dataUuid);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>.
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

	public static com.osp.icecap.model.DataAnalysisLayout
		fetchDataAnalysisLayout(String dataUuid) {

		return getService().fetchDataAnalysisLayout(dataUuid);
	}

	/**
	 * Returns the data analysis layout with the primary key.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout
	 * @throws PortalException if a data analysis layout with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataAnalysisLayout getDataAnalysisLayout(
			String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataAnalysisLayout(dataUuid);
	}

	public static com.liferay.portal.kernel.json.JSONObject
			getDataAnalysisLayoutJSON(String dataUuidStr)
		throws com.liferay.portal.kernel.json.JSONException,
			   com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getService().getDataAnalysisLayoutJSON(dataUuidStr);
	}

	/**
	 * Returns a range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of data analysis layouts
	 */
	public static java.util.List<com.osp.icecap.model.DataAnalysisLayout>
		getDataAnalysisLayouts(int start, int end) {

		return getService().getDataAnalysisLayouts(start, end);
	}

	/**
	 * Returns the number of data analysis layouts.
	 *
	 * @return the number of data analysis layouts
	 */
	public static int getDataAnalysisLayoutsCount() {
		return getService().getDataAnalysisLayoutsCount();
	}

	public static String getDataAnalysisLayoutStr(String dataUuidStr)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getService().getDataAnalysisLayoutStr(dataUuidStr);
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

	public static com.osp.icecap.model.DataAnalysisLayout
			removeDataAnalysisLayout(String dataUuid)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getService().removeDataAnalysisLayout(dataUuid);
	}

	/**
	 * Updates the data analysis layout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was updated
	 */
	public static com.osp.icecap.model.DataAnalysisLayout
		updateDataAnalysisLayout(
			com.osp.icecap.model.DataAnalysisLayout dataAnalysisLayout) {

		return getService().updateDataAnalysisLayout(dataAnalysisLayout);
	}

	public static com.liferay.portal.kernel.json.JSONObject
			updateDataAnalysisLayout(String dataUuidStr, String layoutStr)
		throws com.liferay.portal.kernel.json.JSONException,
			   com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getService().updateDataAnalysisLayout(dataUuidStr, layoutStr);
	}

	public static DataAnalysisLayoutLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataAnalysisLayoutLocalService, DataAnalysisLayoutLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DataAnalysisLayoutLocalService.class);

		ServiceTracker
			<DataAnalysisLayoutLocalService, DataAnalysisLayoutLocalService>
				serviceTracker =
					new ServiceTracker
						<DataAnalysisLayoutLocalService,
						 DataAnalysisLayoutLocalService>(
							 bundle.getBundleContext(),
							 DataAnalysisLayoutLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}