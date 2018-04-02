package org.agent.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.agent.common.Constants;
import org.agent.pojo.Logs;
import org.agent.pojo.User;
import org.agent.service.logs.LogsService;
import org.agent.service.user.UserService;
import org.apache.struts2.ServletActionContext;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 504925248799037852L;
	private UserService userService;
	private User currentUser;
	private String actionMessage;
	private PrintWriter out;
	@Resource
	private LogsService logsService;

	//¼ÇÂ¼ÈÕÖ¾
	public void setLog(User user, String operateInfo) {
		Logs logs = new Logs();
		logs.setUserId(user.getId());
		logs.setUserName(user.getUserCode());
		logs.setOperateInfo(operateInfo);
		logs.setOperateDatetime(new Date());
		this.logsService.addLogs(logs);
	}

	public LogsService getLogsService() {
		return logsService;
	}

	public void setLogsService(LogsService logsService) {
		this.logsService = logsService;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public BaseAction() {
		this.setCurrentUser((User) this.getRequest().getSession().getAttribute(Constants.SESSION_USER));
		this.getResponse().setCharacterEncoding("utf-8");
		try {
			this.out = this.getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void closeOut(PrintWriter out) {
		if (null != out) {
			out.close();
			out = null;
		}
	}
}
