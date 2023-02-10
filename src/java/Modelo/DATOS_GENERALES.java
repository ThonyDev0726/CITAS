package Modelo;

/**
 *
 * @author kamir
 */
public class DATOS_GENERALES extends USER{

    public DATOS_GENERALES() {
    }
    public Integer ID_DATO;
    public Integer FK_USUARIO;
    public String DAT_NOMBRES;
    public String DAT_APELLIDOS;
    public String DAT_FOTO_PERFIL;
    public String DAT_TELEFONO;
    public String DAT_DIRECCION;
    public String DAT_CIUDAD;
    public String DAT_PAIS;
    public String DAT_POSTAL;

    public Integer getID_DATO() {
        return ID_DATO;
    }

    public void setID_DATO(Integer ID_DATO) {
        this.ID_DATO = ID_DATO;
    }

    public String getDAT_NOMBRES() {
        return DAT_NOMBRES;
    }

    public void setDAT_NOMBRES(String DAT_NOMBRES) {
        this.DAT_NOMBRES = DAT_NOMBRES;
    }

    public String getDAT_APELLIDOS() {
        return DAT_APELLIDOS;
    }

    public void setDAT_APELLIDOS(String DAT_APELLIDOS) {
        this.DAT_APELLIDOS = DAT_APELLIDOS;
    }

    public String getDAT_FOTO_PERFIL() {
        return DAT_FOTO_PERFIL;
    }

    public void setDAT_FOTO_PERFIL(String DAT_FOTO_PERFIL) {
        this.DAT_FOTO_PERFIL = DAT_FOTO_PERFIL;
    }

    public String getDAT_TELEFONO() {
        return DAT_TELEFONO;
    }

    public void setDAT_TELEFONO(String DAT_TELEFONO) {
        this.DAT_TELEFONO = DAT_TELEFONO;
    }

    public String getDAT_DIRECCION() {
        return DAT_DIRECCION;
    }

    public void setDAT_DIRECCION(String DAT_DIRECCION) {
        this.DAT_DIRECCION = DAT_DIRECCION;
    }

    public String getDAT_CIUDAD() {
        return DAT_CIUDAD;
    }

    public void setDAT_CIUDAD(String DAT_CIUDAD) {
        this.DAT_CIUDAD = DAT_CIUDAD;
    }

    public String getDAT_PAIS() {
        return DAT_PAIS;
    }

    public void setDAT_PAIS(String DAT_PAIS) {
        this.DAT_PAIS = DAT_PAIS;
    }

    public String getDAT_POSTAL() {
        return DAT_POSTAL;
    }

    public void setDAT_POSTAL(String DAT_POSTAL) {
        this.DAT_POSTAL = DAT_POSTAL;
    }

    public Integer getFK_USUARIO() {
        return FK_USUARIO;
    }

    public void setFK_USUARIO(Integer FK_USUARIO) {
        this.FK_USUARIO = FK_USUARIO;
    }

    @Override
    public String toString() {
        return "DATOS_GENERALES{" + "ID_DATO=" + ID_DATO + ", FK_USUARIO=" + FK_USUARIO + ", DAT_NOMBRES=" + DAT_NOMBRES + ", DAT_APELLIDOS=" + DAT_APELLIDOS + ", DAT_FOTO_PERFIL=" + DAT_FOTO_PERFIL + ", DAT_TELEFONO=" + DAT_TELEFONO + ", DAT_DIRECCION=" + DAT_DIRECCION + ", DAT_CIUDAD=" + DAT_CIUDAD + ", DAT_PAIS=" + DAT_PAIS + ", DAT_POSTAL=" + DAT_POSTAL + '}';
    }
    
    

}
