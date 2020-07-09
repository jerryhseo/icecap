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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link DataCollectionLayoutLocalService}.
 *
 * @author Jerry H. Seo
 * @see DataCollectionLayoutLocalService
 * @generated
 */
@ProviderType
public class DataCollectionLayoutLocalServiceWrapper
	implements DataCollectionLayoutLocalService,
			   ServiceWrapper<DataCollectionLayoutLocalService> {

	public DataCollectionLayoutLocalServiceWrapper(
		DataCollectionLayoutLocalService dataCollectionLayoutLocalService) {

		_dataCollectionLayoutLocalService = dataCollectionLayoutLocalService;
	}

	/**
	 * Adds the data collection layout to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionLayout the data collection layout
	 * @return the data collection layout that was added
	 */
	@Override
	public com.osp.icecap.model.DataCollectionLayout addDataCollectionLayout(
		com.osp.icecap.model.DataCollectionLayout dataCollectionLayout) {

		return _dataCollectionLayoutLocalService.addDataCollectionLayout(
			dataCollectionLayout);
	}

	@Override
	public com.osp.icecap.model.DataCollectionLayout addDataCollectionLayout(
		long dataCollectionId, String jsonLayout) {

		return _dataCollectionLayoutLocalService.addDataCollectionLayout(
			dataCollectionId, jsonLayout);
	}

	/**
	 * Creates a new data collection layout with the primary key. Does not add the data collection layout to the database.
	 *
	 * @param dataCollectionId the primary key for the new data collection layout
	 * @return the new data collection layout
	 */
	@Override
	public com.osp.icecap.model.DataCollectionLayout createDataCollectionLayout(
		long dataCollectionId) {

		return _dataCollectionLayoutLocalService.createDataCollectionLayout(
			dataCollectionId);
	}

	/**
	 * Deletes the data collection layout from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionLayout the data collection layout
	 * @return the data collection layout that was removed
	 */
	@Override
	public com.osp.icecap.model.DataCollectionLayout deleteDataCollectionLayout(
		com.osp.icecap.model.DataCollectionLayout dataCollectionLayout) {

		return _dataCollectionLayoutLocalService.deleteDataCollectionLayout(
			dataCollectionLayout);
	}

	/**
	 * Deletes the data collection layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionId the primary key of the data collection layout
	 * @return the data collection layout that was removed
	 * @throws PortalException if a data collection layout with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataCollectionLayout deleteDataCollectionLayout(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLayoutLocalService.deleteDataCollectionLayout(
			dataCollectionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLayoutLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataCollectionLayoutLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dataCollectionLayoutLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dataCollectionLayoutLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dataCollectionLayoutLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dataCollectionLayoutLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _dataCollectionLayoutLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.DataCollectionLayout fetchDataCollectionLayout(
		long dataCollectionId) {

		return _dataCollectionLayoutLocalService.fetchDataCollectionLayout(
			dataCollectionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataCollectionLayoutLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the data collection layout with the primary key.
	 *
	 * @param dataCollectionId the primary key of the data collection layout
	 * @return the data collection layout
	 * @throws PortalException if a data collection layout with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataCollectionLayout getDataCollectionLayout(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLayoutLocalService.getDataCollectionLayout(
			dataCollectionId);
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
	@Override
	public java.util.List<com.osp.icecap.model.DataCollectionLayout>
		getDataCollectionLayouts(int start, int end) {

		return _dataCollectionLayoutLocalService.getDataCollectionLayouts(
			start, end);
	}

	/**
	 * Returns the number of data collection layouts.
	 *
	 * @return the number of data collection layouts
	 */
	@Override
	public int getDataCollectionLayoutsCount() {
		return _dataCollectionLayoutLocalService.
			getDataCollectionLayoutsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataCollectionLayoutLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataCollectionLayoutLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLayoutLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.osp.icecap.model.DataCollectionLayout removeDataCollectionLayout(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLayoutLocalService.removeDataCollectionLayout(
			dataCollectionId);
	}

	/**
	 * Updates the data collection layout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionLayout the data collection layout
	 * @return the data collection layout that was updated
	 */
	@Override
	public com.osp.icecap.model.DataCollectionLayout updateDataCollectionLayout(
		com.osp.icecap.model.DataCollectionLayout dataCollectionLayout) {

		return _dataCollectionLayoutLocalService.updateDataCollectionLayout(
			dataCollectionLayout);
	}

	@Override
	public com.osp.icecap.model.DataCollectionLayout updateDataCollectionLayout(
		long dataCollectionId, String jsonLayout) {

		return _dataCollectionLayoutLocalService.updateDataCollectionLayout(
			dataCollectionId, jsonLayout);
	}

	@Override
	public DataCollectionLayoutLocalService getWrappedService() {
		return _dataCollectionLayoutLocalService;
	}

	@Override
	public void setWrappedService(
		DataCollectionLayoutLocalService dataCollectionLayoutLocalService) {

		_dataCollectionLayoutLocalService = dataCollectionLayoutLocalService;
	}

	private DataCollectionLayoutLocalService _dataCollectionLayoutLocalService;

}