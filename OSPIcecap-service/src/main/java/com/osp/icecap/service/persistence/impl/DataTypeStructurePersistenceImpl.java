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

import com.osp.icecap.exception.NoSuchDataTypeStructureException;
import com.osp.icecap.model.DataTypeStructure;
import com.osp.icecap.model.impl.DataTypeStructureImpl;
import com.osp.icecap.model.impl.DataTypeStructureModelImpl;
import com.osp.icecap.service.persistence.DataTypeStructurePersistence;
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
 * The persistence implementation for the data type structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = DataTypeStructurePersistence.class)
@ProviderType
public class DataTypeStructurePersistenceImpl
	extends BasePersistenceImpl<DataTypeStructure>
	implements DataTypeStructurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataTypeStructureUtil</code> to access the data type structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataTypeStructureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DataTypeStructurePersistenceImpl() {
		setModelClass(DataTypeStructure.class);

		setModelImplClass(DataTypeStructureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the data type structure in the entity cache if it is enabled.
	 *
	 * @param dataTypeStructure the data type structure
	 */
	@Override
	public void cacheResult(DataTypeStructure dataTypeStructure) {
		entityCache.putResult(
			entityCacheEnabled, DataTypeStructureImpl.class,
			dataTypeStructure.getPrimaryKey(), dataTypeStructure);

		dataTypeStructure.resetOriginalValues();
	}

	/**
	 * Caches the data type structures in the entity cache if it is enabled.
	 *
	 * @param dataTypeStructures the data type structures
	 */
	@Override
	public void cacheResult(List<DataTypeStructure> dataTypeStructures) {
		for (DataTypeStructure dataTypeStructure : dataTypeStructures) {
			if (entityCache.getResult(
					entityCacheEnabled, DataTypeStructureImpl.class,
					dataTypeStructure.getPrimaryKey()) == null) {

				cacheResult(dataTypeStructure);
			}
			else {
				dataTypeStructure.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data type structures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataTypeStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data type structure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataTypeStructure dataTypeStructure) {
		entityCache.removeResult(
			entityCacheEnabled, DataTypeStructureImpl.class,
			dataTypeStructure.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DataTypeStructure> dataTypeStructures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataTypeStructure dataTypeStructure : dataTypeStructures) {
			entityCache.removeResult(
				entityCacheEnabled, DataTypeStructureImpl.class,
				dataTypeStructure.getPrimaryKey());
		}
	}

	/**
	 * Creates a new data type structure with the primary key. Does not add the data type structure to the database.
	 *
	 * @param dataTypeId the primary key for the new data type structure
	 * @return the new data type structure
	 */
	@Override
	public DataTypeStructure create(long dataTypeId) {
		DataTypeStructure dataTypeStructure = new DataTypeStructureImpl();

		dataTypeStructure.setNew(true);
		dataTypeStructure.setPrimaryKey(dataTypeId);

		return dataTypeStructure;
	}

	/**
	 * Removes the data type structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the data type structure
	 * @return the data type structure that was removed
	 * @throws NoSuchDataTypeStructureException if a data type structure with the primary key could not be found
	 */
	@Override
	public DataTypeStructure remove(long dataTypeId)
		throws NoSuchDataTypeStructureException {

		return remove((Serializable)dataTypeId);
	}

	/**
	 * Removes the data type structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data type structure
	 * @return the data type structure that was removed
	 * @throws NoSuchDataTypeStructureException if a data type structure with the primary key could not be found
	 */
	@Override
	public DataTypeStructure remove(Serializable primaryKey)
		throws NoSuchDataTypeStructureException {

		Session session = null;

		try {
			session = openSession();

			DataTypeStructure dataTypeStructure =
				(DataTypeStructure)session.get(
					DataTypeStructureImpl.class, primaryKey);

			if (dataTypeStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataTypeStructureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataTypeStructure);
		}
		catch (NoSuchDataTypeStructureException nsee) {
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
	protected DataTypeStructure removeImpl(
		DataTypeStructure dataTypeStructure) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataTypeStructure)) {
				dataTypeStructure = (DataTypeStructure)session.get(
					DataTypeStructureImpl.class,
					dataTypeStructure.getPrimaryKeyObj());
			}

			if (dataTypeStructure != null) {
				session.delete(dataTypeStructure);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataTypeStructure != null) {
			clearCache(dataTypeStructure);
		}

		return dataTypeStructure;
	}

	@Override
	public DataTypeStructure updateImpl(DataTypeStructure dataTypeStructure) {
		boolean isNew = dataTypeStructure.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dataTypeStructure.isNew()) {
				session.save(dataTypeStructure);

				dataTypeStructure.setNew(false);
			}
			else {
				dataTypeStructure = (DataTypeStructure)session.merge(
					dataTypeStructure);
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
			entityCacheEnabled, DataTypeStructureImpl.class,
			dataTypeStructure.getPrimaryKey(), dataTypeStructure, false);

		dataTypeStructure.resetOriginalValues();

		return dataTypeStructure;
	}

	/**
	 * Returns the data type structure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data type structure
	 * @return the data type structure
	 * @throws NoSuchDataTypeStructureException if a data type structure with the primary key could not be found
	 */
	@Override
	public DataTypeStructure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataTypeStructureException {

		DataTypeStructure dataTypeStructure = fetchByPrimaryKey(primaryKey);

		if (dataTypeStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataTypeStructureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataTypeStructure;
	}

	/**
	 * Returns the data type structure with the primary key or throws a <code>NoSuchDataTypeStructureException</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the data type structure
	 * @return the data type structure
	 * @throws NoSuchDataTypeStructureException if a data type structure with the primary key could not be found
	 */
	@Override
	public DataTypeStructure findByPrimaryKey(long dataTypeId)
		throws NoSuchDataTypeStructureException {

		return findByPrimaryKey((Serializable)dataTypeId);
	}

	/**
	 * Returns the data type structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the data type structure
	 * @return the data type structure, or <code>null</code> if a data type structure with the primary key could not be found
	 */
	@Override
	public DataTypeStructure fetchByPrimaryKey(long dataTypeId) {
		return fetchByPrimaryKey((Serializable)dataTypeId);
	}

	/**
	 * Returns all the data type structures.
	 *
	 * @return the data type structures
	 */
	@Override
	public List<DataTypeStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data type structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type structures
	 * @param end the upper bound of the range of data type structures (not inclusive)
	 * @return the range of data type structures
	 */
	@Override
	public List<DataTypeStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data type structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of data type structures
	 * @param end the upper bound of the range of data type structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data type structures
	 */
	@Deprecated
	@Override
	public List<DataTypeStructure> findAll(
		int start, int end,
		OrderByComparator<DataTypeStructure> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data type structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataTypeStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type structures
	 * @param end the upper bound of the range of data type structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data type structures
	 */
	@Override
	public List<DataTypeStructure> findAll(
		int start, int end,
		OrderByComparator<DataTypeStructure> orderByComparator) {

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

		List<DataTypeStructure> list =
			(List<DataTypeStructure>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATATYPESTRUCTURE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATATYPESTRUCTURE;

				if (pagination) {
					sql = sql.concat(DataTypeStructureModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataTypeStructure>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataTypeStructure>)QueryUtil.list(
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
	 * Removes all the data type structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataTypeStructure dataTypeStructure : findAll()) {
			remove(dataTypeStructure);
		}
	}

	/**
	 * Returns the number of data type structures.
	 *
	 * @return the number of data type structures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATATYPESTRUCTURE);

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
		return "dataTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATATYPESTRUCTURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataTypeStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data type structure persistence.
	 */
	@Activate
	public void activate() {
		DataTypeStructureModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataTypeStructureModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataTypeStructureImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.osp.icecap.model.DataTypeStructure"),
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

	private static final String _SQL_SELECT_DATATYPESTRUCTURE =
		"SELECT dataTypeStructure FROM DataTypeStructure dataTypeStructure";

	private static final String _SQL_COUNT_DATATYPESTRUCTURE =
		"SELECT COUNT(dataTypeStructure) FROM DataTypeStructure dataTypeStructure";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataTypeStructure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataTypeStructure exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DataTypeStructurePersistenceImpl.class);

	static {
		try {
			Class.forName(ICECAPPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}