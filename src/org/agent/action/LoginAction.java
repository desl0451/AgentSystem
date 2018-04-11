package org.agent.action;

import java.util.Date;

import javax.annotation.Resource;

import org.agent.common.Constants;
import org.agent.common.MD5;
import org.agent.pojo.User;
import org.agent.service.user.UserService;
import org.apache.log4j.Logger;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1140744150590704153L;

	// 接收form表单提交的数据
	private User user;

	@Resource
	UserService userService;

	public String login() {
		if (user != null) {
			// 密码加密的处理
			user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
			User _user = userService.getLoginUser(user);
			System.out.println(_user.getId()+"================");
			if (_user != null) {
				this.getRequest().getSession().setAttribute(Constants.SESSION_USER, _user);// 保存Session
				_user.setLastLoginTime(new Date());// 提取系统时间
				userService.modifyUser(_user);// 更新用户状态
				this.setLog(_user, Constants.OPERATE_INFO_USER_LOGIN_SUCCESS);
				return SUCCESS;
			} else {
				this.setLog(_user, Constants.OPERATE_INFO_USER_LOGIN_FAILD);
				return INPUT;
			}
		} else {
			return INPUT;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String validateLoginUser() {
		String flag = "failed";
		if (null != user && !"".equals(user.getUserCode())) {
			try {
				user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
				if (userService.isExitLoginUser(user) == 0) {
					flag = "noexitusercode";
				} else if (userService.getLoginUser(user) == null) {
					flag = "errorpwd";
				} else {
					flag = "success";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.getOut().write(flag);
		// this.closeOut(this.getOut());
		return null;
	}

	public String main() {
		return SUCCESS;
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	public String exit() {
		try {
			User user = (User) getRequest().getSession().getAttribute(Constants.SESSION_USER);
			if (user != null && user.getId() > 0) {
				getRequest().getSession().invalidate();
				getRequest().getSession().removeAttribute(Constants.SESSION_USER);
				user = null;
			}
			setLog(user, Constants.OPERATE_INFO_USER_LOGIN_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
