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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.osp.icecap.exception.NoSuchDataTypeVisualizerLinkException;
import com.osp.icecap.model.DataTypeVisualizerLink;
import com.osp.icecap.model.impl.DataTypeVisualizerLinkImpl;
import com.osp.icecap.model.impl.DataTypeVisualizerLinkModelImpl;
import com.osp.icecap.service.persistence.DataTypeVisualizerLinkPersistence;
import com.osp.icecap.service.persistence.impl.constants.ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the data type visualizer link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = DataTypeVisualizerLinkPersistence.class)
public class DataTypeVisualizerLinkPersistenceImpl
	extends BasePersistenceImpl<DataTypeVisualizerLink>
	implements DataTypeVisualizerLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataTypeVisualizerLinkUtil</code> to access the data type visualizer link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataTypeVisualizerLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByVisualizerName;
	private FinderPath _finderPathWithoutPaginationFindByVisualizerName;
	private FinderPath _finderPathCountByVisualizerName;

	/**
	 * Returns all the data type visualizer links where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @return the matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByVisualizerName(
		String visualizerName) {

		return findByVisualizerName(
			visualizerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data type visualizer links where visualizerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerName the visualizer name
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByVisualizerName(
		String visualizerName, int start, int end) {

		return findByVisualizerName(visualizerName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links where visualizerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerName the visualizer name
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByVisualizerName(
		String visualizerName, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return findByVisualizerName(
			visualizerName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links where visualizerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerName the visualizer name
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByVisualizerName(
		String visualizerName, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean useFinderCache) {

		visualizerName = Objects.toString(visualizerName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVisualizerName;
				finderArgs = new Object[] {visualizerName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVisualizerName;
			finderArgs = new Object[] {
				visualizerName, start, end, orderByComparator
			};
		}

		List<DataTypeVisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<DataTypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataTypeVisualizerLink dataTypeVisualizerLink : list) {
					if (!visualizerName.equals(
							dataTypeVisualizerLink.getVisualizerName())) {

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

			sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			boolean bindVisualizerName = false;

			if (visualizerName.isEmpty()) {
				sb.append(_FINDER_COLUMN_VISUALIZERNAME_VISUALIZERNAME_3);
			}
			else {
				bindVisualizerName = true;

				sb.append(_FINDER_COLUMN_VISUALIZERNAME_VISUALIZERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVisualizerName) {
					queryPos.add(visualizerName);
				}

				list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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
	 * Returns the first data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByVisualizerName_First(
			String visualizerName,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink =
			fetchByVisualizerName_First(visualizerName, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visualizerName=");
		sb.append(visualizerName);

		sb.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByVisualizerName_First(
		String visualizerName,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		List<DataTypeVisualizerLink> list = findByVisualizerName(
			visualizerName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByVisualizerName_Last(
			String visualizerName,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink =
			fetchByVisualizerName_Last(visualizerName, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visualizerName=");
		sb.append(visualizerName);

		sb.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByVisualizerName_Last(
		String visualizerName,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		int count = countByVisualizerName(visualizerName);

		if (count == 0) {
			return null;
		}

		List<DataTypeVisualizerLink> list = findByVisualizerName(
			visualizerName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DataTypeVisualizerLink[] findByVisualizerName_PrevAndNext(
			long dataTypeVisualizerLinkId, String visualizerName,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		visualizerName = Objects.toString(visualizerName, "");

		DataTypeVisualizerLink dataTypeVisualizerLink = findByPrimaryKey(
			dataTypeVisualizerLinkId);

		Session session = null;

		try {
			session = openSession();

			DataTypeVisualizerLink[] array = new DataTypeVisualizerLinkImpl[3];

			array[0] = getByVisualizerName_PrevAndNext(
				session, dataTypeVisualizerLink, visualizerName,
				orderByComparator, true);

			array[1] = dataTypeVisualizerLink;

			array[2] = getByVisualizerName_PrevAndNext(
				session, dataTypeVisualizerLink, visualizerName,
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

	protected DataTypeVisualizerLink getByVisualizerName_PrevAndNext(
		Session session, DataTypeVisualizerLink dataTypeVisualizerLink,
		String visualizerName,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

		boolean bindVisualizerName = false;

		if (visualizerName.isEmpty()) {
			sb.append(_FINDER_COLUMN_VISUALIZERNAME_VISUALIZERNAME_3);
		}
		else {
			bindVisualizerName = true;

			sb.append(_FINDER_COLUMN_VISUALIZERNAME_VISUALIZERNAME_2);
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
			sb.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindVisualizerName) {
			queryPos.add(visualizerName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataTypeVisualizerLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataTypeVisualizerLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data type visualizer links where visualizerName = &#63; from the database.
	 *
	 * @param visualizerName the visualizer name
	 */
	@Override
	public void removeByVisualizerName(String visualizerName) {
		for (DataTypeVisualizerLink dataTypeVisualizerLink :
				findByVisualizerName(
					visualizerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataTypeVisualizerLink);
		}
	}

	/**
	 * Returns the number of data type visualizer links where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @return the number of matching data type visualizer links
	 */
	@Override
	public int countByVisualizerName(String visualizerName) {
		visualizerName = Objects.toString(visualizerName, "");

		FinderPath finderPath = _finderPathCountByVisualizerName;

		Object[] finderArgs = new Object[] {visualizerName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			boolean bindVisualizerName = false;

			if (visualizerName.isEmpty()) {
				sb.append(_FINDER_COLUMN_VISUALIZERNAME_VISUALIZERNAME_3);
			}
			else {
				bindVisualizerName = true;

				sb.append(_FINDER_COLUMN_VISUALIZERNAME_VISUALIZERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVisualizerName) {
					queryPos.add(visualizerName);
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

	private static final String _FINDER_COLUMN_VISUALIZERNAME_VISUALIZERNAME_2 =
		"dataTypeVisualizerLink.visualizerName = ?";

	private static final String _FINDER_COLUMN_VISUALIZERNAME_VISUALIZERNAME_3 =
		"(dataTypeVisualizerLink.visualizerName IS NULL OR dataTypeVisualizerLink.visualizerName = '')";

	private FinderPath _finderPathFetchByVisualizerNameVersion;
	private FinderPath _finderPathCountByVisualizerNameVersion;

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or throws a <code>NoSuchDataTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByVisualizerNameVersion(
			String visualizerName, String visualizerVersion)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink =
			fetchByVisualizerNameVersion(visualizerName, visualizerVersion);

		if (dataTypeVisualizerLink == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("visualizerName=");
			sb.append(visualizerName);

			sb.append(", visualizerVersion=");
			sb.append(visualizerVersion);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
		}

		return dataTypeVisualizerLink;
	}

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByVisualizerNameVersion(
		String visualizerName, String visualizerVersion) {

		return fetchByVisualizerNameVersion(
			visualizerName, visualizerVersion, true);
	}

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByVisualizerNameVersion(
		String visualizerName, String visualizerVersion,
		boolean useFinderCache) {

		visualizerName = Objects.toString(visualizerName, "");
		visualizerVersion = Objects.toString(visualizerVersion, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {visualizerName, visualizerVersion};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByVisualizerNameVersion, finderArgs, this);
		}

		if (result instanceof DataTypeVisualizerLink) {
			DataTypeVisualizerLink dataTypeVisualizerLink =
				(DataTypeVisualizerLink)result;

			if (!Objects.equals(
					visualizerName,
					dataTypeVisualizerLink.getVisualizerName()) ||
				!Objects.equals(
					visualizerVersion,
					dataTypeVisualizerLink.getVisualizerVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			boolean bindVisualizerName = false;

			if (visualizerName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERNAME_3);
			}
			else {
				bindVisualizerName = true;

				sb.append(
					_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERNAME_2);
			}

			boolean bindVisualizerVersion = false;

			if (visualizerVersion.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERVERSION_3);
			}
			else {
				bindVisualizerVersion = true;

				sb.append(
					_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERVERSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVisualizerName) {
					queryPos.add(visualizerName);
				}

				if (bindVisualizerVersion) {
					queryPos.add(visualizerVersion);
				}

				List<DataTypeVisualizerLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByVisualizerNameVersion, finderArgs,
							list);
					}
				}
				else {
					DataTypeVisualizerLink dataTypeVisualizerLink = list.get(0);

					result = dataTypeVisualizerLink;

					cacheResult(dataTypeVisualizerLink);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByVisualizerNameVersion, finderArgs);
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
			return (DataTypeVisualizerLink)result;
		}
	}

	/**
	 * Removes the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; from the database.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the data type visualizer link that was removed
	 */
	@Override
	public DataTypeVisualizerLink removeByVisualizerNameVersion(
			String visualizerName, String visualizerVersion)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink =
			findByVisualizerNameVersion(visualizerName, visualizerVersion);

		return remove(dataTypeVisualizerLink);
	}

	/**
	 * Returns the number of data type visualizer links where visualizerName = &#63; and visualizerVersion = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the number of matching data type visualizer links
	 */
	@Override
	public int countByVisualizerNameVersion(
		String visualizerName, String visualizerVersion) {

		visualizerName = Objects.toString(visualizerName, "");
		visualizerVersion = Objects.toString(visualizerVersion, "");

		FinderPath finderPath = _finderPathCountByVisualizerNameVersion;

		Object[] finderArgs = new Object[] {visualizerName, visualizerVersion};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			boolean bindVisualizerName = false;

			if (visualizerName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERNAME_3);
			}
			else {
				bindVisualizerName = true;

				sb.append(
					_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERNAME_2);
			}

			boolean bindVisualizerVersion = false;

			if (visualizerVersion.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERVERSION_3);
			}
			else {
				bindVisualizerVersion = true;

				sb.append(
					_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERVERSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVisualizerName) {
					queryPos.add(visualizerName);
				}

				if (bindVisualizerVersion) {
					queryPos.add(visualizerVersion);
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

	private static final String
		_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERNAME_2 =
			"dataTypeVisualizerLink.visualizerName = ? AND ";

	private static final String
		_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERNAME_3 =
			"(dataTypeVisualizerLink.visualizerName IS NULL OR dataTypeVisualizerLink.visualizerName = '') AND ";

	private static final String
		_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERVERSION_2 =
			"dataTypeVisualizerLink.visualizerVersion = ?";

	private static final String
		_FINDER_COLUMN_VISUALIZERNAMEVERSION_VISUALIZERVERSION_3 =
			"(dataTypeVisualizerLink.visualizerVersion IS NULL OR dataTypeVisualizerLink.visualizerVersion = '')";

	private FinderPath _finderPathWithPaginationFindByEditable;
	private FinderPath _finderPathWithoutPaginationFindByEditable;
	private FinderPath _finderPathCountByEditable;

	/**
	 * Returns all the data type visualizer links where editable = &#63;.
	 *
	 * @param editable the editable
	 * @return the matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByEditable(boolean editable) {
		return findByEditable(
			editable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data type visualizer links where editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end) {

		return findByEditable(editable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links where editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return findByEditable(editable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links where editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEditable;
				finderArgs = new Object[] {editable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEditable;
			finderArgs = new Object[] {editable, start, end, orderByComparator};
		}

		List<DataTypeVisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<DataTypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataTypeVisualizerLink dataTypeVisualizerLink : list) {
					if (editable != dataTypeVisualizerLink.isEditable()) {
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

			sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_EDITABLE_EDITABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(editable);

				list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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
	 * Returns the first data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByEditable_First(
			boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = fetchByEditable_First(
			editable, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("editable=");
		sb.append(editable);

		sb.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByEditable_First(
		boolean editable,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		List<DataTypeVisualizerLink> list = findByEditable(
			editable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByEditable_Last(
			boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = fetchByEditable_Last(
			editable, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("editable=");
		sb.append(editable);

		sb.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where editable = &#63;.
	 *
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByEditable_Last(
		boolean editable,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		int count = countByEditable(editable);

		if (count == 0) {
			return null;
		}

		List<DataTypeVisualizerLink> list = findByEditable(
			editable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DataTypeVisualizerLink[] findByEditable_PrevAndNext(
			long dataTypeVisualizerLinkId, boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = findByPrimaryKey(
			dataTypeVisualizerLinkId);

		Session session = null;

		try {
			session = openSession();

			DataTypeVisualizerLink[] array = new DataTypeVisualizerLinkImpl[3];

			array[0] = getByEditable_PrevAndNext(
				session, dataTypeVisualizerLink, editable, orderByComparator,
				true);

			array[1] = dataTypeVisualizerLink;

			array[2] = getByEditable_PrevAndNext(
				session, dataTypeVisualizerLink, editable, orderByComparator,
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

	protected DataTypeVisualizerLink getByEditable_PrevAndNext(
		Session session, DataTypeVisualizerLink dataTypeVisualizerLink,
		boolean editable,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

		sb.append(_FINDER_COLUMN_EDITABLE_EDITABLE_2);

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
			sb.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(editable);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataTypeVisualizerLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataTypeVisualizerLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data type visualizer links where editable = &#63; from the database.
	 *
	 * @param editable the editable
	 */
	@Override
	public void removeByEditable(boolean editable) {
		for (DataTypeVisualizerLink dataTypeVisualizerLink :
				findByEditable(
					editable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataTypeVisualizerLink);
		}
	}

	/**
	 * Returns the number of data type visualizer links where editable = &#63;.
	 *
	 * @param editable the editable
	 * @return the number of matching data type visualizer links
	 */
	@Override
	public int countByEditable(boolean editable) {
		FinderPath finderPath = _finderPathCountByEditable;

		Object[] finderArgs = new Object[] {editable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_EDITABLE_EDITABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(editable);

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

	private static final String _FINDER_COLUMN_EDITABLE_EDITABLE_2 =
		"dataTypeVisualizerLink.editable = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId;
	private FinderPath _finderPathCountByDataTypeId;

	/**
	 * Returns all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeId(long dataTypeId) {
		return findByDataTypeId(
			dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return findByDataTypeId(dataTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return findByDataTypeId(
			dataTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId;
				finderArgs = new Object[] {dataTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId;
			finderArgs = new Object[] {
				dataTypeId, start, end, orderByComparator
			};
		}

		List<DataTypeVisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<DataTypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataTypeVisualizerLink dataTypeVisualizerLink : list) {
					if (dataTypeId != dataTypeVisualizerLink.getDataTypeId()) {
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

			sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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
	 * Returns the first data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = fetchByDataTypeId_First(
			dataTypeId, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByDataTypeId_First(
		long dataTypeId,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		List<DataTypeVisualizerLink> list = findByDataTypeId(
			dataTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByDataTypeId_Last(
		long dataTypeId,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		int count = countByDataTypeId(dataTypeId);

		if (count == 0) {
			return null;
		}

		List<DataTypeVisualizerLink> list = findByDataTypeId(
			dataTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DataTypeVisualizerLink[] findByDataTypeId_PrevAndNext(
			long dataTypeVisualizerLinkId, long dataTypeId,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = findByPrimaryKey(
			dataTypeVisualizerLinkId);

		Session session = null;

		try {
			session = openSession();

			DataTypeVisualizerLink[] array = new DataTypeVisualizerLinkImpl[3];

			array[0] = getByDataTypeId_PrevAndNext(
				session, dataTypeVisualizerLink, dataTypeId, orderByComparator,
				true);

			array[1] = dataTypeVisualizerLink;

			array[2] = getByDataTypeId_PrevAndNext(
				session, dataTypeVisualizerLink, dataTypeId, orderByComparator,
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

	protected DataTypeVisualizerLink getByDataTypeId_PrevAndNext(
		Session session, DataTypeVisualizerLink dataTypeVisualizerLink,
		long dataTypeId,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

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
			sb.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataTypeVisualizerLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataTypeVisualizerLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data type visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	@Override
	public void removeByDataTypeId(long dataTypeId) {
		for (DataTypeVisualizerLink dataTypeVisualizerLink :
				findByDataTypeId(
					dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataTypeVisualizerLink);
		}
	}

	/**
	 * Returns the number of data type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching data type visualizer links
	 */
	@Override
	public int countByDataTypeId(long dataTypeId) {
		FinderPath finderPath = _finderPathCountByDataTypeId;

		Object[] finderArgs = new Object[] {dataTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

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

	private static final String _FINDER_COLUMN_DATATYPEID_DATATYPEID_2 =
		"dataTypeVisualizerLink.dataTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeIdEditable;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeIdEditable;
	private FinderPath _finderPathCountByDataTypeIdEditable;

	/**
	 * Returns all the data type visualizer links where dataTypeId = &#63; and editable = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @return the matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeIdEditable(
		long dataTypeId, boolean editable) {

		return findByDataTypeIdEditable(
			dataTypeId, editable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data type visualizer links where dataTypeId = &#63; and editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeIdEditable(
		long dataTypeId, boolean editable, int start, int end) {

		return findByDataTypeIdEditable(dataTypeId, editable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links where dataTypeId = &#63; and editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeIdEditable(
		long dataTypeId, boolean editable, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return findByDataTypeIdEditable(
			dataTypeId, editable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links where dataTypeId = &#63; and editable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeIdEditable(
		long dataTypeId, boolean editable, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDataTypeIdEditable;
				finderArgs = new Object[] {dataTypeId, editable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeIdEditable;
			finderArgs = new Object[] {
				dataTypeId, editable, start, end, orderByComparator
			};
		}

		List<DataTypeVisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<DataTypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataTypeVisualizerLink dataTypeVisualizerLink : list) {
					if ((dataTypeId !=
							dataTypeVisualizerLink.getDataTypeId()) ||
						(editable != dataTypeVisualizerLink.isEditable())) {

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

			sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEIDEDITABLE_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEIDEDITABLE_EDITABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(editable);

				list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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
	 * Returns the first data type visualizer link in the ordered set where dataTypeId = &#63; and editable = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByDataTypeIdEditable_First(
			long dataTypeId, boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink =
			fetchByDataTypeIdEditable_First(
				dataTypeId, editable, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", editable=");
		sb.append(editable);

		sb.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where dataTypeId = &#63; and editable = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByDataTypeIdEditable_First(
		long dataTypeId, boolean editable,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		List<DataTypeVisualizerLink> list = findByDataTypeIdEditable(
			dataTypeId, editable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where dataTypeId = &#63; and editable = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByDataTypeIdEditable_Last(
			long dataTypeId, boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink =
			fetchByDataTypeIdEditable_Last(
				dataTypeId, editable, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", editable=");
		sb.append(editable);

		sb.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where dataTypeId = &#63; and editable = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByDataTypeIdEditable_Last(
		long dataTypeId, boolean editable,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		int count = countByDataTypeIdEditable(dataTypeId, editable);

		if (count == 0) {
			return null;
		}

		List<DataTypeVisualizerLink> list = findByDataTypeIdEditable(
			dataTypeId, editable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data type visualizer links before and after the current data type visualizer link in the ordered set where dataTypeId = &#63; and editable = &#63;.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the current data type visualizer link
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	@Override
	public DataTypeVisualizerLink[] findByDataTypeIdEditable_PrevAndNext(
			long dataTypeVisualizerLinkId, long dataTypeId, boolean editable,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = findByPrimaryKey(
			dataTypeVisualizerLinkId);

		Session session = null;

		try {
			session = openSession();

			DataTypeVisualizerLink[] array = new DataTypeVisualizerLinkImpl[3];

			array[0] = getByDataTypeIdEditable_PrevAndNext(
				session, dataTypeVisualizerLink, dataTypeId, editable,
				orderByComparator, true);

			array[1] = dataTypeVisualizerLink;

			array[2] = getByDataTypeIdEditable_PrevAndNext(
				session, dataTypeVisualizerLink, dataTypeId, editable,
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

	protected DataTypeVisualizerLink getByDataTypeIdEditable_PrevAndNext(
		Session session, DataTypeVisualizerLink dataTypeVisualizerLink,
		long dataTypeId, boolean editable,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEIDEDITABLE_DATATYPEID_2);

		sb.append(_FINDER_COLUMN_DATATYPEIDEDITABLE_EDITABLE_2);

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
			sb.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		queryPos.add(editable);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataTypeVisualizerLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataTypeVisualizerLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data type visualizer links where dataTypeId = &#63; and editable = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 */
	@Override
	public void removeByDataTypeIdEditable(long dataTypeId, boolean editable) {
		for (DataTypeVisualizerLink dataTypeVisualizerLink :
				findByDataTypeIdEditable(
					dataTypeId, editable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataTypeVisualizerLink);
		}
	}

	/**
	 * Returns the number of data type visualizer links where dataTypeId = &#63; and editable = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param editable the editable
	 * @return the number of matching data type visualizer links
	 */
	@Override
	public int countByDataTypeIdEditable(long dataTypeId, boolean editable) {
		FinderPath finderPath = _finderPathCountByDataTypeIdEditable;

		Object[] finderArgs = new Object[] {dataTypeId, editable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEIDEDITABLE_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEIDEDITABLE_EDITABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(editable);

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

	private static final String _FINDER_COLUMN_DATATYPEIDEDITABLE_DATATYPEID_2 =
		"dataTypeVisualizerLink.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEIDEDITABLE_EDITABLE_2 =
		"dataTypeVisualizerLink.editable = ?";

	public DataTypeVisualizerLinkPersistenceImpl() {
		setModelClass(DataTypeVisualizerLink.class);

		setModelImplClass(DataTypeVisualizerLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the data type visualizer link in the entity cache if it is enabled.
	 *
	 * @param dataTypeVisualizerLink the data type visualizer link
	 */
	@Override
	public void cacheResult(DataTypeVisualizerLink dataTypeVisualizerLink) {
		entityCache.putResult(
			entityCacheEnabled, DataTypeVisualizerLinkImpl.class,
			dataTypeVisualizerLink.getPrimaryKey(), dataTypeVisualizerLink);

		finderCache.putResult(
			_finderPathFetchByVisualizerNameVersion,
			new Object[] {
				dataTypeVisualizerLink.getVisualizerName(),
				dataTypeVisualizerLink.getVisualizerVersion()
			},
			dataTypeVisualizerLink);

		dataTypeVisualizerLink.resetOriginalValues();
	}

	/**
	 * Caches the data type visualizer links in the entity cache if it is enabled.
	 *
	 * @param dataTypeVisualizerLinks the data type visualizer links
	 */
	@Override
	public void cacheResult(
		List<DataTypeVisualizerLink> dataTypeVisualizerLinks) {

		for (DataTypeVisualizerLink dataTypeVisualizerLink :
				dataTypeVisualizerLinks) {

			if (entityCache.getResult(
					entityCacheEnabled, DataTypeVisualizerLinkImpl.class,
					dataTypeVisualizerLink.getPrimaryKey()) == null) {

				cacheResult(dataTypeVisualizerLink);
			}
			else {
				dataTypeVisualizerLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data type visualizer links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataTypeVisualizerLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data type visualizer link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataTypeVisualizerLink dataTypeVisualizerLink) {
		entityCache.removeResult(
			entityCacheEnabled, DataTypeVisualizerLinkImpl.class,
			dataTypeVisualizerLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(DataTypeVisualizerLinkModelImpl)dataTypeVisualizerLink, true);
	}

	@Override
	public void clearCache(
		List<DataTypeVisualizerLink> dataTypeVisualizerLinks) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataTypeVisualizerLink dataTypeVisualizerLink :
				dataTypeVisualizerLinks) {

			entityCache.removeResult(
				entityCacheEnabled, DataTypeVisualizerLinkImpl.class,
				dataTypeVisualizerLink.getPrimaryKey());

			clearUniqueFindersCache(
				(DataTypeVisualizerLinkModelImpl)dataTypeVisualizerLink, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DataTypeVisualizerLinkImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DataTypeVisualizerLinkModelImpl dataTypeVisualizerLinkModelImpl) {

		Object[] args = new Object[] {
			dataTypeVisualizerLinkModelImpl.getVisualizerName(),
			dataTypeVisualizerLinkModelImpl.getVisualizerVersion()
		};

		finderCache.putResult(
			_finderPathCountByVisualizerNameVersion, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByVisualizerNameVersion, args,
			dataTypeVisualizerLinkModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DataTypeVisualizerLinkModelImpl dataTypeVisualizerLinkModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				dataTypeVisualizerLinkModelImpl.getVisualizerName(),
				dataTypeVisualizerLinkModelImpl.getVisualizerVersion()
			};

			finderCache.removeResult(
				_finderPathCountByVisualizerNameVersion, args);
			finderCache.removeResult(
				_finderPathFetchByVisualizerNameVersion, args);
		}

		if ((dataTypeVisualizerLinkModelImpl.getColumnBitmask() &
			 _finderPathFetchByVisualizerNameVersion.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataTypeVisualizerLinkModelImpl.getOriginalVisualizerName(),
				dataTypeVisualizerLinkModelImpl.getOriginalVisualizerVersion()
			};

			finderCache.removeResult(
				_finderPathCountByVisualizerNameVersion, args);
			finderCache.removeResult(
				_finderPathFetchByVisualizerNameVersion, args);
		}
	}

	/**
	 * Creates a new data type visualizer link with the primary key. Does not add the data type visualizer link to the database.
	 *
	 * @param dataTypeVisualizerLinkId the primary key for the new data type visualizer link
	 * @return the new data type visualizer link
	 */
	@Override
	public DataTypeVisualizerLink create(long dataTypeVisualizerLinkId) {
		DataTypeVisualizerLink dataTypeVisualizerLink =
			new DataTypeVisualizerLinkImpl();

		dataTypeVisualizerLink.setNew(true);
		dataTypeVisualizerLink.setPrimaryKey(dataTypeVisualizerLinkId);

		return dataTypeVisualizerLink;
	}

	/**
	 * Removes the data type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link that was removed
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	@Override
	public DataTypeVisualizerLink remove(long dataTypeVisualizerLinkId)
		throws NoSuchDataTypeVisualizerLinkException {

		return remove((Serializable)dataTypeVisualizerLinkId);
	}

	/**
	 * Removes the data type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data type visualizer link
	 * @return the data type visualizer link that was removed
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	@Override
	public DataTypeVisualizerLink remove(Serializable primaryKey)
		throws NoSuchDataTypeVisualizerLinkException {

		Session session = null;

		try {
			session = openSession();

			DataTypeVisualizerLink dataTypeVisualizerLink =
				(DataTypeVisualizerLink)session.get(
					DataTypeVisualizerLinkImpl.class, primaryKey);

			if (dataTypeVisualizerLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataTypeVisualizerLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataTypeVisualizerLink);
		}
		catch (NoSuchDataTypeVisualizerLinkException noSuchEntityException) {
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
	protected DataTypeVisualizerLink removeImpl(
		DataTypeVisualizerLink dataTypeVisualizerLink) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataTypeVisualizerLink)) {
				dataTypeVisualizerLink = (DataTypeVisualizerLink)session.get(
					DataTypeVisualizerLinkImpl.class,
					dataTypeVisualizerLink.getPrimaryKeyObj());
			}

			if (dataTypeVisualizerLink != null) {
				session.delete(dataTypeVisualizerLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dataTypeVisualizerLink != null) {
			clearCache(dataTypeVisualizerLink);
		}

		return dataTypeVisualizerLink;
	}

	@Override
	public DataTypeVisualizerLink updateImpl(
		DataTypeVisualizerLink dataTypeVisualizerLink) {

		boolean isNew = dataTypeVisualizerLink.isNew();

		if (!(dataTypeVisualizerLink instanceof
				DataTypeVisualizerLinkModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataTypeVisualizerLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dataTypeVisualizerLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataTypeVisualizerLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataTypeVisualizerLink implementation " +
					dataTypeVisualizerLink.getClass());
		}

		DataTypeVisualizerLinkModelImpl dataTypeVisualizerLinkModelImpl =
			(DataTypeVisualizerLinkModelImpl)dataTypeVisualizerLink;

		Session session = null;

		try {
			session = openSession();

			if (dataTypeVisualizerLink.isNew()) {
				session.save(dataTypeVisualizerLink);

				dataTypeVisualizerLink.setNew(false);
			}
			else {
				dataTypeVisualizerLink = (DataTypeVisualizerLink)session.merge(
					dataTypeVisualizerLink);
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
			Object[] args = new Object[] {
				dataTypeVisualizerLinkModelImpl.getVisualizerName()
			};

			finderCache.removeResult(_finderPathCountByVisualizerName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVisualizerName, args);

			args = new Object[] {dataTypeVisualizerLinkModelImpl.isEditable()};

			finderCache.removeResult(_finderPathCountByEditable, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByEditable, args);

			args = new Object[] {
				dataTypeVisualizerLinkModelImpl.getDataTypeId()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId, args);

			args = new Object[] {
				dataTypeVisualizerLinkModelImpl.getDataTypeId(),
				dataTypeVisualizerLinkModelImpl.isEditable()
			};

			finderCache.removeResult(
				_finderPathCountByDataTypeIdEditable, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeIdEditable, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataTypeVisualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVisualizerName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getOriginalVisualizerName()
				};

				finderCache.removeResult(
					_finderPathCountByVisualizerName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVisualizerName, args);

				args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getVisualizerName()
				};

				finderCache.removeResult(
					_finderPathCountByVisualizerName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVisualizerName, args);
			}

			if ((dataTypeVisualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByEditable.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getOriginalEditable()
				};

				finderCache.removeResult(_finderPathCountByEditable, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEditable, args);

				args = new Object[] {
					dataTypeVisualizerLinkModelImpl.isEditable()
				};

				finderCache.removeResult(_finderPathCountByEditable, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEditable, args);
			}

			if ((dataTypeVisualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getOriginalDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);

				args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);
			}

			if ((dataTypeVisualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeIdEditable.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getOriginalDataTypeId(),
					dataTypeVisualizerLinkModelImpl.getOriginalEditable()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeIdEditable, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeIdEditable, args);

				args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getDataTypeId(),
					dataTypeVisualizerLinkModelImpl.isEditable()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeIdEditable, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeIdEditable, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DataTypeVisualizerLinkImpl.class,
			dataTypeVisualizerLink.getPrimaryKey(), dataTypeVisualizerLink,
			false);

		clearUniqueFindersCache(dataTypeVisualizerLinkModelImpl, false);
		cacheUniqueFindersCache(dataTypeVisualizerLinkModelImpl);

		dataTypeVisualizerLink.resetOriginalValues();

		return dataTypeVisualizerLink;
	}

	/**
	 * Returns the data type visualizer link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data type visualizer link
	 * @return the data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = fetchByPrimaryKey(
			primaryKey);

		if (dataTypeVisualizerLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataTypeVisualizerLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataTypeVisualizerLink;
	}

	/**
	 * Returns the data type visualizer link with the primary key or throws a <code>NoSuchDataTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a data type visualizer link with the primary key could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByPrimaryKey(
			long dataTypeVisualizerLinkId)
		throws NoSuchDataTypeVisualizerLinkException {

		return findByPrimaryKey((Serializable)dataTypeVisualizerLinkId);
	}

	/**
	 * Returns the data type visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeVisualizerLinkId the primary key of the data type visualizer link
	 * @return the data type visualizer link, or <code>null</code> if a data type visualizer link with the primary key could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByPrimaryKey(
		long dataTypeVisualizerLinkId) {

		return fetchByPrimaryKey((Serializable)dataTypeVisualizerLinkId);
	}

	/**
	 * Returns all the data type visualizer links.
	 *
	 * @return the data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @return the range of data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
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

		List<DataTypeVisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<DataTypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATATYPEVISUALIZERLINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATATYPEVISUALIZERLINK;

				sql = sql.concat(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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
	 * Removes all the data type visualizer links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataTypeVisualizerLink dataTypeVisualizerLink : findAll()) {
			remove(dataTypeVisualizerLink);
		}
	}

	/**
	 * Returns the number of data type visualizer links.
	 *
	 * @return the number of data type visualizer links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_DATATYPEVISUALIZERLINK);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "dataTypeVisualizerLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATATYPEVISUALIZERLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataTypeVisualizerLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data type visualizer link persistence.
	 */
	@Activate
	public void activate() {
		DataTypeVisualizerLinkModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		DataTypeVisualizerLinkModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByVisualizerName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisualizerName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVisualizerName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisualizerName",
			new String[] {String.class.getName()},
			DataTypeVisualizerLinkModelImpl.VISUALIZERNAME_COLUMN_BITMASK);

		_finderPathCountByVisualizerName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVisualizerName",
			new String[] {String.class.getName()});

		_finderPathFetchByVisualizerNameVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByVisualizerNameVersion",
			new String[] {String.class.getName(), String.class.getName()},
			DataTypeVisualizerLinkModelImpl.VISUALIZERNAME_COLUMN_BITMASK |
			DataTypeVisualizerLinkModelImpl.VISUALIZERVERSION_COLUMN_BITMASK);

		_finderPathCountByVisualizerNameVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVisualizerNameVersion",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByEditable = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEditable",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByEditable = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEditable",
			new String[] {Boolean.class.getName()},
			DataTypeVisualizerLinkModelImpl.EDITABLE_COLUMN_BITMASK);

		_finderPathCountByEditable = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEditable",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId",
			new String[] {Long.class.getName()},
			DataTypeVisualizerLinkModelImpl.DATATYPEID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataTypeIdEditable = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeIdEditable",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeIdEditable = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDataTypeIdEditable",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			DataTypeVisualizerLinkModelImpl.DATATYPEID_COLUMN_BITMASK |
			DataTypeVisualizerLinkModelImpl.EDITABLE_COLUMN_BITMASK);

		_finderPathCountByDataTypeIdEditable = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataTypeIdEditable",
			new String[] {Long.class.getName(), Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataTypeVisualizerLinkImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.osp.icecap.model.DataTypeVisualizerLink"),
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

	private static final String _SQL_SELECT_DATATYPEVISUALIZERLINK =
		"SELECT dataTypeVisualizerLink FROM DataTypeVisualizerLink dataTypeVisualizerLink";

	private static final String _SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE =
		"SELECT dataTypeVisualizerLink FROM DataTypeVisualizerLink dataTypeVisualizerLink WHERE ";

	private static final String _SQL_COUNT_DATATYPEVISUALIZERLINK =
		"SELECT COUNT(dataTypeVisualizerLink) FROM DataTypeVisualizerLink dataTypeVisualizerLink";

	private static final String _SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE =
		"SELECT COUNT(dataTypeVisualizerLink) FROM DataTypeVisualizerLink dataTypeVisualizerLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dataTypeVisualizerLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataTypeVisualizerLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataTypeVisualizerLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataTypeVisualizerLinkPersistenceImpl.class);

	static {
		try {
			Class.forName(ICECAPPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}