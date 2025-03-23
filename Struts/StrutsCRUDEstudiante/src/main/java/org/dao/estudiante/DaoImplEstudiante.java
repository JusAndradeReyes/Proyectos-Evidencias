package org.dao.estudiante;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.estudiante.Estudiante;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
public class DaoImplEstudiante implements DaoEstudiante {
	
	@SessionTarget
	private Session session;
	
	@TransactionTarget
	private Transaction transaction;

	@Override
	public void addEstudiante(Estudiante estudiante) {
		try {
			session.saveOrUpdate(estudiante);
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			transaction.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> listEstudiantes() {
		List<Estudiante> list = null;
		try {
			list = (List<Estudiante>) session.createQuery("from Estudiante").list();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			transaction.rollback();
		}
		return list;
	}

	@Override
	public Estudiante getEstudianteById(int id) {
		Estudiante estudiante = null;
		try {
			estudiante = (Estudiante) session.get(Estudiante.class,id);
		}catch(Exception e){
			System.out.println("Exception:"+e.getMessage());
			transaction.rollback();
		}
		return estudiante;
	}

	@Override
	public void deleteEstudiante(int id) {
		Estudiante estudiante = null;
		try {
			estudiante = (Estudiante) session.get(Estudiante.class,id);
			session.delete(estudiante);
		}catch(Exception e){
			System.out.println("Exception:"+e.getMessage());
			transaction.rollback();
		}
	}
}
