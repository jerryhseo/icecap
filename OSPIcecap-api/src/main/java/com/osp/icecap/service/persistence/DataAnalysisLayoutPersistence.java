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
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icecap.exception.NoSuchDataAnalysisLayoutException;
import com.osp.icecap.model.DataAnalysisLayout;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data analysis layout service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see DataAnalysisLayoutUtil
 * @generated
 */
@ProviderType
public interface DataAnalysisLayoutPersistence
	extends BasePersistence<DataAnalysisLayout> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataAnalysisLayoutUtil} to access the data analysis layout persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId);

	/**
	 * Returns a range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end);

	/**
	 * Returns an ordered range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataCollectionId(long, int, int, OrderByComparator)}
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Deprecated
	public java.util.List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data analysis layouts where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the first data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the first data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout fetchByDataCollectionId_First(
		long dataCollectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the last data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the last data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout fetchByDataCollectionId_Last(
		long dataCollectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public DataAnalysisLayout[] findByDataCollectionId_PrevAndNext(
			String dataUuid, long dataCollectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Removes all the data analysis layouts where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public void removeByDataCollectionId(long dataCollectionId);

	/**
	 * Returns the number of data analysis layouts where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching data analysis layouts
	 */
	public int countByDataCollectionId(long dataCollectionId);

	/**
	 * Returns all the data analysis layouts where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataSetId(long dataSetId);

	/**
	 * Returns a range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end);

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataSetId(long, int, int, OrderByComparator)}
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Deprecated
	public java.util.List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the first data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout findByDataSetId_First(
			long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the first data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout fetchByDataSetId_First(
		long dataSetId,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the last data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout findByDataSetId_Last(
			long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the last data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout fetchByDataSetId_Last(
		long dataSetId,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public DataAnalysisLayout[] findByDataSetId_PrevAndNext(
			String dataUuid, long dataSetId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Removes all the data analysis layouts where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of data analysis layouts where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data analysis layouts
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId);

	/**
	 * Returns a range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end);

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataSectionId(long, int, int, OrderByComparator)}
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Deprecated
	public java.util.List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data analysis layouts where dataSectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataSectionId the data section ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataSectionId(
		long dataSectionId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the first data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout findByDataSectionId_First(
			long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the first data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout fetchByDataSectionId_First(
		long dataSectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the last data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout findByDataSectionId_Last(
			long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the last data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout fetchByDataSectionId_Last(
		long dataSectionId,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataSectionId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataSectionId the data section ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public DataAnalysisLayout[] findByDataSectionId_PrevAndNext(
			String dataUuid, long dataSectionId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Removes all the data analysis layouts where dataSectionId = &#63; from the database.
	 *
	 * @param dataSectionId the data section ID
	 */
	public void removeByDataSectionId(long dataSectionId);

	/**
	 * Returns the number of data analysis layouts where dataSectionId = &#63;.
	 *
	 * @param dataSectionId the data section ID
	 * @return the number of matching data analysis layouts
	 */
	public int countByDataSectionId(long dataSectionId);

	/**
	 * Returns all the data analysis layouts where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataPackId(long dataPackId);

	/**
	 * Returns a range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end);

	/**
	 * Returns an ordered range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByDataPackId(long, int, int, OrderByComparator)}
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data analysis layouts
	 */
	@Deprecated
	public java.util.List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data analysis layouts where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the first data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout findByDataPackId_First(
			long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the first data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout fetchByDataPackId_First(
		long dataPackId,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the last data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout findByDataPackId_Last(
			long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the last data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data analysis layout, or <code>null</code> if a matching data analysis layout could not be found
	 */
	public DataAnalysisLayout fetchByDataPackId_Last(
		long dataPackId,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Returns the data analysis layouts before and after the current data analysis layout in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataUuid the primary key of the current data analysis layout
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public DataAnalysisLayout[] findByDataPackId_PrevAndNext(
			String dataUuid, long dataPackId,
			OrderByComparator<DataAnalysisLayout> orderByComparator)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Removes all the data analysis layouts where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	public void removeByDataPackId(long dataPackId);

	/**
	 * Returns the number of data analysis layouts where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching data analysis layouts
	 */
	public int countByDataPackId(long dataPackId);

	/**
	 * Caches the data analysis layout in the entity cache if it is enabled.
	 *
	 * @param dataAnalysisLayout the data analysis layout
	 */
	public void cacheResult(DataAnalysisLayout dataAnalysisLayout);

	/**
	 * Caches the data analysis layouts in the entity cache if it is enabled.
	 *
	 * @param dataAnalysisLayouts the data analysis layouts
	 */
	public void cacheResult(
		java.util.List<DataAnalysisLayout> dataAnalysisLayouts);

	/**
	 * Creates a new data analysis layout with the primary key. Does not add the data analysis layout to the database.
	 *
	 * @param dataUuid the primary key for the new data analysis layout
	 * @return the new data analysis layout
	 */
	public DataAnalysisLayout create(String dataUuid);

	/**
	 * Removes the data analysis layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout that was removed
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public DataAnalysisLayout remove(String dataUuid)
		throws NoSuchDataAnalysisLayoutException;

	public DataAnalysisLayout updateImpl(DataAnalysisLayout dataAnalysisLayout);

	/**
	 * Returns the data analysis layout with the primary key or throws a <code>NoSuchDataAnalysisLayoutException</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout
	 * @throws NoSuchDataAnalysisLayoutException if a data analysis layout with the primary key could not be found
	 */
	public DataAnalysisLayout findByPrimaryKey(String dataUuid)
		throws NoSuchDataAnalysisLayoutException;

	/**
	 * Returns the data analysis layout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataUuid the primary key of the data analysis layout
	 * @return the data analysis layout, or <code>null</code> if a data analysis layout with the primary key could not be found
	 */
	public DataAnalysisLayout fetchByPrimaryKey(String dataUuid);

	/**
	 * Returns all the data analysis layouts.
	 *
	 * @return the data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findAll();

	/**
	 * Returns a range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @return the range of data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data analysis layouts
	 */
	@Deprecated
	public java.util.List<DataAnalysisLayout> findAll(
		int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the data analysis layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataAnalysisLayoutModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data analysis layouts
	 * @param end the upper bound of the range of data analysis layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data analysis layouts
	 */
	public java.util.List<DataAnalysisLayout> findAll(
		int start, int end,
		OrderByComparator<DataAnalysisLayout> orderByComparator);

	/**
	 * Removes all the data analysis layouts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data analysis layouts.
	 *
	 * @return the number of data analysis layouts
	 */
	public int countAll();

}