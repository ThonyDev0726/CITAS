package Interfaces;

import Modelo.TAREA;
import java.util.List;

/**
 *
 * @author KAMIR
 */
public interface CRUD_TAREA {

    public TAREA list(int idTarea);

    public String add(TAREA mp);

    public String update(TAREA mp);

    public String delete(int id);

    public String actualizaImportancia(int id, String estado);
}
