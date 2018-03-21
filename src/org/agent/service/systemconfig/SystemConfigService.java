package org.agent.service.systemconfig;

import java.util.List;

import org.agent.pojo.SystemConfig;

public interface SystemConfigService {
	/**
	 * ��ѯ������
	 * 
	 * @param systemConfig
	 * @return
	 */
	public List<SystemConfig> getSystemConfigs(SystemConfig systemConfig);

	/**
	 * ��ѯ�����õ�������
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
	 * һ����Ź̶�ʱ,���Ķ������
	 * 
	 * @param type
	 * @return
	 */
	public int maxTypeValueByType(int type);
}
