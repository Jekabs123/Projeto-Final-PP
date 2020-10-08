package fachadasCasoDeUso;

import model.projetos.Grupo;
import persistencia.xml.DAOXMLGrupo;

public class Fachada3Grupo {
	
	private DAOXMLGrupo grupoXML = new DAOXMLGrupo();
	
	public void adicionarGrupo(Grupo grupo) {
		grupoXML.criar(grupo);
	}
	
	public boolean removerGrupo(Grupo grupo, long id) {
		if(grupo.getProjetos().size() > 0) {
			return false;
		}
		grupoXML.remover(id);
		return true;
	}
	
	public void atualizarGrupo(Grupo grupo, long id) {
		grupoXML.atualizar(id, grupo);
	}

}
