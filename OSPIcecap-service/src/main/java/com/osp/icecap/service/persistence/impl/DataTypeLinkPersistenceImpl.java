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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icecap.exception.NoSuchDataTypeLinkException;
import com.osp.icecap.model.DataTypeLink;
import com.osp.icecap.model.impl.DataTypeLinkImpl;
import com.osp.icecap.model.impl.DataTypeLinkModelImpl;
import com.osp.icecap.service.persistence.DataTypeLinkPersistence;
import com.osp.icecap.service.persistence.impl.constants.ICECAPPersistenceConstants;

import java.io.Serializable;

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
 * The persistence implementation for the data type link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = DataTypeLinkPersistence.class)
@ProviderType
public class DataTypeLinkPersistenceImpl
	extends BasePersistenceImpl<DataTypeLink>
	implements DataTypeLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataTypeLinkUtil</code> to access the data type link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataTypeLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DataTypeLinkPersistenceImpl() {
		setModelClass(DataTypeLink.class);

		setModelImplClass(DataTypeLinkImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the data type link in the entity cache if it is enabled.
	 *
	 * @param dataTypeLink the data type link
	 */
	@Override
	public void cacheResult(DataTypeLink dataTypeLink) {
		entityCache.putResult(
			entityCacheEnabled, DataTypeLinkImpl.class,
			dataTypeLink.getPrimaryKey(), dataTypeLink);

		dataTypeLink.resetOriginalValues();
	}

	/**
	 * Caches the data type links in the entity cache if it is enabled.
	 *
	 * @param dataTypeLinks the data type links
	 */
	@Override
	public void cacheResult(List<DataTypeLink> dataTypeLinks) {
		for (DataTypeLink dataTypeLink : dataTypeLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, DataTypeLinkImpl.class,
					dataTypeLink.getPrimaryKey()) == null) {

				cacheResult(dataTypeLink);
			}
			else {
				dataTypeLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data type links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataTypeLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data type link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataTypeLink dataTypeLink) {
		entityCache.removeResult(
			entityCacheEnabled, DataTypeLinkImpl.class,
			dataTypeLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DataTypeLink> dataTypeLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataTypeLink dataTypeLink : dataTypeLinks) {
			entityCache.removeResult(
				entityCacheEnabled, DataTypeLinkImpl.class,
				dataTypeLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new data type link with the primary key. Does not add the data type link to the database.
	 *
	 * @param dataUuid the primary key for the new data type link
	 * @return the new data type link
	 */
	@Override
	public DataTypeLink create(String dataUuid) {
		DataTypeLink dataTypeLink = new DataTypeLinkImpl();

		dataTypeLink.setNew(true);
		dataTypeLink.setPrimaryKey(dataUuid);

		return dataTypeLink;
	}

	/**
	 * Removes the data type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link that was removed
	 * @throws NoSuchDataTypeLinkException if a data type link with the primary key could not be found
	 */
	@Override
	public DataTypeLink remove(String dataUuid)
		throws NoSuchDataTypeLinkException {

		return remove((Serializable)dataUuid);
	}

	/**
	 * Removes the data type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data type link
	 * @return the data type link that was removed
	 * @throws NoSuchDataTypeLinkException if a data type link with the primary key could not be found
	 */
	@Override
	public DataTypeLink remove(Serializable primaryKey)
		throws NoSuchDataTypeLinkException {

		Session session = null;

		try {
			session = openSession();

			DataTypeLink dataTypeLink = (DataTypeLink)session.get(
				DataTypeLinkImpl.class, primaryKey);

			if (dataTypeLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataTypeLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataTypeLink);
		}
		catch (NoSuchDataTypeLinkException nsee) {
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
	protected DataTypeLink removeImpl(DataTypeLink dataTypeLink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataTypeLink)) {
				dataTypeLink = (DataTypeLink)session.get(
					DataTypeLinkImpl.class, dataTypeLink.getPrimaryKeyObj());
			}

			if (dataTypeLink != null) {
				session.delete(dataTypeLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataTypeLink != null) {
			clearCache(dataTypeLink);
		}

		return dataTypeLink;
	}

	@Override
	public DataTypeLink updateImpl(DataTypeLink dataTypeLink) {
		boolean isNew = dataTypeLink.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dataTypeLink.isNew()) {
				session.save(dataTypeLink);

				dataTypeLink.setNew(false);
			}
			else {
				dataTypeLink = (DataTypeLink)session.merge(dataTypeLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, DataTypeLinkImpl.class,
			dataTypeLink.getPrimaryKey(), dataTypeLink, false);

		dataTypeLink.resetOriginalValues();

		return dataTypeLink;
	}

	/**
	 * Returns the data type link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data type link
	 * @return the data type link
	 * @throws NoSuchDataTypeLinkException if a data type link with the primary key could not be found
	 */
	@Override
	public DataTypeLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataTypeLinkException {

		DataTypeLink dataTypeLink = fetchByPrimaryKey(primaryKey);

		if (dataTypeLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataTypeLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataTypeLink;
	}

	/**
	 * Returns the data type link with the primary key or throws a <code>NoSuchDataTypeLinkException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link
	 * @throws NoSuchDataTypeLinkException if a data type link with the primary key could not be found
	 */
	@Override
	public DataTypeLink findByPrimaryKey(String dataUuid)
		throws NoSuchDataTypeLinkException {

		return findByPrimaryKey((Serializable)dataUuid);
	}

	/**
	 * Returns the data type link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data type link
	 * @return the data type link, or <code>null</code> if a data type link with the primary key could not be found
	 */
	@Override
	public DataTypeLink fetchByPrimaryKey(String dataUuid) {
		return fetchByPrimaryKey((Serializable)dataUuid);
	}

	/**
	 * Returns all the data type links.
	 *
	 * @return the data type links
	 */
	@Override
	public List<DataTypeLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DataTypeLink> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DataTypeLink> findAll(
		int start, int end, OrderByComparator<DataTypeLink> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<DataTypeLink> findAll(
		int start, int end, OrderByComparator<DataTypeLink> orderByComparator) {

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

		List<DataTypeLink> list = (List<DataTypeLink>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATATYPELINK);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATATYPELINK;

				if (pagination) {
					sql = sql.concat(DataTypeLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataTypeLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataTypeLink>)QueryUtil.list(
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
	 * Removes all the data type links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataTypeLink dataTypeLink : findAll()) {
			remove(dataTypeLink);
		}
	}

	/**
	 * Returns the number of data type links.
	 *
	 * @return the number of data type links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATATYPELINK);

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
		return _SQL_SELECT_DATATYPELINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataTypeLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data type link persistence.
	 */
	@Activate
	public void activate() {
		DataTypeLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataTypeLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataTypeLinkImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.osp.icecap.model.DataTypeLink"),
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

	private static final String _SQL_SELECT_DATATYPELINK =
		"SELECT dataTypeLink FROM DataTypeLink dataTypeLink";

	private static final String _SQL_COUNT_DATATYPELINK =
		"SELECT COUNT(dataTypeLink) FROM DataTypeLink dataTypeLink";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataTypeLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataTypeLink exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DataTypeLinkPersistenceImpl.class);

	static {
		try {
			Class.forName(ICECAPPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}