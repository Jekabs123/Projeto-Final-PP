package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import fachadas.Fachada4Edital;
import model.projetos.CompositorProjeto;
import model.projetos.Edital;
import model.projetos.Grupo;

public class ControllerEdital {

	private Fachada4Edital fachadaEdital = new Fachada4Edital();
	
	public void adicionarEdital(String nome,long dataTermino){
		Edital edital = new Edital();
		edital.setAtivo(true);
		edital.setDataInicio(LocalDate.now().getYear());
		edital.setDataTermino(dataTermino);
		edital.setId(fachadaEdital.getEditais().size()+1);
		edital.setNome(nome);
		fachadaEdital.adicionarEdital(edital);
	}
	public void removerEdital(int id){
		fachadaEdital.removerEdital(id);
	}
	
	public ArrayList<Edital> getEditais(){
		return fachadaEdital.getEditais();
	}
	
	public Edital pesquisarEdital(int id){
		return fachadaEdital.pesquisarEdital(id);
	}
	
	public void atualizarEdital() {
		fachadaEdital.atualizarEdital();
	}
	
	public void setAtributosEdital(Edital edital, String nome, long dataTermino) {
		edital.setNome(nome);
		edital.setDataTermino(dataTermino);
	}
	
	public void addCompisitorProjeto(Edital edital, CompositorProjeto compositor) {
		fachadaEdital.adicionarCompositorProjeto(edital, compositor);
	}
	
}
