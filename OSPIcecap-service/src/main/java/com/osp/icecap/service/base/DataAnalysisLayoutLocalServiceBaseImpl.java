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

package com.osp.icecap.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.osp.icecap.model.DataAnalysisLayout;
import com.osp.icecap.service.DataAnalysisLayoutLocalService;
import com.osp.icecap.service.persistence.DataAnalysisLayoutPersistence;
import com.osp.icecap.service.persistence.DataCollectionPersistence;
import com.osp.icecap.service.persistence.DataEntryPersistence;
import com.osp.icecap.service.persistence.DataPackPersistence;
import com.osp.icecap.service.persistence.DataSectionPersistence;
import com.osp.icecap.service.persistence.DataSetPersistence;
import com.osp.icecap.service.persistence.DataTypePersistence;
import com.osp.icecap.service.persistence.DataTypeStructurePersistence;
import com.osp.icecap.service.persistence.DataTypeVisualizerLinkPersistence;
import com.osp.icecap.service.persistence.MetaDataPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the data analysis layout local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.osp.icecap.service.impl.DataAnalysisLayoutLocalServiceImpl}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.osp.icecap.service.impl.DataAnalysisLayoutLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class DataAnalysisLayoutLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements DataAnalysisLayoutLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DataAnalysisLayoutLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.osp.icecap.service.DataAnalysisLayoutLocalServiceUtil</code>.
	 */

	/**
	 * Adds the data analysis layout to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DataAnalysisLayout addDataAnalysisLayout(
		DataAnalysisLayout dataAnalysisLayout) {

		dataAnalysisLayout.setNew(true);

		return dataAnalysisLayoutPersistence.update(dataAnalysisLayout);
	}

	/**
	 * Creates a new data analysis layout with the primary key. Does not add the data analysis layout to the database.
	 *
	 * @param dataUuid the primary key for the new data analysis layout
	 * @return the new data analysis layout
	 */
	@Override
	@Transactional(enabled = false)
	public DataAnalysisLayout createDataAnalysisLayout(String dataUuid) {
		return dataAnalysisLayoutPersistence.create(dataUuid);
	}

	/**
	 * Deletes the data analysis layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout that was removed
	 * @throws PortalException if a data analysis layout with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DataAnalysisLayout deleteDataAnalysisLayout(String dataUuid)
		throws PortalException {

		return dataAnalysisLayoutPersistence.remove(dataUuid);
	}

	/**
	 * Deletes the data analysis layout from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DataAnalysisLayout deleteDataAnalysisLayout(
		DataAnalysisLayout dataAnalysisLayout) {

		return dataAnalysisLayoutPersistence.remove(dataAnalysisLayout);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DataAnalysisLayout.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dataAnalysisLayoutPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return dataAnalysisLayoutPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return dataAnalysisLayoutPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dataAnalysisLayoutPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return dataAnalysisLayoutPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DataAnalysisLayout fetchDataAnalysisLayout(String dataUuid) {
		return dataAnalysisLayoutPersistence.fetchByPrimaryKey(dataUuid);
	}

	/**
	 * Returns the data analysis layout with the primary key.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout
	 * @throws PortalException if a data analysis layout with the primary key could not be found
	 */
	@Override
	public DataAnalysisLayout getDataAnalysisLayout(String dataUuid)
		throws PortalException {

		return dataAnalysisLayoutPersistence.findByPrimaryKey(dataUuid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return dataAnalysisLayoutLocalService.deleteDataAnalysisLayout(
			(DataAnalysisLayout)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dataAnalysisLayoutPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of data analysis layouts
	 */
	@Override
	public List<DataAnalysisLayout> getDataAnalysisLayouts(int start, int end) {
		return dataAnalysisLayoutPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of data analysis layouts.
	 *
	 * @return the number of data analysis layouts
	 */
	@Override
	public int getDataAnalysisLayoutsCount() {
		return dataAnalysisLayoutPersistence.countAll();
	}

	/**
	 * Updates the data analysis layout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 * @return the data analysis layout that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DataAnalysisLayout updateDataAnalysisLayout(
		DataAnalysisLayout dataAnalysisLayout) {

		return dataAnalysisLayoutPersistence.update(dataAnalysisLayout);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DataAnalysisLayoutLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dataAnalysisLayoutLocalService =
			(DataAnalysisLayoutLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DataAnalysisLayoutLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DataAnalysisLayout.class;
	}

	protected String getModelClassName() {
		return DataAnalysisLayout.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				dataAnalysisLayoutPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected DataAnalysisLayoutLocalService dataAnalysisLayoutLocalService;

	@Reference
	protected DataAnalysisLayoutPersistence dataAnalysisLayoutPersistence;

	@Reference
	protected DataCollectionPersistence dataCollectionPersistence;

	@Reference
	protected DataEntryPersistence dataEntryPersistence;

	@Reference
	protected DataPackPersistence dataPackPersistence;

	@Reference
	protected DataSectionPersistence dataSectionPersistence;

	@Reference
	protected DataSetPersistence dataSetPersistence;

	@Reference
	protected DataTypePersistence dataTypePersistence;

	@Reference
	protected DataTypeStructurePersistence dataTypeStructurePersistence;

	@Reference
	protected DataTypeVisualizerLinkPersistence
		dataTypeVisualizerLinkPersistence;

	@Reference
	protected MetaDataPersistence metaDataPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}