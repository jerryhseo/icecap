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

import com.osp.icecap.exception.NoSuchMetaDataException;
import com.osp.icecap.model.MetaData;
import com.osp.icecap.model.impl.MetaDataImpl;
import com.osp.icecap.model.impl.MetaDataModelImpl;
import com.osp.icecap.service.persistence.MetaDataPersistence;
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
 * The persistence implementation for the meta data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = MetaDataPersistence.class)
@ProviderType
public class MetaDataPersistenceImpl
	extends BasePersistenceImpl<MetaData> implements MetaDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MetaDataUtil</code> to access the meta data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MetaDataImpl.class.getName();

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
	 * Returns all the meta datas where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching meta datas
	 */
	@Override
	public List<MetaData> findByDataCollectionId(long dataCollectionId) {
		return findByDataCollectionId(
			dataCollectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the meta datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	@Override
	public List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end) {

		return findByDataCollectionId(dataCollectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataCollectionId(long, int, int, OrderByComparator)}
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching meta datas
	 */
	@Deprecated
	@Override
	public List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<MetaData> orderByComparator, boolean useFinderCache) {

		return findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	@Override
	public List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

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

		List<MetaData> list = (List<MetaData>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MetaData metaData : list) {
				if ((dataCollectionId != metaData.getDataCollectionId())) {
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

			query.append(_SQL_SELECT_METADATA_WHERE);

			query.append(_FINDER_COLUMN_DATACOLLECTIONID_DATACOLLECTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(MetaDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataCollectionId);

				if (!pagination) {
					list = (List<MetaData>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MetaData>)QueryUtil.list(
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
	 * Returns the first meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByDataCollectionId_First(
			dataCollectionId, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataCollectionId=");
		msg.append(dataCollectionId);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the first meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByDataCollectionId_First(
		long dataCollectionId, OrderByComparator<MetaData> orderByComparator) {

		List<MetaData> list = findByDataCollectionId(
			dataCollectionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByDataCollectionId_Last(
			dataCollectionId, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataCollectionId=");
		msg.append(dataCollectionId);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the last meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByDataCollectionId_Last(
		long dataCollectionId, OrderByComparator<MetaData> orderByComparator) {

		int count = countByDataCollectionId(dataCollectionId);

		if (count == 0) {
			return null;
		}

		List<MetaData> list = findByDataCollectionId(
			dataCollectionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData[] findByDataCollectionId_PrevAndNext(
			String dataUuid, long dataCollectionId,
			OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			MetaData[] array = new MetaDataImpl[3];

			array[0] = getByDataCollectionId_PrevAndNext(
				session, metaData, dataCollectionId, orderByComparator, true);

			array[1] = metaData;

			array[2] = getByDataCollectionId_PrevAndNext(
				session, metaData, dataCollectionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MetaData getByDataCollectionId_PrevAndNext(
		Session session, MetaData metaData, long dataCollectionId,
		OrderByComparator<MetaData> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_METADATA_WHERE);

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
			query.append(MetaDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dataCollectionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(metaData)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<MetaData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the meta datas where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	@Override
	public void removeByDataCollectionId(long dataCollectionId) {
		for (MetaData metaData :
				findByDataCollectionId(
					dataCollectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(metaData);
		}
	}

	/**
	 * Returns the number of meta datas where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching meta datas
	 */
	@Override
	public int countByDataCollectionId(long dataCollectionId) {
		FinderPath finderPath = _finderPathCountByDataCollectionId;

		Object[] finderArgs = new Object[] {dataCollectionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_METADATA_WHERE);

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
			"metaData.dataCollectionId = ?";

	private FinderPath _finderPathWithPaginationFindByDataSetId;
	private FinderPath _finderPathWithoutPaginationFindByDataSetId;
	private FinderPath _finderPathCountByDataSetId;

	/**
	 * Returns all the meta datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching meta datas
	 */
	@Override
	public List<MetaData> findByDataSetId(long dataSetId) {
		return findByDataSetId(
			dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the meta datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	@Override
	public List<MetaData> findByDataSetId(long dataSetId, int start, int end) {
		return findByDataSetId(dataSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataSetId(long, int, int, OrderByComparator)}
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching meta datas
	 */
	@Deprecated
	@Override
	public List<MetaData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<MetaData> orderByComparator, boolean useFinderCache) {

		return findByDataSetId(dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	@Override
	public List<MetaData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

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

		List<MetaData> list = (List<MetaData>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MetaData metaData : list) {
				if ((dataSetId != metaData.getDataSetId())) {
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

			query.append(_SQL_SELECT_METADATA_WHERE);

			query.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(MetaDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataSetId);

				if (!pagination) {
					list = (List<MetaData>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MetaData>)QueryUtil.list(
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
	 * Returns the first meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByDataSetId_First(
			long dataSetId, OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByDataSetId_First(
			dataSetId, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataSetId=");
		msg.append(dataSetId);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the first meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByDataSetId_First(
		long dataSetId, OrderByComparator<MetaData> orderByComparator) {

		List<MetaData> list = findByDataSetId(
			dataSetId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByDataSetId_Last(
			long dataSetId, OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByDataSetId_Last(dataSetId, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataSetId=");
		msg.append(dataSetId);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the last meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<MetaData> orderByComparator) {

		int count = countByDataSetId(dataSetId);

		if (count == 0) {
			return null;
		}

		List<MetaData> list = findByDataSetId(
			dataSetId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData[] findByDataSetId_PrevAndNext(
			String dataUuid, long dataSetId,
			OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			MetaData[] array = new MetaDataImpl[3];

			array[0] = getByDataSetId_PrevAndNext(
				session, metaData, dataSetId, orderByComparator, true);

			array[1] = metaData;

			array[2] = getByDataSetId_PrevAndNext(
				session, metaData, dataSetId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MetaData getByDataSetId_PrevAndNext(
		Session session, MetaData metaData, long dataSetId,
		OrderByComparator<MetaData> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_METADATA_WHERE);

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
			query.append(MetaDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dataSetId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(metaData)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<MetaData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the meta datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	@Override
	public void removeByDataSetId(long dataSetId) {
		for (MetaData metaData :
				findByDataSetId(
					dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(metaData);
		}
	}

	/**
	 * Returns the number of meta datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching meta datas
	 */
	@Override
	public int countByDataSetId(long dataSetId) {
		FinderPath finderPath = _finderPathCountByDataSetId;

		Object[] finderArgs = new Object[] {dataSetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_METADATA_WHERE);

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
		"metaData.dataSetId = ?";

	private FinderPath _finderPathWithPaginationFindByDataSectionId;
	private FinderPath _finderPathWithoutPaginationFindByDataSectionId;
	private FinderPath _finderPathCountByDataSectionId;

	/**
	 * Returns all the meta datas where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching meta datas
	 */
	@Override
	public List<MetaData> findByDataSectionId(long dataSectionId) {
		return findByDataSectionId(
			dataSectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the meta datas where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	@Override
	public List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end) {

		return findByDataSectionId(dataSectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataSectionId(long, int, int, OrderByComparator)}
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching meta datas
	 */
	@Deprecated
	@Override
	public List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<MetaData> orderByComparator, boolean useFinderCache) {

		return findByDataSectionId(
			dataSectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	@Override
	public List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

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

		List<MetaData> list = (List<MetaData>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MetaData metaData : list) {
				if ((dataSectionId != metaData.getDataSectionId())) {
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

			query.append(_SQL_SELECT_METADATA_WHERE);

			query.append(_FINDER_COLUMN_DATASECTIONID_DATASECTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(MetaDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataSectionId);

				if (!pagination) {
					list = (List<MetaData>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MetaData>)QueryUtil.list(
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
	 * Returns the first meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByDataSectionId_First(
			long dataSectionId, OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByDataSectionId_First(
			dataSectionId, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataSectionId=");
		msg.append(dataSectionId);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the first meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByDataSectionId_First(
		long dataSectionId, OrderByComparator<MetaData> orderByComparator) {

		List<MetaData> list = findByDataSectionId(
			dataSectionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByDataSectionId_Last(
			long dataSectionId, OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByDataSectionId_Last(
			dataSectionId, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataSectionId=");
		msg.append(dataSectionId);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the last meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByDataSectionId_Last(
		long dataSectionId, OrderByComparator<MetaData> orderByComparator) {

		int count = countByDataSectionId(dataSectionId);

		if (count == 0) {
			return null;
		}

		List<MetaData> list = findByDataSectionId(
			dataSectionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData[] findByDataSectionId_PrevAndNext(
			String dataUuid, long dataSectionId,
			OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			MetaData[] array = new MetaDataImpl[3];

			array[0] = getByDataSectionId_PrevAndNext(
				session, metaData, dataSectionId, orderByComparator, true);

			array[1] = metaData;

			array[2] = getByDataSectionId_PrevAndNext(
				session, metaData, dataSectionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MetaData getByDataSectionId_PrevAndNext(
		Session session, MetaData metaData, long dataSectionId,
		OrderByComparator<MetaData> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_METADATA_WHERE);

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
			query.append(MetaDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dataSectionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(metaData)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<MetaData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the meta datas where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	@Override
	public void removeByDataSectionId(long dataSectionId) {
		for (MetaData metaData :
				findByDataSectionId(
					dataSectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(metaData);
		}
	}

	/**
	 * Returns the number of meta datas where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching meta datas
	 */
	@Override
	public int countByDataSectionId(long dataSectionId) {
		FinderPath finderPath = _finderPathCountByDataSectionId;

		Object[] finderArgs = new Object[] {dataSectionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_METADATA_WHERE);

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
		"metaData.dataSectionId = ?";

	private FinderPath _finderPathWithPaginationFindByDataPackId;
	private FinderPath _finderPathWithoutPaginationFindByDataPackId;
	private FinderPath _finderPathCountByDataPackId;

	/**
	 * Returns all the meta datas where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching meta datas
	 */
	@Override
	public List<MetaData> findByDataPackId(long dataPackId) {
		return findByDataPackId(
			dataPackId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the meta datas where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	@Override
	public List<MetaData> findByDataPackId(
		long dataPackId, int start, int end) {

		return findByDataPackId(dataPackId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataPackId(long, int, int, OrderByComparator)}
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching meta datas
	 */
	@Deprecated
	@Override
	public List<MetaData> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<MetaData> orderByComparator, boolean useFinderCache) {

		return findByDataPackId(dataPackId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	@Override
	public List<MetaData> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

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

		List<MetaData> list = (List<MetaData>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MetaData metaData : list) {
				if ((dataPackId != metaData.getDataPackId())) {
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

			query.append(_SQL_SELECT_METADATA_WHERE);

			query.append(_FINDER_COLUMN_DATAPACKID_DATAPACKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(MetaDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataPackId);

				if (!pagination) {
					list = (List<MetaData>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MetaData>)QueryUtil.list(
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
	 * Returns the first meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByDataPackId_First(
			long dataPackId, OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByDataPackId_First(
			dataPackId, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataPackId=");
		msg.append(dataPackId);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the first meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByDataPackId_First(
		long dataPackId, OrderByComparator<MetaData> orderByComparator) {

		List<MetaData> list = findByDataPackId(
			dataPackId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByDataPackId_Last(
			long dataPackId, OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByDataPackId_Last(
			dataPackId, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dataPackId=");
		msg.append(dataPackId);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the last meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByDataPackId_Last(
		long dataPackId, OrderByComparator<MetaData> orderByComparator) {

		int count = countByDataPackId(dataPackId);

		if (count == 0) {
			return null;
		}

		List<MetaData> list = findByDataPackId(
			dataPackId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData[] findByDataPackId_PrevAndNext(
			String dataUuid, long dataPackId,
			OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			MetaData[] array = new MetaDataImpl[3];

			array[0] = getByDataPackId_PrevAndNext(
				session, metaData, dataPackId, orderByComparator, true);

			array[1] = metaData;

			array[2] = getByDataPackId_PrevAndNext(
				session, metaData, dataPackId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MetaData getByDataPackId_PrevAndNext(
		Session session, MetaData metaData, long dataPackId,
		OrderByComparator<MetaData> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_METADATA_WHERE);

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
			query.append(MetaDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dataPackId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(metaData)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<MetaData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the meta datas where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	@Override
	public void removeByDataPackId(long dataPackId) {
		for (MetaData metaData :
				findByDataPackId(
					dataPackId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(metaData);
		}
	}

	/**
	 * Returns the number of meta datas where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching meta datas
	 */
	@Override
	public int countByDataPackId(long dataPackId) {
		FinderPath finderPath = _finderPathCountByDataPackId;

		Object[] finderArgs = new Object[] {dataPackId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_METADATA_WHERE);

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
		"metaData.dataPackId = ?";

	private FinderPath _finderPathWithPaginationFindByCreator;
	private FinderPath _finderPathWithoutPaginationFindByCreator;
	private FinderPath _finderPathCountByCreator;

	/**
	 * Returns all the meta datas where creator = &#63;.
	 *
	 * @param creator the creator
	 * @return the matching meta datas
	 */
	@Override
	public List<MetaData> findByCreator(String creator) {
		return findByCreator(
			creator, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the meta datas where creator = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creator the creator
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of matching meta datas
	 */
	@Override
	public List<MetaData> findByCreator(String creator, int start, int end) {
		return findByCreator(creator, start, end, null);
	}

	/**
	 * Returns an ordered range of all the meta datas where creator = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCreator(String, int, int, OrderByComparator)}
	 * @param creator the creator
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching meta datas
	 */
	@Deprecated
	@Override
	public List<MetaData> findByCreator(
		String creator, int start, int end,
		OrderByComparator<MetaData> orderByComparator, boolean useFinderCache) {

		return findByCreator(creator, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas where creator = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creator the creator
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching meta datas
	 */
	@Override
	public List<MetaData> findByCreator(
		String creator, int start, int end,
		OrderByComparator<MetaData> orderByComparator) {

		creator = Objects.toString(creator, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCreator;
			finderArgs = new Object[] {creator};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCreator;
			finderArgs = new Object[] {creator, start, end, orderByComparator};
		}

		List<MetaData> list = (List<MetaData>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MetaData metaData : list) {
				if (!creator.equals(metaData.getCreator())) {
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

			query.append(_SQL_SELECT_METADATA_WHERE);

			boolean bindCreator = false;

			if (creator.isEmpty()) {
				query.append(_FINDER_COLUMN_CREATOR_CREATOR_3);
			}
			else {
				bindCreator = true;

				query.append(_FINDER_COLUMN_CREATOR_CREATOR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(MetaDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreator) {
					qPos.add(creator);
				}

				if (!pagination) {
					list = (List<MetaData>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MetaData>)QueryUtil.list(
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
	 * Returns the first meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByCreator_First(
			String creator, OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByCreator_First(creator, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creator=");
		msg.append(creator);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the first meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByCreator_First(
		String creator, OrderByComparator<MetaData> orderByComparator) {

		List<MetaData> list = findByCreator(creator, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	@Override
	public MetaData findByCreator_Last(
			String creator, OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByCreator_Last(creator, orderByComparator);

		if (metaData != null) {
			return metaData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creator=");
		msg.append(creator);

		msg.append("}");

		throw new NoSuchMetaDataException(msg.toString());
	}

	/**
	 * Returns the last meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	@Override
	public MetaData fetchByCreator_Last(
		String creator, OrderByComparator<MetaData> orderByComparator) {

		int count = countByCreator(creator);

		if (count == 0) {
			return null;
		}

		List<MetaData> list = findByCreator(
			creator, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where creator = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData[] findByCreator_PrevAndNext(
			String dataUuid, String creator,
			OrderByComparator<MetaData> orderByComparator)
		throws NoSuchMetaDataException {

		creator = Objects.toString(creator, "");

		MetaData metaData = findByPrimaryKey(dataUuid);

		Session session = null;

		try {
			session = openSession();

			MetaData[] array = new MetaDataImpl[3];

			array[0] = getByCreator_PrevAndNext(
				session, metaData, creator, orderByComparator, true);

			array[1] = metaData;

			array[2] = getByCreator_PrevAndNext(
				session, metaData, creator, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MetaData getByCreator_PrevAndNext(
		Session session, MetaData metaData, String creator,
		OrderByComparator<MetaData> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_METADATA_WHERE);

		boolean bindCreator = false;

		if (creator.isEmpty()) {
			query.append(_FINDER_COLUMN_CREATOR_CREATOR_3);
		}
		else {
			bindCreator = true;

			query.append(_FINDER_COLUMN_CREATOR_CREATOR_2);
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
			query.append(MetaDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreator) {
			qPos.add(creator);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(metaData)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<MetaData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the meta datas where creator = &#63; from the database.
	 *
	 * @param creator the creator
	 */
	@Override
	public void removeByCreator(String creator) {
		for (MetaData metaData :
				findByCreator(
					creator, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(metaData);
		}
	}

	/**
	 * Returns the number of meta datas where creator = &#63;.
	 *
	 * @param creator the creator
	 * @return the number of matching meta datas
	 */
	@Override
	public int countByCreator(String creator) {
		creator = Objects.toString(creator, "");

		FinderPath finderPath = _finderPathCountByCreator;

		Object[] finderArgs = new Object[] {creator};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_METADATA_WHERE);

			boolean bindCreator = false;

			if (creator.isEmpty()) {
				query.append(_FINDER_COLUMN_CREATOR_CREATOR_3);
			}
			else {
				bindCreator = true;

				query.append(_FINDER_COLUMN_CREATOR_CREATOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreator) {
					qPos.add(creator);
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

	private static final String _FINDER_COLUMN_CREATOR_CREATOR_2 =
		"metaData.creator = ?";

	private static final String _FINDER_COLUMN_CREATOR_CREATOR_3 =
		"(metaData.creator IS NULL OR metaData.creator = '')";

	public MetaDataPersistenceImpl() {
		setModelClass(MetaData.class);

		setModelImplClass(MetaDataImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the meta data in the entity cache if it is enabled.
	 *
	 * @param metaData the meta data
	 */
	@Override
	public void cacheResult(MetaData metaData) {
		entityCache.putResult(
			entityCacheEnabled, MetaDataImpl.class, metaData.getPrimaryKey(),
			metaData);

		metaData.resetOriginalValues();
	}

	/**
	 * Caches the meta datas in the entity cache if it is enabled.
	 *
	 * @param metaDatas the meta datas
	 */
	@Override
	public void cacheResult(List<MetaData> metaDatas) {
		for (MetaData metaData : metaDatas) {
			if (entityCache.getResult(
					entityCacheEnabled, MetaDataImpl.class,
					metaData.getPrimaryKey()) == null) {

				cacheResult(metaData);
			}
			else {
				metaData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all meta datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MetaDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the meta data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MetaData metaData) {
		entityCache.removeResult(
			entityCacheEnabled, MetaDataImpl.class, metaData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MetaData> metaDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MetaData metaData : metaDatas) {
			entityCache.removeResult(
				entityCacheEnabled, MetaDataImpl.class,
				metaData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new meta data with the primary key. Does not add the meta data to the database.
	 *
	 * @param dataUuid the primary key for the new meta data
	 * @return the new meta data
	 */
	@Override
	public MetaData create(String dataUuid) {
		MetaData metaData = new MetaDataImpl();

		metaData.setNew(true);
		metaData.setPrimaryKey(dataUuid);

		return metaData;
	}

	/**
	 * Removes the meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data that was removed
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData remove(String dataUuid) throws NoSuchMetaDataException {
		return remove((Serializable)dataUuid);
	}

	/**
	 * Removes the meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the meta data
	 * @return the meta data that was removed
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData remove(Serializable primaryKey)
		throws NoSuchMetaDataException {

		Session session = null;

		try {
			session = openSession();

			MetaData metaData = (MetaData)session.get(
				MetaDataImpl.class, primaryKey);

			if (metaData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetaDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(metaData);
		}
		catch (NoSuchMetaDataException nsee) {
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
	protected MetaData removeImpl(MetaData metaData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metaData)) {
				metaData = (MetaData)session.get(
					MetaDataImpl.class, metaData.getPrimaryKeyObj());
			}

			if (metaData != null) {
				session.delete(metaData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (metaData != null) {
			clearCache(metaData);
		}

		return metaData;
	}

	@Override
	public MetaData updateImpl(MetaData metaData) {
		boolean isNew = metaData.isNew();

		if (!(metaData instanceof MetaDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(metaData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(metaData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in metaData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MetaData implementation " +
					metaData.getClass());
		}

		MetaDataModelImpl metaDataModelImpl = (MetaDataModelImpl)metaData;

		Session session = null;

		try {
			session = openSession();

			if (metaData.isNew()) {
				session.save(metaData);

				metaData.setNew(false);
			}
			else {
				metaData = (MetaData)session.merge(metaData);
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
				metaDataModelImpl.getDataCollectionId()
			};

			finderCache.removeResult(_finderPathCountByDataCollectionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataCollectionId, args);

			args = new Object[] {metaDataModelImpl.getDataSetId()};

			finderCache.removeResult(_finderPathCountByDataSetId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataSetId, args);

			args = new Object[] {metaDataModelImpl.getDataSectionId()};

			finderCache.removeResult(_finderPathCountByDataSectionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataSectionId, args);

			args = new Object[] {metaDataModelImpl.getDataPackId()};

			finderCache.removeResult(_finderPathCountByDataPackId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataPackId, args);

			args = new Object[] {metaDataModelImpl.getCreator()};

			finderCache.removeResult(_finderPathCountByCreator, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCreator, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((metaDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataCollectionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					metaDataModelImpl.getOriginalDataCollectionId()
				};

				finderCache.removeResult(
					_finderPathCountByDataCollectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataCollectionId, args);

				args = new Object[] {metaDataModelImpl.getDataCollectionId()};

				finderCache.removeResult(
					_finderPathCountByDataCollectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataCollectionId, args);
			}

			if ((metaDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataSetId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					metaDataModelImpl.getOriginalDataSetId()
				};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);

				args = new Object[] {metaDataModelImpl.getDataSetId()};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);
			}

			if ((metaDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataSectionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					metaDataModelImpl.getOriginalDataSectionId()
				};

				finderCache.removeResult(_finderPathCountByDataSectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSectionId, args);

				args = new Object[] {metaDataModelImpl.getDataSectionId()};

				finderCache.removeResult(_finderPathCountByDataSectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSectionId, args);
			}

			if ((metaDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataPackId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					metaDataModelImpl.getOriginalDataPackId()
				};

				finderCache.removeResult(_finderPathCountByDataPackId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataPackId, args);

				args = new Object[] {metaDataModelImpl.getDataPackId()};

				finderCache.removeResult(_finderPathCountByDataPackId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataPackId, args);
			}

			if ((metaDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCreator.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					metaDataModelImpl.getOriginalCreator()
				};

				finderCache.removeResult(_finderPathCountByCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCreator, args);

				args = new Object[] {metaDataModelImpl.getCreator()};

				finderCache.removeResult(_finderPathCountByCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCreator, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, MetaDataImpl.class, metaData.getPrimaryKey(),
			metaData, false);

		metaData.resetOriginalValues();

		return metaData;
	}

	/**
	 * Returns the meta data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the meta data
	 * @return the meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetaDataException {

		MetaData metaData = fetchByPrimaryKey(primaryKey);

		if (metaData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetaDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return metaData;
	}

	/**
	 * Returns the meta data with the primary key or throws a <code>NoSuchMetaDataException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData findByPrimaryKey(String dataUuid)
		throws NoSuchMetaDataException {

		return findByPrimaryKey((Serializable)dataUuid);
	}

	/**
	 * Returns the meta data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data, or <code>null</code> if a meta data with the primary key could not be found
	 */
	@Override
	public MetaData fetchByPrimaryKey(String dataUuid) {
		return fetchByPrimaryKey((Serializable)dataUuid);
	}

	/**
	 * Returns all the meta datas.
	 *
	 * @return the meta datas
	 */
	@Override
	public List<MetaData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @return the range of meta datas
	 */
	@Override
	public List<MetaData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of meta datas
	 */
	@Deprecated
	@Override
	public List<MetaData> findAll(
		int start, int end, OrderByComparator<MetaData> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetaDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of meta datas
	 * @param end the upper bound of the range of meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of meta datas
	 */
	@Override
	public List<MetaData> findAll(
		int start, int end, OrderByComparator<MetaData> orderByComparator) {

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

		List<MetaData> list = (List<MetaData>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_METADATA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_METADATA;

				if (pagination) {
					sql = sql.concat(MetaDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MetaData>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MetaData>)QueryUtil.list(
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
	 * Removes all the meta datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MetaData metaData : findAll()) {
			remove(metaData);
		}
	}

	/**
	 * Returns the number of meta datas.
	 *
	 * @return the number of meta datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_METADATA);

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
		return _SQL_SELECT_METADATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MetaDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the meta data persistence.
	 */
	@Activate
	public void activate() {
		MetaDataModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		MetaDataModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDataCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataCollectionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataCollectionId",
			new String[] {Long.class.getName()},
			MetaDataModelImpl.DATACOLLECTIONID_COLUMN_BITMASK);

		_finderPathCountByDataCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataCollectionId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataSetId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataSetId",
			new String[] {Long.class.getName()},
			MetaDataModelImpl.DATASETID_COLUMN_BITMASK);

		_finderPathCountByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataSetId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataSectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataSectionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataSectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataSectionId",
			new String[] {Long.class.getName()},
			MetaDataModelImpl.DATASECTIONID_COLUMN_BITMASK);

		_finderPathCountByDataSectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataSectionId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataPackId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataPackId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataPackId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataPackId",
			new String[] {Long.class.getName()},
			MetaDataModelImpl.DATAPACKID_COLUMN_BITMASK);

		_finderPathCountByDataPackId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataPackId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCreator = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreator",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCreator = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MetaDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreator",
			new String[] {String.class.getName()},
			MetaDataModelImpl.CREATOR_COLUMN_BITMASK);

		_finderPathCountByCreator = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreator",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(MetaDataImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.osp.icecap.model.MetaData"),
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

	private static final String _SQL_SELECT_METADATA =
		"SELECT metaData FROM MetaData metaData";

	private static final String _SQL_SELECT_METADATA_WHERE =
		"SELECT metaData FROM MetaData metaData WHERE ";

	private static final String _SQL_COUNT_METADATA =
		"SELECT COUNT(metaData) FROM MetaData metaData";

	private static final String _SQL_COUNT_METADATA_WHERE =
		"SELECT COUNT(metaData) FROM MetaData metaData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "metaData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MetaData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MetaData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MetaDataPersistenceImpl.class);

	static {
		try {
			Class.forName(ICECAPPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}