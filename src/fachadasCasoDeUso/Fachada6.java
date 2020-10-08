package fachadasCasoDeUso;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.autenticacao.Membro;

//Falta Terminar
public class Fachada6 {
	
	Membro membro = new Membro();
	
	public void adicionarMembro(Membro membro) {
		String mensagem = "adicionado";
	}
	
	public void removerMembro(Membro membro/*(conta)*/) {
		String mensagem = "removido";
		
		
	}
	
	private boolean enviarEmailInfo(String info) {
		String assunto = "Projeto: " + info;
		String mensagem = "Você foi adicionado/removido do projeto por Inathan.";

		String email = "projetoads07@gmail.com";  //projetoads07@gmail.com
		String senha = "ProjetoAd$";                  //ProjetoAd$

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(email, senha);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@vendajava.pp.ads"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject(assunto);
			message.setText(mensagem);

			Transport.send(message);
			System.out.println("Mensagem enviada");
			return true;
		} catch (MessagingException e) {
			System.out.println("Falhou");
			return false;
		}
	}
	
	public static void main(String[] args) {
		Fachada6 email = new Fachada6();
		email.enviarEmailInfo("PP");
	}

}
