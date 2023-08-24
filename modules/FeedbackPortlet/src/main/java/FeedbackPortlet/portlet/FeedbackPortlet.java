package FeedbackPortlet.portlet;

import FeedbackPortlet.constants.FeedbackPortletKeys;
import FeedbackService.model.Feedback;
import FeedbackService.service.FeedbackLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author sinyi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Feedback",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FeedbackPortletKeys.FEEDBACK,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FeedbackPortlet extends MVCPortlet {
	
	public void submitFeedback(ActionRequest request, ActionResponse response) throws PortalException {
		// Retrieve the value of form input data
		String name = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		String subject = ParamUtil.getString(request, "subject");
		String message = ParamUtil.getString(request, "message");

		// Create new Feedback object
		Feedback fb = FeedbackLocalServiceUtil.createFeedback(CounterLocalServiceUtil.increment(Feedback.class.getName()));
		
		// Set the other fields
		fb.setFeedbackName(name);
		fb.setFeedbackEmail(email);
		fb.setFeedbackSubject(subject);
		fb.setFeedbackMessage(message);
		
		// Get the current logged in user data
		if (request.getRemoteUser() != null) {
			User user = UserServiceUtil.getUserById(Long.parseLong(request.getRemoteUser()));
			// Set audit fields
			fb.setUserId(user.getUserId());
			fb.setGroupId(user.getGroupId());
			fb.setUserName(user.getFullName());
		}
		
		// Save to the database
		FeedbackLocalServiceUtil.addFeedback(fb);
	}

}