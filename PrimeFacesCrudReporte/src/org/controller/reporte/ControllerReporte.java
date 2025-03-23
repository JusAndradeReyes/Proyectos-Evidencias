package org.controller.reporte;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.dao.reporte.DaoReporte;
import org.modelo.reporte.Reporte;
@ManagedBean
@ViewScoped
public class ControllerReporte implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Reporte> listaReportes;
	private Reporte reporte;
	
	//CONSTRUCTOR SUPER CLASS
	public ControllerReporte() {
		reporte = new Reporte();
	}
	
	//GET AND SET OF LISTAPERSONAS
	public List<Reporte> getListaReportes() {
		DaoReporte dao = new DaoReporte();
		listaReportes = dao.consultaReporte();
		return listaReportes;
	}

	public void setListaReportes(List<Reporte> listaReportes) {
		this.listaReportes = listaReportes;
	}

	//GET AND SET DE PERSONA
	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}
	
	//QUERIES
	public void limpiarReporte() {
		reporte = new Reporte();
	}
	
	public String agregarReporte() {
		DaoReporte dao = new DaoReporte();
		dao.addReporte(reporte);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String modificarReporte() {
		DaoReporte dao = new DaoReporte();
		dao.updateReporte(reporte);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String eliminarReporte() {
		DaoReporte dao = new DaoReporte();
		dao.deleteReporte(reporte);
		return "/index.xhtml?faces-redirect=true";
	}
}
