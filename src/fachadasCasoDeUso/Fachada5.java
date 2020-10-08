package fachadasCasoDeUso;

import model.autenticacao.Membro;
import model.projetos.Participacao;
import model.projetos.Projeto;
import persistencia.xml.DAOXMLProjetoParticipacao;


//Falta Terminar

public class Fachada5 {
	
	private Projeto projeto;
	private Participacao participacao;
	private Membro membro;
	private DAOXMLProjetoParticipacao projetoParticipacao = new DAOXMLProjetoParticipacao();
	
	public void criarProjeto() {
		projeto = new Projeto();
		participacao = new Participacao();
		
		projetoParticipacao.criar(projeto);
		
		for (int i = 0; i < projeto.getMembros().size(); i++) {
			if(i==1) {
				participacao.setCoordenador(true);
			}
		}
	}	
	
	public void removerProjeto() {
		
	}

}
