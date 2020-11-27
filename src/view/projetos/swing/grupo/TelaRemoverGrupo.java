package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.swing.SetLookAndFeel;

public class TelaRemoverGrupo extends JFrame {
	
	public TelaRemoverGrupo() {
		setTitle("Remover Grupo");
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

	private void addLabels() {
		JLabel labelTitulo = new JLabel("Remover Grupo");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(125, 20, 250, 50);
		add(labelTitulo);
		
		JLabel labelGrupos = new JLabel("Grupos");
		labelGrupos.setFont(new Font("", Font.BOLD, 12));
		labelGrupos.setBounds(150, 80, 60, 30);
		add(labelGrupos);
	}

	private void addJComboBox() {
		JComboBox<String> listGrupos = new JComboBox<String>();
		listGrupos.setBackground(Color.gray);
		listGrupos.setBounds(120, 110, 120, 30);
		add(listGrupos);
	}

	private void addButtons() {
		JButton buttonRemoverGrupo = new JButton("Remover");
		buttonRemoverGrupo.setBackground(Color.gray);
		buttonRemoverGrupo.setBounds(280, 110, 100, 30);
		add(buttonRemoverGrupo);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 190, 100, 30);
		add(buttonFinalizar);
	}

}
