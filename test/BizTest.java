import java.util.List;

import org.agent.dao.systemconfig.SystemConfigMapper;
import org.agent.pojo.SystemConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BizTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-default.xml");
//		for (String beanName : ctx.getBeanDefinitionNames()) {
//			System.out.println(beanName);
//		}
		SystemConfigMapper mapper = (SystemConfigMapper) ctx.getBean("systemConfigMapper");

		List<SystemConfig> list = mapper.getSystemConfigs(new SystemConfig());
		System.out.println("################"+list.size()+"#################");
	}
}
