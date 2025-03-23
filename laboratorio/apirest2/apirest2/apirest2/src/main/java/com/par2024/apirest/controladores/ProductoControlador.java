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

import com.par2024.apirest.modelos.Producto;
import com.par2024.apirest.servicios.ProductoServicioImpl;

//Notaciones
/*
* @RestController en Spring Framework es una anotación que se utiliza para marcar una clase como un controlador de Spring MVC 
* y para indicar que los métodos de la clase se encargarán de manejar las solicitudes HTTP y devolverán las respuestas adecuadas. 
*/
@RestController
/* 
 * La notación @RequestMapping en Spring Framework es una anotación que se utiliza para mapear solicitudes HTTP a métodos de controlador específicos en una clase.
*/
@RequestMapping("/api/v2/")
public class ProductoControlador {
	
	/*
	 * La notación @Autowired en Spring Framework se utiliza para realizar la inyección de dependencias automáticamente en un componente de Spring.
	 */
	@Autowired
	ProductoServicioImpl productoservicio;
	
	/*
	 * -La notación @GetMapping es una anotación en Spring Framework que combina la funcionalidad de las anotaciones @RequestMapping y @ResponseBody 
	 * y se utiliza para mapear las solicitudes HTTP GET a métodos de controlador específicos en una aplicación Spring 
	 */
	@GetMapping("/productos")
	public List<Producto> obtenerProductos(){
		return productoservicio.obtenerTodo();
	}
	
	/*
	 *  -La anotación @PostMapping es una anotación en Spring Framework que se utiliza para mapear las solicitudes HTTP POST a métodos de controlador específicos en una aplicación Spring. 
	 *  Esta anotación combina la funcionalidad de las anotaciones @RequestMapping y @ResponseBody, y se utiliza para manejar solicitudes POST y devolver datos al cliente.
	 * -La anotación @RequestBody en Spring Framework se utiliza para indicar que el parámetro de un método de controlador debe ser vinculado al cuerpo de la solicitud HTTP. 
	 *  Esto significa que Spring tomará los datos enviados en el cuerpo de la solicitud y los convertirá automáticamente al tipo de objeto especificado en el parámetro del método.
	 */
	@PostMapping("/productos")
	public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
		Producto nuevo_producto = productoservicio.guardar(producto);
		return new ResponseEntity<>(nuevo_producto, HttpStatus.CREATED);
	}
	
	/* 
	 * -La notación @GetMapping es una anotación en Spring Framework que combina la funcionalidad de las anotaciones @RequestMapping y @ResponseBody 
	 * y se utiliza para mapear las solicitudes HTTP GET a métodos de controlador específicos en una aplicación Spring.
	 * -La anotación @PathVariable en Spring Framework se utiliza para mapear variables de ruta en una URL a parámetros de método en un controlador de Spring. 
	 *  Permite extraer valores de partes de la URL y utilizarlos como argumentos en los métodos de controlador.
	 * -La anotación @RequestBody en Spring Framework se utiliza para indicar que el parámetro de un método de controlador debe ser vinculado al cuerpo de la solicitud HTTP. 
	 *  Esto significa que Spring tomará los datos enviados en el cuerpo de la solicitud y los convertirá automáticamente al tipo de objeto especificado en el parámetro del método.
	*/
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProductoId(@PathVariable long id){
		Producto productoPorId = productoservicio.obtenerPorId(id);
		return ResponseEntity.ok(productoPorId);
	}
	
	/*
	 * -La anotación @PutMapping es una anotación en Spring Framework que se utiliza para mapear las solicitudes HTTP PUT a métodos de controlador específicos en una aplicación Spring. 
	 * -La anotación @PathVariable en Spring Framework se utiliza para mapear variables de ruta en una URL a parámetros de método en un controlador de Spring. 
	 *  Permite extraer valores de partes de la URL y utilizarlos como argumentos en los métodos de controlador.
	 * -La anotación @RequestBody en Spring Framework se utiliza para indicar que el parámetro de un método de controlador debe ser vinculado al cuerpo de la solicitud HTTP. 
	 *  Esto significa que Spring tomará los datos enviados en el cuerpo de la solicitud y los convertirá automáticamente al tipo de objeto especificado en el parámetro del método.
	 */
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable long id, @RequestBody Producto producto){
		Producto productoPorId = productoservicio.obtenerPorId(id);
		productoPorId.setNombre(producto.getNombre());
		productoPorId.setPrecio(producto.getPrecio());
		productoPorId.setDescripcion(producto.getDescripcion());
		
		Producto producto_actualizado = productoservicio.guardar(productoPorId);
		return new ResponseEntity<>(producto_actualizado, HttpStatus.CREATED);
	}
	
	/*
	 *  -La anotación @DeleteMapping es una anotación en Spring Framework que se utiliza para mapear las solicitudes HTTP DELETE a métodos de controlador específicos en una aplicación Spring. 
	 *  -La anotación @PathVariable en Spring Framework se utiliza para mapear variables de ruta en una URL a parámetros de método en un controlador de Spring. 
	 *  Permite extraer valores de partes de la URL y utilizarlos como argumentos en los métodos de controlador.
	 */
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<HashMap<String,Boolean>> eliminarProducto(@PathVariable long id){
		this.productoservicio.eliminar(id);
		
		HashMap<String, Boolean> estadoProductoEliminado = new HashMap<>();
		estadoProductoEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoProductoEliminado);
	}

}
