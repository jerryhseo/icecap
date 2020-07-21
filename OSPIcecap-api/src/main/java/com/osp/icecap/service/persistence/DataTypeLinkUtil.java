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

import com.osp.icecap.model.DataTypeLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the data type link service. This utility wraps <code>com.osp.icecap.service.persistence.impl.DataTypeLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataTypeLinkPersistence
 * @generated
 */
@ProviderType
public class DataTypeLinkUtil {

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
	public static void clearCache(DataTypeLink dataTypeLink) {
		getPersistence().clearCache(dataTypeLink);
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
	public static Map<Serializable, DataTypeLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataTypeLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataTypeLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataTypeLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataTypeLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataTypeLink update(DataTypeLink dataTypeLink) {
		return getPersistence().update(dataTypeLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataTypeLink update(
		DataTypeLink dataTypeLink, ServiceContext serviceContext) {

		return getPersistence().update(dataTypeLink, serviceContext);
	}

	/**
	 * Caches the data type link in the entity cache if it is enabled.
	 *
	 * @param dataTypeLink the data type link
	 */
	public static void cacheResult(DataTypeLink dataTypeLink) {
		getPersistence().cacheResult(dataTypeLink);
	}

	/**
	 * Caches the data type links in the entity cache if it is enabled.
	 *
	 * @param dataTypeLinks the data type links
	 */
	public static void cacheResult(List<DataTypeLink> dataTypeLinks) {
		getPersistence().cacheResult(dataTypeLinks);
	}

	/**
	 * Creates a new data type link with the primary key. Does not add the data type link to the database.
	 *
	 * @param dataUuid the primary key for the new data type link
	 * @return the new data type link
	 */
	public static DataTypeLink create(String dataUuid) {
		return getPersistence().create(dataUuid);
	}

	/**
	 * Removes the data type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link that was removed
	 * @throws NoSuchDataTypeLinkException if a data type link with the primary key could not be found
	 */
	public static DataTypeLink remove(String dataUuid)
		throws com.osp.icecap.exception.NoSuchDataTypeLinkException {

		return getPersistence().remove(dataUuid);
	}

	public static DataTypeLink updateImpl(DataTypeLink dataTypeLink) {
		return getPersistence().updateImpl(dataTypeLink);
	}

	/**
	 * Returns the data type link with the primary key or throws a <code>NoSuchDataTypeLinkException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link
	 * @throws NoSuchDataTypeLinkException if a data type link with the primary key could not be found
	 */
	public static DataTypeLink findByPrimaryKey(String dataUuid)
		throws com.osp.icecap.exception.NoSuchDataTypeLinkException {

		return getPersistence().findByPrimaryKey(dataUuid);
	}

	/**
	 * Returns the data type link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link, or <code>null</code> if a data type link with the primary key could not be found
	 */
	public static DataTypeLink fetchByPrimaryKey(String dataUuid) {
		return getPersistence().fetchByPrimaryKey(dataUuid);
	}

	/**
	 * Returns all the data type links.
	 *
	 * @return the data type links
	 */
	public static List<DataTypeLink> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DataTypeLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DataTypeLink> findAll(
		int start, int end, OrderByComparator<DataTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

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
	public static List<DataTypeLink> findAll(
		int start, int end, OrderByComparator<DataTypeLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the data type links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data type links.
	 *
	 * @return the number of data type links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataTypeLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DataTypeLinkPersistence, DataTypeLinkPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataTypeLinkPersistence.class);

		ServiceTracker<DataTypeLinkPersistence, DataTypeLinkPersistence>
			serviceTracker =
				new ServiceTracker
					<DataTypeLinkPersistence, DataTypeLinkPersistence>(
						bundle.getBundleContext(),
						DataTypeLinkPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}