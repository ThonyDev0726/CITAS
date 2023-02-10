package Controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author kamir
 */
public class Controller extends HttpServlet {

    String MAIN = "index.jsp";
    String LOGIN = "Vista/Login.jsp";
    String REGISTRO = "Vista/RegistroUsuario.jsp";
    String VERIFICAR = "Vista/Verificar.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES

        switch (action) {
            case "main":
                acceso = MAIN;
                break;
            case "iniciar-sesion":
                acceso = LOGIN;
                break;
            case "unirme":
                acceso = REGISTRO;
                break;
            case "verificar":
                acceso = VERIFICAR;
                break;
            default:
                acceso = MAIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
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
