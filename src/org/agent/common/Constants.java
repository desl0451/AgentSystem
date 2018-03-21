package org.agent.common;

import java.util.ArrayList;
import java.util.List;

import org.agent.pojo.SystemConfig;
import org.springframework.context.ApplicationContext;

public class Constants {
	public static final String SESSION_USER="userSession";
	public static ApplicationContext cxt;
	
	/***************�û�������Ϣ-��ʼ*****************/
	public static String OPERATE_INFO_USER_LOGIN_SUCCESS = "�û����е�¼�����ɹ�";
	public static String OPERATE_INFO_USER_LOGIN_FAILD = "�û����е�¼����ʧ��";
	public static String OPERATE_INFO_USER_LOGOUT_SUCCESS = "�û�ע���˺Ų����ɹ�";
	public static String OPERATE_INFO_USER_MODIFY_PASSWORD = "�û������޸��������";
	public static String OPERATE_INFO_USER_ACCESS_ACCOUNTDETAIL = "�û������˻���ϸ��ѯ";
	public static String OPERATE_INFO_USER_lIST_SEARCH = "�û����д������û���ѯ";
	public static String OPERATE_INFO_USER_LOGLIST_SEARCH = "�û����в�����־��ѯ";
	
	
	/********************* ϵͳ������ *********************/
	public static List<SystemConfig> systemConfigList;

	/**
	 * ��������1
	 */
	public static List<SystemConfig> accountConfigList = new ArrayList<SystemConfig>();

	// ��������2
	public static List<SystemConfig> serviceConfigList = new ArrayList<SystemConfig>();
	// ��������3
	public static SystemConfig maxServiceYearsConfig;
	// APP��ַ4
	public static SystemConfig appMakeUrlConfig;
	// �ͻ�����5
	public static List<SystemConfig> customTypeConfigList = new ArrayList<SystemConfig>();
	// ֤������6
	public static List<SystemConfig> cardTypeConfigList = new ArrayList<SystemConfig>();
	// �Ż�����7
	public static List<SystemConfig> youhuiConfigList = new ArrayList<SystemConfig>();

	// �������������� ,������ͬ�������͹���
	public static void configSystemData() {
		// ��ֹ�ظ����
		accountConfigList.clear();
		serviceConfigList.clear();
		customTypeConfigList.clear();
		cardTypeConfigList.clear();
		youhuiConfigList.clear();
		for (SystemConfig config : systemConfigList) {
			switch (config.getConfigType()) {
			case 1:
				accountConfigList.add(config);
				break;
			case 2:
				serviceConfigList.add(config);
				break;
			case 3:
				maxServiceYearsConfig = config;
				break;
			case 4:
				appMakeUrlConfig = config;
				break;
			case 5:
				customTypeConfigList.add(config);
				break;
			case 6:
				cardTypeConfigList.add(config);
				break;
			case 7:
				youhuiConfigList.add(config);
				break;
			default:
				break;
			}
		}
	}
}
