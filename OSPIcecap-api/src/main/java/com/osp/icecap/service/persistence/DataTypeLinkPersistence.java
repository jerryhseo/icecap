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

import com.osp.icecap.exception.NoSuchDataTypeLinkException;
import com.osp.icecap.model.DataTypeLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data type link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeLinkUtil
 * @generated
 */
@ProviderType
public interface DataTypeLinkPersistence extends BasePersistence<DataTypeLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataTypeLinkUtil} to access the data type link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the data type link in the entity cache if it is enabled.
	 *
	 * @param dataTypeLink the data type link
	 */
	public void cacheResult(DataTypeLink dataTypeLink);

	/**
	 * Caches the data type links in the entity cache if it is enabled.
	 *
	 * @param dataTypeLinks the data type links
	 */
	public void cacheResult(java.util.List<DataTypeLink> dataTypeLinks);

	/**
	 * Creates a new data type link with the primary key. Does not add the data type link to the database.
	 *
	 * @param dataUuid the primary key for the new data type link
	 * @return the new data type link
	 */
	public DataTypeLink create(String dataUuid);

	/**
	 * Removes the data type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link that was removed
	 * @throws NoSuchDataTypeLinkException if a data type link with the primary key could not be found
	 */
	public DataTypeLink remove(String dataUuid)
		throws NoSuchDataTypeLinkException;

	public DataTypeLink updateImpl(DataTypeLink dataTypeLink);

	/**
	 * Returns the data type link with the primary key or throws a <code>NoSuchDataTypeLinkException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link
	 * @throws NoSuchDataTypeLinkException if a data type link with the primary key could not be found
	 */
	public DataTypeLink findByPrimaryKey(String dataUuid)
		throws NoSuchDataTypeLinkException;

	/**
	 * Returns the data type link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link, or <code>null</code> if a data type link with the primary key could not be found
	 */
	public DataTypeLink fetchByPrimaryKey(String dataUuid);

	/**
	 * Returns all the data type links.
	 *
	 * @return the data type links
	 */
	public java.util.List<DataTypeLink> findAll();

	/**
	 * Returns a range of all the data type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type links
	 * @param end the upper bound of the range of data type links (not inclusive)
	 * @return the range of data type links
	 */
	public java.util.List<DataTypeLink> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of data type links
	 * @param end the upper bound of the range of data type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data type links
	 */
	@Deprecated
	public java.util.List<DataTypeLink> findAll(
		int start, int end, OrderByComparator<DataTypeLink> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type links
	 * @param end the upper bound of the range of data type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data type links
	 */
	public java.util.List<DataTypeLink> findAll(
		int start, int end, OrderByComparator<DataTypeLink> orderByComparator);

	/**
	 * Removes all the data type links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data type links.
	 *
	 * @return the number of data type links
	 */
	public int countAll();

}