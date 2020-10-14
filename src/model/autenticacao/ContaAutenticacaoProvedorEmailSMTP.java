package model.autenticacao;

import java.util.HashMap;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import fachadasCasoDeUso.Fachada1Membro;
import fachadasCasoDeUso.Fachada6MembroEmail;
import persistencia.xml.DAOXMLMembroConta;

public class ContaAutenticacaoProvedorEmailSMTP extends Conta{
	
	private char[] provedorHost;
	private char[] provedorPorta;

	@Override
	public Membro autenticar(char[] login, char[] senha) { 
		
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
			HashMap<Long, Membro> membros = Fachada1Membro.getMembro();
			for(int i = 0;i<=membros.size();i++){
				if(membros.get(i).getLogin().equals(login)&&
				   membros.get(i).getSenha().equals(senha)){
					return membros.get(i);
				}
			}
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
