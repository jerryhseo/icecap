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
 * Provides a wrapper for {@link DataSectionService}.
 *
 * @author Jerry H. Seo
 * @see DataSectionService
 * @generated
 */
public class DataSectionServiceWrapper
	implements DataSectionService, ServiceWrapper<DataSectionService> {

	public DataSectionServiceWrapper(DataSectionService dataSectionService) {
		_dataSectionService = dataSectionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataSectionService.getOSGiServiceIdentifier();
	}

	@Override
	public DataSectionService getWrappedService() {
		return _dataSectionService;
	}

	@Override
	public void setWrappedService(DataSectionService dataSectionService) {
		_dataSectionService = dataSectionService;
	}

	private DataSectionService _dataSectionService;

}