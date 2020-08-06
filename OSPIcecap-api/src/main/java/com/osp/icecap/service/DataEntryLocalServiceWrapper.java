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
 * Provides a wrapper for {@link DataEntryLocalService}.
 *
 * @author Jerry H. Seo
 * @see DataEntryLocalService
 * @generated
 */
@ProviderType
public class DataEntryLocalServiceWrapper
	implements DataEntryLocalService, ServiceWrapper<DataEntryLocalService> {

	public DataEntryLocalServiceWrapper(
		DataEntryLocalService dataEntryLocalService) {

		_dataEntryLocalService = dataEntryLocalService;
	}

	/**
	 * Adds the data entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntry the data entry
	 * @return the data entry that was added
	 */
	@Override
	public com.osp.icecap.model.DataEntry addDataEntry(
		com.osp.icecap.model.DataEntry dataEntry) {

		return _dataEntryLocalService.addDataEntry(dataEntry);
	}

	@Override
	public com.osp.icecap.model.DataEntry addDataEntry(
			long dataCollectionId, long dataSetId, long dataSectionId,
			long dataPackId, long dataTypeId, String accessURL,
			String sequenceId, String accessType, long copiedFrom,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataEntryLocalService.addDataEntry(
			dataCollectionId, dataSetId, dataSectionId, dataPackId, dataTypeId,
			accessURL, sequenceId, accessType, copiedFrom, metaDataJSON, sc);
	}

	/**
	 * Creates a new data entry with the primary key. Does not add the data entry to the database.
	 *
	 * @param dataEntryId the primary key for the new data entry
	 * @return the new data entry
	 */
	@Override
	public com.osp.icecap.model.DataEntry createDataEntry(long dataEntryId) {
		return _dataEntryLocalService.createDataEntry(dataEntryId);
	}

	/**
	 * Deletes the data entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntry the data entry
	 * @return the data entry that was removed
	 */
	@Override
	public com.osp.icecap.model.DataEntry deleteDataEntry(
		com.osp.icecap.model.DataEntry dataEntry) {

		return _dataEntryLocalService.deleteDataEntry(dataEntry);
	}

	/**
	 * Deletes the data entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry that was removed
	 * @throws PortalException if a data entry with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataEntry deleteDataEntry(long dataEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataEntryLocalService.deleteDataEntry(dataEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataEntryLocalService.dynamicQuery();
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

		return _dataEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataEntryLocalService.dynamicQuery(
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

		return _dataEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.DataEntry fetchDataEntry(long dataEntryId) {
		return _dataEntryLocalService.fetchDataEntry(dataEntryId);
	}

	/**
	 * Returns the data entry matching the UUID and group.
	 *
	 * @param uuid the data entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	@Override
	public com.osp.icecap.model.DataEntry fetchDataEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return _dataEntryLocalService.fetchDataEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the data entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of data entries
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataEntry> getDataEntries(
		int start, int end) {

		return _dataEntryLocalService.getDataEntries(start, end);
	}

	/**
	 * Returns all the data entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data entries
	 * @param companyId the primary key of the company
	 * @return the matching data entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataEntry>
		getDataEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _dataEntryLocalService.getDataEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataEntry>
		getDataEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icecap.model.DataEntry> orderByComparator) {

		return _dataEntryLocalService.getDataEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data entries.
	 *
	 * @return the number of data entries
	 */
	@Override
	public int getDataEntriesCount() {
		return _dataEntryLocalService.getDataEntriesCount();
	}

	/**
	 * Returns the data entry with the primary key.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry
	 * @throws PortalException if a data entry with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataEntry getDataEntry(long dataEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataEntryLocalService.getDataEntry(dataEntryId);
	}

	/**
	 * Returns the data entry matching the UUID and group.
	 *
	 * @param uuid the data entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data entry
	 * @throws PortalException if a matching data entry could not be found
	 */
	@Override
	public com.osp.icecap.model.DataEntry getDataEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataEntryLocalService.getDataEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataEntryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeDataEntriesByDataCollectionId(long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataEntryLocalService.removeDataEntriesByDataCollectionId(
			dataCollectionId);
	}

	@Override
	public void removeDataEntriesByDataPackId(long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataEntryLocalService.removeDataEntriesByDataPackId(dataPackId);
	}

	@Override
	public void removeDataEntriesByDataSectionId(long dataSectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataEntryLocalService.removeDataEntriesByDataSectionId(dataSectionId);
	}

	@Override
	public void removeDataEntriesByDataSetId(long dataSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataEntryLocalService.removeDataEntriesByDataSetId(dataSetId);
	}

	@Override
	public com.osp.icecap.model.DataEntry removeDataEntry(long dataEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataEntryLocalService.removeDataEntry(dataEntryId);
	}

	/**
	 * Updates the data entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntry the data entry
	 * @return the data entry that was updated
	 */
	@Override
	public com.osp.icecap.model.DataEntry updateDataEntry(
		com.osp.icecap.model.DataEntry dataEntry) {

		return _dataEntryLocalService.updateDataEntry(dataEntry);
	}

	@Override
	public com.osp.icecap.model.DataEntry updateDataEntry(
			long dataEntryId, long dataCollectionId, long dataSetId,
			long dataSectionId, long dataPackId, long dataTypeId,
			String accessURL, String sequenceId, String accessType,
			long copiedFrom,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataEntryLocalService.updateDataEntry(
			dataEntryId, dataCollectionId, dataSetId, dataSectionId, dataPackId,
			dataTypeId, accessURL, sequenceId, accessType, copiedFrom,
			metaDataJSON, sc);
	}

	@Override
	public DataEntryLocalService getWrappedService() {
		return _dataEntryLocalService;
	}

	@Override
	public void setWrappedService(DataEntryLocalService dataEntryLocalService) {
		_dataEntryLocalService = dataEntryLocalService;
	}

	private DataEntryLocalService _dataEntryLocalService;

}