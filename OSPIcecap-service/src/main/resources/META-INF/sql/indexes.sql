create index IX_5B269905 on ICECAP_DataAnalysisLayout (dataCollectionId);
create index IX_5EC06A80 on ICECAP_DataAnalysisLayout (dataPackId);
create index IX_43C8DC98 on ICECAP_DataAnalysisLayout (dataSectionId);
create index IX_CA7D4695 on ICECAP_DataAnalysisLayout (dataSetId);

create index IX_E47C0A28 on ICECAP_DataCollection (copiedFrom);
create index IX_8D4DDEAA on ICECAP_DataCollection (groupId, status);
create index IX_4E0A58E4 on ICECAP_DataCollection (groupId, userId, status);
create index IX_BF2560C3 on ICECAP_DataCollection (name[$COLUMN_LENGTH:75$], version[$COLUMN_LENGTH:75$]);
create index IX_B3668348 on ICECAP_DataCollection (organizationId);
create index IX_42D6C48C on ICECAP_DataCollection (status);
create index IX_17483CC6 on ICECAP_DataCollection (userId, status);
create index IX_BA3CB01A on ICECAP_DataCollection (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BB86751C on ICECAP_DataCollection (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_983BA438 on ICECAP_DataEntry (copiedFrom);
create index IX_A897158D on ICECAP_DataEntry (dataCollectionId);
create index IX_B74AED08 on ICECAP_DataEntry (dataPackId);
create index IX_E254ED10 on ICECAP_DataEntry (dataSectionId);
create index IX_BCD4530D on ICECAP_DataEntry (dataSetId);
create index IX_623FA1A9 on ICECAP_DataEntry (dataTypeId);
create index IX_17A2C3B4 on ICECAP_DataEntry (groupId);
create index IX_CE15E69C on ICECAP_DataEntry (status);
create index IX_6F94FFF0 on ICECAP_DataEntry (userId);
create index IX_30C47E2A on ICECAP_DataEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F2CA872C on ICECAP_DataEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9FC583E3 on ICECAP_DataPack (copiedFrom);
create index IX_8C748F8 on ICECAP_DataPack (dataCollectionId);
create index IX_27D86985 on ICECAP_DataPack (dataSectionId);
create index IX_9C0A5202 on ICECAP_DataPack (dataSetId);
create index IX_32C5FBE9 on ICECAP_DataPack (groupId);
create index IX_EA2E28E0 on ICECAP_DataPack (name[$COLUMN_LENGTH:75$]);
create index IX_F84053C7 on ICECAP_DataPack (status);
create index IX_99BF6D1B on ICECAP_DataPack (userId);
create index IX_90F4B195 on ICECAP_DataPack (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5DB69957 on ICECAP_DataPack (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_AC580DEB on ICECAP_DataSection (copiedFrom);
create index IX_A2FC2D00 on ICECAP_DataSection (dataCollectionId);
create index IX_BD7A66FA on ICECAP_DataSection (dataSetId);
create index IX_48A6EEE1 on ICECAP_DataSection (groupId);
create index IX_51D2D8E8 on ICECAP_DataSection (name[$COLUMN_LENGTH:75$]);
create index IX_97921CF on ICECAP_DataSection (status);
create index IX_AAF83B23 on ICECAP_DataSection (userId);
create index IX_2B29959D on ICECAP_DataSection (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6A64DF5F on ICECAP_DataSection (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5EFEDBA8 on ICECAP_DataSet (copiedFrom);
create index IX_AC8EF8FD on ICECAP_DataSet (dataCollectionId);
create index IX_74D1167E on ICECAP_DataSet (groupId, userId);
create index IX_621F865 on ICECAP_DataSet (name[$COLUMN_LENGTH:75$]);
create index IX_E67E560C on ICECAP_DataSet (status);
create index IX_34BC619A on ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AD44869C on ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1BF5542D on ICECAP_DataType (extension[$COLUMN_LENGTH:75$]);
create index IX_E6ECF9CD on ICECAP_DataType (groupId, name[$COLUMN_LENGTH:75$], status);
create index IX_2C6B970E on ICECAP_DataType (groupId, status);
create index IX_DB9DBC87 on ICECAP_DataType (groupId, userId, name[$COLUMN_LENGTH:75$], status);
create index IX_9AAB6D48 on ICECAP_DataType (groupId, userId, status);
create index IX_CF9352E7 on ICECAP_DataType (name[$COLUMN_LENGTH:75$], status);
create index IX_4A5DE227 on ICECAP_DataType (name[$COLUMN_LENGTH:75$], version[$COLUMN_LENGTH:75$]);
create index IX_C2A94BA8 on ICECAP_DataType (status);
create index IX_97CE5BA1 on ICECAP_DataType (userId, name[$COLUMN_LENGTH:75$], status);
create index IX_F31FE7E2 on ICECAP_DataType (userId, status);
create index IX_FED60436 on ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_975E2038 on ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7EE8DBE5 on ICECAP_DataTypeVisualizerLink (dataTypeId, editable);
create index IX_5D42A1B2 on ICECAP_DataTypeVisualizerLink (editable);
create unique index IX_B506253 on ICECAP_DataTypeVisualizerLink (visualizerName[$COLUMN_LENGTH:75$], visualizerVersion[$COLUMN_LENGTH:75$]);

create index IX_67BA6870 on ICECAP_DataType_Visualizers (companyId);
create index IX_18599343 on ICECAP_DataType_Visualizers (dataTypeVisualizerLinkId);

create index IX_4F9DD1AF on ICECAP_MetaData (creator[$COLUMN_LENGTH:75$]);
create index IX_639E964 on ICECAP_MetaData (dataCollectionId);
create index IX_3285F166 on ICECAP_MetaData (dataEntryId);
create index IX_ED332E1F on ICECAP_MetaData (dataPackId);
create index IX_21038099 on ICECAP_MetaData (dataSectionId);
create index IX_8E41316 on ICECAP_MetaData (dataSetId);