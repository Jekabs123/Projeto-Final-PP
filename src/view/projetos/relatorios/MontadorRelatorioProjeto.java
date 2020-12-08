package view.projetos.relatorios;

import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Projeto;

public interface MontadorRelatorioProjeto {
	
	public void gerarRelatorio();

	public void contruirInterface();
	
	// Nova Versão
	
	public void gerar(Edital edital);
	
	public void gerar(Grupo grupo);
	
	public void gerar(Projeto projeto);
	
}
