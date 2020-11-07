package fachadas;

import java.util.HashMap;

import model.autenticacao.ContaEmail;
import model.autenticacao.Membro;
import persistencia.xml.DAOXMLMembroConta;

public class Fachada1Membro {

	private static DAOXMLMembroConta membroXML = new DAOXMLMembroConta();
	
	/*
	 * TODO
	 * 2. pegue o email do membro e decida no TODO interno!
	 */
	public boolean adicionarMembroNoSistema(Membro membro,ContaEmail contaEmail){
		/*
		 * TODO
		 * 1. implementar pelo e-mail qual a abstracao de conta.
		 */
		membro.setContaEmail(contaEmail);
		if(membroXML.getMembro().size()==0){
			membro.setAdministrador(true);
		}
		return membroXML.criar(membro);
	}
	public boolean atualizarMembro(long idMembro,Membro membro){
		return membroXML.atualizar(idMembro, membro);
	}
	public Membro pesquisarMembro(long idMembro){
		return membroXML.pesquisarMembro(idMembro);
	}
	public static HashMap<Long, Membro> getMembro(){
		return membroXML.getMembro();
	}
	public void removerMembroDoSistema(long idMembro){
		membroXML.remover(idMembro);
	}
}
