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

package com.osp.icecap.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.osp.icecap.exception.NoSuchMetaDataException;
import com.osp.icecap.model.MetaData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the meta data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see MetaDataUtil
 * @generated
 */
@ProviderType
public interface MetaDataPersistence extends BasePersistence<MetaData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MetaDataUtil} to access the meta data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the meta datas where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching meta datas
	 */
	public java.util.List<MetaData> findByDataCollectionId(
		long dataCollectionId);

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
	public java.util.List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end);

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
	public java.util.List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public java.util.List<MetaData> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByDataCollectionId_First(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the first meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByDataCollectionId_First(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the last meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByDataCollectionId_Last(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the last meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByDataCollectionId_Last(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public MetaData[] findByDataCollectionId_PrevAndNext(
			String dataUuid, long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Removes all the meta datas where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public void removeByDataCollectionId(long dataCollectionId);

	/**
	 * Returns the number of meta datas where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching meta datas
	 */
	public int countByDataCollectionId(long dataCollectionId);

	/**
	 * Returns all the meta datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching meta datas
	 */
	public java.util.List<MetaData> findByDataSetId(long dataSetId);

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
	public java.util.List<MetaData> findByDataSetId(
		long dataSetId, int start, int end);

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
	public java.util.List<MetaData> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public java.util.List<MetaData> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByDataSetId_First(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the first meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByDataSetId_First(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the last meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByDataSetId_Last(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the last meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByDataSetId_Last(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public MetaData[] findByDataSetId_PrevAndNext(
			String dataUuid, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Removes all the meta datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of meta datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching meta datas
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the meta datas where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching meta datas
	 */
	public java.util.List<MetaData> findByDataSectionId(long dataSectionId);

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
	public java.util.List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end);

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
	public java.util.List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public java.util.List<MetaData> findByDataSectionId(
		long dataSectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByDataSectionId_First(
			long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the first meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByDataSectionId_First(
		long dataSectionId,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the last meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByDataSectionId_Last(
			long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the last meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByDataSectionId_Last(
		long dataSectionId,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public MetaData[] findByDataSectionId_PrevAndNext(
			String dataUuid, long dataSectionId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Removes all the meta datas where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	public void removeByDataSectionId(long dataSectionId);

	/**
	 * Returns the number of meta datas where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching meta datas
	 */
	public int countByDataSectionId(long dataSectionId);

	/**
	 * Returns all the meta datas where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching meta datas
	 */
	public java.util.List<MetaData> findByDataPackId(long dataPackId);

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
	public java.util.List<MetaData> findByDataPackId(
		long dataPackId, int start, int end);

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
	public java.util.List<MetaData> findByDataPackId(
		long dataPackId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public java.util.List<MetaData> findByDataPackId(
		long dataPackId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByDataPackId_First(
			long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the first meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByDataPackId_First(
		long dataPackId,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the last meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByDataPackId_Last(
			long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the last meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByDataPackId_Last(
		long dataPackId,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public MetaData[] findByDataPackId_PrevAndNext(
			String dataUuid, long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Removes all the meta datas where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	public void removeByDataPackId(long dataPackId);

	/**
	 * Returns the number of meta datas where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching meta datas
	 */
	public int countByDataPackId(long dataPackId);

	/**
	 * Returns all the meta datas where creator = &#63;.
	 *
	 * @param creator the creator
	 * @return the matching meta datas
	 */
	public java.util.List<MetaData> findByCreator(String creator);

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
	public java.util.List<MetaData> findByCreator(
		String creator, int start, int end);

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
	public java.util.List<MetaData> findByCreator(
		String creator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching meta datas
	 */
	public java.util.List<MetaData> findByCreator(
		String creator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByCreator_First(
			String creator,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the first meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByCreator_First(
		String creator,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the last meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data
	 * @throws NoSuchMetaDataException if a matching meta data could not be found
	 */
	public MetaData findByCreator_Last(
			String creator,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Returns the last meta data in the ordered set where creator = &#63;.
	 *
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching meta data, or <code>null</code> if a matching meta data could not be found
	 */
	public MetaData fetchByCreator_Last(
		String creator,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

	/**
	 * Returns the meta datas before and after the current meta data in the ordered set where creator = &#63;.
	 *
	 * @param dataUuid the primary key of the current meta data
	 * @param creator the creator
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public MetaData[] findByCreator_PrevAndNext(
			String dataUuid, String creator,
			com.liferay.portal.kernel.util.OrderByComparator<MetaData>
				orderByComparator)
		throws NoSuchMetaDataException;

	/**
	 * Removes all the meta datas where creator = &#63; from the database.
	 *
	 * @param creator the creator
	 */
	public void removeByCreator(String creator);

	/**
	 * Returns the number of meta datas where creator = &#63;.
	 *
	 * @param creator the creator
	 * @return the number of matching meta datas
	 */
	public int countByCreator(String creator);

	/**
	 * Caches the meta data in the entity cache if it is enabled.
	 *
	 * @param metaData the meta data
	 */
	public void cacheResult(MetaData metaData);

	/**
	 * Caches the meta datas in the entity cache if it is enabled.
	 *
	 * @param metaDatas the meta datas
	 */
	public void cacheResult(java.util.List<MetaData> metaDatas);

	/**
	 * Creates a new meta data with the primary key. Does not add the meta data to the database.
	 *
	 * @param dataUuid the primary key for the new meta data
	 * @return the new meta data
	 */
	public MetaData create(String dataUuid);

	/**
	 * Removes the meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data that was removed
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public MetaData remove(String dataUuid) throws NoSuchMetaDataException;

	public MetaData updateImpl(MetaData metaData);

	/**
	 * Returns the meta data with the primary key or throws a <code>NoSuchMetaDataException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data
	 * @throws NoSuchMetaDataException if a meta data with the primary key could not be found
	 */
	public MetaData findByPrimaryKey(String dataUuid)
		throws NoSuchMetaDataException;

	/**
	 * Returns the meta data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the meta data
	 * @return the meta data, or <code>null</code> if a meta data with the primary key could not be found
	 */
	public MetaData fetchByPrimaryKey(String dataUuid);

	/**
	 * Returns all the meta datas.
	 *
	 * @return the meta datas
	 */
	public java.util.List<MetaData> findAll();

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
	public java.util.List<MetaData> findAll(int start, int end);

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
	public java.util.List<MetaData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator);

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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of meta datas
	 */
	public java.util.List<MetaData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MetaData>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the meta datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of meta datas.
	 *
	 * @return the number of meta datas
	 */
	public int countAll();

}