package com.par2024.apirest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.par2024.apirest.modelos.Factura;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long>{

}
