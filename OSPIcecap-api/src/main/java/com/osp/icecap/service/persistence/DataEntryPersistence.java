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

import com.osp.icecap.exception.NoSuchDataEntryException;
import com.osp.icecap.model.DataEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataEntryUtil
 * @generated
 */
@ProviderType
public interface DataEntryPersistence extends BasePersistence<DataEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataEntryUtil} to access the data entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the data entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where uuid = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByUuid_PrevAndNext(
			long dataEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDataEntryException;

	/**
	 * Returns the data entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the data entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the data entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data entry that was removed
	 */
	public DataEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataEntryException;

	/**
	 * Returns the number of data entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the data entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByUuid_C_PrevAndNext(
			long dataEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByGroupId(long groupId);

	/**
	 * Returns a range of all the data entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where groupId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByGroupId_PrevAndNext(
			long dataEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns all the data entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data entries that the user has permission to view
	 */
	public java.util.List<DataEntry> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the data entries that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries that the user has permission to view
	 */
	public java.util.List<DataEntry> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries that the user has permission to view
	 */
	public java.util.List<DataEntry> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set of data entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] filterFindByGroupId_PrevAndNext(
			long dataEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data entries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of data entries that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data entries that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the data entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByUserId(long userId);

	/**
	 * Returns a range of all the data entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where userId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByUserId_PrevAndNext(
			long dataEntryId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of data entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data entries
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the data entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByStatus(int status);

	/**
	 * Returns a range of all the data entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where status = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByStatus_PrevAndNext(
			long dataEntryId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of data entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data entries
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the data entries where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByDataCollectionId(
		long dataCollectionId);

	/**
	 * Returns a range of all the data entries where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataCollectionId(
		long dataCollectionId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataCollectionId_First(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataCollectionId_First(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataCollectionId_Last(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataCollectionId_Last(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByDataCollectionId_PrevAndNext(
			long dataEntryId, long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public void removeByDataCollectionId(long dataCollectionId);

	/**
	 * Returns the number of data entries where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching data entries
	 */
	public int countByDataCollectionId(long dataCollectionId);

	/**
	 * Returns all the data entries where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByDataSetId(long dataSetId);

	/**
	 * Returns a range of all the data entries where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataSetId(
		long dataSetId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataSetId_First(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataSetId_First(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataSetId_Last(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataSetId_Last(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByDataSetId_PrevAndNext(
			long dataEntryId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of data entries where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data entries
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the data entries where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByDataSectionId(long dataSectionId);

	/**
	 * Returns a range of all the data entries where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataSectionId(
		long dataSectionId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataSectionId(
		long dataSectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataSectionId(
		long dataSectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataSectionId_First(
			long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataSectionId_First(
		long dataSectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataSectionId_Last(
			long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataSectionId_Last(
		long dataSectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByDataSectionId_PrevAndNext(
			long dataEntryId, long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	public void removeByDataSectionId(long dataSectionId);

	/**
	 * Returns the number of data entries where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching data entries
	 */
	public int countByDataSectionId(long dataSectionId);

	/**
	 * Returns all the data entries where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByDataPackId(long dataPackId);

	/**
	 * Returns a range of all the data entries where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataPackId(
		long dataPackId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataPackId(
		long dataPackId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataPackId(
		long dataPackId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataPackId_First(
			long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataPackId_First(
		long dataPackId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataPackId_Last(
			long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataPackId_Last(
		long dataPackId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByDataPackId_PrevAndNext(
			long dataEntryId, long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	public void removeByDataPackId(long dataPackId);

	/**
	 * Returns the number of data entries where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching data entries
	 */
	public int countByDataPackId(long dataPackId);

	/**
	 * Returns all the data entries where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByCopiedFrom(long copiedFrom);

	/**
	 * Returns a range of all the data entries where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByCopiedFrom(
		long copiedFrom, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByCopiedFrom(
		long copiedFrom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByCopiedFrom(
		long copiedFrom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByCopiedFrom_First(
			long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByCopiedFrom_First(
		long copiedFrom,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByCopiedFrom_Last(
			long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByCopiedFrom_Last(
		long copiedFrom,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where copiedFrom = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByCopiedFrom_PrevAndNext(
			long dataEntryId, long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where copiedFrom = &#63; from the database.
	 *
	 * @param copiedFrom the copied from
	 */
	public void removeByCopiedFrom(long copiedFrom);

	/**
	 * Returns the number of data entries where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the number of matching data entries
	 */
	public int countByCopiedFrom(long copiedFrom);

	/**
	 * Returns all the data entries where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching data entries
	 */
	public java.util.List<DataEntry> findByDataTypeId(long dataTypeId);

	/**
	 * Returns a range of all the data entries where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataTypeId(
		long dataTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the data entries where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data entries
	 */
	public java.util.List<DataEntry> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data entry in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the first data entry in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the last data entry in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry
	 * @throws NoSuchDataEntryException if a matching data entry could not be found
	 */
	public DataEntry findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Returns the last data entry in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	public DataEntry fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns the data entries before and after the current data entry in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataEntryId the primary key of the current data entry
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry[] findByDataTypeId_PrevAndNext(
			long dataEntryId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
				orderByComparator)
		throws NoSuchDataEntryException;

	/**
	 * Removes all the data entries where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of data entries where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching data entries
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Caches the data entry in the entity cache if it is enabled.
	 *
	 * @param dataEntry the data entry
	 */
	public void cacheResult(DataEntry dataEntry);

	/**
	 * Caches the data entries in the entity cache if it is enabled.
	 *
	 * @param dataEntries the data entries
	 */
	public void cacheResult(java.util.List<DataEntry> dataEntries);

	/**
	 * Creates a new data entry with the primary key. Does not add the data entry to the database.
	 *
	 * @param dataEntryId the primary key for the new data entry
	 * @return the new data entry
	 */
	public DataEntry create(long dataEntryId);

	/**
	 * Removes the data entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry that was removed
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry remove(long dataEntryId) throws NoSuchDataEntryException;

	public DataEntry updateImpl(DataEntry dataEntry);

	/**
	 * Returns the data entry with the primary key or throws a <code>NoSuchDataEntryException</code> if it could not be found.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	public DataEntry findByPrimaryKey(long dataEntryId)
		throws NoSuchDataEntryException;

	/**
	 * Returns the data entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry, or <code>null</code> if a data entry with the primary key could not be found
	 */
	public DataEntry fetchByPrimaryKey(long dataEntryId);

	/**
	 * Returns all the data entries.
	 *
	 * @return the data entries
	 */
	public java.util.List<DataEntry> findAll();

	/**
	 * Returns a range of all the data entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of data entries
	 */
	public java.util.List<DataEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data entries
	 */
	public java.util.List<DataEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data entries
	 */
	public java.util.List<DataEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the data entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data entries.
	 *
	 * @return the number of data entries
	 */
	public int countAll();

}