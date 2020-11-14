package fachadas;

import java.util.ArrayList;

import model.autenticacao.ContaEmail;
import model.autenticacao.ContaEmailLivre;
import model.autenticacao.Membro;
import persistenciaXML.DAOXMLMembroConta;

public class Fachada1Membro {

	private static DAOXMLMembroConta membroXML = new DAOXMLMembroConta();
	
	public void adicionarMembroNoSistema(Membro membro,ContaEmail contaEmail){
			
		if (contaEmail instanceof ContaEmailLivre) {
			((ContaEmailLivre) contaEmail).criptografarSenha(contaEmail.getSenha());
		}
		
		membro.setContaEmail(contaEmail);
		
		if(membroXML.getMembro().size()==0){
			membro.setAdministrador(true);
		}
		membroXML.criar(membro);
	}
	public void atualizarMembro(){
		membroXML.atualizar();
	}
	public Membro pesquisarMembro(long matricula){
		return membroXML.pesquisarMembro(matricula);
	}
	public static ArrayList<Membro> getMembro(){
		return membroXML.getMembro();
	}
	public void removerMembroDoSistema(long matricula){
		membroXML.remover(matricula);
	}
}
