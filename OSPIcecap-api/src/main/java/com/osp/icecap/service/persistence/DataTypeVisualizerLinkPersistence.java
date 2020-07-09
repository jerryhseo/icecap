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

import com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException;
import com.osp.icecap.model.DataTypeVisualizerLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data type visualizer link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeVisualizerLinkUtil
 * @generated
 */
@ProviderType
public interface DataTypeVisualizerLinkPersistence
	extends BasePersistence<DataTypeVisualizerLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataTypeVisualizerLinkUtil} to access the data type visualizer link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data type visualizer links where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @return the matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByVisualizer(
		String visualizerName);

	/**
	 * Returns a range of all the data type visualizer links where visualizerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param visualizerName the visualizer name
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByVisualizer(
		String visualizerName, int start, int end);

	/**
	 * Returns an ordered range of all the data type visualizer links where visualizerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param visualizerName the visualizer name
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByVisualizer(
		String visualizerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data type visualizer links where visualizerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param visualizerName the visualizer name
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByVisualizer(
		String visualizerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink findByVisualizer_First(
			String visualizerName,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the first data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink fetchByVisualizer_First(
		String visualizerName,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the last data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink findByVisualizer_Last(
			String visualizerName,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the last data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink fetchByVisualizer_Last(
		String visualizerName,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the data type visualizer links before and after the current data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the current data type visualizer link
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public DataTypeVisualizerLink[] findByVisualizer_PrevAndNext(
			long dataTypeVisualizerLinkId, String visualizerName,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Removes all the data type visualizer links where visualizerName = &#63; from the database.
	 *
	 * @param visualizerName the visualizer name
	 */
	public void removeByVisualizer(String visualizerName);

	/**
	 * Returns the number of data type visualizer links where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @return the number of matching data type visualizer links
	 */
	public int countByVisualizer(String visualizerName);

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or throws a <code>NoSuchDataTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink findByVisualizerVersion(
			String visualizerName, String visualizerVersion)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink fetchByVisualizerVersion(
		String visualizerName, String visualizerVersion);

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink fetchByVisualizerVersion(
		String visualizerName, String visualizerVersion,
		boolean retrieveFromCache);

	/**
	 * Removes the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; from the database.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the data type visualizer link that was removed
	 */
	public DataTypeVisualizerLink removeByVisualizerVersion(
			String visualizerName, String visualizerVersion)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the number of data type visualizer links where visualizerName = &#63; and visualizerVersion = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the number of matching data type visualizer links
	 */
	public int countByVisualizerVersion(
		String visualizerName, String visualizerVersion);

	/**
	 * Returns all the data type visualizer links where editable = &#63;.
	 *
	 * @param editable the editable
	 * @return the matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByEditable(
		boolean editable);

	/**
	 * Returns a range of all the data type visualizer links where editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end);

	/**
	 * Returns an ordered range of all the data type visualizer links where editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data type visualizer links where editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink findByEditable_First(
			boolean editable,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the first data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink fetchByEditable_First(
		boolean editable,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the last data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink findByEditable_Last(
			boolean editable,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the last data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink fetchByEditable_Last(
		boolean editable,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the data type visualizer links before and after the current data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the current data type visualizer link
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public DataTypeVisualizerLink[] findByEditable_PrevAndNext(
			long dataTypeVisualizerLinkId, boolean editable,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Removes all the data type visualizer links where editable = &#63; from the database.
	 *
	 * @param editable the editable
	 */
	public void removeByEditable(boolean editable);

	/**
	 * Returns the number of data type visualizer links where editable = &#63;.
	 *
	 * @param editable the editable
	 * @return the number of matching data type visualizer links
	 */
	public int countByEditable(boolean editable);

	/**
	 * Returns all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId);

	/**
	 * Returns a range of all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the first data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the last data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the last data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public DataTypeVisualizerLink fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the data type visualizer links before and after the current data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the current data type visualizer link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public DataTypeVisualizerLink[] findByDataTypeId_PrevAndNext(
			long dataTypeVisualizerLinkId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Removes all the data type visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of data type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching data type visualizer links
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Caches the data type visualizer link in the entity cache if it is enabled.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 */
	public void cacheResult(DataTypeVisualizerLink dataTypeVisualizerLink);

	/**
	 * Caches the data type visualizer links in the entity cache if it is enabled.
	 *
	 * @param dataTypeVisualizerLinks the data type visualizer links
	 */
	public void cacheResult(
		java.util.List<DataTypeVisualizerLink> dataTypeVisualizerLinks);

	/**
	 * Creates a new data type visualizer link with the primary key. Does not add the data type visualizer link to the database.
	 *
	 * @param dataTypeVisualizerLinkId the primary key for the new data type visualizer link
	 * @return the new data type visualizer link
	 */
	public DataTypeVisualizerLink create(long dataTypeVisualizerLinkId);

	/**
	 * Removes the data type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link that was removed
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public DataTypeVisualizerLink remove(long dataTypeVisualizerLinkId)
		throws NoSuchDataTypeVisualizerLinkException;

	public DataTypeVisualizerLink updateImpl(
		DataTypeVisualizerLink dataTypeVisualizerLink);

	/**
	 * Returns the data type visualizer link with the primary key or throws a <code>NoSuchDataTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public DataTypeVisualizerLink findByPrimaryKey(
			long dataTypeVisualizerLinkId)
		throws NoSuchDataTypeVisualizerLinkException;

	/**
	 * Returns the data type visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link, or <code>null</code> if a data type visualizer link with the primary key could not be found
	 */
	public DataTypeVisualizerLink fetchByPrimaryKey(
		long dataTypeVisualizerLinkId);

	/**
	 * Returns all the data type visualizer links.
	 *
	 * @return the data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findAll();

	/**
	 * Returns a range of all the data type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data type visualizer links
	 */
	public java.util.List<DataTypeVisualizerLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeVisualizerLink>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the data type visualizer links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data type visualizer links.
	 *
	 * @return the number of data type visualizer links
	 */
	public int countAll();

}