package org.agent.service.systemconfig;

import java.util.List;

import org.agent.pojo.SystemConfig;

public interface SystemConfigService {
	/**
	 * 查询配置项
	 * 
	 * @param systemConfig
	 * @return
	 */
	public List<SystemConfig> getSystemConfigs(SystemConfig systemConfig);

	/**
	 * 查询已启用的配置项
	 * 
	 * @param systemConfig
	 * @return
	 */
	public List<SystemConfig> getSystemConfigIsStart(SystemConfig systemConfig);

	public int addSystemConfig(SystemConfig systemConfig);

	public int modifySystemConfig(SystemConfig systemConfig);

	public int isPeatConfig(SystemConfig systemConfig);

	public int deleteSystemConfig(SystemConfig systemConfig);

	/**
	 * 一级编号固定时,最大的二级编号
	 * 
	 * @param type
	 * @return
	 */
	public int maxTypeValueByType(int type);
}
