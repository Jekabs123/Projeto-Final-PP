package model.autenticacao;

public class ContaEmail {
	
	private Conta conta;
	
	public ContaEmail(Conta conta) {
		this.setConta(conta);
	}
	
	public Membro autenticar(char[] login, char[] senha) {  //FALTA IMPLEMENTAR
		return null;
	}
	
	public boolean validarlogin(char[] login) {  //FALTA IMPLEMENTAR
		return true;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
