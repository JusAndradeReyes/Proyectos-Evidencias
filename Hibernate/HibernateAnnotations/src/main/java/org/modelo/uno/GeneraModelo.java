package org.modelo.uno;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeneraModelo {
	public static void main(String [] args) {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.addAnnotatedClass(Bitacora.class);
			cfg.configure("hibernate.cfg.xml");
			new SchemaExport(cfg).create(true,true);
		}catch(Exception e){
			System.out.println("Eception:"+e.getMessage());
		}
	}
}

//DESC BITACORA;  --SQL PARA CONSULTAR MODELOS CREADOS