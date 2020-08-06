package com.osp.icecap.search.contributor.document;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.osp.icecap.model.DataType;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataType",
        service = ModelDocumentContributor.class
)
public class DataTypeModelDocumentContributor implements ModelDocumentContributor<DataType> {

	@Override
	public void contribute(Document document, DataType dataType) {
		try {
            document.addDate(Field.MODIFIED_DATE, dataType.getModifiedDate());

            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(dataType.getGroupId());

            String localizedTitle = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());

            document.addText(localizedTitle, dataType.getName());
        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn("Unable to index data type " + dataType.getDataTypeId(), pe);
            }
        }
	}

	private static final Log _log = LogFactoryUtil.getLog(DataTypeModelDocumentContributor.class);
}
