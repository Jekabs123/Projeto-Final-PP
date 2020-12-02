package view.projetos.swing;

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
import view.projetos.TelaPrincipal;

public class TelaPrincipalSwing extends JFrame implements TelaPrincipal {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();
	
	public TelaPrincipalSwing() {
		setTitle("Menu");
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
		JLabel labelTitulo = new JLabel("Menu");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(210, 20, 80, 50);
		add(labelTitulo);
	}

	public void addButtons() {
		JButton buttonProjetos = new JButton("Projetos",  new ImageIcon(getClass().getResource("/projetos.png")));
		buttonProjetos.setBounds(120, 80, 110, 70);
		buttonProjetos.setBackground(Color.gray);
		add(buttonProjetos);
		
		JButton buttonGrupos = new JButton("Grupos",  new ImageIcon(getClass().getResource("/grupos.png")));
		buttonGrupos.setBounds(270, 80, 110, 70);
		buttonGrupos.setBackground(Color.gray);
		add(buttonGrupos);
		
		JButton buttonEditais = new JButton("Editais",  new ImageIcon(getClass().getResource("/editais.png")));
		buttonEditais.setBounds(120, 180, 110, 70);
		buttonEditais.setBackground(Color.gray);
		add(buttonEditais);
		
		JButton buttonPontos = new JButton("Pontos",  new ImageIcon(getClass().getResource("/pontos.png")));
		buttonPontos.setBounds(270, 180, 110, 70);
		buttonPontos.setBackground(Color.gray);
		add(buttonPontos);
		
		OuvinteTelaPrincipal ouvinteTelaPrincipal = new OuvinteTelaPrincipal();
		
		buttonEditais.addActionListener(ouvinteTelaPrincipal);
		buttonGrupos.addActionListener(ouvinteTelaPrincipal);
		buttonPontos.addActionListener(ouvinteTelaPrincipal);
		buttonProjetos.addActionListener(ouvinteTelaPrincipal);
	}
	
	public class OuvinteTelaPrincipal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Projetos":
				dispose();
				fabricaTela.fabricarTelaCadastroProjetos();
		//		new TelaCadastrarProjetosSwing();
				break;

			case "Grupos":
				dispose();
				fabricaTela.fabricarTelaCadastroGrupos();
		//		new TelaCadastroGruposSwing();
				break;
				
			case "Editais":
				dispose();
				fabricaTela.fabricarTelaCadastrarEditais();
		//		new TelaCadastrarEditaisSwing();
				break;
			
			case "Pontos":
				dispose();
				fabricaTela.fabricarTelaPonto();
		//		new TelaPontoSwing();
				break;
			}
			
		}
		
	}
}
