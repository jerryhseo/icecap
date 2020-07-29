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
 * Provides a wrapper for {@link MetaDataLocalService}.
 *
 * @author Jerry H. Seo
 * @see MetaDataLocalService
 * @generated
 */
@ProviderType
public class MetaDataLocalServiceWrapper
	implements MetaDataLocalService, ServiceWrapper<MetaDataLocalService> {

	public MetaDataLocalServiceWrapper(
		MetaDataLocalService metaDataLocalService) {

		_metaDataLocalService = metaDataLocalService;
	}

	/**
	 * Adds the meta data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param metaData the meta data
	 * @return the meta data that was added
	 */
	@Override
	public com.osp.icecap.model.MetaData addMetaData(
		com.osp.icecap.model.MetaData metaData) {

		return _metaDataLocalService.addMetaData(metaData);
	}

	/**
	 * Creates a new meta data with the primary key. Does not add the meta data to the database.
	 *
	 * @param dataUuid the primary key for the new meta data
	 * @return the new meta data
	 */
	@Override
	public com.osp.icecap.model.MetaData createMetaData(String dataUuid) {
		return _metaDataLocalService.createMetaData(dataUuid);
	}

	/**
	 * Deletes the meta data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metaData the meta data
	 * @return the meta data that was removed
	 */
	@Override
	public com.osp.icecap.model.MetaData deleteMetaData(
		com.osp.icecap.model.MetaData metaData) {

		return _metaDataLocalService.deleteMetaData(metaData);
	}

	/**
	 * Deletes the meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data that was removed
	 * @throws PortalException if a meta data with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.MetaData deleteMetaData(String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _metaDataLocalService.deleteMetaData(dataUuid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _metaDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _metaDataLocalService.dynamicQuery();
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

		return _metaDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _metaDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _metaDataLocalService.dynamicQuery(
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

		return _metaDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _metaDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.MetaData fetchMetaData(String dataUuid) {
		return _metaDataLocalService.fetchMetaData(dataUuid);
	}

	/**
	 * Returns the meta data with the primary key.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data
	 * @throws PortalException if a meta data with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.MetaData getMetaData(String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _metaDataLocalService.getMetaData(dataUuid);
	}

	/**
	 * Returns a range of all the meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of meta datas
	 */
	@Override
	public java.util.List<com.osp.icecap.model.MetaData> getMetaDatas(
		int start, int end) {

		return _metaDataLocalService.getMetaDatas(start, end);
	}

	/**
	 * Returns the number of meta datas.
	 *
	 * @return the number of meta datas
	 */
	@Override
	public int getMetaDatasCount() {
		return _metaDataLocalService.getMetaDatasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _metaDataLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _metaDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the meta data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param metaData the meta data
	 * @return the meta data that was updated
	 */
	@Override
	public com.osp.icecap.model.MetaData updateMetaData(
		com.osp.icecap.model.MetaData metaData) {

		return _metaDataLocalService.updateMetaData(metaData);
	}

	@Override
	public MetaDataLocalService getWrappedService() {
		return _metaDataLocalService;
	}

	@Override
	public void setWrappedService(MetaDataLocalService metaDataLocalService) {
		_metaDataLocalService = metaDataLocalService;
	}

	private MetaDataLocalService _metaDataLocalService;

}