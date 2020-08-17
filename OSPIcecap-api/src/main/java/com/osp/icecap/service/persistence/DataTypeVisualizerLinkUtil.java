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

import com.osp.icecap.model.DataTypeVisualizerLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the data type visualizer link service. This utility wraps <code>com.osp.icecap.service.persistence.impl.DataTypeVisualizerLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeVisualizerLinkPersistence
 * @generated
 */
@ProviderType
public class DataTypeVisualizerLinkUtil {

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
	public static void clearCache(
		DataTypeVisualizerLink dataTypeVisualizerLink) {

		getPersistence().clearCache(dataTypeVisualizerLink);
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
	public static Map<Serializable, DataTypeVisualizerLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataTypeVisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataTypeVisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataTypeVisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataTypeVisualizerLink update(
		DataTypeVisualizerLink dataTypeVisualizerLink) {

		return getPersistence().update(dataTypeVisualizerLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataTypeVisualizerLink update(
		DataTypeVisualizerLink dataTypeVisualizerLink,
		ServiceContext serviceContext) {

		return getPersistence().update(dataTypeVisualizerLink, serviceContext);
	}

	/**
	 * Returns all the data type visualizer links where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @return the matching data type visualizer links
	 */
	public static List<DataTypeVisualizerLink> findByVisualizerName(
		String visualizerName) {

		return getPersistence().findByVisualizerName(visualizerName);
	}

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
	public static List<DataTypeVisualizerLink> findByVisualizerName(
		String visualizerName, int start, int end) {

		return getPersistence().findByVisualizerName(
			visualizerName, start, end);
	}

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
	public static List<DataTypeVisualizerLink> findByVisualizerName(
		String visualizerName, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().findByVisualizerName(
			visualizerName, start, end, orderByComparator);
	}

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
	public static List<DataTypeVisualizerLink> findByVisualizerName(
		String visualizerName, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByVisualizerName(
			visualizerName, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink findByVisualizerName_First(
			String visualizerName,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByVisualizerName_First(
			visualizerName, orderByComparator);
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink fetchByVisualizerName_First(
		String visualizerName,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByVisualizerName_First(
			visualizerName, orderByComparator);
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink findByVisualizerName_Last(
			String visualizerName,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByVisualizerName_Last(
			visualizerName, orderByComparator);
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink fetchByVisualizerName_Last(
		String visualizerName,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByVisualizerName_Last(
			visualizerName, orderByComparator);
	}

	/**
	 * Returns the data type visualizer links before and after the current data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the current data type visualizer link
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public static DataTypeVisualizerLink[] findByVisualizerName_PrevAndNext(
			long dataTypeVisualizerLinkId, String visualizerName,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByVisualizerName_PrevAndNext(
			dataTypeVisualizerLinkId, visualizerName, orderByComparator);
	}

	/**
	 * Removes all the data type visualizer links where visualizerName = &#63; from the database.
	 *
	 * @param visualizerName the visualizer name
	 */
	public static void removeByVisualizerName(String visualizerName) {
		getPersistence().removeByVisualizerName(visualizerName);
	}

	/**
	 * Returns the number of data type visualizer links where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @return the number of matching data type visualizer links
	 */
	public static int countByVisualizerName(String visualizerName) {
		return getPersistence().countByVisualizerName(visualizerName);
	}

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or throws a <code>NoSuchDataTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink findByVisualizerNameVersion(
			String visualizerName, String visualizerVersion)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByVisualizerNameVersion(
			visualizerName, visualizerVersion);
	}

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink fetchByVisualizerNameVersion(
		String visualizerName, String visualizerVersion) {

		return getPersistence().fetchByVisualizerNameVersion(
			visualizerName, visualizerVersion);
	}

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink fetchByVisualizerNameVersion(
		String visualizerName, String visualizerVersion,
		boolean retrieveFromCache) {

		return getPersistence().fetchByVisualizerNameVersion(
			visualizerName, visualizerVersion, retrieveFromCache);
	}

	/**
	 * Removes the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; from the database.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the data type visualizer link that was removed
	 */
	public static DataTypeVisualizerLink removeByVisualizerNameVersion(
			String visualizerName, String visualizerVersion)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().removeByVisualizerNameVersion(
			visualizerName, visualizerVersion);
	}

	/**
	 * Returns the number of data type visualizer links where visualizerName = &#63; and visualizerVersion = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the number of matching data type visualizer links
	 */
	public static int countByVisualizerNameVersion(
		String visualizerName, String visualizerVersion) {

		return getPersistence().countByVisualizerNameVersion(
			visualizerName, visualizerVersion);
	}

	/**
	 * Returns all the data type visualizer links where editable = &#63;.
	 *
	 * @param editable the editable
	 * @return the matching data type visualizer links
	 */
	public static List<DataTypeVisualizerLink> findByEditable(
		boolean editable) {

		return getPersistence().findByEditable(editable);
	}

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
	public static List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end) {

		return getPersistence().findByEditable(editable, start, end);
	}

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
	public static List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().findByEditable(
			editable, start, end, orderByComparator);
	}

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
	public static List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByEditable(
			editable, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink findByEditable_First(
			boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByEditable_First(
			editable, orderByComparator);
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink fetchByEditable_First(
		boolean editable,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByEditable_First(
			editable, orderByComparator);
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink findByEditable_Last(
			boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByEditable_Last(
			editable, orderByComparator);
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink fetchByEditable_Last(
		boolean editable,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByEditable_Last(
			editable, orderByComparator);
	}

	/**
	 * Returns the data type visualizer links before and after the current data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the current data type visualizer link
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public static DataTypeVisualizerLink[] findByEditable_PrevAndNext(
			long dataTypeVisualizerLinkId, boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByEditable_PrevAndNext(
			dataTypeVisualizerLinkId, editable, orderByComparator);
	}

	/**
	 * Removes all the data type visualizer links where editable = &#63; from the database.
	 *
	 * @param editable the editable
	 */
	public static void removeByEditable(boolean editable) {
		getPersistence().removeByEditable(editable);
	}

	/**
	 * Returns the number of data type visualizer links where editable = &#63;.
	 *
	 * @param editable the editable
	 * @return the number of matching data type visualizer links
	 */
	public static int countByEditable(boolean editable) {
		return getPersistence().countByEditable(editable);
	}

	/**
	 * Returns all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching data type visualizer links
	 */
	public static List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId) {

		return getPersistence().findByDataTypeId(dataTypeId);
	}

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
	public static List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId(dataTypeId, start, end);
	}

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
	public static List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator);
	}

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
	public static List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink fetchByDataTypeId_First(
		long dataTypeId,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	public static DataTypeVisualizerLink fetchByDataTypeId_Last(
		long dataTypeId,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the data type visualizer links before and after the current data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the current data type visualizer link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public static DataTypeVisualizerLink[] findByDataTypeId_PrevAndNext(
			long dataTypeVisualizerLinkId, long dataTypeId,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByDataTypeId_PrevAndNext(
			dataTypeVisualizerLinkId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the data type visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId(long dataTypeId) {
		getPersistence().removeByDataTypeId(dataTypeId);
	}

	/**
	 * Returns the number of data type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching data type visualizer links
	 */
	public static int countByDataTypeId(long dataTypeId) {
		return getPersistence().countByDataTypeId(dataTypeId);
	}

	/**
	 * Caches the data type visualizer link in the entity cache if it is enabled.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 */
	public static void cacheResult(
		DataTypeVisualizerLink dataTypeVisualizerLink) {

		getPersistence().cacheResult(dataTypeVisualizerLink);
	}

	/**
	 * Caches the data type visualizer links in the entity cache if it is enabled.
	 *
	 * @param dataTypeVisualizerLinks the data type visualizer links
	 */
	public static void cacheResult(
		List<DataTypeVisualizerLink> dataTypeVisualizerLinks) {

		getPersistence().cacheResult(dataTypeVisualizerLinks);
	}

	/**
	 * Creates a new data type visualizer link with the primary key. Does not add the data type visualizer link to the database.
	 *
	 * @param dataTypeVisualizerLinkId the primary key for the new data type visualizer link
	 * @return the new data type visualizer link
	 */
	public static DataTypeVisualizerLink create(long dataTypeVisualizerLinkId) {
		return getPersistence().create(dataTypeVisualizerLinkId);
	}

	/**
	 * Removes the data type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link that was removed
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public static DataTypeVisualizerLink remove(long dataTypeVisualizerLinkId)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().remove(dataTypeVisualizerLinkId);
	}

	public static DataTypeVisualizerLink updateImpl(
		DataTypeVisualizerLink dataTypeVisualizerLink) {

		return getPersistence().updateImpl(dataTypeVisualizerLink);
	}

	/**
	 * Returns the data type visualizer link with the primary key or throws a <code>NoSuchDataTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	public static DataTypeVisualizerLink findByPrimaryKey(
			long dataTypeVisualizerLinkId)
		throws com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException {

		return getPersistence().findByPrimaryKey(dataTypeVisualizerLinkId);
	}

	/**
	 * Returns the data type visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link, or <code>null</code> if a data type visualizer link with the primary key could not be found
	 */
	public static DataTypeVisualizerLink fetchByPrimaryKey(
		long dataTypeVisualizerLinkId) {

		return getPersistence().fetchByPrimaryKey(dataTypeVisualizerLinkId);
	}

	/**
	 * Returns all the data type visualizer links.
	 *
	 * @return the data type visualizer links
	 */
	public static List<DataTypeVisualizerLink> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DataTypeVisualizerLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DataTypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DataTypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the data type visualizer links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data type visualizer links.
	 *
	 * @return the number of data type visualizer links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataTypeVisualizerLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataTypeVisualizerLinkPersistence, DataTypeVisualizerLinkPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DataTypeVisualizerLinkPersistence.class);

		ServiceTracker
			<DataTypeVisualizerLinkPersistence,
			 DataTypeVisualizerLinkPersistence> serviceTracker =
				new ServiceTracker
					<DataTypeVisualizerLinkPersistence,
					 DataTypeVisualizerLinkPersistence>(
						 bundle.getBundleContext(),
						 DataTypeVisualizerLinkPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}