package Interfaces;

import Modelo.USER;
import java.util.List;

/**
 *
 * @author kamir
 */
public interface CRUD_USUARIO {

    public List listar();

    public USER list(int idUsuario);

    public String add(USER mp);

    public String update(USER mp);

    public String delete(int id);

    public String actualizar_estado(int id, String estado);

    /* =========== INICIO DE SESION =========== */
    public Integer consultarUsuario(String USU_USUARIO);

    public String obtenerClave(int ID_USUARIO);

    public String consultarCargo(int ID_USUARIO);

    public String consultarEstado(int ID_USUARIO);

    /* =========== ACTUALIZAR CLAVE =========== */
    public String update_password(int ID_USUARIO, String clave);
}
