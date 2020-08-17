package com.osp.icecap.search.reindexer.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.osp.icecap.model.DataSet;
import com.osp.icecap.search.reindexer.DataSetBatchReindexer;

import org.osgi.service.component.annotations.Reference;

public class DataSetBatchReindexerImpl implements DataSetBatchReindexer {

	@Override
	public void reindex(long dataSetId, long companyId) {
		BatchIndexingActionable batchIndexingActionable =
			    indexerWriter.getBatchIndexingActionable();

			        batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			            Property dataSetIdPropery = PropertyFactoryUtil.forName( "dataSetId");

			            dynamicQuery.add(dataSetIdPropery.eq(dataSetId));
			        });

			        batchIndexingActionable.setCompanyId(companyId);

			        batchIndexingActionable.setPerformActionMethod((DataSet dataSet) -> {
			            Document document = indexerDocumentBuilder.getDocument(dataSet);

			            batchIndexingActionable.addDocuments(document);
			        });

			        batchIndexingActionable.performActions();
	}

	@Reference(target = "(indexer.class.name=com.osp.icecap.model.DataSet)")
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(target = "(indexer.class.name=com.osp.icecap.model.DataSet)")
    protected IndexerWriter<DataSet> indexerWriter;
}
