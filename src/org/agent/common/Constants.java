package org.agent.common;

import java.util.ArrayList;
import java.util.List;

import org.agent.pojo.SystemConfig;
import org.springframework.context.ApplicationContext;

public class Constants {
	public static final String SESSION_USER="userSession";
	public static ApplicationContext cxt;
	
	/***************用户操作信息-开始*****************/
	public static String OPERATE_INFO_USER_LOGIN_SUCCESS = "用户进行登录操作成功";
	public static String OPERATE_INFO_USER_LOGIN_FAILD = "用户进行登录操作失败";
	public static String OPERATE_INFO_USER_LOGOUT_SUCCESS = "用户注销账号操作成功";
	public static String OPERATE_INFO_USER_MODIFY_PASSWORD = "用户进行修改密码操作";
	public static String OPERATE_INFO_USER_ACCESS_ACCOUNTDETAIL = "用户进行账户明细查询";
	public static String OPERATE_INFO_USER_lIST_SEARCH = "用户进行代理商用户查询";
	public static String OPERATE_INFO_USER_LOGLIST_SEARCH = "用户进行操作日志查询";
	
	
	/********************* 系统配置项 *********************/
	public static List<SystemConfig> systemConfigList;

	/**
	 * 账务类型1
	 */
	public static List<SystemConfig> accountConfigList = new ArrayList<SystemConfig>();

	// 服务类型2
	public static List<SystemConfig> serviceConfigList = new ArrayList<SystemConfig>();
	// 服务年限3
	public static SystemConfig maxServiceYearsConfig;
	// APP地址4
	public static SystemConfig appMakeUrlConfig;
	// 客户类型5
	public static List<SystemConfig> customTypeConfigList = new ArrayList<SystemConfig>();
	// 证件类型6
	public static List<SystemConfig> cardTypeConfigList = new ArrayList<SystemConfig>();
	// 优惠类型7
	public static List<SystemConfig> youhuiConfigList = new ArrayList<SystemConfig>();

	// 遍历所有配置项 ,并按不同配置类型归类
	public static void configSystemData() {
		// 防止重复添加
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
