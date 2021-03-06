import java.util.List;

import org.agent.pojo.Permission;
import org.agent.service.permission.PermissionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BizTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-default.xml");
		// ��ѯbean
		// for (String beanName : ctx.getBeanDefinitionNames()) {
		// System.out.println(beanName);
		// }
		// SystemConfigMapper mapper = (SystemConfigMapper)
		// ctx.getBean("systemConfigMapper");

		// List<SystemConfig> list = mapper.getSystemConfigs(new
		// SystemConfig());
		// System.out.println("################"+list.size()+"#################");
		// RoleMapper roleMapper = (RoleMapper) ctx.getBean("roleMapper");
		//
		// List<Role> list = roleMapper.getRoleList();
		// for (Role role : list) {
		// System.out.println(role.getRoleName());
		// }

		// FunctionMapper fMapper = (FunctionMapper)
		// ctx.getBean("functionMapper");
		// List<Function> fList = fMapper.getFunctionList();
		// for (Function f : fList) {
		// System.out.println(f.getFunctionName());
		// }
		PermissionService pMapper = (PermissionService) ctx.getBean("permissionService");
		Permission p = new Permission();
		p.setRoleId(1);
		p.setIsStart(1);
		List<Permission> list = pMapper.getList(p);
		for (Permission permission : list) {
			System.out.println(permission.getCreatedBy());
			System.out.println(permission.getCreationTime());
		}
	}
}
