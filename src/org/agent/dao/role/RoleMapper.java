package org.agent.dao.role;

import java.util.List;

import org.agent.pojo.Role;

public interface RoleMapper {
	/**
	 * ��ѯ���еĽ�ɫ
	 */
	public List<Role> getRoleList();

	/**
	 * ��ѯ������ɫ
	 * 
	 * @param role
	 * @return
	 */
	public Role getRole(Role role);

	/**
	 * ���
	 * 
	 * @param role
	 * @return
	 */
	public int addRole(Role role);

	/**
	 * �޸�
	 * 
	 * @param role
	 * @return
	 */
	public int modifyRole(Role role);

	/**
	 * ɾ��
	 * 
	 * @param role
	 * @return
	 */
	public int deleteRole(Role role);
	/**
	 * ����ѯID��Name
	 * @return
	 */
	public List<Role> getRoleIdAndRnameList();
}
