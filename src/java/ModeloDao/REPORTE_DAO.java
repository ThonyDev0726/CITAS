package ModeloDao;
import Interfaces.CRUD_REPORTE;
import Modelo.REPORTE;
import java.util.List;
import Convertidores.Encriptador;
import DataBase.CONEXION;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author KAMIR
 */

public class REPORTE_DAO {
    Encriptador enc = new Encriptador();
    REPORTE c = new REPORTE();
    CONEXION cn = new CONEXION();
    CallableStatement cs;
    Connection con;
    ResultSet rs;
    String LISTAR = "Call SELECT_REPORTE()"; 
    String LISTAR_ID = "CALL SELEC_ID()"; 
    String CREAR = "CREATE SELEC_ID()"; 
    String ACTUALIZAR = "UPDATE SELEC_ID()"; 
    String ELIMINAR = "DELETE SELEC_ID()"; 
    String ACTUALIZAR_ESTADO = "UPDATE ESTADO()"; 
    

    public List listar() {
         ArrayList<REPORTE> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                REPORTE cli = new REPORTE();
                cli.setID_REPORTE(rs.getInt(1));
                cli.setREP_CREACION (rs.getString(2));
                cli.setREP_HORA (rs.getString(3));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS TAREAS" + ex);
        }
        System.out.println("SE ESTAN LISTANDO LAS TAREAS");
        return lista;
    }


    public REPORTE list(int idReporte) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, idReporte);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setID_REPORTE(rs.getInt(1));
                c.setREP_CREACION (rs.getString(2));
                c.setREP_HORA(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS REPORTES" + ex);
        }
        return c;
    }


    public String add(REPORTE mp) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setString(1, mp.getREP_CREACION());
            cs.setString(2, mp.getREP_HORA());

            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR LA TAREA");
            System.out.println(ex);
            return "La Tarea no fue creada con exito!";
        }
        return "La Tarea fue creadada con exito!";  
    }


    public String update(REPORTE mp) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, c.getID_REPORTE());
            cs.setString(2, c.getREP_CREACION());
            cs.setString(3, c.getREP_HORA());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL REPORTE");
            System.out.println(ex);
            return "El Reporte no fue actualizado!";
        }
        return "El Reporte fue actualizado con exito!"; 
    }


    public String delete(int id) {
       try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println(ELIMINAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar El Reporte!");
            System.out.println(ex);
            return "Error al eliminar El Reporte!";
        }
        return "El Reporte fue eliminado con exito!";
    }


    public String actualizar_estado(int id, String estado) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR_ESTADO);
            cs.setInt(1, id);
            cs.setString(2, estado);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL DAR DE BAJA EL REPORTE ");
            System.out.println(ex);
            return "Error al dar baja El Reporte!";
        }
        return "El Reporte fue dado de baja con exito!";
    }
    
}
