package Controlador;

import Convertidores.Encriptador;
import Modelo.DATOS_GENERALES;
import Modelo.USER;
import ModeloDao.DATOS_GENERALES_DAO;
import ModeloDao.USUARIO_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author kamir
 */
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("LoginLogger");

    //DATOS A UTILIZAR
    Integer ID_USUARIO_BASE;
    String USUARIO;
    String USU_TIPO;
    String USU_ESTADO;
    String CLAVE;
    String CLAVE_BASE = "";
    String CLAVE_DESENCRIPTADA = "";
    //OBJETOS
    DATOS_GENERALES DAT_USU = new DATOS_GENERALES();
    DATOS_GENERALES_DAO datDao = new DATOS_GENERALES_DAO();
    USER usuario = new USER();
    USUARIO_DAO usuDao = new USUARIO_DAO();
    Encriptador enc = new Encriptador();
    //RUTAS
    String LOGIN = "Vista/Login.jsp";
    String ADMINISTRADOR = "Vista/Administrador/dashboard.jsp";
    String CLIENTE = "Vista/Cliente/dashboard.jsp";
    String VERIFICAR = "Vista/Verificar.jsp";

    String ACTUALIZAR_CLI = "Vista/Cliente/dashboard.jsp";
    String ACTUALIZAR_ADMIN = "Vista/Administrador/perfil.jsp";

    public Login() {
        super();
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        String strJson = request.getParameter("datosUsuario"); // obtiene lo enviado por AJAX
        JSONObject json = new JSONObject(strJson);
        USUARIO = (String) json.get("usuario");
        CLAVE = (String) json.get("clave");
        HttpSession sesion = request.getSession();
        //========================================================================================== GLOBALES

        ID_USUARIO_BASE = usuDao.consultarUsuario(USUARIO);
        if (ID_USUARIO_BASE >= 1) {
            CLAVE_BASE = usuDao.obtenerClave(ID_USUARIO_BASE);
            CLAVE_DESENCRIPTADA = enc.desencriptar(CLAVE_BASE);
            if (CLAVE.equalsIgnoreCase(CLAVE_DESENCRIPTADA)) {
                USU_ESTADO = usuDao.consultarEstado(ID_USUARIO_BASE);
                switch (USU_ESTADO) {
                    case "VERIFICAR":
                        USU_TIPO = usuDao.consultarCargo(ID_USUARIO_BASE);
                        switch (USU_TIPO) {
                            case "ADMINISTRADOR":
                                System.out.println("CARGO ADMINISTRADOR");
                                writer.print("¡Verificar!");
                                break;
                            case "CLIENTE":
                                System.out.println("CARGO CLIENTE");
                                writer.print("¡Verificar!");
                                break;
                            default:
                                System.out.println("CARGO NO RECONOCIDO");
                                writer.print("¡Cargo no reconocido!");
                        }
                        break;
                    case "ACTUALIZAR":
                        USU_TIPO = usuDao.consultarCargo(ID_USUARIO_BASE);
                        switch (USU_TIPO) {
                            case "ADMINISTRADOR":
                                System.out.println("CARGO ADMINISTRADOR");
                                DAT_USU = datDao.list(ID_USUARIO_BASE);
                                DAT_USU.setDAT_NOMBRES(DAT_USU.getDAT_NOMBRES());
                                DAT_USU.setDAT_APELLIDOS(DAT_USU.getDAT_APELLIDOS());
                                DAT_USU.setDAT_FOTO_PERFIL(DAT_USU.getDAT_FOTO_PERFIL());
                                DAT_USU.setDAT_TELEFONO(DAT_USU.getDAT_TELEFONO());
                                DAT_USU.setDAT_DIRECCION(DAT_USU.getDAT_DIRECCION());
                                DAT_USU.setDAT_CIUDAD(DAT_USU.getDAT_CIUDAD());
                                DAT_USU.setDAT_PAIS(DAT_USU.getDAT_PAIS());
                                DAT_USU.setDAT_POSTAL(DAT_USU.getDAT_POSTAL());
                                DAT_USU.setUSU_USUARIO(USUARIO);
                                DAT_USU.setUSU_CLAVE(CLAVE);
                                DAT_USU.setUSU_TIPO(USU_TIPO);
                                DAT_USU.setUSU_ESTADO(USU_ESTADO);
                                DAT_USU.setFK_USUARIO(ID_USUARIO_BASE);
                                DAT_USU.toString();
                                request.getSession().setAttribute("idUsuario", ID_USUARIO_BASE);
                                request.setAttribute("idUsuario", ID_USUARIO_BASE);
                                request.getSession().setAttribute("usuNombre", DAT_USU.getDAT_NOMBRES());
                                request.getSession().setAttribute("usuApellido", DAT_USU.getDAT_APELLIDOS());
                                request.getSession().setAttribute("usuFoto", DAT_USU.getDAT_FOTO_PERFIL());
                                request.getSession().setAttribute("usuTelefono", DAT_USU.getDAT_TELEFONO());
                                request.getSession().setAttribute("usuDireccion", DAT_USU.getDAT_DIRECCION());
                                request.getSession().setAttribute("usuCiudad", DAT_USU.getDAT_CIUDAD());
                                request.getSession().setAttribute("usuPais", DAT_USU.getDAT_PAIS());
                                request.getSession().setAttribute("usuPostal", DAT_USU.getDAT_POSTAL());
                                sesion.setAttribute("usuario", DAT_USU);
                                writer.print("¡Acceso correcto - administrador perfil!");
                                break;
                            case "CLIENTE":
                                DAT_USU = datDao.list(ID_USUARIO_BASE);
                                DAT_USU.setDAT_NOMBRES(DAT_USU.getDAT_NOMBRES());
                                DAT_USU.setDAT_APELLIDOS(DAT_USU.getDAT_APELLIDOS());
                                DAT_USU.setDAT_FOTO_PERFIL(DAT_USU.getDAT_FOTO_PERFIL());
                                DAT_USU.setDAT_TELEFONO(DAT_USU.getDAT_TELEFONO());
                                DAT_USU.setDAT_DIRECCION(DAT_USU.getDAT_DIRECCION());
                                DAT_USU.setDAT_CIUDAD(DAT_USU.getDAT_CIUDAD());
                                DAT_USU.setDAT_PAIS(DAT_USU.getDAT_PAIS());
                                DAT_USU.setDAT_POSTAL(DAT_USU.getDAT_POSTAL());
                                DAT_USU.setUSU_USUARIO(USUARIO);
                                DAT_USU.setUSU_CLAVE(CLAVE);
                                DAT_USU.setUSU_TIPO(USU_TIPO);
                                DAT_USU.setUSU_ESTADO(USU_ESTADO);
                                DAT_USU.setFK_USUARIO(ID_USUARIO_BASE);
                                System.out.println(DAT_USU.toString());
//                                request.setAttribute("idUsuario", ID_USUARIO_BASE);
                                request.getSession().setAttribute("idUsuario", ID_USUARIO_BASE);
                                request.getSession().setAttribute("usuNombre", DAT_USU.getDAT_NOMBRES());
                                request.getSession().setAttribute("usuApellido", DAT_USU.getDAT_APELLIDOS());
                                request.getSession().setAttribute("usuFoto", DAT_USU.getDAT_FOTO_PERFIL());
                                request.getSession().setAttribute("usuTelefono", DAT_USU.getDAT_TELEFONO());
                                request.getSession().setAttribute("usuDireccion", DAT_USU.getDAT_DIRECCION());
                                request.getSession().setAttribute("usuCiudad", DAT_USU.getDAT_CIUDAD());
                                request.getSession().setAttribute("usuPais", DAT_USU.getDAT_PAIS());
                                request.getSession().setAttribute("usuPostal", DAT_USU.getDAT_POSTAL());
                                sesion.setAttribute("usuario", DAT_USU);
                                writer.print("¡Acceso correcto - cliente perfil!");
                                break;
                            default:
                                System.out.println("CARGO NO RECONOCIDO");
                                writer.print("¡Cargo no reconocido!");
                        }
                        break;
                    case "EN LINEA":
                        USU_TIPO = usuDao.consultarCargo(ID_USUARIO_BASE);
                        switch (USU_TIPO) {
                            case "ADMINISTRADOR":
                                DAT_USU = datDao.list(ID_USUARIO_BASE);
                                DAT_USU.setDAT_NOMBRES(DAT_USU.getDAT_NOMBRES());
                                DAT_USU.setDAT_APELLIDOS(DAT_USU.getDAT_APELLIDOS());
                                DAT_USU.setDAT_FOTO_PERFIL(DAT_USU.getDAT_FOTO_PERFIL());
                                DAT_USU.setDAT_TELEFONO(DAT_USU.getDAT_TELEFONO());
                                DAT_USU.setDAT_DIRECCION(DAT_USU.getDAT_DIRECCION());
                                DAT_USU.setDAT_CIUDAD(DAT_USU.getDAT_CIUDAD());
                                DAT_USU.setDAT_PAIS(DAT_USU.getDAT_PAIS());
                                DAT_USU.setDAT_POSTAL(DAT_USU.getDAT_POSTAL());
                                DAT_USU.setUSU_USUARIO(USUARIO);
                                DAT_USU.setUSU_CLAVE(CLAVE);
                                DAT_USU.setUSU_TIPO(USU_TIPO);
                                DAT_USU.setUSU_ESTADO(USU_ESTADO);
                                DAT_USU.setFK_USUARIO(ID_USUARIO_BASE);
                                DAT_USU.toString();
//                                request.setAttribute("idUsuario", ID_USUARIO_BASE);
                                request.getSession().setAttribute("idUsuario", ID_USUARIO_BASE);
                                request.getSession().setAttribute("usuNombre", DAT_USU.getDAT_NOMBRES());
                                request.getSession().setAttribute("usuApellido", DAT_USU.getDAT_APELLIDOS());
                                request.getSession().setAttribute("usuFoto", DAT_USU.getDAT_FOTO_PERFIL());
                                request.getSession().setAttribute("usuTelefono", DAT_USU.getDAT_TELEFONO());
                                request.getSession().setAttribute("usuDireccion", DAT_USU.getDAT_DIRECCION());
                                request.getSession().setAttribute("usuCiudad", DAT_USU.getDAT_CIUDAD());
                                request.getSession().setAttribute("usuPais", DAT_USU.getDAT_PAIS());
                                request.getSession().setAttribute("usuPostal", DAT_USU.getDAT_POSTAL());
                                sesion.setAttribute("usuario", DAT_USU);
                                writer.print("¡Acceso correcto - administrador!");
                                break;
                            case "CLIENTE":
                                System.out.println("CARGO CLIENTE");
                                System.out.println("ID USUARIOOOOO " + ID_USUARIO_BASE);

                                DAT_USU = datDao.list(ID_USUARIO_BASE);
                                DAT_USU.setDAT_NOMBRES(DAT_USU.getDAT_NOMBRES());
                                DAT_USU.setDAT_APELLIDOS(DAT_USU.getDAT_APELLIDOS());
                                DAT_USU.setDAT_FOTO_PERFIL(DAT_USU.getDAT_FOTO_PERFIL());
                                DAT_USU.setDAT_TELEFONO(DAT_USU.getDAT_TELEFONO());
                                DAT_USU.setDAT_DIRECCION(DAT_USU.getDAT_DIRECCION());
                                DAT_USU.setDAT_CIUDAD(DAT_USU.getDAT_CIUDAD());
                                DAT_USU.setDAT_PAIS(DAT_USU.getDAT_PAIS());
                                DAT_USU.setDAT_POSTAL(DAT_USU.getDAT_POSTAL());
                                DAT_USU.setUSU_USUARIO(USUARIO);
                                DAT_USU.setUSU_CLAVE(CLAVE);
                                DAT_USU.setUSU_TIPO(USU_TIPO);
                                DAT_USU.setUSU_ESTADO(USU_ESTADO);
                                DAT_USU.setFK_USUARIO(ID_USUARIO_BASE);
                                DAT_USU.toString();
                                request.getSession().setAttribute("idUsuario", ID_USUARIO_BASE);
                                request.getSession().setAttribute("usuNombre", DAT_USU.getDAT_NOMBRES());
                                request.getSession().setAttribute("usuApellido", DAT_USU.getDAT_APELLIDOS());
                                request.getSession().setAttribute("usuFoto", DAT_USU.getDAT_FOTO_PERFIL());
                                request.getSession().setAttribute("usuTelefono", DAT_USU.getDAT_TELEFONO());
                                request.getSession().setAttribute("usuDireccion", DAT_USU.getDAT_DIRECCION());
                                request.getSession().setAttribute("usuCiudad", DAT_USU.getDAT_CIUDAD());
                                request.getSession().setAttribute("usuPais", DAT_USU.getDAT_PAIS());
                                request.getSession().setAttribute("usuPostal", DAT_USU.getDAT_POSTAL());
                                sesion.setAttribute("usuario", DAT_USU);
                                writer.print("¡Acceso correcto - cliente!");
                                break;
                            default:
                                System.out.println("CARGO NO RECONOCIDO");
                                writer.print("¡Cargo no reconocido!");
                        }
                        break;
                    case "BLOQUEDO":
                        System.out.println("EL USUARIO ESTA BLOQUEDO");
                        writer.print("¡El usuario esta bloquedo!");
                        break;
                    default:
                        System.out.println("NO SE RECONOCE ESTE ESTADO");
                        request.getRequestDispatcher(LOGIN).forward(request, response);
                }
            } else {
                System.out.println("¡La clave es incorrecta!");
                writer.print("¡La clave es incorrecta!");
            }
        } else {
            System.out.println("No existe este usuario");
            writer.print("¡No existe este usuario!");
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
}
