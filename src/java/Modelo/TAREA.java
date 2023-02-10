package Modelo;

/**
 *
 * @author KAMIR
 */
public class TAREA {

    public Integer ID_TAREA;
    public Integer FK_USUARIO;
    public String TA_FECHA_CREACION;
    public String TA_FECHA_VENCIMIENTO;
    public String TA_DESCRIPCION;
    public String TA_IMPORTANCIA;
    public String TA_ESTADO;

    public TAREA(Integer FK_USUARIO, String TA_FECHA_CREACION, String TA_FECHA_VENCIMIENTO, String TA_DESCRIPCION, String TA_IMPORTANCIA, String TA_ESTADO) {
        this.FK_USUARIO = FK_USUARIO;
        this.TA_FECHA_CREACION = TA_FECHA_CREACION;
        this.TA_FECHA_VENCIMIENTO = TA_FECHA_VENCIMIENTO;
        this.TA_DESCRIPCION = TA_DESCRIPCION;
        this.TA_IMPORTANCIA = TA_IMPORTANCIA;
        this.TA_ESTADO = TA_ESTADO;
    }
    

    public TAREA() {
    }

    public Integer getID_TAREA() {
        return ID_TAREA;
    }

    public void setID_TAREA(Integer ID_TAREA) {
        this.ID_TAREA = ID_TAREA;
    }

    public Integer getFK_USUARIO() {
        return FK_USUARIO;
    }

    public void setFK_USUARIO(Integer FK_USUARIO) {
        this.FK_USUARIO = FK_USUARIO;
    }

    public String getTA_FECHA_CREACION() {
        return TA_FECHA_CREACION;
    }

    public void setTA_FECHA_CREACION(String TA_FECHA_CREACION) {
        this.TA_FECHA_CREACION = TA_FECHA_CREACION;
    }

    public String getTA_FECHA_VENCIMIENTO() {
        return TA_FECHA_VENCIMIENTO;
    }

    public void setTA_FECHA_VENCIMIENTO(String TA_FECHA_VENCIMIENTO) {
        this.TA_FECHA_VENCIMIENTO = TA_FECHA_VENCIMIENTO;
    }

    public String getTA_DESCRIPCION() {
        return TA_DESCRIPCION;
    }

    public void setTA_DESCRIPCION(String TA_DESCRIPCION) {
        this.TA_DESCRIPCION = TA_DESCRIPCION;
    }

    public String getTA_ESTADO() {
        return TA_ESTADO;
    }

    public void setTA_ESTADO(String TA_ESTADO) {
        this.TA_ESTADO = TA_ESTADO;
    }

    public String getTA_IMPORTANCIA() {
        return TA_IMPORTANCIA;
    }

    public void setTA_IMPORTANCIA(String TA_IMPORTANCIA) {
        this.TA_IMPORTANCIA = TA_IMPORTANCIA;
    }

}
