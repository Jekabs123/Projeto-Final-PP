package fachadasCasoDeUso;

import java.util.HashMap;

import model.projetos.Edital;
import model.projetos.Grupo;

public class Fachada8Relatorio {
	
	private HashMap<Long, Edital> editais;
	private HashMap<Long, Grupo> grupos; 
	public Fachada8Relatorio() {
		Fachada4Edital fachada = new Fachada4Edital();
		Fachada3Grupo fachadaGrupo = new Fachada3Grupo();
		this.editais = fachada.getEdital();
		this.grupos = fachadaGrupo.getGrupo();
	}
	public void gerarRelatorioEdital(){
		for(int i = 0;i<=editais.size();i++){
			System.out.println("[NOME] - "+editais.get(i).getNome());
			System.out.println("[DATA INICIO] - "+editais.get(i).getDataInicio());
			System.out.println("[DATA TERMINO] - "+editais.get(i).getDataTermino());
			System.out.println("[CUSTO TOTAL] - "+editais.get(i).getCustoTotal());
			System.out.println("[CAPITAL NÃO GASTO] - "+editais.get(i).getCapitalReaisNaoGastoTotal());
			System.out.println("[CUSTEIO NÃO GASTO] - "+editais.get(i).getCusteioReaisNaoGastoTotal());
			System.out.println("[EDITAL ATIVO] - "+editais.get(i).getAtivo());
		}
	}
	public void gerarRelatorioGrupo(){
		System.out.println("[GRUPO]");
		for(int i = 0;i<=grupos.size();i++){
			System.out.println("[LINK CNPq] - "+new String(grupos.get(i).getLinkCNPq()));
			System.out.println("[DATA CRIAÇÂO] - "+grupos.get(i).getDataCriacao());
			System.out.println("[GRUPO ATIVO] - "+grupos.get(i).getAtivo());
		}
	}
}
