package com.osp.icecap.search.contributor.document;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.osp.icecap.model.DataSet;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataSet",
        service = ModelDocumentContributor.class
)
public class DataSetModelDocumentContributor implements ModelDocumentContributor<DataSet> {

	@Override
	public void contribute(Document document, DataSet dataSet) {
		try {
            document.addDate(Field.MODIFIED_DATE, dataSet.getModifiedDate());

            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(dataSet.getGroupId());

            String localizedTitle = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());

            document.addText(localizedTitle, dataSet.getName());
        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn("Unable to index data type " + dataSet.getDataSetId(), pe);
            }
        }
	}

	private static final Log _log = LogFactoryUtil.getLog(DataSetModelDocumentContributor.class);
}
