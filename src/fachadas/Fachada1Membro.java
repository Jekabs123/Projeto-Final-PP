package fachadas;

import java.util.HashMap;

import model.autenticacao.ContaEmail;
import model.autenticacao.ContaEmailLivre;
import model.autenticacao.Membro;
import persistenciaXML.DAOXMLMembroConta;

public class Fachada1Membro {

	private static DAOXMLMembroConta membroXML = new DAOXMLMembroConta();
	
	public boolean adicionarMembroNoSistema(Membro membro,ContaEmail contaEmail){
			
		if (contaEmail instanceof ContaEmailLivre) {
			((ContaEmailLivre) contaEmail).criptografarSenha(contaEmail.getSenha());
		}
		
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
