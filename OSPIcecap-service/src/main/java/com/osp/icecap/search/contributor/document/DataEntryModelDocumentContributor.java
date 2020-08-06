package com.osp.icecap.search.contributor.document;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.model.MetaData;
import com.osp.icecap.service.MetaDataLocalServiceUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataEntry",
        service = ModelDocumentContributor.class
)
public class DataEntryModelDocumentContributor implements ModelDocumentContributor<DataEntry> {

	@Override
	public void contribute(Document document, DataEntry dataEntry) {
		try {
            document.addDate(Field.MODIFIED_DATE, dataEntry.getModifiedDate());

            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(dataEntry.getGroupId());

            String localizedTitle = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());

            MetaData metaData = MetaDataLocalServiceUtil.getMetaData(dataEntry.getUuid());
            document.addText(localizedTitle, metaData.getTitle(defaultLocale));
        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn("Unable to index data type " + dataEntry.getDataEntryId(), pe);
            }
        }
	}

	private static final Log _log = LogFactoryUtil.getLog(DataEntryModelDocumentContributor.class);
}
