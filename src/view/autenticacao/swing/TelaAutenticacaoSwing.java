package view.autenticacao.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ControllerTelaAutenticacao;
import model.autenticacao.Membro;
import model.autenticacao.TipoProvedorAutenticacao;
import view.autenticacao.TelaAutenticacao;

public class TelaAutenticacaoSwing extends JFrame implements TelaAutenticacao{
	
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private JRadioButton smtp;
	private JRadioButton interno;
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
		OuvinteAutenticar ouvinte = new OuvinteAutenticar();
		JButton autenticar = new JButton("Autenticar");
		autenticar.setBounds(80, 100, 90, 30);
		autenticar.addActionListener(ouvinte);
		add(autenticar);
	}
	public void textField(){
		campoLogin = new JTextField();
		campoLogin.setBounds(120, 150, 120, 30);
		add(campoLogin);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(120, 190, 120, 30);
		add(campoSenha);
	}
	public void radioButton(){
		smtp = new JRadioButton("Provedor SMTP");
		interno = new JRadioButton("Provedor interno");

		smtp.setBounds(30, 230, 80, 30);
		interno.setBounds(120, 230, 80, 30);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(smtp);
		grupo.add(interno);
		
		add(smtp);
		add(interno);
		
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
	public class OuvinteAutenticar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ControllerTelaAutenticacao controller = new ControllerTelaAutenticacao();
			String senha = new String(campoSenha.getPassword());
			TipoProvedorAutenticacao provedor = null;
			if(smtp.isSelected()){
				provedor = TipoProvedorAutenticacao.EMAIL_SMTP;
			}else if(interno.isSelected()){
				provedor = TipoProvedorAutenticacao.INTERNO;
			}
			Membro m = controller.autenticarContaEmail(campoLogin.getText(), senha, provedor);
			JOptionPane.showMessageDialog(null, m.getNome());
		}
		
	}
}
