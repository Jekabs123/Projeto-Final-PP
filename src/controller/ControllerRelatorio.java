package controller;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;
import view.projetos.relatorios.DiretorRelatorio;

public class ControllerRelatorio {

	private DiretorRelatorio diretor;
	
	public ControllerRelatorio(DiretorRelatorio diretor) {
		this.diretor = diretor;
	}
	
//	public void gerarRelatorioEdital(Edital edital){
//		diretor.gerar(edital);
//	}
//	public void gerarRelatorioGrupo(Grupo grupo){
//		diretor.gerar(grupo);
//	}
//	public void gerarRelatrorioProjeto(Projeto projeto){
//		diretor.gerar(projeto);
//	}
}
