package org.test.app;
import java.util.List;

import org.dao.sregion.DaoImpl;
import org.modelo.sregion.S_Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	public  static void addS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		dao.addS_Region(new S_Region(30,"SINALOA"));
	}
	
	public  static void updateS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		dao.updateS_Region(new S_Region("SINALOA MX",30));
	}
	
	public  static void deleteS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		dao.deleteS_Region(new S_Region(30));
	}
	
	public  static void selectByIdS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		S_Region region = dao.selectByIdS_Region(4);
		System.out.println(region.getId()+" , "+region.getName());
	}
	
	public  static void selectAllS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		List<S_Region> regiones = dao.selectAllS_Region();
		for(S_Region x : regiones) {
			System.out.println(x.getId()+" , "+x.getName());
		}
	}
	
	public  static void createTableUniversidad() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		dao.createTableUniversidad();
	}
	
	public static void main(String[] args) {
		//addS_Region();
		//updateS_Region();
		//deleteS_Region();
		//selectByIdS_Region();
		//selectAllS_Region();
		createTableUniversidad();
	}
}
