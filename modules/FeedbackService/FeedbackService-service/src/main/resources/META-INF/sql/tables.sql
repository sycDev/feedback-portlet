create table FB_Feedback (
	uuid_ VARCHAR(75) null,
	feedbackId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	feedbackName VARCHAR(75) null,
	feedbackEmail VARCHAR(75) null,
	feedbackSubject VARCHAR(75) null,
	feedbackMessage STRING null
);