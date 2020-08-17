package com.osp.icecap.search.contributor.indexerwriter;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.osp.icecap.model.DataEntry;
import com.osp.icecap.search.reindexer.DataEntryBatchReindexer;
import com.osp.icecap.service.DataEntryLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataEntry",
        service = ModelIndexerWriterContributor.class
)
public class DataEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataEntry> {
	 @Override
	    public void customize(
	        BatchIndexingActionable batchIndexingActionable,
	        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

	        batchIndexingActionable.setPerformActionMethod((DataEntry dataEntry) -> {
	            Document document = modelIndexerWriterDocumentHelper.getDocument(dataEntry);

	            batchIndexingActionable.addDocuments(document);
	        });
	    }

	    @Override
	    public BatchIndexingActionable getBatchIndexingActionable() {
	        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
	    dataEntryLocalService.getIndexableActionableDynamicQuery());
	    }

	    @Override
	    public long getCompanyId(DataEntry dataEntry) {
	        return dataEntry.getCompanyId();
	    }

	    @Override
	    public void modelIndexed(DataEntry dataEntry) {
	        dataEntryBatchReindexer.reindex(
	        		dataEntry.getDataEntryId(), dataEntry.getCompanyId());
	    }

	    @Reference
	    protected DynamicQueryBatchIndexingActionableFactory
	    dynamicQueryBatchIndexingActionableFactory;

	    @Reference
	    protected DataEntryBatchReindexer dataEntryBatchReindexer;

	    @Reference
	    protected DataEntryLocalService dataEntryLocalService;
}
