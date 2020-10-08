package fachadasCasoDeUso;

import model.projetos.Edital;
import persistencia.xml.DAOXMLEdital;

public class Fachada4Edital {
	
private DAOXMLEdital editalXML = new DAOXMLEdital();
	
	public void adicionarGrupo(Edital edital) {
		editalXML.criar(edital);
	}
	
	public boolean removerGrupo(Edital edital, long id) {
		if(edital.getProjetos().size() > 0) {
			return false;
		}
		editalXML.remover(id);
		return true;
	}
	
	public void atualizarGrupo(Edital edital, long id) {
		editalXML.atualizar(id, edital);
	}

}
