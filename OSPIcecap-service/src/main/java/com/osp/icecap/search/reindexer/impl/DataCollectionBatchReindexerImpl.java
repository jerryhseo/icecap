package com.osp.icecap.search.reindexer.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.osp.icecap.model.DataCollection;
import com.osp.icecap.search.reindexer.DataCollectionBatchReindexer;

import org.osgi.service.component.annotations.Reference;

public class DataCollectionBatchReindexerImpl implements DataCollectionBatchReindexer {

	@Override
	public void reindex(long dataCollectionId, long companyId) {
		BatchIndexingActionable batchIndexingActionable =
			    indexerWriter.getBatchIndexingActionable();

			        batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			            Property dataCollectionIdPropery = PropertyFactoryUtil.forName( "dataCollectionId");

			            dynamicQuery.add(dataCollectionIdPropery.eq(dataCollectionId));
			        });

			        batchIndexingActionable.setCompanyId(companyId);

			        batchIndexingActionable.setPerformActionMethod((DataCollection dataCollection) -> {
			            Document document = indexerDocumentBuilder.getDocument(dataCollection);

			            batchIndexingActionable.addDocuments(document);
			        });

			        batchIndexingActionable.performActions();
	}

	@Reference(target = "(indexer.class.name=com.osp.icecap.model.DataCollection)")
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(target = "(indexer.class.name=com.osp.icecap.model.DataCollection)")
    protected IndexerWriter<DataCollection> indexerWriter;
}
