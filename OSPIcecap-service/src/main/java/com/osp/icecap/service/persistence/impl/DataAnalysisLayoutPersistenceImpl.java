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
import com.liferay.portal.kernel.util.StringUtil;

import com.osp.icecap.exception.NoSuchDataAnalysisLayoutException;
import com.osp.icecap.model.DataAnalysisLayout;
import com.osp.icecap.model.impl.DataAnalysisLayoutImpl;
import com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl;
import com.osp.icecap.service.persistence.DataAnalysisLayoutPersistence;
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
 * The persistence implementation for the data analysis layout service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = DataAnalysisLayoutPersistence.class)
@ProviderType
public class DataAnalysisLayoutPersistenceImpl
	extends BasePersistenceImpl<DataAnalysisLayout>
	implements DataAnalysisLayoutPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataAnalysisLayoutUtil</code> to access the data analysis layout persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataAnalysisLayoutImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByApplyLevel;
	private FinderPath _finderPathWithoutPaginationFindByApplyLevel;
	private FinderPath _finderPathCountByApplyLevel;

	/**
	 * Returns all the data analysis layouts where applyLevel = &#63;.
	 *
	 * @param applyLevel the apply level
	 * @return the matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByApplyLevel(String applyLevel) {
		return findByApplyLevel(
			applyLevel, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data analysis layouts where applyLevel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applyLevel the apply level
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByApplyLevel(
		String applyLevel, int start, int end) {

		return findByApplyLevel(applyLevel, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where applyLevel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByApplyLevel(String, int, int, OrderByComparator)}
	 * @param applyLevel the apply level
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Deprecated
	@Override
	public List<DataAnalysisLayout> findByApplyLevel(
		String applyLevel, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean useFinderCache) {

		return findByApplyLevel(applyLevel, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where applyLevel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applyLevel the apply level
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByApplyLevel(
		String applyLevel, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		applyLevel = Objects.toString(applyLevel, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByApplyLevel;
			finderArgs = new Object[] {applyLevel};
		}
		else {
			finderPath = _finderPathWithPaginationFindByApplyLevel;
			finderArgs = new Object[] {
				applyLevel, start, end, orderByComparator
			};
		}

		List<DataAnalysisLayout> list =
			(List<DataAnalysisLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DataAnalysisLayout dataAnalysisLayout : list) {
				if (!applyLevel.equals(dataAnalysisLayout.getApplyLevel())) {
					list = null;

					break;
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

			query.append(_SQL_SELECT_DATAANALYSISLAYOUT_WHERE);

			boolean bindApplyLevel = false;

			if (applyLevel.isEmpty()) {
				query.append(_FINDER_COLUMN_APPLYLEVEL_APPLYLEVEL_3);
			}
			else {
				bindApplyLevel = true;

				query.append(_FINDER_COLUMN_APPLYLEVEL_APPLYLEVEL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataAnalysisLayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplyLevel) {
					qPos.add(applyLevel);
				}

				if (!pagination) {
					list = (List<DataAnalysisLayout>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataAnalysisLayout>)QueryUtil.list(
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
	 * Returns the first data analysis layout in the ordered set where applyLevel = &#63;.
	 *
	 * @param applyLevel the apply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByApplyLevel_First(
			String applyLevel,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByApplyLevel_First(
			applyLevel, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applyLevel=");
		msg.append(applyLevel);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the first data analysis layout in the ordered set where applyLevel = &#63;.
	 *
	 * @param applyLevel the apply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByApplyLevel_First(
		String applyLevel,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		List<DataAnalysisLayout> list = findByApplyLevel(
			applyLevel, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data analysis layout in the ordered set where applyLevel = &#63;.
	 *
	 * @param applyLevel the apply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByApplyLevel_Last(
			String applyLevel,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByApplyLevel_Last(
			applyLevel, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applyLevel=");
		msg.append(applyLevel);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the last data analysis layout in the ordered set where applyLevel = &#63;.
	 *
	 * @param applyLevel the apply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByApplyLevel_Last(
		String applyLevel,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		int count = countByApplyLevel(applyLevel);

		if (count == 0) {
			return null;
		}

		List<DataAnalysisLayout> list = findByApplyLevel(
			applyLevel, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where applyLevel = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param applyLevel the apply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout[] findByApplyLevel_PrevAndNext(
			String dataUuid, String applyLevel,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		applyLevel = Objects.toString(applyLevel, "");

		DataAnalysisLayout dataAnalysisLayout = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			DataAnalysisLayout[] array = new DataAnalysisLayoutImpl[3];

			array[0] = getByApplyLevel_PrevAndNext(
				session, dataAnalysisLayout, applyLevel, orderByComparator,
				true);

			array[1] = dataAnalysisLayout;

			array[2] = getByApplyLevel_PrevAndNext(
				session, dataAnalysisLayout, applyLevel, orderByComparator,
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

	protected DataAnalysisLayout getByApplyLevel_PrevAndNext(
		Session session, DataAnalysisLayout dataAnalysisLayout,
		String applyLevel,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
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

		query.append(_SQL_SELECT_DATAANALYSISLAYOUT_WHERE);

		boolean bindApplyLevel = false;

		if (applyLevel.isEmpty()) {
			query.append(_FINDER_COLUMN_APPLYLEVEL_APPLYLEVEL_3);
		}
		else {
			bindApplyLevel = true;

			query.append(_FINDER_COLUMN_APPLYLEVEL_APPLYLEVEL_2);
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
			query.append(DataAnalysisLayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApplyLevel) {
			qPos.add(applyLevel);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataAnalysisLayout)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataAnalysisLayout> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data analysis layouts where applyLevel = &#63; from the database.
	 *
	 * @param applyLevel the apply level
	 */
	@Override
	public void removeByApplyLevel(String applyLevel) {
		for (DataAnalysisLayout dataAnalysisLayout :
				findByApplyLevel(
					applyLevel, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataAnalysisLayout);
		}
	}

	/**
	 * Returns the number of data analysis layouts where applyLevel = &#63;.
	 *
	 * @param applyLevel the apply level
	 * @return the number of matching data analysis layouts
	 */
	@Override
	public int countByApplyLevel(String applyLevel) {
		applyLevel = Objects.toString(applyLevel, "");

		FinderPath finderPath = _finderPathCountByApplyLevel;

		Object[] finderArgs = new Object[] {applyLevel};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAANALYSISLAYOUT_WHERE);

			boolean bindApplyLevel = false;

			if (applyLevel.isEmpty()) {
				query.append(_FINDER_COLUMN_APPLYLEVEL_APPLYLEVEL_3);
			}
			else {
				bindApplyLevel = true;

				query.append(_FINDER_COLUMN_APPLYLEVEL_APPLYLEVEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplyLevel) {
					qPos.add(applyLevel);
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

	private static final String _FINDER_COLUMN_APPLYLEVEL_APPLYLEVEL_2 =
		"dataAnalysisLayout.applyLevel = ?";

	private static final String _FINDER_COLUMN_APPLYLEVEL_APPLYLEVEL_3 =
		"(dataAnalysisLayout.applyLevel IS NULL OR dataAnalysisLayout.applyLevel = '')";

	private FinderPath _finderPathFetchByDataUuidApplyLevel;
	private FinderPath _finderPathCountByDataUuidApplyLevel;

	/**
	 * Returns the data analysis layout where dataUuid = &#63; and applyLevel = &#63; or throws a <code>NoSuchDataAnalysisLayoutException</code> if it could not be found.
	 *
	 * @param dataUuid the data uuid
	 * @param applyLevel the apply level
	 * @return the matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataUuidApplyLevel(
			String dataUuid, String applyLevel)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataUuidApplyLevel(
			dataUuid, applyLevel);

		if (dataAnalysisLayout == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dataUuid=");
			msg.append(dataUuid);

			msg.append(", applyLevel=");
			msg.append(applyLevel);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDataAnalysisLayoutException(msg.toString());
		}

		return dataAnalysisLayout;
	}

	/**
	 * Returns the data analysis layout where dataUuid = &#63; and applyLevel = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByDataUuidApplyLevel(String,String)}
	 * @param dataUuid the data uuid
	 * @param applyLevel the apply level
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Deprecated
	@Override
	public DataAnalysisLayout fetchByDataUuidApplyLevel(
		String dataUuid, String applyLevel, boolean useFinderCache) {

		return fetchByDataUuidApplyLevel(dataUuid, applyLevel);
	}

	/**
	 * Returns the data analysis layout where dataUuid = &#63; and applyLevel = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataUuid the data uuid
	 * @param applyLevel the apply level
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataUuidApplyLevel(
		String dataUuid, String applyLevel) {

		dataUuid = Objects.toString(dataUuid, "");
		applyLevel = Objects.toString(applyLevel, "");

		Object[] finderArgs = new Object[] {dataUuid, applyLevel};

		Object result = finderCache.getResult(
			_finderPathFetchByDataUuidApplyLevel, finderArgs, this);

		if (result instanceof DataAnalysisLayout) {
			DataAnalysisLayout dataAnalysisLayout = (DataAnalysisLayout)result;

			if (!Objects.equals(dataUuid, dataAnalysisLayout.getDataUuid()) ||
				!Objects.equals(
					applyLevel, dataAnalysisLayout.getApplyLevel())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DATAANALYSISLAYOUT_WHERE);

			boolean bindDataUuid = false;

			if (dataUuid.isEmpty()) {
				query.append(_FINDER_COLUMN_DATAUUIDAPPLYLEVEL_DATAUUID_3);
			}
			else {
				bindDataUuid = true;

				query.append(_FINDER_COLUMN_DATAUUIDAPPLYLEVEL_DATAUUID_2);
			}

			boolean bindApplyLevel = false;

			if (applyLevel.isEmpty()) {
				query.append(_FINDER_COLUMN_DATAUUIDAPPLYLEVEL_APPLYLEVEL_3);
			}
			else {
				bindApplyLevel = true;

				query.append(_FINDER_COLUMN_DATAUUIDAPPLYLEVEL_APPLYLEVEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDataUuid) {
					qPos.add(dataUuid);
				}

				if (bindApplyLevel) {
					qPos.add(applyLevel);
				}

				List<DataAnalysisLayout> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByDataUuidApplyLevel, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DataAnalysisLayoutPersistenceImpl.fetchByDataUuidApplyLevel(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DataAnalysisLayout dataAnalysisLayout = list.get(0);

					result = dataAnalysisLayout;

					cacheResult(dataAnalysisLayout);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByDataUuidApplyLevel, finderArgs);

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
			return (DataAnalysisLayout)result;
		}
	}

	/**
	 * Removes the data analysis layout where dataUuid = &#63; and applyLevel = &#63; from the database.
	 *
	 * @param dataUuid the data uuid
	 * @param applyLevel the apply level
	 * @return the data analysis layout that was removed
	 */
	@Override
	public DataAnalysisLayout removeByDataUuidApplyLevel(
			String dataUuid, String applyLevel)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = findByDataUuidApplyLevel(
			dataUuid, applyLevel);

		return remove(dataAnalysisLayout);
	}

	/**
	 * Returns the number of data analysis layouts where dataUuid = &#63; and applyLevel = &#63;.
	 *
	 * @param dataUuid the data uuid
	 * @param applyLevel the apply level
	 * @return the number of matching data analysis layouts
	 */
	@Override
	public int countByDataUuidApplyLevel(String dataUuid, String applyLevel) {
		dataUuid = Objects.toString(dataUuid, "");
		applyLevel = Objects.toString(applyLevel, "");

		FinderPath finderPath = _finderPathCountByDataUuidApplyLevel;

		Object[] finderArgs = new Object[] {dataUuid, applyLevel};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DATAANALYSISLAYOUT_WHERE);

			boolean bindDataUuid = false;

			if (dataUuid.isEmpty()) {
				query.append(_FINDER_COLUMN_DATAUUIDAPPLYLEVEL_DATAUUID_3);
			}
			else {
				bindDataUuid = true;

				query.append(_FINDER_COLUMN_DATAUUIDAPPLYLEVEL_DATAUUID_2);
			}

			boolean bindApplyLevel = false;

			if (applyLevel.isEmpty()) {
				query.append(_FINDER_COLUMN_DATAUUIDAPPLYLEVEL_APPLYLEVEL_3);
			}
			else {
				bindApplyLevel = true;

				query.append(_FINDER_COLUMN_DATAUUIDAPPLYLEVEL_APPLYLEVEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDataUuid) {
					qPos.add(dataUuid);
				}

				if (bindApplyLevel) {
					qPos.add(applyLevel);
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

	private static final String _FINDER_COLUMN_DATAUUIDAPPLYLEVEL_DATAUUID_2 =
		"dataAnalysisLayout.dataUuid = ? AND ";

	private static final String _FINDER_COLUMN_DATAUUIDAPPLYLEVEL_DATAUUID_3 =
		"(dataAnalysisLayout.dataUuid IS NULL OR dataAnalysisLayout.dataUuid = '') AND ";

	private static final String _FINDER_COLUMN_DATAUUIDAPPLYLEVEL_APPLYLEVEL_2 =
		"dataAnalysisLayout.applyLevel = ?";

	private static final String _FINDER_COLUMN_DATAUUIDAPPLYLEVEL_APPLYLEVEL_3 =
		"(dataAnalysisLayout.applyLevel IS NULL OR dataAnalysisLayout.applyLevel = '')";

	public DataAnalysisLayoutPersistenceImpl() {
		setModelClass(DataAnalysisLayout.class);

		setModelImplClass(DataAnalysisLayoutImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the data analysis layout in the entity cache if it is enabled.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 */
	@Override
	public void cacheResult(DataAnalysisLayout dataAnalysisLayout) {
		entityCache.putResult(
			entityCacheEnabled, DataAnalysisLayoutImpl.class,
			dataAnalysisLayout.getPrimaryKey(), dataAnalysisLayout);

		finderCache.putResult(
			_finderPathFetchByDataUuidApplyLevel,
			new Object[] {
				dataAnalysisLayout.getDataUuid(),
				dataAnalysisLayout.getApplyLevel()
			},
			dataAnalysisLayout);

		dataAnalysisLayout.resetOriginalValues();
	}

	/**
	 * Caches the data analysis layouts in the entity cache if it is enabled.
	 *
	 * @param dataAnalysisLayouts the data analysis layouts
	 */
	@Override
	public void cacheResult(List<DataAnalysisLayout> dataAnalysisLayouts) {
		for (DataAnalysisLayout dataAnalysisLayout : dataAnalysisLayouts) {
			if (entityCache.getResult(
					entityCacheEnabled, DataAnalysisLayoutImpl.class,
					dataAnalysisLayout.getPrimaryKey()) == null) {

				cacheResult(dataAnalysisLayout);
			}
			else {
				dataAnalysisLayout.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data analysis layouts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataAnalysisLayoutImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data analysis layout.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataAnalysisLayout dataAnalysisLayout) {
		entityCache.removeResult(
			entityCacheEnabled, DataAnalysisLayoutImpl.class,
			dataAnalysisLayout.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(DataAnalysisLayoutModelImpl)dataAnalysisLayout, true);
	}

	@Override
	public void clearCache(List<DataAnalysisLayout> dataAnalysisLayouts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataAnalysisLayout dataAnalysisLayout : dataAnalysisLayouts) {
			entityCache.removeResult(
				entityCacheEnabled, DataAnalysisLayoutImpl.class,
				dataAnalysisLayout.getPrimaryKey());

			clearUniqueFindersCache(
				(DataAnalysisLayoutModelImpl)dataAnalysisLayout, true);
		}
	}

	protected void cacheUniqueFindersCache(
		DataAnalysisLayoutModelImpl dataAnalysisLayoutModelImpl) {

		Object[] args = new Object[] {
			dataAnalysisLayoutModelImpl.getDataUuid(),
			dataAnalysisLayoutModelImpl.getApplyLevel()
		};

		finderCache.putResult(
			_finderPathCountByDataUuidApplyLevel, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDataUuidApplyLevel, args,
			dataAnalysisLayoutModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DataAnalysisLayoutModelImpl dataAnalysisLayoutModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				dataAnalysisLayoutModelImpl.getDataUuid(),
				dataAnalysisLayoutModelImpl.getApplyLevel()
			};

			finderCache.removeResult(
				_finderPathCountByDataUuidApplyLevel, args);
			finderCache.removeResult(
				_finderPathFetchByDataUuidApplyLevel, args);
		}

		if ((dataAnalysisLayoutModelImpl.getColumnBitmask() &
			 _finderPathFetchByDataUuidApplyLevel.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataAnalysisLayoutModelImpl.getOriginalDataUuid(),
				dataAnalysisLayoutModelImpl.getOriginalApplyLevel()
			};

			finderCache.removeResult(
				_finderPathCountByDataUuidApplyLevel, args);
			finderCache.removeResult(
				_finderPathFetchByDataUuidApplyLevel, args);
		}
	}

	/**
	 * Creates a new data analysis layout with the primary key. Does not add the data analysis layout to the database.
	 *
	 * @param dataUuid the primary key for the new data analysis layout
	 * @return the new data analysis layout
	 */
	@Override
	public DataAnalysisLayout create(String dataUuid) {
		DataAnalysisLayout dataAnalysisLayout = new DataAnalysisLayoutImpl();

		dataAnalysisLayout.setNew(true);
		dataAnalysisLayout.setPrimaryKey(dataUuid);

		return dataAnalysisLayout;
	}

	/**
	 * Removes the data analysis layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout that was removed
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout remove(String dataUuid)
		throws NoSuchDataAnalysisLayoutException {

		return remove((Serializable)dataUuid);
	}

	/**
	 * Removes the data analysis layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data analysis layout
	 * @return the data analysis layout that was removed
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout remove(Serializable primaryKey)
		throws NoSuchDataAnalysisLayoutException {

		Session session = null;

		try {
			session = openSession();

			DataAnalysisLayout dataAnalysisLayout =
				(DataAnalysisLayout)session.get(
					DataAnalysisLayoutImpl.class, primaryKey);

			if (dataAnalysisLayout == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataAnalysisLayoutException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataAnalysisLayout);
		}
		catch (NoSuchDataAnalysisLayoutException nsee) {
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
	protected DataAnalysisLayout removeImpl(
		DataAnalysisLayout dataAnalysisLayout) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataAnalysisLayout)) {
				dataAnalysisLayout = (DataAnalysisLayout)session.get(
					DataAnalysisLayoutImpl.class,
					dataAnalysisLayout.getPrimaryKeyObj());
			}

			if (dataAnalysisLayout != null) {
				session.delete(dataAnalysisLayout);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataAnalysisLayout != null) {
			clearCache(dataAnalysisLayout);
		}

		return dataAnalysisLayout;
	}

	@Override
	public DataAnalysisLayout updateImpl(
		DataAnalysisLayout dataAnalysisLayout) {

		boolean isNew = dataAnalysisLayout.isNew();

		if (!(dataAnalysisLayout instanceof DataAnalysisLayoutModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataAnalysisLayout.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dataAnalysisLayout);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataAnalysisLayout proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataAnalysisLayout implementation " +
					dataAnalysisLayout.getClass());
		}

		DataAnalysisLayoutModelImpl dataAnalysisLayoutModelImpl =
			(DataAnalysisLayoutModelImpl)dataAnalysisLayout;

		Session session = null;

		try {
			session = openSession();

			if (dataAnalysisLayout.isNew()) {
				session.save(dataAnalysisLayout);

				dataAnalysisLayout.setNew(false);
			}
			else {
				dataAnalysisLayout = (DataAnalysisLayout)session.merge(
					dataAnalysisLayout);
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
				dataAnalysisLayoutModelImpl.getApplyLevel()
			};

			finderCache.removeResult(_finderPathCountByApplyLevel, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByApplyLevel, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataAnalysisLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByApplyLevel.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataAnalysisLayoutModelImpl.getOriginalApplyLevel()
				};

				finderCache.removeResult(_finderPathCountByApplyLevel, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByApplyLevel, args);

				args = new Object[] {
					dataAnalysisLayoutModelImpl.getApplyLevel()
				};

				finderCache.removeResult(_finderPathCountByApplyLevel, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByApplyLevel, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DataAnalysisLayoutImpl.class,
			dataAnalysisLayout.getPrimaryKey(), dataAnalysisLayout, false);

		clearUniqueFindersCache(dataAnalysisLayoutModelImpl, false);
		cacheUniqueFindersCache(dataAnalysisLayoutModelImpl);

		dataAnalysisLayout.resetOriginalValues();

		return dataAnalysisLayout;
	}

	/**
	 * Returns the data analysis layout with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data analysis layout
	 * @return the data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByPrimaryKey(primaryKey);

		if (dataAnalysisLayout == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataAnalysisLayoutException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataAnalysisLayout;
	}

	/**
	 * Returns the data analysis layout with the primary key or throws a <code>NoSuchDataAnalysisLayoutException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout findByPrimaryKey(String dataUuid)
		throws NoSuchDataAnalysisLayoutException {

		return findByPrimaryKey((Serializable)dataUuid);
	}

	/**
	 * Returns the data analysis layout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout, or <code>null</code> if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByPrimaryKey(String dataUuid) {
		return fetchByPrimaryKey((Serializable)dataUuid);
	}

	/**
	 * Returns all the data analysis layouts.
	 *
	 * @return the data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data analysis layouts
	 */
	@Deprecated
	@Override
	public List<DataAnalysisLayout> findAll(
		int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findAll(
		int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

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

		List<DataAnalysisLayout> list =
			(List<DataAnalysisLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATAANALYSISLAYOUT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATAANALYSISLAYOUT;

				if (pagination) {
					sql = sql.concat(DataAnalysisLayoutModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataAnalysisLayout>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataAnalysisLayout>)QueryUtil.list(
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
	 * Removes all the data analysis layouts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataAnalysisLayout dataAnalysisLayout : findAll()) {
			remove(dataAnalysisLayout);
		}
	}

	/**
	 * Returns the number of data analysis layouts.
	 *
	 * @return the number of data analysis layouts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATAANALYSISLAYOUT);

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
		return "dataUuid";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATAANALYSISLAYOUT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataAnalysisLayoutModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data analysis layout persistence.
	 */
	@Activate
	public void activate() {
		DataAnalysisLayoutModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataAnalysisLayoutModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByApplyLevel = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplyLevel",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByApplyLevel = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApplyLevel",
			new String[] {String.class.getName()},
			DataAnalysisLayoutModelImpl.APPLYLEVEL_COLUMN_BITMASK);

		_finderPathCountByApplyLevel = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApplyLevel",
			new String[] {String.class.getName()});

		_finderPathFetchByDataUuidApplyLevel = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByDataUuidApplyLevel",
			new String[] {String.class.getName(), String.class.getName()},
			DataAnalysisLayoutModelImpl.DATAUUID_COLUMN_BITMASK |
			DataAnalysisLayoutModelImpl.APPLYLEVEL_COLUMN_BITMASK);

		_finderPathCountByDataUuidApplyLevel = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataUuidApplyLevel",
			new String[] {String.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataAnalysisLayoutImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.osp.icecap.model.DataAnalysisLayout"),
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

	private static final String _SQL_SELECT_DATAANALYSISLAYOUT =
		"SELECT dataAnalysisLayout FROM DataAnalysisLayout dataAnalysisLayout";

	private static final String _SQL_SELECT_DATAANALYSISLAYOUT_WHERE =
		"SELECT dataAnalysisLayout FROM DataAnalysisLayout dataAnalysisLayout WHERE ";

	private static final String _SQL_COUNT_DATAANALYSISLAYOUT =
		"SELECT COUNT(dataAnalysisLayout) FROM DataAnalysisLayout dataAnalysisLayout";

	private static final String _SQL_COUNT_DATAANALYSISLAYOUT_WHERE =
		"SELECT COUNT(dataAnalysisLayout) FROM DataAnalysisLayout dataAnalysisLayout WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataAnalysisLayout.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataAnalysisLayout exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataAnalysisLayout exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataAnalysisLayoutPersistenceImpl.class);

	static {
		try {
			Class.forName(ICECAPPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}