package view.autenticacao.swing;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		//Conta
		
		JLabel labelConta = new JLabel("Conta");
		labelConta.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelConta.setBounds(150, 30, 95, 50);
		add(labelConta);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(50, 80, 50, 30);
		add(labelLogin);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(50, 130, 50, 30);
		add(labelSenha);
		
		//Membro
		
		JLabel labelMembro = new JLabel("Membro");
		labelMembro.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelMembro.setBounds(150, 250, 110, 50);
		add(labelMembro);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(50, 300, 50, 30);
		add(labelEmail);
		
		JLabel labelMatricula = new JLabel("Matricula");
		labelMatricula.setBounds(50, 350, 50, 30);
		add(labelMatricula);
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(50, 400, 50, 30);
		add(labelNome);
		
	}
	public void addTextFields() {
		//Conta
		
		JTextField txtLogin = new JTextField();
		txtLogin.setBounds(120, 80, 230, 30);
		add(txtLogin);
		
		JTextField txtSenha = new JTextField();
		txtSenha.setBounds(120, 130, 230, 30);
		add(txtSenha);
		
		//Membro
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(120, 300, 230, 30);
		add(txtEmail);
		
		JTextField txtMatricula = new JTextField();
		txtMatricula.setBounds(120, 350, 230, 30);
		add(txtMatricula);
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds(120, 400, 230, 30);
		add(txtNome);
	}
	
	public void addRadioButtons() {
		JRadioButton radioBttProvedorInterno = new JRadioButton("Interno");
		radioBttProvedorInterno.setBounds(80, 180, 100, 30);
		add(radioBttProvedorInterno);
		radioBttProvedorInterno.setSelected(true);
		
		JRadioButton radioBttProvedorSMTP = new JRadioButton("SMTP");
		radioBttProvedorSMTP.setBounds(250 , 180, 100, 30);
		add(radioBttProvedorSMTP);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioBttProvedorInterno);
		group.add(radioBttProvedorSMTP);
	}
	
	public void addButtons() {
		JButton buttonCadastrar = new JButton("Cadastrar", new ImageIcon(getClass().getResource("/addMembro.png")));
		buttonCadastrar.setBounds(150, 470, 120, 50);
		add(buttonCadastrar);
	}


	public static void main(String[] args) {
		new TelaCriarContaSwing();
	}

}
