package view.projetos.relatorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fachadas.Fachada8Relatorio;

public class RelatorioProjetoHTML extends File implements MontadorRelatorioProjeto {

	private String relatorio;

	public RelatorioProjetoHTML(File arquivo, String caminho) {
		super(arquivo, caminho);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;



	public StringBufferHTML getProduto() {
		StringBufferHTML stringHtml = new StringBufferHTML();
		stringHtml.setHTML(this);
		return stringHtml;
	}



	@Override
	public void gerarRelatorio() {
			Fachada8Relatorio fachada = new Fachada8Relatorio();
			relatorio = fachada.gerarRelatorioGeral();
	}



	@Override
	public void contruirInterface() {
		try {
			FileWriter fw = new FileWriter(this);
			fw.write(relatorio);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}
