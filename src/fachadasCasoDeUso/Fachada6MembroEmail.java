package fachadasCasoDeUso;

import java.util.HashMap;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;
import model.projetos.Participacao;
import model.projetos.Projeto;
import persistencia.xml.DAOXMLMembroConta;
/**
 * @author INATHAN e PAULO - TATAKAE!
 * Fachada para a classe membro
 */
public class Fachada6MembroEmail {
	
	/**
	 * {@link #membroCoordenador} Atributo que representar membro coordenador
	 */
	private Membro membroCoordenador;
	/**
	 * Esse e o construtor que seta o membro que vai ser administrador, atravez do construtor
	 * @param membroCoordenador: é o Membro que vai ser o administrador
	 */
	public Fachada6MembroEmail(Membro membroCoordenador) {          
		this.membroCoordenador = membroCoordenador;
	}
	
	/**
	 * Esse método adiciona o membro no projeto
	 * @param membro: membro que vai ser adicionado ao projeto
	 * @param projeto: projeto em que o membro vai ser adicionado
	 * @param adicionado: dá a informação que o membro foi adicionado
	 */
	public void adicionarMembro(Membro membro, Projeto projeto, String adicionado) { 
		adicionado = "adicionado";
		if(membroCoordenador.getParticipacao().isCoordenador() == true) {   //Verifico se quem chamou a fachada é realmente um coordenador
			if (membro.getContaEmail() != null) {
				try {
					projeto.adicionar(membro);
					enviarEmailInfo(projeto.getNome(), adicionado, membroCoordenador.getNome());
				} catch (ExceptionMembroDuplicado e) {
					System.out.println("Membro duplicado");
				}
			}
			
		}else {
			System.out.println("Apenas coordenadores podem adicionar membros!");
		}
	
	}
	
	/**
	 * Esse método remove o membro do projeto
	 * @param membro: membro que vai ser removido
	 * @param projeto: projeto que o membro vai ser removido
	 * @param removido: dá a informação que o membro foi removido
	 * @return: retorna true se foi removido com sucesso e false se não
	 */
	public boolean removerMembro(Membro membro, Projeto projeto, String removido) {
		removido = "removido";
		if(membroCoordenador.getParticipacao().isCoordenador() == true) {
			for (int i = 0; i < projeto.getMembros().size(); i++) {
				if(projeto.getMembros().get(i).equals(membro)) {
					projeto.getMembros().remove(membro);
					enviarEmailInfo(projeto.getNome(), removido, membroCoordenador.getNome());
					return true;
				}
			}
		}else {
			System.out.println("Apenas coordenadores podem remover membros!");
		}
		
		return false;
		
	}
	
	/**
	 * Esse método envia um e-mail
	 * @param projetoNome: é o nome do projeto que o membro está
	 * @param info: é a informação em que o membro se encontra
	 * @param corrdenadorNome: é o nome do coordenador do projeto em que o membro se encontra
	 * @return
	 */
	private boolean enviarEmailInfo(String projetoNome, String info, String coordenadorNome) {
		String assunto = "Projeto: " + projetoNome;
		String mensagem = "Você foi "+ info +" no projeto por "+ coordenadorNome;

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
}
