package com.par2024.apirest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.par2024.apirest.modelos.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

}
