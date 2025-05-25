<%-- 
    Document   : index
    Created on : 25 may 2025, 12:20:07 p.m.
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Inicial</title>
    </head>
    <body>
        <h1>Datos del Usuario</h1>
        <form action="SvUsuarios" method="Post">
            <p><label>CI:</label><input type="text" name="ci"></p>
            <p><label>Nombre:</label><input type="text" name="nombre"></p>
            <p><label>Apellido:</label><input type="text" name="apellido"></p>
            <p><label>Telefono:</label><input type="text" name="telefono"></p>
            <button type="submit"> Enviar </button>
        </form>
        
        <h1>Ver Usuario</h1>
        <form action="SvUsuarios" method="Get">
            <p>Para ver los datos de los usuarios cargados haga click en el 
                siguiente boton</p>
            <button type="submit"> Mostrar Usuarios </button>
        </form>
    </body>
</html>
