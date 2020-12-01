package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerGrupo;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaAtualizarGrupo extends JFrame {
	
	private ControllerGrupo controllerGrupo = new ControllerGrupo();
	
	private JComboBox<String> listGrupos;
	private JTextField txtNovoNome;


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
		txtNovoNome = new JTextField();
		txtNovoNome.setBounds(270, 110, 130, 30);
		add(txtNovoNome);
	}

	public void addComboBox() {
		String[] gruposComboBox = new String[controllerGrupo.getGrupos().size()];
		for (int i=0; i<controllerGrupo.getGrupos().size(); i++) {
			gruposComboBox[i] = (controllerGrupo.getGrupos().get(i).getNome());
		}
		
		listGrupos = new JComboBox<String>(gruposComboBox);
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
		
		OuvinteAtualizarGrupo ouvinteAtualizarGrupo = new OuvinteAtualizarGrupo();
		
		buttonAtualizar.addActionListener(ouvinteAtualizarGrupo);
		buttonFinalizar.addActionListener(ouvinteAtualizarGrupo);
		
	}
	
	public class OuvinteAtualizarGrupo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Atualizar":
				int index = listGrupos.getSelectedIndex();
				
				for (int i = 0; i < controllerGrupo.getGrupos().size(); i++) {
					if(controllerGrupo.getGrupos().get(i).equals(controllerGrupo.getGrupos().get(index))) {
						controllerGrupo.setNomeGrupo(controllerGrupo.getGrupos().get(index),txtNovoNome.getText());
						controllerGrupo.atualizarGrupo();
						JOptionPane.showMessageDialog(null, "Grupo Atualizado");
						listGrupos.repaint();
					}
				}
				break;

			case "Finalizar":
				dispose();
				new TelaCadastroGruposSwing();
				break;
			}
		}
		
	}

}
