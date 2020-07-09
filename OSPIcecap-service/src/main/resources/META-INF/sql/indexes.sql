create index IX_97D5DB7B on ICECAP_DataCollection (dataTypeName, dataTypeVersion);
create index IX_8D4DDEAA on ICECAP_DataCollection (groupId, status);
create index IX_4E0A58E4 on ICECAP_DataCollection (groupId, userId, status);
create index IX_2C406E5 on ICECAP_DataCollection (name[$COLUMN_LENGTH:75$]);
create index IX_42D6C48C on ICECAP_DataCollection (status);
create index IX_17483CC6 on ICECAP_DataCollection (userId, status);
create index IX_BA3CB01A on ICECAP_DataCollection (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BB86751C on ICECAP_DataCollection (uuid_[$COLUMN_LENGTH:75$], groupId);

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

create index IX_4FF777CD on ICECAP_DataTypeVisualizerLink (dataTypeId);
create index IX_5D42A1B2 on ICECAP_DataTypeVisualizerLink (editable);
create unique index IX_B506253 on ICECAP_DataTypeVisualizerLink (visualizerName[$COLUMN_LENGTH:75$], visualizerVersion[$COLUMN_LENGTH:75$]);