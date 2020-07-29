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
	private FinderPath _finderPathWithPaginationFindByDataCollectionId;
	private FinderPath _finderPathWithoutPaginationFindByDataCollectionId;
	private FinderPath _finderPathCountByDataCollectionId;

	/**
	 * Returns all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId) {

		return findByDataCollectionId(
			dataCollectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end) {

		return findByDataCollectionId(dataCollectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDataCollectionId;
			finderArgs = new Object[] {dataCollectionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataCollectionId;
			finderArgs = new Object[] {
				dataCollectionId, start, end, orderByComparator
			};
		}

		List<DataAnalysisLayout> list = null;

		if (retrieveFromCache) {
			list = (List<DataAnalysisLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataAnalysisLayout dataAnalysisLayout : list) {
					if ((dataCollectionId !=
							dataAnalysisLayout.getDataCollectionId())) {

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

			query.append(_SQL_SELECT_DATAANALYSISLAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DATACOLLECTIONID_DATACOLLECTIONID_2);

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

				qPos.add(dataCollectionId);

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
	 * Returns the first data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataCollectionId_First(
			dataCollectionId, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataCollectionId=");
		msg.append(dataCollectionId);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataCollectionId_First(
		long dataCollectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		List<DataAnalysisLayout> list = findByDataCollectionId(
			dataCollectionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataCollectionId_Last(
			dataCollectionId, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataCollectionId=");
		msg.append(dataCollectionId);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataCollectionId_Last(
		long dataCollectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		int count = countByDataCollectionId(dataCollectionId);

		if (count == 0) {
			return null;
		}

		List<DataAnalysisLayout> list = findByDataCollectionId(
			dataCollectionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout[] findByDataCollectionId_PrevAndNext(
			String dataUuid, long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			DataAnalysisLayout[] array = new DataAnalysisLayoutImpl[3];

			array[0] = getByDataCollectionId_PrevAndNext(
				session, dataAnalysisLayout, dataCollectionId,
				orderByComparator, true);

			array[1] = dataAnalysisLayout;

			array[2] = getByDataCollectionId_PrevAndNext(
				session, dataAnalysisLayout, dataCollectionId,
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

	protected DataAnalysisLayout getByDataCollectionId_PrevAndNext(
		Session session, DataAnalysisLayout dataAnalysisLayout,
		long dataCollectionId,
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

		query.append(_FINDER_COLUMN_DATACOLLECTIONID_DATACOLLECTIONID_2);

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

		qPos.add(dataCollectionId);

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
	 * Removes all the data analysis layouts where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	@Override
	public void removeByDataCollectionId(long dataCollectionId) {
		for (DataAnalysisLayout dataAnalysisLayout :
				findByDataCollectionId(
					dataCollectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataAnalysisLayout);
		}
	}

	/**
	 * Returns the number of data analysis layouts where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching data analysis layouts
	 */
	@Override
	public int countByDataCollectionId(long dataCollectionId) {
		FinderPath finderPath = _finderPathCountByDataCollectionId;

		Object[] finderArgs = new Object[] {dataCollectionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAANALYSISLAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DATACOLLECTIONID_DATACOLLECTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataCollectionId);

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
		_FINDER_COLUMN_DATACOLLECTIONID_DATACOLLECTIONID_2 =
			"dataAnalysisLayout.dataCollectionId = ?";

	private FinderPath _finderPathWithPaginationFindByDataSetId;
	private FinderPath _finderPathWithoutPaginationFindByDataSetId;
	private FinderPath _finderPathCountByDataSetId;

	/**
	 * Returns all the data analysis layouts where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataSetId(long dataSetId) {
		return findByDataSetId(
			dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end) {

		return findByDataSetId(dataSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return findByDataSetId(dataSetId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDataSetId;
			finderArgs = new Object[] {dataSetId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataSetId;
			finderArgs = new Object[] {
				dataSetId, start, end, orderByComparator
			};
		}

		List<DataAnalysisLayout> list = null;

		if (retrieveFromCache) {
			list = (List<DataAnalysisLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataAnalysisLayout dataAnalysisLayout : list) {
					if ((dataSetId != dataAnalysisLayout.getDataSetId())) {
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

			query.append(_SQL_SELECT_DATAANALYSISLAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

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

				qPos.add(dataSetId);

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
	 * Returns the first data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataSetId_First(
			long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataSetId_First(
			dataSetId, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataSetId=");
		msg.append(dataSetId);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataSetId_First(
		long dataSetId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		List<DataAnalysisLayout> list = findByDataSetId(
			dataSetId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataSetId_Last(
			long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataSetId_Last(
			dataSetId, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataSetId=");
		msg.append(dataSetId);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataSetId_Last(
		long dataSetId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		int count = countByDataSetId(dataSetId);

		if (count == 0) {
			return null;
		}

		List<DataAnalysisLayout> list = findByDataSetId(
			dataSetId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout[] findByDataSetId_PrevAndNext(
			String dataUuid, long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			DataAnalysisLayout[] array = new DataAnalysisLayoutImpl[3];

			array[0] = getByDataSetId_PrevAndNext(
				session, dataAnalysisLayout, dataSetId, orderByComparator,
				true);

			array[1] = dataAnalysisLayout;

			array[2] = getByDataSetId_PrevAndNext(
				session, dataAnalysisLayout, dataSetId, orderByComparator,
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

	protected DataAnalysisLayout getByDataSetId_PrevAndNext(
		Session session, DataAnalysisLayout dataAnalysisLayout, long dataSetId,
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

		query.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

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

		qPos.add(dataSetId);

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
	 * Removes all the data analysis layouts where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	@Override
	public void removeByDataSetId(long dataSetId) {
		for (DataAnalysisLayout dataAnalysisLayout :
				findByDataSetId(
					dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataAnalysisLayout);
		}
	}

	/**
	 * Returns the number of data analysis layouts where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data analysis layouts
	 */
	@Override
	public int countByDataSetId(long dataSetId) {
		FinderPath finderPath = _finderPathCountByDataSetId;

		Object[] finderArgs = new Object[] {dataSetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAANALYSISLAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataSetId);

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

	private static final String _FINDER_COLUMN_DATASETID_DATASETID_2 =
		"dataAnalysisLayout.dataSetId = ?";

	private FinderPath _finderPathWithPaginationFindByDataSectionId;
	private FinderPath _finderPathWithoutPaginationFindByDataSectionId;
	private FinderPath _finderPathCountByDataSectionId;

	/**
	 * Returns all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataSectionId(long dataSectionId) {
		return findByDataSectionId(
			dataSectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end) {

		return findByDataSectionId(dataSectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return findByDataSectionId(
			dataSectionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDataSectionId;
			finderArgs = new Object[] {dataSectionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataSectionId;
			finderArgs = new Object[] {
				dataSectionId, start, end, orderByComparator
			};
		}

		List<DataAnalysisLayout> list = null;

		if (retrieveFromCache) {
			list = (List<DataAnalysisLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataAnalysisLayout dataAnalysisLayout : list) {
					if ((dataSectionId !=
							dataAnalysisLayout.getDataSectionId())) {

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

			query.append(_SQL_SELECT_DATAANALYSISLAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DATASECTIONID_DATASECTIONID_2);

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

				qPos.add(dataSectionId);

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
	 * Returns the first data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataSectionId_First(
			long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataSectionId_First(
			dataSectionId, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataSectionId=");
		msg.append(dataSectionId);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataSectionId_First(
		long dataSectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		List<DataAnalysisLayout> list = findByDataSectionId(
			dataSectionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataSectionId_Last(
			long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataSectionId_Last(
			dataSectionId, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataSectionId=");
		msg.append(dataSectionId);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataSectionId_Last(
		long dataSectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		int count = countByDataSectionId(dataSectionId);

		if (count == 0) {
			return null;
		}

		List<DataAnalysisLayout> list = findByDataSectionId(
			dataSectionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout[] findByDataSectionId_PrevAndNext(
			String dataUuid, long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			DataAnalysisLayout[] array = new DataAnalysisLayoutImpl[3];

			array[0] = getByDataSectionId_PrevAndNext(
				session, dataAnalysisLayout, dataSectionId, orderByComparator,
				true);

			array[1] = dataAnalysisLayout;

			array[2] = getByDataSectionId_PrevAndNext(
				session, dataAnalysisLayout, dataSectionId, orderByComparator,
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

	protected DataAnalysisLayout getByDataSectionId_PrevAndNext(
		Session session, DataAnalysisLayout dataAnalysisLayout,
		long dataSectionId,
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

		query.append(_FINDER_COLUMN_DATASECTIONID_DATASECTIONID_2);

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

		qPos.add(dataSectionId);

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
	 * Removes all the data analysis layouts where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	@Override
	public void removeByDataSectionId(long dataSectionId) {
		for (DataAnalysisLayout dataAnalysisLayout :
				findByDataSectionId(
					dataSectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataAnalysisLayout);
		}
	}

	/**
	 * Returns the number of data analysis layouts where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching data analysis layouts
	 */
	@Override
	public int countByDataSectionId(long dataSectionId) {
		FinderPath finderPath = _finderPathCountByDataSectionId;

		Object[] finderArgs = new Object[] {dataSectionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAANALYSISLAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DATASECTIONID_DATASECTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataSectionId);

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

	private static final String _FINDER_COLUMN_DATASECTIONID_DATASECTIONID_2 =
		"dataAnalysisLayout.dataSectionId = ?";

	private FinderPath _finderPathWithPaginationFindByDataPackId;
	private FinderPath _finderPathWithoutPaginationFindByDataPackId;
	private FinderPath _finderPathCountByDataPackId;

	/**
	 * Returns all the data analysis layouts where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataPackId(long dataPackId) {
		return findByDataPackId(
			dataPackId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end) {

		return findByDataPackId(dataPackId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return findByDataPackId(
			dataPackId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByDataPackId;
			finderArgs = new Object[] {dataPackId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByDataPackId;
			finderArgs = new Object[] {
				dataPackId, start, end, orderByComparator
			};
		}

		List<DataAnalysisLayout> list = null;

		if (retrieveFromCache) {
			list = (List<DataAnalysisLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataAnalysisLayout dataAnalysisLayout : list) {
					if ((dataPackId != dataAnalysisLayout.getDataPackId())) {
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

			query.append(_SQL_SELECT_DATAANALYSISLAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DATAPACKID_DATAPACKID_2);

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

				qPos.add(dataPackId);

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
	 * Returns the first data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataPackId_First(
			long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataPackId_First(
			dataPackId, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataPackId=");
		msg.append(dataPackId);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the first data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataPackId_First(
		long dataPackId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		List<DataAnalysisLayout> list = findByDataPackId(
			dataPackId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout findByDataPackId_Last(
			long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = fetchByDataPackId_Last(
			dataPackId, orderByComparator);

		if (dataAnalysisLayout != null) {
			return dataAnalysisLayout;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataPackId=");
		msg.append(dataPackId);

		msg.append("}");

		throw new NoSuchDataAnalysisLayoutException(msg.toString());
	}

	/**
	 * Returns the last data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	@Override
	public DataAnalysisLayout fetchByDataPackId_Last(
		long dataPackId,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		int count = countByDataPackId(dataPackId);

		if (count == 0) {
			return null;
		}

		List<DataAnalysisLayout> list = findByDataPackId(
			dataPackId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout[] findByDataPackId_PrevAndNext(
			String dataUuid, long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException {

		DataAnalysisLayout dataAnalysisLayout = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			DataAnalysisLayout[] array = new DataAnalysisLayoutImpl[3];

			array[0] = getByDataPackId_PrevAndNext(
				session, dataAnalysisLayout, dataPackId, orderByComparator,
				true);

			array[1] = dataAnalysisLayout;

			array[2] = getByDataPackId_PrevAndNext(
				session, dataAnalysisLayout, dataPackId, orderByComparator,
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

	protected DataAnalysisLayout getByDataPackId_PrevAndNext(
		Session session, DataAnalysisLayout dataAnalysisLayout, long dataPackId,
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

		query.append(_FINDER_COLUMN_DATAPACKID_DATAPACKID_2);

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

		qPos.add(dataPackId);

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
	 * Removes all the data analysis layouts where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	@Override
	public void removeByDataPackId(long dataPackId) {
		for (DataAnalysisLayout dataAnalysisLayout :
				findByDataPackId(
					dataPackId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataAnalysisLayout);
		}
	}

	/**
	 * Returns the number of data analysis layouts where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching data analysis layouts
	 */
	@Override
	public int countByDataPackId(long dataPackId) {
		FinderPath finderPath = _finderPathCountByDataPackId;

		Object[] finderArgs = new Object[] {dataPackId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAANALYSISLAYOUT_WHERE);

			query.append(_FINDER_COLUMN_DATAPACKID_DATAPACKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataPackId);

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

	private static final String _FINDER_COLUMN_DATAPACKID_DATAPACKID_2 =
		"dataAnalysisLayout.dataPackId = ?";

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
	}

	@Override
	public void clearCache(List<DataAnalysisLayout> dataAnalysisLayouts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataAnalysisLayout dataAnalysisLayout : dataAnalysisLayouts) {
			entityCache.removeResult(
				entityCacheEnabled, DataAnalysisLayoutImpl.class,
				dataAnalysisLayout.getPrimaryKey());
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
				dataAnalysisLayoutModelImpl.getDataCollectionId()
			};

			finderCache.removeResult(_finderPathCountByDataCollectionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataCollectionId, args);

			args = new Object[] {dataAnalysisLayoutModelImpl.getDataSetId()};

			finderCache.removeResult(_finderPathCountByDataSetId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataSetId, args);

			args = new Object[] {
				dataAnalysisLayoutModelImpl.getDataSectionId()
			};

			finderCache.removeResult(_finderPathCountByDataSectionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataSectionId, args);

			args = new Object[] {dataAnalysisLayoutModelImpl.getDataPackId()};

			finderCache.removeResult(_finderPathCountByDataPackId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataPackId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataAnalysisLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataCollectionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataAnalysisLayoutModelImpl.getOriginalDataCollectionId()
				};

				finderCache.removeResult(
					_finderPathCountByDataCollectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataCollectionId, args);

				args = new Object[] {
					dataAnalysisLayoutModelImpl.getDataCollectionId()
				};

				finderCache.removeResult(
					_finderPathCountByDataCollectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataCollectionId, args);
			}

			if ((dataAnalysisLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataSetId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataAnalysisLayoutModelImpl.getOriginalDataSetId()
				};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);

				args = new Object[] {
					dataAnalysisLayoutModelImpl.getDataSetId()
				};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);
			}

			if ((dataAnalysisLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataSectionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataAnalysisLayoutModelImpl.getOriginalDataSectionId()
				};

				finderCache.removeResult(_finderPathCountByDataSectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSectionId, args);

				args = new Object[] {
					dataAnalysisLayoutModelImpl.getDataSectionId()
				};

				finderCache.removeResult(_finderPathCountByDataSectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSectionId, args);
			}

			if ((dataAnalysisLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataPackId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataAnalysisLayoutModelImpl.getOriginalDataPackId()
				};

				finderCache.removeResult(_finderPathCountByDataPackId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataPackId, args);

				args = new Object[] {
					dataAnalysisLayoutModelImpl.getDataPackId()
				};

				finderCache.removeResult(_finderPathCountByDataPackId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataPackId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DataAnalysisLayoutImpl.class,
			dataAnalysisLayout.getPrimaryKey(), dataAnalysisLayout, false);

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
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findAll(
		int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> findAll(
		int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
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

		List<DataAnalysisLayout> list = null;

		if (retrieveFromCache) {
			list = (List<DataAnalysisLayout>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

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

		_finderPathWithPaginationFindByDataCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataCollectionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataCollectionId",
			new String[] {Long.class.getName()},
			DataAnalysisLayoutModelImpl.DATACOLLECTIONID_COLUMN_BITMASK);

		_finderPathCountByDataCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataCollectionId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataSetId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataSetId",
			new String[] {Long.class.getName()},
			DataAnalysisLayoutModelImpl.DATASETID_COLUMN_BITMASK);

		_finderPathCountByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataSetId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataSectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataSectionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataSectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataSectionId",
			new String[] {Long.class.getName()},
			DataAnalysisLayoutModelImpl.DATASECTIONID_COLUMN_BITMASK);

		_finderPathCountByDataSectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataSectionId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataPackId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataPackId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataPackId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			DataAnalysisLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataPackId",
			new String[] {Long.class.getName()},
			DataAnalysisLayoutModelImpl.DATAPACKID_COLUMN_BITMASK);

		_finderPathCountByDataPackId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataPackId",
			new String[] {Long.class.getName()});
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

}