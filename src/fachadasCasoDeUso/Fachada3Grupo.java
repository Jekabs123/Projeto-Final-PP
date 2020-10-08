package fachadasCasoDeUso;

import model.autenticacao.Membro;
import model.projetos.Grupo;
import persistencia.xml.DAOXMLGrupo;
/**
 * @author PAULO e INATHAN
 *Fachada para a classe Grupo
 */
public class Fachada3Grupo {
	/**
	 * Atributo que faz a persistência.
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
		if(grupo.getProjetos().size() > 0) {
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
	public boolean removerMembro(Membro membro,long idDoGrupo){
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
	public Grupo pesquisarGrupo(long id){
		return grupoXML.pesquisarGrupo(id);
	}
}
