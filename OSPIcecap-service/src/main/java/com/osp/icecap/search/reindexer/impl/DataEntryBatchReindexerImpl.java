package com.osp.icecap.search.reindexer.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.search.reindexer.DataEntryBatchReindexer;

import org.osgi.service.component.annotations.Reference;

public class DataEntryBatchReindexerImpl implements DataEntryBatchReindexer {

	@Override
	public void reindex(long dataEntryId, long companyId) {
		BatchIndexingActionable batchIndexingActionable =
			    indexerWriter.getBatchIndexingActionable();

			        batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			            Property dataEntryIdPropery = PropertyFactoryUtil.forName( "dataEntryId");

			            dynamicQuery.add(dataEntryIdPropery.eq(dataEntryId));
			        });

			        batchIndexingActionable.setCompanyId(companyId);

			        batchIndexingActionable.setPerformActionMethod((DataEntry dataEntry) -> {
			            Document document = indexerDocumentBuilder.getDocument(dataEntry);

			            batchIndexingActionable.addDocuments(document);
			        });

			        batchIndexingActionable.performActions();
	}

	@Reference(target = "(indexer.class.name=com.osp.icecap.model.DataEntry)")
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(target = "(indexer.class.name=com.osp.icecap.model.DataEntry)")
    protected IndexerWriter<DataEntry> indexerWriter;
}
