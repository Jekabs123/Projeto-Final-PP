package view.projetos.swing.projeto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaMostrarProjetos extends JFrame {
	
	private FabricaTela fabricaTela = new FabricaTelaSwing();

	public TelaMostrarProjetos() {
		setTitle("Mostrar Projeto");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addJComboBox();
		addButtons();

		setVisible(true);
		repaint();

	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Seus Projetos");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(150, 20, 250, 50);
		add(labelTitulo);
		
		JLabel labelGrupos = new JLabel("Projetos");
		labelGrupos.setFont(new Font("", Font.BOLD, 12));
		labelGrupos.setBounds(225, 80, 50, 30);
		add(labelGrupos);
	}

	public void addJComboBox() {
		JComboBox<String> listGrupos = new JComboBox<String>();
		listGrupos.setBackground(Color.gray);
		listGrupos.setBounds(190, 110, 120, 30);
		add(listGrupos);
	}

	public void addButtons() {
		JButton buttonOk = new JButton("Ok");
		buttonOk.setBackground(Color.gray);
		buttonOk.setBounds(200, 190, 100, 30);
		add(buttonOk);
		
		OuvinteMostrarProjetos ouvinteMostrarProjetos = new OuvinteMostrarProjetos();
		buttonOk.addActionListener(ouvinteMostrarProjetos);
		
	}
	
	public class OuvinteMostrarProjetos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			if(evento.equals("Ok")) {
				dispose();
				fabricaTela.fabricarTelaCadastroProjetos();
			}
				
			
		}
		
	}

}
