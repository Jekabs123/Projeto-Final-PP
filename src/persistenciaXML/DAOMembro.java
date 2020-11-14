package persistenciaXML;

import java.util.ArrayList;

import model.autenticacao.Membro;

public class DAOMembro {

	private ArrayList<Membro> membros = new ArrayList<>();
	
	public void add(Membro membro){
		membros.add(membro);
	}
	public void remove(Membro membro){
		membros.remove(membro);
	}
	public ArrayList<Membro> getMembros() {
		return membros;
	}
	public void setMembros(ArrayList<Membro> membros) {
		this.membros = membros;
	}
	
	
}
