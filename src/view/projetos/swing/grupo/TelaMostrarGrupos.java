package view.projetos.swing.grupo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ControllerGrupo;
import controller.ControllerMembro;
import view.autenticacao.swing.SetLookAndFeel;

public class TelaMostrarGrupos extends JFrame {
	
	private ControllerGrupo controllerGrupo = new ControllerGrupo();
	private ControllerMembro controllerMembro = new ControllerMembro();
	
	public TelaMostrarGrupos() {
		setTitle("Mostrar Grupo");
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
		String[] gruposComboBox = new String[controllerGrupo.getGrupos().size()];
		for (int i=0; i<controllerGrupo.getGrupos().size(); i++) {
			for (int j = 0; j < controllerGrupo.getGrupos().get(i).getMembros().size(); j++) {
				if (controllerGrupo.getGrupos().get(i).getMembros().get(j).isAtivo()) {
					gruposComboBox[i] = (controllerGrupo.getGrupos().get(i).getNome());
				}
			}	
		}
		
		JComboBox<String> listGrupos = new JComboBox<String>(gruposComboBox);
		listGrupos.setBackground(Color.gray);
		listGrupos.setBounds(190, 110, 120, 30);
		add(listGrupos);
	}

	public void addButtons() {
		JButton buttonOk = new JButton("Ok");
		buttonOk.setBackground(Color.gray);
		buttonOk.setBounds(200, 190, 100, 30);
		add(buttonOk);
		
		OuvinteMostrarGrupos ouvinteMostrarGrupos = new OuvinteMostrarGrupos();
		
		buttonOk.addActionListener(ouvinteMostrarGrupos);
		
	}
	
	public class OuvinteMostrarGrupos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String evento = e.getActionCommand();
			
			switch (evento) {
			case "Ok":
				dispose();
				new TelaCadastroGruposSwing();
				break;

			}
			
		}
		
	}

}
