package org.agent.dao.user;

import java.util.List;

import org.agent.pojo.User;

public interface UserMapper {
	// 查询用户列表
	public List<User> getUserList(User user);

	public User getUser(User user);

	public int addUser(User user);

	public int modifyUser(User user);

	public int deleteUser(User user);

	public int count(User user);

	/**
	 * 查询用户是否存在 >0存在 =0不存在
	 * 
	 * @param user
	 * @return
	 */
	public int isExitLoginUser(User user);

	public User getLoginUser(User user);
}
