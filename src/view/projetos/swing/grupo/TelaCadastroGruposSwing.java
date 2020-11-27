package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.swing.SetLookAndFeel;

public class TelaCadastroGruposSwing extends JFrame {
	
	public TelaCadastroGruposSwing() {
		setTitle("Gerenciamento de Grupos");
		setLayout(null);
		setResizable(false);
		setSize(505, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addButtons();

		setVisible(true);
		repaint();
	}

	private void addLabels() {
		JLabel labelTitulo = new JLabel("Gerenciar Grupos");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);
	}

	private void addButtons() {
		JButton buttonAdicionar = new JButton("Adicionar",  new ImageIcon(getClass().getResource("/addGrupo.png")));
		buttonAdicionar.setBounds(50, 100, 110, 70);
		buttonAdicionar.setBackground(Color.gray);
		add(buttonAdicionar);
		
		JButton buttonRemover = new JButton("Remover",  new ImageIcon(getClass().getResource("/removerGrupo.png")));
		buttonRemover.setBounds(200, 100, 110, 70);
		buttonRemover.setBackground(Color.gray);
		add(buttonRemover);
		
		JButton buttonAtualizar = new JButton("Atualizar",  new ImageIcon(getClass().getResource("/atualizar.png")));
		buttonAtualizar.setBounds(350, 100, 110, 70);
		buttonAtualizar.setBackground(Color.gray);
		add(buttonAtualizar);
	}
	
	public static void main(String[] args) {
		new TelaCadastroGruposSwing();
	}

}
