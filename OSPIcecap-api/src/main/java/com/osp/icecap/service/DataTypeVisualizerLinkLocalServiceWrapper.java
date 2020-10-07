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

/**
 * Provides a wrapper for {@link DataTypeVisualizerLinkLocalService}.
 *
 * @author Jerry H. Seo
 * @see DataTypeVisualizerLinkLocalService
 * @generated
 */
public class DataTypeVisualizerLinkLocalServiceWrapper
	implements DataTypeVisualizerLinkLocalService,
			   ServiceWrapper<DataTypeVisualizerLinkLocalService> {

	public DataTypeVisualizerLinkLocalServiceWrapper(
		DataTypeVisualizerLinkLocalService dataTypeVisualizerLinkLocalService) {

		_dataTypeVisualizerLinkLocalService =
			dataTypeVisualizerLinkLocalService;
	}

	/**
	 * Adds the data type visualizer link to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 * @return the data type visualizer link that was added
	 */
	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
		addDataTypeVisualizerLink(
			com.osp.icecap.model.DataTypeVisualizerLink
				dataTypeVisualizerLink) {

		return _dataTypeVisualizerLinkLocalService.addDataTypeVisualizerLink(
			dataTypeVisualizerLink);
	}

	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
		addDataTypeVisualizerLink(
			long dataTypeId, String visualizerName, String visualizerVersion,
			boolean editable) {

		return _dataTypeVisualizerLinkLocalService.addDataTypeVisualizerLink(
			dataTypeId, visualizerName, visualizerVersion, editable);
	}

	/**
	 * Creates a new data type visualizer link with the primary key. Does not add the data type visualizer link to the database.
	 *
	 * @param dataTypeVisualizerLinkId the primary key for the new data type visualizer link
	 * @return the new data type visualizer link
	 */
	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
		createDataTypeVisualizerLink(long dataTypeVisualizerLinkId) {

		return _dataTypeVisualizerLinkLocalService.createDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
	}

	/**
	 * Deletes the data type visualizer link from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 * @return the data type visualizer link that was removed
	 */
	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
		deleteDataTypeVisualizerLink(
			com.osp.icecap.model.DataTypeVisualizerLink
				dataTypeVisualizerLink) {

		return _dataTypeVisualizerLinkLocalService.deleteDataTypeVisualizerLink(
			dataTypeVisualizerLink);
	}

	/**
	 * Deletes the data type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link that was removed
	 * @throws PortalException if a data type visualizer link with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
			deleteDataTypeVisualizerLink(long dataTypeVisualizerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeVisualizerLinkLocalService.deleteDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeVisualizerLinkLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataTypeVisualizerLinkLocalService.dynamicQuery();
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

		return _dataTypeVisualizerLinkLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dataTypeVisualizerLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dataTypeVisualizerLinkLocalService.dynamicQuery(
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

		return _dataTypeVisualizerLinkLocalService.dynamicQueryCount(
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

		return _dataTypeVisualizerLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
		fetchDataTypeVisualizerLink(long dataTypeVisualizerLinkId) {

		return _dataTypeVisualizerLinkLocalService.fetchDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataTypeVisualizerLinkLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the data type visualizer link with the primary key.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link
	 * @throws PortalException if a data type visualizer link with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
			getDataTypeVisualizerLink(long dataTypeVisualizerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeVisualizerLinkLocalService.getDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
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
	@Override
	public java.util.List<com.osp.icecap.model.DataTypeVisualizerLink>
		getDataTypeVisualizerLinks(int start, int end) {

		return _dataTypeVisualizerLinkLocalService.getDataTypeVisualizerLinks(
			start, end);
	}

	/**
	 * Returns the number of data type visualizer links.
	 *
	 * @return the number of data type visualizer links
	 */
	@Override
	public int getDataTypeVisualizerLinksCount() {
		return _dataTypeVisualizerLinkLocalService.
			getDataTypeVisualizerLinksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataTypeVisualizerLinkLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataTypeVisualizerLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeVisualizerLinkLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
			removeDataTypeVisualizerLink(long dataTypeVisualizerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeVisualizerLinkLocalService.removeDataTypeVisualizerLink(
			dataTypeVisualizerLinkId);
	}

	@Override
	public void removeDataTypeVisualizerLinks(long dataTypeId) {
		_dataTypeVisualizerLinkLocalService.removeDataTypeVisualizerLinks(
			dataTypeId);
	}

	@Override
	public void removeDataTypeVisualizerLinks(String visualizerName)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		_dataTypeVisualizerLinkLocalService.removeDataTypeVisualizerLinks(
			visualizerName);
	}

	@Override
	public void removeDataTypeVisualizerLinks(
			String visualizerName, String visualizerVersion)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		_dataTypeVisualizerLinkLocalService.removeDataTypeVisualizerLinks(
			visualizerName, visualizerVersion);
	}

	/**
	 * Updates the data type visualizer link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 * @return the data type visualizer link that was updated
	 */
	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
		updateDataTypeVisualizerLink(
			com.osp.icecap.model.DataTypeVisualizerLink
				dataTypeVisualizerLink) {

		return _dataTypeVisualizerLinkLocalService.updateDataTypeVisualizerLink(
			dataTypeVisualizerLink);
	}

	@Override
	public com.osp.icecap.model.DataTypeVisualizerLink
			updateDataTypeVisualizerLink(
				long dataTypeVisualizerLinkId, long dataTypeId,
				String visualizerName, String visualizerVersion,
				boolean editable)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeVisualizerLinkLocalService.updateDataTypeVisualizerLink(
			dataTypeVisualizerLinkId, dataTypeId, visualizerName,
			visualizerVersion, editable);
	}

	@Override
	public DataTypeVisualizerLinkLocalService getWrappedService() {
		return _dataTypeVisualizerLinkLocalService;
	}

	@Override
	public void setWrappedService(
		DataTypeVisualizerLinkLocalService dataTypeVisualizerLinkLocalService) {

		_dataTypeVisualizerLinkLocalService =
			dataTypeVisualizerLinkLocalService;
	}

	private DataTypeVisualizerLinkLocalService
		_dataTypeVisualizerLinkLocalService;

}