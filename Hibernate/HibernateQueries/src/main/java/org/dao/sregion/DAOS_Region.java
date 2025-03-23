package org.dao.sregion;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.modelo.sregion.S_Region;

/*
 * DAO: DATA ACCES OBJETC, SE DEFINE EN LA CAPA DE DATOS LAS CONSULTAS
 * 
 * EJEMPLO: CRUD CON HIBERNATE.
 */
public class DAOS_Region {
	
	public static void agregarS_region() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			S_Region region = new S_Region();
			region.setName("Veracruz");
			session.save(region);
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();
		}
	}
	
	public static void actualizarR_Region() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			S_Region region = new S_Region();
			region.setId(1);
			region.setName("Apizaco Tlaxcala");
			session.update(region);
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();		}
	}
	
	public static void eliminarS_Region() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			S_Region region = new S_Region();
			region.setId(1);
			session.delete(region);
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();		}
	}
	
	public static void consultaIndividualS_Region() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			S_Region region = (S_Region) session.get(S_Region.class, 5);
			System.out.println(region.getId()+","+region.getName());
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();		}
	}
	
	public static void main(String [] agrs) {
		//agregarS_region();
		//actualizarR_Region();
		//eliminarS_Region();
		consultaIndividualS_Region();
	}
}
