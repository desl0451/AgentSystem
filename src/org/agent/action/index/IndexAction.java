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
	private User u;
	@Resource
	UserService userService;

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public void modifyPwd() {
		// _user:已登录用户.User页面接收的
		String oldpwd = u.getUserPassword();
		String newpwd1 = u.getUserCode();
		String newpwd2 = u.getUserName();
		logger.error("oldpwd =======>" + oldpwd);
		logger.error("newpwd1 =======>" + newpwd1);
		logger.error("newpwd2 =======>" + newpwd2);

		oldpwd = MD5.MD5Encode(oldpwd);

		u.setId(this.getCurrentUser().getId());
		String result = "0";
		if (!newpwd1.equals(newpwd2)) {
			result = "2pwddif";
		} else if (!oldpwd.equals(this.getCurrentUser().getUserPassword())) {
			result = "oldpwddif";
		} else {
			try {
				u.setUserCode(null);
				u.setUserName(null);
				u.setUserPassword(newpwd1);
				u.setUserPassword(MD5.MD5Encode(u.getUserPassword()));
				userService.modifyUser(u);
				result = "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = "failed";
			}
		}
		this.getOut().write(result);
	}
}
