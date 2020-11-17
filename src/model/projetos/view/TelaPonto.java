package model.projetos.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import fachadas.Fachada13Horario;
import fachadas.Fachada1Membro;
import fachadas.Fachada2Autenticacao;
import fachadas.Fachada5Projeto;
import fachadas.Fachada9MembroRealizarLogout;
import model.autenticacao.TipoProvedorAutenticacao;
import model.projetos.Projeto;
import model.projetos.controller.ControllerTelaPonto;

// CLASSE CLIENTE DO PROXY

public class TelaPonto extends JFrame {

	private Fachada13Horario fachadaHorario = new Fachada13Horario();
	private Fachada2Autenticacao fachadaAutenticacao = new Fachada2Autenticacao();

	private OuvinteBaterPonto ouvinteBaterPonto = new OuvinteBaterPonto();

	private boolean liberarBaterPonto = false;
	private boolean liberarDetalhes = false;

	private JComboBox<String> listComboBox;
	private JTextField textLogin;
	private JTextField textSenha;
	private JRadioButton provedorInterno;
	private JRadioButton provedorSMTP;

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
		radioButton();
		botaoBaterPonto(null, null);
		botaoVerDetalhes();
		setVisible(true);

		repaint();
	}

	public void labels() {
		JLabel labelProjeto = new JLabel("Projetos");
		labelProjeto.setBounds(30, 220, 60, 30);
		add(labelProjeto);

		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(30, 30, 60, 30);
		add(labelLogin);

		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(30, 70, 60, 30);
		add(labelSenha);
	}

	public void textFields() {
		textLogin = new JTextField();
		textLogin.setBounds(110, 30, 200, 30);
		add(textLogin);

		textSenha = new JPasswordField();
		textSenha.setBounds(110, 70, 200, 30);
		add(textSenha);
	}

	public void buttonLogar() {
		JButton btBaterPonto = new JButton("Logar");
		btBaterPonto.setBounds(150, 170, 100, 30);
		add(btBaterPonto);

		btBaterPonto.addActionListener(ouvinteBaterPonto);
	}

	public void comboBox() {
		String[] projetosComboBox = new String[Fachada5Projeto.getProjetosPersistidos().size()];
		for (int i = 0; i < Fachada5Projeto.getProjetosPersistidos().size(); i++) {
			projetosComboBox[i] =  Fachada5Projeto.getProjetosPersistidos().get(i).getNome();
		}
		
		listComboBox = new JComboBox<String>(projetosComboBox);
		listComboBox.setBounds(110, 220, 200, 30);
		add(listComboBox);
	}

	public void radioButton() {
		provedorInterno = new JRadioButton("Provedor Interno");
		provedorInterno.setBounds(30, 120, 150, 30);
		provedorInterno.setSelected(true);

		provedorSMTP = new JRadioButton("Provedor SMTP");
		provedorSMTP.setBounds(200, 120, 150, 30);

		ButtonGroup group = new ButtonGroup();
		group.add(provedorInterno);
		group.add(provedorSMTP);

		add(provedorInterno);
		add(provedorSMTP);
	}


	public void botaoBaterPonto(Projeto projeto, String login) {
		JButton btBaterPonto = new JButton("Bater Ponto");
		btBaterPonto.setBounds(150, 290, 100, 30);
		add(btBaterPonto);

		btBaterPonto.addActionListener(ouvinteBaterPonto);

	}

	public void botaoVerDetalhes() {
		JButton btBaterPonto = new JButton("Ver Detalhes");
		btBaterPonto.setBounds(150, 340, 100, 30);
		add(btBaterPonto);

		btBaterPonto.addActionListener(ouvinteBaterPonto);
	}


	public class OuvinteBaterPonto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String evento = e.getActionCommand();

			ControllerTelaPonto controllerTelaPonto = new ControllerTelaPonto();

			Projeto projetoSelecionado = (Projeto)listComboBox.getSelectedItem();

			switch (evento) {

			case "Logar":

				TipoProvedorAutenticacao provedor;

				if (provedorInterno.isSelected()) {
					provedor = TipoProvedorAutenticacao.INTERNO;
				}else {
					provedor = TipoProvedorAutenticacao.EMAIL_SMTP;
				}

				if(Fachada1Membro.getMembros().size() > 0) {
					for (int i = 0; i < Fachada1Membro.getMembros().size();  ) {
						if(Fachada1Membro.getMembros().get(i).getLogin().equals(textLogin.getText()) && 
								Fachada1Membro.getMembros().get(i).getSenha().equals(textSenha.getText())) {

							Fachada9MembroRealizarLogout.realizarLogin(Fachada1Membro.getMembros().get(i));
							Fachada9MembroRealizarLogout.isOnline(textLogin.getText());
							fachadaAutenticacao.autenticarContaEmailProvedor(textLogin.getText(), textSenha.getText(), provedor);
							JOptionPane.showMessageDialog(null, "Logado");
							liberarBaterPonto = true;
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Login não cadastrado");
							break;
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não há ninguém cadastrado");
				}

				break;

			case "Bater Ponto":

				//TODO acho que tem que usar a fachada, né isso? 

				if(liberarBaterPonto==true) {
					controllerTelaPonto.conectarProxy(projetoSelecionado, textLogin.getText());
					liberarDetalhes = true;
				} else {
					JOptionPane.showMessageDialog(null, "Você precisar estar Logado");
				}


				break;

			case "Ver Detalhes":

				if(liberarDetalhes==true) {
					JOptionPane.showMessageDialog(null, "Horas Trabalhadas: " + 
							fachadaHorario.horasTrabalhadas(projetoSelecionado.getDataInicio(), projetoSelecionado.getDataTermino(), textLogin.getText())
					+ "\nDéficit Horas: " + 
					controllerTelaPonto.deficitHoras(projetoSelecionado.getDataInicio(), projetoSelecionado.getDataTermino(), textLogin.getText())
					+ "\nPontos Inválidos: " +
					controllerTelaPonto.pontosInvalidos(textLogin.getText()));
				} else {
					JOptionPane.showMessageDialog(null, "Você precisar bater o ponto");
				}

				break;
			}

		}

	}

}
