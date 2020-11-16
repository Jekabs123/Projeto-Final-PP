package persistenciaXML;

import java.util.ArrayList;

import model.projetos.Projeto;

public class DAOProjeto {
	
	private ArrayList<Projeto> projetos = new ArrayList<>();
	
	public void add(Projeto projeto){
		projetos.add(projeto);
	}
	public void remove(Projeto projeto){
		projetos.remove(projeto);
	}
	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(ArrayList<Projeto> projetos) {
		this.projetos = projetos;
	}

}
