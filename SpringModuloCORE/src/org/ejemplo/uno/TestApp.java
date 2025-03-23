package org.ejemplo.uno;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestApp {
	
	public static void main(String[]ags) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			Triangle triangle = (Triangle) context.getBean("ejemplouno");
			String resultado = triangle.toString();
			System.out.println(resultado);
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
}
