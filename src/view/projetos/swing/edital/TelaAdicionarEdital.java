package view.projetos.swing.edital;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerEdital;
import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAdicionarEdital extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	private ControllerEdital controllerEdital = new ControllerEdital();
	
	private JTextField txtNomeEdital;
	private JTextField txtTermino;

	public TelaAdicionarEdital() {
		setTitle("Adicionar Edital");
		setLayout(null);
		setResizable(false);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextField();
		addButtons();

		setVisible(true);
		repaint();
	}
	
	public void addLabels() {
		JLabel labelTitulo = new JLabel("Adicionar Edital");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);
		
		JLabel labelNomeProjeto = new JLabel("Nome do Edital");
		labelNomeProjeto.setFont(new Font("", Font.BOLD, 12));
		labelNomeProjeto.setBounds(120, 80, 100, 30);
		add(labelNomeProjeto);
		
		JLabel labelTermino = new JLabel("Data Termino");
		labelTermino.setFont(new Font("", Font.BOLD, 12));
		labelTermino.setBounds(120, 120, 100, 30);
		add(labelTermino);
		
	}
	
	public void addTextField() {
		txtNomeEdital = new JTextField();
		txtNomeEdital.setBounds(230, 80, 210, 30);
		
		txtTermino = new JTextField();
		txtTermino.setBounds(230, 120, 100, 30);
		
		add(txtNomeEdital);
		add(txtTermino);
	}


	public void addButtons() {
		JButton buttonAdd = new JButton("Criar");
		buttonAdd.setBackground(Color.gray);
		buttonAdd.setBounds(200, 190, 100, 30);
		add(buttonAdd);
		
		JButton buttonNovoProjeto = new JButton("Novo Edital");
		buttonNovoProjeto.setBackground(Color.gray);
		buttonNovoProjeto.setBounds(200, 240, 100, 30);
		add(buttonNovoProjeto);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 290, 100, 30);
		add(buttonFinalizar);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteAdicionarEdital ouvinteAdicionarEdital = new OuvinteAdicionarEdital();
		buttonAdd.addActionListener(ouvinteAdicionarEdital);
		buttonFinalizar.addActionListener(ouvinteAdicionarEdital);
		buttonNovoProjeto.addActionListener(ouvinteAdicionarEdital);
		buttonVoltar.addActionListener(ouvinteAdicionarEdital);
		
	}
	
	public class OuvinteAdicionarEdital implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();

//			if(txtNomeEdital.getText().equals("") || txtTermino.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, "Há Campos Vazios!");
//			}
				switch (evento) {		
				case "Criar":
					long dataTermino = Long.parseLong(txtTermino.getText());
					controllerEdital.adicionarEdital(txtNomeEdital.getText(), dataTermino);
					JOptionPane.showMessageDialog(null, "Criado!");
					break;

				case "Novo Edital":
					dispose();
					new TelaAdicionarEdital();
					break;
					
				case "Finalizar":
					dispose();
					fabricaTela.fabricarTelaCadastrarEditais();
					break;
				
				case "":
					dispose();
					fabricaTela.fabricarTelaCadastrarEditais();
					break;
				}
			
			
		}
		
	}
}
