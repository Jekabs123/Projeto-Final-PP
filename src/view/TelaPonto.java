package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.projetos.Projeto;
import model.projetos.controller.ControllerTelaPonto;

// CLASSE CLIENTE DO PROXY

public class TelaPonto extends JFrame{
	
	//PROVAVELMENTE PRECISA COLOCAR UM JTEXTFIELD PARA RECEBER ESSAS INFORMAÇÕES
	private Projeto projeto;
	private String login;
	
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
     	

     	botaoBaterPonto(null, null);
     	botaoVerDetalhes();
     	setVisible(true);
    
    	repaint();
    }
	
	public void botaoBaterPonto(Projeto projeto, String login) {
		JButton btBaterPonto = new JButton("Bater Ponto");
		btBaterPonto.setBounds(100, 50, 130, 30);
		add(btBaterPonto);
		
		OuvinteBaterPonto ouvinteBaterPonto = new OuvinteBaterPonto();
		btBaterPonto.addActionListener(ouvinteBaterPonto);
		
	}
	
	public void botaoVerDetalhes() {
		JButton btBaterPonto = new JButton("Ver Detalhes");
		btBaterPonto.setBounds(100, 100, 130, 30);
		add(btBaterPonto);
	}
	
	
	public class OuvinteBaterPonto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ControllerTelaPonto controllerTelaPonto = new ControllerTelaPonto();
			
			controllerTelaPonto.conectarProxy(projeto, login);
			
		}
		
	}

}
