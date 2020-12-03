package view.projetos.swing.edital;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;
import view.projetos.TelaCadastroEditais;

public class TelaCadastrarEditaisSwing extends JFrame implements TelaCadastroEditais {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	
	public TelaCadastrarEditaisSwing() {
		setTitle("Gerenciamento de Editais");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Gerenciar Editais");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 430, 50);
		add(labelTitulo);
	}

	public void addButtons() {
		JButton buttonAdicionar = new JButton("Adicionar");
		buttonAdicionar.setBounds(120, 80, 110, 70);
		buttonAdicionar.setBackground(Color.gray);
		add(buttonAdicionar);
		
		JButton buttonRemover = new JButton("Remover");
		buttonRemover.setBounds(270, 80, 110, 70);
		buttonRemover.setBackground(Color.gray);
		add(buttonRemover);
		
		JButton buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBounds(120, 180, 110, 70);
		buttonAtualizar.setBackground(Color.gray);
		add(buttonAtualizar);
		
		JButton buttonMostrarEditais = new JButton("Editais");
		buttonMostrarEditais.setBounds(270, 180, 110, 70);
		buttonMostrarEditais.setBackground(Color.gray);
		add(buttonMostrarEditais);
		
		JButton buttonVoltar = new JButton(new ImageIcon(getClass().getResource("/voltar.png")));
		buttonVoltar.setBackground(Color.gray);
		buttonVoltar.setBounds(15, 15, 20, 20);
		add(buttonVoltar);
		
		OuvinteTelaCadastroEditais ouvinteTelaCadastroEditais = new OuvinteTelaCadastroEditais();
		
		buttonAdicionar.addActionListener(ouvinteTelaCadastroEditais);
		buttonRemover.addActionListener(ouvinteTelaCadastroEditais);
		buttonAtualizar.addActionListener(ouvinteTelaCadastroEditais);
		buttonMostrarEditais.addActionListener(ouvinteTelaCadastroEditais);
		buttonVoltar.addActionListener(ouvinteTelaCadastroEditais);
	}
	
	public class OuvinteTelaCadastroEditais implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Adicionar":
				dispose();
				new TelaAdicionarEdital();
				break;

			case "Remover":
				dispose();
				new TelaRemoverEdital();
				break;
				
			case "Atualizar":
				dispose();
				new TelaAtualizarEdital();
				break;
			
			case "Editais":
				dispose();
				new TelaMostrarEditais();
				break;
				
			case "":
				dispose();
				fabricaTela.fabricarTelaPrincipal();
				break;
			}
			
		}
	}

}
