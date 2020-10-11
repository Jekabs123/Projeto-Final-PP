package fachadasCasoDeUso;

import model.autenticacao.Membro;
import model.projetos.Projeto;
import persistencia.xml.DAOXMLProjetoParticipacao;

/**
 * @author PAULO e INATHAN - TATAKAE!
 *Fachada para a classe Projeto
 */
public class Fachada5Projeto {
	
	/**
	 * {@link #projetoParticipacao} Atributo que faz a persistência
	 */
	private DAOXMLProjetoParticipacao projetoParticipacao = new DAOXMLProjetoParticipacao();
	
	/**
	 * Método que cria o projeto e adiciona na persistência
	 * @param projeto: esse parâmetro é o projeto que vai ser adicionado
	 */
	public void criarProjeto(Projeto projeto) { 
		projetoParticipacao.criar(projeto);
	}	
	/**
	 * Método que remove o projeto da persistência
	 * @param idProjeto: é o id do projeto para que possa achar o projeto e remove-lo
	 * @return: retorna true se for remover o projeto e false se não.
	 */
	public boolean removerProjeto(long idProjeto) {
		Projeto projeto = pesquisarProjeto(idProjeto);
		if(projeto.getMembros().size()>0){
			return false;
		}
		projetoParticipacao.remover(idProjeto);
		return true;
	}
	/**
	 * Método que atualiza os dados do projeto.
	 * @param projeto: é o projeto que vai ser atualizado na persistência.
	 * @param idProjeto: é o id que onde o projeto vai ficar no HashMap da persistência.
	 * @return: retorna true se atualizar o projeto e false se não.
	 */
	public boolean atualizarProjeto(Projeto projeto,long idProjeto){
		return projetoParticipacao.atualizar(idProjeto, projeto);
	}
	/**
	 * Método que adiciona o Membro no projeto.
	 * @param membro: é o membro que vai ser adicionado no projeto.
	 * @param idDoProjeto: é o id do projeto que vai ser adicionado o membro.
	 * @return: retorna true se o membro for adicionado e false se não.
	 */
	public boolean adicionarMembroNoProjeto(Membro membro,long idDoProjeto){
		try{
			// adiciona o membro para o projeto
			Projeto projeto = pesquisarProjeto(idDoProjeto);
			projeto.adicionar(membro);
			return projetoParticipacao.atualizar(idDoProjeto, projeto);
		}catch(Exception e){
			System.out.println("Não existe Projeto com este ID");
		}
		return false;
	}
	/**
	 * Método que remove o membro do projeto.
	 * @param membro: o Membro que vai ser removido do projeto.
	 * @param idDoProjeto: o id do projeto que o membro vai ser removido.
	 * @return: retorna true se remover o membro do projeto e false se não.
	 */
	public boolean removerMembroNoProjeto(Membro membro,long idDoProjeto){
		try{
			// remove o membro do projeto
			Projeto projeto = pesquisarProjeto(idDoProjeto);
			projeto.remover(membro);
			return projetoParticipacao.atualizar(idDoProjeto, projeto);
		}catch(Exception e){
			System.out.println("Não foi possivel remover o membro");
		}
		return false;
	}
	/**
	 * Método pesquisa por um projeto na persistência.
	 * @param idProjeto: o id do projeto que você quer pesquisar.
	 * @return: retorna o projeto que você pesquisou
	 */
	public Projeto pesquisarProjeto(long idProjeto){
		return projetoParticipacao.pesquisarProjeto(idProjeto);
	}
}
