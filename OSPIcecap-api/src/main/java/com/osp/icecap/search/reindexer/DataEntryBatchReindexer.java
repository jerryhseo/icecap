package com.osp.icecap.search.reindexer;

public interface DataEntryBatchReindexer {
	public void reindex(long dataEntryId, long companyId);
}
