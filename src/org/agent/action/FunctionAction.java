package org.agent.action;

import java.util.List;

import org.agent.pojo.Function;
import org.agent.pojo.Role;
import org.agent.service.function.FunctionService;
import org.agent.service.role.RoleService;

import com.opensymphony.xwork2.Action;

public class FunctionAction extends BaseAction {
	private static final long serialVersionUID = -4645807998094946801L;
	private FunctionService functionService;
	private List<Function> functionList;
	private RoleService roleService;
	private List<Role> roleList;

	public String roleList() {
		// 获得所有角色
		this.roleList = this.roleService.getRoleIdAndRnameList();
		return Action.SUCCESS;
	}

	public String functionList() {
		this.functionList = this.functionService.getFunctionList();
		return Action.SUCCESS;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<Function> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(List<Function> functionList) {
		this.functionList = functionList;
	}

	public FunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
}
