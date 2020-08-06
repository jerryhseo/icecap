package com.osp.icecap.search.reindexer.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.osp.icecap.model.DataType;
import com.osp.icecap.search.reindexer.api.DataTypeBatchReindexer;

import org.osgi.service.component.annotations.Reference;

public class DataTypeBatchReindexerImpl implements DataTypeBatchReindexer {

	@Override
	public void reindex(long dataTypeId, long companyId) {
		BatchIndexingActionable batchIndexingActionable =
			    indexerWriter.getBatchIndexingActionable();

			        batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			            Property dataTypeIdPropery = PropertyFactoryUtil.forName( "dataTypeId");

			            dynamicQuery.add(dataTypeIdPropery.eq(dataTypeId));
			        });

			        batchIndexingActionable.setCompanyId(companyId);

			        batchIndexingActionable.setPerformActionMethod((DataType dataType) -> {
			            Document document = indexerDocumentBuilder.getDocument(dataType);

			            batchIndexingActionable.addDocuments(document);
			        });

			        batchIndexingActionable.performActions();
	}

	@Reference(target = "(indexer.class.name=com.osp.icecap.model.DataType)")
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(target = "(indexer.class.name=com.osp.icecap.model.DataType)")
    protected IndexerWriter<DataType> indexerWriter;
}
