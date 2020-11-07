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

	/*
	 * TODO
	 * 1. recomendo retirar pois nao eh util para clientes saberem qual
	 * bridge a abstracao esta usando, depois de setada.
	 */
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
   
   /*
    * TODO
    * 1. Desnecessario esse metodo.
    */
   public void setTipoAutenticacao(TipoProvedorAutenticacao tipo){
	   conta.setTipo(tipo);
   }
   
   /*
    * TODO
    * 1. Desnecessario esse metodo.
    */
   public TipoProvedorAutenticacao getTipoAutenticacao(){
	   return conta.getTipo();
   }
}
