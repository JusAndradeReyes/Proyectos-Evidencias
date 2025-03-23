package org.test.app;
import java.util.List;
import org.dao.sregion.DaoImpl;
import org.modelo.sregion.S_Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	public static void addS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		S_Region region = new S_Region();
		region.setName("BAJA CALIFORNIA");
		dao.addS_Region(region);
	}
	
	public static void updateS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		S_Region region = new S_Region();
		region.setId(5);
		region.setName("BAJA CALIFORNIA MX");
		dao.updateS_Region(region);
	}
	
	public static void deleteS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		S_Region region = new S_Region();
		region.setId(5);
		dao.deleteS_Region(region);
	}
	
	public static void selectByIdS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		S_Region region = new S_Region();
		dao.getS_RegionById(3);
		System.out.println(region.getId()+" , "+region.getName());
	}
	
	public static void selectAllS_Region() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
		List<S_Region> regiones = dao.listS_Region();
		for (S_Region region : regiones) {
			System.out.println(region.getId()+" , "+region.getName());
		}
	}
	
	public static void main(String[] args) {
		//addS_Region();
		//updateS_Region();
		//deleteS_Region();
		selectByIdS_Region();
		//selectAllS_Region();
	}
}
