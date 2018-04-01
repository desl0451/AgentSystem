package org.agent.action;

import java.util.Date;
import java.util.List;

import org.agent.common.MD5;
import org.agent.common.SQLTools;
import org.agent.pojo.Role;
import org.agent.pojo.User;
import org.agent.service.role.RoleService;
import org.agent.service.user.UserService;
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

		this.userList = this.getUserService().getUserList(user); // 读取用户集合
		this.roleList = this.getRoleService().getRoleIdAndNameList(); // 读取角色集合
		return Action.SUCCESS;
	}

	/**
	 * 添加修改方法
	 * 
	 * @return
	 */
	public void editUser() {
		String flag = "failed";
		if (user != null && user.getUserCode() != null && user.getUserCode() != "" && user.getUserName() != null
				&& user.getUserName() != "" && user.getUserPassword() != null && user.getUserPassword() != "")
			if (type.equals("add")) {
				user.setCreatedBy(this.getCurrentUser().getUserCode());
				user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
				user.setCreationTime(new Date());
				this.getUserService().addUser(user);
				this.getOut().print("success");
			} else if (type.equals("modify")) {
				user.setLastUpdateTime(new Date());
				this.getUserService().modifyUser(user);
				this.getOut().print("success");
			}

	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public void deleteUser() {
		if (this.getUserService().deleteUser(user) > 0) {
			this.getOut().print("success");
		}

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
