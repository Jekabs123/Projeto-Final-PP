package view.projetos.swing;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.autenticacao.swing.SetLookAndFeel;
import view.projetos.TelaJustificativaPonto;

public class TelaJustificativaPontoSwing extends JFrame implements TelaJustificativaPonto {
	
	public TelaJustificativaPontoSwing() {
		setTitle("Justificar Ponto");
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

	private void addLabels() {
		JLabel labelTitulo = new JLabel("Justificar Ponto");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 300, 50);
		add(labelTitulo);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(new Font("", Font.BOLD, 12));
		labelLogin.setBounds(70, 90, 50, 30);
		add(labelLogin);
		
		JLabel labelJustificativa = new JLabel("Justificativa");
		labelJustificativa.setFont(new Font("", Font.BOLD, 12));
		labelJustificativa.setBounds(215, 140, 70, 30);
		add(labelJustificativa);
	}

	private void addTextField() {
		JTextField txtLogin = new JTextField();
		txtLogin.setBounds(150, 90, 200, 30);
		add(txtLogin);
		
		JTextArea txtJustificatica = new JTextArea();
		txtJustificatica.setBounds(100, 180, 300, 70);
		add(txtJustificatica);
	}

	private void addButtons() {
		JButton buttonJustificar = new JButton("Justificar");
		buttonJustificar.setBounds(200, 300, 100, 30);
		add(buttonJustificar);
	}

}
