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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;

import com.osp.icecap.exception.NoSuchDataEntryException;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.model.impl.DataEntryImpl;
import com.osp.icecap.model.impl.DataEntryModelImpl;
import com.osp.icecap.service.persistence.DataEntryPersistence;
import com.osp.icecap.service.persistence.impl.constants.ICECAPPersistenceConstants;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the data entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = DataEntryPersistence.class)
@ProviderType
public class DataEntryPersistenceImpl
	extends BasePersistenceImpl<DataEntry> implements DataEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataEntryUtil</code> to access the data entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DataEntryPersistenceImpl() {
		setModelClass(DataEntry.class);

		setModelImplClass(DataEntryImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("path", "path_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the data entry in the entity cache if it is enabled.
	 *
	 * @param dataEntry the data entry
	 */
	@Override
	public void cacheResult(DataEntry dataEntry) {
		entityCache.putResult(
			entityCacheEnabled, DataEntryImpl.class, dataEntry.getPrimaryKey(),
			dataEntry);

		dataEntry.resetOriginalValues();
	}

	/**
	 * Caches the data entries in the entity cache if it is enabled.
	 *
	 * @param dataEntries the data entries
	 */
	@Override
	public void cacheResult(List<DataEntry> dataEntries) {
		for (DataEntry dataEntry : dataEntries) {
			if (entityCache.getResult(
					entityCacheEnabled, DataEntryImpl.class,
					dataEntry.getPrimaryKey()) == null) {

				cacheResult(dataEntry);
			}
			else {
				dataEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataEntry dataEntry) {
		entityCache.removeResult(
			entityCacheEnabled, DataEntryImpl.class, dataEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DataEntry> dataEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataEntry dataEntry : dataEntries) {
			entityCache.removeResult(
				entityCacheEnabled, DataEntryImpl.class,
				dataEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new data entry with the primary key. Does not add the data entry to the database.
	 *
	 * @param dataEntryId the primary key for the new data entry
	 * @return the new data entry
	 */
	@Override
	public DataEntry create(long dataEntryId) {
		DataEntry dataEntry = new DataEntryImpl();

		dataEntry.setNew(true);
		dataEntry.setPrimaryKey(dataEntryId);

		dataEntry.setCompanyId(companyProvider.getCompanyId());

		return dataEntry;
	}

	/**
	 * Removes the data entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry that was removed
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	@Override
	public DataEntry remove(long dataEntryId) throws NoSuchDataEntryException {
		return remove((Serializable)dataEntryId);
	}

	/**
	 * Removes the data entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data entry
	 * @return the data entry that was removed
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	@Override
	public DataEntry remove(Serializable primaryKey)
		throws NoSuchDataEntryException {

		Session session = null;

		try {
			session = openSession();

			DataEntry dataEntry = (DataEntry)session.get(
				DataEntryImpl.class, primaryKey);

			if (dataEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataEntry);
		}
		catch (NoSuchDataEntryException nsee) {
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
	protected DataEntry removeImpl(DataEntry dataEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataEntry)) {
				dataEntry = (DataEntry)session.get(
					DataEntryImpl.class, dataEntry.getPrimaryKeyObj());
			}

			if (dataEntry != null) {
				session.delete(dataEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataEntry != null) {
			clearCache(dataEntry);
		}

		return dataEntry;
	}

	@Override
	public DataEntry updateImpl(DataEntry dataEntry) {
		boolean isNew = dataEntry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dataEntry.isNew()) {
				session.save(dataEntry);

				dataEntry.setNew(false);
			}
			else {
				dataEntry = (DataEntry)session.merge(dataEntry);
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
			entityCacheEnabled, DataEntryImpl.class, dataEntry.getPrimaryKey(),
			dataEntry, false);

		dataEntry.resetOriginalValues();

		return dataEntry;
	}

	/**
	 * Returns the data entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data entry
	 * @return the data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	@Override
	public DataEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataEntryException {

		DataEntry dataEntry = fetchByPrimaryKey(primaryKey);

		if (dataEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataEntry;
	}

	/**
	 * Returns the data entry with the primary key or throws a <code>NoSuchDataEntryException</code> if it could not be found.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry
	 * @throws NoSuchDataEntryException if a data entry with the primary key could not be found
	 */
	@Override
	public DataEntry findByPrimaryKey(long dataEntryId)
		throws NoSuchDataEntryException {

		return findByPrimaryKey((Serializable)dataEntryId);
	}

	/**
	 * Returns the data entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry, or <code>null</code> if a data entry with the primary key could not be found
	 */
	@Override
	public DataEntry fetchByPrimaryKey(long dataEntryId) {
		return fetchByPrimaryKey((Serializable)dataEntryId);
	}

	/**
	 * Returns all the data entries.
	 *
	 * @return the data entries
	 */
	@Override
	public List<DataEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of data entries
	 */
	@Override
	public List<DataEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data entries
	 */
	@Override
	public List<DataEntry> findAll(
		int start, int end, OrderByComparator<DataEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data entries
	 */
	@Override
	public List<DataEntry> findAll(
		int start, int end, OrderByComparator<DataEntry> orderByComparator,
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

		List<DataEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DataEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATAENTRY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATAENTRY;

				if (pagination) {
					sql = sql.concat(DataEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataEntry>)QueryUtil.list(
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
	 * Removes all the data entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataEntry dataEntry : findAll()) {
			remove(dataEntry);
		}
	}

	/**
	 * Returns the number of data entries.
	 *
	 * @return the number of data entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATAENTRY);

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
		return "dataEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATAENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data entry persistence.
	 */
	@Activate
	public void activate() {
		DataEntryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataEntryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataEntryImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.osp.icecap.model.DataEntry"),
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

	private static final String _SQL_SELECT_DATAENTRY =
		"SELECT dataEntry FROM DataEntry dataEntry";

	private static final String _SQL_COUNT_DATAENTRY =
		"SELECT COUNT(dataEntry) FROM DataEntry dataEntry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataEntry exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DataEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"path"});

}