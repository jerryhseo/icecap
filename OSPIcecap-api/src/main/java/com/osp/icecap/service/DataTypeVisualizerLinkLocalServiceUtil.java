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
 * Provides the local service utility for DataTypeVisualizerLink. This utility wraps
 * <code>com.osp.icecap.service.impl.DataTypeVisualizerLinkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see DataTypeVisualizerLinkLocalService
 * @generated
 */
public class DataTypeVisualizerLinkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.DataTypeVisualizerLinkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data type visualizer link to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 * @return the data type visualizer link that was added
	 */
	public static com.osp.icecap.model.DataTypeVisualizerLink
		addDataTypeVisualizerLink(
			com.osp.icecap.model.DataTypeVisualizerLink
				dataTypeVisualizerLink) {

		return getService().addDataTypeVisualizerLink(dataTypeVisualizerLink);
	}

	public static com.osp.icecap.model.DataTypeVisualizerLink
		addDataTypeVisualizerLink(
			long dataTypeId, String visualizerName, String visualizerVersion,
			boolean editable) {

		return getService().addDataTypeVisualizerLink(
			dataTypeId, visualizerName, visualizerVersion, editable);
	}

	/**
	 * Creates a new data type visualizer link with the primary key. Does not add the data type visualizer link to the database.
	 *
	 * @param dataTypeVisualizerLinkId the primary key for the new data type visualizer link
	 * @return the new data type visualizer link
	 */
	public static com.osp.icecap.model.DataTypeVisualizerLink
		createDataTypeVisualizerLink(long dataTypeVisualizerLinkId) {

		return getService().createDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
	}

	/**
	 * Deletes the data type visualizer link from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 * @return the data type visualizer link that was removed
	 */
	public static com.osp.icecap.model.DataTypeVisualizerLink
		deleteDataTypeVisualizerLink(
			com.osp.icecap.model.DataTypeVisualizerLink
				dataTypeVisualizerLink) {

		return getService().deleteDataTypeVisualizerLink(
			dataTypeVisualizerLink);
	}

	/**
	 * Deletes the data type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link that was removed
	 * @throws PortalException if a data type visualizer link with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataTypeVisualizerLink
			deleteDataTypeVisualizerLink(long dataTypeVisualizerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeVisualizerLinkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeVisualizerLinkModelImpl</code>.
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

	public static com.osp.icecap.model.DataTypeVisualizerLink
		fetchDataTypeVisualizerLink(long dataTypeVisualizerLinkId) {

		return getService().fetchDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the data type visualizer link with the primary key.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link
	 * @throws PortalException if a data type visualizer link with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataTypeVisualizerLink
			getDataTypeVisualizerLink(long dataTypeVisualizerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataTypeVisualizerLink(dataTypeVisualizerLinkId);
	}

	/**
	 * Returns a range of all the data type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of data type visualizer links
	 */
	public static java.util.List<com.osp.icecap.model.DataTypeVisualizerLink>
		getDataTypeVisualizerLinks(int start, int end) {

		return getService().getDataTypeVisualizerLinks(start, end);
	}

	/**
	 * Returns the number of data type visualizer links.
	 *
	 * @return the number of data type visualizer links
	 */
	public static int getDataTypeVisualizerLinksCount() {
		return getService().getDataTypeVisualizerLinksCount();
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

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.osp.icecap.model.DataTypeVisualizerLink
			removeDataTypeVisualizerLink(long dataTypeVisualizerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
	}

	public static void removeDataTypeVisualizerLinks(long dataTypeId) {
		getService().removeDataTypeVisualizerLinks(dataTypeId);
	}

	public static void removeDataTypeVisualizerLinks(String visualizerName)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		getService().removeDataTypeVisualizerLinks(visualizerName);
	}

	public static void removeDataTypeVisualizerLinks(
			String visualizerName, String visualizerVersion)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		getService().removeDataTypeVisualizerLinks(
			visualizerName, visualizerVersion);
	}

	/**
	 * Updates the data type visualizer link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 * @return the data type visualizer link that was updated
	 */
	public static com.osp.icecap.model.DataTypeVisualizerLink
		updateDataTypeVisualizerLink(
			com.osp.icecap.model.DataTypeVisualizerLink
				dataTypeVisualizerLink) {

		return getService().updateDataTypeVisualizerLink(
			dataTypeVisualizerLink);
	}

	public static com.osp.icecap.model.DataTypeVisualizerLink
			updateDataTypeVisualizerLink(
				long dataTypeVisualizerLinkId, long dataTypeId,
				String visualizerName, String visualizerVersion,
				boolean editable)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateDataTypeVisualizerLink(
			dataTypeVisualizerLinkId, dataTypeId, visualizerName,
			visualizerVersion, editable);
	}

	public static DataTypeVisualizerLinkLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataTypeVisualizerLinkLocalService, DataTypeVisualizerLinkLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DataTypeVisualizerLinkLocalService.class);

		ServiceTracker
			<DataTypeVisualizerLinkLocalService,
			 DataTypeVisualizerLinkLocalService> serviceTracker =
				new ServiceTracker
					<DataTypeVisualizerLinkLocalService,
					 DataTypeVisualizerLinkLocalService>(
						 bundle.getBundleContext(),
						 DataTypeVisualizerLinkLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}