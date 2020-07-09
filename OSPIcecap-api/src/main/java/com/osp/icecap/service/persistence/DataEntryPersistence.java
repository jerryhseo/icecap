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