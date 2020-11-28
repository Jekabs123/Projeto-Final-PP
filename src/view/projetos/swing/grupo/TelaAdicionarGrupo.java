package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.autenticacao.swing.SetLookAndFeel;

public class TelaAdicionarGrupo extends JFrame {
	
	public TelaAdicionarGrupo() {
		setTitle("Adicionar Grupo");
		setLayout(null);
		setResizable(false);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addTextField();
		addJComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Adicionar Grupo");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);
		
		JLabel labelNomeGrupo = new JLabel("Nome do Grupo");
		labelNomeGrupo.setFont(new Font("", Font.BOLD, 12));
		labelNomeGrupo.setBounds(120, 80, 90, 30);
		add(labelNomeGrupo);
		
		JLabel labelMembros = new JLabel("Membros");
		labelMembros.setFont(new Font("", Font.BOLD, 12));
		labelMembros.setBounds(135, 130, 60, 30);
		add(labelMembros);
		
	}
	
	public void addTextField() {
		JTextField txtNomeGrupo = new JTextField();
		txtNomeGrupo.setBounds(260, 80, 120, 30);
		add(txtNomeGrupo);
	}
	
	public void addJComboBox() {
		JComboBox<String> listMembros = new JComboBox<String>();
		listMembros.setBackground(Color.gray);
		listMembros.setBounds(120, 160, 100, 30);
		add(listMembros);
	}


	public void addButtons() {
		JButton buttonAddMembro = new JButton("Adicionar");
		buttonAddMembro.setBackground(Color.gray);
		buttonAddMembro.setBounds(260, 160, 120, 30);
		add(buttonAddMembro);
		
		JButton buttonNovoGrupo = new JButton("Novo Grupo");
		buttonNovoGrupo.setBackground(Color.gray);
		buttonNovoGrupo.setBounds(200, 230, 100, 30);
		add(buttonNovoGrupo);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 270, 100, 30);
		add(buttonFinalizar);
	}


}
