package com.osp.icecap.search.contributor.indexerwriter;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.osp.icecap.model.DataSet;
import com.osp.icecap.search.reindexer.DataSetBatchReindexer;
import com.osp.icecap.service.DataSetLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataSet",
        service = ModelIndexerWriterContributor.class
)
public class DataSetModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataSet> {
	 @Override
	    public void customize(
	        BatchIndexingActionable batchIndexingActionable,
	        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

	        batchIndexingActionable.setPerformActionMethod((DataSet dataSet) -> {
	            Document document = modelIndexerWriterDocumentHelper.getDocument(dataSet);

	            batchIndexingActionable.addDocuments(document);
	        });
	    }

	    @Override
	    public BatchIndexingActionable getBatchIndexingActionable() {
	        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
	    dataSetLocalService.getIndexableActionableDynamicQuery());
	    }

	    @Override
	    public long getCompanyId(DataSet dataSet) {
	        return dataSet.getCompanyId();
	    }

	    @Override
	    public void modelIndexed(DataSet dataSet) {
	        dataSetBatchReindexer.reindex(
	        		dataSet.getDataSetId(), dataSet.getCompanyId());
	    }

	    @Reference
	    protected DynamicQueryBatchIndexingActionableFactory
	    dynamicQueryBatchIndexingActionableFactory;

	    @Reference
	    protected DataSetBatchReindexer dataSetBatchReindexer;

	    @Reference
	    protected DataSetLocalService dataSetLocalService;
}
