package org.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * EJEMPLO: INYECCIÓN DE DEPENDENCIAS
 * A TRAVÉS DE LA ANOTACIÓN @Autowired
 * 
 * @Component: CONVERTIR LA CLASE EN UN BEAN.
 * 
 * @Autowired: REALIZA LA INSTANCIA ÚNIC, INYECCIÓN DE DEPENDENCIAS.
 * 
 * DATASOURCE: FUENTE Ú ORIGEN DE DATOS, CONEXIÓN A BD
 */
@Component
public class DaoImpl {
	
	@Autowired
	private DataSource dataSource;
	
	//GET AND SET OF DATASOURCE
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//QUERIE
	public void selecAllS_Region() {
		Connection connection = null;
		try {
			//ESTABLECE CONEXIÓN CON ORACLE...
			connection = dataSource.getConnection();
			//QUERY
			String sql = "SELECT * FROM S_REGION";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				System.out.println(rSet.getInt("id")+","+rSet.getString("name"));
			}
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
}
