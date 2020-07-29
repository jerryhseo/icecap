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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;

import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MetaData service. Represents a row in the &quot;ICECAP_MetaData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.osp.icecap.model.impl.MetaDataModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.osp.icecap.model.impl.MetaDataImpl</code>.
 * </p>
 *
 * @author Jerry H. Seo
 * @see MetaData
 * @generated
 */
@ProviderType
public interface MetaDataModel extends BaseModel<MetaData>, LocalizedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a meta data model instance should use the {@link MetaData} interface instead.
	 */

	/**
	 * Returns the primary key of this meta data.
	 *
	 * @return the primary key of this meta data
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this meta data.
	 *
	 * @param primaryKey the primary key of this meta data
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the data uuid of this meta data.
	 *
	 * @return the data uuid of this meta data
	 */
	@AutoEscape
	public String getDataUuid();

	/**
	 * Sets the data uuid of this meta data.
	 *
	 * @param dataUuid the data uuid of this meta data
	 */
	public void setDataUuid(String dataUuid);

	/**
	 * Returns the creator of this meta data.
	 *
	 * @return the creator of this meta data
	 */
	@AutoEscape
	public String getCreator();

	/**
	 * Sets the creator of this meta data.
	 *
	 * @param creator the creator of this meta data
	 */
	public void setCreator(String creator);

	/**
	 * Returns the created of this meta data.
	 *
	 * @return the created of this meta data
	 */
	@AutoEscape
	public String getCreated();

	/**
	 * Sets the created of this meta data.
	 *
	 * @param created the created of this meta data
	 */
	public void setCreated(String created);

	/**
	 * Returns the title of this meta data.
	 *
	 * @return the title of this meta data
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this meta data
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this meta data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this meta data
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this meta data
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this meta data.
	 *
	 * @return the locales and localized titles of this meta data
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this meta data.
	 *
	 * @param title the title of this meta data
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this meta data in the language.
	 *
	 * @param title the localized title of this meta data
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this meta data in the language, and sets the default locale.
	 *
	 * @param title the localized title of this meta data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this meta data from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this meta data
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this meta data from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this meta data
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this meta data.
	 *
	 * @return the description of this meta data
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this meta data
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this meta data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this meta data
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this meta data
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this meta data.
	 *
	 * @return the locales and localized descriptions of this meta data
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this meta data.
	 *
	 * @param description the description of this meta data
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this meta data in the language.
	 *
	 * @param description the localized description of this meta data
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this meta data in the language, and sets the default locale.
	 *
	 * @param description the localized description of this meta data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this meta data from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this meta data
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this meta data from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this meta data
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the summary of this meta data.
	 *
	 * @return the summary of this meta data
	 */
	public String getSummary();

	/**
	 * Returns the localized summary of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized summary of this meta data
	 */
	@AutoEscape
	public String getSummary(Locale locale);

	/**
	 * Returns the localized summary of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized summary of this meta data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSummary(Locale locale, boolean useDefault);

	/**
	 * Returns the localized summary of this meta data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized summary of this meta data
	 */
	@AutoEscape
	public String getSummary(String languageId);

	/**
	 * Returns the localized summary of this meta data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized summary of this meta data
	 */
	@AutoEscape
	public String getSummary(String languageId, boolean useDefault);

	@AutoEscape
	public String getSummaryCurrentLanguageId();

	@AutoEscape
	public String getSummaryCurrentValue();

	/**
	 * Returns a map of the locales and localized summaries of this meta data.
	 *
	 * @return the locales and localized summaries of this meta data
	 */
	public Map<Locale, String> getSummaryMap();

	/**
	 * Sets the summary of this meta data.
	 *
	 * @param summary the summary of this meta data
	 */
	public void setSummary(String summary);

	/**
	 * Sets the localized summary of this meta data in the language.
	 *
	 * @param summary the localized summary of this meta data
	 * @param locale the locale of the language
	 */
	public void setSummary(String summary, Locale locale);

	/**
	 * Sets the localized summary of this meta data in the language, and sets the default locale.
	 *
	 * @param summary the localized summary of this meta data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSummary(String summary, Locale locale, Locale defaultLocale);

	public void setSummaryCurrentLanguageId(String languageId);

	/**
	 * Sets the localized summaries of this meta data from the map of locales and localized summaries.
	 *
	 * @param summaryMap the locales and localized summaries of this meta data
	 */
	public void setSummaryMap(Map<Locale, String> summaryMap);

	/**
	 * Sets the localized summaries of this meta data from the map of locales and localized summaries, and sets the default locale.
	 *
	 * @param summaryMap the locales and localized summaries of this meta data
	 * @param defaultLocale the default locale
	 */
	public void setSummaryMap(
		Map<Locale, String> summaryMap, Locale defaultLocale);

	/**
	 * Returns the doi of this meta data.
	 *
	 * @return the doi of this meta data
	 */
	@AutoEscape
	public String getDoi();

	/**
	 * Sets the doi of this meta data.
	 *
	 * @param doi the doi of this meta data
	 */
	public void setDoi(String doi);

	/**
	 * Returns the date accepted of this meta data.
	 *
	 * @return the date accepted of this meta data
	 */
	@AutoEscape
	public String getDateAccepted();

	/**
	 * Sets the date accepted of this meta data.
	 *
	 * @param dateAccepted the date accepted of this meta data
	 */
	public void setDateAccepted(String dateAccepted);

	/**
	 * Returns the date copyrighted of this meta data.
	 *
	 * @return the date copyrighted of this meta data
	 */
	@AutoEscape
	public String getDateCopyrighted();

	/**
	 * Sets the date copyrighted of this meta data.
	 *
	 * @param dateCopyrighted the date copyrighted of this meta data
	 */
	public void setDateCopyrighted(String dateCopyrighted);

	/**
	 * Returns the date submitted of this meta data.
	 *
	 * @return the date submitted of this meta data
	 */
	@AutoEscape
	public String getDateSubmitted();

	/**
	 * Sets the date submitted of this meta data.
	 *
	 * @param dateSubmitted the date submitted of this meta data
	 */
	public void setDateSubmitted(String dateSubmitted);

	/**
	 * Returns the format of this meta data.
	 *
	 * @return the format of this meta data
	 */
	@AutoEscape
	public String getFormat();

	/**
	 * Sets the format of this meta data.
	 *
	 * @param format the format of this meta data
	 */
	public void setFormat(String format);

	/**
	 * Returns the version of this meta data.
	 *
	 * @return the version of this meta data
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this meta data.
	 *
	 * @param version the version of this meta data
	 */
	public void setVersion(String version);

	/**
	 * Returns the issued of this meta data.
	 *
	 * @return the issued of this meta data
	 */
	@AutoEscape
	public String getIssued();

	/**
	 * Sets the issued of this meta data.
	 *
	 * @param issued the issued of this meta data
	 */
	public void setIssued(String issued);

	/**
	 * Returns the license of this meta data.
	 *
	 * @return the license of this meta data
	 */
	@AutoEscape
	public String getLicense();

	/**
	 * Sets the license of this meta data.
	 *
	 * @param license the license of this meta data
	 */
	public void setLicense(String license);

	/**
	 * Returns the date pattern of this meta data.
	 *
	 * @return the date pattern of this meta data
	 */
	@AutoEscape
	public String getDatePattern();

	/**
	 * Sets the date pattern of this meta data.
	 *
	 * @param datePattern the date pattern of this meta data
	 */
	public void setDatePattern(String datePattern);

	/**
	 * Returns the data collection ID of this meta data.
	 *
	 * @return the data collection ID of this meta data
	 */
	public long getDataCollectionId();

	/**
	 * Sets the data collection ID of this meta data.
	 *
	 * @param dataCollectionId the data collection ID of this meta data
	 */
	public void setDataCollectionId(long dataCollectionId);

	/**
	 * Returns the data set ID of this meta data.
	 *
	 * @return the data set ID of this meta data
	 */
	public long getDataSetId();

	/**
	 * Sets the data set ID of this meta data.
	 *
	 * @param dataSetId the data set ID of this meta data
	 */
	public void setDataSetId(long dataSetId);

	/**
	 * Returns the data section ID of this meta data.
	 *
	 * @return the data section ID of this meta data
	 */
	public long getDataSectionId();

	/**
	 * Sets the data section ID of this meta data.
	 *
	 * @param dataSectionId the data section ID of this meta data
	 */
	public void setDataSectionId(long dataSectionId);

	/**
	 * Returns the data pack ID of this meta data.
	 *
	 * @return the data pack ID of this meta data
	 */
	public long getDataPackId();

	/**
	 * Sets the data pack ID of this meta data.
	 *
	 * @param dataPackId the data pack ID of this meta data
	 */
	public void setDataPackId(long dataPackId);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}