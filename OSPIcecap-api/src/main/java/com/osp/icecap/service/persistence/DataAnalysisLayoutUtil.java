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

package com.osp.icecap.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icecap.model.DataAnalysisLayout;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the data analysis layout service. This utility wraps <code>com.osp.icecap.service.persistence.impl.DataAnalysisLayoutPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataAnalysisLayoutPersistence
 * @generated
 */
@ProviderType
public class DataAnalysisLayoutUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DataAnalysisLayout dataAnalysisLayout) {
		getPersistence().clearCache(dataAnalysisLayout);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DataAnalysisLayout> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataAnalysisLayout> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataAnalysisLayout> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataAnalysisLayout> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataAnalysisLayout update(
		DataAnalysisLayout dataAnalysisLayout) {

		return getPersistence().update(dataAnalysisLayout);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataAnalysisLayout update(
		DataAnalysisLayout dataAnalysisLayout, ServiceContext serviceContext) {

		return getPersistence().update(dataAnalysisLayout, serviceContext);
	}

	/**
	 * Returns all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId) {

		return getPersistence().findByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns a range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout fetchByDataCollectionId_First(
		long dataCollectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout fetchByDataCollectionId_Last(
		long dataCollectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public static DataAnalysisLayout[] findByDataCollectionId_PrevAndNext(
			String dataUuid, long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataCollectionId_PrevAndNext(
			dataUuid, dataCollectionId, orderByComparator);
	}

	/**
	 * Removes all the data analysis layouts where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByDataCollectionId(long dataCollectionId) {
		getPersistence().removeByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns the number of data analysis layouts where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching data analysis layouts
	 */
	public static int countByDataCollectionId(long dataCollectionId) {
		return getPersistence().countByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns all the data analysis layouts where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout findByDataSetId_First(
			long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout fetchByDataSetId_First(
		long dataSetId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout findByDataSetId_Last(
			long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout fetchByDataSetId_Last(
		long dataSetId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public static DataAnalysisLayout[] findByDataSetId_PrevAndNext(
			String dataUuid, long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataSetId_PrevAndNext(
			dataUuid, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the data analysis layouts where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of data analysis layouts where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data analysis layouts
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId) {

		return getPersistence().findByDataSectionId(dataSectionId);
	}

	/**
	 * Returns a range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end) {

		return getPersistence().findByDataSectionId(dataSectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().findByDataSectionId(
			dataSectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataSectionId(
			dataSectionId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout findByDataSectionId_First(
			long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataSectionId_First(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout fetchByDataSectionId_First(
		long dataSectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().fetchByDataSectionId_First(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout findByDataSectionId_Last(
			long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataSectionId_Last(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout fetchByDataSectionId_Last(
		long dataSectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().fetchByDataSectionId_Last(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public static DataAnalysisLayout[] findByDataSectionId_PrevAndNext(
			String dataUuid, long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataSectionId_PrevAndNext(
			dataUuid, dataSectionId, orderByComparator);
	}

	/**
	 * Removes all the data analysis layouts where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	public static void removeByDataSectionId(long dataSectionId) {
		getPersistence().removeByDataSectionId(dataSectionId);
	}

	/**
	 * Returns the number of data analysis layouts where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching data analysis layouts
	 */
	public static int countByDataSectionId(long dataSectionId) {
		return getPersistence().countByDataSectionId(dataSectionId);
	}

	/**
	 * Returns all the data analysis layouts where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataPackId(long dataPackId) {
		return getPersistence().findByDataPackId(dataPackId);
	}

	/**
	 * Returns a range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end) {

		return getPersistence().findByDataPackId(dataPackId, start, end);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().findByDataPackId(
			dataPackId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	public static List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataPackId(
			dataPackId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout findByDataPackId_First(
			long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataPackId_First(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout fetchByDataPackId_First(
		long dataPackId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().fetchByDataPackId_First(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout findByDataPackId_Last(
			long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataPackId_Last(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public static DataAnalysisLayout fetchByDataPackId_Last(
		long dataPackId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().fetchByDataPackId_Last(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public static DataAnalysisLayout[] findByDataPackId_PrevAndNext(
			String dataUuid, long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByDataPackId_PrevAndNext(
			dataUuid, dataPackId, orderByComparator);
	}

	/**
	 * Removes all the data analysis layouts where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	public static void removeByDataPackId(long dataPackId) {
		getPersistence().removeByDataPackId(dataPackId);
	}

	/**
	 * Returns the number of data analysis layouts where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching data analysis layouts
	 */
	public static int countByDataPackId(long dataPackId) {
		return getPersistence().countByDataPackId(dataPackId);
	}

	/**
	 * Caches the data analysis layout in the entity cache if it is enabled.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 */
	public static void cacheResult(DataAnalysisLayout dataAnalysisLayout) {
		getPersistence().cacheResult(dataAnalysisLayout);
	}

	/**
	 * Caches the data analysis layouts in the entity cache if it is enabled.
	 *
	 * @param dataAnalysisLayouts the data analysis layouts
	 */
	public static void cacheResult(
		List<DataAnalysisLayout> dataAnalysisLayouts) {

		getPersistence().cacheResult(dataAnalysisLayouts);
	}

	/**
	 * Creates a new data analysis layout with the primary key. Does not add the data analysis layout to the database.
	 *
	 * @param dataUuid the primary key for the new data analysis layout
	 * @return the new data analysis layout
	 */
	public static DataAnalysisLayout create(String dataUuid) {
		return getPersistence().create(dataUuid);
	}

	/**
	 * Removes the data analysis layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout that was removed
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public static DataAnalysisLayout remove(String dataUuid)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().remove(dataUuid);
	}

	public static DataAnalysisLayout updateImpl(
		DataAnalysisLayout dataAnalysisLayout) {

		return getPersistence().updateImpl(dataAnalysisLayout);
	}

	/**
	 * Returns the data analysis layout with the primary key or throws a <code>NoSuchDataAnalysisLayoutException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public static DataAnalysisLayout findByPrimaryKey(String dataUuid)
		throws com.osp.icecap.exception.NoSuchDataAnalysisLayoutException {

		return getPersistence().findByPrimaryKey(dataUuid);
	}

	/**
	 * Returns the data analysis layout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout, or <code>null</code> if a data analysis layout with the primary key could not be found
	 */
	public static DataAnalysisLayout fetchByPrimaryKey(String dataUuid) {
		return getPersistence().fetchByPrimaryKey(dataUuid);
	}

	/**
	 * Returns all the data analysis layouts.
	 *
	 * @return the data analysis layouts
	 */
	public static List<DataAnalysisLayout> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of data analysis layouts
	 */
	public static List<DataAnalysisLayout> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data analysis layouts
	 */
	public static List<DataAnalysisLayout> findAll(
		int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data analysis layouts
	 */
	public static List<DataAnalysisLayout> findAll(
		int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the data analysis layouts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data analysis layouts.
	 *
	 * @return the number of data analysis layouts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataAnalysisLayoutPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataAnalysisLayoutPersistence, DataAnalysisLayoutPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DataAnalysisLayoutPersistence.class);

		ServiceTracker
			<DataAnalysisLayoutPersistence, DataAnalysisLayoutPersistence>
				serviceTracker =
					new ServiceTracker
						<DataAnalysisLayoutPersistence,
						 DataAnalysisLayoutPersistence>(
							 bundle.getBundleContext(),
							 DataAnalysisLayoutPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}