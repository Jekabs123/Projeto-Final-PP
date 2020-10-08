package fachadasCasoDeUso;

import model.projetos.Edital;
import persistencia.xml.DAOXMLEdital;

public class Fachada4Edital {
	
private DAOXMLEdital editalXML = new DAOXMLEdital();
	
	public void adicionarEdital(Edital edital) {
		editalXML.criar(edital);
	}
	
	public boolean removerEdital(Edital edital, long id) {
		if(edital.getProjetos().size() > 0) {
			return false;
		}
		editalXML.remover(id);
		return true;
	}
	
	public void atualizarEdital(Edital edital, long id) {
		editalXML.atualizar(id, edital);
	}
	public Edital pesquisarEdital(long idEdital){
		return editalXML.pesquisarEdital(idEdital);
	}

}
