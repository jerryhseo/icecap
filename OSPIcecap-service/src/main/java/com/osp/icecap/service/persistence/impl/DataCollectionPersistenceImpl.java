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

package com.osp.icecap.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.osp.icecap.exception.NoSuchDataCollectionException;
import com.osp.icecap.model.DataCollection;
import com.osp.icecap.model.impl.DataCollectionImpl;
import com.osp.icecap.model.impl.DataCollectionModelImpl;
import com.osp.icecap.service.persistence.DataCollectionPersistence;
import com.osp.icecap.service.persistence.impl.constants.ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the data collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = DataCollectionPersistence.class)
@ProviderType
public class DataCollectionPersistenceImpl
	extends BasePersistenceImpl<DataCollection>
	implements DataCollectionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataCollectionUtil</code> to access the data collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataCollectionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the data collections where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if (!uuid.equals(dataCollection.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByUuid_First(
			String uuid, OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByUuid_First(
			uuid, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByUuid_First(
		String uuid, OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByUuid_Last(
			String uuid, OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByUuid_Last(
			uuid, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByUuid_Last(
		String uuid, OrderByComparator<DataCollection> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where uuid = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findByUuid_PrevAndNext(
			long dataCollectionId, String uuid,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		uuid = Objects.toString(uuid, "");

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dataCollection, uuid, orderByComparator, true);

			array[1] = dataCollection;

			array[2] = getByUuid_PrevAndNext(
				session, dataCollection, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getByUuid_PrevAndNext(
		Session session, DataCollection dataCollection, String uuid,
		OrderByComparator<DataCollection> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DataCollection dataCollection :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data collections
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"dataCollection.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dataCollection.uuid IS NULL OR dataCollection.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the data collection where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataCollectionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByUUID_G(String uuid, long groupId)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByUUID_G(uuid, groupId);

		if (dataCollection == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDataCollectionException(msg.toString());
		}

		return dataCollection;
	}

	/**
	 * Returns the data collection where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the data collection where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof DataCollection) {
			DataCollection dataCollection = (DataCollection)result;

			if (!Objects.equals(uuid, dataCollection.getUuid()) ||
				(groupId != dataCollection.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<DataCollection> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					DataCollection dataCollection = list.get(0);

					result = dataCollection;

					cacheResult(dataCollection);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DataCollection)result;
		}
	}

	/**
	 * Removes the data collection where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data collection that was removed
	 */
	@Override
	public DataCollection removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByUUID_G(uuid, groupId);

		return remove(dataCollection);
	}

	/**
	 * Returns the number of data collections where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data collections
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"dataCollection.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dataCollection.uuid IS NULL OR dataCollection.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dataCollection.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if (!uuid.equals(dataCollection.getUuid()) ||
						(companyId != dataCollection.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataCollection> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findByUuid_C_PrevAndNext(
			long dataCollectionId, String uuid, long companyId,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		uuid = Objects.toString(uuid, "");

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dataCollection, uuid, companyId, orderByComparator,
				true);

			array[1] = dataCollection;

			array[2] = getByUuid_C_PrevAndNext(
				session, dataCollection, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getByUuid_C_PrevAndNext(
		Session session, DataCollection dataCollection, String uuid,
		long companyId, OrderByComparator<DataCollection> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DataCollection dataCollection :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data collections
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"dataCollection.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dataCollection.uuid IS NULL OR dataCollection.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dataCollection.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the data collections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupId;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((groupId != dataCollection.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByGroupId_First(
			long groupId, OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByGroupId_First(
			groupId, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByGroupId_First(
		long groupId, OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByGroupId_Last(
			long groupId, OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByGroupId_Last(
		long groupId, OrderByComparator<DataCollection> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where groupId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findByGroupId_PrevAndNext(
			long dataCollectionId, long groupId,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, dataCollection, groupId, orderByComparator, true);

			array[1] = dataCollection;

			array[2] = getByGroupId_PrevAndNext(
				session, dataCollection, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getByGroupId_PrevAndNext(
		Session session, DataCollection dataCollection, long groupId,
		OrderByComparator<DataCollection> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (DataCollection dataCollection :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data collections
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"dataCollection.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the data collections where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUserId;
			finderArgs = new Object[] {userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((userId != dataCollection.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByUserId_First(
			long userId, OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByUserId_First(
			userId, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByUserId_First(
		long userId, OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByUserId_Last(
			long userId, OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByUserId_Last(
			userId, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByUserId_Last(
		long userId, OrderByComparator<DataCollection> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where userId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findByUserId_PrevAndNext(
			long dataCollectionId, long userId,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, dataCollection, userId, orderByComparator, true);

			array[1] = dataCollection;

			array[2] = getByUserId_PrevAndNext(
				session, dataCollection, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getByUserId_PrevAndNext(
		Session session, DataCollection dataCollection, long userId,
		OrderByComparator<DataCollection> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (DataCollection dataCollection :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data collections
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"dataCollection.userId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the data collections where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStatus;
			finderArgs = new Object[] {status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((status != dataCollection.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByStatus_First(
			int status, OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByStatus_First(
			status, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByStatus_First(
		int status, OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByStatus_Last(
			int status, OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByStatus_Last(
			status, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByStatus_Last(
		int status, OrderByComparator<DataCollection> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findByStatus_PrevAndNext(
			long dataCollectionId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, dataCollection, status, orderByComparator, true);

			array[1] = dataCollection;

			array[2] = getByStatus_PrevAndNext(
				session, dataCollection, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getByStatus_PrevAndNext(
		Session session, DataCollection dataCollection, int status,
		OrderByComparator<DataCollection> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (DataCollection dataCollection :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data collections
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"dataCollection.status = ?";

	private FinderPath _finderPathWithPaginationFindBy_G_U;
	private FinderPath _finderPathWithoutPaginationFindBy_G_U;
	private FinderPath _finderPathCountBy_G_U;

	/**
	 * Returns all the data collections where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_U(long groupId, long userId) {
		return findBy_G_U(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_U(
		long groupId, long userId, int start, int end) {

		return findBy_G_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findBy_G_U(groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBy_G_U;
			finderArgs = new Object[] {groupId, userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindBy_G_U;
			finderArgs = new Object[] {
				groupId, userId, start, end, orderByComparator
			};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((groupId != dataCollection.getGroupId()) ||
						(userId != dataCollection.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN__G_U_GROUPID_2);

			query.append(_FINDER_COLUMN__G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findBy_G_U_First(
			long groupId, long userId,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchBy_G_U_First(
			groupId, userId, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchBy_G_U_First(
		long groupId, long userId,
		OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findBy_G_U(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findBy_G_U_Last(
			long groupId, long userId,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchBy_G_U_Last(
			groupId, userId, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchBy_G_U_Last(
		long groupId, long userId,
		OrderByComparator<DataCollection> orderByComparator) {

		int count = countBy_G_U(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findBy_G_U(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findBy_G_U_PrevAndNext(
			long dataCollectionId, long groupId, long userId,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getBy_G_U_PrevAndNext(
				session, dataCollection, groupId, userId, orderByComparator,
				true);

			array[1] = dataCollection;

			array[2] = getBy_G_U_PrevAndNext(
				session, dataCollection, groupId, userId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getBy_G_U_PrevAndNext(
		Session session, DataCollection dataCollection, long groupId,
		long userId, OrderByComparator<DataCollection> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN__G_U_GROUPID_2);

		query.append(_FINDER_COLUMN__G_U_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeBy_G_U(long groupId, long userId) {
		for (DataCollection dataCollection :
				findBy_G_U(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data collections
	 */
	@Override
	public int countBy_G_U(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountBy_G_U;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN__G_U_GROUPID_2);

			query.append(_FINDER_COLUMN__G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN__G_U_GROUPID_2 =
		"dataCollection.groupId = ? AND ";

	private static final String _FINDER_COLUMN__G_U_USERID_2 =
		"dataCollection.userId = ?";

	private FinderPath _finderPathWithPaginationFindBy_G_S;
	private FinderPath _finderPathWithoutPaginationFindBy_G_S;
	private FinderPath _finderPathCountBy_G_S;

	/**
	 * Returns all the data collections where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_S(long groupId, int status) {
		return findBy_G_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_S(
		long groupId, int status, int start, int end) {

		return findBy_G_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findBy_G_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBy_G_S;
			finderArgs = new Object[] {groupId, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindBy_G_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((groupId != dataCollection.getGroupId()) ||
						(status != dataCollection.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN__G_S_GROUPID_2);

			query.append(_FINDER_COLUMN__G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findBy_G_S_First(
			long groupId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchBy_G_S_First(
			groupId, status, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchBy_G_S_First(
		long groupId, int status,
		OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findBy_G_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findBy_G_S_Last(
			long groupId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchBy_G_S_Last(
			groupId, status, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchBy_G_S_Last(
		long groupId, int status,
		OrderByComparator<DataCollection> orderByComparator) {

		int count = countBy_G_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findBy_G_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findBy_G_S_PrevAndNext(
			long dataCollectionId, long groupId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getBy_G_S_PrevAndNext(
				session, dataCollection, groupId, status, orderByComparator,
				true);

			array[1] = dataCollection;

			array[2] = getBy_G_S_PrevAndNext(
				session, dataCollection, groupId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getBy_G_S_PrevAndNext(
		Session session, DataCollection dataCollection, long groupId,
		int status, OrderByComparator<DataCollection> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN__G_S_GROUPID_2);

		query.append(_FINDER_COLUMN__G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeBy_G_S(long groupId, int status) {
		for (DataCollection dataCollection :
				findBy_G_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data collections
	 */
	@Override
	public int countBy_G_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountBy_G_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN__G_S_GROUPID_2);

			query.append(_FINDER_COLUMN__G_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN__G_S_GROUPID_2 =
		"dataCollection.groupId = ? AND ";

	private static final String _FINDER_COLUMN__G_S_STATUS_2 =
		"dataCollection.status = ?";

	private FinderPath _finderPathWithPaginationFindBy_U_S;
	private FinderPath _finderPathWithoutPaginationFindBy_U_S;
	private FinderPath _finderPathCountBy_U_S;

	/**
	 * Returns all the data collections where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findBy_U_S(long userId, int status) {
		return findBy_U_S(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_U_S(
		long userId, int status, int start, int end) {

		return findBy_U_S(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_U_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findBy_U_S(userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_U_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBy_U_S;
			finderArgs = new Object[] {userId, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindBy_U_S;
			finderArgs = new Object[] {
				userId, status, start, end, orderByComparator
			};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((userId != dataCollection.getUserId()) ||
						(status != dataCollection.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN__U_S_USERID_2);

			query.append(_FINDER_COLUMN__U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findBy_U_S_First(
			long userId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchBy_U_S_First(
			userId, status, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchBy_U_S_First(
		long userId, int status,
		OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findBy_U_S(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findBy_U_S_Last(
			long userId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchBy_U_S_Last(
			userId, status, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchBy_U_S_Last(
		long userId, int status,
		OrderByComparator<DataCollection> orderByComparator) {

		int count = countBy_U_S(userId, status);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findBy_U_S(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findBy_U_S_PrevAndNext(
			long dataCollectionId, long userId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getBy_U_S_PrevAndNext(
				session, dataCollection, userId, status, orderByComparator,
				true);

			array[1] = dataCollection;

			array[2] = getBy_U_S_PrevAndNext(
				session, dataCollection, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getBy_U_S_PrevAndNext(
		Session session, DataCollection dataCollection, long userId, int status,
		OrderByComparator<DataCollection> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN__U_S_USERID_2);

		query.append(_FINDER_COLUMN__U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeBy_U_S(long userId, int status) {
		for (DataCollection dataCollection :
				findBy_U_S(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data collections
	 */
	@Override
	public int countBy_U_S(long userId, int status) {
		FinderPath finderPath = _finderPathCountBy_U_S;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN__U_S_USERID_2);

			query.append(_FINDER_COLUMN__U_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN__U_S_USERID_2 =
		"dataCollection.userId = ? AND ";

	private static final String _FINDER_COLUMN__U_S_STATUS_2 =
		"dataCollection.status = ?";

	private FinderPath _finderPathWithPaginationFindBy_G_U_S;
	private FinderPath _finderPathWithoutPaginationFindBy_G_U_S;
	private FinderPath _finderPathCountBy_G_U_S;

	/**
	 * Returns all the data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_U_S(
		long groupId, long userId, int status) {

		return findBy_G_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_U_S(
		long groupId, long userId, int status, int start, int end) {

		return findBy_G_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findBy_G_U_S(
			groupId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findBy_G_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBy_G_U_S;
			finderArgs = new Object[] {groupId, userId, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindBy_G_U_S;
			finderArgs = new Object[] {
				groupId, userId, status, start, end, orderByComparator
			};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((groupId != dataCollection.getGroupId()) ||
						(userId != dataCollection.getUserId()) ||
						(status != dataCollection.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN__G_U_S_GROUPID_2);

			query.append(_FINDER_COLUMN__G_U_S_USERID_2);

			query.append(_FINDER_COLUMN__G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(status);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findBy_G_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchBy_G_U_S_First(
			groupId, userId, status, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchBy_G_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findBy_G_U_S(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findBy_G_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchBy_G_U_S_Last(
			groupId, userId, status, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchBy_G_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<DataCollection> orderByComparator) {

		int count = countBy_G_U_S(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findBy_G_U_S(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findBy_G_U_S_PrevAndNext(
			long dataCollectionId, long groupId, long userId, int status,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getBy_G_U_S_PrevAndNext(
				session, dataCollection, groupId, userId, status,
				orderByComparator, true);

			array[1] = dataCollection;

			array[2] = getBy_G_U_S_PrevAndNext(
				session, dataCollection, groupId, userId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getBy_G_U_S_PrevAndNext(
		Session session, DataCollection dataCollection, long groupId,
		long userId, int status,
		OrderByComparator<DataCollection> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN__G_U_S_GROUPID_2);

		query.append(_FINDER_COLUMN__G_U_S_USERID_2);

		query.append(_FINDER_COLUMN__G_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeBy_G_U_S(long groupId, long userId, int status) {
		for (DataCollection dataCollection :
				findBy_G_U_S(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data collections
	 */
	@Override
	public int countBy_G_U_S(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountBy_G_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN__G_U_S_GROUPID_2);

			query.append(_FINDER_COLUMN__G_U_S_USERID_2);

			query.append(_FINDER_COLUMN__G_U_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN__G_U_S_GROUPID_2 =
		"dataCollection.groupId = ? AND ";

	private static final String _FINDER_COLUMN__G_U_S_USERID_2 =
		"dataCollection.userId = ? AND ";

	private static final String _FINDER_COLUMN__G_U_S_STATUS_2 =
		"dataCollection.status = ?";

	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the data collection where name = &#63; or throws a <code>NoSuchDataCollectionException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByName(String name)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByName(name);

		if (dataCollection == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDataCollectionException(msg.toString());
		}

		return dataCollection;
	}

	/**
	 * Returns the data collection where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the data collection where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByName(String name, boolean retrieveFromCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = new Object[] {name};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof DataCollection) {
			DataCollection dataCollection = (DataCollection)result;

			if (!Objects.equals(name, dataCollection.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<DataCollection> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByName, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DataCollectionPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DataCollection dataCollection = list.get(0);

					result = dataCollection;

					cacheResult(dataCollection);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByName, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DataCollection)result;
		}
	}

	/**
	 * Removes the data collection where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the data collection that was removed
	 */
	@Override
	public DataCollection removeByName(String name)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByName(name);

		return remove(dataCollection);
	}

	/**
	 * Returns the number of data collections where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching data collections
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"dataCollection.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(dataCollection.name IS NULL OR dataCollection.name = '')";

	private FinderPath _finderPathWithPaginationFindByDataTypeName;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeName;
	private FinderPath _finderPathCountByDataTypeName;

	/**
	 * Returns all the data collections where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findByDataTypeName(long dataTypeName) {
		return findByDataTypeName(
			dataTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections where dataTypeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findByDataTypeName(
		long dataTypeName, int start, int end) {

		return findByDataTypeName(dataTypeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where dataTypeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByDataTypeName(
		long dataTypeName, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findByDataTypeName(
			dataTypeName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where dataTypeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByDataTypeName(
		long dataTypeName, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDataTypeName;
			finderArgs = new Object[] {dataTypeName};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataTypeName;
			finderArgs = new Object[] {
				dataTypeName, start, end, orderByComparator
			};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((dataTypeName != dataCollection.getDataTypeName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataTypeName);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByDataTypeName_First(
			long dataTypeName,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByDataTypeName_First(
			dataTypeName, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataTypeName=");
		msg.append(dataTypeName);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByDataTypeName_First(
		long dataTypeName,
		OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findByDataTypeName(
			dataTypeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByDataTypeName_Last(
			long dataTypeName,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByDataTypeName_Last(
			dataTypeName, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataTypeName=");
		msg.append(dataTypeName);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByDataTypeName_Last(
		long dataTypeName,
		OrderByComparator<DataCollection> orderByComparator) {

		int count = countByDataTypeName(dataTypeName);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findByDataTypeName(
			dataTypeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findByDataTypeName_PrevAndNext(
			long dataCollectionId, long dataTypeName,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getByDataTypeName_PrevAndNext(
				session, dataCollection, dataTypeName, orderByComparator, true);

			array[1] = dataCollection;

			array[2] = getByDataTypeName_PrevAndNext(
				session, dataCollection, dataTypeName, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getByDataTypeName_PrevAndNext(
		Session session, DataCollection dataCollection, long dataTypeName,
		OrderByComparator<DataCollection> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dataTypeName);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where dataTypeName = &#63; from the database.
	 *
	 * @param dataTypeName the data type name
	 */
	@Override
	public void removeByDataTypeName(long dataTypeName) {
		for (DataCollection dataCollection :
				findByDataTypeName(
					dataTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @return the number of matching data collections
	 */
	@Override
	public int countByDataTypeName(long dataTypeName) {
		FinderPath finderPath = _finderPathCountByDataTypeName;

		Object[] finderArgs = new Object[] {dataTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataTypeName);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DATATYPENAME_DATATYPENAME_2 =
		"dataCollection.dataTypeName = ?";

	private FinderPath _finderPathWithPaginationFindByDataType;
	private FinderPath _finderPathWithoutPaginationFindByDataType;
	private FinderPath _finderPathCountByDataType;

	/**
	 * Returns all the data collections where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @return the matching data collections
	 */
	@Override
	public List<DataCollection> findByDataType(
		long dataTypeName, long dataTypeVersion) {

		return findByDataType(
			dataTypeName, dataTypeVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data collections where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	@Override
	public List<DataCollection> findByDataType(
		long dataTypeName, long dataTypeVersion, int start, int end) {

		return findByDataType(dataTypeName, dataTypeVersion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByDataType(
		long dataTypeName, long dataTypeVersion, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findByDataType(
			dataTypeName, dataTypeVersion, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data collections
	 */
	@Override
	public List<DataCollection> findByDataType(
		long dataTypeName, long dataTypeVersion, int start, int end,
		OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDataType;
			finderArgs = new Object[] {dataTypeName, dataTypeVersion};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataType;
			finderArgs = new Object[] {
				dataTypeName, dataTypeVersion, start, end, orderByComparator
			};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataCollection dataCollection : list) {
					if ((dataTypeName != dataCollection.getDataTypeName()) ||
						(dataTypeVersion !=
							dataCollection.getDataTypeVersion())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_DATATYPE_DATATYPENAME_2);

			query.append(_FINDER_COLUMN_DATATYPE_DATATYPEVERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataTypeName);

				qPos.add(dataTypeVersion);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data collection in the ordered set where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByDataType_First(
			long dataTypeName, long dataTypeVersion,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByDataType_First(
			dataTypeName, dataTypeVersion, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataTypeName=");
		msg.append(dataTypeName);

		msg.append(", dataTypeVersion=");
		msg.append(dataTypeVersion);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the first data collection in the ordered set where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByDataType_First(
		long dataTypeName, long dataTypeVersion,
		OrderByComparator<DataCollection> orderByComparator) {

		List<DataCollection> list = findByDataType(
			dataTypeName, dataTypeVersion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data collection in the ordered set where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	@Override
	public DataCollection findByDataType_Last(
			long dataTypeName, long dataTypeVersion,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByDataType_Last(
			dataTypeName, dataTypeVersion, orderByComparator);

		if (dataCollection != null) {
			return dataCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataTypeName=");
		msg.append(dataTypeName);

		msg.append(", dataTypeVersion=");
		msg.append(dataTypeVersion);

		msg.append("}");

		throw new NoSuchDataCollectionException(msg.toString());
	}

	/**
	 * Returns the last data collection in the ordered set where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Override
	public DataCollection fetchByDataType_Last(
		long dataTypeName, long dataTypeVersion,
		OrderByComparator<DataCollection> orderByComparator) {

		int count = countByDataType(dataTypeName, dataTypeVersion);

		if (count == 0) {
			return null;
		}

		List<DataCollection> list = findByDataType(
			dataTypeName, dataTypeVersion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection[] findByDataType_PrevAndNext(
			long dataCollectionId, long dataTypeName, long dataTypeVersion,
			OrderByComparator<DataCollection> orderByComparator)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = findByPrimaryKey(dataCollectionId);

		Session session = null;

		try {
			session = openSession();

			DataCollection[] array = new DataCollectionImpl[3];

			array[0] = getByDataType_PrevAndNext(
				session, dataCollection, dataTypeName, dataTypeVersion,
				orderByComparator, true);

			array[1] = dataCollection;

			array[2] = getByDataType_PrevAndNext(
				session, dataCollection, dataTypeName, dataTypeVersion,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataCollection getByDataType_PrevAndNext(
		Session session, DataCollection dataCollection, long dataTypeName,
		long dataTypeVersion,
		OrderByComparator<DataCollection> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DATACOLLECTION_WHERE);

		query.append(_FINDER_COLUMN_DATATYPE_DATATYPENAME_2);

		query.append(_FINDER_COLUMN_DATATYPE_DATATYPEVERSION_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DataCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dataTypeName);

		qPos.add(dataTypeVersion);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataCollection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data collections where dataTypeName = &#63; and dataTypeVersion = &#63; from the database.
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 */
	@Override
	public void removeByDataType(long dataTypeName, long dataTypeVersion) {
		for (DataCollection dataCollection :
				findByDataType(
					dataTypeName, dataTypeVersion, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections where dataTypeName = &#63; and dataTypeVersion = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param dataTypeVersion the data type version
	 * @return the number of matching data collections
	 */
	@Override
	public int countByDataType(long dataTypeName, long dataTypeVersion) {
		FinderPath finderPath = _finderPathCountByDataType;

		Object[] finderArgs = new Object[] {dataTypeName, dataTypeVersion};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DATACOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_DATATYPE_DATATYPENAME_2);

			query.append(_FINDER_COLUMN_DATATYPE_DATATYPEVERSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataTypeName);

				qPos.add(dataTypeVersion);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DATATYPE_DATATYPENAME_2 =
		"dataCollection.dataTypeName = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPE_DATATYPEVERSION_2 =
		"dataCollection.dataTypeVersion = ?";

	public DataCollectionPersistenceImpl() {
		setModelClass(DataCollection.class);

		setModelImplClass(DataCollectionImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the data collection in the entity cache if it is enabled.
	 *
	 * @param dataCollection the data collection
	 */
	@Override
	public void cacheResult(DataCollection dataCollection) {
		entityCache.putResult(
			entityCacheEnabled, DataCollectionImpl.class,
			dataCollection.getPrimaryKey(), dataCollection);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				dataCollection.getUuid(), dataCollection.getGroupId()
			},
			dataCollection);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {dataCollection.getName()},
			dataCollection);

		dataCollection.resetOriginalValues();
	}

	/**
	 * Caches the data collections in the entity cache if it is enabled.
	 *
	 * @param dataCollections the data collections
	 */
	@Override
	public void cacheResult(List<DataCollection> dataCollections) {
		for (DataCollection dataCollection : dataCollections) {
			if (entityCache.getResult(
					entityCacheEnabled, DataCollectionImpl.class,
					dataCollection.getPrimaryKey()) == null) {

				cacheResult(dataCollection);
			}
			else {
				dataCollection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data collections.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataCollectionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data collection.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataCollection dataCollection) {
		entityCache.removeResult(
			entityCacheEnabled, DataCollectionImpl.class,
			dataCollection.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DataCollectionModelImpl)dataCollection, true);
	}

	@Override
	public void clearCache(List<DataCollection> dataCollections) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataCollection dataCollection : dataCollections) {
			entityCache.removeResult(
				entityCacheEnabled, DataCollectionImpl.class,
				dataCollection.getPrimaryKey());

			clearUniqueFindersCache(
				(DataCollectionModelImpl)dataCollection, true);
		}
	}

	protected void cacheUniqueFindersCache(
		DataCollectionModelImpl dataCollectionModelImpl) {

		Object[] args = new Object[] {
			dataCollectionModelImpl.getUuid(),
			dataCollectionModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dataCollectionModelImpl, false);

		args = new Object[] {dataCollectionModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, dataCollectionModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DataCollectionModelImpl dataCollectionModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				dataCollectionModelImpl.getUuid(),
				dataCollectionModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((dataCollectionModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataCollectionModelImpl.getOriginalUuid(),
				dataCollectionModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {dataCollectionModelImpl.getName()};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(_finderPathFetchByName, args);
		}

		if ((dataCollectionModelImpl.getColumnBitmask() &
			 _finderPathFetchByName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataCollectionModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(_finderPathFetchByName, args);
		}
	}

	/**
	 * Creates a new data collection with the primary key. Does not add the data collection to the database.
	 *
	 * @param dataCollectionId the primary key for the new data collection
	 * @return the new data collection
	 */
	@Override
	public DataCollection create(long dataCollectionId) {
		DataCollection dataCollection = new DataCollectionImpl();

		dataCollection.setNew(true);
		dataCollection.setPrimaryKey(dataCollectionId);

		String uuid = PortalUUIDUtil.generate();

		dataCollection.setUuid(uuid);

		dataCollection.setCompanyId(companyProvider.getCompanyId());

		return dataCollection;
	}

	/**
	 * Removes the data collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection that was removed
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection remove(long dataCollectionId)
		throws NoSuchDataCollectionException {

		return remove((Serializable)dataCollectionId);
	}

	/**
	 * Removes the data collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data collection
	 * @return the data collection that was removed
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection remove(Serializable primaryKey)
		throws NoSuchDataCollectionException {

		Session session = null;

		try {
			session = openSession();

			DataCollection dataCollection = (DataCollection)session.get(
				DataCollectionImpl.class, primaryKey);

			if (dataCollection == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataCollectionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataCollection);
		}
		catch (NoSuchDataCollectionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DataCollection removeImpl(DataCollection dataCollection) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataCollection)) {
				dataCollection = (DataCollection)session.get(
					DataCollectionImpl.class,
					dataCollection.getPrimaryKeyObj());
			}

			if (dataCollection != null) {
				session.delete(dataCollection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataCollection != null) {
			clearCache(dataCollection);
		}

		return dataCollection;
	}

	@Override
	public DataCollection updateImpl(DataCollection dataCollection) {
		boolean isNew = dataCollection.isNew();

		if (!(dataCollection instanceof DataCollectionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataCollection.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dataCollection);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataCollection proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataCollection implementation " +
					dataCollection.getClass());
		}

		DataCollectionModelImpl dataCollectionModelImpl =
			(DataCollectionModelImpl)dataCollection;

		if (Validator.isNull(dataCollection.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dataCollection.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dataCollection.getCreateDate() == null)) {
			if (serviceContext == null) {
				dataCollection.setCreateDate(now);
			}
			else {
				dataCollection.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!dataCollectionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dataCollection.setModifiedDate(now);
			}
			else {
				dataCollection.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dataCollection.isNew()) {
				session.save(dataCollection);

				dataCollection.setNew(false);
			}
			else {
				dataCollection = (DataCollection)session.merge(dataCollection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {dataCollectionModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				dataCollectionModelImpl.getUuid(),
				dataCollectionModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {dataCollectionModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {dataCollectionModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {dataCollectionModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {
				dataCollectionModelImpl.getGroupId(),
				dataCollectionModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountBy_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBy_G_U, args);

			args = new Object[] {
				dataCollectionModelImpl.getGroupId(),
				dataCollectionModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountBy_G_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBy_G_S, args);

			args = new Object[] {
				dataCollectionModelImpl.getUserId(),
				dataCollectionModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountBy_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBy_U_S, args);

			args = new Object[] {
				dataCollectionModelImpl.getGroupId(),
				dataCollectionModelImpl.getUserId(),
				dataCollectionModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountBy_G_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBy_G_U_S, args);

			args = new Object[] {dataCollectionModelImpl.getDataTypeName()};

			finderCache.removeResult(_finderPathCountByDataTypeName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeName, args);

			args = new Object[] {
				dataCollectionModelImpl.getDataTypeName(),
				dataCollectionModelImpl.getDataTypeVersion()
			};

			finderCache.removeResult(_finderPathCountByDataType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {dataCollectionModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalUuid(),
					dataCollectionModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					dataCollectionModelImpl.getUuid(),
					dataCollectionModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {dataCollectionModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {dataCollectionModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {dataCollectionModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBy_G_U.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalGroupId(),
					dataCollectionModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountBy_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_G_U, args);

				args = new Object[] {
					dataCollectionModelImpl.getGroupId(),
					dataCollectionModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountBy_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_G_U, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBy_G_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalGroupId(),
					dataCollectionModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountBy_G_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_G_S, args);

				args = new Object[] {
					dataCollectionModelImpl.getGroupId(),
					dataCollectionModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountBy_G_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_G_S, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBy_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalUserId(),
					dataCollectionModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountBy_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_U_S, args);

				args = new Object[] {
					dataCollectionModelImpl.getUserId(),
					dataCollectionModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountBy_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_U_S, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBy_G_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalGroupId(),
					dataCollectionModelImpl.getOriginalUserId(),
					dataCollectionModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountBy_G_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_G_U_S, args);

				args = new Object[] {
					dataCollectionModelImpl.getGroupId(),
					dataCollectionModelImpl.getUserId(),
					dataCollectionModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountBy_G_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_G_U_S, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalDataTypeName()
				};

				finderCache.removeResult(_finderPathCountByDataTypeName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeName, args);

				args = new Object[] {dataCollectionModelImpl.getDataTypeName()};

				finderCache.removeResult(_finderPathCountByDataTypeName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeName, args);
			}

			if ((dataCollectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCollectionModelImpl.getOriginalDataTypeName(),
					dataCollectionModelImpl.getOriginalDataTypeVersion()
				};

				finderCache.removeResult(_finderPathCountByDataType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataType, args);

				args = new Object[] {
					dataCollectionModelImpl.getDataTypeName(),
					dataCollectionModelImpl.getDataTypeVersion()
				};

				finderCache.removeResult(_finderPathCountByDataType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataType, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DataCollectionImpl.class,
			dataCollection.getPrimaryKey(), dataCollection, false);

		clearUniqueFindersCache(dataCollectionModelImpl, false);
		cacheUniqueFindersCache(dataCollectionModelImpl);

		dataCollection.resetOriginalValues();

		return dataCollection;
	}

	/**
	 * Returns the data collection with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data collection
	 * @return the data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataCollectionException {

		DataCollection dataCollection = fetchByPrimaryKey(primaryKey);

		if (dataCollection == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataCollectionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataCollection;
	}

	/**
	 * Returns the data collection with the primary key or throws a <code>NoSuchDataCollectionException</code> if it could not be found.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection findByPrimaryKey(long dataCollectionId)
		throws NoSuchDataCollectionException {

		return findByPrimaryKey((Serializable)dataCollectionId);
	}

	/**
	 * Returns the data collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection, or <code>null</code> if a data collection with the primary key could not be found
	 */
	@Override
	public DataCollection fetchByPrimaryKey(long dataCollectionId) {
		return fetchByPrimaryKey((Serializable)dataCollectionId);
	}

	/**
	 * Returns all the data collections.
	 *
	 * @return the data collections
	 */
	@Override
	public List<DataCollection> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of data collections
	 */
	@Override
	public List<DataCollection> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data collections
	 */
	@Override
	public List<DataCollection> findAll(
		int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data collections
	 */
	@Override
	public List<DataCollection> findAll(
		int start, int end, OrderByComparator<DataCollection> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DataCollection> list = null;

		if (retrieveFromCache) {
			list = (List<DataCollection>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATACOLLECTION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATACOLLECTION;

				if (pagination) {
					sql = sql.concat(DataCollectionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataCollection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the data collections from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataCollection dataCollection : findAll()) {
			remove(dataCollection);
		}
	}

	/**
	 * Returns the number of data collections.
	 *
	 * @return the number of data collections
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATACOLLECTION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "dataCollectionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATACOLLECTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataCollectionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data collection persistence.
	 */
	@Activate
	public void activate() {
		DataCollectionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataCollectionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			DataCollectionModelImpl.UUID_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			DataCollectionModelImpl.UUID_COLUMN_BITMASK |
			DataCollectionModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			DataCollectionModelImpl.UUID_COLUMN_BITMASK |
			DataCollectionModelImpl.COMPANYID_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			DataCollectionModelImpl.GROUPID_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			DataCollectionModelImpl.USERID_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			DataCollectionModelImpl.STATUS_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindBy_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBy_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBy_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBy_G_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			DataCollectionModelImpl.GROUPID_COLUMN_BITMASK |
			DataCollectionModelImpl.USERID_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBy_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBy_G_U",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindBy_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBy_G_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBy_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBy_G_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			DataCollectionModelImpl.GROUPID_COLUMN_BITMASK |
			DataCollectionModelImpl.STATUS_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBy_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBy_G_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindBy_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBy_U_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBy_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBy_U_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			DataCollectionModelImpl.USERID_COLUMN_BITMASK |
			DataCollectionModelImpl.STATUS_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBy_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBy_U_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindBy_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBy_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBy_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBy_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			DataCollectionModelImpl.GROUPID_COLUMN_BITMASK |
			DataCollectionModelImpl.USERID_COLUMN_BITMASK |
			DataCollectionModelImpl.STATUS_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBy_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBy_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathFetchByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()},
			DataCollectionModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByDataTypeName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeName",
			new String[] {Long.class.getName()},
			DataCollectionModelImpl.DATATYPENAME_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByDataTypeName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeName",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataType",
			new String[] {Long.class.getName(), Long.class.getName()},
			DataCollectionModelImpl.DATATYPENAME_COLUMN_BITMASK |
			DataCollectionModelImpl.DATATYPEVERSION_COLUMN_BITMASK |
			DataCollectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByDataType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataType",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataCollectionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ICECAPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.osp.icecap.model.DataCollection"),
			true);
	}

	@Override
	@Reference(
		target = ICECAPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ICECAPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DATACOLLECTION =
		"SELECT dataCollection FROM DataCollection dataCollection";

	private static final String _SQL_SELECT_DATACOLLECTION_WHERE =
		"SELECT dataCollection FROM DataCollection dataCollection WHERE ";

	private static final String _SQL_COUNT_DATACOLLECTION =
		"SELECT COUNT(dataCollection) FROM DataCollection dataCollection";

	private static final String _SQL_COUNT_DATACOLLECTION_WHERE =
		"SELECT COUNT(dataCollection) FROM DataCollection dataCollection WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataCollection.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataCollection exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataCollection exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataCollectionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}