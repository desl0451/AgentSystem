package org.agent.pojo;

public class SystemConfig extends Base {

	private Integer configType; // 一级编号
	private String configTypeName;// 配置项名称
	private Integer configTypeValue;// 二级编号
	private String configValue;// 配置项的值
	private Integer isStart;

	public Integer getConfigType() {
		return configType;
	}

	public void setConfigType(Integer configType) {
		this.configType = configType;
	}

	public String getConfigTypeName() {
		return configTypeName;
	}

	public void setConfigTypeName(String configTypeName) {
		this.configTypeName = configTypeName;
	}

	public Integer getConfigTypeValue() {
		return configTypeValue;
	}

	public void setConfigTypeValue(Integer configTypeValue) {
		this.configTypeValue = configTypeValue;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public Integer getIsStart() {
		return isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

}
