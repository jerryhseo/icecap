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

import com.osp.icecap.model.DataPack;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the data pack service. This utility wraps <code>com.osp.icecap.service.persistence.impl.DataPackPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataPackPersistence
 * @generated
 */
public class DataPackUtil {

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
	public static void clearCache(DataPack dataPack) {
		getPersistence().clearCache(dataPack);
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
	public static Map<Serializable, DataPack> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataPack> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataPack> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataPack> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataPack update(DataPack dataPack) {
		return getPersistence().update(dataPack);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataPack update(
		DataPack dataPack, ServiceContext serviceContext) {

		return getPersistence().update(dataPack, serviceContext);
	}

	/**
	 * Returns all the data packs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data packs
	 */
	public static List<DataPack> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the data packs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByUuid_First(
			String uuid, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByUuid_First(
		String uuid, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByUuid_Last(
			String uuid, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByUuid_Last(
		String uuid, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where uuid = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByUuid_PrevAndNext(
			long dataPackId, String uuid,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUuid_PrevAndNext(
			dataPackId, uuid, orderByComparator);
	}

	/**
	 * Removes all the data packs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of data packs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data packs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the data pack where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataPackException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByUUID_G(String uuid, long groupId)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data pack where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data pack where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the data pack where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data pack that was removed
	 */
	public static DataPack removeByUUID_G(String uuid, long groupId)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of data packs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data packs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the data packs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data packs
	 */
	public static List<DataPack> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the data packs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByUuid_C_PrevAndNext(
			long dataPackId, String uuid, long companyId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dataPackId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the data packs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of data packs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data packs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the data packs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data packs
	 */
	public static List<DataPack> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the data packs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByGroupId_First(
			long groupId, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByGroupId_First(
		long groupId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByGroupId_Last(
			long groupId, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByGroupId_Last(
		long groupId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where groupId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByGroupId_PrevAndNext(
			long dataPackId, long groupId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByGroupId_PrevAndNext(
			dataPackId, groupId, orderByComparator);
	}

	/**
	 * Returns all the data packs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data packs that the user has permission to view
	 */
	public static List<DataPack> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the data packs that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs that the user has permission to view
	 */
	public static List<DataPack> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs that the user has permission to view
	 */
	public static List<DataPack> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set of data packs that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] filterFindByGroupId_PrevAndNext(
			long dataPackId, long groupId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			dataPackId, groupId, orderByComparator);
	}

	/**
	 * Removes all the data packs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of data packs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data packs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of data packs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data packs that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the data packs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data packs
	 */
	public static List<DataPack> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the data packs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByUserId_First(
			long userId, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByUserId_First(
		long userId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByUserId_Last(
			long userId, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByUserId_Last(
		long userId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where userId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByUserId_PrevAndNext(
			long dataPackId, long userId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByUserId_PrevAndNext(
			dataPackId, userId, orderByComparator);
	}

	/**
	 * Removes all the data packs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of data packs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data packs
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the data packs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data packs
	 */
	public static List<DataPack> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the data packs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByStatus_First(
			int status, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByStatus_First(
		int status, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByStatus_Last(
			int status, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByStatus_Last(
		int status, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where status = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByStatus_PrevAndNext(
			long dataPackId, int status,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByStatus_PrevAndNext(
			dataPackId, status, orderByComparator);
	}

	/**
	 * Removes all the data packs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of data packs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data packs
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the data packs where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching data packs
	 */
	public static List<DataPack> findByDataCollectionId(long dataCollectionId) {
		return getPersistence().findByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns a range of all the data packs where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByDataCollectionId(
		long dataCollectionId, int start, int end) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByDataCollectionId_First(
		long dataCollectionId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByDataCollectionId_Last(
		long dataCollectionId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByDataCollectionId_PrevAndNext(
			long dataPackId, long dataCollectionId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataCollectionId_PrevAndNext(
			dataPackId, dataCollectionId, orderByComparator);
	}

	/**
	 * Removes all the data packs where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByDataCollectionId(long dataCollectionId) {
		getPersistence().removeByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns the number of data packs where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching data packs
	 */
	public static int countByDataCollectionId(long dataCollectionId) {
		return getPersistence().countByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns all the data packs where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data packs
	 */
	public static List<DataPack> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the data packs where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByDataSetId_First(
			long dataSetId, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByDataSetId_First(
		long dataSetId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByDataSetId_Last(
			long dataSetId, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByDataSetId_PrevAndNext(
			long dataPackId, long dataSetId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataSetId_PrevAndNext(
			dataPackId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the data packs where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of data packs where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data packs
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns all the data packs where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching data packs
	 */
	public static List<DataPack> findByDataSectionId(long dataSectionId) {
		return getPersistence().findByDataSectionId(dataSectionId);
	}

	/**
	 * Returns a range of all the data packs where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByDataSectionId(
		long dataSectionId, int start, int end) {

		return getPersistence().findByDataSectionId(dataSectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByDataSectionId(
			dataSectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDataSectionId(
			dataSectionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByDataSectionId_First(
			long dataSectionId, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataSectionId_First(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByDataSectionId_First(
		long dataSectionId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByDataSectionId_First(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByDataSectionId_Last(
			long dataSectionId, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataSectionId_Last(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByDataSectionId_Last(
		long dataSectionId, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByDataSectionId_Last(
			dataSectionId, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByDataSectionId_PrevAndNext(
			long dataPackId, long dataSectionId,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByDataSectionId_PrevAndNext(
			dataPackId, dataSectionId, orderByComparator);
	}

	/**
	 * Removes all the data packs where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	public static void removeByDataSectionId(long dataSectionId) {
		getPersistence().removeByDataSectionId(dataSectionId);
	}

	/**
	 * Returns the number of data packs where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching data packs
	 */
	public static int countByDataSectionId(long dataSectionId) {
		return getPersistence().countByDataSectionId(dataSectionId);
	}

	/**
	 * Returns all the data packs where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the matching data packs
	 */
	public static List<DataPack> findByCopiedFrom(long copiedFrom) {
		return getPersistence().findByCopiedFrom(copiedFrom);
	}

	/**
	 * Returns a range of all the data packs where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByCopiedFrom(
		long copiedFrom, int start, int end) {

		return getPersistence().findByCopiedFrom(copiedFrom, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByCopiedFrom(
		long copiedFrom, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByCopiedFrom(
			copiedFrom, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByCopiedFrom(
		long copiedFrom, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCopiedFrom(
			copiedFrom, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByCopiedFrom_First(
			long copiedFrom, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByCopiedFrom_First(
			copiedFrom, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByCopiedFrom_First(
		long copiedFrom, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByCopiedFrom_First(
			copiedFrom, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByCopiedFrom_Last(
			long copiedFrom, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByCopiedFrom_Last(
			copiedFrom, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByCopiedFrom_Last(
		long copiedFrom, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByCopiedFrom_Last(
			copiedFrom, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByCopiedFrom_PrevAndNext(
			long dataPackId, long copiedFrom,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByCopiedFrom_PrevAndNext(
			dataPackId, copiedFrom, orderByComparator);
	}

	/**
	 * Removes all the data packs where copiedFrom = &#63; from the database.
	 *
	 * @param copiedFrom the copied from
	 */
	public static void removeByCopiedFrom(long copiedFrom) {
		getPersistence().removeByCopiedFrom(copiedFrom);
	}

	/**
	 * Returns the number of data packs where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the number of matching data packs
	 */
	public static int countByCopiedFrom(long copiedFrom) {
		return getPersistence().countByCopiedFrom(copiedFrom);
	}

	/**
	 * Returns all the data packs where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching data packs
	 */
	public static List<DataPack> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the data packs where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of matching data packs
	 */
	public static List<DataPack> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the data packs where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByName(
		String name, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data packs
	 */
	public static List<DataPack> findByName(
		String name, int start, int end,
		OrderByComparator<DataPack> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByName_First(
			String name, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first data pack in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByName_First(
		String name, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public static DataPack findByName_Last(
			String name, OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last data pack in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public static DataPack fetchByName_Last(
		String name, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where name = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack[] findByName_PrevAndNext(
			long dataPackId, String name,
			OrderByComparator<DataPack> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByName_PrevAndNext(
			dataPackId, name, orderByComparator);
	}

	/**
	 * Removes all the data packs where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of data packs where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching data packs
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the data pack in the entity cache if it is enabled.
	 *
	 * @param dataPack the data pack
	 */
	public static void cacheResult(DataPack dataPack) {
		getPersistence().cacheResult(dataPack);
	}

	/**
	 * Caches the data packs in the entity cache if it is enabled.
	 *
	 * @param dataPacks the data packs
	 */
	public static void cacheResult(List<DataPack> dataPacks) {
		getPersistence().cacheResult(dataPacks);
	}

	/**
	 * Creates a new data pack with the primary key. Does not add the data pack to the database.
	 *
	 * @param dataPackId the primary key for the new data pack
	 * @return the new data pack
	 */
	public static DataPack create(long dataPackId) {
		return getPersistence().create(dataPackId);
	}

	/**
	 * Removes the data pack with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack that was removed
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack remove(long dataPackId)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().remove(dataPackId);
	}

	public static DataPack updateImpl(DataPack dataPack) {
		return getPersistence().updateImpl(dataPack);
	}

	/**
	 * Returns the data pack with the primary key or throws a <code>NoSuchDataPackException</code> if it could not be found.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public static DataPack findByPrimaryKey(long dataPackId)
		throws com.osp.icecap.exception.NoSuchDataPackException {

		return getPersistence().findByPrimaryKey(dataPackId);
	}

	/**
	 * Returns the data pack with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack, or <code>null</code> if a data pack with the primary key could not be found
	 */
	public static DataPack fetchByPrimaryKey(long dataPackId) {
		return getPersistence().fetchByPrimaryKey(dataPackId);
	}

	/**
	 * Returns all the data packs.
	 *
	 * @return the data packs
	 */
	public static List<DataPack> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data packs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of data packs
	 */
	public static List<DataPack> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data packs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data packs
	 */
	public static List<DataPack> findAll(
		int start, int end, OrderByComparator<DataPack> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data packs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data packs
	 */
	public static List<DataPack> findAll(
		int start, int end, OrderByComparator<DataPack> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data packs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data packs.
	 *
	 * @return the number of data packs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataPackPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DataPackPersistence, DataPackPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataPackPersistence.class);

		ServiceTracker<DataPackPersistence, DataPackPersistence>
			serviceTracker =
				new ServiceTracker<DataPackPersistence, DataPackPersistence>(
					bundle.getBundleContext(), DataPackPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}