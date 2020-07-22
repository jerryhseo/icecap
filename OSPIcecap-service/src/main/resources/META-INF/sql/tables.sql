create table ICECAP_DataAnalysisLayout (
	dataUuid VARCHAR(75) not null primary key,
	layout VARCHAR(75) null,
	applyLevel VARCHAR(75) null
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
	title STRING null,
	description STRING null,
	organizationId LONG
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
	dataPackId LONG,
	dataSectionId LONG,
	dataSetId LONG,
	dataCollectionId LONG,
	accessURL VARCHAR(75) null,
	pathType VARCHAR(75) null,
	copiedFrom LONG
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
	title STRING null,
	version VARCHAR(75) null,
	description STRING null,
	copiedFrom LONG
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
	title STRING null,
	version VARCHAR(75) null,
	description STRING null,
	copiedFrom LONG
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
	title STRING null,
	version VARCHAR(75) null,
	description STRING null,
	copiedFrom LONG
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

create table ICECAP_DataTypeLink (
	dataUuid VARCHAR(75) not null primary key,
	dataTypeId LONG
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