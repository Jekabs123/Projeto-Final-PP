package controller;

import fachadas.Fachada2Autenticacao;
import model.autenticacao.Membro;
import model.autenticacao.TipoProvedorAutenticacao;

public class ControllerTelaAutenticacao {
	private Fachada2Autenticacao fachada = new Fachada2Autenticacao();
	
	public Membro autenticarContaEmail(String login, String senha,TipoProvedorAutenticacao provedor){
		return fachada.autenticarContaEmailProvedor(login, senha, provedor);
	}
	
	public boolean validarLogin(String login, TipoProvedorAutenticacao provedor){
		return fachada.validarLoginProvedor(login, provedor);
	}
	
	public String cripotogafarSenha(String senha, TipoProvedorAutenticacao provedor){
		return fachada.criptografarSenhaEmailLivre(senha, provedor);
	}
}
 