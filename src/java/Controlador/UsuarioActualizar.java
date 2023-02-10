package Controlador;

import Convertidores.Encriptador;
import Modelo.DATOS_GENERALES;
import ModeloDao.DATOS_GENERALES_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;
import org.json.JSONObject;

public class UsuarioActualizar extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("LoginLogger");

    public UsuarioActualizar() {
        super();
    }
    public String DAT_TELEFONO;
    public String DAT_DIRECCION;
    public String DAT_CIUDAD;
    public String DAT_PAIS;
    public String DAT_POSTAL;
    Integer FK_USUARIO;
    String LOGIN = "Vista/Login.jsp";

    //OBJETOS
    DATOS_GENERALES_DAO datDao = new DATOS_GENERALES_DAO();
    Encriptador enc = new Encriptador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        DATOS_GENERALES dat = (DATOS_GENERALES) session.getAttribute("usuario");
        String strJson = request.getParameter("datosUsuario");
        JSONObject json = new JSONObject(strJson);
        DAT_TELEFONO = (String) json.get("txtTelefono");
        DAT_DIRECCION = (String) json.get("txtDireccion");
        DAT_CIUDAD = (String) json.get("txtCiudad");
        DAT_PAIS = (String) json.get("txtPais");
        DAT_POSTAL = (String) json.get("txtPostal");
        FK_USUARIO = dat.getFK_USUARIO();
        System.out.println("usaurio id " + dat.getFK_USUARIO());
        if (dat == null) {
            request.getRequestDispatcher(LOGIN).forward(request, response);
        } else {
            dat.setDAT_TELEFONO(DAT_TELEFONO);
            dat.setDAT_DIRECCION(DAT_DIRECCION);
            dat.setDAT_CIUDAD(DAT_CIUDAD);
            dat.setDAT_PAIS(DAT_PAIS);
            dat.setDAT_POSTAL(DAT_POSTAL);
            dat.setFK_USUARIO(FK_USUARIO);
            if (datDao.update(dat).equalsIgnoreCase("Se actualizaron con exito")) {
                writer.print("Datos actualizados");
                System.out.println("Datos actualizados");
            } else if (datDao.update(dat).equalsIgnoreCase("no se actualizo")) {
                writer.print("No se pudo actualizar");
                System.out.println("No se pudo actualizarf");
            }
        }
        writer.flush();
        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException e) {
            logger.warning(e.getLocalizedMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException e) {
            logger.warning(e.getLocalizedMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
