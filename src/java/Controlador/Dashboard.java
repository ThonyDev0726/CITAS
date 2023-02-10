package Controlador;

import Modelo.DATOS_GENERALES;
import Modelo.USER;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author kamir
 */
public class Dashboard extends HttpServlet {

    String LOGIN = "Vista/Login.jsp";
    String DASHBOARD_ADMINISTRADOR = "Vista/Administrador/dashboard.jsp";
    String DASHBOARD_CLIENTE = "Vista/Cliente/dashboard.jsp";
    String CLIENTE_PERFIL = "Vista/Cliente/perfil.jsp";
    String CLIENTE_TODAS = "Vista/Cliente/todas.jsp";
    String CLIENTE_PENDIENTES = "Vista/Cliente/perfil.jsp";
    String CLIENTE_EJECUCION = "Vista/Cliente/perfil.jsp";
    String CLIENTE_REALIZADAS = "Vista/Cliente/perfil.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        DATOS_GENERALES usu = (DATOS_GENERALES) session.getAttribute("usuario");
        if (usu == null) {
            request.getRequestDispatcher(LOGIN).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";
        //
        HttpSession session = request.getSession();
        DATOS_GENERALES usu = (DATOS_GENERALES) session.getAttribute("usuario");
        if (usu == null) {
            request.setAttribute("iniciarSesion", "Debes iniciar sesion, para acceder al contenido");
            request.getRequestDispatcher(LOGIN).forward(request, response);
        } else {
            String TIPO_USUARIO = usu.getUSU_TIPO();
            if (TIPO_USUARIO.equalsIgnoreCase("ADMINISTRADOR")) {
                switch (action) {
                    case "administrador":
                        acceso = DASHBOARD_ADMINISTRADOR;
                        break;
                    case "administrador_perfil":
                        acceso = DASHBOARD_ADMINISTRADOR;
                        break;
                    case "cliente":
                        request.getSession().removeAttribute("usuario");
                        acceso = LOGIN;
                        break;
                    case "cliente_perfil":
                        request.getSession().removeAttribute("usuario");
                        acceso = LOGIN;
                        break;
                    default:
                        acceso = LOGIN;
                }
            }
            if (TIPO_USUARIO.equalsIgnoreCase("CLIENTE")) {
                switch (action) {
                    case "administrador":
                        request.getSession().removeAttribute("usuario");
                        acceso = LOGIN;
                        break;
                    case "administrador_perfil":
                        request.getSession().removeAttribute("usuario");
                        acceso = LOGIN;
                        break;
                    case "cliente":
                        acceso = DASHBOARD_CLIENTE;
                        break;
                    case "cliente_perfil":
                        acceso = CLIENTE_PERFIL;
                        break;
                    case "todas":
                        acceso = CLIENTE_TODAS;
                        break;
                    case "en_ejecucion":
                        acceso = CLIENTE_EJECUCION;
                        break;
                    case "pendientes":
                        acceso = CLIENTE_PENDIENTES;
                        break;
                    case "realizadas":
                        acceso = CLIENTE_REALIZADAS;
                        break;
                    default:
                        acceso = LOGIN;
                }
            }
            RequestDispatcher view = request.getRequestDispatcher(acceso);
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
