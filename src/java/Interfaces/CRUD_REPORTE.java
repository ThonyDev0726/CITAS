package Interfaces;

import Modelo.REPORTE;
import java.util.List;

/**
 *
 * @author KAMIR
 */
public interface CRUD_REPORTE {
    public List listar();

    public REPORTE list(int idReporte);

    public String add(REPORTE mp);

    public String update(REPORTE mp);

    public String delete(int id);

    public String actualizar_estado(int id, String estado);  
}
