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

import com.osp.icecap.model.DataEntry;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DataEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Jerry H. Seo
 * @see DataEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DataEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataEntryLocalServiceUtil} to access the data entry local service. Add custom service methods to <code>com.osp.icecap.service.impl.DataEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the data entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntry the data entry
	 * @return the data entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataEntry addDataEntry(DataEntry dataEntry);

	@Indexable(type = IndexableType.REINDEX)
	public DataEntry addDataEntry(
			long dataCollectionId, long dataSetId, long dataSectionId,
			long dataPackId, long dataTypeId, String accessURL,
			String sequenceId, String accessType, long copiedFrom,
			JSONObject metaDataJSON, ServiceContext sc)
		throws PortalException;

	/**
	 * Creates a new data entry with the primary key. Does not add the data entry to the database.
	 *
	 * @param dataEntryId the primary key for the new data entry
	 * @return the new data entry
	 */
	@Transactional(enabled = false)
	public DataEntry createDataEntry(long dataEntryId);

	/**
	 * Deletes the data entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntry the data entry
	 * @return the data entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataEntry deleteDataEntry(DataEntry dataEntry);

	/**
	 * Deletes the data entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry that was removed
	 * @throws PortalException if a data entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataEntry deleteDataEntry(long dataEntryId) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataEntryModelImpl</code>.
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
	public DataEntry fetchDataEntry(long dataEntryId);

	/**
	 * Returns the data entry matching the UUID and group.
	 *
	 * @param uuid the data entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data entry, or <code>null</code> if a matching data entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataEntry fetchDataEntryByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns a range of all the data entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icecap.model.impl.DataEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @return the range of data entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataEntry> getDataEntries(int start, int end);

	/**
	 * Returns all the data entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data entries
	 * @param companyId the primary key of the company
	 * @return the matching data entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataEntry> getDataEntriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of data entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data entries
	 * @param end the upper bound of the range of data entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataEntry> getDataEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataEntry> orderByComparator);

	/**
	 * Returns the number of data entries.
	 *
	 * @return the number of data entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataEntriesCount();

	/**
	 * Returns the data entry with the primary key.
	 *
	 * @param dataEntryId the primary key of the data entry
	 * @return the data entry
	 * @throws PortalException if a data entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataEntry getDataEntry(long dataEntryId) throws PortalException;

	/**
	 * Returns the data entry matching the UUID and group.
	 *
	 * @param uuid the data entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data entry
	 * @throws PortalException if a matching data entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataEntry getDataEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void removeDataEntriesByDataCollectionId(long dataCollectionId)
		throws PortalException;

	public void removeDataEntriesByDataPackId(long dataPackId)
		throws PortalException;

	public void removeDataEntriesByDataSectionId(long dataSectionId)
		throws PortalException;

	public void removeDataEntriesByDataSetId(long dataSetId)
		throws PortalException;

	public DataEntry removeDataEntry(long dataEntryId) throws PortalException;

	/**
	 * Updates the data entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataEntry the data entry
	 * @return the data entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataEntry updateDataEntry(DataEntry dataEntry);

	@Indexable(type = IndexableType.REINDEX)
	public DataEntry updateDataEntry(
			long dataEntryId, long dataCollectionId, long dataSetId,
			long dataSectionId, long dataPackId, long dataTypeId,
			String accessURL, String sequenceId, String accessType,
			long copiedFrom, JSONObject metaDataJSON, ServiceContext sc)
		throws PortalException;

}