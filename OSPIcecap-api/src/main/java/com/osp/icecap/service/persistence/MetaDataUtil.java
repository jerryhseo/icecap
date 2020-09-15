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

import com.osp.icecap.model.MetaData;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the meta data service. This utility wraps <code>com.osp.icecap.service.persistence.impl.MetaDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see MetaDataPersistence
 * @generated
 */
@ProviderType
public class MetaDataUtil {

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
	public static void clearCache(MetaData metaData) {
		getPersistence().clearCache(metaData);
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
	public static Map<Serializable, MetaData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MetaData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MetaData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MetaData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MetaData update(MetaData metaData) {
		return getPersistence().update(metaData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MetaData update(
		MetaData metaData, ServiceContext serviceContext) {

		return getPersistence().update(metaData, serviceContext);
	}

	/**
	 * Returns all the meta datas where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching meta datas
	 */
	public static List<MetaData> findByDataCollectionId(long dataCollectionId) {
		return getPersistence().findByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns a range of all the meta datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	public static List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<MetaData> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataCollectionId_First(
		long dataCollectionId, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataCollectionId_Last(
		long dataCollectionId, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public static MetaData[] findByDataCollectionId_PrevAndNext(
			String dataUuid, long dataCollectionId,
			OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataCollectionId_PrevAndNext(
			dataUuid, dataCollectionId, orderByComparator);
	}

	/**
	 * Removes all the meta datas where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByDataCollectionId(long dataCollectionId) {
		getPersistence().removeByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns the number of meta datas where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching meta datas
	 */
	public static int countByDataCollectionId(long dataCollectionId) {
		return getPersistence().countByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns all the meta datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching meta datas
	 */
	public static List<MetaData> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the meta datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	public static List<MetaData> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<MetaData> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataSetId_First(
			long dataSetId, OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataSetId_First(
		long dataSetId, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataSetId_Last(
			long dataSetId, OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public static MetaData[] findByDataSetId_PrevAndNext(
			String dataUuid, long dataSetId,
			OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataSetId_PrevAndNext(
			dataUuid, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the meta datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of meta datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching meta datas
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns all the meta datas where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching meta datas
	 */
	public static List<MetaData> findByDataSectionId(long dataSectionId) {
		return getPersistence().findByDataSectionId(dataSectionId);
	}

	/**
	 * Returns a range of all the meta datas where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	public static List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end) {

		return getPersistence().findByDataSectionId(dataSectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().findByDataSectionId(
			dataSectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<MetaData> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataSectionId(
			dataSectionId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataSectionId_First(
			long dataSectionId, OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataSectionId_First(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the first meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataSectionId_First(
		long dataSectionId, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByDataSectionId_First(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataSectionId_Last(
			long dataSectionId, OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataSectionId_Last(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataSectionId_Last(
		long dataSectionId, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByDataSectionId_Last(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public static MetaData[] findByDataSectionId_PrevAndNext(
			String dataUuid, long dataSectionId,
			OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataSectionId_PrevAndNext(
			dataUuid, dataSectionId, orderByComparator);
	}

	/**
	 * Removes all the meta datas where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	public static void removeByDataSectionId(long dataSectionId) {
		getPersistence().removeByDataSectionId(dataSectionId);
	}

	/**
	 * Returns the number of meta datas where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching meta datas
	 */
	public static int countByDataSectionId(long dataSectionId) {
		return getPersistence().countByDataSectionId(dataSectionId);
	}

	/**
	 * Returns all the meta datas where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching meta datas
	 */
	public static List<MetaData> findByDataPackId(long dataPackId) {
		return getPersistence().findByDataPackId(dataPackId);
	}

	/**
	 * Returns a range of all the meta datas where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	public static List<MetaData> findByDataPackId(
		long dataPackId, int start, int end) {

		return getPersistence().findByDataPackId(dataPackId, start, end);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().findByDataPackId(
			dataPackId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<MetaData> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataPackId(
			dataPackId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataPackId_First(
			long dataPackId, OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataPackId_First(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the first meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataPackId_First(
		long dataPackId, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByDataPackId_First(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataPackId_Last(
			long dataPackId, OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataPackId_Last(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataPackId_Last(
		long dataPackId, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByDataPackId_Last(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public static MetaData[] findByDataPackId_PrevAndNext(
			String dataUuid, long dataPackId,
			OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataPackId_PrevAndNext(
			dataUuid, dataPackId, orderByComparator);
	}

	/**
	 * Removes all the meta datas where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	public static void removeByDataPackId(long dataPackId) {
		getPersistence().removeByDataPackId(dataPackId);
	}

	/**
	 * Returns the number of meta datas where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching meta datas
	 */
	public static int countByDataPackId(long dataPackId) {
		return getPersistence().countByDataPackId(dataPackId);
	}

	/**
	 * Returns the meta data where dataEntryId = &#63; or throws a <code>NoSuchMetaDataException</code> if it could not be found.
	 *
	 * @param dataEntryId the data entry ID
	 * @return the matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByDataEntryId(long dataEntryId)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByDataEntryId(dataEntryId);
	}

	/**
	 * Returns the meta data where dataEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataEntryId the data entry ID
	 * @return the matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataEntryId(long dataEntryId) {
		return getPersistence().fetchByDataEntryId(dataEntryId);
	}

	/**
	 * Returns the meta data where dataEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataEntryId the data entry ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByDataEntryId(
		long dataEntryId, boolean retrieveFromCache) {

		return getPersistence().fetchByDataEntryId(
			dataEntryId, retrieveFromCache);
	}

	/**
	 * Removes the meta data where dataEntryId = &#63; from the database.
	 *
	 * @param dataEntryId the data entry ID
	 * @return the meta data that was removed
	 */
	public static MetaData removeByDataEntryId(long dataEntryId)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().removeByDataEntryId(dataEntryId);
	}

	/**
	 * Returns the number of meta datas where dataEntryId = &#63;.
	 *
	 * @param dataEntryId the data entry ID
	 * @return the number of matching meta datas
	 */
	public static int countByDataEntryId(long dataEntryId) {
		return getPersistence().countByDataEntryId(dataEntryId);
	}

	/**
	 * Returns all the meta datas where creator = &#63;.
	 *
	 * @param creator the creator
	 * @return the matching meta datas
	 */
	public static List<MetaData> findByCreator(String creator) {
		return getPersistence().findByCreator(creator);
	}

	/**
	 * Returns a range of all the meta datas where creator = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creator the creator
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	public static List<MetaData> findByCreator(
		String creator, int start, int end) {

		return getPersistence().findByCreator(creator, start, end);
	}

	/**
	 * Returns an ordered range of all the meta datas where creator = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creator the creator
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByCreator(
		String creator, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().findByCreator(
			creator, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where creator = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creator the creator
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public static List<MetaData> findByCreator(
		String creator, int start, int end,
		OrderByComparator<MetaData> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCreator(
			creator, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByCreator_First(
			String creator, OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByCreator_First(creator, orderByComparator);
	}

	/**
	 * Returns the first meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByCreator_First(
		String creator, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByCreator_First(
			creator, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public static MetaData findByCreator_Last(
			String creator, OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByCreator_Last(creator, orderByComparator);
	}

	/**
	 * Returns the last meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public static MetaData fetchByCreator_Last(
		String creator, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().fetchByCreator_Last(creator, orderByComparator);
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where creator = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public static MetaData[] findByCreator_PrevAndNext(
			String dataUuid, String creator,
			OrderByComparator<MetaData> orderByComparator)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByCreator_PrevAndNext(
			dataUuid, creator, orderByComparator);
	}

	/**
	 * Removes all the meta datas where creator = &#63; from the database.
	 *
	 * @param creator the creator
	 */
	public static void removeByCreator(String creator) {
		getPersistence().removeByCreator(creator);
	}

	/**
	 * Returns the number of meta datas where creator = &#63;.
	 *
	 * @param creator the creator
	 * @return the number of matching meta datas
	 */
	public static int countByCreator(String creator) {
		return getPersistence().countByCreator(creator);
	}

	/**
	 * Caches the meta data in the entity cache if it is enabled.
	 *
	 * @param metaData the meta data
	 */
	public static void cacheResult(MetaData metaData) {
		getPersistence().cacheResult(metaData);
	}

	/**
	 * Caches the meta datas in the entity cache if it is enabled.
	 *
	 * @param metaDatas the meta datas
	 */
	public static void cacheResult(List<MetaData> metaDatas) {
		getPersistence().cacheResult(metaDatas);
	}

	/**
	 * Creates a new meta data with the primary key. Does not add the meta data to the database.
	 *
	 * @param dataUuid the primary key for the new meta data
	 * @return the new meta data
	 */
	public static MetaData create(String dataUuid) {
		return getPersistence().create(dataUuid);
	}

	/**
	 * Removes the meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data that was removed
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public static MetaData remove(String dataUuid)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().remove(dataUuid);
	}

	public static MetaData updateImpl(MetaData metaData) {
		return getPersistence().updateImpl(metaData);
	}

	/**
	 * Returns the meta data with the primary key or throws a <code>NoSuchMetaDataException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public static MetaData findByPrimaryKey(String dataUuid)
		throws com.osp.icecap.exception.NoSuchMetaDataException {

		return getPersistence().findByPrimaryKey(dataUuid);
	}

	/**
	 * Returns the meta data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data, or <code>null</code> if a meta data with the primary key could not be found
	 */
	public static MetaData fetchByPrimaryKey(String dataUuid) {
		return getPersistence().fetchByPrimaryKey(dataUuid);
	}

	/**
	 * Returns all the meta datas.
	 *
	 * @return the meta datas
	 */
	public static List<MetaData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of meta datas
	 */
	public static List<MetaData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of meta datas
	 */
	public static List<MetaData> findAll(
		int start, int end, OrderByComparator<MetaData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of meta datas
	 */
	public static List<MetaData> findAll(
		int start, int end, OrderByComparator<MetaData> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the meta datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of meta datas.
	 *
	 * @return the number of meta datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MetaDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MetaDataPersistence, MetaDataPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MetaDataPersistence.class);

		ServiceTracker<MetaDataPersistence, MetaDataPersistence>
			serviceTracker =
				new ServiceTracker<MetaDataPersistence, MetaDataPersistence>(
					bundle.getBundleContext(), MetaDataPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}