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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataPackService}.
 *
 * @author Jerry H. Seo
 * @see DataPackService
 * @generated
 */
public class DataPackServiceWrapper
	implements DataPackService, ServiceWrapper<DataPackService> {

	public DataPackServiceWrapper(DataPackService dataPackService) {
		_dataPackService = dataPackService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataPackService.getOSGiServiceIdentifier();
	}

	@Override
	public DataPackService getWrappedService() {
		return _dataPackService;
	}

	@Override
	public void setWrappedService(DataPackService dataPackService) {
		_dataPackService = dataPackService;
	}

	private DataPackService _dataPackService;

}