package org.modelo.unoamuchos;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeneraModelo {
	public static void main(String [] args) {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.addAnnotatedClass(Departamento.class);
			cfg.addAnnotatedClass(Personal.class);
			cfg.configure("hibernate.cfg.xml");
			new SchemaExport(cfg).create(true,true);
		}catch(Exception e){
			System.out.println("Eception:"+e.getMessage());
		}
	}
}

//DESC DEPARTAMENTO; / DESC PERSONAL; --SQL PARA CONSULTAR MODELOS CREADOS
