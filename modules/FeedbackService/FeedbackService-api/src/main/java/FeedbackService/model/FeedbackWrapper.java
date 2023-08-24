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

package FeedbackService.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Feedback}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Feedback
 * @generated
 */
public class FeedbackWrapper
	extends BaseModelWrapper<Feedback>
	implements Feedback, ModelWrapper<Feedback> {

	public FeedbackWrapper(Feedback feedback) {
		super(feedback);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("feedbackId", getFeedbackId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("feedbackName", getFeedbackName());
		attributes.put("feedbackEmail", getFeedbackEmail());
		attributes.put("feedbackSubject", getFeedbackSubject());
		attributes.put("feedbackMessage", getFeedbackMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String feedbackName = (String)attributes.get("feedbackName");

		if (feedbackName != null) {
			setFeedbackName(feedbackName);
		}

		String feedbackEmail = (String)attributes.get("feedbackEmail");

		if (feedbackEmail != null) {
			setFeedbackEmail(feedbackEmail);
		}

		String feedbackSubject = (String)attributes.get("feedbackSubject");

		if (feedbackSubject != null) {
			setFeedbackSubject(feedbackSubject);
		}

		String feedbackMessage = (String)attributes.get("feedbackMessage");

		if (feedbackMessage != null) {
			setFeedbackMessage(feedbackMessage);
		}
	}

	@Override
	public Feedback cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this feedback.
	 *
	 * @return the company ID of this feedback
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this feedback.
	 *
	 * @return the create date of this feedback
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the feedback email of this feedback.
	 *
	 * @return the feedback email of this feedback
	 */
	@Override
	public String getFeedbackEmail() {
		return model.getFeedbackEmail();
	}

	/**
	 * Returns the feedback ID of this feedback.
	 *
	 * @return the feedback ID of this feedback
	 */
	@Override
	public long getFeedbackId() {
		return model.getFeedbackId();
	}

	/**
	 * Returns the feedback message of this feedback.
	 *
	 * @return the feedback message of this feedback
	 */
	@Override
	public String getFeedbackMessage() {
		return model.getFeedbackMessage();
	}

	/**
	 * Returns the feedback name of this feedback.
	 *
	 * @return the feedback name of this feedback
	 */
	@Override
	public String getFeedbackName() {
		return model.getFeedbackName();
	}

	/**
	 * Returns the feedback subject of this feedback.
	 *
	 * @return the feedback subject of this feedback
	 */
	@Override
	public String getFeedbackSubject() {
		return model.getFeedbackSubject();
	}

	/**
	 * Returns the group ID of this feedback.
	 *
	 * @return the group ID of this feedback
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this feedback.
	 *
	 * @return the modified date of this feedback
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this feedback.
	 *
	 * @return the primary key of this feedback
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this feedback.
	 *
	 * @return the user ID of this feedback
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this feedback.
	 *
	 * @return the user name of this feedback
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this feedback.
	 *
	 * @return the user uuid of this feedback
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this feedback.
	 *
	 * @return the uuid of this feedback
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this feedback.
	 *
	 * @param companyId the company ID of this feedback
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this feedback.
	 *
	 * @param createDate the create date of this feedback
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the feedback email of this feedback.
	 *
	 * @param feedbackEmail the feedback email of this feedback
	 */
	@Override
	public void setFeedbackEmail(String feedbackEmail) {
		model.setFeedbackEmail(feedbackEmail);
	}

	/**
	 * Sets the feedback ID of this feedback.
	 *
	 * @param feedbackId the feedback ID of this feedback
	 */
	@Override
	public void setFeedbackId(long feedbackId) {
		model.setFeedbackId(feedbackId);
	}

	/**
	 * Sets the feedback message of this feedback.
	 *
	 * @param feedbackMessage the feedback message of this feedback
	 */
	@Override
	public void setFeedbackMessage(String feedbackMessage) {
		model.setFeedbackMessage(feedbackMessage);
	}

	/**
	 * Sets the feedback name of this feedback.
	 *
	 * @param feedbackName the feedback name of this feedback
	 */
	@Override
	public void setFeedbackName(String feedbackName) {
		model.setFeedbackName(feedbackName);
	}

	/**
	 * Sets the feedback subject of this feedback.
	 *
	 * @param feedbackSubject the feedback subject of this feedback
	 */
	@Override
	public void setFeedbackSubject(String feedbackSubject) {
		model.setFeedbackSubject(feedbackSubject);
	}

	/**
	 * Sets the group ID of this feedback.
	 *
	 * @param groupId the group ID of this feedback
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this feedback.
	 *
	 * @param modifiedDate the modified date of this feedback
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this feedback.
	 *
	 * @param primaryKey the primary key of this feedback
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this feedback.
	 *
	 * @param userId the user ID of this feedback
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this feedback.
	 *
	 * @param userName the user name of this feedback
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this feedback.
	 *
	 * @param userUuid the user uuid of this feedback
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this feedback.
	 *
	 * @param uuid the uuid of this feedback
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected FeedbackWrapper wrap(Feedback feedback) {
		return new FeedbackWrapper(feedback);
	}

}