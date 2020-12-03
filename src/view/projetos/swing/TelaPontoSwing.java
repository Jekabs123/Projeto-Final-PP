package view.projetos.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

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

import org.apache.commons.mail.EmailException;

import controller.ControllerTelaPonto;
import fachadas.Fachada11BaterPonto;
import fachadas.Fachada13Horario;
import fachadas.Fachada1Membro;
import fachadas.Fachada2Autenticacao;
import fachadas.Fachada5Projeto;
import fachadas.Fachada9MembroRealizarLogout;
import model.autenticacao.Membro;
import model.autenticacao.TipoProvedorAutenticacao;
import model.projetos.Projeto;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.projetos.TelaPonto;

// CLASSE CLIENTE DO PROXY

public class TelaPontoSwing extends JFrame implements TelaPonto {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();

	private Fachada13Horario fachadaHorario = new Fachada13Horario();
	private Fachada2Autenticacao fachadaAutenticacao = new Fachada2Autenticacao();
	private Fachada11BaterPonto fachadaBaterPonto = new Fachada11BaterPonto();

	private OuvinteBaterPonto ouvinteBaterPonto = new OuvinteBaterPonto();

	private boolean liberarBaterPonto = false;
	private boolean liberarDetalhes = false;

	private JComboBox<Projeto> listComboBox;
	private JTextField textLogin;
	private JTextField textSenha;
	private JRadioButton provedorInterno;
	private JRadioButton provedorSMTP;

	public TelaPontoSwing() {
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
		comboBox();
		radioButton();
		addButtons();
	
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

	public void comboBox() {
		Projeto[] projetosComboBox = new Projeto[Fachada5Projeto.getProjetosPersistidos().size()];
		int i = 0;
		for (Projeto projeto : Fachada5Projeto.getProjetosPersistidos()) {
			for (Membro membro : projeto.getMembros()) {
					if(Fachada9MembroRealizarLogout.isOnline(membro.getLogin())) {
						projetosComboBox[i] =  projeto;
					}
			}
			i+=1;
		}
		
		listComboBox = new JComboBox<Projeto>(projetosComboBox);
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


	public void addButtons() {
		JButton btBaterPonto = new JButton("Bater Ponto");
		btBaterPonto.setBounds(150, 290, 100, 30);
		add(btBaterPonto);

		btBaterPonto.addActionListener(ouvinteBaterPonto);
		
		JButton btDetalhes = new JButton("Ver Detalhes");
		btDetalhes.setBounds(150, 340, 100, 30);
		add(btDetalhes);

		btDetalhes.addActionListener(ouvinteBaterPonto);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(20, 340, 100, 30);
		add(btVoltar);

		btVoltar.addActionListener(ouvinteBaterPonto);
		
		JButton btLogout = new JButton("Logout");
		btLogout.setBounds(270, 340, 100, 30);
		add(btLogout);

		btLogout.addActionListener(ouvinteBaterPonto);
		
		JButton btLogar = new JButton("Logar");
		btLogar.setBounds(150, 170, 100, 30);
		add(btLogar);

		btLogar.addActionListener(ouvinteBaterPonto);

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
					for (Membro membro: Fachada1Membro.getMembros()) {
						if(membro.getLogin().equals(textLogin.getText()) && membro.getSenha().equals(textSenha.getText())) {
							Fachada9MembroRealizarLogout.realizarLogin(membro);
							try {
								fachadaAutenticacao.autenticarContaEmailProvedor(textLogin.getText(), textSenha.getText(), provedor);
							} catch (EmailException e1) {
								JOptionPane.showMessageDialog(null, "Login ou senha não existe no provedor SMTP");
							}
							JOptionPane.showMessageDialog(null, "Logado");
							liberarBaterPonto = true;
							break;
						} else{
							JOptionPane.showMessageDialog(null, "Login não cadastrado");
							
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não há ninguém cadastrado");
				}

				break;

			case "Bater Ponto":


				if(liberarBaterPonto==true) {
					Membro membro = null;
					for(Membro x : Fachada1Membro.getMembros()){
						if(x.getLogin().equals(textLogin.getText())){
							membro = x;
							break;
						}
					}
					LocalDateTime localTime = LocalDateTime.now();
					fachadaBaterPonto.baterPonto(membro.getParticipacao(),localTime.getHour(),localTime.getHour()+8);
					liberarDetalhes = true;
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa estar Logado");
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
					JOptionPane.showMessageDialog(null, "Você precisa bater o ponto");
				}

				break;
				
			case "Logout":
				for (int i = 0; i < Fachada1Membro.getMembros().size(); i++) {
					Fachada9MembroRealizarLogout.realizarLogout(Fachada1Membro.getMembros().get(i).getLogin());
				}
				dispose();
				
				break;
				
			case "Voltar":
				dispose();
				fabricaTela.fabricarTelaPrincipal();
		//		new TelaPrincipalSwing();
				break;
			}

		}

	}

}
