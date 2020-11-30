package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import fachadas.Fachada3Grupo;
import model.autenticacao.Membro;
import model.projetos.Grupo;

public class ControllerGrupo {
	
	private Fachada3Grupo fachadaGrupo = new Fachada3Grupo();
	private Grupo grupo;
	
	public void addGrupo(String nome) {
		grupo = new Grupo();
		grupo.setAtivo(true);
		grupo.setDataInicio(LocalDate.now().getYear());
		grupo.setDataTermino(2020);  // FALTA COLOCAR A OPÇÃO PARA O CLIENTE ESCOLHER
		grupo.setDataCriacao(LocalDate.now().getYear());
		grupo.setLinkCNPq("");
		grupo.setId(fachadaGrupo.getGrupos().size()+1);
		grupo.setNome(nome);
		fachadaGrupo.adicionarGrupo(grupo);
	}
	
	public void addMembroAogrupo(Membro membro) {
		fachadaGrupo.adicionarMembroNoGrupo(membro, grupo.getId());
	}
	
	public ArrayList<Grupo> getGrupos() {
		return fachadaGrupo.getGrupos();
	}
	
	public void removerGrupo(int id) {
		fachadaGrupo.removerGrupo(id);
	}

}
