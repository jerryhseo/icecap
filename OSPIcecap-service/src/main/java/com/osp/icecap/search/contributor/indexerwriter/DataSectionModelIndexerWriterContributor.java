package com.osp.icecap.search.contributor.indexerwriter;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.osp.icecap.model.DataSection;
import com.osp.icecap.search.reindexer.DataSectionBatchReindexer;
import com.osp.icecap.service.DataSectionLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataSection",
        service = ModelIndexerWriterContributor.class
)
public class DataSectionModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataSection> {
	 @Override
	    public void customize(
	        BatchIndexingActionable batchIndexingActionable,
	        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

	        batchIndexingActionable.setPerformActionMethod((DataSection dataSection) -> {
	            Document document = modelIndexerWriterDocumentHelper.getDocument(dataSection);

	            batchIndexingActionable.addDocuments(document);
	        });
	    }

	    @Override
	    public BatchIndexingActionable getBatchIndexingActionable() {
	        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
	    dataSectionLocalService.getIndexableActionableDynamicQuery());
	    }

	    @Override
	    public long getCompanyId(DataSection dataSection) {
	        return dataSection.getCompanyId();
	    }

	    @Override
	    public void modelIndexed(DataSection dataSection) {
	        dataSectionBatchReindexer.reindex(
	        		dataSection.getDataSectionId(), dataSection.getCompanyId());
	    }

	    @Reference
	    protected DynamicQueryBatchIndexingActionableFactory
	    dynamicQueryBatchIndexingActionableFactory;

	    @Reference
	    protected DataSectionBatchReindexer dataSectionBatchReindexer;

	    @Reference
	    protected DataSectionLocalService dataSectionLocalService;
}
