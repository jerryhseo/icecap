package com.osp.icecap.search.contributor.indexerwriter;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.osp.icecap.model.DataCollection;
import com.osp.icecap.search.reindexer.DataCollectionBatchReindexer;
import com.osp.icecap.service.DataCollectionLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataCollection",
        service = ModelIndexerWriterContributor.class
)
public class DataCollectionModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataCollection> {
	 @Override
	    public void customize(
	        BatchIndexingActionable batchIndexingActionable,
	        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

	        batchIndexingActionable.setPerformActionMethod((DataCollection dataCollection) -> {
	            Document document = modelIndexerWriterDocumentHelper.getDocument(dataCollection);

	            batchIndexingActionable.addDocuments(document);
	        });
	    }

	    @Override
	    public BatchIndexingActionable getBatchIndexingActionable() {
	        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
	    dataCollectionLocalService.getIndexableActionableDynamicQuery());
	    }

	    @Override
	    public long getCompanyId(DataCollection dataCollection) {
	        return dataCollection.getCompanyId();
	    }

	    @Override
	    public void modelIndexed(DataCollection dataCollection) {
	        dataCollectionBatchReindexer.reindex(
	        		dataCollection.getDataCollectionId(), dataCollection.getCompanyId());
	    }

	    @Reference
	    protected DynamicQueryBatchIndexingActionableFactory
	    dynamicQueryBatchIndexingActionableFactory;

	    @Reference
	    protected DataCollectionBatchReindexer dataCollectionBatchReindexer;

	    @Reference
	    protected DataCollectionLocalService dataCollectionLocalService;
}
