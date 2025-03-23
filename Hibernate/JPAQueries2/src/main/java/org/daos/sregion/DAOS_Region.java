package org.daos.sregion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.modelo.sregion.S_Region;
/*
 * QUEIRES JPA(JAVA PERSISTENCE API)
 * 
 * INSERT=PERSIST	UPDATE=MERGE	DELETE=REMOVE	SELECT=GET
 */
public class DAOS_Region {
	public static void agregraS_Region() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			S_Region region = new S_Region();
			region.setId(25);
			region.setName("COAHUILA");
			em.persist(region);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
	
	public static void actualizarS_Region() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			S_Region region = new S_Region();
			region.setId(25);
			region.setName("COAHUILA MX");
			em.merge(region);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
	
	public static void eliminarS_Region() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			S_Region region = new S_Region();
			region = em.find(S_Region.class,25);
			if(region==null){
				System.out.println("¡EL REGISTRO NO EXISTE!");
			}else {
				em.remove(region);
				em.getTransaction().commit();
			}
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			em.getTransaction().rollback();
		}
	}
	
	public static void consultaS_Region() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			//PARAMETSO O COLUMNAS ALIAS: a, abc.. ?,*, menos la ñ
			Query query = em.createQuery("select a from S_Region a");
			@SuppressWarnings("unchecked")
			List<S_Region> regiones = query.getResultList();
			for(S_Region x : regiones) {
				System.out.println(x.getId()+" - "+x.getName());
			}
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			em.getTransaction().rollback();
		}
	}
	/*
	 * CARÁLOGO DE CONSULTAS:
	 * 
	 * 1.- QUERY NAME = S_REGION_SELECT_ALL
	 * 2.-QUERY NAME = S_REGION_SELECT_BY_ID
	 */
	public static void consultaCatalogoS_Region() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			//Query query = em.createNamedQuery("S_REGION_SELECT_ALL");
			Query query = em.createNamedQuery("S_REGION_BY_ID");
			query.setParameter("p", 4);
			@SuppressWarnings("unchecked")
			List<S_Region> regiones = query.getResultList();
			for(S_Region x : regiones) {
				System.out.println(x.getId()+" - "+x.getName());
			}
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			em.getTransaction().rollback();
		}
	}
	
	public static void main(String[]args) {
		//agregraS_Region();
		//actualizarS_Region();
		//eliminarS_Region();
		//consultaS_Region();
		consultaCatalogoS_Region();
	}
}
