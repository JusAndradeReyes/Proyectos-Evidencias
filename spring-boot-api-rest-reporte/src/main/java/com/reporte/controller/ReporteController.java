package com.reporte.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reporte.modelo.Reporte;
import com.reporte.repository.ReporteRpository;
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({"reportes"})
public class ReporteController {
	
	@Autowired
	private ReporteRpository reporteRpository;
	
	//ENDPOINT GET: http://localhost:7575/reportes/listar
		@GetMapping("listar")
		public List<Reporte> listarReporte(){
			List<Reporte> reportes = (List<Reporte>) reporteRpository.findAll();
			return reportes;
		}
		
		//ENDPOINT GET BY ID: http://localhost:7575/reportes/4
		@GetMapping("/{id}")
		public Optional<Reporte> getReporteById(@PathVariable int id){
			return reporteRpository.findById(id);
		}
		
		//ENDPOINT POST: http://localhost:7575/reportes/{FORMAT JSON}
		@PostMapping
		public Reporte agregarReporte(@RequestBody Reporte reporte){
			return reporteRpository.save(reporte);
		}
		
		//ENDPOINT PUT: http://localhost:7575/reportes/id {FORMAT JSON}
		@PutMapping("/{id}")
		public Reporte modificarReporte(@RequestBody Reporte reporte,@PathVariable int id){
			reporte.setId(id);
			return reporteRpository.save(reporte);
		}
		
		//ENDPOINT DELETE BY ID: http://localhost:7575/reportes/id
		@DeleteMapping("/{id}")
		public void eliminarReporteById(@PathVariable int id){
			reporteRpository.deleteById(id);
		}
}
