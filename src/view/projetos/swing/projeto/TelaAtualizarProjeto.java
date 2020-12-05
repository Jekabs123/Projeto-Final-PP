package view.projetos.swing.projeto;

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

import controller.ControllerMembro;
import controller.ControllerProjeto;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAtualizarProjeto extends JFrame{

	private FabricaTela fabricaTela = new FabricaTelaSwing();
	private ControllerMembro controllerMembro = new ControllerMembro();
	private ControllerProjeto controllerProjeto = new ControllerProjeto();

	private JComboBox<String> listMembros;
	private JComboBox<String> listProjetos;
	private JComboBox<String> listMembrosProjeto;
	private JTextField txtNovoNome;
	private JTextField txtCapital;
	private JTextField txtCusteio;
	private JTextField txtGastoCapital;
	private JTextField txtGastoCusteio;
	private JTextField txtTermino;


	public TelaAtualizarProjeto() {
		setTitle("Atualizar Projeto");
		setLayout(null);
		setResizable(false);
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextFields();
		addComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Atualizar Projeto");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 320, 50);
		add(labelTitulo);

		JLabel labelGrupos = new JLabel("Projetos");
		labelGrupos.setFont(new Font("", Font.BOLD, 12));
		labelGrupos.setBounds(145, 80, 50, 30);
		add(labelGrupos);

		JLabel labelNome = new JLabel("Novo Nome");
		labelNome.setFont(new Font("", Font.BOLD, 12));
		labelNome.setBounds(310, 80, 70, 30);
		add(labelNome);

		JLabel labelCapital = new JLabel("Capital");
		labelCapital.setFont(new Font("", Font.BOLD, 12));
		labelCapital.setBounds(120, 150, 90, 30);
		add(labelCapital);

		JLabel labelCusteio = new JLabel("Custeio");
		labelCusteio.setFont(new Font("", Font.BOLD, 12));
		labelCusteio.setBounds(120, 190, 90, 30);
		add(labelCusteio);

		JLabel labelGastoCapital = new JLabel("Gasto Capital");
		labelGastoCapital.setFont(new Font("", Font.BOLD, 12));
		labelGastoCapital.setBounds(120, 230, 90, 30);
		add(labelGastoCapital);

		JLabel labelGastoCusteio = new JLabel("Gasto Custeio");
		labelGastoCusteio.setFont(new Font("", Font.BOLD, 12));
		labelGastoCusteio.setBounds(120, 270, 90, 30);
		add(labelGastoCusteio);

		JLabel labelTermino = new JLabel("Data Termino");
		labelTermino.setFont(new Font("", Font.BOLD, 12));
		labelTermino.setBounds(120, 310, 90, 30);
		add(labelTermino);
		
		JLabel labelMembros = new JLabel("Membros");
		labelMembros.setFont(new Font("", Font.BOLD, 12));
		labelMembros.setBounds(300, 350, 60, 30);
		add(labelMembros);

		JLabel labelMembrosProjeto = new JLabel("Membros no Projeto");
		labelMembrosProjeto.setFont(new Font("", Font.BOLD, 12));
		labelMembrosProjeto.setBounds(100, 350, 120, 30);
		add(labelMembrosProjeto);

	}

	public void addTextFields() {
		txtNovoNome = new JTextField();
		txtNovoNome.setBounds(270, 110, 130, 30);
		add(txtNovoNome);

		txtCapital = new JTextField();
		txtCapital.setBounds(270, 150, 90, 30);
		add(txtCapital);

		txtCusteio = new JTextField();
		txtCusteio.setBounds(270, 190, 90, 30);
		add(txtCusteio);

		txtGastoCapital = new JTextField();
		txtGastoCapital.setBounds(270, 230, 90, 30);
		add(txtGastoCapital);

		txtGastoCusteio = new JTextField();
		txtGastoCusteio.setBounds(270, 270, 90, 30);
		add(txtGastoCusteio);

		txtTermino = new JTextField();
		txtTermino.setBounds(270, 310, 90, 30);
		add(txtTermino);
	}

	public void addComboBox() {
		//Lista dos projetos
		String[] projetosComboBox = new String[controllerProjeto.getProjetos().size()];
		for (int i=0; i<controllerProjeto.getProjetos().size(); i++) {
			projetosComboBox[i] = (controllerProjeto.getProjetos().get(i).getNome());
		}

		listProjetos = new JComboBox<String>(projetosComboBox);
		listProjetos.setBackground(Color.gray);
		listProjetos.setBounds(100, 110, 130, 30);
		add(listProjetos);

		//Lista dos membros
		String[] membrosComboBox = new String[controllerMembro.getMembros().size()];
		for (int i=0; i<controllerMembro.getMembros().size(); i++) {
			membrosComboBox[i] = controllerMembro.getMembros().get(i).getNome();
		}

		listMembros = new JComboBox<String>(membrosComboBox);
		listMembros.setBackground(Color.gray);
		listMembros.setBounds(270, 380, 130, 30);
		add(listMembros);


		int index = listProjetos.getSelectedIndex();

		//Lista dos membros que estão no projeto selecionado
		String[] membrosProjetoComboBox = new String[controllerMembro.getMembros().size()];
		if(controllerProjeto.getProjetos().size() > 0) {
			for (int i=0; i<controllerProjeto.getProjetos().get(index).getMembros().size(); i++) {
				membrosProjetoComboBox[i] = controllerProjeto.getProjetos().get(index).getMembros().get(i).getNome();
			}
		}


		listMembrosProjeto = new JComboBox<String>(membrosProjetoComboBox);
		listMembrosProjeto.setBackground(Color.gray);
		listMembrosProjeto.setBounds(100, 380, 130, 30);
		add(listMembrosProjeto);
	}

	public void addButtons() {

		JButton buttonRemoverMembroDoGrupo = new JButton("Remover");
		buttonRemoverMembroDoGrupo.setBackground(Color.gray);
		buttonRemoverMembroDoGrupo.setBounds(100, 410, 80, 30);
		add(buttonRemoverMembroDoGrupo);

		JButton buttonAdionarMembroAoGrupo = new JButton("Adicionar");
		buttonAdionarMembroAoGrupo.setBackground(Color.gray);
		buttonAdionarMembroAoGrupo.setBounds(320, 410, 80, 30);
		add(buttonAdionarMembroAoGrupo);

		JButton buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBackground(Color.gray);
		buttonAtualizar.setBounds(100, 500, 100, 30);
		add(buttonAtualizar);

		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(300, 500, 100, 30);
		add(buttonFinalizar);

		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);

		OuvinteBotao ouvinteBotao = new OuvinteBotao();

		buttonAtualizar.addActionListener(ouvinteBotao);
		buttonFinalizar.addActionListener(ouvinteBotao);
		buttonVoltar.addActionListener(ouvinteBotao);
	}

	public class OuvinteBotao implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();

			int idProjeto = 0;
			for (int i = 0; i < controllerProjeto.getProjetos().size(); i++) {
				if(controllerProjeto.getProjetos().get(i).equals(controllerProjeto.getProjetos().get(listProjetos.getSelectedIndex()))) {
					idProjeto = controllerProjeto.getProjetos().get(i).getId();
				}
			}

			switch (evento) {
			case "Atualizar":
				int index = listProjetos.getSelectedIndex();
				
				String nomeProjeto = txtNovoNome.getText();
				float aporteCapitalReais = Float.parseFloat(txtCapital.getText());
				float aporteCusteioReais = Float.parseFloat(txtCusteio.getText());
				long dataTermino = Long.parseLong(txtTermino.getText());
				float gastoExecutadoCapitalReais = Float.parseFloat(txtGastoCapital.getText());
				float gastoExecutadoCusteioReais = Float.parseFloat(txtGastoCusteio.getText());

				for (int i = 0; i < controllerProjeto.getProjetos().size(); i++) {
					if(controllerProjeto.getProjetos().get(i).equals(controllerProjeto.getProjetos().get(index))) {
						controllerProjeto.setAtributosProjeto(controllerProjeto.getProjetos().get(index), nomeProjeto, aporteCapitalReais, aporteCusteioReais, dataTermino, gastoExecutadoCapitalReais, gastoExecutadoCusteioReais);
						controllerProjeto.atualizarProjeto();
						JOptionPane.showMessageDialog(null, "Grupo Atualizado");
						listProjetos.repaint();
					}
				}
				break;

			case "Finalizar":
				dispose();
				fabricaTela.fabricarTelaCadastroProjetos();
				break;

			case "Remover":
				int indexMembroProjeto = listMembrosProjeto.getSelectedIndex();
				for (int i = 0; i < controllerMembro.getMembros().size(); i++) {
					if(controllerMembro.getMembros().get(i).equals(controllerMembro.getMembros().get(indexMembroProjeto))) {
						controllerProjeto.removerMembroDoProjeto(controllerMembro.getMembros().get(indexMembroProjeto), idProjeto);
						JOptionPane.showMessageDialog(null, "Removido!");
					}
				}

				break;

			case "Adicionar":
				int indexMembro = listMembros.getSelectedIndex();
				for (int i = 0; i < controllerMembro.getMembros().size(); i++) {
					if(controllerMembro.getMembros().get(i).equals(controllerMembro.getMembros().get(indexMembro))) {
						controllerProjeto.adicionarMembroNoProjeto(controllerMembro.getMembros().get(indexMembro), idProjeto);
					}
				}

				break;
			}

		}

	}

}
