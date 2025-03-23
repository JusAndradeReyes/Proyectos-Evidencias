package com.item.service;
import java.util.List;
import com.item.modelo.Item;
public interface ItemService {
	
	public List<Item> findAllProductos();
	public Item findByIdProducto(int id, Integer cantidad);
}
