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
 * Provides a wrapper for {@link DataTypeLinkLocalService}.
 *
 * @author Jerry H. Seo
 * @see DataTypeLinkLocalService
 * @generated
 */
@ProviderType
public class DataTypeLinkLocalServiceWrapper
	implements DataTypeLinkLocalService,
			   ServiceWrapper<DataTypeLinkLocalService> {

	public DataTypeLinkLocalServiceWrapper(
		DataTypeLinkLocalService dataTypeLinkLocalService) {

		_dataTypeLinkLocalService = dataTypeLinkLocalService;
	}

	/**
	 * Adds the data type link to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeLink the data type link
	 * @return the data type link that was added
	 */
	@Override
	public com.osp.icecap.model.DataTypeLink addDataTypeLink(
		com.osp.icecap.model.DataTypeLink dataTypeLink) {

		return _dataTypeLinkLocalService.addDataTypeLink(dataTypeLink);
	}

	@Override
	public com.osp.icecap.model.DataTypeLink addDataTypeLink(
		String dataUuid, long dataTypeId) {

		return _dataTypeLinkLocalService.addDataTypeLink(dataUuid, dataTypeId);
	}

	/**
	 * Creates a new data type link with the primary key. Does not add the data type link to the database.
	 *
	 * @param dataUuid the primary key for the new data type link
	 * @return the new data type link
	 */
	@Override
	public com.osp.icecap.model.DataTypeLink createDataTypeLink(
		String dataUuid) {

		return _dataTypeLinkLocalService.createDataTypeLink(dataUuid);
	}

	/**
	 * Deletes the data type link from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeLink the data type link
	 * @return the data type link that was removed
	 */
	@Override
	public com.osp.icecap.model.DataTypeLink deleteDataTypeLink(
		com.osp.icecap.model.DataTypeLink dataTypeLink) {

		return _dataTypeLinkLocalService.deleteDataTypeLink(dataTypeLink);
	}

	/**
	 * Deletes the data type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link that was removed
	 * @throws PortalException if a data type link with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataTypeLink deleteDataTypeLink(String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLinkLocalService.deleteDataTypeLink(dataUuid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataTypeLinkLocalService.dynamicQuery();
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

		return _dataTypeLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataTypeLinkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataTypeLinkLocalService.dynamicQuery(
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

		return _dataTypeLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataTypeLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.DataTypeLink fetchDataTypeLink(
		String dataUuid) {

		return _dataTypeLinkLocalService.fetchDataTypeLink(dataUuid);
	}

	/**
	 * Returns the data type link with the primary key.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link
	 * @throws PortalException if a data type link with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataTypeLink getDataTypeLink(String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLinkLocalService.getDataTypeLink(dataUuid);
	}

	/**
	 * Returns a range of all the data type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataTypeLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type links
	 * @param end the upper bound of the range of data type links (not inclusive)
	 * @return the range of data type links
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataTypeLink> getDataTypeLinks(
		int start, int end) {

		return _dataTypeLinkLocalService.getDataTypeLinks(start, end);
	}

	/**
	 * Returns the number of data type links.
	 *
	 * @return the number of data type links
	 */
	@Override
	public int getDataTypeLinksCount() {
		return _dataTypeLinkLocalService.getDataTypeLinksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataTypeLinkLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.osp.icecap.model.DataTypeLink removeDataTypeLink(String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLinkLocalService.removeDataTypeLink(dataUuid);
	}

	/**
	 * Updates the data type link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeLink the data type link
	 * @return the data type link that was updated
	 */
	@Override
	public com.osp.icecap.model.DataTypeLink updateDataTypeLink(
		com.osp.icecap.model.DataTypeLink dataTypeLink) {

		return _dataTypeLinkLocalService.updateDataTypeLink(dataTypeLink);
	}

	@Override
	public com.osp.icecap.model.DataTypeLink updateDataTypeLink(
			String dataUuid, long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLinkLocalService.updateDataTypeLink(
			dataUuid, dataTypeId);
	}

	@Override
	public DataTypeLinkLocalService getWrappedService() {
		return _dataTypeLinkLocalService;
	}

	@Override
	public void setWrappedService(
		DataTypeLinkLocalService dataTypeLinkLocalService) {

		_dataTypeLinkLocalService = dataTypeLinkLocalService;
	}

	private DataTypeLinkLocalService _dataTypeLinkLocalService;

}