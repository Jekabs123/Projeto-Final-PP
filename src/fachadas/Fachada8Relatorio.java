package fachadas;

import java.util.ArrayList;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa fachada é utilizada para gerar relatório
 */
public class Fachada8Relatorio {
	/**
	 * {@link #editais} Esse atributo guarda a lista de editais
	 * {@link #grupos} Esse atributo guarda a lista de grupos
	 */
	private ArrayList<Edital> editais;
	private ArrayList<Grupo> grupos;
	private ArrayList<Projeto> projetos;
	
	/**
	 * Esse é construtor que inicializa os atributos
	 */
	public Fachada8Relatorio() {
		Fachada4Edital fachada = new Fachada4Edital();
		Fachada3Grupo fachadaGrupo = new Fachada3Grupo();
		this.editais = fachada.getEditais();
		this.grupos = fachadaGrupo.getGrupos();
		this.projetos = Fachada5Projeto.getProjetosPersistidos();
	}
	/**
	 * Esse método gera o relatório de todos os editais
	 */
	public String gerarRelatorioEdital(){
		String relatorio = "";
		for(Edital edital : editais){
			relatorio += "[Edital]<br>";
			relatorio += "[NOME] - "+edital.getNome()+"<br>";
			relatorio += "[DATA INICIO] - "+edital.getDataInicio()+"<br>";
			relatorio += "[DATA TERMINO] - "+edital.getDataTermino()+"<br>";
			relatorio += "[CUSTO TOTAL] - "+edital.getCustoTotal()+"<br>";
			relatorio += "[CAPITAL NÃO GASTO] - "+edital.getCapitalReaisNaoGastoTotal()+"<br>";
			relatorio += "[CUSTEIO NÃO GASTO] - "+edital.getCusteioReaisNaoGastoTotal()+"<br>";
			relatorio +="[EDITAL ATIVO] - "+edital.getAtivo()+"<br>";
		}
		return relatorio;
	}
	/**
	 * Esse método gera o relatório do todos os grupos
	 */
	public String gerarRelatorioGrupo(){
		String relatorio = "";
		for(Grupo grupo : grupos){
			relatorio += "[GRUPO]<br>";
			relatorio += "[LINK CNPq] - "+grupo.getLinkCNPq()+"<br>";
			relatorio += "[DATA CRIAÇÂO] - "+grupo.getDataCriacao()+"<br>";
			relatorio += "[GRUPO ATIVO] - "+grupo.getAtivo()+"<br>";
		}
		return relatorio;
	}
	public String gerarRelatorioProjeto(){
		String relatorio = "";
		for(Projeto p: projetos){
			relatorio += "[Projeto]<br>";
			relatorio += "Nome do projeto: "+p.getNome()+"<br>";
			relatorio += "Gastos executados capital: "+p.getGastoExecutadoCapitalReais()+"<br>";
			relatorio += "Gastos executados custeio: "+p.getGastoExecutadoCusteioReais()+"<br>";
			relatorio += "Aporte capital: "+p.getAporteCapitalReais()+"<br>";
			relatorio += "Aporte custeio: "+p.getAporteCusteioReais()+"<br>";
			relatorio += "Data inicio: "+p.getDataInicio()+"<br>";
			relatorio += "Data termino: "+p.getDataTermino()+"<br>";
			relatorio += "Custo Total: "+p.getCustoTotal()+"<br>";
		}
		return relatorio;
	}
	public String gerarRelatorioGeral(){
		String relatorio = "";
		relatorio += gerarRelatorioEdital()+"<br>";
		relatorio += gerarRelatorioGrupo()+"<br>";
		relatorio += gerarRelatorioProjeto()+"<br>";
		return relatorio;
	}
}
