package model.autenticacao;

import java.util.HashMap;

import fachadasCasoDeUso.Fachada1Membro;

public class ObserverRegistrarOffline extends Observer{

	@Override
	public void notifyObserver(Membro membro) {
	}

	@Override
	public void notifyObserver(char[] login) {
		HashMap<Long, Membro> membros = Fachada1Membro.getMembro();
		Membro membro;
		for(int i = 0;i<=membros.size();i++){
			membro = membros.get((long)(i+1));
			if(membro.getLogin().equals(login)){
				System.out.println("Regiistrado: "+membro.getMatricula());
				break;
			}
		}
	}



}
