package view.projetos;

import java.io.File;

public class RelatorioProjetoHTML extends File implements MontadorRelatorioProjeto {

	public RelatorioProjetoHTML(File arg0, String arg1) {
		super(arg0, arg1);
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public void reiniciar() {
		
	}
	
	public SwingJPanel getProduto() {
		return null;
	}

}
