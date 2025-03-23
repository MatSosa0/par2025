package com.par2024.apirest.controladores;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.par2024.apirest.modelos.Factura;
import com.par2024.apirest.servicios.FacturaServicioImpl;

@RestController
@RequestMapping("/api/v2/")
public class FacturaControlador {
	
	@Autowired
    FacturaServicioImpl facturaservicio;
	
	@GetMapping("/facturas")
	public List<Factura> obtenerFacturas(){
		return facturaservicio.obtenerTodo();
	}
	
	
	@PostMapping("/facturas")
	public ResponseEntity<Factura> guardarFactura(@RequestBody Factura factura){
		Factura nueva_factura = facturaservicio.guardar(factura);
		return new ResponseEntity<>(nueva_factura, HttpStatus.CREATED);
	}
	
	@GetMapping("/facturas/{id}")
	public ResponseEntity<Factura> obtenerFacturaId(@PathVariable long id){
		Factura facturaPorId = facturaservicio.obtenerPorId(id);
		return ResponseEntity.ok(facturaPorId);
	}
	
	@PutMapping("/facturas/{id}")
	public ResponseEntity<Factura> actualizarFactura(@PathVariable long id, @RequestBody Factura factura){
		Factura facturaPorId = facturaservicio.obtenerPorId(id);
		facturaPorId.setNumero(factura.getNumero());
		facturaPorId.setCliente(factura.getCliente());
		facturaPorId.setTotal(factura.getTotal());
		
		Factura factura_actualizada = facturaservicio.guardar(facturaPorId);
		return new ResponseEntity<>(factura_actualizada, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/facturas/{id}")
	public ResponseEntity<HashMap<String,Boolean>> eliminarFactura(@PathVariable long id){
		this.facturaservicio.eliminar(id);

        HashMap<String, Boolean> estadoFacturaEliminado = new HashMap<>();
		estadoFacturaEliminado.put("eliminado", true);
        
		return ResponseEntity.ok(estadoFacturaEliminado);
	}

}
