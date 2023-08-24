<%@ include file="init.jsp" %>

<h1>
	<liferay-ui:message key="feedback.title"/>
</h1>

<p>
	<liferay-ui:message key="feedback.subtitle"/>
</p>

<portlet:actionURL name="submitFeedback" var="submitFeedbackURL" />

<aui:form action="<%=submitFeedbackURL %>" method="post">
	<div class="row">
		<div class="col-6">
			<!-- Name Field -->
			<aui:input type="text" name="name" label="form.name" />
		</div>
		<div class="col-6">
			<!-- Email Field -->
			<aui:input type="email" name="email" label="form.email" />
		</div>
	</div>

	<!-- Subject Field (Required) -->
	<aui:input type="text" name="subject" label="form.subject">
		<aui:validator name="required" errorMessage="form.validator.subject" />
	</aui:input>

	<!-- Message Field (Required, Max 1000 characters) -->
	<aui:input type="textarea" name="message" label="form.message">
		<aui:validator name="required" errorMessage="form.validator.message" />
	</aui:input>

	<div id="counterContainer"><p><span id="counter"></span> character(s) remaining</p></div>

	<aui:button type="submit" value="form.submit" />
</aui:form>

<aui:script use="aui-char-counter">
AUI().use(
  function(A) {
    new A.CharCounter(
      {
        counter: '#counter',
        input: '#<portlet:namespace />message',
        maxLength: 1000
      }
    );
  }
);
</aui:script> 
