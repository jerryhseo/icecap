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

import com.osp.icecap.exception.NoSuchDataSetException;
import com.osp.icecap.model.DataSet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataSetUtil
 * @generated
 */
@ProviderType
public interface DataSetPersistence extends BasePersistence<DataSet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataSetUtil} to access the data set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data sets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data sets
	 */
	public java.util.List<DataSet> findByUuid(String uuid);

	/**
	 * Returns a range of all the data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public java.util.List<DataSet> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the first data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the last data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the last data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set where uuid = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] findByUuid_PrevAndNext(
			long dataSetId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Removes all the data sets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data sets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data sets
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data set where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataSetException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByUUID_G(String uuid, long groupId)
		throws NoSuchDataSetException;

	/**
	 * Returns the data set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the data set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the data set where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data set that was removed
	 */
	public DataSet removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataSetException;

	/**
	 * Returns the number of data sets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data sets
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data sets
	 */
	public java.util.List<DataSet> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public java.util.List<DataSet> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the first data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the last data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the last data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] findByUuid_C_PrevAndNext(
			long dataSetId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Removes all the data sets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data sets
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data sets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data sets
	 */
	public java.util.List<DataSet> findByGroupId(long groupId);

	/**
	 * Returns a range of all the data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public java.util.List<DataSet> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the first data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the last data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the last data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set where groupId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] findByGroupId_PrevAndNext(
			long dataSetId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns all the data sets that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data sets that the user has permission to view
	 */
	public java.util.List<DataSet> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the data sets that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets that the user has permission to view
	 */
	public java.util.List<DataSet> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data sets that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets that the user has permission to view
	 */
	public java.util.List<DataSet> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set of data sets that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] filterFindByGroupId_PrevAndNext(
			long dataSetId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Removes all the data sets where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data sets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data sets
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of data sets that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data sets that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the data sets where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data sets
	 */
	public java.util.List<DataSet> findByUserId(long groupId, long userId);

	/**
	 * Returns a range of all the data sets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public java.util.List<DataSet> findByUserId(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByUserId_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the first data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByUserId_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the last data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByUserId_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the last data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByUserId_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] findByUserId_PrevAndNext(
			long dataSetId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns all the data sets that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data sets that the user has permission to view
	 */
	public java.util.List<DataSet> filterFindByUserId(
		long groupId, long userId);

	/**
	 * Returns a range of all the data sets that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets that the user has permission to view
	 */
	public java.util.List<DataSet> filterFindByUserId(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the data sets that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets that the user has permission to view
	 */
	public java.util.List<DataSet> filterFindByUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set of data sets that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] filterFindByUserId_PrevAndNext(
			long dataSetId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Removes all the data sets where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByUserId(long groupId, long userId);

	/**
	 * Returns the number of data sets where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data sets
	 */
	public int countByUserId(long groupId, long userId);

	/**
	 * Returns the number of data sets that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data sets that the user has permission to view
	 */
	public int filterCountByUserId(long groupId, long userId);

	/**
	 * Returns all the data sets where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data sets
	 */
	public java.util.List<DataSet> findByStatus(int status);

	/**
	 * Returns a range of all the data sets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public java.util.List<DataSet> findByStatus(int status, int start, int end);

	/**
	 * Returns an ordered range of all the data sets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data set in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the first data set in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the last data set in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the last data set in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set where status = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] findByStatus_PrevAndNext(
			long dataSetId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Removes all the data sets where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of data sets where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data sets
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the data sets where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching data sets
	 */
	public java.util.List<DataSet> findByDataCollectionId(
		long dataCollectionId);

	/**
	 * Returns a range of all the data sets where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public java.util.List<DataSet> findByDataCollectionId(
		long dataCollectionId, int start, int end);

	/**
	 * Returns an ordered range of all the data sets where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data set in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByDataCollectionId_First(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the first data set in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByDataCollectionId_First(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the last data set in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByDataCollectionId_Last(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the last data set in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByDataCollectionId_Last(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] findByDataCollectionId_PrevAndNext(
			long dataSetId, long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Removes all the data sets where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public void removeByDataCollectionId(long dataCollectionId);

	/**
	 * Returns the number of data sets where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching data sets
	 */
	public int countByDataCollectionId(long dataCollectionId);

	/**
	 * Returns all the data sets where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the matching data sets
	 */
	public java.util.List<DataSet> findByCopiedFrom(long copiedFrom);

	/**
	 * Returns a range of all the data sets where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public java.util.List<DataSet> findByCopiedFrom(
		long copiedFrom, int start, int end);

	/**
	 * Returns an ordered range of all the data sets where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByCopiedFrom(
		long copiedFrom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets where copiedFrom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param copiedFrom the copied from
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByCopiedFrom(
		long copiedFrom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data set in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByCopiedFrom_First(
			long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the first data set in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByCopiedFrom_First(
		long copiedFrom,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the last data set in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByCopiedFrom_Last(
			long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the last data set in the ordered set where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByCopiedFrom_Last(
		long copiedFrom,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set where copiedFrom = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param copiedFrom the copied from
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] findByCopiedFrom_PrevAndNext(
			long dataSetId, long copiedFrom,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Removes all the data sets where copiedFrom = &#63; from the database.
	 *
	 * @param copiedFrom the copied from
	 */
	public void removeByCopiedFrom(long copiedFrom);

	/**
	 * Returns the number of data sets where copiedFrom = &#63;.
	 *
	 * @param copiedFrom the copied from
	 * @return the number of matching data sets
	 */
	public int countByCopiedFrom(long copiedFrom);

	/**
	 * Returns all the data sets where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching data sets
	 */
	public java.util.List<DataSet> findByName(String name);

	/**
	 * Returns a range of all the data sets where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public java.util.List<DataSet> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the data sets where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public java.util.List<DataSet> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data set in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the first data set in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the last data set in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public DataSet findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Returns the last data set in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public DataSet fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns the data sets before and after the current data set in the ordered set where name = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet[] findByName_PrevAndNext(
			long dataSetId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<DataSet>
				orderByComparator)
		throws NoSuchDataSetException;

	/**
	 * Removes all the data sets where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of data sets where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching data sets
	 */
	public int countByName(String name);

	/**
	 * Caches the data set in the entity cache if it is enabled.
	 *
	 * @param dataSet the data set
	 */
	public void cacheResult(DataSet dataSet);

	/**
	 * Caches the data sets in the entity cache if it is enabled.
	 *
	 * @param dataSets the data sets
	 */
	public void cacheResult(java.util.List<DataSet> dataSets);

	/**
	 * Creates a new data set with the primary key. Does not add the data set to the database.
	 *
	 * @param dataSetId the primary key for the new data set
	 * @return the new data set
	 */
	public DataSet create(long dataSetId);

	/**
	 * Removes the data set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set that was removed
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet remove(long dataSetId) throws NoSuchDataSetException;

	public DataSet updateImpl(DataSet dataSet);

	/**
	 * Returns the data set with the primary key or throws a <code>NoSuchDataSetException</code> if it could not be found.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public DataSet findByPrimaryKey(long dataSetId)
		throws NoSuchDataSetException;

	/**
	 * Returns the data set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set, or <code>null</code> if a data set with the primary key could not be found
	 */
	public DataSet fetchByPrimaryKey(long dataSetId);

	/**
	 * Returns all the data sets.
	 *
	 * @return the data sets
	 */
	public java.util.List<DataSet> findAll();

	/**
	 * Returns a range of all the data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of data sets
	 */
	public java.util.List<DataSet> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data sets
	 */
	public java.util.List<DataSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data sets
	 */
	public java.util.List<DataSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data sets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data sets.
	 *
	 * @return the number of data sets
	 */
	public int countAll();

}