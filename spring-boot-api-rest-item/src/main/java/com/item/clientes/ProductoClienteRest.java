package com.item.clientes;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.item.modelo.Producto;
@FeignClient(name="spring-boot-api-rest-item", url="localhost:7272")
public interface ProductoClienteRest {
	
	@GetMapping("listar")
	public List<Producto> lstar();
	
	@GetMapping("ver/{id}")
	public Producto detalleProducto(@PathVariable int id);
}
