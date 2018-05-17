package t3h.edu;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorld extends Object {

	@Autowired
	HelloB b;
	
	public HelloWorld() {
		super();
		System.out.println("Khoi tao helloworld");
	}
	public String toString(){
		System.out.println("abc");
		b.show();
		return "";
	}
	
	class HelloB{
		public HelloB(){
			System.out.println("Hello B");
		}
		
		public void show(){
			System.out.println("Hellow BBBB ");
		}
	}

}
