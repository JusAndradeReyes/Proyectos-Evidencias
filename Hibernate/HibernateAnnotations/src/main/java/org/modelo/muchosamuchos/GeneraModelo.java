package org.modelo.muchosamuchos;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
public class GeneraModelo {
	public static void main(String [] args) {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.addAnnotatedClass(Encargado.class);
			cfg.addAnnotatedClass(Evento.class);
			cfg.configure("hibernate.cfg.xml");
			new SchemaExport(cfg).create(true,true);
		}catch(Exception e){
			System.out.println("Eception:"+e.getMessage());
		}
	}
}

//DESC ENCARGADO; / DESC EVENTO;  / DESC ENCEVE; --SQL PARA CONSULTAR MODELOS CREADOS