/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package FeedbackService.model.impl;

import FeedbackService.model.Feedback;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Feedback in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FeedbackCacheModel
	implements CacheModel<Feedback>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FeedbackCacheModel)) {
			return false;
		}

		FeedbackCacheModel feedbackCacheModel = (FeedbackCacheModel)object;

		if (feedbackId == feedbackCacheModel.feedbackId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, feedbackId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", feedbackId=");
		sb.append(feedbackId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", feedbackName=");
		sb.append(feedbackName);
		sb.append(", feedbackEmail=");
		sb.append(feedbackEmail);
		sb.append(", feedbackSubject=");
		sb.append(feedbackSubject);
		sb.append(", feedbackMessage=");
		sb.append(feedbackMessage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Feedback toEntityModel() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		if (uuid == null) {
			feedbackImpl.setUuid("");
		}
		else {
			feedbackImpl.setUuid(uuid);
		}

		feedbackImpl.setFeedbackId(feedbackId);
		feedbackImpl.setGroupId(groupId);
		feedbackImpl.setCompanyId(companyId);
		feedbackImpl.setUserId(userId);

		if (userName == null) {
			feedbackImpl.setUserName("");
		}
		else {
			feedbackImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			feedbackImpl.setCreateDate(null);
		}
		else {
			feedbackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			feedbackImpl.setModifiedDate(null);
		}
		else {
			feedbackImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (feedbackName == null) {
			feedbackImpl.setFeedbackName("");
		}
		else {
			feedbackImpl.setFeedbackName(feedbackName);
		}

		if (feedbackEmail == null) {
			feedbackImpl.setFeedbackEmail("");
		}
		else {
			feedbackImpl.setFeedbackEmail(feedbackEmail);
		}

		if (feedbackSubject == null) {
			feedbackImpl.setFeedbackSubject("");
		}
		else {
			feedbackImpl.setFeedbackSubject(feedbackSubject);
		}

		if (feedbackMessage == null) {
			feedbackImpl.setFeedbackMessage("");
		}
		else {
			feedbackImpl.setFeedbackMessage(feedbackMessage);
		}

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		feedbackId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		feedbackName = objectInput.readUTF();
		feedbackEmail = objectInput.readUTF();
		feedbackSubject = objectInput.readUTF();
		feedbackMessage = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(feedbackId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (feedbackName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(feedbackName);
		}

		if (feedbackEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(feedbackEmail);
		}

		if (feedbackSubject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(feedbackSubject);
		}

		if (feedbackMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(feedbackMessage);
		}
	}

	public String uuid;
	public long feedbackId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String feedbackName;
	public String feedbackEmail;
	public String feedbackSubject;
	public String feedbackMessage;

}