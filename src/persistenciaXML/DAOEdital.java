package persistenciaXML;

import java.util.ArrayList;

import model.projetos.Edital;

public class DAOEdital {

	private ArrayList<Edital> editais = new ArrayList<>();

	public void add(Edital edital){
		editais.add(edital);
	}
	public void remove(Edital edital){
		editais.remove(edital);
	}
	public ArrayList<Edital> getEditais() {
		return editais;
	}
	public void setEditais(ArrayList<Edital> editais) {
		this.editais = editais;
	}

}
