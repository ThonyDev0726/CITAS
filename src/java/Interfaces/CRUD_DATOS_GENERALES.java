package Interfaces;

import Modelo.DATOS_GENERALES;
import java.util.List;

/**
 *
 * @author kamir
 */
public interface CRUD_DATOS_GENERALES {

    public List listar();

    public DATOS_GENERALES list(int idUsuario);

    public String add(DATOS_GENERALES mp);

    public String update(DATOS_GENERALES mp);

    public String delete(int id);

    public String actualizar_estado(int id, String estado);

}
