package ModeloDao;

import Convertidores.Encriptador;
import DataBase.CONEXION;
import Interfaces.CRUD_USUARIO;
import Modelo.USER;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAMIR
 */
public class USUARIO_DAO implements CRUD_USUARIO {

    /* ========= VARIABLES GLOBALES ========= */
    Encriptador enc = new Encriptador();
    USER u = new USER();
    CONEXION cn = new CONEXION();
    CallableStatement callableStament;
    Connection con;
    ResultSet resultado;

    /* ========= VARIABLES PROCEDIMIENTOS ========= */
    String CONSULTAR_USUARIO = "CALL U_S_ID_USUARIO(?)";
    String CONSULTAR_CLAVE = "CALL U_S_USU_CLAVE(?)";
    String CONSULTAR_CARGO = "CALL U_S_USU_PARAMETRO(?)";
    String CONSULTAR_ESTADO = "CALL U_S_USU_ESTADO(?)";
    String LISTAR = "CALL SELECT_ALL_USUARIO()";
    String LISTAR_ID = "CALL A_S_ID_USUARIO(?)";
    String CREAR = "CALL INSERT_USUARIO(?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_USUARIO(?,?,?,?,?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE_USU_ESTADO(?,?)";
    String ACTUALIZAR_CLAVE = "CALL UPDATE_CLAVE(?,?)";
    String ELIMINAR = "CALL DELETE_USUARIO(?)";

    /* ========= VARIABLES PROCEDIMIENTOS PARAMETROS ========= */
    Integer ID_USUARIO;
    String CLAVE = "";
    String CARGO = "";
    String ESTADO = "";

