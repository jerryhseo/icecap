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
 * Provides the local service utility for DataTypeStructure. This utility wraps
 * <code>com.osp.icecap.service.impl.DataTypeStructureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see DataTypeStructureLocalService
 * @generated
 */
@ProviderType
public class DataTypeStructureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.DataTypeStructureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data type structure to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeStructure the data type structure
	 * @return the data type structure that was added
	 */
	public static com.osp.icecap.model.DataTypeStructure addDataTypeStructure(
		com.osp.icecap.model.DataTypeStructure dataTypeStructure) {

		return getService().addDataTypeStructure(dataTypeStructure);
	}

	public static com.osp.icecap.model.DataTypeStructure addDataTypeStructure(
		long dataTypeId, String jsonStructure) {

		return getService().addDataTypeStructure(dataTypeId, jsonStructure);
	}

	/**
	 * Creates a new data type structure with the primary key. Does not add the data type structure to the database.
	 *
	 * @param dataTypeId the primary key for the new data type structure
	 * @return the new data type structure
	 */
	public static com.osp.icecap.model.DataTypeStructure
		createDataTypeStructure(long dataTypeId) {

		return getService().createDataTypeStructure(dataTypeId);
	}

	/**
	 * Deletes the data type structure from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeStructure the data type structure
	 * @return the data type structure that was removed
	 */
	public static com.osp.icecap.model.DataTypeStructure
		deleteDataTypeStructure(
			com.osp.icecap.model.DataTypeStructure dataTypeStructure) {

		return getService().deleteDataTypeStructure(dataTypeStructure);
	}

	/**
	 * Deletes the data type structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the data type structure
	 * @return the data type structure that was removed
	 * @throws PortalException if a data type structure with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataTypeStructure
			deleteDataTypeStructure(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDataTypeStructure(dataTypeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.osp.icecap.model.DataTypeStructure fetchDataTypeStructure(
		long dataTypeId) {

		return getService().fetchDataTypeStructure(dataTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the data type structure with the primary key.
	 *
	 * @param dataTypeId the primary key of the data type structure
	 * @return the data type structure
	 * @throws PortalException if a data type structure with the primary key could not be found
	 */
	public static com.osp.icecap.model.DataTypeStructure getDataTypeStructure(
			long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataTypeStructure(dataTypeId);
	}

	/**
	 * Returns a range of all the data type structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type structures
	 * @param end the upper bound of the range of data type structures (not inclusive)
	 * @return the range of data type structures
	 */
	public static java.util.List<com.osp.icecap.model.DataTypeStructure>
		getDataTypeStructures(int start, int end) {

		return getService().getDataTypeStructures(start, end);
	}

	/**
	 * Returns the number of data type structures.
	 *
	 * @return the number of data type structures
	 */
	public static int getDataTypeStructuresCount() {
		return getService().getDataTypeStructuresCount();
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

	public static com.osp.icecap.model.DataTypeStructure
			removeDataTypeStructure(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeDataTypeStructure(dataTypeId);
	}

	/**
	 * Updates the data type structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeStructure the data type structure
	 * @return the data type structure that was updated
	 */
	public static com.osp.icecap.model.DataTypeStructure
		updateDataTypeStructure(
			com.osp.icecap.model.DataTypeStructure dataTypeStructure) {

		return getService().updateDataTypeStructure(dataTypeStructure);
	}

	public static com.osp.icecap.model.DataTypeStructure
		updateDataTypeStructure(long dataTypeId, String jsonStructure) {

		return getService().updateDataTypeStructure(dataTypeId, jsonStructure);
	}

	public static DataTypeStructureLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataTypeStructureLocalService, DataTypeStructureLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DataTypeStructureLocalService.class);

		ServiceTracker
			<DataTypeStructureLocalService, DataTypeStructureLocalService>
				serviceTracker =
					new ServiceTracker
						<DataTypeStructureLocalService,
						 DataTypeStructureLocalService>(
							 bundle.getBundleContext(),
							 DataTypeStructureLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}