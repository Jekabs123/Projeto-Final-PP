package view.autenticacao.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ControllerProjeto;
import view.autenticacao.TelaCriarConta;

public class TelaCriarContaSwing extends JFrame implements TelaCriarConta {
	
	private ControllerProjeto controllerProjeto = new ControllerProjeto();

	public TelaCriarContaSwing() {
		setTitle("Criar Conta");
		setLayout(null);
		setResizable(false);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextFields();
		addRadioButtons();
		addButtons();
		addComboBox();

		setVisible(true);
		repaint();
	}

	private void addComboBox() {
		String[] projetosComboBox = new String[controllerProjeto.getProjetos().size()];
		for (int i=0; i<controllerProjeto.getProjetos().size(); i++) {
			projetosComboBox[i] = (controllerProjeto.getProjetos().get(i).getNome());
		}
		
		JComboBox<String> listProjetos = new JComboBox<String>(projetosComboBox);
		listProjetos.setBackground(Color.gray);
		listProjetos.setBounds(450, 400, 120, 30);
		add(listProjetos);
		
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
		
		JLabel labelPreferenciaAutenticacao = new JLabel("Preferência:");
		labelPreferenciaAutenticacao.setFont(new Font("", Font.BOLD, 12));
		labelPreferenciaAutenticacao.setBounds(50, 180, 70, 30);
		add(labelPreferenciaAutenticacao);
		
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
		
		//Participacao 
		
		JLabel labelpart = new JLabel("Participação");
		labelpart.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelpart.setBounds(500, 30, 250, 50);
		add(labelpart);
		
		JLabel labelCusteio = new JLabel("Custeio Mensal");
		labelCusteio.setBounds(450, 80, 100, 30);
		add(labelCusteio);
		
		JLabel labelMesesCusteados = new JLabel("Meses Custeados");
		labelMesesCusteados.setBounds(450, 185, 120, 30);
		add(labelMesesCusteados);
		
		JLabel labelMesesPagos = new JLabel("Meses Pagos");
		labelMesesPagos.setBounds(450, 295, 120, 30);
		add(labelMesesPagos);
		
		JLabel labelProjetos = new JLabel("Projetos");
		labelProjetos.setBounds(470, 370, 60, 30);
		add(labelProjetos);
		
	}
	public void addTextFields() {
		//Conta
		
		JTextField txtLogin = new JTextField();
		txtLogin.setBounds(120, 80, 230, 30);
		add(txtLogin);
		
		JTextField txtSenha = new JPasswordField();
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
		
		//Participacao
		
		JTextField txtCusteio = new JTextField();
		txtCusteio.setBounds(620, 80, 90, 30);
		add(txtCusteio);
		
		JTextField txtMesesCusteados = new JTextField();
		txtMesesCusteados.setBounds(620, 185, 90, 30);
		add(txtMesesCusteados);

		JTextField txtMesesPagos = new JTextField();
		txtMesesPagos.setBounds(620, 295, 90, 30);
		add(txtMesesPagos);
		
	}
	
	public void addRadioButtons() {
		JRadioButton radioBttProvedorInterno = new JRadioButton("Interno");
		radioBttProvedorInterno.setBounds(150, 180, 60, 30);
		add(radioBttProvedorInterno);
		radioBttProvedorInterno.setSelected(true);
		
		JRadioButton radioBttProvedorSMTP = new JRadioButton("SMTP");
		radioBttProvedorSMTP.setBounds(290 , 180, 60, 30);
		add(radioBttProvedorSMTP);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioBttProvedorInterno);
		group.add(radioBttProvedorSMTP);
	}
	
	public void addButtons() {
		JButton buttonCadastrar = new JButton("Cadastrar", new ImageIcon(getClass().getResource("/addMembro.png")));
		buttonCadastrar.setBackground(Color.gray);
		buttonCadastrar.setBounds(340, 470, 120, 50);
		add(buttonCadastrar);
		
		JButton buttonParticipar = new JButton("Participar");
		buttonParticipar.setBackground(Color.gray);
		buttonParticipar.setBounds(600, 400, 110, 30);
		add(buttonParticipar);
	}
	
	
	public class OuvinteCriarConta implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
//			switch (key) {
//			case value:
//				
//				break;
//
//			default:
//				break;
//			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new TelaCriarContaSwing();
	}
	
}
