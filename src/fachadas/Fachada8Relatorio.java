package fachadas;

import java.util.HashMap;

import model.projetos.Edital;
import model.projetos.Grupo;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa fachada é utilizada para gerar relatório
 */
public class Fachada8Relatorio {
	/**
	 * {@link #editais} Esse atributo guarda a lista de editais
	 * {@link #grupos} Esse atributo guarda a lista de grupos
	 */
	private HashMap<Long, Edital> editais;
	private HashMap<Long, Grupo> grupos; 
	
	/**
	 * Esse é construtor que inicializa os atributos
	 */
	public Fachada8Relatorio() {
		Fachada4Edital fachada = new Fachada4Edital();
		Fachada3Grupo fachadaGrupo = new Fachada3Grupo();
		this.editais = fachada.getEditais();
		this.grupos = fachadaGrupo.getGrupos();
	}
	/**
	 * Esse método gera o relatório de todos os editais
	 */
	public void gerarRelatorioEdital(){
		for(int i = 0;i<=editais.size();i++){
			System.out.println("[Edital]");
			System.out.println("[NOME] - "+editais.get(i).getNome());
			System.out.println("[DATA INICIO] - "+editais.get(i).getDataInicio());
			System.out.println("[DATA TERMINO] - "+editais.get(i).getDataTermino());
			System.out.println("[CUSTO TOTAL] - "+editais.get(i).getCustoTotal());
			System.out.println("[CAPITAL NÃO GASTO] - "+editais.get(i).getCapitalReaisNaoGastoTotal());
			System.out.println("[CUSTEIO NÃO GASTO] - "+editais.get(i).getCusteioReaisNaoGastoTotal());
			System.out.println("[EDITAL ATIVO] - "+editais.get(i).getAtivo());
		}
	}
	/**
	 * Esse método gera o relatório do todos os grupos
	 */
	public void gerarRelatorioGrupo(){
		System.out.println("[GRUPO]");
		for(int i = 0;i<=grupos.size();i++){
			System.out.println("[LINK CNPq] - "+new String(grupos.get(i).getLinkCNPq()));
			System.out.println("[DATA CRIAÇÂO] - "+grupos.get(i).getDataCriacao());
			System.out.println("[GRUPO ATIVO] - "+grupos.get(i).getAtivo());
		}
	}
}
