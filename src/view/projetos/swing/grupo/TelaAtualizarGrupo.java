package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.autenticacao.swing.SetLookAndFeel;

public class TelaAtualizarGrupo extends JFrame {


	public TelaAtualizarGrupo() {
		setTitle("Atualizar Grupo");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextFields();
		addComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Atualizar Grupo");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 300, 50);
		add(labelTitulo);

		JLabel labelGrupos = new JLabel("Grupos");
		labelGrupos.setFont(new Font("", Font.BOLD, 12));
		labelGrupos.setBounds(145, 80, 50, 30);
		add(labelGrupos);
		
		JLabel labelNome = new JLabel("Novo Nome");
		labelNome.setFont(new Font("", Font.BOLD, 12));
		labelNome.setBounds(310, 80, 70, 30);
		add(labelNome);
		
	}
	
	public void addTextFields() {
		JTextField txtNovoNome = new JTextField();
		txtNovoNome.setBounds(270, 110, 130, 30);
		add(txtNovoNome);
	}

	public void addComboBox() {
		JComboBox<String> listGrupos = new JComboBox<String>();
		listGrupos.setBackground(Color.gray);
		listGrupos.setBounds(100, 110, 130, 30);
		add(listGrupos);
	}

	public void addButtons() {
		JButton buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBackground(Color.gray);
		buttonAtualizar.setBounds(100, 190, 100, 30);
		add(buttonAtualizar);

		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(300, 190, 100, 30);
		add(buttonFinalizar);
	}
	
	public static void main(String[] args) {
		new TelaAtualizarGrupo();
	}

}
