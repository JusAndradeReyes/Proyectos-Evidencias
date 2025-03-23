package org.daos.empleado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.modelo.empleado.Empleado;
import org.modelo.sregion.S_Region;

public class DAOS_Empelado {
	
	public static void agregraEmpleado() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Empleado empleado = new Empleado();
			empleado.setId(6);
			empleado.setNombre("JUSTINO");
			empleado.setSalario(25000);
			em.persist(empleado);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
	
	public static void actualizarEmpleado() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Empleado empleado = new Empleado();
			empleado.setId(6);
			empleado.setNombre("Justino Juan Carlos Andrade Reyes");
			em.merge(empleado);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
	
	public static void eliminarEmpleado() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Empleado empleado = new Empleado();
			empleado = em.find(Empleado.class,6);
			if(empleado==null){
				System.out.println("¡EL REGISTRO NO EXISTE!");
			}else {
				em.remove(empleado);
				em.getTransaction().commit();
			}
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			em.getTransaction().rollback();
		}
	}
	
	public static void consultaEmpleado() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			//PARAMETSO O COLUMNAS ALIAS: a, abc.. ?,*, menos la ñ
			Query query = em.createQuery("select a from Empleado a");
			@SuppressWarnings("unchecked")
			List<Empleado> empleados = query.getResultList();
			for(Empleado x : empleados) {
				System.out.println(x.getId()+" - "+x.getNombre());
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
	public static void consultaCatalogoEmpleado() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			//Query query = em.createNamedQuery("EMPLEADO_SELECT_ALL");
			Query query = em.createNamedQuery("EMPLEADO_BY_ID");
			query.setParameter("p", 6);
			@SuppressWarnings("unchecked")
			List<Empleado> empleados = query.getResultList();
			for(Empleado x : empleados) {
				System.out.println(x.getId()+" - "+x.getNombre());
			}
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
			em.getTransaction().rollback();
		}
	}

	
	public static void main(String[]args) {
		//agregraEmpleado();
		//actualizarEmpleado();
		//eliminarEmpleado();
		//consultaEmpleado();
		//consultaCatalogoEmpleado();
	}
}
