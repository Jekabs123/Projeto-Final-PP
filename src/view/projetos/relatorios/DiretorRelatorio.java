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
	
	public void gerar(Edital edital) {
		montador.reiniciar(); //1.TODO o reiniciar tem que ter algum parametro para
							  //ler os atributos do edital e gerar o relatorio
	}
	
	public void gerar(Grupo grupo) {
		montador.reiniciar();	//Idem 1.TODO
	}
	
	public void gerar(Projeto projeto) {
		montador.reiniciar();	//idem 1.TODO
	}

}
