package view.projetos.relatorios;

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
