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
 * Provides a wrapper for {@link DataPackLocalService}.
 *
 * @author Jerry H. Seo
 * @see DataPackLocalService
 * @generated
 */
@ProviderType
public class DataPackLocalServiceWrapper
	implements DataPackLocalService, ServiceWrapper<DataPackLocalService> {

	public DataPackLocalServiceWrapper(
		DataPackLocalService dataPackLocalService) {

		_dataPackLocalService = dataPackLocalService;
	}

	/**
	 * Adds the data pack to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was added
	 */
	@Override
	public com.osp.icecap.model.DataPack addDataPack(
		com.osp.icecap.model.DataPack dataPack) {

		return _dataPackLocalService.addDataPack(dataPack);
	}

	@Override
	public com.osp.icecap.model.DataPack addDataPack(
			long dataCollectionId, long dataSetId, long dataSectionId,
			String name, String version, long copiedFrom,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			String layout, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.addDataPack(
			dataCollectionId, dataSetId, dataSectionId, name, version,
			copiedFrom, metaDataJSON, layout, sc);
	}

	/**
	 * Creates a new data pack with the primary key. Does not add the data pack to the database.
	 *
	 * @param dataPackId the primary key for the new data pack
	 * @return the new data pack
	 */
	@Override
	public com.osp.icecap.model.DataPack createDataPack(long dataPackId) {
		return _dataPackLocalService.createDataPack(dataPackId);
	}

	/**
	 * Deletes the data pack from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was removed
	 */
	@Override
	public com.osp.icecap.model.DataPack deleteDataPack(
		com.osp.icecap.model.DataPack dataPack) {

		return _dataPackLocalService.deleteDataPack(dataPack);
	}

	/**
	 * Deletes the data pack with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack that was removed
	 * @throws PortalException if a data pack with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataPack deleteDataPack(long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.deleteDataPack(dataPackId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataPackLocalService.dynamicQuery();
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

		return _dataPackLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataPackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataPackLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataPackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataPackLocalService.dynamicQuery(
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

		return _dataPackLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataPackLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.DataPack fetchDataPack(long dataPackId) {
		return _dataPackLocalService.fetchDataPack(dataPackId);
	}

	/**
	 * Returns the data pack matching the UUID and group.
	 *
	 * @param uuid the data pack's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	@Override
	public com.osp.icecap.model.DataPack fetchDataPackByUuidAndGroupId(
		String uuid, long groupId) {

		return _dataPackLocalService.fetchDataPackByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataPackLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataEntry>
		getDataEntriesByDataPackId(long dataPackId) {

		return _dataPackLocalService.getDataEntriesByDataPackId(dataPackId);
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataEntry>
		getDataEntriesByDataPackId(long dataPackId, int start, int end) {

		return _dataPackLocalService.getDataEntriesByDataPackId(
			dataPackId, start, end);
	}

	@Override
	public int getDataEntriesCountByDataPackId(long dataPackId) {
		return _dataPackLocalService.getDataEntriesCountByDataPackId(
			dataPackId);
	}

	/**
	 * Returns the data pack with the primary key.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack
	 * @throws PortalException if a data pack with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataPack getDataPack(long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.getDataPack(dataPackId);
	}

	/**
	 * Returns the data pack matching the UUID and group.
	 *
	 * @param uuid the data pack's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack
	 * @throws PortalException if a matching data pack could not be found
	 */
	@Override
	public com.osp.icecap.model.DataPack getDataPackByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.getDataPackByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the data packs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataPackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of data packs
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataPack> getDataPacks(
		int start, int end) {

		return _dataPackLocalService.getDataPacks(start, end);
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByDataSectionId(long dataSectionId) {

		return _dataPackLocalService.getDataPacksByDataSectionId(dataSectionId);
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByDataSectionId(long dataSectionId, int start, int end) {

		return _dataPackLocalService.getDataPacksByDataSectionId(
			dataSectionId, start, end);
	}

	/**
	 * Returns all the data packs matching the UUID and company.
	 *
	 * @param uuid the UUID of the data packs
	 * @param companyId the primary key of the company
	 * @return the matching data packs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByUuidAndCompanyId(String uuid, long companyId) {

		return _dataPackLocalService.getDataPacksByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data packs matching the UUID and company.
	 *
	 * @param uuid the UUID of the data packs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data packs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icecap.model.DataPack> orderByComparator) {

		return _dataPackLocalService.getDataPacksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data packs.
	 *
	 * @return the number of data packs
	 */
	@Override
	public int getDataPacksCount() {
		return _dataPackLocalService.getDataPacksCount();
	}

	@Override
	public int getDataPacksCountByDataSectionId(long dataSectionId) {
		return _dataPackLocalService.getDataPacksCountByDataSectionId(
			dataSectionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataPackLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataPackLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataPackLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.osp.icecap.model.DataPack removeDataPack(long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.removeDataPack(dataPackId);
	}

	@Override
	public void removeDataPacksByDataCollectionId(long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataPackLocalService.removeDataPacksByDataCollectionId(
			dataCollectionId);
	}

	@Override
	public void removeDataPacksByDataSectionId(long dataSectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataPackLocalService.removeDataPacksByDataSectionId(dataSectionId);
	}

	@Override
	public void removeDataPacksByDataSetId(long dataSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataPackLocalService.removeDataPacksByDataSetId(dataSetId);
	}

	/**
	 * Updates the data pack in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was updated
	 */
	@Override
	public com.osp.icecap.model.DataPack updateDataPack(
		com.osp.icecap.model.DataPack dataPack) {

		return _dataPackLocalService.updateDataPack(dataPack);
	}

	@Override
	public com.osp.icecap.model.DataPack updateDataPack(
			long dataPackId, long dataCollectionId, long dataSetId,
			long dataSectionId, String name, String version, long copiedFrom,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			String layout, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.updateDataPack(
			dataPackId, dataCollectionId, dataSetId, dataSectionId, name,
			version, copiedFrom, metaDataJSON, layout, sc);
	}

	@Override
	public DataPackLocalService getWrappedService() {
		return _dataPackLocalService;
	}

	@Override
	public void setWrappedService(DataPackLocalService dataPackLocalService) {
		_dataPackLocalService = dataPackLocalService;
	}

	private DataPackLocalService _dataPackLocalService;

}