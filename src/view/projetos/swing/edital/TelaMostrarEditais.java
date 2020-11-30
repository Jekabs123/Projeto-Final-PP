package view.projetos.swing.edital;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.swing.SetLookAndFeel;

public class TelaMostrarEditais extends JFrame{

	public TelaMostrarEditais() {
		setTitle("Mostrar Editais");
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
		JLabel labelTitulo = new JLabel("Seus Editais");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(150, 20, 250, 50);
		add(labelTitulo);
		
		JLabel labelEditais = new JLabel("Editais");
		labelEditais.setFont(new Font("", Font.BOLD, 12));
		labelEditais.setBounds(225, 80, 50, 30);
		add(labelEditais);
	}

	public void addJComboBox() {
		JComboBox<String> listEditais = new JComboBox<String>();
		listEditais.setBackground(Color.gray);
		listEditais.setBounds(190, 110, 120, 30);
		add(listEditais);
	}

	public void addButtons() {
		JButton buttonOk = new JButton("Ok");
		buttonOk.setBackground(Color.gray);
		buttonOk.setBounds(200, 190, 100, 30);
		add(buttonOk);
	}

}
