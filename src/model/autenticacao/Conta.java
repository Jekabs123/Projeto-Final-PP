package model.autenticacao;

public abstract class Conta {

	private TipoProvedorAutenticacao tipo;
	/*
	 * TODO
	 * 1. Implemente como String aqui e onde mais houver arrays de char[] no projeto.
	 * 2. esses atributos devem dicar no supertipo abstracao
	 */
	private char[] login;
	private char[] senha;

	public abstract Membro autenticar(char[] login, char[] senha);

	/*
	 * TODO
	 * 1. Desnecessario esse metodo.
	 */
	public TipoProvedorAutenticacao getTipo() {
		return tipo;
	}

	/*
	 * TODO
	 * 1. Desnecessario esse metodo.
	 */
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
