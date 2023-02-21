package ModeloDao;

/**
 *
 * @author KAMIR
 */
import Convertidores.Encriptador;
import DataBase.CONEXION;
import Interfaces.CRUD_TAREA;
import Modelo.TAREA;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TAREA_DAO implements CRUD_TAREA {

    Encriptador enc = new Encriptador();
    TAREA c = new TAREA();
    CONEXION cn = new CONEXION();
    CallableStatement coneccion;
    Connection con;
    ResultSet rs;
    String LISTAR_IMPORTANTES = "CALL SELECT_TAREA_IMPORTANTES()";
    String LISTAR_HACER = "CALL SELECT_TAREA_POR_HACER()";
    String LISTAR_PROGRESO = "CALL  SELECT_TAREA_EN_PROGRESO()";
    String LISTAR_POCO_IMPORTANTES = "CALL SELECT_TAREA_POCO_IMPORTANTES()";
    String LISTAR_REALIZADAS = "CALL SELECT_TAREA_REALIZADAS()";
    String LISTAR_ID = "CALL SELECT_ID_TAREA(?)";
    String CREAR = "CALL INSERT_TAREA(?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_TAREA(?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_TAREA(?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE ESTADO()";
    String UPDATE_TAREA_IMPORTANCIA = "CALL UPDATE_TAREA_IMPORTANCIA(?,?)";

    public List listarImportantes() {
        ArrayList<TAREA> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            coneccion = con.prepareCall(LISTAR_IMPORTANTES);
            rs = coneccion.executeQuery();
            while (rs.next()) {
                TAREA cli = new TAREA();
                cli.setID_TAREA(rs.getInt(1));
                cli.setTA_FECHA_CREACION(rs.getString(2));
                cli.setTA_FECHA_VENCIMIENTO(rs.getString(3));
                cli.setTA_DESCRIPCION(rs.getString(4));
                cli.setTA_ESTADO(rs.getString(5));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS TAREAS" + ex);
        }
        System.out.println("SE ESTAN LISTANDO LAS TAREAS");
        return lista;
    }

    public List listarPorHacer() {
        ArrayList<TAREA> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            coneccion = con.prepareCall(LISTAR_HACER);
            rs = coneccion.executeQuery();
            while (rs.next()) {
                TAREA cli = new TAREA();
                cli.setID_TAREA(rs.getInt(1));
                cli.setTA_FECHA_CREACION(rs.getString(2));
                cli.setTA_FECHA_VENCIMIENTO(rs.getString(3));
                cli.setTA_DESCRIPCION(rs.getString(4));
                cli.setTA_ESTADO(rs.getString(5));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS TAREAS" + ex);
        }
        System.out.println("SE ESTAN LISTANDO LAS TAREAS");
        return lista;
    }

    public List listarEnProgreso() {
        ArrayList<TAREA> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            coneccion = con.prepareCall(LISTAR_PROGRESO);
            rs = coneccion.executeQuery();
            while (rs.next()) {
                TAREA cli = new TAREA();
                cli.setID_TAREA(rs.getInt(1));
                cli.setTA_FECHA_CREACION(rs.getString(2));
                cli.setTA_FECHA_VENCIMIENTO(rs.getString(3));
                cli.setTA_DESCRIPCION(rs.getString(4));
                cli.setTA_ESTADO(rs.getString(5));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS TAREAS" + ex);
        }
        System.out.println("SE ESTAN LISTANDO LAS TAREAS");
        return lista;
    }

    public List listarPocoImportantes() {
        ArrayList<TAREA> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            coneccion = con.prepareCall(LISTAR_POCO_IMPORTANTES);
            rs = coneccion.executeQuery();
            while (rs.next()) {
                TAREA cli = new TAREA();
                cli.setID_TAREA(rs.getInt(1));
                cli.setTA_FECHA_CREACION(rs.getString(2));
                cli.setTA_FECHA_VENCIMIENTO(rs.getString(3));
                cli.setTA_DESCRIPCION(rs.getString(4));
                cli.setTA_ESTADO(rs.getString(5));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS TAREAS" + ex);
        }
        System.out.println("SE ESTAN LISTANDO LAS TAREAS");
        return lista;
    }

    public List listarRealizadas() {
        ArrayList<TAREA> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            coneccion = con.prepareCall(LISTAR_REALIZADAS);
            rs = coneccion.executeQuery();
            while (rs.next()) {
                TAREA cli = new TAREA();
                cli.setID_TAREA(rs.getInt(1));
                cli.setTA_FECHA_CREACION(rs.getString(2));
                cli.setTA_FECHA_VENCIMIENTO(rs.getString(3));
                cli.setTA_DESCRIPCION(rs.getString(4));
                cli.setTA_ESTADO(rs.getString(5));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS TAREAS" + ex);
        }
        System.out.println("SE ESTAN LISTANDO LAS TAREAS");
        return lista;
    }

    public TAREA list(int idTarea) {
        try {
            con = (Connection) cn.getConexion();
            coneccion = con.prepareCall(LISTAR_ID);
            coneccion.setInt(1, idTarea);
            rs = coneccion.executeQuery();
            while (rs.next()) {
                c.setID_TAREA(rs.getInt(1));
                c.setTA_FECHA_CREACION(rs.getString(2));
                c.setTA_FECHA_VENCIMIENTO(rs.getString(3));
                c.setTA_DESCRIPCION(rs.getString(4));
                c.setTA_IMPORTANCIA(rs.getString(5));
                c.setTA_ESTADO(rs.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS TAREAS" + ex);
        }
        return c;
    }

    public String add(TAREA mp) {
        try {
            con = (Connection) cn.getConexion();
            coneccion = con.prepareCall(CREAR);
            coneccion.setInt(1, mp.getFK_USUARIO());
            coneccion.setString(2, mp.getTA_FECHA_CREACION());
            coneccion.setString(3, mp.getTA_FECHA_VENCIMIENTO());
            coneccion.setString(4, mp.getTA_DESCRIPCION());
            coneccion.setString(5, mp.getTA_IMPORTANCIA());
            coneccion.setString(6, mp.getTA_ESTADO());
            coneccion.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR LA TAREA");
            System.out.println(ex);
            return "La Tarea no fue creada con exito!";
        }
        return "La Tarea fue creadada con exito!";
    }

    public String update(TAREA mp) {
        try {
            con = (Connection) cn.getConexion();
            coneccion = con.prepareCall(ACTUALIZAR);
            coneccion.setInt(1, mp.getID_TAREA());
            coneccion.setInt(2, mp.getFK_USUARIO());
            coneccion.setString(3, mp.getTA_FECHA_CREACION());
            coneccion.setString(4, mp.getTA_FECHA_VENCIMIENTO());
            coneccion.setString(5, mp.getTA_DESCRIPCION());
            coneccion.setString(6, mp.getTA_IMPORTANCIA());
            coneccion.setString(7, mp.getTA_ESTADO());
            coneccion.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR LA TAREA");
            System.out.println(ex);
            return "La Tarea no fue actualizada!";
        }
        return "La Tarea fue actualizada con exito!";
    }

    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println(ELIMINAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la Tarea!");
            System.out.println(ex);
            return "Error al eliminar la Tarea!";
        }
        return "La Tarea fue eliminada con exito!";
    }

    public String actualizaImportancia(int id, String importancia) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(UPDATE_TAREA_IMPORTANCIA);
            cs.setInt(1, id);
            cs.setString(2, importancia);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL DAR DE BAJA A LA TAREA");
            System.out.println(ex);
            return "Error al dar baja a la Tarea!";
        }
        return "La Tarea fue dada de baja con exito!";
    }

}
