package com.producto.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.producto.modelo.Producto;
import com.producto.service.IProductoService;
@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	//http://localhost:7272/listar
	@GetMapping("/listar")
	public List<Producto> listarProductos(){
		return productoService.findAllProductos();
	}
	
	//http://localhost:7272/ver/id
	@GetMapping("/ver/{id}")
	public Producto detalleProducto(@PathVariable int id) {
		return productoService.findByIdProducto(id);
	}
	
}
