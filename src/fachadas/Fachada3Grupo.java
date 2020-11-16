package fachadas;

import java.util.ArrayList;

import model.autenticacao.Membro;
import model.projetos.Grupo;
import persistenciaXML.DAOXMLGrupo;
/**
 * @author PAULO e INATHAN - TATAKAE!
 *Fachada para a classe Grupo
 */
public class Fachada3Grupo {
	/**
	 * {@link #grupoXML} Atributo que faz a persistï¿½ncia.
	 */
	private DAOXMLGrupo grupoXML = new DAOXMLGrupo();
	
	/**
	 * Metodo que adiciona o grupo na persistencia.
	 * @param grupo: e o grupo que vai ser adicionado na persistencia. 
	 */
	public void adicionarGrupo(Grupo grupo) {
		grupoXML.criar(grupo);
	}
	/**
	 * Metodo que remove o grupo da persistencia.
	 * @param id: e o id do grupo para que possa remover da persistencia.
	 * @return: retorna true se remover o grupo da persistencia e false se nao.
	 */
	public boolean removerGrupo(int id) {
		Grupo grupo = pesquisarGrupo(id);
		if(grupo.getGrupos().size() > 0) {
			return false;
		}
		grupoXML.remover(id);
		return true;
	}
	/**
	 * Mï¿½todo que atualiza o grupo na persistï¿½ncia.
	 * @param grupo: ï¿½ o grupo que vai ser atualizado.
	 * @param id: ï¿½ o id onde grupo vai ficar no HashMap da persistï¿½ncia.
	 * @return: retorna true se o grupo atualizar e false se nï¿½o.
	 */
	public void atualizarGrupo() {
		grupoXML.atualizar();
	}
	/**
	 * Esse mï¿½todo adiciona um membro no grupo selecionado
	 * @param membro: ï¿½ o Membro que vai ser adicionado
	 * @param idDoGrupo: ï¿½ o id do grupo que vai ser adicionado
	 * @return: retorna true se adicionar o membro no grupo e false se nï¿½o
	 */
	public void adicionarMembroNoGrupo(Membro membro, int idDoGrupo){
		try{
			// adiciona o membro para o grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.adicionarMembro(membro);
			grupoXML.atualizar();
		}catch(Exception e){
			System.out.println("Nï¿½o existe Grupo com este ID");
		}
	}
	/**
	 * Esse mï¿½todo remove um Membro do Grupo selecionado
	 * @param membro: ï¿½ o membro que vai ser removido do grupo
	 * @param idDoGrupo: ï¿½ o id do Grupo que vai ser removido o membro
	 * @return: retorna true se for removido e false se nï¿½o
	 */
	public void removerMembroDoGrupo(Membro membro, int idDoGrupo){
		try{
			//remove o membro do grupo
			Grupo grupo = pesquisarGrupo(idDoGrupo);
			grupo.removerMembro(membro);
			grupoXML.atualizar();
		}catch(Exception e){
			System.out.println("Não foi possivel remover o membro");
		}
	}
	/**
	 * Esse mï¿½todo pesquisa um grupo na persistï¿½ncia grupoXML
	 * @param id: ï¿½ o id do grupo que vocï¿½ quer pesquisar na persistï¿½ncia grupoXML
	 * @return: retorna o Grupo se achar e null se nï¿½o achar o grupo
	 */
	public Grupo pesquisarGrupo(int id){
		return grupoXML.pesquisarGrupo(id);
	}
	/**
	 * Esse mï¿½todo retorna uma lista de grupo
	 * @return: retorna uma lista de grupo de existir se nï¿½o ele retorna uma lista vazia
	 */
	public ArrayList<Grupo> getGrupos(){
		return grupoXML.getGrupo();
	}
}
