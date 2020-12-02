package view.projetos.relatorios;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class StringBufferHTML {
	private File arquivo;
	
	public void setHTML(File file){
		this.arquivo = file;
	}
	
	public void mostrarHTML(){
		Desktop d  = Desktop.getDesktop();
		try {
			d.open(arquivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
