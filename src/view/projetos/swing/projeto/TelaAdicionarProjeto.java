package view.projetos.swing.projeto;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.autenticacao.swing.SetLookAndFeel;

public class TelaAdicionarProjeto extends JFrame{

	public TelaAdicionarProjeto() {
		setTitle("Adicionar Projeto");
		setLayout(null);
		setResizable(false);
		setSize(500, 600);
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
		JLabel labelTitulo = new JLabel("Adicionar Projeto");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);
		
		JLabel labelNomeProjeto = new JLabel("Nome do Projeto");
		labelNomeProjeto.setFont(new Font("", Font.BOLD, 12));
		labelNomeProjeto.setBounds(120, 80, 100, 30);
		add(labelNomeProjeto);
		
		JLabel labelMembros = new JLabel("Membros");
		labelMembros.setFont(new Font("", Font.BOLD, 12));
		labelMembros.setBounds(120, 210, 60, 30);
		add(labelMembros);
		
		JLabel labelCapital = new JLabel("Capital");
		labelCapital.setFont(new Font("", Font.BOLD, 12));
		labelCapital.setBounds(170, 120, 50, 30);
		add(labelCapital);
		
		JLabel labelCusteio = new JLabel("Custeio");
		labelCusteio.setFont(new Font("", Font.BOLD, 12));
		labelCusteio.setBounds(170, 160, 50, 30);
		add(labelCusteio);
	}
	
	public void addTextField() {
		JTextField txtNomeProjeto = new JTextField();
		txtNomeProjeto.setBounds(230, 80, 210, 30);
		
		JTextField textCapital = new JTextField();
		textCapital.setBounds(230, 120, 100, 30);
		
		JTextField textCusteio = new JTextField();
		textCusteio.setBounds(230, 160, 100, 30);
		
		add(textCusteio);
		add(textCapital);
		add(txtNomeProjeto);
	}
	
	public void addJComboBox() {
		JComboBox<String> listMembros = new JComboBox<String>();
		listMembros.setBackground(Color.gray);
		listMembros.setBounds(100, 240, 100, 30);
		add(listMembros);
	}


	public void addButtons() {
		JButton buttonAddMembro = new JButton("Adicionar");
		buttonAddMembro.setBackground(Color.gray);
		buttonAddMembro.setBounds(300, 240, 120, 30);
		add(buttonAddMembro);
		
		JButton buttonNovoProjeto = new JButton("Novo Projeto");
		buttonNovoProjeto.setBackground(Color.gray);
		buttonNovoProjeto.setBounds(200, 290, 100, 30);
		add(buttonNovoProjeto);
		
		JButton buttonFinalizar = new JButton("Finalizar");
		buttonFinalizar.setBackground(Color.gray);
		buttonFinalizar.setBounds(200, 330, 100, 30);
		add(buttonFinalizar);
	}
	public static void main(String[] args) {
		new TelaAdicionarProjeto();
	}
}
