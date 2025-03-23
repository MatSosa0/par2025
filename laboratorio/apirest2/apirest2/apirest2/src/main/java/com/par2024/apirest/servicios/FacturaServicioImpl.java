package com.par2024.apirest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.par2024.apirest.modelos.Factura;
import com.par2024.apirest.repositorios.FacturaRepositorio;

@Service
public class FacturaServicioImpl implements IFacturaServicio{
	
	@Autowired
	FacturaRepositorio facturarepositorio;

	@Override
	public List<Factura> obtenerTodo() {
		return facturarepositorio.findAll();
	}

	@SuppressWarnings("null")
    @Override
	public Factura guardar(Factura factura) {
		return facturarepositorio.save(factura);
	}

	@Override
	public Factura obtenerPorId(long id) {
		return facturarepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		facturarepositorio.deleteById(id);
		
	}

}
