package org.agent.action;

import java.util.Date;
import java.util.List;

import org.agent.pojo.Function;
import org.agent.pojo.Permission;
import org.agent.pojo.Role;
import org.agent.service.function.FunctionService;
import org.agent.service.permission.PermissionService;
import org.agent.service.role.RoleService;

import com.opensymphony.xwork2.Action;

public class FunctionAction extends BaseAction {
	private static final long serialVersionUID = -4645807998094946801L;
	private FunctionService functionService;
	private List<Function> functionList;
	private RoleService roleService;
	private List<Role> roleList;
	private PermissionService permissionService;
	/**
	 * Ȩ�ޱ��
	 */
	private Integer roleId;
	private String checkList;

	public String getCheckList() {
		return checkList;
	}

	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}

	/**
	 * ������н�ɫ
	 * 
	 * @return
	 */
	public String roleList() {
		// ������н�ɫ
		this.roleList = this.roleService.getRoleIdAndNameList();
		return Action.SUCCESS;
	}

	public String functionList() {
		try {
			functionList = functionService.getFunctionList();
			Permission pm = new Permission();
			pm.setRoleId(this.getRoleId());
			pm.setIsStart(1);
			List<Permission> pList = permissionService.getList(pm);
			if (pList != null) {
				for (Permission p : pList)
					for (Function f : functionList) {
						if (p.getFunctionId() == f.getId())
							f.setIsCheck(true);
					}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void saveRoleFunc() {
		// ����ҵ�����������ɫ �͹��ܵ�ӳ��
		// 1.������н�ɫ�͹��ܵ�ӳ��
		Permission pm = new Permission();
		pm.setRoleId(roleId);
		pm.setCreatedBy(this.getCurrentUser().getUserCode());
		pm.setCreationTime(new Date());
		pm.setIsStart(1);
		// 2.����
		permissionService.tx_delAddPermission(pm, this.getCheckList());
		this.getOut().print("success");
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public Integer getRoleId() {
		return roleId;
	}

}
