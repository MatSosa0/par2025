package com.par2024.apirest.servicios;

import java.util.List;
import com.par2024.apirest.modelos.Producto;

public interface IProductoServicio {
    public List<Producto> obtenerTodo();
    public Producto guardar(Producto producto);
    public Producto obtenerPorId(long id);
    public void eliminar(long id);
}
