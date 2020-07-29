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
 * Provides a wrapper for {@link DataAnalysisLayoutLocalService}.
 *
 * @author Jerry H. Seo
 * @see DataAnalysisLayoutLocalService
 * @generated
 */
@ProviderType
public class DataAnalysisLayoutLocalServiceWrapper
	implements DataAnalysisLayoutLocalService,
			   ServiceWrapper<DataAnalysisLayoutLocalService> {

	public DataAnalysisLayoutLocalServiceWrapper(
		DataAnalysisLayoutLocalService dataAnalysisLayoutLocalService) {

		_dataAnalysisLayoutLocalService = dataAnalysisLayoutLocalService;
	}

	/**
	 * Adds the data analysis layout to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was added
	 */
	@Override
	public com.osp.icecap.model.DataAnalysisLayout addDataAnalysisLayout(
		com.osp.icecap.model.DataAnalysisLayout dataAnalysisLayout) {

		return _dataAnalysisLayoutLocalService.addDataAnalysisLayout(
			dataAnalysisLayout);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject addDataAnalysisLayout(
			String dataUuidStr, String layoutStr)
		throws com.liferay.portal.kernel.json.JSONException {

		return _dataAnalysisLayoutLocalService.addDataAnalysisLayout(
			dataUuidStr, layoutStr);
	}

	/**
	 * Creates a new data analysis layout with the primary key. Does not add the data analysis layout to the database.
	 *
	 * @param dataUuid the primary key for the new data analysis layout
	 * @return the new data analysis layout
	 */
	@Override
	public com.osp.icecap.model.DataAnalysisLayout createDataAnalysisLayout(
		String dataUuid) {

		return _dataAnalysisLayoutLocalService.createDataAnalysisLayout(
			dataUuid);
	}

	/**
	 * Deletes the data analysis layout from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was removed
	 */
	@Override
	public com.osp.icecap.model.DataAnalysisLayout deleteDataAnalysisLayout(
		com.osp.icecap.model.DataAnalysisLayout dataAnalysisLayout) {

		return _dataAnalysisLayoutLocalService.deleteDataAnalysisLayout(
			dataAnalysisLayout);
	}

	/**
	 * Deletes the data analysis layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout that was removed
	 * @throws PortalException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataAnalysisLayout deleteDataAnalysisLayout(
			String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataAnalysisLayoutLocalService.deleteDataAnalysisLayout(
			dataUuid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataAnalysisLayoutLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataAnalysisLayoutLocalService.dynamicQuery();
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

		return _dataAnalysisLayoutLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataAnalysisLayoutLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataAnalysisLayoutLocalService.dynamicQuery(
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

		return _dataAnalysisLayoutLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataAnalysisLayoutLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icecap.model.DataAnalysisLayout fetchDataAnalysisLayout(
		String dataUuid) {

		return _dataAnalysisLayoutLocalService.fetchDataAnalysisLayout(
			dataUuid);
	}

	/**
	 * Returns the data analysis layout with the primary key.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout
	 * @throws PortalException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public com.osp.icecap.model.DataAnalysisLayout getDataAnalysisLayout(
			String dataUuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataAnalysisLayoutLocalService.getDataAnalysisLayout(dataUuid);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getDataAnalysisLayoutJSON(
			String dataUuidStr)
		throws com.liferay.portal.kernel.json.JSONException,
			   com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return _dataAnalysisLayoutLocalService.getDataAnalysisLayoutJSON(
			dataUuidStr);
	}

	/**
	 * Returns a range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of data analysis layouts
	 */
	@Override
	public java.util.List<com.osp.icecap.model.DataAnalysisLayout>
		getDataAnalysisLayouts(int start, int end) {

		return _dataAnalysisLayoutLocalService.getDataAnalysisLayouts(
			start, end);
	}

	/**
	 * Returns the number of data analysis layouts.
	 *
	 * @return the number of data analysis layouts
	 */
	@Override
	public int getDataAnalysisLayoutsCount() {
		return _dataAnalysisLayoutLocalService.getDataAnalysisLayoutsCount();
	}

	@Override
	public String getDataAnalysisLayoutStr(String dataUuidStr)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return _dataAnalysisLayoutLocalService.getDataAnalysisLayoutStr(
			dataUuidStr);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataAnalysisLayoutLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataAnalysisLayoutLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.osp.icecap.model.DataAnalysisLayout removeDataAnalysisLayout(
			String dataUuid)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return _dataAnalysisLayoutLocalService.removeDataAnalysisLayout(
			dataUuid);
	}

	/**
	 * Updates the data analysis layout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was updated
	 */
	@Override
	public com.osp.icecap.model.DataAnalysisLayout updateDataAnalysisLayout(
		com.osp.icecap.model.DataAnalysisLayout dataAnalysisLayout) {

		return _dataAnalysisLayoutLocalService.updateDataAnalysisLayout(
			dataAnalysisLayout);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject updateDataAnalysisLayout(
			String dataUuidStr, String layoutStr)
		throws com.liferay.portal.kernel.json.JSONException,
			   com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return _dataAnalysisLayoutLocalService.updateDataAnalysisLayout(
			dataUuidStr, layoutStr);
	}

	@Override
	public DataAnalysisLayoutLocalService getWrappedService() {
		return _dataAnalysisLayoutLocalService;
	}

	@Override
	public void setWrappedService(
		DataAnalysisLayoutLocalService dataAnalysisLayoutLocalService) {

		_dataAnalysisLayoutLocalService = dataAnalysisLayoutLocalService;
	}

	private DataAnalysisLayoutLocalService _dataAnalysisLayoutLocalService;

}