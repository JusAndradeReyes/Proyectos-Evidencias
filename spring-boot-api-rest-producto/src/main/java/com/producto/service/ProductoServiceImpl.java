package com.producto.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.producto.modelo.Producto;
import com.producto.repository.ProductoRepository;
@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAllProductos() {
		return (List<Producto>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findByIdProducto(int id) {
		return repository.findById(id).orElse(null);
	}

}
