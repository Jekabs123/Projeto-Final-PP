package model.autenticacao;

import org.apache.commons.mail.EmailException;

public abstract class Conta {
	
	private TipoProvedorAutenticacao tipo;
	 
	public abstract Membro autenticar(String login, String senha) throws EmailException;


}
