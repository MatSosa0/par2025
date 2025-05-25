<%-- 
    Document   : galeria
    Created on : 24 may 2025, 10:30:10 p.m.
    Author     : Matias
--%>

<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Galería de Imágenes</title>
    <style>
        img {
            width: 200px;
            margin: 10px;
            border: 2px solid #ccc;
            border-radius: 10px;
        }
    </style>
</head>
<body>
    <h1>Galería de imágenes</h1>

    <%
        String path = application.getRealPath("/imagenes");
        File folder = new File(path);
        if (folder.exists()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".png"))) {
    %>
                    <img src="imagenes/<%= file.getName() %>" alt="imagen">
    <%
                }
            }
        } else {
            out.println("<p>No se encontró el directorio 'imagenes'</p>");
        }
    %>
</body>
</html>

