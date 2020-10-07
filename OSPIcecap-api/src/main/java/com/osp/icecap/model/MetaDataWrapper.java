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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MetaData}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see MetaData
 * @generated
 */
public class MetaDataWrapper
	extends BaseModelWrapper<MetaData>
	implements MetaData, ModelWrapper<MetaData> {

	public MetaDataWrapper(MetaData metaData) {
		super(metaData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataUuid", getDataUuid());
		attributes.put("creator", getCreator());
		attributes.put("created", getCreated());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("summary", getSummary());
		attributes.put("doi", getDoi());
		attributes.put("dateAccepted", getDateAccepted());
		attributes.put("dateCopyrighted", getDateCopyrighted());
		attributes.put("dateSubmitted", getDateSubmitted());
		attributes.put("format", getFormat());
		attributes.put("version", getVersion());
		attributes.put("issued", getIssued());
		attributes.put("license", getLicense());
		attributes.put("datePattern", getDatePattern());
		attributes.put("dataCollectionId", getDataCollectionId());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataSectionId", getDataSectionId());
		attributes.put("dataPackId", getDataPackId());
		attributes.put("dataEntryId", getDataEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String dataUuid = (String)attributes.get("dataUuid");

		if (dataUuid != null) {
			setDataUuid(dataUuid);
		}

		String creator = (String)attributes.get("creator");

		if (creator != null) {
			setCreator(creator);
		}

		String created = (String)attributes.get("created");

		if (created != null) {
			setCreated(created);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String doi = (String)attributes.get("doi");

		if (doi != null) {
			setDoi(doi);
		}

		String dateAccepted = (String)attributes.get("dateAccepted");

		if (dateAccepted != null) {
			setDateAccepted(dateAccepted);
		}

		String dateCopyrighted = (String)attributes.get("dateCopyrighted");

		if (dateCopyrighted != null) {
			setDateCopyrighted(dateCopyrighted);
		}

		String dateSubmitted = (String)attributes.get("dateSubmitted");

		if (dateSubmitted != null) {
			setDateSubmitted(dateSubmitted);
		}

		String format = (String)attributes.get("format");

		if (format != null) {
			setFormat(format);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String issued = (String)attributes.get("issued");

		if (issued != null) {
			setIssued(issued);
		}

		String license = (String)attributes.get("license");

		if (license != null) {
			setLicense(license);
		}

		String datePattern = (String)attributes.get("datePattern");

		if (datePattern != null) {
			setDatePattern(datePattern);
		}

		Long dataCollectionId = (Long)attributes.get("dataCollectionId");

		if (dataCollectionId != null) {
			setDataCollectionId(dataCollectionId);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataSectionId = (Long)attributes.get("dataSectionId");

		if (dataSectionId != null) {
			setDataSectionId(dataSectionId);
		}

		Long dataPackId = (Long)attributes.get("dataPackId");

		if (dataPackId != null) {
			setDataPackId(dataPackId);
		}

		Long dataEntryId = (Long)attributes.get("dataEntryId");

		if (dataEntryId != null) {
			setDataEntryId(dataEntryId);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the created of this meta data.
	 *
	 * @return the created of this meta data
	 */
	@Override
	public String getCreated() {
		return model.getCreated();
	}

	/**
	 * Returns the creator of this meta data.
	 *
	 * @return the creator of this meta data
	 */
	@Override
	public String getCreator() {
		return model.getCreator();
	}

	/**
	 * Returns the data collection ID of this meta data.
	 *
	 * @return the data collection ID of this meta data
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the data entry ID of this meta data.
	 *
	 * @return the data entry ID of this meta data
	 */
	@Override
	public long getDataEntryId() {
		return model.getDataEntryId();
	}

	/**
	 * Returns the data pack ID of this meta data.
	 *
	 * @return the data pack ID of this meta data
	 */
	@Override
	public long getDataPackId() {
		return model.getDataPackId();
	}

	/**
	 * Returns the data section ID of this meta data.
	 *
	 * @return the data section ID of this meta data
	 */
	@Override
	public long getDataSectionId() {
		return model.getDataSectionId();
	}

	/**
	 * Returns the data set ID of this meta data.
	 *
	 * @return the data set ID of this meta data
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the data uuid of this meta data.
	 *
	 * @return the data uuid of this meta data
	 */
	@Override
	public String getDataUuid() {
		return model.getDataUuid();
	}

	/**
	 * Returns the date accepted of this meta data.
	 *
	 * @return the date accepted of this meta data
	 */
	@Override
	public String getDateAccepted() {
		return model.getDateAccepted();
	}

	/**
	 * Returns the date copyrighted of this meta data.
	 *
	 * @return the date copyrighted of this meta data
	 */
	@Override
	public String getDateCopyrighted() {
		return model.getDateCopyrighted();
	}

	/**
	 * Returns the date pattern of this meta data.
	 *
	 * @return the date pattern of this meta data
	 */
	@Override
	public String getDatePattern() {
		return model.getDatePattern();
	}

	/**
	 * Returns the date submitted of this meta data.
	 *
	 * @return the date submitted of this meta data
	 */
	@Override
	public String getDateSubmitted() {
		return model.getDateSubmitted();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this meta data.
	 *
	 * @return the description of this meta data
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this meta data
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this meta data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this meta data
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this meta data
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this meta data.
	 *
	 * @return the locales and localized descriptions of this meta data
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the doi of this meta data.
	 *
	 * @return the doi of this meta data
	 */
	@Override
	public String getDoi() {
		return model.getDoi();
	}

	/**
	 * Returns the format of this meta data.
	 *
	 * @return the format of this meta data
	 */
	@Override
	public String getFormat() {
		return model.getFormat();
	}

	/**
	 * Returns the issued of this meta data.
	 *
	 * @return the issued of this meta data
	 */
	@Override
	public String getIssued() {
		return model.getIssued();
	}

	/**
	 * Returns the license of this meta data.
	 *
	 * @return the license of this meta data
	 */
	@Override
	public String getLicense() {
		return model.getLicense();
	}

	/**
	 * Returns the primary key of this meta data.
	 *
	 * @return the primary key of this meta data
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the summary of this meta data.
	 *
	 * @return the summary of this meta data
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the localized summary of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized summary of this meta data
	 */
	@Override
	public String getSummary(java.util.Locale locale) {
		return model.getSummary(locale);
	}

	/**
	 * Returns the localized summary of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized summary of this meta data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSummary(java.util.Locale locale, boolean useDefault) {
		return model.getSummary(locale, useDefault);
	}

	/**
	 * Returns the localized summary of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized summary of this meta data
	 */
	@Override
	public String getSummary(String languageId) {
		return model.getSummary(languageId);
	}

	/**
	 * Returns the localized summary of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized summary of this meta data
	 */
	@Override
	public String getSummary(String languageId, boolean useDefault) {
		return model.getSummary(languageId, useDefault);
	}

	@Override
	public String getSummaryCurrentLanguageId() {
		return model.getSummaryCurrentLanguageId();
	}

	@Override
	public String getSummaryCurrentValue() {
		return model.getSummaryCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized summaries of this meta data.
	 *
	 * @return the locales and localized summaries of this meta data
	 */
	@Override
	public Map<java.util.Locale, String> getSummaryMap() {
		return model.getSummaryMap();
	}

	/**
	 * Returns the title of this meta data.
	 *
	 * @return the title of this meta data
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this meta data
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this meta data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this meta data
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this meta data
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return model.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return model.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return model.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this meta data.
	 *
	 * @return the locales and localized titles of this meta data
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the version of this meta data.
	 *
	 * @return the version of this meta data
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the created of this meta data.
	 *
	 * @param created the created of this meta data
	 */
	@Override
	public void setCreated(String created) {
		model.setCreated(created);
	}

	/**
	 * Sets the creator of this meta data.
	 *
	 * @param creator the creator of this meta data
	 */
	@Override
	public void setCreator(String creator) {
		model.setCreator(creator);
	}

	/**
	 * Sets the data collection ID of this meta data.
	 *
	 * @param dataCollectionId the data collection ID of this meta data
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the data entry ID of this meta data.
	 *
	 * @param dataEntryId the data entry ID of this meta data
	 */
	@Override
	public void setDataEntryId(long dataEntryId) {
		model.setDataEntryId(dataEntryId);
	}

	/**
	 * Sets the data pack ID of this meta data.
	 *
	 * @param dataPackId the data pack ID of this meta data
	 */
	@Override
	public void setDataPackId(long dataPackId) {
		model.setDataPackId(dataPackId);
	}

	/**
	 * Sets the data section ID of this meta data.
	 *
	 * @param dataSectionId the data section ID of this meta data
	 */
	@Override
	public void setDataSectionId(long dataSectionId) {
		model.setDataSectionId(dataSectionId);
	}

	/**
	 * Sets the data set ID of this meta data.
	 *
	 * @param dataSetId the data set ID of this meta data
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the data uuid of this meta data.
	 *
	 * @param dataUuid the data uuid of this meta data
	 */
	@Override
	public void setDataUuid(String dataUuid) {
		model.setDataUuid(dataUuid);
	}

	/**
	 * Sets the date accepted of this meta data.
	 *
	 * @param dateAccepted the date accepted of this meta data
	 */
	@Override
	public void setDateAccepted(String dateAccepted) {
		model.setDateAccepted(dateAccepted);
	}

	/**
	 * Sets the date copyrighted of this meta data.
	 *
	 * @param dateCopyrighted the date copyrighted of this meta data
	 */
	@Override
	public void setDateCopyrighted(String dateCopyrighted) {
		model.setDateCopyrighted(dateCopyrighted);
	}

	/**
	 * Sets the date pattern of this meta data.
	 *
	 * @param datePattern the date pattern of this meta data
	 */
	@Override
	public void setDatePattern(String datePattern) {
		model.setDatePattern(datePattern);
	}

	/**
	 * Sets the date submitted of this meta data.
	 *
	 * @param dateSubmitted the date submitted of this meta data
	 */
	@Override
	public void setDateSubmitted(String dateSubmitted) {
		model.setDateSubmitted(dateSubmitted);
	}

	/**
	 * Sets the description of this meta data.
	 *
	 * @param description the description of this meta data
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this meta data in the language.
	 *
	 * @param description the localized description of this meta data
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this meta data in the language, and sets the default locale.
	 *
	 * @param description the localized description of this meta data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this meta data from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this meta data
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this meta data from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this meta data
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the doi of this meta data.
	 *
	 * @param doi the doi of this meta data
	 */
	@Override
	public void setDoi(String doi) {
		model.setDoi(doi);
	}

	/**
	 * Sets the format of this meta data.
	 *
	 * @param format the format of this meta data
	 */
	@Override
	public void setFormat(String format) {
		model.setFormat(format);
	}

	/**
	 * Sets the issued of this meta data.
	 *
	 * @param issued the issued of this meta data
	 */
	@Override
	public void setIssued(String issued) {
		model.setIssued(issued);
	}

	/**
	 * Sets the license of this meta data.
	 *
	 * @param license the license of this meta data
	 */
	@Override
	public void setLicense(String license) {
		model.setLicense(license);
	}

	@Override
	public void setMetaData(
			com.liferay.portal.kernel.json.JSONObject metaDataJSON)
		throws com.osp.icecap.exception.NoSuchMetaDataFieldException {

		model.setMetaData(metaDataJSON);
	}

	/**
	 * Sets the primary key of this meta data.
	 *
	 * @param primaryKey the primary key of this meta data
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the summary of this meta data.
	 *
	 * @param summary the summary of this meta data
	 */
	@Override
	public void setSummary(String summary) {
		model.setSummary(summary);
	}

	/**
	 * Sets the localized summary of this meta data in the language.
	 *
	 * @param summary the localized summary of this meta data
	 * @param locale the locale of the language
	 */
	@Override
	public void setSummary(String summary, java.util.Locale locale) {
		model.setSummary(summary, locale);
	}

	/**
	 * Sets the localized summary of this meta data in the language, and sets the default locale.
	 *
	 * @param summary the localized summary of this meta data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSummary(
		String summary, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSummary(summary, locale, defaultLocale);
	}

	@Override
	public void setSummaryCurrentLanguageId(String languageId) {
		model.setSummaryCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized summaries of this meta data from the map of locales and localized summaries.
	 *
	 * @param summaryMap the locales and localized summaries of this meta data
	 */
	@Override
	public void setSummaryMap(Map<java.util.Locale, String> summaryMap) {
		model.setSummaryMap(summaryMap);
	}

	/**
	 * Sets the localized summaries of this meta data from the map of locales and localized summaries, and sets the default locale.
	 *
	 * @param summaryMap the locales and localized summaries of this meta data
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSummaryMap(
		Map<java.util.Locale, String> summaryMap,
		java.util.Locale defaultLocale) {

		model.setSummaryMap(summaryMap, defaultLocale);
	}

	/**
	 * Sets the title of this meta data.
	 *
	 * @param title the title of this meta data
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this meta data in the language.
	 *
	 * @param title the localized title of this meta data
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this meta data in the language, and sets the default locale.
	 *
	 * @param title the localized title of this meta data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		model.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this meta data from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this meta data
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this meta data from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this meta data
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the version of this meta data.
	 *
	 * @param version the version of this meta data
	 */
	@Override
	public void setVersion(String version) {
		model.setVersion(version);
	}

	@Override
	protected MetaDataWrapper wrap(MetaData metaData) {
		return new MetaDataWrapper(metaData);
	}

}