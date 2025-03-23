package com.item.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.item.modelo.Item;
import com.item.service.ItemService;
@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("itemServiceFeing") //SE OCUPA PARA ESTRABLECER UN ORDEN DE INYECCIÓN A LOS BEANS
	private ItemService itemService;
	
	//ENDPOINT GET: http://localhost:7171/listar
	@GetMapping("/listar")
	public List<Item> listarItemsProducto(){
		return itemService.findAllProductos();
	}
	
	//ENDPOINT GET: http://localhost:7171/ver/400/cantidad/30
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalleProducto(@PathVariable int id, @PathVariable Integer cantidad) {
		return itemService.findByIdProducto(id, cantidad);
	}
}
