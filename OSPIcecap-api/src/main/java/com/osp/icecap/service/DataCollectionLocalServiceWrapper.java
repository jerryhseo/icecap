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
 * Provides a wrapper for {@link DataCollectionLocalService}.
 *
 * @author Jerry H. Seo
 * @see DataCollectionLocalService
 * @generated
 */
@ProviderType
public class DataCollectionLocalServiceWrapper
	implements DataCollectionLocalService,
			   ServiceWrapper<DataCollectionLocalService> {

	public DataCollectionLocalServiceWrapper(
		DataCollectionLocalService dataCollectionLocalService) {

		_dataCollectionLocalService = dataCollectionLocalService;
	}

	/**
	 * Adds the data collection to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was added
	 */
	@Override
	public com.osp.icecap.model.DataCollection addDataCollection(
		com.osp.icecap.model.DataCollection dataCollection) {

		return _dataCollectionLocalService.addDataCollection(dataCollection);
	}

	/**
	 * Creates a new data collection with the primary key. Does not add the data collection to the database.
	 *
	 * @param dataCollectionId the primary key for the new data collection
	 * @return the new data collection
	 */
	@Override
	public com.osp.icecap.model.DataCollection createDataCollection(
		long dataCollectionId) {

		return _dataCollectionLocalService.createDataCollection(
			dataCollectionId);
	}

	@Override
	public com.osp.icecap.model.DataCollection createDataCollection(
		String collectionName,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _dataCollectionLocalService.createDataCollection(
			collectionName, sc);
	}

	/**
	 * Deletes the data collection from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was removed
	 */
	@Override
	public com.osp.icecap.model.DataCollection deleteDataCollection(
		com.osp.icecap.model.DataCollection dataCollection) {

		return _dataCollectionLocalService.deleteDataCollection(dataCollection);
	}

	/**
	 * Deletes the data collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection that was removed
	 * @throws PortalException if a data collection with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataCollection deleteDataCollection(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLocalService.deleteDataCollection(
			dataCollectionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataCollectionLocalService.dynamicQuery();
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

		return _dataCollectionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataCollectionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataCollectionLocalService.dynamicQuery(
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

		return _dataCollectionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataCollectionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.DataCollection fetchDataCollection(
		long dataCollectionId) {

		return _dataCollectionLocalService.fetchDataCollection(
			dataCollectionId);
	}

	/**
	 * Returns the data collection matching the UUID and group.
	 *
	 * @param uuid the data collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public com.osp.icecap.model.DataCollection
		fetchDataCollectionByUuidAndGroupId(String uuid, long groupId) {

		return _dataCollectionLocalService.fetchDataCollectionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataCollectionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the data collection with the primary key.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection
	 * @throws PortalException if a data collection with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataCollection getDataCollection(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLocalService.getDataCollection(dataCollectionId);
	}

	/**
	 * Returns the data collection matching the UUID and group.
	 *
	 * @param uuid the data collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data collection
	 * @throws PortalException if a matching data collection could not be found
	 */
	@Override
	public com.osp.icecap.model.DataCollection
			getDataCollectionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLocalService.getDataCollectionByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of data collections
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollections(int start, int end) {

		return _dataCollectionLocalService.getDataCollections(start, end);
	}

	/**
	 * Returns all the data collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data collections
	 * @param companyId the primary key of the company
	 * @return the matching data collections, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByUuidAndCompanyId(String uuid, long companyId) {

		return _dataCollectionLocalService.getDataCollectionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data collections
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data collections, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataCollection>
		getDataCollectionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icecap.model.DataCollection> orderByComparator) {

		return _dataCollectionLocalService.getDataCollectionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data collections.
	 *
	 * @return the number of data collections
	 */
	@Override
	public int getDataCollectionsCount() {
		return _dataCollectionLocalService.getDataCollectionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataCollectionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataCollectionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataCollectionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.osp.icecap.model.DataCollection removeDataCollection(
		com.osp.icecap.model.DataCollection collection) {

		return _dataCollectionLocalService.removeDataCollection(collection);
	}

	@Override
	public com.osp.icecap.model.DataCollection removeDataCollection(
			long collectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionLocalService.removeDataCollection(collectionId);
	}

	@Override
	public com.osp.icecap.model.DataCollection removeDataCollection(
		String collectionName) {

		return _dataCollectionLocalService.removeDataCollection(collectionName);
	}

	/**
	 * Updates the data collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was updated
	 */
	@Override
	public com.osp.icecap.model.DataCollection updateDataCollection(
		com.osp.icecap.model.DataCollection dataCollection) {

		return _dataCollectionLocalService.updateDataCollection(dataCollection);
	}

	@Override
	public DataCollectionLocalService getWrappedService() {
		return _dataCollectionLocalService;
	}

	@Override
	public void setWrappedService(
		DataCollectionLocalService dataCollectionLocalService) {

		_dataCollectionLocalService = dataCollectionLocalService;
	}

	private DataCollectionLocalService _dataCollectionLocalService;

}