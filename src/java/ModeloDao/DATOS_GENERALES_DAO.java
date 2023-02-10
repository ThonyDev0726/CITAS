package ModeloDao;

import DataBase.CONEXION;
import Interfaces.CRUD_DATOS_GENERALES;
import Modelo.DATOS_GENERALES;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamir
 */
public class DATOS_GENERALES_DAO implements CRUD_DATOS_GENERALES {

    DATOS_GENERALES datos_generales = new DATOS_GENERALES();
    CONEXION cn = new CONEXION();
    CallableStatement cs;
    Connection con;
    ResultSet rs;
    /* ========= VARIABLES PROCEDIMIENTOS ========= */
    String CONSULTAR_USUARIO = "CALL U_S_ID_USUARIO(?)";
    String CONSULTAR_CLAVE = "CALL U_S_USU_CLAVE(?)";
    String CONSULTAR_CARGO = "CALL U_S_USU_PARAMETRO(?)";
    String CONSULTAR_ESTADO = "CALL U_S_USU_ESTADO(?)";
    String LISTAR = "CALL SELECT_ALL_USUARIO()";
    String LISTAR_ID = "CALL SELECT_DATO_USUARIO_ID(?)";
    String CREAR = "CALL INSERT_DATOS_GENERALES(?,?,?,?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_DATA_USU(?,?,?,?,?,?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE_USUARIO_ESTADO(?,?)";
    String ELIMINAR = "CALL DELETE_USUARIO(?)";

    @Override
    public List listar() {
        ArrayList<DATOS_GENERALES> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                DATOS_GENERALES cli = new DATOS_GENERALES();
                cli.setID_USUARIO(rs.getInt(1));
                cli.setUSU_USUARIO(rs.getString(2));
                cli.setUSU_CLAVE(rs.getString(3));
                cli.setUSU_EMAIL(rs.getString(4));
                cli.setUSU_CREACION(rs.getString(5));
                cli.setUSU_ESTADO(rs.getString(6));
                cli.setUSU_TIPO(rs.getString(7));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS USUARIOS" + ex);
        }
        System.out.println("SE ESTAN LISTANDO LOS USUARIOS");
        return lista;
    }

    @Override
    public DATOS_GENERALES list(int idUsuario) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            while (rs.next()) {
                datos_generales.setDAT_NOMBRES(rs.getString(3));
                datos_generales.setDAT_APELLIDOS(rs.getString(4));
                datos_generales.setDAT_FOTO_PERFIL(rs.getString(5));
                datos_generales.setDAT_TELEFONO(rs.getString(6));
                datos_generales.setDAT_DIRECCION(rs.getString(7));
                datos_generales.setDAT_CIUDAD(rs.getString(8));
                datos_generales.setDAT_PAIS(rs.getString(9));
                datos_generales.setDAT_POSTAL(rs.getString(10));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS EMPLEADOS" + ex);
        }
        return datos_generales;
    }

    @Override
    public String add(DATOS_GENERALES mp) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setInt(1, mp.getFK_USUARIO());
            cs.setString(2, mp.getDAT_NOMBRES());
            cs.setString(3, mp.getDAT_APELLIDOS());
            cs.setString(4, mp.getDAT_FOTO_PERFIL());
            cs.setString(5, mp.getDAT_TELEFONO());
            cs.setString(6, mp.getDAT_DIRECCION());
            cs.setString(7, mp.getDAT_CIUDAD());
            cs.setString(8, mp.getDAT_PAIS());
            cs.setString(9, mp.getDAT_POSTAL());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR LOS DATOS DEL USUARIO");
            System.out.println(ex);
            return "Los datos del usuario no fueron creados!";
        }
        return "Los datos del usuario fue creado con exito!";
    }

    @Override
    public String update(DATOS_GENERALES mp) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, mp.getFK_USUARIO());
            cs.setString(2, mp.getDAT_TELEFONO());
            cs.setString(3, mp.getDAT_CIUDAD());
            cs.setString(4, mp.getDAT_PAIS());
            cs.setString(5, mp.getDAT_POSTAL());
            cs.setString(6, mp.getDAT_DIRECCION());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR LOS DATOS DEL USUARIO");
            System.out.println(ex);
            return "no se actualizo";
        }
        return "Se actualizaron con exito";
    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String actualizar_estado(int id, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
