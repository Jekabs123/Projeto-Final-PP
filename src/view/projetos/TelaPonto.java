package view.projetos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.projetos.Projeto;

public class TelaPonto extends JFrame{
	
	public TelaPonto(){
		setTitle("Bater Ponto");
    	setLayout(null);
        setResizable(false);
    	setSize(300,200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	setLocationRelativeTo(null);
     	
     	try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if ("Nimbus".equals(info.getName())) {
			        UIManager.setLookAndFeel(info.getClassName());
			        break;
			    }
			}
			} catch (Exception e) {}
     	

     	botaoBaterPonto(null, null, null);
     	botaoVerDetalhes();
     	setVisible(true);
    
    	repaint();
    }
	
	public void botaoBaterPonto(Projeto projeto, char[] login, char[] senha) {
		JButton btBaterPonto = new JButton("Bater Ponto");
		btBaterPonto.setBounds(100, 50, 130, 30);
		add(btBaterPonto);
	}
	
	public void botaoVerDetalhes() {
		JButton btBaterPonto = new JButton("Ver Detalhes");
		btBaterPonto.setBounds(100, 100, 130, 30);
		add(btBaterPonto);
	}

}
