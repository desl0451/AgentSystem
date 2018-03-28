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
