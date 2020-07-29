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
 * Provides a wrapper for {@link DataSectionLocalService}.
 *
 * @author Jerry H. Seo
 * @see DataSectionLocalService
 * @generated
 */
@ProviderType
public class DataSectionLocalServiceWrapper
	implements DataSectionLocalService,
			   ServiceWrapper<DataSectionLocalService> {

	public DataSectionLocalServiceWrapper(
		DataSectionLocalService dataSectionLocalService) {

		_dataSectionLocalService = dataSectionLocalService;
	}

	/**
	 * Adds the data section to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSection the data section
	 * @return the data section that was added
	 */
	@Override
	public com.osp.icecap.model.DataSection addDataSection(
		com.osp.icecap.model.DataSection dataSection) {

		return _dataSectionLocalService.addDataSection(dataSection);
	}

	@Override
	public com.osp.icecap.model.DataSection addDataSection(
			long dataCollectionId, long dataSetId, String name, String version,
			long copiedFrom,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			String layout, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSectionLocalService.addDataSection(
			dataCollectionId, dataSetId, name, version, copiedFrom,
			metaDataJSON, layout, sc);
	}

	/**
	 * Creates a new data section with the primary key. Does not add the data section to the database.
	 *
	 * @param dataSectionId the primary key for the new data section
	 * @return the new data section
	 */
	@Override
	public com.osp.icecap.model.DataSection createDataSection(
		long dataSectionId) {

		return _dataSectionLocalService.createDataSection(dataSectionId);
	}

	/**
	 * Deletes the data section from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSection the data section
	 * @return the data section that was removed
	 */
	@Override
	public com.osp.icecap.model.DataSection deleteDataSection(
		com.osp.icecap.model.DataSection dataSection) {

		return _dataSectionLocalService.deleteDataSection(dataSection);
	}

	/**
	 * Deletes the data section with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSectionId the primary key of the data section
	 * @return the data section that was removed
	 * @throws PortalException if a data section with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataSection deleteDataSection(
			long dataSectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSectionLocalService.deleteDataSection(dataSectionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSectionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataSectionLocalService.dynamicQuery();
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

		return _dataSectionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataSectionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataSectionLocalService.dynamicQuery(
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

		return _dataSectionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataSectionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.DataSection fetchDataSection(
		long dataSectionId) {

		return _dataSectionLocalService.fetchDataSection(dataSectionId);
	}

	/**
	 * Returns the data section matching the UUID and group.
	 *
	 * @param uuid the data section's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data section, or <code>null</code> if a matching data section could not be found
	 */
	@Override
	public com.osp.icecap.model.DataSection fetchDataSectionByUuidAndGroupId(
		String uuid, long groupId) {

		return _dataSectionLocalService.fetchDataSectionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataSectionLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataEntry>
		getDataEntriesByDataSectionId(long dataSectionId) {

		return _dataSectionLocalService.getDataEntriesByDataSectionId(
			dataSectionId);
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataEntry>
		getDataEntriesByDataSectionId(long dataSectionId, int start, int end) {

		return _dataSectionLocalService.getDataEntriesByDataSectionId(
			dataSectionId, start, end);
	}

	@Override
	public int getDataEntriesCountByDataSectionId(long dataSectionId) {
		return _dataSectionLocalService.getDataEntriesCountByDataSectionId(
			dataSectionId);
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByDataSectionId(long dataSectionId) {

		return _dataSectionLocalService.getDataPacksByDataSectionId(
			dataSectionId);
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataPack>
		getDataPacksByDataSectionId(long dataSectionId, int start, int end) {

		return _dataSectionLocalService.getDataPacksByDataSectionId(
			dataSectionId, start, end);
	}

	@Override
	public int getDataPacksCountByDataSectionId(long dataSectionId) {
		return _dataSectionLocalService.getDataPacksCountByDataSectionId(
			dataSectionId);
	}

	/**
	 * Returns the data section with the primary key.
	 *
	 * @param dataSectionId the primary key of the data section
	 * @return the data section
	 * @throws PortalException if a data section with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataSection getDataSection(long dataSectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSectionLocalService.getDataSection(dataSectionId);
	}

	/**
	 * Returns the data section matching the UUID and group.
	 *
	 * @param uuid the data section's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data section
	 * @throws PortalException if a matching data section could not be found
	 */
	@Override
	public com.osp.icecap.model.DataSection getDataSectionByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSectionLocalService.getDataSectionByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the data sections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of data sections
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataSection> getDataSections(
		int start, int end) {

		return _dataSectionLocalService.getDataSections(start, end);
	}

	/**
	 * Returns all the data sections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sections
	 * @param companyId the primary key of the company
	 * @return the matching data sections, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataSection>
		getDataSectionsByUuidAndCompanyId(String uuid, long companyId) {

		return _dataSectionLocalService.getDataSectionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data sections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sections
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data sections, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataSection>
		getDataSectionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icecap.model.DataSection> orderByComparator) {

		return _dataSectionLocalService.getDataSectionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data sections.
	 *
	 * @return the number of data sections
	 */
	@Override
	public int getDataSectionsCount() {
		return _dataSectionLocalService.getDataSectionsCount();
	}

	@Override
	public int getDataSectionVariantsCount(long dataSectionId) {
		return _dataSectionLocalService.getDataSectionVariantsCount(
			dataSectionId);
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataSection>
		getDataSectionVarients(long dataSectionId) {

		return _dataSectionLocalService.getDataSectionVarients(dataSectionId);
	}

	@Override
	public java.util.List<com.osp.icecap.model.DataSection>
		getDataSectionVarients(long dataSectionId, int start, int end) {

		return _dataSectionLocalService.getDataSectionVarients(
			dataSectionId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataSectionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataSectionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataSectionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSectionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.osp.icecap.model.DataSection removeDataSection(
			long dataSectionId)
		throws com.osp.icecap.exception.NoSuchDataSectionException {

		return _dataSectionLocalService.removeDataSection(dataSectionId);
	}

	/**
	 * Updates the data section in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataSection the data section
	 * @return the data section that was updated
	 */
	@Override
	public com.osp.icecap.model.DataSection updateDataSection(
		com.osp.icecap.model.DataSection dataSection) {

		return _dataSectionLocalService.updateDataSection(dataSection);
	}

	@Override
	public com.osp.icecap.model.DataSection updateDataSection(
			long dataSectionId, long dataCollectionId, long dataSetId,
			String name, String version, long copiedFrom,
			com.liferay.portal.kernel.json.JSONObject metaDataJSON,
			String layout, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.osp.icecap.exception.NoSuchDataSectionException,
			   com.osp.icecap.exception.NoSuchMetaDataFieldException {

		return _dataSectionLocalService.updateDataSection(
			dataSectionId, dataCollectionId, dataSetId, name, version,
			copiedFrom, metaDataJSON, layout, sc);
	}

	@Override
	public DataSectionLocalService getWrappedService() {
		return _dataSectionLocalService;
	}

	@Override
	public void setWrappedService(
		DataSectionLocalService dataSectionLocalService) {

		_dataSectionLocalService = dataSectionLocalService;
	}

	private DataSectionLocalService _dataSectionLocalService;

}