package com.osp.icecap.search.contributor.indexerwriter;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.osp.icecap.model.DataPack;
import com.osp.icecap.search.reindexer.DataPackBatchReindexer;
import com.osp.icecap.service.DataPackLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataPack",
        service = ModelIndexerWriterContributor.class
)
public class DataPackModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataPack> {
	 @Override
	    public void customize(
	        BatchIndexingActionable batchIndexingActionable,
	        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

	        batchIndexingActionable.setPerformActionMethod((DataPack dataPack) -> {
	            Document document = modelIndexerWriterDocumentHelper.getDocument(dataPack);

	            batchIndexingActionable.addDocuments(document);
	        });
	    }

	    @Override
	    public BatchIndexingActionable getBatchIndexingActionable() {
	        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
	    dataPackLocalService.getIndexableActionableDynamicQuery());
	    }

	    @Override
	    public long getCompanyId(DataPack dataPack) {
	        return dataPack.getCompanyId();
	    }

	    @Override
	    public void modelIndexed(DataPack dataPack) {
	        dataPackBatchReindexer.reindex(
	        		dataPack.getDataPackId(), dataPack.getCompanyId());
	    }

	    @Reference
	    protected DynamicQueryBatchIndexingActionableFactory
	    dynamicQueryBatchIndexingActionableFactory;

	    @Reference
	    protected DataPackBatchReindexer dataPackBatchReindexer;

	    @Reference
	    protected DataPackLocalService dataPackLocalService;
}
