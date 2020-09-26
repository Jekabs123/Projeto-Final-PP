package model.autenticacao;

public class Membro {
	
	private long matricula;
	private char[] nome;
	private boolean ativo;
	private char[] email;
	private boolean administrador;
	
	public void ativar() {    //FALTA IMPLEMENTAR
		
	}
	
	public void desativar() {  //FALTA IMPLEMENTAR
		
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public char[] getNome() {
		return nome;
	}

	public void setNome(char[] nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public char[] getEmail() {
		return email;
	}

	public void setEmail(char[] email) {
		this.email = email;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

}
