package org.agent.interceptor;

import org.agent.common.Constants;
import org.agent.pojo.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		User user = (User) ai.getInvocationContext().getSession().get(Constants.SESSION_USER);
		if (user != null && user.getUserCode() != null && user.getUserPassword() != null && user.getIsStart() == 1) {
			ai.invoke();
		}

		return null;
	}

}
