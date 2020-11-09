package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import fachadas.Fachada5Projeto;
import model.projetos.Projeto;
import model.projetos.controller.ControllerTelaPonto;

// CLASSE CLIENTE DO PROXY

public class TelaPonto extends JFrame {
	
	private Fachada5Projeto fachadaProjeto = new Fachada5Projeto();
	
	public TelaPonto() {
		setTitle("Bater Ponto");
    	setLayout(null);
        setResizable(false);
    	setSize(400,290);
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
     	labels();
     	comboBox();
     	setVisible(true);
    
    	repaint();
    }
	
	public void labels() {
		JLabel labelProjeto = new JLabel("Projetos");
		labelProjeto.setBounds(120, 50, 60, 20);
		add(labelProjeto);
	}
	
	public void comboBox() {
		Projeto[] projetosComboBox = fachadaProjeto.getProjetosPersistidos().toArray(new Projeto[0]);
		JComboBox<Projeto> listComboBox = new JComboBox<Projeto>(projetosComboBox);
		listComboBox.setBounds(190, 50, 100, 20);
		add(listComboBox);
	}
	
	
	public void botaoBaterPonto(Projeto projeto, String login) {
		JButton btBaterPonto = new JButton("Bater Ponto");
		btBaterPonto.setBounds(150, 100, 100, 30);
		add(btBaterPonto);
		
		OuvinteBaterPonto ouvinteBaterPonto = new OuvinteBaterPonto();
		btBaterPonto.addActionListener(ouvinteBaterPonto);
		
	}
	
	public void botaoVerDetalhes() {
		JButton btBaterPonto = new JButton("Ver Detalhes");
		btBaterPonto.setBounds(150, 150, 100, 30);
		add(btBaterPonto);
	}
	
	
	public class OuvinteBaterPonto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ControllerTelaPonto controllerTelaPonto = new ControllerTelaPonto();
			
//			controllerTelaPonto.conectarProxy(projeto, login);
			
		}
		
	}

}
