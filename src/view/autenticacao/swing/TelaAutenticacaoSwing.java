package view.autenticacao.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.autenticacao.TelaAutenticacao;

public class TelaAutenticacaoSwing extends JFrame implements TelaAutenticacao{

	public TelaAutenticacaoSwing() {
		SetLookAndFeel.addLookAndFeel();
		setTitle("Autenticação");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		botoes();
		textField();
		label();
		setVisible(true);
		repaint();
	}
	public void botoes(){
		JButton autenticar = new JButton("Autenticar");
		autenticar.setBounds(80, 100, 90, 30);
		add(autenticar);
	}
	public void textField(){
		JTextField campoLogin = new JTextField();
		campoLogin.setBounds(120, 150, 120, 30);
		add(campoLogin);
		
		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(120, 190, 120, 30);
		add(campoSenha);
	}
	public void label(){
		JLabel autenticarLabel = new JLabel("Autenticação");
		autenticarLabel.setBounds(100, 50, 100, 30);
		
		JLabel login = new JLabel("Login");
		login.setBounds(80, 150, 50, 30);
		
		JLabel senha = new JLabel("Senha");
		senha.setBounds(80, 190, 50, 30);
		
		add(autenticarLabel);
		add(login);
		add(senha);
	}
	
}
