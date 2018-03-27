package org.agent.pojo;

import java.util.Date;

public class Function extends Base {
	private String functionCode;
	private String functionName;
	private Date creationTime;
	private String createBy;
	private Date lastUpdateTime;
	private String funUrl;
	private Integer isStart;
	private Integer parentId;

	public Function(String functionCode, String functionName, Date creationTime, String createBy, Date lastUpdateTime,
			String funUrl, Integer isStart, Integer parentId) {
		super();
		this.functionCode = functionCode;
		this.functionName = functionName;
		this.creationTime = creationTime;
		this.createBy = createBy;
		this.lastUpdateTime = lastUpdateTime;
		this.funUrl = funUrl;
		this.isStart = isStart;
		this.parentId = parentId;
	}

	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getFunUrl() {
		return funUrl;
	}

	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	public Integer getIsStart() {
		return isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
