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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.osp.icecap.exception.NoSuchDataTypeException;
import com.osp.icecap.model.DataType;
import com.osp.icecap.model.impl.DataTypeImpl;
import com.osp.icecap.model.impl.DataTypeModelImpl;
import com.osp.icecap.service.persistence.DataTypePersistence;
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

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the data type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = DataTypePersistence.class)
public class DataTypePersistenceImpl
	extends BasePersistenceImpl<DataType> implements DataTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataTypeUtil</code> to access the data type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataTypeImpl.class.getName();

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
	 * Returns all the data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (!uuid.equals(dataType.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByUuid_First(
			String uuid, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByUuid_First(uuid, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByUuid_First(
		String uuid, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByUuid_Last(
			String uuid, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByUuid_Last(uuid, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByUuid_Last(
		String uuid, OrderByComparator<DataType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where uuid = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByUuid_PrevAndNext(
			long dataTypeId, String uuid,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		uuid = Objects.toString(uuid, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dataType, uuid, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByUuid_PrevAndNext(
				session, dataType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByUuid_PrevAndNext(
		Session session, DataType dataType, String uuid,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DataType dataType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"dataType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dataType.uuid IS NULL OR dataType.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the data type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByUUID_G(String uuid, long groupId)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByUUID_G(uuid, groupId);

		if (dataType == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDataTypeException(sb.toString());
		}

		return dataType;
	}

	/**
	 * Returns the data type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the data type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof DataType) {
			DataType dataType = (DataType)result;

			if (!Objects.equals(uuid, dataType.getUuid()) ||
				(groupId != dataType.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<DataType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DataType dataType = list.get(0);

					result = dataType;

					cacheResult(dataType);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DataType)result;
		}
	}

	/**
	 * Removes the data type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data type that was removed
	 */
	@Override
	public DataType removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataTypeException {

		DataType dataType = findByUUID_G(uuid, groupId);

		return remove(dataType);
	}

	/**
	 * Returns the number of data types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data types
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"dataType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dataType.uuid IS NULL OR dataType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dataType.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the data types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (!uuid.equals(dataType.getUuid()) ||
						(companyId != dataType.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByUuid_C_PrevAndNext(
			long dataTypeId, String uuid, long companyId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		uuid = Objects.toString(uuid, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dataType, uuid, companyId, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByUuid_C_PrevAndNext(
				session, dataType, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByUuid_C_PrevAndNext(
		Session session, DataType dataType, String uuid, long companyId,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DataType dataType :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data types
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"dataType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dataType.uuid IS NULL OR dataType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dataType.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the data types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (groupId != dataType.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByGroupId_First(
			long groupId, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByGroupId_First(groupId, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByGroupId_First(
		long groupId, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByGroupId_Last(
			long groupId, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByGroupId_Last(groupId, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByGroupId_Last(
		long groupId, OrderByComparator<DataType> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where groupId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByGroupId_PrevAndNext(
			long dataTypeId, long groupId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, dataType, groupId, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByGroupId_PrevAndNext(
				session, dataType, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByGroupId_PrevAndNext(
		Session session, DataType dataType, long groupId,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the data types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<DataType>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set of data types that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] filterFindByGroupId_PrevAndNext(
			long dataTypeId, long groupId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				dataTypeId, groupId, orderByComparator);
		}

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, dataType, groupId, orderByComparator, true);

			array[1] = dataType;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, dataType, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType filterGetByGroupId_PrevAndNext(
		Session session, DataType dataType, long groupId,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (DataType dataType :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data types
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of data types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data types that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"dataType.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the data types where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (userId != dataType.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByUserId_First(
			long userId, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByUserId_First(userId, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByUserId_First(
		long userId, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByUserId_Last(
			long userId, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByUserId_Last(userId, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByUserId_Last(
		long userId, OrderByComparator<DataType> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where userId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByUserId_PrevAndNext(
			long dataTypeId, long userId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, dataType, userId, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByUserId_PrevAndNext(
				session, dataType, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByUserId_PrevAndNext(
		Session session, DataType dataType, long userId,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (DataType dataType :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data types
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"dataType.userId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the data types where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (status != dataType.getStatus()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByStatus_First(
			int status, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByStatus_First(status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByStatus_First(
		int status, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByStatus_Last(
			int status, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByStatus_Last(status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByStatus_Last(
		int status, OrderByComparator<DataType> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByStatus_PrevAndNext(
			long dataTypeId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, dataType, status, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByStatus_PrevAndNext(
				session, dataType, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByStatus_PrevAndNext(
		Session session, DataType dataType, int status,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (DataType dataType :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data types
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"dataType.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_U;
	private FinderPath _finderPathWithoutPaginationFindByG_U;
	private FinderPath _finderPathCountByG_U;

	/**
	 * Returns all the data types where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByG_U(long groupId, long userId) {
		return findByG_U(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByG_U(
		long groupId, long userId, int start, int end) {

		return findByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByG_U(groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U;
				finderArgs = new Object[] {groupId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U;
			finderArgs = new Object[] {
				groupId, userId, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((groupId != dataType.getGroupId()) ||
						(userId != dataType.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByG_U_First(
			long groupId, long userId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByG_U_First(
			groupId, userId, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByG_U(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByG_U_Last(groupId, userId, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByG_U(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByG_U(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByG_U_PrevAndNext(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByG_U_PrevAndNext(
				session, dataType, groupId, userId, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByG_U_PrevAndNext(
				session, dataType, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByG_U_PrevAndNext(
		Session session, DataType dataType, long groupId, long userId,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the data types that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_U(long groupId, long userId) {
		return filterFindByG_U(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_U(
		long groupId, long userId, int start, int end) {

		return filterFindByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U(groupId, userId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			return (List<DataType>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set of data types that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] filterFindByG_U_PrevAndNext(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_PrevAndNext(
				dataTypeId, groupId, userId, orderByComparator);
		}

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = filterGetByG_U_PrevAndNext(
				session, dataType, groupId, userId, orderByComparator, true);

			array[1] = dataType;

			array[2] = filterGetByG_U_PrevAndNext(
				session, dataType, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType filterGetByG_U_PrevAndNext(
		Session session, DataType dataType, long groupId, long userId,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByG_U(long groupId, long userId) {
		for (DataType dataType :
				findByG_U(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data types
	 */
	@Override
	public int countByG_U(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByG_U;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of data types that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data types that the user has permission to view
	 */
	@Override
	public int filterCountByG_U(long groupId, long userId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U(groupId, userId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_U_GROUPID_2 =
		"dataType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_USERID_2 =
		"dataType.userId = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the data types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((groupId != dataType.getGroupId()) ||
						(status != dataType.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByG_S_First(
			long groupId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByG_S_Last(groupId, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByG_S_PrevAndNext(
			long dataTypeId, long groupId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, dataType, groupId, status, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByG_S_PrevAndNext(
				session, dataType, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByG_S_PrevAndNext(
		Session session, DataType dataType, long groupId, int status,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the data types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<DataType>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set of data types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] filterFindByG_S_PrevAndNext(
			long dataTypeId, long groupId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				dataTypeId, groupId, status, orderByComparator);
		}

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, dataType, groupId, status, orderByComparator, true);

			array[1] = dataType;

			array[2] = filterGetByG_S_PrevAndNext(
				session, dataType, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType filterGetByG_S_PrevAndNext(
		Session session, DataType dataType, long groupId, int status,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (DataType dataType :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data types
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of data types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data types that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"dataType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"dataType.status = ?";

	private FinderPath _finderPathWithPaginationFindByU_S;
	private FinderPath _finderPathWithoutPaginationFindByU_S;
	private FinderPath _finderPathCountByU_S;

	/**
	 * Returns all the data types where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByU_S(long userId, int status) {
		return findByU_S(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByU_S(
		long userId, int status, int start, int end) {

		return findByU_S(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByU_S(userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU_S;
				finderArgs = new Object[] {userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU_S;
			finderArgs = new Object[] {
				userId, status, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((userId != dataType.getUserId()) ||
						(status != dataType.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByU_S_First(
			long userId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByU_S_First(userId, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByU_S_First(
		long userId, int status,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByU_S(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByU_S_Last(
			long userId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByU_S_Last(userId, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByU_S(userId, status);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByU_S(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByU_S_PrevAndNext(
			long dataTypeId, long userId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByU_S_PrevAndNext(
				session, dataType, userId, status, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByU_S_PrevAndNext(
				session, dataType, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByU_S_PrevAndNext(
		Session session, DataType dataType, long userId, int status,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByU_S(long userId, int status) {
		for (DataType dataType :
				findByU_S(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data types
	 */
	@Override
	public int countByU_S(long userId, int status) {
		FinderPath finderPath = _finderPathCountByU_S;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_S_USERID_2 =
		"dataType.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_S_STATUS_2 =
		"dataType.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_U_S;
	private FinderPath _finderPathWithoutPaginationFindByG_U_S;
	private FinderPath _finderPathCountByG_U_S;

	/**
	 * Returns all the data types where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByG_U_S(long groupId, long userId, int status) {
		return findByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data types where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return findByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByG_U_S(
			groupId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U_S;
				finderArgs = new Object[] {groupId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U_S;
			finderArgs = new Object[] {
				groupId, userId, status, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((groupId != dataType.getGroupId()) ||
						(userId != dataType.getUserId()) ||
						(status != dataType.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByG_U_S(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByG_U_S(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByG_U_S(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByG_U_S_PrevAndNext(
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByG_U_S_PrevAndNext(
				session, dataType, groupId, userId, status, orderByComparator,
				true);

			array[1] = dataType;

			array[2] = getByG_U_S_PrevAndNext(
				session, dataType, groupId, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByG_U_S_PrevAndNext(
		Session session, DataType dataType, long groupId, long userId,
		int status, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the data types that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return filterFindByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data types that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return filterFindByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S(
				groupId, userId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			queryPos.add(status);

			return (List<DataType>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set of data types that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] filterFindByG_U_S_PrevAndNext(
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U_S_PrevAndNext(
				dataTypeId, groupId, userId, status, orderByComparator);
		}

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = filterGetByG_U_S_PrevAndNext(
				session, dataType, groupId, userId, status, orderByComparator,
				true);

			array[1] = dataType;

			array[2] = filterGetByG_U_S_PrevAndNext(
				session, dataType, groupId, userId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType filterGetByG_U_S_PrevAndNext(
		Session session, DataType dataType, long groupId, long userId,
		int status, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByG_U_S(long groupId, long userId, int status) {
		for (DataType dataType :
				findByG_U_S(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data types
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByG_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of data types that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data types that the user has permission to view
	 */
	@Override
	public int filterCountByG_U_S(long groupId, long userId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U_S(groupId, userId, status);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_U_S_GROUPID_2 =
		"dataType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_USERID_2 =
		"dataType.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_2 =
		"dataType.status = ?";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the data types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName(
		String name, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName(
		String name, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (!name.equals(dataType.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_First(
			String name, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_First(name, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_First(
		String name, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_Last(
			String name, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_Last(name, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_Last(
		String name, OrderByComparator<DataType> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where name = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByName_PrevAndNext(
			long dataTypeId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByName_PrevAndNext(
				session, dataType, name, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByName_PrevAndNext(
				session, dataType, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByName_PrevAndNext(
		Session session, DataType dataType, String name,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (DataType dataType :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching data types
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"dataType.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '')";

	private FinderPath _finderPathWithPaginationFindByName_G;
	private FinderPath _finderPathWithoutPaginationFindByName_G;
	private FinderPath _finderPathCountByName_G;

	/**
	 * Returns all the data types where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByName_G(long groupId, String name) {
		return findByName_G(
			groupId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByName_G(
		long groupId, String name, int start, int end) {

		return findByName_G(groupId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_G(
		long groupId, String name, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByName_G(groupId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_G(
		long groupId, String name, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName_G;
				finderArgs = new Object[] {groupId, name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName_G;
			finderArgs = new Object[] {
				groupId, name, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((groupId != dataType.getGroupId()) ||
						!name.equals(dataType.getName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_G_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_G_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_G_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_G_First(
			long groupId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_G_First(
			groupId, name, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_G_First(
		long groupId, String name,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByName_G(
			groupId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_G_Last(
			long groupId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_G_Last(
			groupId, name, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_G_Last(
		long groupId, String name,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByName_G(groupId, name);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByName_G(
			groupId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByName_G_PrevAndNext(
			long dataTypeId, long groupId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByName_G_PrevAndNext(
				session, dataType, groupId, name, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByName_G_PrevAndNext(
				session, dataType, groupId, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByName_G_PrevAndNext(
		Session session, DataType dataType, long groupId, String name,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_G_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the data types that the user has permission to view where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G(long groupId, String name) {
		return filterFindByName_G(
			groupId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types that the user has permission to view where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G(
		long groupId, String name, int start, int end) {

		return filterFindByName_G(groupId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types that the user has permissions to view where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G(
		long groupId, String name, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByName_G(groupId, name, start, end, orderByComparator);
		}

		name = Objects.toString(name, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_NAME_G_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_NAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindName) {
				queryPos.add(name);
			}

			return (List<DataType>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set of data types that the user has permission to view where groupId = &#63; and name = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] filterFindByName_G_PrevAndNext(
			long dataTypeId, long groupId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByName_G_PrevAndNext(
				dataTypeId, groupId, name, orderByComparator);
		}

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = filterGetByName_G_PrevAndNext(
				session, dataType, groupId, name, orderByComparator, true);

			array[1] = dataType;

			array[2] = filterGetByName_G_PrevAndNext(
				session, dataType, groupId, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType filterGetByName_G_PrevAndNext(
		Session session, DataType dataType, long groupId, String name,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_NAME_G_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_NAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 */
	@Override
	public void removeByName_G(long groupId, String name) {
		for (DataType dataType :
				findByName_G(
					groupId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching data types
	 */
	@Override
	public int countByName_G(long groupId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName_G;

		Object[] finderArgs = new Object[] {groupId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_G_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_G_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_G_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of data types that the user has permission to view where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching data types that the user has permission to view
	 */
	@Override
	public int filterCountByName_G(long groupId, String name) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByName_G(groupId, name);
		}

		name = Objects.toString(name, "");

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_G_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_NAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindName) {
				queryPos.add(name);
			}

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_NAME_G_GROUPID_2 =
		"dataType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_G_NAME_2 =
		"dataType.name = ?";

	private static final String _FINDER_COLUMN_NAME_G_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '')";

	private FinderPath _finderPathWithPaginationFindByName_U;
	private FinderPath _finderPathWithoutPaginationFindByName_U;
	private FinderPath _finderPathCountByName_U;

	/**
	 * Returns all the data types where userId = &#63; and name = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByName_U(long userId, String name) {
		return findByName_U(
			userId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where userId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByName_U(
		long userId, String name, int start, int end) {

		return findByName_U(userId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where userId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_U(
		long userId, String name, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByName_U(userId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where userId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_U(
		long userId, String name, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName_U;
				finderArgs = new Object[] {userId, name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName_U;
			finderArgs = new Object[] {
				userId, name, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((userId != dataType.getUserId()) ||
						!name.equals(dataType.getName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_U_USERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_U_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_U_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where userId = &#63; and name = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_U_First(
			long userId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_U_First(
			userId, name, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where userId = &#63; and name = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_U_First(
		long userId, String name,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByName_U(
			userId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where userId = &#63; and name = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_U_Last(
			long userId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_U_Last(userId, name, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where userId = &#63; and name = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_U_Last(
		long userId, String name,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByName_U(userId, name);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByName_U(
			userId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where userId = &#63; and name = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByName_U_PrevAndNext(
			long dataTypeId, long userId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByName_U_PrevAndNext(
				session, dataType, userId, name, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByName_U_PrevAndNext(
				session, dataType, userId, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByName_U_PrevAndNext(
		Session session, DataType dataType, long userId, String name,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_U_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_U_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_U_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where userId = &#63; and name = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param name the name
	 */
	@Override
	public void removeByName_U(long userId, String name) {
		for (DataType dataType :
				findByName_U(
					userId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where userId = &#63; and name = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @return the number of matching data types
	 */
	@Override
	public int countByName_U(long userId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName_U;

		Object[] finderArgs = new Object[] {userId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_U_USERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_U_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_U_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_U_USERID_2 =
		"dataType.userId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_U_NAME_2 =
		"dataType.name = ?";

	private static final String _FINDER_COLUMN_NAME_U_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '')";

	private FinderPath _finderPathWithPaginationFindByName_S;
	private FinderPath _finderPathWithoutPaginationFindByName_S;
	private FinderPath _finderPathCountByName_S;

	/**
	 * Returns all the data types where name = &#63; and status = &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByName_S(String name, int status) {
		return findByName_S(
			name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByName_S(
		String name, int status, int start, int end) {

		return findByName_S(name, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_S(
		String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByName_S(name, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_S(
		String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName_S;
				finderArgs = new Object[] {name, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName_S;
			finderArgs = new Object[] {
				name, status, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (!name.equals(dataType.getName()) ||
						(status != dataType.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_S_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_S_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAME_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where name = &#63; and status = &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_S_First(
			String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_S_First(
			name, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where name = &#63; and status = &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_S_First(
		String name, int status,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByName_S(
			name, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where name = &#63; and status = &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_S_Last(
			String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_S_Last(name, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where name = &#63; and status = &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_S_Last(
		String name, int status,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByName_S(name, status);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByName_S(
			name, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where name = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByName_S_PrevAndNext(
			long dataTypeId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByName_S_PrevAndNext(
				session, dataType, name, status, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByName_S_PrevAndNext(
				session, dataType, name, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByName_S_PrevAndNext(
		Session session, DataType dataType, String name, int status,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where name = &#63; and status = &#63; from the database.
	 *
	 * @param name the name
	 * @param status the status
	 */
	@Override
	public void removeByName_S(String name, int status) {
		for (DataType dataType :
				findByName_S(
					name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where name = &#63; and status = &#63;.
	 *
	 * @param name the name
	 * @param status the status
	 * @return the number of matching data types
	 */
	@Override
	public int countByName_S(String name, int status) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName_S;

		Object[] finderArgs = new Object[] {name, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_S_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_S_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAME_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_S_NAME_2 =
		"dataType.name = ? AND ";

	private static final String _FINDER_COLUMN_NAME_S_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '') AND ";

	private static final String _FINDER_COLUMN_NAME_S_STATUS_2 =
		"dataType.status = ?";

	private FinderPath _finderPathWithPaginationFindByName_G_U;
	private FinderPath _finderPathWithoutPaginationFindByName_G_U;
	private FinderPath _finderPathCountByName_G_U;

	/**
	 * Returns all the data types where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByName_G_U(
		long groupId, long userId, String name) {

		return findByName_G_U(
			groupId, userId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_U(
		long groupId, long userId, String name, int start, int end) {

		return findByName_G_U(groupId, userId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_U(
		long groupId, long userId, String name, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByName_G_U(
			groupId, userId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_U(
		long groupId, long userId, String name, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName_G_U;
				finderArgs = new Object[] {groupId, userId, name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName_G_U;
			finderArgs = new Object[] {
				groupId, userId, name, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((groupId != dataType.getGroupId()) ||
						(userId != dataType.getUserId()) ||
						!name.equals(dataType.getName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_NAME_G_U_USERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_G_U_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_G_U_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_G_U_First(
			long groupId, long userId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_G_U_First(
			groupId, userId, name, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_G_U_First(
		long groupId, long userId, String name,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByName_G_U(
			groupId, userId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_G_U_Last(
			long groupId, long userId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_G_U_Last(
			groupId, userId, name, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_G_U_Last(
		long groupId, long userId, String name,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByName_G_U(groupId, userId, name);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByName_G_U(
			groupId, userId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByName_G_U_PrevAndNext(
			long dataTypeId, long groupId, long userId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByName_G_U_PrevAndNext(
				session, dataType, groupId, userId, name, orderByComparator,
				true);

			array[1] = dataType;

			array[2] = getByName_G_U_PrevAndNext(
				session, dataType, groupId, userId, name, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByName_G_U_PrevAndNext(
		Session session, DataType dataType, long groupId, long userId,
		String name, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_NAME_G_U_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_U_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_U_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the data types that the user has permission to view where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @return the matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_U(
		long groupId, long userId, String name) {

		return filterFindByName_G_U(
			groupId, userId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types that the user has permission to view where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_U(
		long groupId, long userId, String name, int start, int end) {

		return filterFindByName_G_U(groupId, userId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types that the user has permissions to view where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_U(
		long groupId, long userId, String name, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByName_G_U(
				groupId, userId, name, start, end, orderByComparator);
		}

		name = Objects.toString(name, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_NAME_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_NAME_G_U_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_U_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_U_NAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			if (bindName) {
				queryPos.add(name);
			}

			return (List<DataType>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set of data types that the user has permission to view where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] filterFindByName_G_U_PrevAndNext(
			long dataTypeId, long groupId, long userId, String name,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByName_G_U_PrevAndNext(
				dataTypeId, groupId, userId, name, orderByComparator);
		}

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = filterGetByName_G_U_PrevAndNext(
				session, dataType, groupId, userId, name, orderByComparator,
				true);

			array[1] = dataType;

			array[2] = filterGetByName_G_U_PrevAndNext(
				session, dataType, groupId, userId, name, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType filterGetByName_G_U_PrevAndNext(
		Session session, DataType dataType, long groupId, long userId,
		String name, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_NAME_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_NAME_G_U_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_U_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_U_NAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where groupId = &#63; and userId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 */
	@Override
	public void removeByName_G_U(long groupId, long userId, String name) {
		for (DataType dataType :
				findByName_G_U(
					groupId, userId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @return the number of matching data types
	 */
	@Override
	public int countByName_G_U(long groupId, long userId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_NAME_G_U_USERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_G_U_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_G_U_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of data types that the user has permission to view where groupId = &#63; and userId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @return the number of matching data types that the user has permission to view
	 */
	@Override
	public int filterCountByName_G_U(long groupId, long userId, String name) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByName_G_U(groupId, userId, name);
		}

		name = Objects.toString(name, "");

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_NAME_G_U_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_U_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_U_NAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			if (bindName) {
				queryPos.add(name);
			}

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_NAME_G_U_GROUPID_2 =
		"dataType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_G_U_USERID_2 =
		"dataType.userId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_G_U_NAME_2 =
		"dataType.name = ?";

	private static final String _FINDER_COLUMN_NAME_G_U_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '')";

	private FinderPath _finderPathWithPaginationFindByName_G_S;
	private FinderPath _finderPathWithoutPaginationFindByName_G_S;
	private FinderPath _finderPathCountByName_G_S;

	/**
	 * Returns all the data types where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByName_G_S(
		long groupId, String name, int status) {

		return findByName_G_S(
			groupId, name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_S(
		long groupId, String name, int status, int start, int end) {

		return findByName_G_S(groupId, name, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_S(
		long groupId, String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByName_G_S(
			groupId, name, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_S(
		long groupId, String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName_G_S;
				finderArgs = new Object[] {groupId, name, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName_G_S;
			finderArgs = new Object[] {
				groupId, name, status, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((groupId != dataType.getGroupId()) ||
						!name.equals(dataType.getName()) ||
						(status != dataType.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_G_S_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_G_S_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_G_S_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAME_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_G_S_First(
			long groupId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_G_S_First(
			groupId, name, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_G_S_First(
		long groupId, String name, int status,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByName_G_S(
			groupId, name, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_G_S_Last(
			long groupId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_G_S_Last(
			groupId, name, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_G_S_Last(
		long groupId, String name, int status,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByName_G_S(groupId, name, status);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByName_G_S(
			groupId, name, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByName_G_S_PrevAndNext(
			long dataTypeId, long groupId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByName_G_S_PrevAndNext(
				session, dataType, groupId, name, status, orderByComparator,
				true);

			array[1] = dataType;

			array[2] = getByName_G_S_PrevAndNext(
				session, dataType, groupId, name, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByName_G_S_PrevAndNext(
		Session session, DataType dataType, long groupId, String name,
		int status, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_G_S_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindName) {
			queryPos.add(name);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the data types that the user has permission to view where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @return the matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_S(
		long groupId, String name, int status) {

		return filterFindByName_G_S(
			groupId, name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types that the user has permission to view where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_S(
		long groupId, String name, int status, int start, int end) {

		return filterFindByName_G_S(groupId, name, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types that the user has permissions to view where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_S(
		long groupId, String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByName_G_S(
				groupId, name, status, start, end, orderByComparator);
		}

		name = Objects.toString(name, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_NAME_G_S_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindName) {
				queryPos.add(name);
			}

			queryPos.add(status);

			return (List<DataType>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set of data types that the user has permission to view where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] filterFindByName_G_S_PrevAndNext(
			long dataTypeId, long groupId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByName_G_S_PrevAndNext(
				dataTypeId, groupId, name, status, orderByComparator);
		}

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = filterGetByName_G_S_PrevAndNext(
				session, dataType, groupId, name, status, orderByComparator,
				true);

			array[1] = dataType;

			array[2] = filterGetByName_G_S_PrevAndNext(
				session, dataType, groupId, name, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType filterGetByName_G_S_PrevAndNext(
		Session session, DataType dataType, long groupId, String name,
		int status, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_NAME_G_S_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindName) {
			queryPos.add(name);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where groupId = &#63; and name = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 */
	@Override
	public void removeByName_G_S(long groupId, String name, int status) {
		for (DataType dataType :
				findByName_G_S(
					groupId, name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @return the number of matching data types
	 */
	@Override
	public int countByName_G_S(long groupId, String name, int status) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName_G_S;

		Object[] finderArgs = new Object[] {groupId, name, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_G_S_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_G_S_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_G_S_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAME_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of data types that the user has permission to view where groupId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @return the number of matching data types that the user has permission to view
	 */
	@Override
	public int filterCountByName_G_S(long groupId, String name, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByName_G_S(groupId, name, status);
		}

		name = Objects.toString(name, "");

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_G_S_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindName) {
				queryPos.add(name);
			}

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_NAME_G_S_GROUPID_2 =
		"dataType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_G_S_NAME_2 =
		"dataType.name = ? AND ";

	private static final String _FINDER_COLUMN_NAME_G_S_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '') AND ";

	private static final String _FINDER_COLUMN_NAME_G_S_STATUS_2 =
		"dataType.status = ?";

	private FinderPath _finderPathWithPaginationFindByName_U_S;
	private FinderPath _finderPathWithoutPaginationFindByName_U_S;
	private FinderPath _finderPathCountByName_U_S;

	/**
	 * Returns all the data types where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByName_U_S(long userId, String name, int status) {
		return findByName_U_S(
			userId, name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByName_U_S(
		long userId, String name, int status, int start, int end) {

		return findByName_U_S(userId, name, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_U_S(
		long userId, String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByName_U_S(
			userId, name, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_U_S(
		long userId, String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName_U_S;
				finderArgs = new Object[] {userId, name, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName_U_S;
			finderArgs = new Object[] {
				userId, name, status, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((userId != dataType.getUserId()) ||
						!name.equals(dataType.getName()) ||
						(status != dataType.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_U_S_USERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_U_S_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_U_S_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAME_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_U_S_First(
			long userId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_U_S_First(
			userId, name, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_U_S_First(
		long userId, String name, int status,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByName_U_S(
			userId, name, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_U_S_Last(
			long userId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_U_S_Last(
			userId, name, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_U_S_Last(
		long userId, String name, int status,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByName_U_S(userId, name, status);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByName_U_S(
			userId, name, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByName_U_S_PrevAndNext(
			long dataTypeId, long userId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByName_U_S_PrevAndNext(
				session, dataType, userId, name, status, orderByComparator,
				true);

			array[1] = dataType;

			array[2] = getByName_U_S_PrevAndNext(
				session, dataType, userId, name, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByName_U_S_PrevAndNext(
		Session session, DataType dataType, long userId, String name,
		int status, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_U_S_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_U_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_U_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindName) {
			queryPos.add(name);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where userId = &#63; and name = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 */
	@Override
	public void removeByName_U_S(long userId, String name, int status) {
		for (DataType dataType :
				findByName_U_S(
					userId, name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @return the number of matching data types
	 */
	@Override
	public int countByName_U_S(long userId, String name, int status) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName_U_S;

		Object[] finderArgs = new Object[] {userId, name, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_U_S_USERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_U_S_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_U_S_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAME_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_U_S_USERID_2 =
		"dataType.userId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_U_S_NAME_2 =
		"dataType.name = ? AND ";

	private static final String _FINDER_COLUMN_NAME_U_S_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '') AND ";

	private static final String _FINDER_COLUMN_NAME_U_S_STATUS_2 =
		"dataType.status = ?";

	private FinderPath _finderPathWithPaginationFindByName_G_U_S;
	private FinderPath _finderPathWithoutPaginationFindByName_G_U_S;
	private FinderPath _finderPathCountByName_G_U_S;

	/**
	 * Returns all the data types where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByName_G_U_S(
		long groupId, long userId, String name, int status) {

		return findByName_G_U_S(
			groupId, userId, name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data types where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_U_S(
		long groupId, long userId, String name, int status, int start,
		int end) {

		return findByName_G_U_S(
			groupId, userId, name, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_U_S(
		long groupId, long userId, String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByName_G_U_S(
			groupId, userId, name, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByName_G_U_S(
		long groupId, long userId, String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName_G_U_S;
				finderArgs = new Object[] {groupId, userId, name, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName_G_U_S;
			finderArgs = new Object[] {
				groupId, userId, name, status, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if ((groupId != dataType.getGroupId()) ||
						(userId != dataType.getUserId()) ||
						!name.equals(dataType.getName()) ||
						(status != dataType.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_NAME_G_U_S_USERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAME_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_G_U_S_First(
			long groupId, long userId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_G_U_S_First(
			groupId, userId, name, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_G_U_S_First(
		long groupId, long userId, String name, int status,
		OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByName_G_U_S(
			groupId, userId, name, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByName_G_U_S_Last(
			long groupId, long userId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByName_G_U_S_Last(
			groupId, userId, name, status, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByName_G_U_S_Last(
		long groupId, long userId, String name, int status,
		OrderByComparator<DataType> orderByComparator) {

		int count = countByName_G_U_S(groupId, userId, name, status);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByName_G_U_S(
			groupId, userId, name, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByName_G_U_S_PrevAndNext(
			long dataTypeId, long groupId, long userId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByName_G_U_S_PrevAndNext(
				session, dataType, groupId, userId, name, status,
				orderByComparator, true);

			array[1] = dataType;

			array[2] = getByName_G_U_S_PrevAndNext(
				session, dataType, groupId, userId, name, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByName_G_U_S_PrevAndNext(
		Session session, DataType dataType, long groupId, long userId,
		String name, int status, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_NAME_G_U_S_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_G_U_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (bindName) {
			queryPos.add(name);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the data types that the user has permission to view where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @return the matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_U_S(
		long groupId, long userId, String name, int status) {

		return filterFindByName_G_U_S(
			groupId, userId, name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data types that the user has permission to view where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_U_S(
		long groupId, long userId, String name, int status, int start,
		int end) {

		return filterFindByName_G_U_S(
			groupId, userId, name, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types that the user has permissions to view where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types that the user has permission to view
	 */
	@Override
	public List<DataType> filterFindByName_G_U_S(
		long groupId, long userId, String name, int status, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByName_G_U_S(
				groupId, userId, name, status, start, end, orderByComparator);
		}

		name = Objects.toString(name, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(7);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_NAME_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_NAME_G_U_S_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			if (bindName) {
				queryPos.add(name);
			}

			queryPos.add(status);

			return (List<DataType>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set of data types that the user has permission to view where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] filterFindByName_G_U_S_PrevAndNext(
			long dataTypeId, long groupId, long userId, String name, int status,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByName_G_U_S_PrevAndNext(
				dataTypeId, groupId, userId, name, status, orderByComparator);
		}

		name = Objects.toString(name, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = filterGetByName_G_U_S_PrevAndNext(
				session, dataType, groupId, userId, name, status,
				orderByComparator, true);

			array[1] = dataType;

			array[2] = filterGetByName_G_U_S_PrevAndNext(
				session, dataType, groupId, userId, name, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType filterGetByName_G_U_S_PrevAndNext(
		Session session, DataType dataType, long groupId, long userId,
		String name, int status, OrderByComparator<DataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(7);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_NAME_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_NAME_G_U_S_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_G_U_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DataTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DataTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (bindName) {
			queryPos.add(name);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 */
	@Override
	public void removeByName_G_U_S(
		long groupId, long userId, String name, int status) {

		for (DataType dataType :
				findByName_G_U_S(
					groupId, userId, name, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @return the number of matching data types
	 */
	@Override
	public int countByName_G_U_S(
		long groupId, long userId, String name, int status) {

		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName_G_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, name, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_NAME_G_U_S_USERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_2);
			}

			sb.append(_FINDER_COLUMN_NAME_G_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of data types that the user has permission to view where groupId = &#63; and userId = &#63; and name = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param name the name
	 * @param status the status
	 * @return the number of matching data types that the user has permission to view
	 */
	@Override
	public int filterCountByName_G_U_S(
		long groupId, long userId, String name, int status) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByName_G_U_S(groupId, userId, name, status);
		}

		name = Objects.toString(name, "");

		StringBundler sb = new StringBundler(5);

		sb.append(_FILTER_SQL_COUNT_DATATYPE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_NAME_G_U_S_USERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_G_U_S_NAME_2);
		}

		sb.append(_FINDER_COLUMN_NAME_G_U_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DataType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(userId);

			if (bindName) {
				queryPos.add(name);
			}

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_NAME_G_U_S_GROUPID_2 =
		"dataType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_G_U_S_USERID_2 =
		"dataType.userId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_G_U_S_NAME_2 =
		"dataType.name = ? AND ";

	private static final String _FINDER_COLUMN_NAME_G_U_S_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '') AND ";

	private static final String _FINDER_COLUMN_NAME_G_U_S_STATUS_2 =
		"dataType.status = ?";

	private FinderPath _finderPathFetchByNameVersion;
	private FinderPath _finderPathCountByNameVersion;

	/**
	 * Returns the data type where name = &#63; and version = &#63; or throws a <code>NoSuchDataTypeException</code> if it could not be found.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByNameVersion(String name, String version)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByNameVersion(name, version);

		if (dataType == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDataTypeException(sb.toString());
		}

		return dataType;
	}

	/**
	 * Returns the data type where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByNameVersion(String name, String version) {
		return fetchByNameVersion(name, version, true);
	}

	/**
	 * Returns the data type where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByNameVersion(
		String name, String version, boolean useFinderCache) {

		name = Objects.toString(name, "");
		version = Objects.toString(version, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByNameVersion, finderArgs, this);
		}

		if (result instanceof DataType) {
			DataType dataType = (DataType)result;

			if (!Objects.equals(name, dataType.getName()) ||
				!Objects.equals(version, dataType.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEVERSION_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAMEVERSION_NAME_2);
			}

			boolean bindVersion = false;

			if (version.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				sb.append(_FINDER_COLUMN_NAMEVERSION_VERSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindVersion) {
					queryPos.add(version);
				}

				List<DataType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByNameVersion, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name, version};
							}

							_log.warn(
								"DataTypePersistenceImpl.fetchByNameVersion(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DataType dataType = list.get(0);

					result = dataType;

					cacheResult(dataType);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByNameVersion, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DataType)result;
		}
	}

	/**
	 * Removes the data type where name = &#63; and version = &#63; from the database.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the data type that was removed
	 */
	@Override
	public DataType removeByNameVersion(String name, String version)
		throws NoSuchDataTypeException {

		DataType dataType = findByNameVersion(name, version);

		return remove(dataType);
	}

	/**
	 * Returns the number of data types where name = &#63; and version = &#63;.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the number of matching data types
	 */
	@Override
	public int countByNameVersion(String name, String version) {
		name = Objects.toString(name, "");
		version = Objects.toString(version, "");

		FinderPath finderPath = _finderPathCountByNameVersion;

		Object[] finderArgs = new Object[] {name, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEVERSION_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAMEVERSION_NAME_2);
			}

			boolean bindVersion = false;

			if (version.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAMEVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				sb.append(_FINDER_COLUMN_NAMEVERSION_VERSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindVersion) {
					queryPos.add(version);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAMEVERSION_NAME_2 =
		"dataType.name = ? AND ";

	private static final String _FINDER_COLUMN_NAMEVERSION_NAME_3 =
		"(dataType.name IS NULL OR dataType.name = '') AND ";

	private static final String _FINDER_COLUMN_NAMEVERSION_VERSION_2 =
		"dataType.version = ?";

	private static final String _FINDER_COLUMN_NAMEVERSION_VERSION_3 =
		"(dataType.version IS NULL OR dataType.version = '')";

	private FinderPath _finderPathWithPaginationFindByExtension;
	private FinderPath _finderPathWithoutPaginationFindByExtension;
	private FinderPath _finderPathCountByExtension;

	/**
	 * Returns all the data types where extension = &#63;.
	 *
	 * @param extension the extension
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findByExtension(String extension) {
		return findByExtension(
			extension, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where extension = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param extension the extension
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findByExtension(
		String extension, int start, int end) {

		return findByExtension(extension, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where extension = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param extension the extension
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByExtension(
		String extension, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findByExtension(extension, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where extension = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param extension the extension
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findByExtension(
		String extension, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		extension = Objects.toString(extension, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByExtension;
				finderArgs = new Object[] {extension};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByExtension;
			finderArgs = new Object[] {
				extension, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (!extension.equals(dataType.getExtension())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindExtension = false;

			if (extension.isEmpty()) {
				sb.append(_FINDER_COLUMN_EXTENSION_EXTENSION_3);
			}
			else {
				bindExtension = true;

				sb.append(_FINDER_COLUMN_EXTENSION_EXTENSION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExtension) {
					queryPos.add(extension);
				}

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first data type in the ordered set where extension = &#63;.
	 *
	 * @param extension the extension
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByExtension_First(
			String extension, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByExtension_First(
			extension, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("extension=");
		sb.append(extension);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where extension = &#63;.
	 *
	 * @param extension the extension
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByExtension_First(
		String extension, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findByExtension(
			extension, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where extension = &#63;.
	 *
	 * @param extension the extension
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findByExtension_Last(
			String extension, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByExtension_Last(extension, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("extension=");
		sb.append(extension);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where extension = &#63;.
	 *
	 * @param extension the extension
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchByExtension_Last(
		String extension, OrderByComparator<DataType> orderByComparator) {

		int count = countByExtension(extension);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findByExtension(
			extension, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where extension = &#63;.
	 *
	 * @param dataTypeId the primary key of the current data type
	 * @param extension the extension
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findByExtension_PrevAndNext(
			long dataTypeId, String extension,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		extension = Objects.toString(extension, "");

		DataType dataType = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getByExtension_PrevAndNext(
				session, dataType, extension, orderByComparator, true);

			array[1] = dataType;

			array[2] = getByExtension_PrevAndNext(
				session, dataType, extension, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getByExtension_PrevAndNext(
		Session session, DataType dataType, String extension,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		boolean bindExtension = false;

		if (extension.isEmpty()) {
			sb.append(_FINDER_COLUMN_EXTENSION_EXTENSION_3);
		}
		else {
			bindExtension = true;

			sb.append(_FINDER_COLUMN_EXTENSION_EXTENSION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindExtension) {
			queryPos.add(extension);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where extension = &#63; from the database.
	 *
	 * @param extension the extension
	 */
	@Override
	public void removeByExtension(String extension) {
		for (DataType dataType :
				findByExtension(
					extension, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where extension = &#63;.
	 *
	 * @param extension the extension
	 * @return the number of matching data types
	 */
	@Override
	public int countByExtension(String extension) {
		extension = Objects.toString(extension, "");

		FinderPath finderPath = _finderPathCountByExtension;

		Object[] finderArgs = new Object[] {extension};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindExtension = false;

			if (extension.isEmpty()) {
				sb.append(_FINDER_COLUMN_EXTENSION_EXTENSION_3);
			}
			else {
				bindExtension = true;

				sb.append(_FINDER_COLUMN_EXTENSION_EXTENSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExtension) {
					queryPos.add(extension);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EXTENSION_EXTENSION_2 =
		"dataType.extension = ?";

	private static final String _FINDER_COLUMN_EXTENSION_EXTENSION_3 =
		"(dataType.extension IS NULL OR dataType.extension = '')";

	public DataTypePersistenceImpl() {
		setModelClass(DataType.class);

		setModelImplClass(DataTypeImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the data type in the entity cache if it is enabled.
	 *
	 * @param dataType the data type
	 */
	@Override
	public void cacheResult(DataType dataType) {
		entityCache.putResult(
			entityCacheEnabled, DataTypeImpl.class, dataType.getPrimaryKey(),
			dataType);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {dataType.getUuid(), dataType.getGroupId()}, dataType);

		finderCache.putResult(
			_finderPathFetchByNameVersion,
			new Object[] {dataType.getName(), dataType.getVersion()}, dataType);

		dataType.resetOriginalValues();
	}

	/**
	 * Caches the data types in the entity cache if it is enabled.
	 *
	 * @param dataTypes the data types
	 */
	@Override
	public void cacheResult(List<DataType> dataTypes) {
		for (DataType dataType : dataTypes) {
			if (entityCache.getResult(
					entityCacheEnabled, DataTypeImpl.class,
					dataType.getPrimaryKey()) == null) {

				cacheResult(dataType);
			}
			else {
				dataType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataType dataType) {
		entityCache.removeResult(
			entityCacheEnabled, DataTypeImpl.class, dataType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DataTypeModelImpl)dataType, true);
	}

	@Override
	public void clearCache(List<DataType> dataTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataType dataType : dataTypes) {
			entityCache.removeResult(
				entityCacheEnabled, DataTypeImpl.class,
				dataType.getPrimaryKey());

			clearUniqueFindersCache((DataTypeModelImpl)dataType, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DataTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DataTypeModelImpl dataTypeModelImpl) {

		Object[] args = new Object[] {
			dataTypeModelImpl.getUuid(), dataTypeModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dataTypeModelImpl, false);

		args = new Object[] {
			dataTypeModelImpl.getName(), dataTypeModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountByNameVersion, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByNameVersion, args, dataTypeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DataTypeModelImpl dataTypeModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				dataTypeModelImpl.getUuid(), dataTypeModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((dataTypeModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataTypeModelImpl.getOriginalUuid(),
				dataTypeModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				dataTypeModelImpl.getName(), dataTypeModelImpl.getVersion()
			};

			finderCache.removeResult(_finderPathCountByNameVersion, args);
			finderCache.removeResult(_finderPathFetchByNameVersion, args);
		}

		if ((dataTypeModelImpl.getColumnBitmask() &
			 _finderPathFetchByNameVersion.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataTypeModelImpl.getOriginalName(),
				dataTypeModelImpl.getOriginalVersion()
			};

			finderCache.removeResult(_finderPathCountByNameVersion, args);
			finderCache.removeResult(_finderPathFetchByNameVersion, args);
		}
	}

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeId the primary key for the new data type
	 * @return the new data type
	 */
	@Override
	public DataType create(long dataTypeId) {
		DataType dataType = new DataTypeImpl();

		dataType.setNew(true);
		dataType.setPrimaryKey(dataTypeId);

		String uuid = PortalUUIDUtil.generate();

		dataType.setUuid(uuid);

		dataType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dataType;
	}

	/**
	 * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the data type
	 * @return the data type that was removed
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType remove(long dataTypeId) throws NoSuchDataTypeException {
		return remove((Serializable)dataTypeId);
	}

	/**
	 * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data type
	 * @return the data type that was removed
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType remove(Serializable primaryKey)
		throws NoSuchDataTypeException {

		Session session = null;

		try {
			session = openSession();

			DataType dataType = (DataType)session.get(
				DataTypeImpl.class, primaryKey);

			if (dataType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataType);
		}
		catch (NoSuchDataTypeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DataType removeImpl(DataType dataType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataType)) {
				dataType = (DataType)session.get(
					DataTypeImpl.class, dataType.getPrimaryKeyObj());
			}

			if (dataType != null) {
				session.delete(dataType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dataType != null) {
			clearCache(dataType);
		}

		return dataType;
	}

	@Override
	public DataType updateImpl(DataType dataType) {
		boolean isNew = dataType.isNew();

		if (!(dataType instanceof DataTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dataType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataType implementation " +
					dataType.getClass());
		}

		DataTypeModelImpl dataTypeModelImpl = (DataTypeModelImpl)dataType;

		if (Validator.isNull(dataType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dataType.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dataType.getCreateDate() == null)) {
			if (serviceContext == null) {
				dataType.setCreateDate(now);
			}
			else {
				dataType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!dataTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dataType.setModifiedDate(now);
			}
			else {
				dataType.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dataType.isNew()) {
				session.save(dataType);

				dataType.setNew(false);
			}
			else {
				dataType = (DataType)session.merge(dataType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {dataTypeModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				dataTypeModelImpl.getUuid(), dataTypeModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {dataTypeModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {dataTypeModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {dataTypeModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {
				dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByG_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U, args);

			args = new Object[] {
				dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S, args);

			args = new Object[] {
				dataTypeModelImpl.getUserId(), dataTypeModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByU_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByU_S, args);

			args = new Object[] {
				dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getUserId(),
				dataTypeModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U_S, args);

			args = new Object[] {dataTypeModelImpl.getName()};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName, args);

			args = new Object[] {
				dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByName_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName_G, args);

			args = new Object[] {
				dataTypeModelImpl.getUserId(), dataTypeModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByName_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName_U, args);

			args = new Object[] {
				dataTypeModelImpl.getName(), dataTypeModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByName_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName_S, args);

			args = new Object[] {
				dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getUserId(),
				dataTypeModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByName_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName_G_U, args);

			args = new Object[] {
				dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getName(),
				dataTypeModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByName_G_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName_G_S, args);

			args = new Object[] {
				dataTypeModelImpl.getUserId(), dataTypeModelImpl.getName(),
				dataTypeModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByName_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName_U_S, args);

			args = new Object[] {
				dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getUserId(),
				dataTypeModelImpl.getName(), dataTypeModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByName_G_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName_G_U_S, args);

			args = new Object[] {dataTypeModelImpl.getExtension()};

			finderCache.removeResult(_finderPathCountByExtension, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByExtension, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {dataTypeModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalUuid(),
					dataTypeModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					dataTypeModelImpl.getUuid(),
					dataTypeModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {dataTypeModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {dataTypeModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {dataTypeModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalGroupId(),
					dataTypeModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByG_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U, args);

				args = new Object[] {
					dataTypeModelImpl.getGroupId(),
					dataTypeModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountByG_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalGroupId(),
					dataTypeModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);

				args = new Object[] {
					dataTypeModelImpl.getGroupId(),
					dataTypeModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByU_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalUserId(),
					dataTypeModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByU_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_S, args);

				args = new Object[] {
					dataTypeModelImpl.getUserId(), dataTypeModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByU_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_S, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalGroupId(),
					dataTypeModelImpl.getOriginalUserId(),
					dataTypeModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_S, args);

				args = new Object[] {
					dataTypeModelImpl.getGroupId(),
					dataTypeModelImpl.getUserId(), dataTypeModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_S, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalName()
				};

				finderCache.removeResult(_finderPathCountByName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName, args);

				args = new Object[] {dataTypeModelImpl.getName()};

				finderCache.removeResult(_finderPathCountByName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName_G.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalGroupId(),
					dataTypeModelImpl.getOriginalName()
				};

				finderCache.removeResult(_finderPathCountByName_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_G, args);

				args = new Object[] {
					dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getName()
				};

				finderCache.removeResult(_finderPathCountByName_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_G, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName_U.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalUserId(),
					dataTypeModelImpl.getOriginalName()
				};

				finderCache.removeResult(_finderPathCountByName_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_U, args);

				args = new Object[] {
					dataTypeModelImpl.getUserId(), dataTypeModelImpl.getName()
				};

				finderCache.removeResult(_finderPathCountByName_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_U, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalName(),
					dataTypeModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByName_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_S, args);

				args = new Object[] {
					dataTypeModelImpl.getName(), dataTypeModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByName_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_S, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName_G_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalGroupId(),
					dataTypeModelImpl.getOriginalUserId(),
					dataTypeModelImpl.getOriginalName()
				};

				finderCache.removeResult(_finderPathCountByName_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_G_U, args);

				args = new Object[] {
					dataTypeModelImpl.getGroupId(),
					dataTypeModelImpl.getUserId(), dataTypeModelImpl.getName()
				};

				finderCache.removeResult(_finderPathCountByName_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_G_U, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName_G_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalGroupId(),
					dataTypeModelImpl.getOriginalName(),
					dataTypeModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByName_G_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_G_S, args);

				args = new Object[] {
					dataTypeModelImpl.getGroupId(), dataTypeModelImpl.getName(),
					dataTypeModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByName_G_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_G_S, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName_U_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalUserId(),
					dataTypeModelImpl.getOriginalName(),
					dataTypeModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByName_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_U_S, args);

				args = new Object[] {
					dataTypeModelImpl.getUserId(), dataTypeModelImpl.getName(),
					dataTypeModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByName_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_U_S, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName_G_U_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalGroupId(),
					dataTypeModelImpl.getOriginalUserId(),
					dataTypeModelImpl.getOriginalName(),
					dataTypeModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByName_G_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_G_U_S, args);

				args = new Object[] {
					dataTypeModelImpl.getGroupId(),
					dataTypeModelImpl.getUserId(), dataTypeModelImpl.getName(),
					dataTypeModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByName_G_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName_G_U_S, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByExtension.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalExtension()
				};

				finderCache.removeResult(_finderPathCountByExtension, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExtension, args);

				args = new Object[] {dataTypeModelImpl.getExtension()};

				finderCache.removeResult(_finderPathCountByExtension, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByExtension, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DataTypeImpl.class, dataType.getPrimaryKey(),
			dataType, false);

		clearUniqueFindersCache(dataTypeModelImpl, false);
		cacheUniqueFindersCache(dataTypeModelImpl);

		dataType.resetOriginalValues();

		return dataType;
	}

	/**
	 * Returns the data type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data type
	 * @return the data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByPrimaryKey(primaryKey);

		if (dataType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataType;
	}

	/**
	 * Returns the data type with the primary key or throws a <code>NoSuchDataTypeException</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the data type
	 * @return the data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType findByPrimaryKey(long dataTypeId)
		throws NoSuchDataTypeException {

		return findByPrimaryKey((Serializable)dataTypeId);
	}

	/**
	 * Returns the data type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the data type
	 * @return the data type, or <code>null</code> if a data type with the primary key could not be found
	 */
	@Override
	public DataType fetchByPrimaryKey(long dataTypeId) {
		return fetchByPrimaryKey((Serializable)dataTypeId);
	}

	/**
	 * Returns all the data types.
	 *
	 * @return the data types
	 */
	@Override
	public List<DataType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of data types
	 */
	@Override
	public List<DataType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data types
	 */
	@Override
	public List<DataType> findAll(
		int start, int end, OrderByComparator<DataType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data types
	 */
	@Override
	public List<DataType> findAll(
		int start, int end, OrderByComparator<DataType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATATYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATATYPE;

				sql = sql.concat(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the data types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataType dataType : findAll()) {
			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DATATYPE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
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
		return "dataTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATATYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data type persistence.
	 */
	@Activate
	public void activate() {
		DataTypeModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataTypeModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			DataTypeModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			DataTypeModelImpl.UUID_COLUMN_BITMASK |
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			DataTypeModelImpl.UUID_COLUMN_BITMASK |
			DataTypeModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			DataTypeModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			DataTypeModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK |
			DataTypeModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK |
			DataTypeModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			DataTypeModelImpl.USERID_COLUMN_BITMASK |
			DataTypeModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK |
			DataTypeModelImpl.USERID_COLUMN_BITMASK |
			DataTypeModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()},
			DataTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByName_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName_G",
			new String[] {Long.class.getName(), String.class.getName()},
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK |
			DataTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByName_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName_G",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByName_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName_U",
			new String[] {Long.class.getName(), String.class.getName()},
			DataTypeModelImpl.USERID_COLUMN_BITMASK |
			DataTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByName_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName_U",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByName_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName_S",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName_S",
			new String[] {String.class.getName(), Integer.class.getName()},
			DataTypeModelImpl.NAME_COLUMN_BITMASK |
			DataTypeModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByName_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName_S",
			new String[] {String.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByName_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK |
			DataTypeModelImpl.USERID_COLUMN_BITMASK |
			DataTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByName_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByName_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName_G_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName_G_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK |
			DataTypeModelImpl.NAME_COLUMN_BITMASK |
			DataTypeModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByName_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName_G_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByName_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName_U_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName_U_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			DataTypeModelImpl.USERID_COLUMN_BITMASK |
			DataTypeModelImpl.NAME_COLUMN_BITMASK |
			DataTypeModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByName_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName_U_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByName_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			},
			DataTypeModelImpl.GROUPID_COLUMN_BITMASK |
			DataTypeModelImpl.USERID_COLUMN_BITMASK |
			DataTypeModelImpl.NAME_COLUMN_BITMASK |
			DataTypeModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByName_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

		_finderPathFetchByNameVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNameVersion",
			new String[] {String.class.getName(), String.class.getName()},
			DataTypeModelImpl.NAME_COLUMN_BITMASK |
			DataTypeModelImpl.VERSION_COLUMN_BITMASK);

		_finderPathCountByNameVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameVersion",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByExtension = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExtension",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByExtension = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExtension",
			new String[] {String.class.getName()},
			DataTypeModelImpl.EXTENSION_COLUMN_BITMASK);

		_finderPathCountByExtension = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExtension",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataTypeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ICECAPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.osp.icecap.model.DataType"),
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

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DATATYPE =
		"SELECT dataType FROM DataType dataType";

	private static final String _SQL_SELECT_DATATYPE_WHERE =
		"SELECT dataType FROM DataType dataType WHERE ";

	private static final String _SQL_COUNT_DATATYPE =
		"SELECT COUNT(dataType) FROM DataType dataType";

	private static final String _SQL_COUNT_DATATYPE_WHERE =
		"SELECT COUNT(dataType) FROM DataType dataType WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"dataType.dataTypeId";

	private static final String _FILTER_SQL_SELECT_DATATYPE_WHERE =
		"SELECT DISTINCT {dataType.*} FROM ICECAP_DataType dataType WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {ICECAP_DataType.*} FROM (SELECT DISTINCT dataType.dataTypeId FROM ICECAP_DataType dataType WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DATATYPE_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN ICECAP_DataType ON TEMP_TABLE.dataTypeId = ICECAP_DataType.dataTypeId";

	private static final String _FILTER_SQL_COUNT_DATATYPE_WHERE =
		"SELECT COUNT(DISTINCT dataType.dataTypeId) AS COUNT_VALUE FROM ICECAP_DataType dataType WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "dataType";

	private static final String _FILTER_ENTITY_TABLE = "ICECAP_DataType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataType.";

	private static final String _ORDER_BY_ENTITY_TABLE = "ICECAP_DataType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(ICECAPPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}