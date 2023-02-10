package Controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CerrarSesion extends HttpServlet {

    String LOGIN = "Vista/Login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("usuario");
        session.removeAttribute("usuNombre");
        session.removeAttribute("usuApellido");
        session.removeAttribute("usuFoto");
        session.removeAttribute("usuTelefono");
        session.removeAttribute("usuDireccion");
        session.removeAttribute("usuCiudad");
        session.removeAttribute("usuPais");
        session.removeAttribute("usuPostal");
        request.setAttribute("iniciarSesion", "Cerraste sesion!!");
        request.getRequestDispatcher(LOGIN).forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
