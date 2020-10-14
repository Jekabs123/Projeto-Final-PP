package fachadasCasoDeUso;

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
	 * {@link #grupoXML} Atributo que faz a persistência.
	 */
	private DAOXMLGrupo grupoXML = new DAOXMLGrupo();
	
	/**
	 * Método que adiciona o grupo na persistência.
	 * @param grupo: é o grupo que vai ser adicionado na persistência. 
	 */
	public void adicionarGrupo(Grupo grupo) {
		grupoXML.criar(grupo);
	}
	/**
	 * Método que remove o grupo da persistência.
	 * @param id: é o id do grupo para que possa remover da persistência.
	 * @return: retorna true se remover o grupo da persistência e false se não.
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
	 * Método que atualiza o grupo na persistência.
	 * @param grupo: é o grupo que vai ser atualizado.
	 * @param id: é o id onde grupo vai ficar no HashMap da persistência.
	 * @return: retorna true se o grupo atualizar e false se não.
	 */
	public boolean atualizarGrupo(Grupo grupo, long id) {
		return grupoXML.atualizar(id, grupo);
	}
	/**
	 * Esse método adiciona um membro no grupo selecionado
	 * @param membro: é o Membro que vai ser adicionado
	 * @param idDoGrupo: é o id do grupo que vai ser adicionado
	 * @return: retorna true se adicionar o membro no grupo e false se não
	 */
	public boolean adicionarMembroNoGrupo(Membro membro,long idDoGrupo){
		try{
			// adiciona o membro para o grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.adicionar(membro);
			return grupoXML.atualizar(idDoGrupo, grupo);
		}catch(Exception e){
			System.out.println("Não existe Grupo com este ID");
		}
		return false;
	}
	/**
	 * Esse método remove um Membro do Grupo selecionado
	 * @param membro: é o membro que vai ser removido do grupo
	 * @param idDoGrupo: é o id do Grupo que vai ser removido o membro
	 * @return: retorna true se for removido e false se não
	 */
	public boolean removerMembroDoGrupo(Membro membro,long idDoGrupo){
		try{
			//remove o membro do grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.remover(membro);
			return grupoXML.atualizar(idDoGrupo, grupo);
		}catch(Exception e){
			System.out.println("Não foi possivel remover o membro");
		}
		return false;
	}
	/**
	 * Esse método pesquisa um grupo na persistência grupoXML
	 * @param id: é o id do grupo que você quer pesquisar na persistência grupoXML
	 * @return: retorna o Grupo se achar e null se não achar o grupo
	 */
	public Grupo pesquisarGrupo(long id){
		return grupoXML.pesquisarGrupo(id);
	}
	/**
	 * Esse método retorna uma lista de grupo
	 * @return: retorna uma lista de grupo de existir se não ele retorna uma lista vazia
	 */
	public HashMap<Long, Grupo> getGrupo(){
		return grupoXML.getGrupo();
	}
}
