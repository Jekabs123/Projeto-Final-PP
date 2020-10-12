package model.autenticacao;

public class FachadaAutenticacao {
	
	private Conta contaSMTP = new ContaAutenticacaoProvedorEmailSMTP();
	private Conta contaInterno = new ContaAutenticacaoProvedorInterno();
	private ContaEmail contaEmail;
	
	public void criptografarSenhaEmailLivreProvedorEmailSMTP(char[] senha) {
		ContaEmailLivre contaEmailLivre = (ContaEmailLivre) contaEmail;
		contaEmailLivre = new ContaEmailLivre(contaSMTP);
		contaEmailLivre.criptografarSenha(senha);
		
	}
	
	public void criptografarSenhaEmailLivreProvedorInterno(char[] senha) {
		ContaEmailLivre contaEmailLivre = (ContaEmailLivre) contaEmail;
		contaEmailLivre = new ContaEmailLivre(contaInterno);
		contaEmailLivre.criptografarSenha(senha);
		
	}
	
	//Usando abstracao default
	public void autenticarContaEmailProvedorEmailSMTP(char[] login, char[] senha) {
		contaEmail = new ContaEmail(contaSMTP);
		contaEmail.autenticar(login, senha); 
	}
	
	public void autenticarContaEmailProvedorInterno(char[] login, char[] senha) {
		contaEmail = new ContaEmail(contaInterno);
		contaEmail.autenticar(login, senha);
	}
	
	public void validarLoginProvedorEmailSMTP(char[] login) {
		contaEmail = new ContaEmail(contaSMTP);
		contaEmail.validarlogin(login);
	}
	
	public void validarLoginProvedorInterno(char[] login) {
		contaEmail = new ContaEmail(contaInterno);
		contaEmail.validarlogin(login);
	}
	
	
	//usando abstracao EmailLivre
	public void autenticarContaEmailLivreProvedorEmailSMTP(char[] login, char[] senha) {
		contaEmail = new ContaEmailLivre(contaSMTP);
		contaEmail.autenticar(login, senha); 
	}
	
	public void autenticarContaEmailLivreProvedorInterno(char[] login, char[] senha) {
		contaEmail = new ContaEmailLivre(contaInterno);
		contaEmail.autenticar(login, senha);
	}
	
	public void validarLoginLivreProvedorEmailSMTP(char[] login) {
		contaEmail = new ContaEmailLivre(contaSMTP);
		contaEmail.validarlogin(login);
	}
	
	public void validarLoginLivreProvedorInterno(char[] login) {
		contaEmail = new ContaEmailLivre(contaInterno);
		contaEmail.validarlogin(login);
	}
	
	
	//usando abstracao EmailIFPB
	public void autenticarContaEmailIFPBProvedorEmailSMTP(char[] login, char[] senha) {
		contaEmail = new ContaEmailIFPB(contaSMTP);
		contaEmail.autenticar(login, senha); 
	}
	
	public void autenticarContaEmailIFPBProvedorInterno(char[] login, char[] senha) {
		contaEmail = new ContaEmailIFPB(contaInterno);
		contaEmail.autenticar(login, senha);
	}
	
	public void validarLoginIFPBProvedorEmailSMTP(char[] login) {
		contaEmail = new ContaEmailIFPB(contaSMTP);
		contaEmail.validarlogin(login);
	}
	
	public void validarLoginIFPBProvedorInterno(char[] login) {
		contaEmail = new ContaEmailIFPB(contaInterno);
		contaEmail.validarlogin(login);
	}

}
