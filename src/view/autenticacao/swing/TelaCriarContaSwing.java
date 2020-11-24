package view.autenticacao.swing;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.autenticacao.TelaCriarConta;

public class TelaCriarContaSwing extends JFrame implements TelaCriarConta {

	public TelaCriarContaSwing() {
		setTitle("Criar Conta");
		setLayout(null);
		setResizable(false);
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		addLookAndFeel();
		addLabels();
		addTextFields();
		addRadioButtons();
		addButtons();

		setVisible(true);
		repaint();
	}
	
	public void addLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {}
	}

	public void addLabels() {
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(50, 50, 50, 30);
		add(labelLogin);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(50, 100, 50, 30);
		add(labelSenha);
	}
	public void addTextFields() {
		JTextField txtLogin = new JTextField();
		txtLogin.setBounds(120, 50, 230, 30);
		add(txtLogin);
		
		JTextField txtSenha = new JTextField();
		txtSenha.setBounds(120, 100, 230, 30);
		add(txtSenha);
	}
	
	public void addRadioButtons() {
		JRadioButton radioBttProvedorInterno = new JRadioButton("Interno");
		radioBttProvedorInterno.setBounds(80, 150, 100, 30);
		add(radioBttProvedorInterno);
		radioBttProvedorInterno.setSelected(true);
		
		JRadioButton radioBttProvedorSMTP = new JRadioButton("SMTP");
		radioBttProvedorSMTP.setBounds(250 , 150, 100, 30);
		add(radioBttProvedorSMTP);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioBttProvedorInterno);
		group.add(radioBttProvedorSMTP);
	}
	
	public void addButtons() {

	}


	public static void main(String[] args) {
		new TelaCriarContaSwing();
	}

}
