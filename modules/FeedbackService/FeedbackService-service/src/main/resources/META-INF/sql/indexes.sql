create index IX_1D61E1DA on FB_Feedback (companyId);
create index IX_872715A4 on FB_Feedback (feedbackMessage[$COLUMN_LENGTH:4000$]);
create index IX_95CD16DC on FB_Feedback (groupId);
create index IX_FD013802 on FB_Feedback (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4E1BD704 on FB_Feedback (uuid_[$COLUMN_LENGTH:75$], groupId);