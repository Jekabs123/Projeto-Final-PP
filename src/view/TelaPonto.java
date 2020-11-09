package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import fachadas.Fachada5Projeto;
import model.projetos.Projeto;
import model.projetos.controller.ControllerTelaPonto;

// CLASSE CLIENTE DO PROXY

public class TelaPonto extends JFrame {
	
	private Fachada5Projeto fachadaProjeto = new Fachada5Projeto();
	OuvinteBaterPonto ouvinteBaterPonto = new OuvinteBaterPonto();
	
	public TelaPonto() {
		setTitle("Bater Ponto");
    	setLayout(null);
        setResizable(false);
    	setSize(400, 420);
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
     	

     	labels();
     	textFields();
     	buttonLogar();
     	comboBox();
     	botaoBaterPonto(null, null);
     	botaoVerDetalhes();
     	setVisible(true);
    
    	repaint();
    }
	
	public void labels() {
		JLabel labelProjeto = new JLabel("Projetos");
		labelProjeto.setBounds(120, 200, 60, 30);
		add(labelProjeto);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(30, 30, 60, 30);
		add(labelLogin);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(30, 70, 60, 30);
		add(labelSenha);
	}
	
	public void textFields() {
		JTextField textLogin = new JTextField();
		textLogin.setBounds(110, 30, 200, 30);
		add(textLogin);
		
		JTextField textSenha = new JPasswordField();
		textSenha.setBounds(110, 70, 200, 30);
		add(textSenha);
	}
	
	public void buttonLogar() {
		JButton btBaterPonto = new JButton("Logar");
		btBaterPonto.setBounds(150, 120, 100, 30);
		add(btBaterPonto);
	}
	
	public void comboBox() {
		Projeto[] projetosComboBox = fachadaProjeto.getProjetosPersistidos().toArray(new Projeto[0]);
		JComboBox<Projeto> listComboBox = new JComboBox<Projeto>(projetosComboBox);
		listComboBox.setBounds(190, 200, 100, 30);
		add(listComboBox);
	}
	
	
	public void botaoBaterPonto(Projeto projeto, String login) {
		JButton btBaterPonto = new JButton("Bater Ponto");
		btBaterPonto.setBounds(150, 250, 100, 30);
		add(btBaterPonto);
		
		btBaterPonto.addActionListener(ouvinteBaterPonto);
		
	}
	
	public void botaoVerDetalhes() {
		JButton btBaterPonto = new JButton("Ver Detalhes");
		btBaterPonto.setBounds(150, 300, 100, 30);
		add(btBaterPonto);
		
		btBaterPonto.addActionListener(ouvinteBaterPonto);
	}
	
	
	public class OuvinteBaterPonto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String evento = e.getActionCommand();
			
//			ControllerTelaPonto controllerTelaPonto = new ControllerTelaPonto();
			
//			controllerTelaPonto.conectarProxy(projeto, login);
			
			//botaoVerDetalhes
			switch (evento) {
			
			case "Ver Detalhes":
				
				JOptionPane.showMessageDialog(null, "Horas Trabalhadas: "
						+ "\nD�ficit Horas: "
						+ "\nPontos Inv�lidos: ");
				
				break;
			}
			
		}
		
	}

}
