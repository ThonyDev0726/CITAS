package Controlador;

import Convertidores.Encriptador;
import ModeloDao.USUARIO_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author kamir
 */
public class ConfirmarCuenta extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("LoginLogger");

    //DATOS A UTILIZAR
    Integer ID_USUARIO_BASE;
    String USUARIO;
    String CLAVE_TEMPORAL;
    String CLAVE_NUEVA;
    String CLAVE_BASE = "";
    String CLAVE_DESENCRIPTADA = "";
    //OBJETOS
    USUARIO_DAO usuDao = new USUARIO_DAO();
    Encriptador enc = new Encriptador();

    public ConfirmarCuenta() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        String strJson = request.getParameter("datosUsuario");
        System.out.println("clave descript "+ enc.desencriptar("KKq13vNeDBzBv4LxlwhiSw=="));
        JSONObject json = new JSONObject(strJson);
        USUARIO = (String) json.get("user_input");
        CLAVE_TEMPORAL = (String) json.get("temporal_password_input");
        CLAVE_NUEVA = (String) json.get("new_password_input");
        ID_USUARIO_BASE = usuDao.consultarUsuario(USUARIO);
        if (ID_USUARIO_BASE >= 1) {
            CLAVE_BASE = usuDao.obtenerClave(ID_USUARIO_BASE);
            CLAVE_DESENCRIPTADA = enc.desencriptar(CLAVE_BASE);
            if (CLAVE_TEMPORAL.equalsIgnoreCase(CLAVE_DESENCRIPTADA)) {
                //Aqui se actualiza la clave del usuario  
                if (usuDao.update_password(ID_USUARIO_BASE, CLAVE_NUEVA) == "La clave del usaurios se actualizo con con exito!") {
                    System.out.println("Clave actualizada");
                    if (usuDao.actualizar_estado(ID_USUARIO_BASE, "ACTUALIZAR") == "El usuario fue dado de baja con exito!") {
                        System.out.println("Estado actualizado");
                        writer.print("¡Estado actualizado!");
                    } else if (usuDao.actualizar_estado(ID_USUARIO_BASE, "ACTUALIZAR") == "Error al dar baja al usuario!") {
                        System.out.println("Estado no actualizado");
                        writer.print("¡Estado no actualizado!");
                    }
                } else if (usuDao.update_password(ID_USUARIO_BASE, enc.encriptar(CLAVE_NUEVA)) == "Error al actualizar clave del usuario!") {
                    System.out.println("Error al actualizar clave del usuario");
                    writer.print("¡Error al actualizar clave del usuario!");
                }
            } else {
                System.out.println("clave incorrecta");
                writer.print("¡Clave incorrecta!");
            }
        } else {
            System.out.println("No existe este usuario");
            writer.print("¡No existe este usuario!");
        }
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException e) {
            logger.warning(e.getLocalizedMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
