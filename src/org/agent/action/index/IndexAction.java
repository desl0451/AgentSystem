package org.agent.action.index;

import javax.annotation.Resource;

import org.agent.action.BaseAction;
import org.agent.action.LoginAction;
import org.agent.common.MD5;
import org.agent.pojo.User;
import org.agent.service.user.UserService;
import org.apache.log4j.Logger;

public class IndexAction extends BaseAction {
	private Logger logger = Logger.getLogger(LoginAction.class);
	private static final long serialVersionUID = 1140744150590704153L;
	private User user;
	@Resource
	UserService userService;

	public void modifyPwd() {
		// _user:已登录用户.User页面接收的
		String oldpwd = user.getUserPassword();
		String newpwd1 = user.getUserCode();
		String newpwd2 = user.getUserName();
		logger.error("oldpwd =======>" + oldpwd);
		logger.error("newpwd1 =======>" + newpwd1);
		logger.error("newpwd2 =======>" + newpwd2);

		oldpwd = MD5.MD5Encode(oldpwd);

		user.setId(this.getCurrentUser().getId());
		String result = "0";
		if (!newpwd1.equals(newpwd2)) {
			result = "2pwddif";
		} else if (!oldpwd.equals(this.getCurrentUser().getUserPassword())) {
			result = "oldpwddif";
		} else {
			try {
				user.setUserCode(null);
				user.setUserName(null);
				user.setUserPassword(newpwd1);
				user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
				userService.modifyUser(user);
				result = "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = "failed";
			}
		}
		this.getOut().write(result);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
