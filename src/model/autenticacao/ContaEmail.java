package model.autenticacao;

import org.apache.commons.mail.EmailException;

public class ContaEmail {
	
	private Conta conta;
	
	private String login;
	private String senha;
	
	public ContaEmail(Conta conta) {
		this.setConta(conta);
	}
	
	public Membro autenticar(String login, String senha) throws EmailException {  
		return conta.autenticar(login, senha);
	}
	
	public boolean validarlogin(String login) { 
		if(login.length()<6){
			return false;
		}
		return true;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
