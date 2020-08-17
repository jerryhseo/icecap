package com.osp.icecap.search.contributor.indexerwriter;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.osp.icecap.model.DataType;
import com.osp.icecap.search.reindexer.DataTypeBatchReindexer;
import com.osp.icecap.service.DataTypeLocalService;

import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.osp.icecap.model.DataType",
        service = ModelIndexerWriterContributor.class
)
public class DataTypeModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataType> {
	@Override
	public void customize(
	        BatchIndexingActionable batchIndexingActionable,
	        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

	        batchIndexingActionable.setPerformActionMethod((DataType dataType) -> {
	            Document document = modelIndexerWriterDocumentHelper.getDocument(dataType);
	           Map<String, Field> fieldMap =  document.getFields();
	           Set<String> keySet = fieldMap.keySet();
	           System.out.println("DataType Key Set: "+dataType.getPrimaryKey());
	           for( String key : keySet ) {
	        	   System.out.println("==>"+ key);
	           }

	            batchIndexingActionable.addDocuments(document);
	        });
	    }

	    @Override
	    public BatchIndexingActionable getBatchIndexingActionable() {
	        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
	    dataTypeLocalService.getIndexableActionableDynamicQuery());
	    }

	    @Override
	    public long getCompanyId(DataType dataType) {
	        return dataType.getCompanyId();
	    }

	    @Override
	    public void modelIndexed(DataType dataType) {
	        dataTypeBatchReindexer.reindex(
	        		dataType.getDataTypeId(), dataType.getCompanyId());
	    }

	    @Reference
	    protected DynamicQueryBatchIndexingActionableFactory
	    dynamicQueryBatchIndexingActionableFactory;

	    @Reference
	    protected DataTypeBatchReindexer dataTypeBatchReindexer;

	    @Reference
	    protected DataTypeLocalService dataTypeLocalService;
}
