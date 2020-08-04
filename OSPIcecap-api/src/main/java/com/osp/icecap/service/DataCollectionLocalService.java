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

package com.osp.icecap.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icecap.exception.NoSuchDataAnalysisLayoutException;
import com.osp.icecap.exception.NoSuchDataCollectionException;
import com.osp.icecap.exception.NoSuchMetaDataException;
import com.osp.icecap.model.DataCollection;
import com.osp.icecap.model.DataSet;
import com.osp.icecap.model.MetaData;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DataCollection. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Jerry H. Seo
 * @see DataCollectionLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DataCollectionLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataCollectionLocalServiceUtil} to access the data collection local service. Add custom service methods to <code>com.osp.icecap.service.impl.DataCollectionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the data collection to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataCollection addDataCollection(DataCollection dataCollection);

	public DataCollection addDataCollection(
			String name, String version, long organizationId,
			JSONObject metaDataJSON, String layout, ServiceContext sc)
		throws PortalException;

	/**
	 * Creates a new data collection with the primary key. Does not add the data collection to the database.
	 *
	 * @param dataCollectionId the primary key for the new data collection
	 * @return the new data collection
	 */
	@Transactional(enabled = false)
	public DataCollection createDataCollection(long dataCollectionId);

	/**
	 * Deletes the data collection from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataCollection deleteDataCollection(DataCollection dataCollection);

	/**
	 * Deletes the data collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection that was removed
	 * @throws PortalException if a data collection with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataCollection deleteDataCollection(long dataCollectionId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataCollection fetchDataCollection(long dataCollectionId);

	/**
	 * Returns the data collection matching the UUID and group.
	 *
	 * @param uuid the data collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataCollection fetchDataCollectionByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the data collection with the primary key.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection
	 * @throws PortalException if a data collection with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataCollection getDataCollection(long dataCollectionId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataCollection getDataCollectionByNameVersion(
			String dataCollectionName, String dataCollectionVersion)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the data collection matching the UUID and group.
	 *
	 * @param uuid the data collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data collection
	 * @throws PortalException if a matching data collection could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataCollection getDataCollectionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataCollectionCountAll();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataCollectionCountByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataCollectionCountByName(String dataCollectionName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataCollectionCountByUserId(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getDataCollectionLayout(long dataCollectionId)
		throws NoSuchDataAnalysisLayoutException, NoSuchDataCollectionException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MetaData getDataCollectionMetaData(long dataCollectionId)
		throws NoSuchDataCollectionException, NoSuchMetaDataException;

	/**
	 * Returns a range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataCollectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of data collections
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollections(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsAll();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsAll(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsByGroupId(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsByName(
		String dataCollectionName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsByName(
		String dataCollectionName, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsByUserId(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsByUserId(
		long userId, int start, int end);

	/**
	 * Returns all the data collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data collections
	 * @param companyId the primary key of the company
	 * @return the matching data collections, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of data collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data collections
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data collections, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator);

	/**
	 * Returns the number of data collections.
	 *
	 * @return the number of data collections
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataCollectionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataCollectionVariantCount(long dataCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionVariants(
		long dataCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataCollection> getDataCollectionVariants(
		long dataCollectionId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSetsByDataCollectionId(long dataCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSetsByDataCollectionId(
		long dataCollectionId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataSetsCountByDataCollectionId(long dataCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Removes all DataCollection related stuff.
	 * DataAnalysysLayout
	 * DataSet
	 * DataPack
	 * DataEntry
	 */
	public DataCollection removeDataCollection(long dataCollectionId)
		throws PortalException;

	/**
	 * Updates the data collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataCollection updateDataCollection(DataCollection dataCollection);

	public DataCollection updateDataCollection(
			long dataCollectionId, String name, String version,
			long organizationId, JSONObject metaDataJSON, String layout,
			ServiceContext sc)
		throws PortalException;

}