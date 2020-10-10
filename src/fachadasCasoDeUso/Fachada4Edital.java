package fachadasCasoDeUso;

import model.projetos.Edital;
import persistencia.xml.DAOXMLEdital;
/**
 * 
 * @author PAULO E INATHAN
 *A classe é uma fachada de edital, para facilitar o uso dela
 */
public class Fachada4Edital {
/**
 * Atributo que vai persistir os editais	
 */
private DAOXMLEdital editalXML = new DAOXMLEdital();
	
	/**
	 * Esse método adiciona editais na persistência editalXML
	 * @param edital: é o edital que vai ser adicionado
	 */
	public void adicionarEdital(Edital edital) {
		editalXML.criar(edital);
	}
	/**
	 * Esse método remove o edital da persistência editalXML
	 * @param id: é o id onde se encontra o edital
	 * @return: retorna true se for excluido o edital e false se não
	 */
	public boolean removerEdital(long id) {
		Edital edital = pesquisarEdital(id);
		if(edital.getProjetos().size() > 0) {
			return false;
		}
		editalXML.remover(id);
		return true;
	}
	/**
	 * Esse método atualiza o edital na persistência
	 * @param edital: é o edital atualizado que vai ser salvo na persistência
	 * @param id: é o id onde o edital atualizado vai ficar
	 */
	public void atualizarEdital(Edital edital, long id) {
		editalXML.atualizar(id, edital);
	}
	/**
	 * Esse método pesquisa o edital de acordo com o id passado
	 * @param idEdital: é o id do edital que você quer pesquisar
	 * @return: retorna o Edital se achar e null se não achar
	 */
	public Edital pesquisarEdital(long idEdital){
		return editalXML.pesquisarEdital(idEdital);
	}

}
