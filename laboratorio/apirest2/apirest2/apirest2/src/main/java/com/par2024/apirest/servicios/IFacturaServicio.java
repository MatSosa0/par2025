package com.par2024.apirest.servicios;

import java.util.List;
import com.par2024.apirest.modelos.Factura;

public interface IFacturaServicio {
    public List<Factura> obtenerTodo();
    public Factura guardar(Factura factura);
    public Factura obtenerPorId(long id);
    public void eliminar(long id);
}
