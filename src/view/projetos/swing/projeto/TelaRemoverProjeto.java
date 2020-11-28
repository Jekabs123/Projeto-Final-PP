package view.projetos.swing.projeto;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.swing.SetLookAndFeel;

public class TelaRemoverProjeto extends JFrame{

	public TelaRemoverProjeto() {
		setTitle("Remover Projeto");
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
		JLabel labelTitulo = new JLabel("Remover Projeto");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(125, 20, 250, 50);
		add(labelTitulo);
		
		JLabel labelProjetos = new JLabel("Projetos");
		labelProjetos.setFont(new Font("", Font.BOLD, 12));
		labelProjetos.setBounds(150, 80, 60, 30);
		add(labelProjetos);
	}

	private void addJComboBox() {
		JComboBox<String> listProjetos = new JComboBox<String>();
		listProjetos.setBackground(Color.gray);
		listProjetos.setBounds(120, 110, 120, 30);
		add(listProjetos);
	}

	private void addButtons() {
		JButton buttonRemoverProjeto = new JButton("Remover");
		buttonRemoverProjeto.setBackground(Color.gray);
		buttonRemoverProjeto.setBounds(280, 110, 100, 30);
		add(buttonRemoverProjeto);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 190, 100, 30);
		add(buttonFinalizar);
	}
}
