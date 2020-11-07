package model.autenticacao;

public class ContaEmail {
	
	private Conta conta;
	
	public ContaEmail(Conta conta) {
		this.setConta(conta);
	}
	
	public Membro autenticar(String login, String senha) {  
		return conta.autenticar(login, senha);
	}
	
	public boolean validarlogin(String login) { 
		if(login.length()<6){
			return false;
		}
		return true;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
   public String getLogin(){
	   return conta.getLogin();
   }
   public String getSenha(){
	   return conta.getSenha();
   }
}
