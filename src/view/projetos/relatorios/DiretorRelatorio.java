package view.projetos.relatorios;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public class DiretorRelatorio {
	
	private MontadorRelatorioProjeto montador;
	
	public DiretorRelatorio(MontadorRelatorioProjeto montadorRelatorioProjeto) {
		this.montador = montadorRelatorioProjeto;
	}
	
	public void montar() {
		montador.gerarRelatorio();
		montador.contruirInterface();
		
	}
	public StringBufferHTML getProdutoHTML(){
		RelatorioProjetoHTML relatorio = null;
		if(montador instanceof RelatorioProjetoHTML){
			relatorio = (RelatorioProjetoHTML) montador;
		}
		return relatorio.getProduto();
	}
	public SwingJPanel getProdutoSwing(){
		RelatorioProjetoSwing relatorio = null;
		if(montador instanceof RelatorioProjetoSwing){
			relatorio = (RelatorioProjetoSwing) montador;
		}
		return relatorio.getProduto();
	}
	
	// Nova Versão
	
	public void gerarRelatorioCompleto(Edital edital, Grupo grupo, Projeto projeto) {
		montador.gerar(edital);
		montador.gerar(grupo);
		montador.gerar(projeto);
	}
}
