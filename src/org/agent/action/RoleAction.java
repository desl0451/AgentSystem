package org.agent.action;

import java.util.List;

import javax.annotation.Resource;

import org.agent.common.Constants;
import org.agent.pojo.Role;
import org.agent.service.role.RoleService;
import org.agent.service.user.UserService;
import org.apache.log4j.Logger;

public class RoleAction extends BaseAction {
	private Logger logger = Logger.getLogger(RoleAction.class);
	private static final long serialVersionUID = -6755381166484867033L;
	
	@Resource
	RoleService roleService;
	private Role role;
	private List<Role> roleList;
	private String type;// 新增add|修改modify

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// 查询所有角色
	public String roleList() {
		this.roleList= this.getRoleService().getRoleList();
		logger.debug(roleList.size()+"############");
		return SUCCESS;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String edit() {
		if (type.equals("add")) {

		} else if (type.equals("modify")) {

		}
		return this.SUCCESS;
	}

	public String deleteRole() {
		return this.SUCCESS;
	}
}
