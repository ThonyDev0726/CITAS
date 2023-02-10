package Modelo;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author kamir
 */
public class EMAIL {

    public EMAIL() {
    }
    public Integer ID_EMAIL;
    public Integer FK_USUARIO;
    public String EMA_ASUNTO;
    public String EMA_DESCRIPCION;
    public String EMA_ARCHIVO_1;
    public String EMA_ARCHIVO_2;

    public Integer getID_EMAIL() {
        return ID_EMAIL;
    }

    public void setID_EMAIL(Integer ID_EMAIL) {
        this.ID_EMAIL = ID_EMAIL;
    }

    public Integer getFK_USUARIO() {
        return FK_USUARIO;
    }

    public void setFK_USUARIO(Integer FK_USUARIO) {
        this.FK_USUARIO = FK_USUARIO;
    }

    public String getEMA_ASUNTO() {
        return EMA_ASUNTO;
    }

    public void setEMA_ASUNTO(String EMA_ASUNTO) {
        this.EMA_ASUNTO = EMA_ASUNTO;
    }

    public String getEMA_DESCRIPCION() {
        return EMA_DESCRIPCION;
    }

    public void setEMA_DESCRIPCION(String EMA_DESCRIPCION) {
        this.EMA_DESCRIPCION = EMA_DESCRIPCION;
    }

    public String getEMA_ARCHIVO_1() {
        return EMA_ARCHIVO_1;
    }

    public void setEMA_ARCHIVO_1(String EMA_ARCHIVO_1) {
        this.EMA_ARCHIVO_1 = EMA_ARCHIVO_1;
    }

    public String getEMA_ARCHIVO_2() {
        return EMA_ARCHIVO_2;
    }

    public void setEMA_ARCHIVO_2(String EMA_ARCHIVO_2) {
        this.EMA_ARCHIVO_2 = EMA_ARCHIVO_2;
    }
    
}
