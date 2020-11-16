package persistenciaXML;

import java.util.ArrayList;

import model.projetos.Grupo;

public class DAOGrupo {
	
	private ArrayList<Grupo> grupos = new ArrayList<>();

	public void add(Grupo grupo){
		grupos.add(grupo);
	}
	public void remove(Grupo grupo){
		grupos.remove(grupo);
	}
	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

}
