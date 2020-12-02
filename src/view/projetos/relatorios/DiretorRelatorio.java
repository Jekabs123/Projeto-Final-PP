package view.projetos.relatorios;

import fachadas.Fachada8Relatorio;
import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public class DiretorRelatorio {
	private MontadorRelatorioProjeto montador;
	
	public DiretorRelatorio(MontadorRelatorioProjeto montadorRelatorioProjeto) {
		this.montador = montadorRelatorioProjeto;
	}
	
	public void montar() {
		montador.gerarRelatorioHtml();
		montador.gerarRelatorioNativoSwing();
		
	}
		

}
