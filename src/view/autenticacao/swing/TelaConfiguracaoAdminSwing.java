package view.autenticacao.swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.autenticacao.TelaConfiguracaoAdmin;

public class TelaConfiguracaoAdminSwing extends JFrame implements TelaConfiguracaoAdmin {
	
	public TelaConfiguracaoAdminSwing() {
		setTitle("Configurações do Administrador");
		setLayout(null);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		SetLookAndFeel.addLookAndFeel();
		addLabels();
		addComboBox();
		addButtons();

		setVisible(true);
		repaint();
	}

	public void addLabels() {
		JLabel labelTitulo = new JLabel("Habilitar Membros");
		labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 30));
		labelTitulo.setBounds(100, 20, 400, 50);
		add(labelTitulo);
		
		JLabel labelMembros = new JLabel("Membros");
		labelMembros.setFont(new Font("", Font.BOLD, 12));
		labelMembros.setBounds(225, 75, 60, 30);
		add(labelMembros);
	}
	
	public void addComboBox() {
		JComboBox<String> listMembros = new JComboBox<String>();
		listMembros.setBounds(150, 100, 200, 30);
		add(listMembros);
		
	}
	
	public void addButtons() {
		JButton buttonTornarAdmin = new JButton("Tornar Administrador", new ImageIcon(getClass().getResource("/tornarAdmin.png")));
		buttonTornarAdmin.setBackground(Color.gray);
		buttonTornarAdmin.setBounds(160, 170, 180, 50);
		add(buttonTornarAdmin);
		
	}
	
}
