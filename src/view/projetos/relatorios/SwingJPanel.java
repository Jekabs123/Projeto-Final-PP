package view.projetos.relatorios;

import javax.swing.JPanel;

public class SwingJPanel {

	private JPanel panel;
	
	public void setJPanel(JPanel panel){
		this.panel = panel;
	}
	public void mostrarJPanel(){
		panel.setVisible(true);
	}
}
