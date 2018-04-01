package org.agent.service.user;

import java.util.List;

import org.agent.pojo.User;

public interface UserService {
	public List<User> getUserList(User user);

	public User getUser(User user);

	public int addUser(User user);

	public int modifyUser(User user);

	public int deleteUser(User user);

	public int count(User user);

	public int isExitLoginUser(User user);

	public User getLoginUser(User user);
	
	/**
	 * 需要事务处理的添加
	 */
	public void tx_AddUser(User user);
}
