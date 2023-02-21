package Controlador;

import ModeloDao.TAREA_DAO;
import Modelo.TAREA;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActualizarTarea extends HttpServlet {

    public Integer ID_TAREA;
    public Integer FK_USUARIO;
    public String TA_FECHA_CREACION;
    public String TA_FECHA_VENCIMIENTO;
    public String TA_DESCRIPCION;
    public String TA_IMPORTANCIA;
    public String TA_ESTADO;
    public String REGISTROS = "Vista/Cliente/dashboard.jsp";

    // 
    TAREA_DAO dao = new TAREA_DAO();
    TAREA tarea = new TAREA();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        switch (action) {
            case "Actualizar":
                ID_TAREA = Integer.parseInt(request.getParameter("txtIdTarea"));
                System.out.println("Tarea id" + ID_TAREA);
                TA_FECHA_CREACION = request.getParameter("txtTaFechaCreacion");
                TA_FECHA_VENCIMIENTO = request.getParameter("txtTaFechaVencimiento");
                TA_DESCRIPCION = request.getParameter("txtTaDescripcion");
                TA_IMPORTANCIA = request.getParameter("txtTaImportancia");
                TA_ESTADO = "EN LINEA";
                FK_USUARIO = 1;
//                tarea = new TAREA(
//                        ID_TAREA,
//                        FK_USUARIO,
//                        TA_FECHA_CREACION,
//                        TA_FECHA_VENCIMIENTO,
//                        TA_DESCRIPCION,
//                        TA_IMPORTANCIA,
//                        TA_ESTADO);
                tarea.setID_TAREA(ID_TAREA);
                tarea.setFK_USUARIO(FK_USUARIO);
                tarea.setTA_DESCRIPCION(TA_DESCRIPCION);
                tarea.setTA_ESTADO(TA_ESTADO);
                tarea.setTA_FECHA_CREACION(TA_FECHA_CREACION);
                tarea.setTA_FECHA_VENCIMIENTO(TA_FECHA_VENCIMIENTO);
                tarea.setTA_IMPORTANCIA(TA_IMPORTANCIA);
                dao.update(tarea);
                acceso = REGISTROS;
                break;
            default:
                throw new AssertionError();
        }
        RequestDispatcher v = request.getRequestDispatcher(acceso);
        v.forward(request, response);
    }
}
