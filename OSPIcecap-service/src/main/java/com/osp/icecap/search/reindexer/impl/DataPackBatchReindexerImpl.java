package com.osp.icecap.search.reindexer.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.osp.icecap.model.DataPack;
import com.osp.icecap.search.reindexer.DataPackBatchReindexer;

import org.osgi.service.component.annotations.Reference;

public class DataPackBatchReindexerImpl implements DataPackBatchReindexer {

	@Override
	public void reindex(long dataPackId, long companyId) {
		BatchIndexingActionable batchIndexingActionable =
			    indexerWriter.getBatchIndexingActionable();

			        batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			            Property dataPackIdPropery = PropertyFactoryUtil.forName( "dataPackId");

			            dynamicQuery.add(dataPackIdPropery.eq(dataPackId));
			        });

			        batchIndexingActionable.setCompanyId(companyId);

			        batchIndexingActionable.setPerformActionMethod((DataPack dataPack) -> {
			            Document document = indexerDocumentBuilder.getDocument(dataPack);

			            batchIndexingActionable.addDocuments(document);
			        });

			        batchIndexingActionable.performActions();
	}

	@Reference(target = "(indexer.class.name=com.osp.icecap.model.DataPack)")
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(target = "(indexer.class.name=com.osp.icecap.model.DataPack)")
    protected IndexerWriter<DataPack> indexerWriter;
}
