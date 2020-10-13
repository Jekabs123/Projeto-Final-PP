package model.autenticacao;

import model.projetos.Participacao;

public class Membro {
	
	private long matricula;
	private String nome;
	private boolean ativo;
	private char[] email;
	private boolean administrador;
	private ContaEmail contaEmail;
	private Participacao participacao;
	
	
	public ContaEmail getContaEmail() {
		return contaEmail;
	}

	public void setContaEmail(ContaEmail contaEmail) {
		this.contaEmail = contaEmail;
	}

	public void ativar() {
		if(participacao.getAtivo()==true){
			ativo = true;
		}
	}
	
	public void desativar() {
		if(participacao.getAtivo()==false){
			ativo = false;
		}
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
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

	public boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public Participacao getParticipacao() {
		return participacao;
	}

	public void setParticipacao(Participacao participacao) {
		this.participacao = participacao;
	}
	public char[] getLogin(){
		return contaEmail.getLogin();
	}
	public char[] getSenha(){
		return contaEmail.getSenha();
	}

}
