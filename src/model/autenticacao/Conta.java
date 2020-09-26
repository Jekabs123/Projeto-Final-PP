package model.autenticacao;

public abstract class Conta {
	
	private TipoProvedorAutenticacao tipo;
	private char[] login;
	private char[] senha;
	
	public abstract Membro autenticar(char[] login, char[] senha);

	public TipoProvedorAutenticacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoProvedorAutenticacao tipo) {
		this.tipo = tipo;
	}

	public char[] getLogin() {
		return login;
	}

	public void setLogin(char[] login) {
		this.login = login;
	}

	public char[] getSenha() {
		return senha;
	}

	public void setSenha(char[] senha) {
		this.senha = senha;
	}

}
