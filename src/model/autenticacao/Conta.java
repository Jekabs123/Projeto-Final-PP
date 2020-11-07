package model.autenticacao;

public abstract class Conta {
	
	private TipoProvedorAutenticacao tipo;
	 
	public abstract Membro autenticar(String login, String senha);


}
