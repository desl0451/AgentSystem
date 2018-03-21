package org.agent.systeminit;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.agent.common.Constants;
import org.agent.pojo.SystemConfig;
import org.agent.service.systemconfig.SystemConfigService;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SystemInit implements ServletContextListener {
	private Logger logger = Logger.getLogger(SystemInit.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		// 1.拿到ICO容器WebApplicationContext
		System.out.println("####################初始化Spring Web WebApplicationContext开始########################");

		System.out.println("####################初始化Spring Web WebApplicationContext结束########################");
		// 2.拿到systemconfigService
		Constants.cxt = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		if (null == Constants.cxt)
			System.out.println("WebApplicationContext Init failed.");
		System.out.println("初始化Spring WebApplicationContext完成");

		if (null != Constants.cxt) {
			System.out.println("初始化配置项开始");
			SystemConfigService systemConfigService = (SystemConfigService) Constants.cxt
					.getBean("systemConfigService");

			try {
				SystemConfig systemConfig = new SystemConfig();
				systemConfig.setIsStart(1);
				Constants.systemConfigList = systemConfigService.getSystemConfigIsStart(systemConfig);

				Constants.configSystemData();
				logger.error("------------>" + Constants.accountConfigList.size());
				logger.error("------------>" + Constants.serviceConfigList.size());
				logger.error("------------>" + Constants.maxServiceYearsConfig.getConfigValue());
				logger.error("------------>" + Constants.appMakeUrlConfig.getConfigValue());
				logger.error("------------>" + Constants.customTypeConfigList.size());
				logger.error("------------>" + Constants.cardTypeConfigList.size());
				System.out.println("初始化结束");
				// init menu
				// List<Role> roleList = roleService.getRoleIdAndNameList();
				// List<Function> menuFunctionList =
				// functionService.getMenuFunction();
				// List<Function> fList;
				// ArrayList<RoleFunctions> roleFunctionsList;
				//
				// for (Role role : roleList) {
				// fList = new ArrayList<Function>();
				// roleFunctionsList = new ArrayList<RoleFunctions>();
				// Premission premission = new Premission();
				// premission.setRoleId(role.getId());
				// premission.setIsStart(1);
				// List<Premission> premissionList =
				// premissionService.getList(premission);
				// for (int j = 0; j < premissionList.size(); j++) {
				// Function function = new Function();
				// function.setId(premissionList.get(j).getFunctionId());
				// function = functionService.getFunctionById(function);
				// fList.add(function);
				// }
				//
				// List<Function> subFunction;
				// for (Function f : menuFunctionList) {
				// RoleFunctions roleFunctions = new RoleFunctions();
				// roleFunctions.setMainFunction(f);
				// subFunction = new ArrayList<Function>();
				// if (null != fList && fList.size() > 0) {
				// for (Function subf : fList) {
				// if (subf.getParentId() == f.getId()) {
				// subFunction.add(subf);
				// }
				// }
				// }
				// roleFunctions.setSubFunctions(subFunction);
				// roleFunctionsList.add(roleFunctions);
				// }
				// Constants.MENU.put(role.getId(), roleFunctionsList);
				//
				// }
				//
				// logger.error("Role list:" + Constants.MENU.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("init datas failed.");
			}
			logger.error("init datas end.");
		}
		// 3.调用service的方法

	}

}
