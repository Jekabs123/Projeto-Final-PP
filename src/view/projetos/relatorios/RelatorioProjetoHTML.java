package view.projetos.relatorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fachadas.Fachada8Relatorio;

public class RelatorioProjetoHTML extends File implements MontadorRelatorioProjeto {



	public RelatorioProjetoHTML(File arquivo, String caminho) {
		super(arquivo, caminho);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void gerarRelatorioHtml() {
		try {
			Fachada8Relatorio fachada = new Fachada8Relatorio();
			FileWriter fw = new FileWriter(this);
			fw.write(fachada.gerarRelatorioGeral());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public StringBufferHTML getProduto() {
		StringBufferHTML stringHtml = new StringBufferHTML();
		stringHtml.setHTML(this);
		return stringHtml;
	}

	@Override
	public void gerarRelatorioNativoSwing() {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		new RelatorioProjetoHTML(new File("RelatorioHTML.html"), "").gerarRelatorioHtml();
	}

}
