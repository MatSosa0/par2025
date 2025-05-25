<%-- 
    Document   : factorial
    Created on : 24 may 2025, 10:29:51 p.m.
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cálculo del factorial</title>
</head>
<body>
    <h1>Cálculo del factorial</h1>

    <!-- Formulario -->
    <form action="factorial.jsp" method="get">
        <p>Número: <input type="text" name="numero">
        <input type="submit" value="Calcular"></p>
    </form>

    <%
        String numeroGet = request.getParameter("numero");
        if(numeroGet != null) {
            int numero = 0;
            double factorial = 1;
            boolean error = false;

            try {
                numero = Integer.parseInt(numeroGet);
                if(numero < 1) {
                    error = true;
                } else {
                    for(int i = numero; i > 1; i--) {
                        factorial *= i;
                    }
                }
            } catch(NumberFormatException e) {
                error = true;
            }

            if(error) {
                out.println("<p style='color:red;'>Debe indicar un número "
                + "entero mayor que 0</p>");
            } else {
                out.println("<p><strong>Resultado:</strong> " + numero + "! = "
                + "" + factorial + "</p>");
            }
        }

        // Contador de ejecuciones en la sesión
        Integer contador = (Integer)session.getAttribute("contadorVisitas");
        if (contador == null) {
            contador = 0;
        }
        contador++;
        session.setAttribute("contadorVisitas", contador);
        out.println("<p><strong>Visitas en esta sesión:</strong> " + contador 
                + "</p>");
    %>
</body>
</html>

