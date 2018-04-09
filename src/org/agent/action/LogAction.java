package org.agent.action;

import java.text.SimpleDateFormat;
import java.util.List;

import org.agent.pojo.Logs;
import org.agent.pojo.User;

public class LogAction extends BaseAction {
	private Logs logs;
	private List<Logs> logsList;
	private User user;

	public Logs getLogs() {
		return logs;
	}

	public void setLogs(Logs logs) {
		this.logs = logs;
	}

	public List<Logs> getLogsList() {
		return logsList;
	}

	public void setLogsList(List<Logs> logsList) {
		this.logsList = logsList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 查询用户日志
	 * 
	 * @return
	 */
	public String logsList() {
		if (logs == null) {
			logs = new Logs();
		}
		logs.setUserId(user.getId());
		logs.setUserName(user.getUserCode());
		if (logs.getOperateDatetime() != null) {
			String odt = new SimpleDateFormat("yyyy-MM-dd").format(logs.getOperateDatetime());
			logs.setOdt(odt);
		}
		this.logsList = this.getLogsService().getList(logs);
		return SUCCESS;
	}
}
