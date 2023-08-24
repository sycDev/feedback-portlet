<%@ include file="init.jsp" %>

<!--  Using Render URL -->
<portlet:renderURL var="feedbackForm">
	<portlet:param name="jspPage" value="/feedback.jsp"/>
</portlet:renderURL>

<a class="btn btn-primary" href="${feedbackForm}" role="button">Add New Feedback</a>

<!-- Display Feedback Records -->
<liferay-ui:search-container total="<%= FeedbackLocalServiceUtil.getFeedbacksCount() %>">
	<liferay-ui:search-container-results
		results="<%= FeedbackLocalServiceUtil.getFeedbacks(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="FeedbackService.model.Feedback"
		modelVar="aFeedback"
	>
		<liferay-ui:search-container-column-text property="feedbackSubject" name="Subject" />
		<liferay-ui:search-container-column-text property="feedbackMessage" name="Message" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>