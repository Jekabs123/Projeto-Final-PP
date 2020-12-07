package main;

import view.autenticacao.FabricaTela;
import view.autenticacao.swing.FabricaTelaSwing;

public class Main {
	
	public static void main(String[] args) {
		FabricaTela fabricaTela = new FabricaTelaSwing();
		fabricaTela.fabricarTelaPrincipal();
	}
}
