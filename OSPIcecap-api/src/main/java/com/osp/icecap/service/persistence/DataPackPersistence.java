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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.osp.icecap.exception.NoSuchDataPackException;
import com.osp.icecap.model.DataPack;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data pack service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataPackUtil
 * @generated
 */
@ProviderType
public interface DataPackPersistence extends BasePersistence<DataPack> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataPackUtil} to access the data pack persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data packs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByUuid(String uuid);

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
	public java.util.List<DataPack> findByUuid(String uuid, int start, int end);

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
	public java.util.List<DataPack> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where uuid = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByUuid_PrevAndNext(
			long dataPackId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data packs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data packs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data pack where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataPackException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByUUID_G(String uuid, long groupId)
		throws NoSuchDataPackException;

	/**
	 * Returns the data pack where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the data pack where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the data pack where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data pack that was removed
	 */
	public DataPack removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataPackException;

	/**
	 * Returns the number of data packs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data packs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data packs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<DataPack> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DataPack> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public DataPack[] findByUuid_C_PrevAndNext(
			long dataPackId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data packs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data packs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data packs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByGroupId(long groupId);

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
	public java.util.List<DataPack> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DataPack> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where groupId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByGroupId_PrevAndNext(
			long dataPackId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns all the data packs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data packs that the user has permission to view
	 */
	public java.util.List<DataPack> filterFindByGroupId(long groupId);

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
	public java.util.List<DataPack> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DataPack> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set of data packs that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] filterFindByGroupId_PrevAndNext(
			long dataPackId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data packs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data packs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of data packs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data packs that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the data packs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByUserId(long userId);

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
	public java.util.List<DataPack> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<DataPack> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where userId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByUserId_PrevAndNext(
			long dataPackId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of data packs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data packs
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the data packs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByStatus(int status);

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
	public java.util.List<DataPack> findByStatus(
		int status, int start, int end);

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
	public java.util.List<DataPack> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where status = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByStatus_PrevAndNext(
			long dataPackId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of data packs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data packs
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the data packs where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByDataCollectionId(
		long dataCollectionId);

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
	public java.util.List<DataPack> findByDataCollectionId(
		long dataCollectionId, int start, int end);

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
	public java.util.List<DataPack> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByDataCollectionId_First(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByDataCollectionId_First(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByDataCollectionId_Last(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByDataCollectionId_Last(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByDataCollectionId_PrevAndNext(
			long dataPackId, long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public void removeByDataCollectionId(long dataCollectionId);

	/**
	 * Returns the number of data packs where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching data packs
	 */
	public int countByDataCollectionId(long dataCollectionId);

	/**
	 * Returns all the data packs where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByDataSetId(long dataSetId);

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
	public java.util.List<DataPack> findByDataSetId(
		long dataSetId, int start, int end);

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
	public java.util.List<DataPack> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByDataSetId_First(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByDataSetId_First(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByDataSetId_Last(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByDataSetId_Last(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByDataSetId_PrevAndNext(
			long dataPackId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of data packs where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data packs
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the data packs where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByDataSectionId(long dataSectionId);

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
	public java.util.List<DataPack> findByDataSectionId(
		long dataSectionId, int start, int end);

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
	public java.util.List<DataPack> findByDataSectionId(
		long dataSectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByDataSectionId(
		long dataSectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByDataSectionId_First(
			long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByDataSectionId_First(
		long dataSectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByDataSectionId_Last(
			long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByDataSectionId_Last(
		long dataSectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByDataSectionId_PrevAndNext(
			long dataPackId, long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	public void removeByDataSectionId(long dataSectionId);

	/**
	 * Returns the number of data packs where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching data packs
	 */
	public int countByDataSectionId(long dataSectionId);

	/**
	 * Returns all the data packs where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByCopiedFrom(long copiedFrom);

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
	public java.util.List<DataPack> findByCopiedFrom(
		long copiedFrom, int start, int end);

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
	public java.util.List<DataPack> findByCopiedFrom(
		long copiedFrom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByCopiedFrom(
		long copiedFrom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByCopiedFrom_First(
			long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByCopiedFrom_First(
		long copiedFrom,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByCopiedFrom_Last(
			long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByCopiedFrom_Last(
		long copiedFrom,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where copiedFrom = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByCopiedFrom_PrevAndNext(
			long dataPackId, long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where copiedFrom = &#63; from the database.
	 *
	 * @param copiedFrom the copied from
	 */
	public void removeByCopiedFrom(long copiedFrom);

	/**
	 * Returns the number of data packs where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the number of matching data packs
	 */
	public int countByCopiedFrom(long copiedFrom);

	/**
	 * Returns all the data packs where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching data packs
	 */
	public java.util.List<DataPack> findByName(String name);

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
	public java.util.List<DataPack> findByName(String name, int start, int end);

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
	public java.util.List<DataPack> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the first data pack in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the last data pack in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack
	 * @throws NoSuchDataPackException if a matching data pack could not be found
	 */
	public DataPack findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Returns the last data pack in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	public DataPack fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

	/**
	 * Returns the data packs before and after the current data pack in the ordered set where name = &#63;.
	 *
	 * @param dataPackId the primary key of the current data pack
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack[] findByName_PrevAndNext(
			long dataPackId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<DataPack>
				orderByComparator)
		throws NoSuchDataPackException;

	/**
	 * Removes all the data packs where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of data packs where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching data packs
	 */
	public int countByName(String name);

	/**
	 * Caches the data pack in the entity cache if it is enabled.
	 *
	 * @param dataPack the data pack
	 */
	public void cacheResult(DataPack dataPack);

	/**
	 * Caches the data packs in the entity cache if it is enabled.
	 *
	 * @param dataPacks the data packs
	 */
	public void cacheResult(java.util.List<DataPack> dataPacks);

	/**
	 * Creates a new data pack with the primary key. Does not add the data pack to the database.
	 *
	 * @param dataPackId the primary key for the new data pack
	 * @return the new data pack
	 */
	public DataPack create(long dataPackId);

	/**
	 * Removes the data pack with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack that was removed
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack remove(long dataPackId) throws NoSuchDataPackException;

	public DataPack updateImpl(DataPack dataPack);

	/**
	 * Returns the data pack with the primary key or throws a <code>NoSuchDataPackException</code> if it could not be found.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack
	 * @throws NoSuchDataPackException if a data pack with the primary key could not be found
	 */
	public DataPack findByPrimaryKey(long dataPackId)
		throws NoSuchDataPackException;

	/**
	 * Returns the data pack with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack, or <code>null</code> if a data pack with the primary key could not be found
	 */
	public DataPack fetchByPrimaryKey(long dataPackId);

	/**
	 * Returns all the data packs.
	 *
	 * @return the data packs
	 */
	public java.util.List<DataPack> findAll();

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
	public java.util.List<DataPack> findAll(int start, int end);

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
	public java.util.List<DataPack> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator);

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
	public java.util.List<DataPack> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPack>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data packs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data packs.
	 *
	 * @return the number of data packs
	 */
	public int countAll();

}