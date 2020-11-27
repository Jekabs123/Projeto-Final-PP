package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.swing.SetLookAndFeel;

public class TelaMostrarGrupos extends JFrame {
	
	public TelaMostrarGrupos() {
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

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Seus Grupos");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(150, 20, 200, 50);
		add(labelTitulo);
		
		JLabel labelGrupos = new JLabel("Grupos");
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
	}
	
	public static void main(String[] args) {
		new TelaMostrarGrupos();
	}

}
