package model.autenticacao;

import java.nio.file.attribute.PosixFileAttributeView;

import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class ContaAutenticacaoProvedorEmailSMTP extends Conta{
	
	private char[] provedorHost;
	private char[] provedorPorta;

	@Override
	public Membro autenticar(char[] login, char[] senha) {  //FALTA IMPLEMENTAR
		
		SimpleEmail email = new SimpleEmail();
		String host = new String(provedorHost);
		String porta = new String(provedorPorta);
		email.setHostName(host);
		email.setSslSmtpPort(porta);
		String loginEmail = new String(login);
		String senhaEmail = new String(senha);
		email.setAuthenticator( new DefaultAuthenticator(loginEmail, senhaEmail) );
		try {
			email.setFrom(loginEmail);
		} catch (EmailException e) {
			
		}
		return null;
	}

	public char[] getProvedorHost() {
		return provedorHost;
	}

	public void setProvedorHost(char[] provedorHost) {
		this.provedorHost = provedorHost;
	}

	public char[] getProvedorPorta() {
		return provedorPorta;
	}

	public void setProvedorPorta(char[] provedorPorta) {
		this.provedorPorta = provedorPorta;
	}

}
