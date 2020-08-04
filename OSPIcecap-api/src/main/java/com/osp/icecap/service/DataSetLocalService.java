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

import com.osp.icecap.model.DataSection;
import com.osp.icecap.model.DataSet;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DataSet. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Jerry H. Seo
 * @see DataSetLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DataSetLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataSetLocalServiceUtil} to access the data set local service. Add custom service methods to <code>com.osp.icecap.service.impl.DataSetLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the data set to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSet the data set
	 * @return the data set that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataSet addDataSet(DataSet dataSet);

	public DataSet addDataSet(
			long dataCollectionId, String name, String version, long copiedFrom,
			JSONObject metaDataJSON, String layout, ServiceContext sc)
		throws PortalException;

	/**
	 * Creates a new data set with the primary key. Does not add the data set to the database.
	 *
	 * @param dataSetId the primary key for the new data set
	 * @return the new data set
	 */
	@Transactional(enabled = false)
	public DataSet createDataSet(long dataSetId);

	/**
	 * Deletes the data set from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSet the data set
	 * @return the data set that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataSet deleteDataSet(DataSet dataSet);

	/**
	 * Deletes the data set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set that was removed
	 * @throws PortalException if a data set with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataSet deleteDataSet(long dataSetId) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public DataSet fetchDataSet(long dataSetId);

	/**
	 * Returns the data set matching the UUID and group.
	 *
	 * @param uuid the data set's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataSet fetchDataSetByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSection> getDataSectionsByDataSetId(long dataSetId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSection> getDataSectionsByDataSetId(
		long dataSetId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataSectionsCountByDataSetId(long dataSetId);

	/**
	 * Returns the data set with the primary key.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set
	 * @throws PortalException if a data set with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataSet getDataSet(long dataSetId) throws PortalException;

	/**
	 * Returns the data set matching the UUID and group.
	 *
	 * @param uuid the data set's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data set
	 * @throws PortalException if a matching data set could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataSet getDataSetByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataSetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of data sets
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSets(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSetsByDataCollectionId(long dataCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSetsByDataCollectionId(
		long dataCollectionId, int start, int end);

	/**
	 * Returns all the data sets matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sets
	 * @param companyId the primary key of the company
	 * @return the matching data sets, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSetsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of data sets matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sets
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data sets, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSetsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataSet> orderByComparator);

	/**
	 * Returns the number of data sets.
	 *
	 * @return the number of data sets
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataSetsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataSetsCountByDataCollectionId(long dataCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSetsVariants(
		long dataSetId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataSet> getDataSetVariants(long dataSetId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataSetVariantsCount(long dataSetId);

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

	public DataSet removeDataSet(long dataSetId) throws PortalException;

	public void removeDataSetsByDataCollectionId(long dataCollectionId)
		throws PortalException;

	/**
	 * Updates the data set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataSet the data set
	 * @return the data set that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataSet updateDataSet(DataSet dataSet);

	public DataSet updateDataSet(
			long dataSetId, long dataCollectionId, String name, String version,
			long copiedFrom, JSONObject metaDataJSON, String layout,
			ServiceContext sc)
		throws PortalException;

}