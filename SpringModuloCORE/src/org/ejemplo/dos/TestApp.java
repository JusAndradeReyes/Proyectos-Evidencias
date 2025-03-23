package org.ejemplo.dos;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			Triangle triangle = (Triangle) context.getBean("ejemplodos");
			triangle.imprimirCoordenadas();
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
}
