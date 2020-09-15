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

package com.osp.icecap.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class MetaDataSoap implements Serializable {

	public static MetaDataSoap toSoapModel(MetaData model) {
		MetaDataSoap soapModel = new MetaDataSoap();

		soapModel.setDataUuid(model.getDataUuid());
		soapModel.setCreator(model.getCreator());
		soapModel.setCreated(model.getCreated());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setSummary(model.getSummary());
		soapModel.setDoi(model.getDoi());
		soapModel.setDateAccepted(model.getDateAccepted());
		soapModel.setDateCopyrighted(model.getDateCopyrighted());
		soapModel.setDateSubmitted(model.getDateSubmitted());
		soapModel.setFormat(model.getFormat());
		soapModel.setVersion(model.getVersion());
		soapModel.setIssued(model.getIssued());
		soapModel.setLicense(model.getLicense());
		soapModel.setDatePattern(model.getDatePattern());
		soapModel.setDataCollectionId(model.getDataCollectionId());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataSectionId(model.getDataSectionId());
		soapModel.setDataPackId(model.getDataPackId());
		soapModel.setDataEntryId(model.getDataEntryId());

		return soapModel;
	}

	public static MetaDataSoap[] toSoapModels(MetaData[] models) {
		MetaDataSoap[] soapModels = new MetaDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetaDataSoap[][] toSoapModels(MetaData[][] models) {
		MetaDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetaDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetaDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetaDataSoap[] toSoapModels(List<MetaData> models) {
		List<MetaDataSoap> soapModels = new ArrayList<MetaDataSoap>(
			models.size());

		for (MetaData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetaDataSoap[soapModels.size()]);
	}

	public MetaDataSoap() {
	}

	public String getPrimaryKey() {
		return _dataUuid;
	}

	public void setPrimaryKey(String pk) {
		setDataUuid(pk);
	}

	public String getDataUuid() {
		return _dataUuid;
	}

	public void setDataUuid(String dataUuid) {
		_dataUuid = dataUuid;
	}

	public String getCreator() {
		return _creator;
	}

	public void setCreator(String creator) {
		_creator = creator;
	}

	public String getCreated() {
		return _created;
	}

	public void setCreated(String created) {
		_created = created;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public String getDoi() {
		return _doi;
	}

	public void setDoi(String doi) {
		_doi = doi;
	}

	public String getDateAccepted() {
		return _dateAccepted;
	}

	public void setDateAccepted(String dateAccepted) {
		_dateAccepted = dateAccepted;
	}

	public String getDateCopyrighted() {
		return _dateCopyrighted;
	}

	public void setDateCopyrighted(String dateCopyrighted) {
		_dateCopyrighted = dateCopyrighted;
	}

	public String getDateSubmitted() {
		return _dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		_dateSubmitted = dateSubmitted;
	}

	public String getFormat() {
		return _format;
	}

	public void setFormat(String format) {
		_format = format;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public String getIssued() {
		return _issued;
	}

	public void setIssued(String issued) {
		_issued = issued;
	}

	public String getLicense() {
		return _license;
	}

	public void setLicense(String license) {
		_license = license;
	}

	public String getDatePattern() {
		return _datePattern;
	}

	public void setDatePattern(String datePattern) {
		_datePattern = datePattern;
	}

	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	public void setDataCollectionId(long dataCollectionId) {
		_dataCollectionId = dataCollectionId;
	}

	public long getDataSetId() {
		return _dataSetId;
	}

	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	public long getDataSectionId() {
		return _dataSectionId;
	}

	public void setDataSectionId(long dataSectionId) {
		_dataSectionId = dataSectionId;
	}

	public long getDataPackId() {
		return _dataPackId;
	}

	public void setDataPackId(long dataPackId) {
		_dataPackId = dataPackId;
	}

	public long getDataEntryId() {
		return _dataEntryId;
	}

	public void setDataEntryId(long dataEntryId) {
		_dataEntryId = dataEntryId;
	}

	private String _dataUuid;
	private String _creator;
	private String _created;
	private String _title;
	private String _description;
	private String _summary;
	private String _doi;
	private String _dateAccepted;
	private String _dateCopyrighted;
	private String _dateSubmitted;
	private String _format;
	private String _version;
	private String _issued;
	private String _license;
	private String _datePattern;
	private long _dataCollectionId;
	private long _dataSetId;
	private long _dataSectionId;
	private long _dataPackId;
	private long _dataEntryId;

}