package model.autenticacao;

public class ContaEmail {
	
	private Conta conta;
	
	public ContaEmail(Conta conta) {
		this.setConta(conta);
	}
	
	public Membro autenticar(char[] login, char[] senha) {  
		return conta.autenticar(login, senha);
	}
	
	public boolean validarlogin(char[] login) { 
		if(login.length<6){
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
   public char[] getLogin(){
	   return conta.getLogin();
   }
   public char[] getSenha(){
	   return conta.getSenha();
   }
   public void setTipoAutenticacao(TipoProvedorAutenticacao tipo){
	   conta.setTipo(tipo);
   }
   public TipoProvedorAutenticacao getTipoAutenticacao(){
	   return conta.getTipo();
   }
}
