package org.agent.service.permission;

import java.util.List;

import org.agent.dao.permission.PermissionMapper;
import org.agent.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;

	/**
	 * 添加一个权限,先删除再添加,保证权限的唯一，避免冗余
	 */
	@Override
	public void tx_delAddPermission(Permission pm, String checkList) {

		// 1.组合所有角色和功能的映射Permission
		String[] funcList = checkList.split(",");

		// 2.删除角色信息
		permissionMapper.deletePermission(pm);

		// 2.保存(删除再添加)
		if (null != funcList && !funcList.equals("")) {
			for (int i = 0; i < funcList.length; i++) {
				pm.setFunctionId(Integer.valueOf(funcList[i]));
				permissionMapper.addPermission(pm);
			}
		}
	}

	public PermissionMapper getPermissionMapper() {
		return permissionMapper;
	}

	public void setPermissionMapper(PermissionMapper permissionMapper) {
		this.permissionMapper = permissionMapper;
	}

	@Override
	public List<Permission> getList(Permission permission) {
		// TODO Auto-generated method stub
		return permissionMapper.getList(permission);
	}

	@Override
	public int addPermission(Permission permission) {
		// TODO Auto-generated method stub
		return permissionMapper.addPermission(permission);
	}

	@Override
	public int modifyPermission(Permission permission) {
		// TODO Auto-generated method stub
		return permissionMapper.modifyPermission(permission);
	}

	@Override
	public int deletePermission(Permission permission) {
		// TODO Auto-generated method stub
		return permissionMapper.deletePermission(permission);
	}

}
