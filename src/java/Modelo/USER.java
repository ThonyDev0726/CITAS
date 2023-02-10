package Modelo;

import Convertidores.Encriptador;

/**
 *
 * @author kamir
 */
public class USER {

    public USER() {
    }

    public Integer ID_USUARIO;
    public String USU_USUARIO;
    public String USU_CLAVE;
    public String USU_EMAIL;
    public String USU_CREACION;
    public String USU_ESTADO;
    public String USU_TIPO;

    public Integer getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(Integer ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getUSU_USUARIO() {
        return USU_USUARIO;
    }

    public void setUSU_USUARIO(String USU_USUARIO) {
        this.USU_USUARIO = USU_USUARIO;
    }

    public String getUSU_CLAVE() {
        return USU_CLAVE;
    }

    public void setUSU_CLAVE(String USU_CLAVE) {
        this.USU_CLAVE = USU_CLAVE;
    }

    public String getUSU_CREACION() {
        return USU_CREACION;
    }

    public void setUSU_CREACION(String USU_CREACION) {
        this.USU_CREACION = USU_CREACION;
    }

    public String getUSU_ESTADO() {
        return USU_ESTADO;
    }

    public void setUSU_ESTADO(String USU_ESTADO) {
        this.USU_ESTADO = USU_ESTADO;
    }

    public String getUSU_TIPO() {
        return USU_TIPO;
    }

    public void setUSU_TIPO(String USU_TIPO) {
        this.USU_TIPO = USU_TIPO;
    }

    public String getUSU_EMAIL() {
        return USU_EMAIL;
    }

    public void setUSU_EMAIL(String USU_EMAIL) {
        this.USU_EMAIL = USU_EMAIL;
    }

}
