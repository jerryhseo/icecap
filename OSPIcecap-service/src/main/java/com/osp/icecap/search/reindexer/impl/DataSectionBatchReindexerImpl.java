package com.osp.icecap.search.reindexer.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.osp.icecap.model.DataSection;
import com.osp.icecap.search.reindexer.DataSectionBatchReindexer;

import org.osgi.service.component.annotations.Reference;

public class DataSectionBatchReindexerImpl implements DataSectionBatchReindexer {

	@Override
	public void reindex(long dataSectionId, long companyId) {
		BatchIndexingActionable batchIndexingActionable =
			    indexerWriter.getBatchIndexingActionable();

			        batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			            Property dataSectionIdPropery = PropertyFactoryUtil.forName( "dataSectionId");

			            dynamicQuery.add(dataSectionIdPropery.eq(dataSectionId));
			        });

			        batchIndexingActionable.setCompanyId(companyId);

			        batchIndexingActionable.setPerformActionMethod((DataSection dataSection) -> {
			            Document document = indexerDocumentBuilder.getDocument(dataSection);

			            batchIndexingActionable.addDocuments(document);
			        });

			        batchIndexingActionable.performActions();
	}

	@Reference(target = "(indexer.class.name=com.osp.icecap.model.DataSection)")
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(target = "(indexer.class.name=com.osp.icecap.model.DataSection)")
    protected IndexerWriter<DataSection> indexerWriter;
}
