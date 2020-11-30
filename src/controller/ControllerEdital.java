package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import fachadas.Fachada4Edital;
import model.projetos.Edital;

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
	
}
