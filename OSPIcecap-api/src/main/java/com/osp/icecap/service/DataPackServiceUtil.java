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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for DataPack. This utility wraps
 * <code>com.osp.icecap.service.impl.DataPackServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry H. Seo
 * @see DataPackService
 * @generated
 */
public class DataPackServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icecap.service.impl.DataPackServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DataPackService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DataPackService, DataPackService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataPackService.class);

		ServiceTracker<DataPackService, DataPackService> serviceTracker =
			new ServiceTracker<DataPackService, DataPackService>(
				bundle.getBundleContext(), DataPackService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}