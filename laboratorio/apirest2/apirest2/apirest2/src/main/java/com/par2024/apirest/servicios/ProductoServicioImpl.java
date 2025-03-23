package com.par2024.apirest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.par2024.apirest.modelos.Producto;
import com.par2024.apirest.repositorios.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements IProductoServicio{
	
	@Autowired
	ProductoRepositorio productorepositorio;

	@Override
	public List<Producto> obtenerTodo() {
		return productorepositorio.findAll();
	}

	@SuppressWarnings("null")
    @Override
	public Producto guardar(Producto producto) {
		return productorepositorio.save(producto);
	}

	@Override
	public Producto obtenerPorId(long id) {
		return productorepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		productorepositorio.deleteById(id);
		
	}

}
