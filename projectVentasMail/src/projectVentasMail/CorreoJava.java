package projectVentasMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class CorreoJava {

	
	public static String to = "edulo1528@gmail.com"; // edulo1528@gmail.com // colc.1608@gmail.com
	public	static String from = "edulo1528@gmail.com";
	public	static String password = "aptkaixbhwjwbtfg"; //aptkaixbhwjwbtfg // eduardo%15
	
	
	public static void EnviarCorreo(String para,String mensaje) {
	    
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
	    Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	      public PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(para, password);
	      }
	      });
	    try {
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(para));
	      message.setRecipients(Message.RecipientType.TO,
	        InternetAddress.parse(para));
	      message.setSubject("Testing Subject");
	      message.setText(mensaje);
	      Transport.send(message);
	    } catch (MessagingException e) {
	    	JOptionPane.showMessageDialog(null, "No se logro enviar el correo");
	      throw new RuntimeException(e);
	    }
	}
	
	
	public static void rootniteSSL(){
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	        "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	    	public PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication(to,password);
	        }
	      });
	    try {
	      Message message = new MimeMessage(session); 
	      message.setFrom(new InternetAddress(from));
	      message.setRecipients(Message.RecipientType.TO,
	          InternetAddress.parse(to));
	      message.setSubject("Testing Subject");
	      message.setText("Estimado cliente,");
	      Transport.send(message);
	      System.out.println("Enviado");
	    } catch (MessagingException e) {
	      throw new RuntimeException(e);
	    }
	}
}
