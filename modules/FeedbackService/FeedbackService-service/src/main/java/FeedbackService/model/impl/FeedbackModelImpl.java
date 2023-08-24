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
import FeedbackService.model.FeedbackModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Feedback service. Represents a row in the &quot;FB_Feedback&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FeedbackModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FeedbackImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackImpl
 * @generated
 */
public class FeedbackModelImpl
	extends BaseModelImpl<Feedback> implements FeedbackModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a feedback model instance should use the <code>Feedback</code> interface instead.
	 */
	public static final String TABLE_NAME = "FB_Feedback";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"feedbackId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"feedbackName", Types.VARCHAR}, {"feedbackEmail", Types.VARCHAR},
		{"feedbackSubject", Types.VARCHAR}, {"feedbackMessage", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("feedbackId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("feedbackName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("feedbackEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("feedbackSubject", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("feedbackMessage", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FB_Feedback (uuid_ VARCHAR(75) null,feedbackId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,feedbackName VARCHAR(75) null,feedbackEmail VARCHAR(75) null,feedbackSubject VARCHAR(75) null,feedbackMessage STRING null)";

	public static final String TABLE_SQL_DROP = "drop table FB_Feedback";

	public static final String ORDER_BY_JPQL =
		" ORDER BY feedback.feedbackId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY FB_Feedback.feedbackId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FEEDBACKMESSAGE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FEEDBACKID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public FeedbackModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFeedbackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Feedback, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Feedback, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Feedback, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Feedback)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Feedback, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Feedback, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Feedback)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Feedback, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Feedback, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Feedback, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Feedback, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Feedback, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Feedback, Object>>();
		Map<String, BiConsumer<Feedback, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Feedback, ?>>();

		attributeGetterFunctions.put("uuid", Feedback::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Feedback, String>)Feedback::setUuid);
		attributeGetterFunctions.put("feedbackId", Feedback::getFeedbackId);
		attributeSetterBiConsumers.put(
			"feedbackId", (BiConsumer<Feedback, Long>)Feedback::setFeedbackId);
		attributeGetterFunctions.put("groupId", Feedback::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Feedback, Long>)Feedback::setGroupId);
		attributeGetterFunctions.put("companyId", Feedback::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Feedback, Long>)Feedback::setCompanyId);
		attributeGetterFunctions.put("userId", Feedback::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Feedback, Long>)Feedback::setUserId);
		attributeGetterFunctions.put("userName", Feedback::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Feedback, String>)Feedback::setUserName);
		attributeGetterFunctions.put("createDate", Feedback::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Feedback, Date>)Feedback::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Feedback::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Feedback, Date>)Feedback::setModifiedDate);
		attributeGetterFunctions.put("feedbackName", Feedback::getFeedbackName);
		attributeSetterBiConsumers.put(
			"feedbackName",
			(BiConsumer<Feedback, String>)Feedback::setFeedbackName);
		attributeGetterFunctions.put(
			"feedbackEmail", Feedback::getFeedbackEmail);
		attributeSetterBiConsumers.put(
			"feedbackEmail",
			(BiConsumer<Feedback, String>)Feedback::setFeedbackEmail);
		attributeGetterFunctions.put(
			"feedbackSubject", Feedback::getFeedbackSubject);
		attributeSetterBiConsumers.put(
			"feedbackSubject",
			(BiConsumer<Feedback, String>)Feedback::setFeedbackSubject);
		attributeGetterFunctions.put(
			"feedbackMessage", Feedback::getFeedbackMessage);
		attributeSetterBiConsumers.put(
			"feedbackMessage",
			(BiConsumer<Feedback, String>)Feedback::setFeedbackMessage);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(long feedbackId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_feedbackId = feedbackId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getFeedbackName() {
		if (_feedbackName == null) {
			return "";
		}
		else {
			return _feedbackName;
		}
	}

	@Override
	public void setFeedbackName(String feedbackName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_feedbackName = feedbackName;
	}

	@Override
	public String getFeedbackEmail() {
		if (_feedbackEmail == null) {
			return "";
		}
		else {
			return _feedbackEmail;
		}
	}

	@Override
	public void setFeedbackEmail(String feedbackEmail) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_feedbackEmail = feedbackEmail;
	}

	@Override
	public String getFeedbackSubject() {
		if (_feedbackSubject == null) {
			return "";
		}
		else {
			return _feedbackSubject;
		}
	}

	@Override
	public void setFeedbackSubject(String feedbackSubject) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_feedbackSubject = feedbackSubject;
	}

	@Override
	public String getFeedbackMessage() {
		if (_feedbackMessage == null) {
			return "";
		}
		else {
			return _feedbackMessage;
		}
	}

	@Override
	public void setFeedbackMessage(String feedbackMessage) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_feedbackMessage = feedbackMessage;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFeedbackMessage() {
		return getColumnOriginalValue("feedbackMessage");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Feedback.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Feedback.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Feedback toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Feedback>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setUuid(getUuid());
		feedbackImpl.setFeedbackId(getFeedbackId());
		feedbackImpl.setGroupId(getGroupId());
		feedbackImpl.setCompanyId(getCompanyId());
		feedbackImpl.setUserId(getUserId());
		feedbackImpl.setUserName(getUserName());
		feedbackImpl.setCreateDate(getCreateDate());
		feedbackImpl.setModifiedDate(getModifiedDate());
		feedbackImpl.setFeedbackName(getFeedbackName());
		feedbackImpl.setFeedbackEmail(getFeedbackEmail());
		feedbackImpl.setFeedbackSubject(getFeedbackSubject());
		feedbackImpl.setFeedbackMessage(getFeedbackMessage());

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public Feedback cloneWithOriginalValues() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		feedbackImpl.setFeedbackId(
			this.<Long>getColumnOriginalValue("feedbackId"));
		feedbackImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		feedbackImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		feedbackImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		feedbackImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		feedbackImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		feedbackImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		feedbackImpl.setFeedbackName(
			this.<String>getColumnOriginalValue("feedbackName"));
		feedbackImpl.setFeedbackEmail(
			this.<String>getColumnOriginalValue("feedbackEmail"));
		feedbackImpl.setFeedbackSubject(
			this.<String>getColumnOriginalValue("feedbackSubject"));
		feedbackImpl.setFeedbackMessage(
			this.<String>getColumnOriginalValue("feedbackMessage"));

		return feedbackImpl;
	}

	@Override
	public int compareTo(Feedback feedback) {
		int value = 0;

		if (getFeedbackId() < feedback.getFeedbackId()) {
			value = -1;
		}
		else if (getFeedbackId() > feedback.getFeedbackId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Feedback)) {
			return false;
		}

		Feedback feedback = (Feedback)object;

		long primaryKey = feedback.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Feedback> toCacheModel() {
		FeedbackCacheModel feedbackCacheModel = new FeedbackCacheModel();

		feedbackCacheModel.uuid = getUuid();

		String uuid = feedbackCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			feedbackCacheModel.uuid = null;
		}

		feedbackCacheModel.feedbackId = getFeedbackId();

		feedbackCacheModel.groupId = getGroupId();

		feedbackCacheModel.companyId = getCompanyId();

		feedbackCacheModel.userId = getUserId();

		feedbackCacheModel.userName = getUserName();

		String userName = feedbackCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			feedbackCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			feedbackCacheModel.createDate = createDate.getTime();
		}
		else {
			feedbackCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			feedbackCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			feedbackCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		feedbackCacheModel.feedbackName = getFeedbackName();

		String feedbackName = feedbackCacheModel.feedbackName;

		if ((feedbackName != null) && (feedbackName.length() == 0)) {
			feedbackCacheModel.feedbackName = null;
		}

		feedbackCacheModel.feedbackEmail = getFeedbackEmail();

		String feedbackEmail = feedbackCacheModel.feedbackEmail;

		if ((feedbackEmail != null) && (feedbackEmail.length() == 0)) {
			feedbackCacheModel.feedbackEmail = null;
		}

		feedbackCacheModel.feedbackSubject = getFeedbackSubject();

		String feedbackSubject = feedbackCacheModel.feedbackSubject;

		if ((feedbackSubject != null) && (feedbackSubject.length() == 0)) {
			feedbackCacheModel.feedbackSubject = null;
		}

		feedbackCacheModel.feedbackMessage = getFeedbackMessage();

		String feedbackMessage = feedbackCacheModel.feedbackMessage;

		if ((feedbackMessage != null) && (feedbackMessage.length() == 0)) {
			feedbackCacheModel.feedbackMessage = null;
		}

		return feedbackCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Feedback, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Feedback, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Feedback, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Feedback)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Feedback, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Feedback, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Feedback, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Feedback)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Feedback>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Feedback.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _feedbackId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _feedbackName;
	private String _feedbackEmail;
	private String _feedbackSubject;
	private String _feedbackMessage;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Feedback, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Feedback)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("feedbackId", _feedbackId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("feedbackName", _feedbackName);
		_columnOriginalValues.put("feedbackEmail", _feedbackEmail);
		_columnOriginalValues.put("feedbackSubject", _feedbackSubject);
		_columnOriginalValues.put("feedbackMessage", _feedbackMessage);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("feedbackId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("feedbackName", 256L);

		columnBitmasks.put("feedbackEmail", 512L);

		columnBitmasks.put("feedbackSubject", 1024L);

		columnBitmasks.put("feedbackMessage", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Feedback _escapedModel;

}