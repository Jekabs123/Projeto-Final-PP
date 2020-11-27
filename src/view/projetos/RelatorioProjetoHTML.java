package view.projetos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RelatorioProjetoHTML extends File implements MontadorRelatorioProjeto {

	public RelatorioProjetoHTML(File arg0, String arg1) {
		super(arg0, arg1);
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public void reiniciar() {
		try {
			FileWriter fw = new FileWriter(this);
			fw.write("Relatorio HTML.html");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SwingJPanel getProduto() {
		return null;
	}

}
