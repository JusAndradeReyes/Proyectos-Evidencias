package org.action.estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.dao.estudiante.DaoEstudiante;
import org.dao.estudiante.DaoImplEstudiante;
import org.modelo.estudiante.Estudiante;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionEstudiante extends ActionSupport implements ModelDriven<Estudiante>{
	
	public Estudiante estudiante = new Estudiante(); //GET AND SET
	private DaoEstudiante dao = new DaoImplEstudiante();
	private List<Estudiante> listEstudiante = new ArrayList<Estudiante>();//GET AND SET
	
	public String execute() {
		return SUCCESS;
	}
	
	public String add() {
		dao.addEstudiante(estudiante);
		return SUCCESS;
	}
	
	public String select() {
		setListEstudiante(dao.listEstudiantes());
		return SUCCESS;
	}
	
	public String edit() {
		HttpServletRequest request = (HttpServletRequest)
		ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		estudiante = dao.getEstudianteById(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String delete() {
		HttpServletRequest request = (HttpServletRequest)
		ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		dao.deleteEstudiante(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	@Override
	public Estudiante getModel() {
		// TODO Auto-generated method stub
		return estudiante;
	}
	
	//GETTERS AND SETTERS OF ESTUDIANTE AND LISTESTUDIANTE
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public List<Estudiante> getListEstudiante() {
		return listEstudiante;
	}
	
	public void setListEstudiante(List<Estudiante> listEstudiante) {
		this.listEstudiante = listEstudiante;
	}
}
