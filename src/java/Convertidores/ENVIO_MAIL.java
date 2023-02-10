package Convertidores;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author kamir
 */
public class ENVIO_MAIL {

    public ENVIO_MAIL() {
        mProperties = new Properties();
    }
    private static String emailFrom = "dolareuro619@gmail.com";
    private static String passwordFrom = "dorlrlbixbuadlwi";
    private String emailTo;
    private String subject;
//    private String content;

    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    public void crearEmail(
            String empresa,
            String destinatarioEmail,
            String asunto,
            String operacion,
            String nomApe,
            String usuario,
            String clave
    ) {
        emailTo = destinatarioEmail;
        subject = asunto;
//        content = mensaje;
        // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom, empresa));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
//            mCorreo.setText(content, "ISO-8859-1", "html");
            mCorreo.setText("<center>"
                    + "<div  style=\""
                    + " background-color:#E9F1FB;\n"
                    + "	border-radius:15px;\n"
                    + "	display:inline-block;\n"
                    + "	cursor:pointer;\n"
                    + "	font-family:Arial;\n"
                    + "	font-size:15px;\n"
                    + "	padding:10px 15px;\n"
                    + "	cursor:pointer;\n"
                    + "	text-decoration:none;\n"
                    + "	width:20rem;\n"
                    + "	text-shadow:0px 1px 0px #2f6627;"
                    + "\">"
                    + "<center>"
                    + "<h2 style=\""
                    + "	color:#000;\n"
                    + "\"> "
                    + operacion
                    + "</h2><br/>"
                    + "</center>"
                    + "<div style=\""
                    + "align-content: left;"
                    + "width= 100%"
                    + "\">"
                    + "<span>Estimad@ <b>" + nomApe + "</b>,</span><br>"
                    + "<span>Esta es una notificacion automatica para poder validar la creacion de la cuenta en <b>" + empresa + "</b>.</span><br><br>"
                    + "<span><b>Usuario: </b>" + usuario + "</span><br>"
                    + "<span><b>Contraseña temporal: </b>" + clave + "</span><br>"
                    + "</div>"
                    + "<br>"
                    + "<br>"
                    + ""
                    + "<center>"
                    + "<a href='http://192.168.100.4:8080/ECOMMERCE/CONTROLLER?accion=iniciar-sesion' style=\""
                    + "background-color:#08AAFA;\n"
                    + "	border-radius:28px;\n"
                    + "	display:inline-block;\n"
                    + "	cursor:pointer;\n"
                    + "	color:#fff;\n"
                    + "	font-family:Arial;\n"
                    + "	font-size:15px;\n"
                    + "	padding:10px 15px;\n"
                    + "	cursor:pointer;\n"
                    + "	text-decoration:none;\n"
                    + "	text-shadow:0px 1px 0px #2f6627;"
                    + "\"> "
                    //TEXTO DEL BOTON
                    + "INICIAR SESION"
                    + "</a> <br><br>"
                    + "</center>"
                    + "</center>", "ISO-8859-1", "html");

        } catch (AddressException ex) {
            Logger.getLogger(ENVIO_MAIL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ENVIO_MAIL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ENVIO_MAIL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ENVIO_MAIL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ENVIO_MAIL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
