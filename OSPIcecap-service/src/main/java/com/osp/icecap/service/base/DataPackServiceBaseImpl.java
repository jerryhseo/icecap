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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.osp.icecap.model.DataPack;
import com.osp.icecap.service.DataPackService;
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

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the data pack remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.osp.icecap.service.impl.DataPackServiceImpl}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.osp.icecap.service.impl.DataPackServiceImpl
 * @generated
 */
public abstract class DataPackServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, DataPackService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DataPackService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.osp.icecap.service.DataPackServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DataPackService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dataPackService = (DataPackService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DataPackService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DataPack.class;
	}

	protected String getModelClassName() {
		return DataPack.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dataPackPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected DataAnalysisLayoutPersistence dataAnalysisLayoutPersistence;

	@Reference
	protected DataCollectionPersistence dataCollectionPersistence;

	@Reference
	protected DataEntryPersistence dataEntryPersistence;

	@Reference
	protected com.osp.icecap.service.DataPackLocalService dataPackLocalService;

	protected DataPackService dataPackService;

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
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

}