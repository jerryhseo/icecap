package com.osp.icecap.search.contributor.document;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.osp.icecap.model.DataSection;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataSection",
        service = ModelDocumentContributor.class
)
public class DataSectionModelDocumentContributor implements ModelDocumentContributor<DataSection> {

	@Override
	public void contribute(Document document, DataSection dataSection) {
		try {
            document.addDate(Field.MODIFIED_DATE, dataSection.getModifiedDate());

            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(dataSection.getGroupId());

            String localizedTitle = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());

            document.addText(localizedTitle, dataSection.getName());
        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn("Unable to index data type " + dataSection.getDataSectionId(), pe);
            }
        }
	}

	private static final Log _log = LogFactoryUtil.getLog(DataSectionModelDocumentContributor.class);
}
