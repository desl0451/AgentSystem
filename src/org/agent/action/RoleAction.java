package org.agent.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.agent.pojo.Role;
import org.agent.service.role.RoleService;
import org.apache.log4j.Logger;

public class RoleAction extends BaseAction {
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

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	// 查询所有角色
	public String roleList() {
		this.roleList = this.getRoleService().getRoleList();
		return SUCCESS;
	}

	public void editRole() {
		if (type.equals("add")) {
			// role.setCreatedBy(this.getRequest().getSession().getAttribute(Constants.SESSION_USER));
			// System.out.println(this.getCurrentUser().getRoleName()+"###########"+this.getCurrentUser().getUserCode());
			role.setCreatedBy(this.getCurrentUser().getUserCode());
			role.setCreationTime(new Date());
			this.getRoleService().addRole(role);
			this.getOut().print("success");
		} else if (type.equals("modify")) {
			role.setLastUpdateTime(new Date());
			this.getRoleService().modifyRole(role);
			this.getOut().print("success");
		}
	}

	public void deleteRole() {
		if (this.getRoleService().deleteRole(role) > 0) {
			this.getOut().print("success");
		}

	}
}
