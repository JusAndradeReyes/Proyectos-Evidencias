package org.dao.reporte;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.modelo.reporte.Reporte;
public class DaoReporte implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void addReporte(Reporte reporte) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(reporte);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();
		}
	}
	
	public void updateReporte(Reporte reporte) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(reporte);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();
		}
	}
	
	public void deleteReporte(Reporte reporte) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(reporte);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Reporte> consultaReporte() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Reporte> reportes = null;
		try {
			session.beginTransaction();
			reportes = (List<Reporte>) session.createQuery("from Reporte").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
			session.getTransaction().rollback();
		}
		return reportes;
	}
}
