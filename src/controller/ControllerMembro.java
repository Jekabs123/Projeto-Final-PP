package controller;

import java.util.ArrayList;

import fachadas.Fachada1Membro;
import model.autenticacao.Membro;

public class ControllerMembro {
	
	//private Fachada1Membro fachadaMembro = new Fachada1Membro();
	
	public ArrayList<Membro> getMembros() {
		return Fachada1Membro.getMembros();
	}

}
