package model.autenticacao;

public abstract class Conta {

	private TipoProvedorAutenticacao tipo;
	/*
	 * TODO
	 * 2. esses atributos devem dicar no supertipo abstracao
	 * Giuseppe ta doido, já ta no supertipo abstrato kkkkkk
	 */
	private String login;
	private String senha;

	public abstract Membro autenticar(String login, String senha);


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
