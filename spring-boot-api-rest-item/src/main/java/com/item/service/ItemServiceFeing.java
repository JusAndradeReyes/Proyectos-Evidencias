package com.item.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.item.clientes.ProductoClienteRest;
import com.item.modelo.Item;
@Service("itemServiceFeing")
@Primary //REALIZAR INYECCIÓN DE DEPENDENCIAS DE FORMA AVANZADA
public class ItemServiceFeing implements ItemService{
	
	@Autowired
	private ProductoClienteRest clienteRest;
	
	@Override
	public List<Item> findAllProductos() {
		return clienteRest.lstar().stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findByIdProducto(int id, Integer cantidad) {
		return new Item(clienteRest.detalleProducto(id),cantidad);
	}
}
