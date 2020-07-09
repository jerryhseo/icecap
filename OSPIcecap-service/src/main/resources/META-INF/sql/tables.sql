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
	name VARCHAR(75) null,
	variantFrom LONG,
	title STRING null,
	description STRING null,
	storageType VARCHAR(75) null,
	dataTypeName LONG,
	dataTypeVersion LONG
);

create table ICECAP_DataCollectionLayout (
	dataCollectionId LONG not null primary key,
	layout VARCHAR(75) null
);

create table ICECAP_DataEntry (
	dataEntryId LONG not null primary key,
	dataCollectionName VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	path_ VARCHAR(75) null,
	sequenceNo INTEGER,
	recordCount INTEGER,
	sequenceDelimeter VARCHAR(75) null
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
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	version VARCHAR(75) null,
	samplePath VARCHAR(75) null,
	description STRING null,
	superType LONG
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