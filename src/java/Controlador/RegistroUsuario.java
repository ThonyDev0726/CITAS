package Controlador;

import Convertidores.ENVIO_MAIL;
import Convertidores.Encriptador;
import Modelo.*;
import ModeloDao.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author kamir
 */
public class RegistroUsuario extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("LoginLogger");
//========================================================================================== VARIABLES GLOBALES     

    ENVIO_MAIL m = new ENVIO_MAIL();
    String LOGIN = "Vista/Login.jsp";
    String REGISTRO = "Vista/RegistroUsuario.jsp";
    LocalDate todaysDate = LocalDate.now();
    String fecha = todaysDate.toString();
    Encriptador e = new Encriptador();
    /**/
    USER usu = new USER();
    USUARIO_DAO usuDao = new USUARIO_DAO();
    DATOS_GENERALES dat = new DATOS_GENERALES();
    DATOS_GENERALES_DAO datDao = new DATOS_GENERALES_DAO();
    /**/
    public Integer ID_USUARIO;
    public Integer FK_USUARIO;
    public Integer ID_USUARIO_BASE;
    public String USU_USUARIO;
    public String USU_CLAVE;
    public String USU_CLAVE_ENCRIPTADA;
    public String USU_EMAIL;
    public String USU_CREACION = fecha;
    public String USU_ESTADO;
    public String USU_TIPO;
    /**/
    public Integer ID_DATO;
    public String DAT_NOMBRES;
    public String DAT_APELLIDOS;
    public String DAT_FOTO_PERFIL = "img/perfilImagen.png";
    public String DAT_TELEFONO;
    public String DAT_DIRECCION = "N/A";
    public String DAT_CIUDAD = "N/A";
    public String DAT_PAIS = "N/A";
    public String DAT_POSTAL = "170702";

    public RegistroUsuario() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        String strJson = request.getParameter("datosUsuario"); // obtiene lo enviado por AJAX
        JSONObject json = new JSONObject(strJson);
        USU_USUARIO = (String) json.get("usu-usuario");
        USU_CLAVE = e.generadorAleatorio(15);
        USU_CLAVE_ENCRIPTADA = e.encriptar(USU_CLAVE);//este guarda en la bd
        USU_EMAIL = (String) json.get("usu-email");
        DAT_NOMBRES = (String) json.get("dat-nombre");
        DAT_APELLIDOS = (String) json.get("dat-apellido");
        DAT_TELEFONO = (String) json.get("dat-telefono");
        usu.setUSU_USUARIO(USU_USUARIO);
        usu.setUSU_CLAVE("admin");
//        usu.setUSU_CLAVE(USU_CLAVE);
        usu.setUSU_EMAIL(USU_EMAIL);
        usu.setUSU_CREACION(USU_CREACION);
        usu.setUSU_ESTADO("VERIFICAR");
        usu.setUSU_TIPO("CLIENTE");
        ID_USUARIO_BASE = usuDao.consultarUsuario(USU_USUARIO);
        if (ID_USUARIO_BASE >= 1) {
            writer.print("¡Elige otro nombre de usuario!");
        } else {
            if (usuDao.add(usu) == "El usuario fue creado con exito!") {
                ID_USUARIO_BASE = usuDao.consultarUsuario(USU_USUARIO);
                dat.setID_USUARIO(ID_USUARIO);
                dat.setFK_USUARIO(ID_USUARIO_BASE);
                dat.setDAT_NOMBRES(DAT_NOMBRES);
                dat.setDAT_APELLIDOS(DAT_APELLIDOS);
                dat.setDAT_FOTO_PERFIL(DAT_FOTO_PERFIL);
                dat.setDAT_TELEFONO(DAT_TELEFONO);
                dat.setDAT_DIRECCION(DAT_DIRECCION);
                dat.setDAT_CIUDAD(DAT_CIUDAD);
                dat.setDAT_PAIS(DAT_PAIS);
                dat.setDAT_POSTAL(DAT_POSTAL);
                if (datDao.add(dat) == "Los datos del usuario fue creado con exito!") {
                    m.crearEmail("SNY - PAL", USU_EMAIL, "SNY - PAL (VERIFICAR CUENTA)", "CONFIRMA TU CUENTA", DAT_NOMBRES + " " + DAT_APELLIDOS, USU_USUARIO, USU_CLAVE);
                    m.sendEmail();
                    writer.print("¡Usuario creado, porfavor revisa tu correo!");
                } else if (datDao.add(dat) == "Los datos del usuario no fueron creados!") {
                    writer.print("El usuario no se pudo crear, porfavor verifica los datos correspondientes!");
                }
            } else if (usuDao.add(usu) == "El usuario no fue creado con exito!") {
                System.out.println("NO SE PUDO CREAR AL USUARIO");
                writer.print("¡No se pudo crear el usuario!");
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
