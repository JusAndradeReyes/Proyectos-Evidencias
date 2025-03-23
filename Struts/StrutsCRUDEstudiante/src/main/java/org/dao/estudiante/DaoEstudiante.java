package org.dao.estudiante;
import java.util.List;
import org.modelo.estudiante.Estudiante;
public interface DaoEstudiante {
	public void addEstudiante(Estudiante estudiante);
	public List<Estudiante> listEstudiantes();
	public Estudiante getEstudianteById(int id);
	public void deleteEstudiante(int id);
}
