package model.autenticacao;

import java.util.ArrayList;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import fachadas.Fachada1Membro;

public class ContaAutenticacaoProvedorEmailSMTP extends Conta{
	
	private String provedorHost;
	private String provedorPorta;

	@Override
	public Membro autenticar(String login, String senha) { 
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName(provedorHost);
		email.setSslSmtpPort(provedorPorta);
		email.setAuthenticator( new DefaultAuthenticator(login, senha) );
		try {
			email.setFrom(login);
			ArrayList<Membro> membrosList = Fachada1Membro.getMembro();
				for(Membro m: membrosList){
					if(m.getLogin().equals(login)&&
							m.getSenha().equals(senha)){
						System.out.println("membro achado");
						return m;
					}
				}
		} catch (EmailException e) {
			e.printStackTrace();
		}
		System.out.println("nenhum membro");
		return null;
	}

	public String getProvedorHost() {
		return provedorHost;
	}

	public void setProvedorHost(String provedorHost) {
		this.provedorHost = provedorHost;
	}

	public String getProvedorPorta() {
		return provedorPorta;
	}

	public void setProvedorPorta(String provedorPorta) {
		this.provedorPorta = provedorPorta;
	}

}
