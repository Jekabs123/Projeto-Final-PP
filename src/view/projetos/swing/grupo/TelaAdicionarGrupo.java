package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerGrupo;
import controller.ControllerMembro;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAdicionarGrupo extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();

	private JTextField txtNomeGrupo;
	private JComboBox<String> listMembros;

	private ControllerMembro controllerMembro = new ControllerMembro();
	
	ControllerGrupo controllerGrupo = new ControllerGrupo();

	private OuvinteTelaAdicionarGrupo ouvinteTelaAdicionarGrupo = new OuvinteTelaAdicionarGrupo();

	public TelaAdicionarGrupo() {
		setTitle("Adicionar Grupo");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextField();
		//		addJComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Adicionar Grupo");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);

		JLabel labelNomeGrupo = new JLabel("Nome do Grupo");
		labelNomeGrupo.setFont(new Font("", Font.BOLD, 12));
		labelNomeGrupo.setBounds(120, 80, 90, 30);
		add(labelNomeGrupo);

		//		JLabel labelMembros = new JLabel("Membros");
		//		labelMembros.setFont(new Font("", Font.BOLD, 12));
		//		labelMembros.setBounds(135, 130, 60, 30);
		//		add(labelMembros);

	}

	public void addTextField() {
		txtNomeGrupo = new JTextField();
		txtNomeGrupo.setBounds(260, 80, 120, 30);
		add(txtNomeGrupo);
	}

	//	public void addJComboBox() {
	//		JComboBox<String> listMembros = new JComboBox<String>();
	//		listMembros.setBackground(Color.gray);
	//		listMembros.setBounds(120, 160, 100, 30);
	//		add(listMembros);
	//	}


	public void addButtons() {
		//		JButton buttonAddMembro = new JButton("Adicionar");
		//		buttonAddMembro.setBackground(Color.gray);
		//		buttonAddMembro.setBounds(260, 160, 120, 30);
		//		add(buttonAddMembro);

		JButton buttonNovoGrupo = new JButton("Novo Grupo");
		buttonNovoGrupo.setBackground(Color.gray);
		buttonNovoGrupo.setBounds(200, 150, 100, 30);
		add(buttonNovoGrupo);

		JButton buttonFinalizar = new JButton("Criar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 190, 100, 30);
		add(buttonFinalizar);

		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);

		//	buttonAddMembro.addActionListener(ouvinteTelaAdicionarGrupo);
		buttonNovoGrupo.addActionListener(ouvinteTelaAdicionarGrupo);
		buttonFinalizar.addActionListener(ouvinteTelaAdicionarGrupo);
		buttonVoltar.addActionListener(ouvinteTelaAdicionarGrupo);
	}

	private class AdicionarMembros extends JFrame {

		public AdicionarMembros() {
			setLayout(null);
			setResizable(false);
			setSize(200, 200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			SetLookAndFeel.addLookAndFeel();

			JLabel labelMembros = new JLabel("Membros");
			labelMembros.setFont(new Font("", Font.BOLD, 12));
			labelMembros.setBounds(70, 10, 60, 20);
			add(labelMembros);

			String[] membrosComboBox = new String[controllerGrupo.getGrupos().size()];
			
			for (int i=0; i<controllerMembro.getMembros().size(); i++) {
				membrosComboBox[i] = controllerMembro.getMembros().get(i).getNome();
			}

			listMembros = new JComboBox<String>(membrosComboBox);
			listMembros.setBackground(Color.gray);
			listMembros.setBounds(50, 30, 100, 30);
			add(listMembros);

			JButton buttonAddMembro = new JButton("Add");
			buttonAddMembro.setBackground(Color.gray);
			buttonAddMembro.setBounds(110, 100, 70, 30);
			add(buttonAddMembro);

			JButton buttonVoltar = new JButton("Voltar");
			buttonVoltar.setBackground(Color.gray);
			buttonVoltar.setBounds(20, 100, 70, 30);
			add(buttonVoltar);

			buttonAddMembro.addActionListener(ouvinteTelaAdicionarGrupo);
			buttonVoltar.addActionListener(ouvinteTelaAdicionarGrupo);

			setVisible(true);
			repaint();
		}
	}

	public class OuvinteTelaAdicionarGrupo implements ActionListener {

		private AdicionarMembros addMembros;

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();

			switch (evento) {
			
			case "Novo Grupo":
				dispose();
				new TelaAdicionarGrupo();
				break;

			case "Criar":
				controllerGrupo.addGrupo(txtNomeGrupo.getText());

				addMembros = new AdicionarMembros();
				break;

			case "":
				dispose();
				fabricaTela.fabricarTelaCadastroGrupos();
	//			new TelaCadastroGruposSwing();
				break;

			case "Add":
				int index = listMembros.getSelectedIndex();

				for (int i = 0; i < controllerMembro.getMembros().size(); i++) {
					if(!controllerMembro.getMembros().get(i).equals(controllerMembro.getMembros().get(index))) {
						controllerGrupo.addMembroAogrupo(controllerMembro.getMembros().get(index));
						JOptionPane.showMessageDialog(null, "Membro Adicionado ao Grupo!");
						break;

			//		}else {
			//			JOptionPane.showMessageDialog(null, "Membro Já Adicionado!");
					}
				}

				break;

			case "Voltar":
				addMembros.dispose();
				break;

			}	

		}

	}


}
