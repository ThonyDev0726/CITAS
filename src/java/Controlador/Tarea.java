package Controlador;

import Modelo.TAREA;
import ModeloDao.TAREA_DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.json.JSONObject;

public class Tarea extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("LoginLogger");
    String REGISTRO = "Vista/Cliente/dashboard.jsp";
//========================================================================================== VARIABLES GLOBALES     
    public Integer ID_TAREA;
    public Integer FK_USUARIO;
    public String TA_FECHA_CREACION = LocalDate.now().toString();
    public String TA_FECHA_VENCIMIENTO;
    public String TA_DESCRIPCION;
    public String TA_IMPORTANCIA;
    public String TA_ESTADO;
//========================================================================================== VARIABLES TABLA BD E INTERFAZ
    TAREA tar = new TAREA();
    TAREA_DAO dao = new TAREA_DAO();

    public Tarea() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        String strJson = request.getParameter("tareaDatos"); // obtiene lo enviado por AJAX
        JSONObject json = new JSONObject(strJson);
        FK_USUARIO = 1;
        TA_FECHA_CREACION = LocalDate.now().toString();
        TA_FECHA_VENCIMIENTO = (String) json.get("txtVencimiento");
        TA_DESCRIPCION = (String) json.get("txtDescripcion");
        TA_IMPORTANCIA = "POR HACER";
        TA_ESTADO = "EN LINEA";
        if (dao.add(new TAREA(FK_USUARIO, TA_FECHA_CREACION, TA_FECHA_VENCIMIENTO, TA_DESCRIPCION, TA_IMPORTANCIA, TA_ESTADO)).equalsIgnoreCase("La Tarea fue creadada con exito!")) {
            writer.print("Tarea creada");
        } else if (dao.add(new TAREA(FK_USUARIO, TA_FECHA_CREACION, TA_FECHA_VENCIMIENTO, TA_DESCRIPCION, TA_IMPORTANCIA, TA_ESTADO)).equalsIgnoreCase("La Tarea no fue creada con exito!")) {
            writer.print("No se pudo crear la tarea");
        }
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String acceso = "";
        String action = request.getParameter("accion");
        switch (action) {
            case "marcar-progreso":
                dao.actualizaImportancia(Integer.parseInt(request.getParameter("idTarea")), "EN PROGRESO");
                acceso = REGISTRO;
                break;
            case "marcar-hecho":
                dao.actualizaImportancia(Integer.parseInt(request.getParameter("idTarea")), "REALIZADO");
                acceso = REGISTRO;
                break;
            default:
                throw new AssertionError();
        }
        RequestDispatcher v = request.getRequestDispatcher(acceso);
        v.forward(request, response);
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
