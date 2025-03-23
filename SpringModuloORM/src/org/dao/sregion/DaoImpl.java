package org.dao.sregion;
import java.util.ArrayList;
import java.util.List;
import org.modelo.sregion.S_Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component
public class DaoImpl {
	
	@Autowired
	private HibernateTemplate template;
	
	//GET AND SET DATASOURCE
	public void addS_Region(S_Region region) {
		template.save(region);
	}
	
	public void updateS_Region(S_Region region) {
		template.update(region);
	}
	
	public void deleteS_Region(S_Region region) {
		template.delete(region);
	}
	
	public S_Region getS_RegionById(int id) {
		S_Region region = (S_Region) template.get(S_Region.class,id);
		return region;
	}
	
	public List<S_Region> listS_Region() {
		List<S_Region> regiones = new ArrayList<S_Region>();
		regiones = template.loadAll(S_Region.class);
		return regiones;
	}
}
