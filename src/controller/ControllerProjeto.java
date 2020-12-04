package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import fachadas.Fachada5Projeto;
import model.autenticacao.Membro;
import model.projetos.Projeto;

public class ControllerProjeto {

	private Fachada5Projeto fachadaProjeto = new Fachada5Projeto();
	
	private Projeto projeto;
	
	public void adicionarProjeto(String nome,float aporteCapitalReais,float aporteCusteioReais,long dataTermino, float gastoExecutadoCapitalReais, float gastoExecutadoCusteioReais){
		projeto = new Projeto();
		projeto.setAporteCapitalReais(aporteCapitalReais);
		projeto.setAporteCusteioReais(aporteCusteioReais);
		projeto.setAtivo(true);
		projeto.setDataInicio(LocalDate.now().getYear());
		projeto.setDataTermino(dataTermino);
		projeto.setId(Fachada5Projeto.getProjetosPersistidos().size()+1);
		projeto.setNome(nome);
		projeto.setGastoExecutadoCapitalReais(gastoExecutadoCapitalReais);
		projeto.setGastoExecutadoCusteioReais(gastoExecutadoCusteioReais);
		fachadaProjeto.adicionarProjeto(projeto);
	}
	public void adicionarMembroNoProjeto(Membro membro){
		fachadaProjeto.adicionarMembroNoProjeto(membro, projeto.getId());
	}
	public ArrayList<Projeto> getProjetos(){
		return Fachada5Projeto.getProjetosPersistidos();
	}
	public void removerProjeto(int id){
		fachadaProjeto.removerProjeto(id);
	}
	public void removerMembro(Membro membro, int id){
		fachadaProjeto.removerMembroNoProjeto(membro, id);
	}
	public Projeto pesquisarProjeto(int id){
		return fachadaProjeto.pesquisarProjeto(id);
	}
}
