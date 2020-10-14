package fachadasCasoDeUso;

import model.autenticacao.Conta;
import model.autenticacao.ContaAutenticacaoProvedorEmailSMTP;
import model.autenticacao.ContaAutenticacaoProvedorInterno;
import model.autenticacao.ContaEmail;
import model.autenticacao.ContaEmailIFPB;
import model.autenticacao.ContaEmailLivre;
import model.autenticacao.Membro;

public class Fachada2Autenticacao {
	
	private Conta contaSMTP = new ContaAutenticacaoProvedorEmailSMTP();
	private Conta contaInterno = new ContaAutenticacaoProvedorInterno();
	private ContaEmail contaEmail;
	
	public char[] criptografarSenhaEmailLivreProvedorEmailSMTP(char[] senha) {
		ContaEmailLivre contaEmailLivre = (ContaEmailLivre) contaEmail;
		contaEmailLivre = new ContaEmailLivre(contaSMTP);
		return contaEmailLivre.criptografarSenha(senha);
		
	}
	
	public char[] criptografarSenhaEmailLivreProvedorInterno(char[] senha) {
		ContaEmailLivre contaEmailLivre = (ContaEmailLivre) contaEmail;
		contaEmailLivre = new ContaEmailLivre(contaInterno);
		return contaEmailLivre.criptografarSenha(senha);
		
	}
	
	//Usando abstracao default
	public Membro autenticarContaEmailProvedorEmailSMTP(char[] login, char[] senha) {
		contaEmail = new ContaEmail(contaSMTP);
		return contaEmail.autenticar(login, senha); 
	}
	
	public Membro autenticarContaEmailProvedorInterno(char[] login, char[] senha) {
		contaEmail = new ContaEmail(contaInterno);
		return contaEmail.autenticar(login, senha);
	}
	
	public boolean validarLoginProvedorEmailSMTP(char[] login) {
		contaEmail = new ContaEmail(contaSMTP);
		return contaEmail.validarlogin(login);
	}
	
	public boolean validarLoginProvedorInterno(char[] login) {
		contaEmail = new ContaEmail(contaInterno);
		return contaEmail.validarlogin(login);
	}
	
	
	//usando abstracao EmailLivre
	public Membro autenticarContaEmailLivreProvedorEmailSMTP(char[] login, char[] senha) {
		contaEmail = new ContaEmailLivre(contaSMTP);
		return contaEmail.autenticar(login, senha); 
	}
	
	public Membro autenticarContaEmailLivreProvedorInterno(char[] login, char[] senha) {
		contaEmail = new ContaEmailLivre(contaInterno);
		return contaEmail.autenticar(login, senha);
	}
	
	public boolean validarLoginLivreProvedorEmailSMTP(char[] login) {
		contaEmail = new ContaEmailLivre(contaSMTP);
		return contaEmail.validarlogin(login);
	}
	
	public boolean validarLoginLivreProvedorInterno(char[] login) {
		contaEmail = new ContaEmailLivre(contaInterno);
		return contaEmail.validarlogin(login);
	}
	
	
	//usando abstracao EmailIFPB
	public Membro autenticarContaEmailIFPBProvedorEmailSMTP(char[] login, char[] senha) {
		contaEmail = new ContaEmailIFPB(contaSMTP);
		return contaEmail.autenticar(login, senha); 
	}
	
	public Membro autenticarContaEmailIFPBProvedorInterno(char[] login, char[] senha) {
		contaEmail = new ContaEmailIFPB(contaInterno);
		return contaEmail.autenticar(login, senha);
	}
	
	public boolean validarLoginIFPBProvedorEmailSMTP(char[] login) {
		contaEmail = new ContaEmailIFPB(contaSMTP);
		return contaEmail.validarlogin(login);
	}
	
	public boolean validarLoginIFPBProvedorInterno(char[] login) {
		contaEmail = new ContaEmailIFPB(contaInterno);
		return contaEmail.validarlogin(login);
	}

}
