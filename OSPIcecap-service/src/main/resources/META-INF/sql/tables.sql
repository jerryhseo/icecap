create table ICECAP_DataAnalysisLayout (
	dataUuid VARCHAR(75) not null primary key,
	dataCollectionId LONG,
	dataSetId LONG,
	dataSectionId LONG,
	dataPackId LONG,
	layout VARCHAR(75) null
);

create table ICECAP_DataCollection (
	uuid_ VARCHAR(75) null,
	dataCollectionId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	version VARCHAR(75) null,
	copiedFrom LONG,
	organizationId LONG,
	hasMetaData BOOLEAN
);

create table ICECAP_DataCollectionLayout (
	dataCollectionId LONG not null primary key,
	layout VARCHAR(75) null
);

create table ICECAP_DataEntry (
	uuid_ VARCHAR(75) null,
	dataEntryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataTypeId LONG,
	dataPackId LONG,
	dataSectionId LONG,
	dataSetId LONG,
	dataCollectionId LONG,
	accessURL VARCHAR(75) null,
	sequenceId VARCHAR(75) null,
	accessType VARCHAR(75) null,
	copiedFrom LONG,
	hasMetaData BOOLEAN
);

create table ICECAP_DataEntryDescription (
	dataEntryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	creator VARCHAR(75) null,
	created VARCHAR(75) null,
	title STRING null,
	description STRING null,
	summary STRING null,
	doi VARCHAR(75) null,
	dateAccepted VARCHAR(75) null,
	dateCopyrighted VARCHAR(75) null,
	dateSubmitted VARCHAR(75) null,
	format VARCHAR(75) null,
	version VARCHAR(75) null,
	issued VARCHAR(75) null,
	license VARCHAR(75) null,
	datePattern VARCHAR(75) null
);

create table ICECAP_DataPack (
	uuid_ VARCHAR(75) null,
	dataPackId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataCollectionId LONG,
	dataSetId LONG,
	dataSectionId LONG,
	name VARCHAR(75) null,
	version VARCHAR(75) null,
	component VARCHAR(75) null,
	copiedFrom LONG,
	hasMetaData BOOLEAN
);

create table ICECAP_DataPackLayout (
	dataPackId LONG not null primary key,
	layout VARCHAR(75) null
);

create table ICECAP_DataSection (
	uuid_ VARCHAR(75) null,
	dataSectionId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataCollectionId LONG,
	dataSetId LONG,
	dataTypeId LONG,
	name VARCHAR(75) null,
	version VARCHAR(75) null,
	copiedFrom LONG,
	hasMetaData BOOLEAN
);

create table ICECAP_DataSectionLayout (
	dataSectionId LONG not null primary key,
	layout VARCHAR(75) null
);

create table ICECAP_DataSet (
	uuid_ VARCHAR(75) null,
	dataSetId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataCollectionId LONG,
	dataTypeId LONG,
	name VARCHAR(75) null,
	version VARCHAR(75) null,
	copiedFrom LONG,
	hasMetaData BOOLEAN
);

create table ICECAP_DataSetLayout (
	dataSetId LONG not null primary key,
	layout VARCHAR(75) null
);

create table ICECAP_DataType (
	uuid_ VARCHAR(75) null,
	dataTypeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	name VARCHAR(75) null,
	version VARCHAR(75) null,
	samplePath VARCHAR(75) null,
	description STRING null
);

create table ICECAP_DataTypeLayout (
	dataTypeId LONG not null primary key,
	layout VARCHAR(75) null
);

create table ICECAP_DataTypeStructure (
	dataTypeId LONG not null primary key,
	structure VARCHAR(75) null
);

create table ICECAP_DataTypeVisualizerLink (
	dataTypeVisualizerLinkId LONG not null primary key,
	dataTypeId LONG,
	visualizerName VARCHAR(75) null,
	visualizerVersion VARCHAR(75) null,
	defaultVisualizer BOOLEAN,
	editable BOOLEAN
);

create table ICECAP_MetaData (
	dataUuid VARCHAR(75) not null primary key,
	creator VARCHAR(75) null,
	created VARCHAR(75) null,
	title STRING null,
	description STRING null,
	summary STRING null,
	doi VARCHAR(75) null,
	dateAccepted VARCHAR(75) null,
	dateCopyrighted VARCHAR(75) null,
	dateSubmitted VARCHAR(75) null,
	format VARCHAR(75) null,
	version VARCHAR(75) null,
	issued VARCHAR(75) null,
	license VARCHAR(75) null,
	datePattern VARCHAR(75) null,
	dataCollectionId LONG,
	dataSetId LONG,
	dataSectionId LONG,
	dataPackId LONG
);