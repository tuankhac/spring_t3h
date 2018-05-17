package t3h.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	 public static void main(String[] args) {
//	      ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
//	      HelloWorld te = (HelloWorld) context.getBean("helloWorld");
//	      te.toString();
		 Animal dog = new Dog();
		 dog.run();
	   }
}
