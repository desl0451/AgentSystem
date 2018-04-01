package org.agent.pojo;

import java.util.Date;

public class Logs extends Base {
	private Integer userId;
	private String userName;
	private String operateInfo;
	private Date operateDatetime;
	private String odt;//yyyy-MM-dd
	public String getOdt() {
		return odt;
	}

	public void setOdt(String odt) {
		this.odt = odt;
	}

	public Logs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logs(Integer userId, String userName, String operateInfo, Date operateDatetime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.operateInfo = operateInfo;
		this.operateDatetime = operateDatetime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperateInfo() {
		return operateInfo;
	}

	public void setOperateInfo(String operateInfo) {
		this.operateInfo = operateInfo;
	}

	public Date getOperateDatetime() {
		return operateDatetime;
	}

	public void setOperateDatetime(Date operateDatetime) {
		this.operateDatetime = operateDatetime;
	}
}
