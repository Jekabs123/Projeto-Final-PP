package view.projetos.relatorios;

import javax.swing.JFrame;

public class SwingJPanel {

	private JFrame panel;
	
	public void setJPanel(JFrame panel){
		this.panel = panel;
	}
	public void mostrarJPanel(){
		panel.setVisible(true);
	}

}
