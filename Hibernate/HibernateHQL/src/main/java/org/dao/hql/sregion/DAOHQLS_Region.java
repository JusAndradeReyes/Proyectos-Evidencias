package org.dao.hql.sregion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.modelo.sregion.S_Region;

/*
 * HQL: HIBERNATE QUERY LANGUAJE, ES UN LENGUAJE
 * DE HIBARNATE SIMILAR A SQL, NO ES SQL.
 */
public class DAOHQLS_Region {
	public static void actualizarS_Region() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("update S_Region set name = :name where id = :id");
			query.setParameter("id", 5);
			query.setParameter("name","PUEBLA MX");
			query.executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
	
	public static void eliminarS_Region() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("delete from S_Region where id = :id");
			query.setParameter("id", 5);
			query.executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();
		}
	}
	
	public static void consultaGeneralS_Region() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<S_Region> regiones = (List<S_Region>)
					session.createQuery("from S_Region").list();
			for(S_Region x : regiones) {
				System.out.println(x.getId()+","+x.getName());
			}
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();
		}
	}
	
	/*
	 * EN HQL EL INSERT REALIZA LA MIGRACIÓN O RESPALDO DE DATOS A OTRA TABLA.
	 * SOLO CORRE UNA VEZ POR QUE NO PUEDE INSERTAR DE NUEVO LLLAVES PRIMARIAS
	 */
	public static void insertarS_Region() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			//INSERT DIFERENTE EN HQL , NO SE PUEDEN INSERTAR NUEVOS REGISTROS, PARA ELLO SE DEBE UTILIZAR MEJOR HIBERNATE
			Query query = session.createQuery("insert into S_Region2 (id,name) select id,name from S_Region");
			query.executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();
		}
	}
	
	
	public static void main(String[]args) {
		//actualizarS_Region();
		//eliminarS_Region();
		//consultaGeneralS_Region();
		insertarS_Region(); //HACE UN "RESPLADO O MIGRACIÓN DE TABLA ORIGINAL"
	}
}
