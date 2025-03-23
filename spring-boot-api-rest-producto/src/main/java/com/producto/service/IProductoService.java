package com.producto.service;
import java.util.List;
import com.producto.modelo.Producto;
public interface IProductoService {
	
	public List<Producto> findAllProductos();
	public Producto findByIdProducto(int id);

}
