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
import fachadas.Fachada1Membro;
import fachadas.Fachada5Projeto;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAdicionarProjeto extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	
	private ControllerProjeto controllerProjeto = new ControllerProjeto();
	private ControllerMembro controllerMembro = new ControllerMembro();
	
	private JComboBox<String> listMembros;
	private JTextField txtNomeProjeto;
	private JTextField textCapital;
	private JTextField textCusteio;
	private JButton buttonAddMembro;

	public TelaAdicionarProjeto() {
		setTitle("Adicionar Projeto");
		setLayout(null);
		setResizable(false);
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextField();
		addJComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}
	
	public void addLabels() {
		JLabel labelTitulo = new JLabel("Adicionar Projeto");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);
		
		JLabel labelNomeProjeto = new JLabel("Nome do Projeto");
		labelNomeProjeto.setFont(new Font("", Font.BOLD, 12));
		labelNomeProjeto.setBounds(120, 80, 100, 30);
		add(labelNomeProjeto);
		
		JLabel labelMembros = new JLabel("Membros");
		labelMembros.setFont(new Font("", Font.BOLD, 12));
		labelMembros.setBounds(120, 260, 60, 30);
		add(labelMembros);
		
		JLabel labelCapital = new JLabel("Capital");
		labelCapital.setFont(new Font("", Font.BOLD, 12));
		labelCapital.setBounds(170, 120, 50, 30);
		add(labelCapital);
		
		JLabel labelCusteio = new JLabel("Custeio");
		labelCusteio.setFont(new Font("", Font.BOLD, 12));
		labelCusteio.setBounds(170, 160, 50, 30);
		add(labelCusteio);
	}
	
	public void addTextField() {
		txtNomeProjeto = new JTextField();
		txtNomeProjeto.setBounds(230, 80, 210, 30);
		
		textCapital = new JTextField();
		textCapital.setBounds(230, 120, 100, 30);
		
		textCusteio = new JTextField();
		textCusteio.setBounds(230, 160, 100, 30);
		
		add(textCusteio);
		add(textCapital);
		add(txtNomeProjeto);
	}
	
	public void addJComboBox() {
		String[] membrosComboBox = new String[controllerProjeto.getProjetos().size()];
		
		for (int i=0; i<controllerMembro.getMembros().size(); i++) {
			membrosComboBox[i] = controllerMembro.getMembros().get(i).getNome();
		}
		
		listMembros = new JComboBox<String>(membrosComboBox);
		listMembros.setBackground(Color.gray);
		listMembros.setBounds(100, 290, 100, 30);
		add(listMembros);
	}


	public void addButtons() {
		buttonAddMembro = new JButton("Adicionar");
		buttonAddMembro.setBackground(Color.gray);
		buttonAddMembro.setBounds(300, 290, 120, 30);
		buttonAddMembro.setEnabled(false);
		add(buttonAddMembro);
		
		JButton buttonNovoProjeto = new JButton("Novo Projeto");
		buttonNovoProjeto.setBackground(Color.gray);
		buttonNovoProjeto.setBounds(200, 340, 100, 30);
		add(buttonNovoProjeto);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 380, 100, 30);
		add(buttonFinalizar);
		
		JButton buttonCriarProjeto = new JButton("Criar Projeto");
		buttonCriarProjeto.setBackground(Color.gray);
		buttonCriarProjeto.setBounds(200, 200, 100, 30);
		add(buttonCriarProjeto);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteTelaCadastroProjetos ouvinteTelaCadastroProjetos = new OuvinteTelaCadastroProjetos();
		
		buttonCriarProjeto.addActionListener(ouvinteTelaCadastroProjetos);
		buttonNovoProjeto.addActionListener(ouvinteTelaCadastroProjetos);
		buttonFinalizar.addActionListener(ouvinteTelaCadastroProjetos);
		buttonVoltar.addActionListener(ouvinteTelaCadastroProjetos);
	}
	
	public class OuvinteTelaCadastroProjetos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			
			case "Criar Projeto":
				float capital = Float.parseFloat(textCapital.getText());
				float custeio = Float.parseFloat(textCusteio.getText());
				controllerProjeto.adicionarProjeto(txtNomeProjeto.getText(), capital, custeio, 2020);
				buttonAddMembro.setEnabled(true);
				break;
			
			case "Adicionar":
				int index = listMembros.getSelectedIndex();
				
				for (int i = 0; i < controllerMembro.getMembros().size(); i++) {
					if(!controllerMembro.getMembros().get(i).equals(controllerMembro.getMembros().get(index))) {
						controllerProjeto.adicionarMembroNoProjeto(controllerMembro.getMembros().get(index));
						JOptionPane.showMessageDialog(null, "Membro Adicionado ao Projeto!");
						break;

				//	}else {
				//		JOptionPane.showMessageDialog(null, "Membro Já Adicionado!");
					}
				}
				
				break;

			case "":
				dispose();
				fabricaTela.fabricarTelaCadastroProjetos();
				break;
			}
			
		}
		
	}
	
}
