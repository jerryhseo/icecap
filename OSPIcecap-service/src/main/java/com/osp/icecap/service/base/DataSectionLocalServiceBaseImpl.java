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

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import com.osp.icecap.model.DataSection;
import com.osp.icecap.service.DataSectionLocalService;
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
 * Provides the base implementation for the data section local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.osp.icecap.service.impl.DataSectionLocalServiceImpl}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.osp.icecap.service.impl.DataSectionLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class DataSectionLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements DataSectionLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DataSectionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.osp.icecap.service.DataSectionLocalServiceUtil</code>.
	 */

	/**
	 * Adds the data section to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSection the data section
	 * @return the data section that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DataSection addDataSection(DataSection dataSection) {
		dataSection.setNew(true);

		return dataSectionPersistence.update(dataSection);
	}

	/**
	 * Creates a new data section with the primary key. Does not add the data section to the database.
	 *
	 * @param dataSectionId the primary key for the new data section
	 * @return the new data section
	 */
	@Override
	@Transactional(enabled = false)
	public DataSection createDataSection(long dataSectionId) {
		return dataSectionPersistence.create(dataSectionId);
	}

	/**
	 * Deletes the data section with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSectionId the primary key of the data section
	 * @return the data section that was removed
	 * @throws PortalException if a data section with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DataSection deleteDataSection(long dataSectionId)
		throws PortalException {

		return dataSectionPersistence.remove(dataSectionId);
	}

	/**
	 * Deletes the data section from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSection the data section
	 * @return the data section that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DataSection deleteDataSection(DataSection dataSection) {
		return dataSectionPersistence.remove(dataSection);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DataSection.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dataSectionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return dataSectionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return dataSectionPersistence.findWithDynamicQuery(
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
		return dataSectionPersistence.countWithDynamicQuery(dynamicQuery);
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

		return dataSectionPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DataSection fetchDataSection(long dataSectionId) {
		return dataSectionPersistence.fetchByPrimaryKey(dataSectionId);
	}

	/**
	 * Returns the data section matching the UUID and group.
	 *
	 * @param uuid the data section's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data section, or <code>null</code> if a matching data section could not be found
	 */
	@Override
	public DataSection fetchDataSectionByUuidAndGroupId(
		String uuid, long groupId) {

		return dataSectionPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data section with the primary key.
	 *
	 * @param dataSectionId the primary key of the data section
	 * @return the data section
	 * @throws PortalException if a data section with the primary key could not be found
	 */
	@Override
	public DataSection getDataSection(long dataSectionId)
		throws PortalException {

		return dataSectionPersistence.findByPrimaryKey(dataSectionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dataSectionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DataSection.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dataSectionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dataSectionLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DataSection.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"dataSectionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(dataSectionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DataSection.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dataSectionId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									DataSection.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DataSection>() {

				@Override
				public void performAction(DataSection dataSection)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, dataSection);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(DataSection.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return dataSectionLocalService.deleteDataSection(
			(DataSection)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dataSectionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the data sections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sections
	 * @param companyId the primary key of the company
	 * @return the matching data sections, or an empty list if no matches were found
	 */
	@Override
	public List<DataSection> getDataSectionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return dataSectionPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of data sections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sections
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data sections, or an empty list if no matches were found
	 */
	@Override
	public List<DataSection> getDataSectionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataSection> orderByComparator) {

		return dataSectionPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the data section matching the UUID and group.
	 *
	 * @param uuid the data section's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data section
	 * @throws PortalException if a matching data section could not be found
	 */
	@Override
	public DataSection getDataSectionByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return dataSectionPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the data sections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sections
	 * @param end the upper bound of the range of data sections (not inclusive)
	 * @return the range of data sections
	 */
	@Override
	public List<DataSection> getDataSections(int start, int end) {
		return dataSectionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of data sections.
	 *
	 * @return the number of data sections
	 */
	@Override
	public int getDataSectionsCount() {
		return dataSectionPersistence.countAll();
	}

	/**
	 * Updates the data section in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataSection the data section
	 * @return the data section that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DataSection updateDataSection(DataSection dataSection) {
		return dataSectionPersistence.update(dataSection);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DataSectionLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dataSectionLocalService = (DataSectionLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DataSectionLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DataSection.class;
	}

	protected String getModelClassName() {
		return DataSection.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dataSectionPersistence.getDataSource();

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

	@Reference
	protected DataAnalysisLayoutPersistence dataAnalysisLayoutPersistence;

	@Reference
	protected DataCollectionPersistence dataCollectionPersistence;

	@Reference
	protected DataEntryPersistence dataEntryPersistence;

	@Reference
	protected DataPackPersistence dataPackPersistence;

	protected DataSectionLocalService dataSectionLocalService;

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

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

}