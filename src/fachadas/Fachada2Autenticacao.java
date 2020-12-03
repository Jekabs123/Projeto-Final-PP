package fachadas;

import org.apache.commons.mail.EmailException;

import model.autenticacao.Conta;
import model.autenticacao.ContaAutenticacaoProvedorEmailSMTP;
import model.autenticacao.ContaAutenticacaoProvedorInterno;
import model.autenticacao.ContaEmail;
import model.autenticacao.ContaEmailLivre;
import model.autenticacao.Membro;
import model.autenticacao.TipoProvedorAutenticacao;

public class Fachada2Autenticacao {
	
	private Conta contaSMTP = new ContaAutenticacaoProvedorEmailSMTP();
	private Conta contaInterno = new ContaAutenticacaoProvedorInterno();
	private ContaEmail contaEmail;
	
	public String criptografarSenhaEmailLivre(String senha,TipoProvedorAutenticacao provedor) {
		ContaEmailLivre contaEmailLivre = (ContaEmailLivre) contaEmail;
		if(provedor == TipoProvedorAutenticacao.EMAIL_SMTP){
			contaEmailLivre = new ContaEmailLivre(contaSMTP);
		}else{
			contaEmailLivre = new ContaEmailLivre(contaInterno);
		}
		return contaEmailLivre.criptografarSenha(senha);
		
	}
	
	public Membro autenticarContaEmailProvedor(String login, String senha, TipoProvedorAutenticacao provedor) throws EmailException {
		if(provedor == TipoProvedorAutenticacao.EMAIL_SMTP){
			contaEmail = new ContaEmail(contaSMTP);
		}else{
			contaEmail = new ContaEmail(contaInterno);
		}
		return contaEmail.autenticar(login, senha); 
	}
	
	public boolean validarLoginProvedor(String login, TipoProvedorAutenticacao provedor) {
		if(provedor == TipoProvedorAutenticacao.EMAIL_SMTP){
			contaEmail = new ContaEmail(contaSMTP);
		}else{
			contaEmail = new ContaEmail(contaInterno);
		}
		return contaEmail.validarlogin(login);
	}
}
