package org.agent.action;

import java.util.Date;

import javax.annotation.Resource;

import org.agent.common.Constants;
import org.agent.common.MD5;
import org.agent.pojo.User;
import org.agent.service.user.UserService;
import org.apache.log4j.Logger;

public class LoginAction extends BaseAction {

	private Logger logger = Logger.getLogger(LoginAction.class);
	private static final long serialVersionUID = 1140744150590704153L;

	// ����form�����ύ������
	private User user;
	@Resource
	UserService userService;

	public String login() {
		if (user != null) {
			// ������ܵĴ���
			user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
			User _user = userService.getLoginUser(user);

			if (_user != null) {
				this.getRequest().getSession().setAttribute(Constants.SESSION_USER, _user);// ����Session
				_user.setLastLoginTime(new Date());// ��ȡϵͳʱ��
				userService.modifyUser(_user);// �����û�״̬
				return SUCCESS;
			} else {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.getOut().write(flag);
		//this.closeOut(this.getOut());
		return null;
	}

	public String main() {
		return SUCCESS;
	}

	public void modifyPwd() {
		// _user:�ѵ�¼�û�.Userҳ����յ�
		User _user = (User) this.getRequest().getSession().getAttribute(Constants.SESSION_USER);
		if (MD5.MD5Encode(user.getUserName()).equals(_user.getUserName())) {
			_user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
			if (this.getUserService().modifyUser(_user) > 0) {
				this.getOut().println("success");
				this.getOut().flush();
				this.getOut().close();
			}
		}
	}

	/**
	 * �˳�
	 * 
	 * @return
	 */
	public String exit() {
		try {
			User user = (User) getRequest().getSession().getAttribute(Constants.SESSION_USER);
			if (user != null && user.getId() > 0) {
				getRequest().getSession().invalidate();
				getRequest().getSession().removeAttribute(Constants.SESSION_USER);
				logger.error("User logout : " + user.getUserCode() + " - " + user.getUserName());
				user = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

}