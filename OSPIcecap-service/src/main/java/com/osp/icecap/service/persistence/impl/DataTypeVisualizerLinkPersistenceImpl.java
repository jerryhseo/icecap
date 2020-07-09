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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
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
@ProviderType
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
	private FinderPath _finderPathWithPaginationFindByVisualizer;
	private FinderPath _finderPathWithoutPaginationFindByVisualizer;
	private FinderPath _finderPathCountByVisualizer;

	/**
	 * Returns all the data type visualizer links where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @return the matching data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findByVisualizer(
		String visualizerName) {

		return findByVisualizer(
			visualizerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DataTypeVisualizerLink> findByVisualizer(
		String visualizerName, int start, int end) {

		return findByVisualizer(visualizerName, start, end, null);
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
	@Override
	public List<DataTypeVisualizerLink> findByVisualizer(
		String visualizerName, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		return findByVisualizer(
			visualizerName, start, end, orderByComparator, true);
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
	@Override
	public List<DataTypeVisualizerLink> findByVisualizer(
		String visualizerName, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean retrieveFromCache) {

		visualizerName = Objects.toString(visualizerName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByVisualizer;
			finderArgs = new Object[] {visualizerName};
		}
		else {
			finderPath = _finderPathWithPaginationFindByVisualizer;
			finderArgs = new Object[] {
				visualizerName, start, end, orderByComparator
			};
		}

		List<DataTypeVisualizerLink> list = null;

		if (retrieveFromCache) {
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
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			boolean bindVisualizerName = false;

			if (visualizerName.isEmpty()) {
				query.append(_FINDER_COLUMN_VISUALIZER_VISUALIZERNAME_3);
			}
			else {
				bindVisualizerName = true;

				query.append(_FINDER_COLUMN_VISUALIZER_VISUALIZERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVisualizerName) {
					qPos.add(visualizerName);
				}

				if (!pagination) {
					list = (List<DataTypeVisualizerLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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
	 * Returns the first data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByVisualizer_First(
			String visualizerName,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = fetchByVisualizer_First(
			visualizerName, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("visualizerName=");
		msg.append(visualizerName);

		msg.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(msg.toString());
	}

	/**
	 * Returns the first data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByVisualizer_First(
		String visualizerName,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		List<DataTypeVisualizerLink> list = findByVisualizer(
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
	public DataTypeVisualizerLink findByVisualizer_Last(
			String visualizerName,
			OrderByComparator<DataTypeVisualizerLink> orderByComparator)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = fetchByVisualizer_Last(
			visualizerName, orderByComparator);

		if (dataTypeVisualizerLink != null) {
			return dataTypeVisualizerLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("visualizerName=");
		msg.append(visualizerName);

		msg.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(msg.toString());
	}

	/**
	 * Returns the last data type visualizer link in the ordered set where visualizerName = &#63;.
	 *
	 * @param visualizerName the visualizer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByVisualizer_Last(
		String visualizerName,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator) {

		int count = countByVisualizer(visualizerName);

		if (count == 0) {
			return null;
		}

		List<DataTypeVisualizerLink> list = findByVisualizer(
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
	public DataTypeVisualizerLink[] findByVisualizer_PrevAndNext(
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

			array[0] = getByVisualizer_PrevAndNext(
				session, dataTypeVisualizerLink, visualizerName,
				orderByComparator, true);

			array[1] = dataTypeVisualizerLink;

			array[2] = getByVisualizer_PrevAndNext(
				session, dataTypeVisualizerLink, visualizerName,
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

	protected DataTypeVisualizerLink getByVisualizer_PrevAndNext(
		Session session, DataTypeVisualizerLink dataTypeVisualizerLink,
		String visualizerName,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

		boolean bindVisualizerName = false;

		if (visualizerName.isEmpty()) {
			query.append(_FINDER_COLUMN_VISUALIZER_VISUALIZERNAME_3);
		}
		else {
			bindVisualizerName = true;

			query.append(_FINDER_COLUMN_VISUALIZER_VISUALIZERNAME_2);
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
			query.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindVisualizerName) {
			qPos.add(visualizerName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataTypeVisualizerLink)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataTypeVisualizerLink> list = q.list();

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
	public void removeByVisualizer(String visualizerName) {
		for (DataTypeVisualizerLink dataTypeVisualizerLink :
				findByVisualizer(
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
	public int countByVisualizer(String visualizerName) {
		visualizerName = Objects.toString(visualizerName, "");

		FinderPath finderPath = _finderPathCountByVisualizer;

		Object[] finderArgs = new Object[] {visualizerName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			boolean bindVisualizerName = false;

			if (visualizerName.isEmpty()) {
				query.append(_FINDER_COLUMN_VISUALIZER_VISUALIZERNAME_3);
			}
			else {
				bindVisualizerName = true;

				query.append(_FINDER_COLUMN_VISUALIZER_VISUALIZERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVisualizerName) {
					qPos.add(visualizerName);
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

	private static final String _FINDER_COLUMN_VISUALIZER_VISUALIZERNAME_2 =
		"dataTypeVisualizerLink.visualizerName = ?";

	private static final String _FINDER_COLUMN_VISUALIZER_VISUALIZERNAME_3 =
		"(dataTypeVisualizerLink.visualizerName IS NULL OR dataTypeVisualizerLink.visualizerName = '')";

	private FinderPath _finderPathFetchByVisualizerVersion;
	private FinderPath _finderPathCountByVisualizerVersion;

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or throws a <code>NoSuchDataTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @return the matching data type visualizer link
	 * @throws NoSuchDataTypeVisualizerLinkException if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink findByVisualizerVersion(
			String visualizerName, String visualizerVersion)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink =
			fetchByVisualizerVersion(visualizerName, visualizerVersion);

		if (dataTypeVisualizerLink == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("visualizerName=");
			msg.append(visualizerName);

			msg.append(", visualizerVersion=");
			msg.append(visualizerVersion);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDataTypeVisualizerLinkException(msg.toString());
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
	public DataTypeVisualizerLink fetchByVisualizerVersion(
		String visualizerName, String visualizerVersion) {

		return fetchByVisualizerVersion(
			visualizerName, visualizerVersion, true);
	}

	/**
	 * Returns the data type visualizer link where visualizerName = &#63; and visualizerVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param visualizerName the visualizer name
	 * @param visualizerVersion the visualizer version
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching data type visualizer link, or <code>null</code> if a matching data type visualizer link could not be found
	 */
	@Override
	public DataTypeVisualizerLink fetchByVisualizerVersion(
		String visualizerName, String visualizerVersion,
		boolean retrieveFromCache) {

		visualizerName = Objects.toString(visualizerName, "");
		visualizerVersion = Objects.toString(visualizerVersion, "");

		Object[] finderArgs = new Object[] {visualizerName, visualizerVersion};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByVisualizerVersion, finderArgs, this);
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
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			boolean bindVisualizerName = false;

			if (visualizerName.isEmpty()) {
				query.append(_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERNAME_3);
			}
			else {
				bindVisualizerName = true;

				query.append(_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERNAME_2);
			}

			boolean bindVisualizerVersion = false;

			if (visualizerVersion.isEmpty()) {
				query.append(
					_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERVERSION_3);
			}
			else {
				bindVisualizerVersion = true;

				query.append(
					_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERVERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVisualizerName) {
					qPos.add(visualizerName);
				}

				if (bindVisualizerVersion) {
					qPos.add(visualizerVersion);
				}

				List<DataTypeVisualizerLink> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByVisualizerVersion, finderArgs, list);
				}
				else {
					DataTypeVisualizerLink dataTypeVisualizerLink = list.get(0);

					result = dataTypeVisualizerLink;

					cacheResult(dataTypeVisualizerLink);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByVisualizerVersion, finderArgs);

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
	public DataTypeVisualizerLink removeByVisualizerVersion(
			String visualizerName, String visualizerVersion)
		throws NoSuchDataTypeVisualizerLinkException {

		DataTypeVisualizerLink dataTypeVisualizerLink = findByVisualizerVersion(
			visualizerName, visualizerVersion);

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
	public int countByVisualizerVersion(
		String visualizerName, String visualizerVersion) {

		visualizerName = Objects.toString(visualizerName, "");
		visualizerVersion = Objects.toString(visualizerVersion, "");

		FinderPath finderPath = _finderPathCountByVisualizerVersion;

		Object[] finderArgs = new Object[] {visualizerName, visualizerVersion};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			boolean bindVisualizerName = false;

			if (visualizerName.isEmpty()) {
				query.append(_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERNAME_3);
			}
			else {
				bindVisualizerName = true;

				query.append(_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERNAME_2);
			}

			boolean bindVisualizerVersion = false;

			if (visualizerVersion.isEmpty()) {
				query.append(
					_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERVERSION_3);
			}
			else {
				bindVisualizerVersion = true;

				query.append(
					_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERVERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVisualizerName) {
					qPos.add(visualizerName);
				}

				if (bindVisualizerVersion) {
					qPos.add(visualizerVersion);
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

	private static final String
		_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERNAME_2 =
			"dataTypeVisualizerLink.visualizerName = ? AND ";

	private static final String
		_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERNAME_3 =
			"(dataTypeVisualizerLink.visualizerName IS NULL OR dataTypeVisualizerLink.visualizerName = '') AND ";

	private static final String
		_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERVERSION_2 =
			"dataTypeVisualizerLink.visualizerVersion = ?";

	private static final String
		_FINDER_COLUMN_VISUALIZERVERSION_VISUALIZERVERSION_3 =
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Override
	public List<DataTypeVisualizerLink> findByEditable(
		boolean editable, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByEditable;
			finderArgs = new Object[] {editable};
		}
		else {
			finderPath = _finderPathWithPaginationFindByEditable;
			finderArgs = new Object[] {editable, start, end, orderByComparator};
		}

		List<DataTypeVisualizerLink> list = null;

		if (retrieveFromCache) {
			list = (List<DataTypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataTypeVisualizerLink dataTypeVisualizerLink : list) {
					if ((editable != dataTypeVisualizerLink.isEditable())) {
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

			query.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			query.append(_FINDER_COLUMN_EDITABLE_EDITABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(editable);

				if (!pagination) {
					list = (List<DataTypeVisualizerLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("editable=");
		msg.append(editable);

		msg.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(msg.toString());
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

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("editable=");
		msg.append(editable);

		msg.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(msg.toString());
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
		catch (Exception e) {
			throw processException(e);
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

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

		query.append(_FINDER_COLUMN_EDITABLE_EDITABLE_2);

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
			query.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(editable);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataTypeVisualizerLink)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataTypeVisualizerLink> list = q.list();

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
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			query.append(_FINDER_COLUMN_EDITABLE_EDITABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(editable);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Override
	public List<DataTypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDataTypeId;
			finderArgs = new Object[] {dataTypeId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataTypeId;
			finderArgs = new Object[] {
				dataTypeId, start, end, orderByComparator
			};
		}

		List<DataTypeVisualizerLink> list = null;

		if (retrieveFromCache) {
			list = (List<DataTypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataTypeVisualizerLink dataTypeVisualizerLink : list) {
					if ((dataTypeId !=
							dataTypeVisualizerLink.getDataTypeId())) {

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

			query.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

			query.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataTypeId);

				if (!pagination) {
					list = (List<DataTypeVisualizerLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataTypeId=");
		msg.append(dataTypeId);

		msg.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(msg.toString());
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

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataTypeId=");
		msg.append(dataTypeId);

		msg.append("}");

		throw new NoSuchDataTypeVisualizerLinkException(msg.toString());
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
		catch (Exception e) {
			throw processException(e);
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

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATATYPEVISUALIZERLINK_WHERE);

		query.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

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
			query.append(DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dataTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataTypeVisualizerLink)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataTypeVisualizerLink> list = q.list();

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
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATATYPEVISUALIZERLINK_WHERE);

			query.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataTypeId);

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

	private static final String _FINDER_COLUMN_DATATYPEID_DATATYPEID_2 =
		"dataTypeVisualizerLink.dataTypeId = ?";

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
			_finderPathFetchByVisualizerVersion,
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

	protected void cacheUniqueFindersCache(
		DataTypeVisualizerLinkModelImpl dataTypeVisualizerLinkModelImpl) {

		Object[] args = new Object[] {
			dataTypeVisualizerLinkModelImpl.getVisualizerName(),
			dataTypeVisualizerLinkModelImpl.getVisualizerVersion()
		};

		finderCache.putResult(
			_finderPathCountByVisualizerVersion, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByVisualizerVersion, args,
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

			finderCache.removeResult(_finderPathCountByVisualizerVersion, args);
			finderCache.removeResult(_finderPathFetchByVisualizerVersion, args);
		}

		if ((dataTypeVisualizerLinkModelImpl.getColumnBitmask() &
			 _finderPathFetchByVisualizerVersion.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataTypeVisualizerLinkModelImpl.getOriginalVisualizerName(),
				dataTypeVisualizerLinkModelImpl.getOriginalVisualizerVersion()
			};

			finderCache.removeResult(_finderPathCountByVisualizerVersion, args);
			finderCache.removeResult(_finderPathFetchByVisualizerVersion, args);
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
		catch (NoSuchDataTypeVisualizerLinkException nsee) {
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
		catch (Exception e) {
			throw processException(e);
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
			Object[] args = new Object[] {
				dataTypeVisualizerLinkModelImpl.getVisualizerName()
			};

			finderCache.removeResult(_finderPathCountByVisualizer, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVisualizer, args);

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

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataTypeVisualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVisualizer.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getOriginalVisualizerName()
				};

				finderCache.removeResult(_finderPathCountByVisualizer, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVisualizer, args);

				args = new Object[] {
					dataTypeVisualizerLinkModelImpl.getVisualizerName()
				};

				finderCache.removeResult(_finderPathCountByVisualizer, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVisualizer, args);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeVisualizerLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type visualizer links
	 * @param end the upper bound of the range of data type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data type visualizer links
	 */
	@Override
	public List<DataTypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<DataTypeVisualizerLink> orderByComparator,
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

		List<DataTypeVisualizerLink> list = null;

		if (retrieveFromCache) {
			list = (List<DataTypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATATYPEVISUALIZERLINK);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATATYPEVISUALIZERLINK;

				if (pagination) {
					sql = sql.concat(
						DataTypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataTypeVisualizerLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataTypeVisualizerLink>)QueryUtil.list(
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

				Query q = session.createQuery(
					_SQL_COUNT_DATATYPEVISUALIZERLINK);

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

		_finderPathWithPaginationFindByVisualizer = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisualizer",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVisualizer = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisualizer",
			new String[] {String.class.getName()},
			DataTypeVisualizerLinkModelImpl.VISUALIZERNAME_COLUMN_BITMASK);

		_finderPathCountByVisualizer = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVisualizer",
			new String[] {String.class.getName()});

		_finderPathFetchByVisualizerVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataTypeVisualizerLinkImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByVisualizerVersion",
			new String[] {String.class.getName(), String.class.getName()},
			DataTypeVisualizerLinkModelImpl.VISUALIZERNAME_COLUMN_BITMASK |
			DataTypeVisualizerLinkModelImpl.VISUALIZERVERSION_COLUMN_BITMASK);

		_finderPathCountByVisualizerVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVisualizerVersion",
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
		target = ICECAPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

}