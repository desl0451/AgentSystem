package org.agent.action;

import java.util.List;

import org.agent.common.MD5;
import org.agent.common.SQLTools;
import org.agent.pojo.Role;
import org.agent.pojo.User;
import org.agent.service.role.RoleService;
import org.agent.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	private User user;
	private String type;
	private RoleService roleService;
	private List<Role> roleList;

	private List<User> userList;

	/**
	 * 检查用户列表
	 * 
	 * @return
	 */
	public String userList() {
		if (user == null)
			user = new User();
		// 检测关键字
		if (user.getUserName() != null)
			user.setUserName(SQLTools.transfer(user.getUserName()));

		this.userList = this.getUserService().getUserList(user);
		this.roleList = this.getRoleService().getRoleIdAndNameList();
		return Action.SUCCESS;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
