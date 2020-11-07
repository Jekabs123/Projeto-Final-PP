package fachadas;

import java.util.HashMap;

import model.autenticacao.Membro;
import model.projetos.Grupo;
import persistencia.xml.DAOXMLGrupo;
/**
 * @author PAULO e INATHAN - TATAKAE!
 *Fachada para a classe Grupo
 */
public class Fachada3Grupo {
	/**
	 * {@link #grupoXML} Atributo que faz a persist�ncia.
	 */
	private DAOXMLGrupo grupoXML = new DAOXMLGrupo();
	
	/**
	 * M�todo que adiciona o grupo na persist�ncia.
	 * @param grupo: � o grupo que vai ser adicionado na persist�ncia. 
	 */
	public void adicionarGrupo(Grupo grupo) {
		grupoXML.criar(grupo);
	}
	/**
	 * M�todo que remove o grupo da persist�ncia.
	 * @param id: � o id do grupo para que possa remover da persist�ncia.
	 * @return: retorna true se remover o grupo da persist�ncia e false se n�o.
	 */
	public boolean removerGrupo(long id) {
		Grupo grupo = pesquisarGrupo(id);
		if(grupo.getInterfaces().size() > 0) {
			return false;
		}
		grupoXML.remover(id);
		return true;
	}
	/**
	 * M�todo que atualiza o grupo na persist�ncia.
	 * @param grupo: � o grupo que vai ser atualizado.
	 * @param id: � o id onde grupo vai ficar no HashMap da persist�ncia.
	 * @return: retorna true se o grupo atualizar e false se n�o.
	 */
	public boolean atualizarGrupo(Grupo grupo, long id) {
		return grupoXML.atualizar(id, grupo);
	}
	/**
	 * Esse m�todo adiciona um membro no grupo selecionado
	 * @param membro: � o Membro que vai ser adicionado
	 * @param idDoGrupo: � o id do grupo que vai ser adicionado
	 * @return: retorna true se adicionar o membro no grupo e false se n�o
	 */
	public boolean adicionarMembroNoGrupo(Membro membro,long idDoGrupo){
		try{
			// adiciona o membro para o grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.adicionar(membro);
			return grupoXML.atualizar(idDoGrupo, grupo);
		}catch(Exception e){
			System.out.println("N�o existe Grupo com este ID");
		}
		return false;
	}
	/**
	 * Esse m�todo remove um Membro do Grupo selecionado
	 * @param membro: � o membro que vai ser removido do grupo
	 * @param idDoGrupo: � o id do Grupo que vai ser removido o membro
	 * @return: retorna true se for removido e false se n�o
	 */
	public boolean removerMembroDoGrupo(Membro membro,long idDoGrupo){
		try{
			//remove o membro do grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.remover(membro);
			return grupoXML.atualizar(idDoGrupo, grupo);
		}catch(Exception e){
			System.out.println("N�o foi possivel remover o membro");
		}
		return false;
	}
	/**
	 * Esse m�todo pesquisa um grupo na persist�ncia grupoXML
	 * @param id: � o id do grupo que voc� quer pesquisar na persist�ncia grupoXML
	 * @return: retorna o Grupo se achar e null se n�o achar o grupo
	 */
	public Grupo pesquisarGrupo(long id){
		return grupoXML.pesquisarGrupo(id);
	}
	/**
	 * Esse m�todo retorna uma lista de grupo
	 * @return: retorna uma lista de grupo de existir se n�o ele retorna uma lista vazia
	 */
	//TODO grupo ou grupos?
	public HashMap<Long, Grupo> getGrupo(){
		return grupoXML.getGrupo();
	}
}
