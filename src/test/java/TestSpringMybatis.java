import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMybatis {
  /*
   * 此类完成项目的各模块的测试功能；
  **/
	public static void main(String[] args) {

		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserControllerMybatis uc = (UserControllerMybatis)appCon.getBean("UserControllerMybatis");
		uc.test();
	}
}
