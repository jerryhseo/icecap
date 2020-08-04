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
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icecap.exception.NoSuchDataSectionException;
import com.osp.icecap.model.DataSection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data section service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataSectionUtil
 * @generated
 */
@ProviderType
public interface DataSectionPersistence extends BasePersistence<DataSection> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataSectionUtil} to access the data section persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data sections where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByUuid(String uuid);

	/**
	 * Returns a range of all the data sections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByUuid_First(
			String uuid, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByUuid_First(
		String uuid, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByUuid_Last(
			String uuid, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByUuid_Last(
		String uuid, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where uuid = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByUuid_PrevAndNext(
			long dataSectionId, String uuid,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data sections where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data sections
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data section where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataSectionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByUUID_G(String uuid, long groupId)
		throws NoSuchDataSectionException;

	/**
	 * Returns the data section where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data section, or <code>null</code> if a matching data section could not be found
	 */
	@Deprecated
	public DataSection fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the data section where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the data section where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data section that was removed
	 */
	public DataSection removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataSectionException;

	/**
	 * Returns the number of data sections where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data sections
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data sections where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the data sections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByUuid_C_PrevAndNext(
			long dataSectionId, String uuid, long companyId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data sections where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data sections
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data sections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByGroupId(long groupId);

	/**
	 * Returns a range of all the data sections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupId(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByGroupId_First(
			long groupId, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByGroupId_First(
		long groupId, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByGroupId_Last(
			long groupId, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByGroupId_Last(
		long groupId, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where groupId = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByGroupId_PrevAndNext(
			long dataSectionId, long groupId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns all the data sections that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data sections that the user has permission to view
	 */
	public java.util.List<DataSection> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the data sections that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections that the user has permission to view
	 */
	public java.util.List<DataSection> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data sections that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections that the user has permission to view
	 */
	public java.util.List<DataSection> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set of data sections that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] filterFindByGroupId_PrevAndNext(
			long dataSectionId, long groupId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data sections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data sections
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of data sections that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data sections that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the data sections where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByUserId(long userId);

	/**
	 * Returns a range of all the data sections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUserId(long, int, int, OrderByComparator)}
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByUserId_First(
			long userId, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByUserId_First(
		long userId, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByUserId_Last(
			long userId, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByUserId_Last(
		long userId, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where userId = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByUserId_PrevAndNext(
			long dataSectionId, long userId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of data sections where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data sections
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the data sections where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByStatus(int status);

	/**
	 * Returns a range of all the data sections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByStatus(int, int, int, OrderByComparator)}
	 * @param status the status
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByStatus_First(
			int status, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByStatus_First(
		int status, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByStatus_Last(
			int status, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByStatus_Last(
		int status, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where status = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByStatus_PrevAndNext(
			long dataSectionId, int status,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of data sections where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data sections
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the data sections where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByDataCollectionId(
		long dataCollectionId);

	/**
	 * Returns a range of all the data sections where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByDataCollectionId(
		long dataCollectionId, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataCollectionId(long, int, int, OrderByComparator)}
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByDataCollectionId_First(
		long dataCollectionId,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByDataCollectionId_Last(
		long dataCollectionId,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByDataCollectionId_PrevAndNext(
			long dataSectionId, long dataCollectionId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public void removeByDataCollectionId(long dataCollectionId);

	/**
	 * Returns the number of data sections where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching data sections
	 */
	public int countByDataCollectionId(long dataCollectionId);

	/**
	 * Returns all the data sections where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByDataSetId(long dataSetId);

	/**
	 * Returns a range of all the data sections where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByDataSetId(
		long dataSetId, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataSetId(long, int, int, OrderByComparator)}
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByDataSetId_First(
			long dataSetId, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByDataSetId_First(
		long dataSetId, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByDataSetId_Last(
			long dataSetId, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByDataSetId_PrevAndNext(
			long dataSectionId, long dataSetId,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of data sections where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data sections
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the data sections where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByCopiedFrom(long copiedFrom);

	/**
	 * Returns a range of all the data sections where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByCopiedFrom(
		long copiedFrom, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCopiedFrom(long, int, int, OrderByComparator)}
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByCopiedFrom(
		long copiedFrom, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByCopiedFrom(
		long copiedFrom, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByCopiedFrom_First(
			long copiedFrom, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByCopiedFrom_First(
		long copiedFrom, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByCopiedFrom_Last(
			long copiedFrom, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByCopiedFrom_Last(
		long copiedFrom, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where copiedFrom = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByCopiedFrom_PrevAndNext(
			long dataSectionId, long copiedFrom,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where copiedFrom = &#63; from the database.
	 *
	 * @param copiedFrom the copied from
	 */
	public void removeByCopiedFrom(long copiedFrom);

	/**
	 * Returns the number of data sections where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the number of matching data sections
	 */
	public int countByCopiedFrom(long copiedFrom);

	/**
	 * Returns all the data sections where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching data sections
	 */
	public java.util.List<DataSection> findByName(String name);

	/**
	 * Returns a range of all the data sections where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of matching data sections
	 */
	public java.util.List<DataSection> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the data sections where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByName(String, int, int, OrderByComparator)}
	 * @param name the name
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findByName(
		String name, int start, int end,
		OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sections
	 */
	public java.util.List<DataSection> findByName(
		String name, int start, int end,
		OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the first data section in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByName_First(
			String name, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the first data section in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByName_First(
		String name, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the last data section in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section
	 * @throws NoSuchDataSectionException if a matching data section could not be found
	 */
	public DataSection findByName_Last(
			String name, OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Returns the last data section in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data section, or <code>null</code> if a matching data section could not be found
	 */
	public DataSection fetchByName_Last(
		String name, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Returns the data sections before and after the current data section in the ordered set where name = &#63;.
	 *
	 * @param dataSectionId the primary key of the current data section
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection[] findByName_PrevAndNext(
			long dataSectionId, String name,
			OrderByComparator<DataSection> orderByComparator)
		throws NoSuchDataSectionException;

	/**
	 * Removes all the data sections where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of data sections where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching data sections
	 */
	public int countByName(String name);

	/**
	 * Caches the data section in the entity cache if it is enabled.
	 *
	 * @param dataSection the data section
	 */
	public void cacheResult(DataSection dataSection);

	/**
	 * Caches the data sections in the entity cache if it is enabled.
	 *
	 * @param dataSections the data sections
	 */
	public void cacheResult(java.util.List<DataSection> dataSections);

	/**
	 * Creates a new data section with the primary key. Does not add the data section to the database.
	 *
	 * @param dataSectionId the primary key for the new data section
	 * @return the new data section
	 */
	public DataSection create(long dataSectionId);

	/**
	 * Removes the data section with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSectionId the primary key of the data section
	 * @return the data section that was removed
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection remove(long dataSectionId)
		throws NoSuchDataSectionException;

	public DataSection updateImpl(DataSection dataSection);

	/**
	 * Returns the data section with the primary key or throws a <code>NoSuchDataSectionException</code> if it could not be found.
	 *
	 * @param dataSectionId the primary key of the data section
	 * @return the data section
	 * @throws NoSuchDataSectionException if a data section with the primary key could not be found
	 */
	public DataSection findByPrimaryKey(long dataSectionId)
		throws NoSuchDataSectionException;

	/**
	 * Returns the data section with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataSectionId the primary key of the data section
	 * @return the data section, or <code>null</code> if a data section with the primary key could not be found
	 */
	public DataSection fetchByPrimaryKey(long dataSectionId);

	/**
	 * Returns all the data sections.
	 *
	 * @return the data sections
	 */
	public java.util.List<DataSection> findAll();

	/**
	 * Returns a range of all the data sections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of data sections
	 */
	public java.util.List<DataSection> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data sections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data sections
	 */
	@Deprecated
	public java.util.List<DataSection> findAll(
		int start, int end, OrderByComparator<DataSection> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data sections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data sections
	 */
	public java.util.List<DataSection> findAll(
		int start, int end, OrderByComparator<DataSection> orderByComparator);

	/**
	 * Removes all the data sections from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data sections.
	 *
	 * @return the number of data sections
	 */
	public int countAll();

}