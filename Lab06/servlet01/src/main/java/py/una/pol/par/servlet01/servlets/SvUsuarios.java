/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package py.una.pol.par.servlet01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    private static final List<String> listaUsuarios = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ci = request.getParameter("ci");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        String usuario = String.format("CI: %s, Nombre: %s, Apellido: %s, Teléfono: %s",
                ci, nombre, apellido, telefono);

        listaUsuarios.add(usuario);

        System.out.println("Usuario cargado:");
        System.out.println(usuario);

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Usuarios cargados:</h2>");

        if (listaUsuarios.isEmpty()) {
            out.println("<p>No hay usuarios cargados.</p>");
        } else {
            out.println("<ul>");
            for (String usuario : listaUsuarios) {
                out.println("<li>" + usuario + "</li>");
            }
            out.println("</ul>");
        }

        out.println("<br><a href='index.jsp'>Volver</a>");
        out.println("</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "Servlet que guarda y muestra usuarios";
    }
}