    /* =================== LOGIN =================== */
    @Override
    public Integer consultarUsuario(String USU_USUARIO) {
        try {
            ID_USUARIO = 0;
            con = (Connection) cn.getConexion();
            callableStament = con.prepareCall(CONSULTAR_USUARIO);
            callableStament.setString(1, USU_USUARIO);
            resultado = callableStament.executeQuery();
            while (resultado.next()) {
                ID_USUARIO = Integer.parseInt(resultado.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("ID_USUARIO no encontrado: " + ex);
            return 0;
        }
        return ID_USUARIO;
    }

    @Override
    public String obtenerClave(int ID_USUARIO) {
        try {
            con = (Connection) cn.getConexion();
            callableStament = con.prepareCall(CONSULTAR_CLAVE);
            callableStament.setInt(1, ID_USUARIO);
            resultado = callableStament.executeQuery();
            while (resultado.next()) {
                CLAVE = resultado.getString(1);
            }
        } catch (Exception e) {
            System.out.println("USU_CLAVE no encontrada: " + e);
        }
        return CLAVE;
    }

    @Override
    public String consultarCargo(int ID_USUARIO) {
        try {
            con = (Connection) cn.getConexion();
            callableStament = con.prepareCall(CONSULTAR_CARGO);
            callableStament.setInt(1, ID_USUARIO);
            resultado = callableStament.executeQuery();
            while (resultado.next()) {
                CARGO = resultado.getString(1);
            }
        } catch (Exception e) {
            System.out.println("USU_CARGO no encontrada: " + e);
        }
        return CARGO;
    }

    @Override
    public String consultarEstado(int ID_USUARIO) {
        try {
            con = (Connection) cn.getConexion();
            callableStament = con.prepareCall(CONSULTAR_ESTADO);
            callableStament.setInt(1, ID_USUARIO);
            resultado = callableStament.executeQuery();
            while (resultado.next()) {
                ESTADO = resultado.getString(1);
            }
        } catch (Exception e) {
            System.out.println("USU_ESTADO no encontrado: " + e);
        }
        System.out.println(ESTADO);
        return ESTADO;
    }

    /* ==================================== 
            CRUD 
    ==================================== */
    @Override
    public List listar() {
        ArrayList<USER> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            callableStament = con.prepareCall(LISTAR);
            resultado = callableStament.executeQuery();
            while (resultado.next()) {
                USER user = new USER();
                user.setID_USUARIO(resultado.getInt(1));
                user.setUSU_USUARIO(resultado.getString(2));
                user.setUSU_CLAVE(resultado.getString(3));
                user.setUSU_EMAIL(resultado.getString(4));
                user.setUSU_CREACION(resultado.getString(5));
                user.setUSU_ESTADO(resultado.getString(6));
                user.setUSU_TIPO(resultado.getString(7));
                lista.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS USUARIOS " + ex);
        }
        System.out.println("SE ESTAN LISTANDO LOS USUARIOS");
        return lista;
    }

    @Override
    public USER list(int idUsuario) {
        try {
            con = (Connection) cn.getConexion();
            callableStament = con.prepareCall(LISTAR_ID);
            callableStament.setInt(1, idUsuario);
            resultado = callableStament.executeQuery();
            while (resultado.next()) {
                u.setID_USUARIO(resultado.getInt(1));
                u.setUSU_USUARIO(resultado.getString(2));
                u.setUSU_CLAVE(enc.desencriptar(resultado.getString(3)));
                u.setUSU_EMAIL(resultado.getString(4));
                u.setUSU_CREACION(resultado.getString(5));
                u.setUSU_ESTADO(resultado.getString(6));
                u.setUSU_TIPO(resultado.getString(7));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS EMPLEADOS" + ex);
        }
        return u;
    }

    @Override
    public String add(USER parametroUsuario) {
        try {
            con = (Connection) cn.getConexion();
            callableStament = con.prepareCall(CREAR);
            callableStament.setString(1, parametroUsuario.getUSU_USUARIO());
            callableStament.setString(2, enc.encriptar(parametroUsuario.getUSU_CLAVE()));
            callableStament.setString(3, parametroUsuario.getUSU_EMAIL());
            callableStament.setString(4, parametroUsuario.getUSU_CREACION());
            callableStament.setString(5, parametroUsuario.getUSU_ESTADO());
            callableStament.setString(6, parametroUsuario.getUSU_TIPO());
            callableStament.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL USUARIO");
            System.out.println(ex);
            return "El usuario no fue creado con exito!";
        }
        return "El usuario fue creado con exito!";
    }

    @Override
    public String update(USER usuarioParametro) {
        try {
            con = (Connection) cn.getConexion();
            callableStament = con.prepareCall(ACTUALIZAR);
            callableStament.setInt(1, usuarioParametro.getID_USUARIO());
            callableStament.setString(2, enc.encriptar(usuarioParametro.getUSU_CLAVE()));
            callableStament.setString(3, usuarioParametro.getUSU_EMAIL());
            callableStament.setString(4, usuarioParametro.getUSU_ESTADO());
            callableStament.setString(5, usuarioParametro.getUSU_TIPO());
            callableStament.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL USUARIO");
            System.out.println(ex);
            return "El usuario no fue actualizado!";
        }
        return "El usuario fue actualizado con exito!";
    }

    @Override
    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println(ELIMINAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el cliente!");
            System.out.println(ex);
            return "Error al eliminar el usuario!";
        }
        return "El usuario fue eliminado con exito!";
    }

    @Override
    public String actualizar_estado(int id, String estado) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR_ESTADO);
            cs.setInt(1, id);
            cs.setString(2, estado);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL DAR DE BAJA AL USUARIO");
            System.out.println(ex);
            return "Error al dar baja al usuario!";
        }
        return "El usuario fue dado de baja con exito!";
    }

    @Override
    public String update_password(int id, String password) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR_CLAVE);
            cs.setInt(1, id);
            cs.setString(2, enc.encriptar(password));
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR CLAVE DEL USUARIO");
            System.out.println(ex);
            return "Error al actualizar clave del usuario!";
        }
        return "La clave del usaurios se actualizo con con exito!";
    }

}
