package model.autenticacao;

import java.util.HashMap;

import fachadasCasoDeUso.Fachada1Membro;

public class ObserverRegistrarOnline extends Observer{

	@Override
	public void notifyObserver(Membro membro) {
		HashMap<Long, Membro> membros = Fachada1Membro.getMembro();
		if(membros.get(membro)!=null){
			System.out.println("Registrado: "+membro.getMatricula());
		}
	}

	@Override
	public void notifyObserver(char[] login) {
		// TODO Auto-generated method stub
		
	}



}
