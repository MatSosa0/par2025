<%-- 
    Document   : index
    Created on : 24 may 2025, 10:30:26 p.m.
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Page - Ejemplo Lab05 - 2024</title>
</head>
<body>
    <h1>Ejemplos de expresiones</h1>

    <%-- Mostrar la fecha y hora actual --%>
    <p><strong>Fecha y hora:</strong> <%= new java.util.Date().toString() %></p>

    <%-- Convertir a mayúsculas un String --%>
    <p><strong>Texto en mayúsculas:</strong> 
        <%= "Texto a mayúsculas".toUpperCase() %></p>

    <%-- Resultado de una expresión aritmética --%>
    <p><strong>Resultado de (5+2)/3:</strong> <%= (5+2)/(float)3 %></p>

    <%-- Generar un número aleatorio entre 0 y 99 --%>
    <p><strong>Número aleatorio:</strong> 
        <%= new java.util.Random().nextInt(100) %></p>
</body>
</html>
