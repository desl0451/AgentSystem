package org.agent.dao.role;

import java.util.List;

import org.agent.pojo.Role;

public interface RoleMapper {
	/**
	 * 查询所有的角色
	 */
	public List<Role> getRoleList();

	/**
	 * 查询单个角色
	 * 
	 * @param role
	 * @return
	 */
	public Role getRole(Role role);

	/**
	 * 添加
	 * 
	 * @param role
	 * @return
	 */
	public int addRole(Role role);

	/**
	 * 修改
	 * 
	 * @param role
	 * @return
	 */
	public int modifyRole(Role role);

	/**
	 * 删除
	 * 
	 * @param role
	 * @return
	 */
	public int deleteRole(Role role);
	/**
	 * 仅查询ID和Name
	 * @return
	 */
	public List<Role> getRoleIdAndRnameList();
}
