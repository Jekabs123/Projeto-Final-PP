package controller;

import java.util.ArrayList;

import fachadas.Fachada1Membro;
import model.autenticacao.Membro;

public class ControllerMembro {
	
	private Fachada1Membro fachadaMembro = new Fachada1Membro();
	
	public ArrayList<Membro> getMembros() {
		return Fachada1Membro.getMembros();
	}
	
	public Membro pesquisar(long matricula){
		return fachadaMembro.pesquisarMembro(matricula);
	}
	public void atualizar(){
		fachadaMembro.atualizarMembro();
	}
	public void tornarMembroAdim(Membro membro){
		if(getMembros().size()>0){
			Membro admin = getMembros().get(0);
			ControllerConfigurarAdim config = new ControllerConfigurarAdim(admin.getNome(), admin.getContaEmail(), admin.getEmail(), admin.getMatricula(), admin.getParticipacao());
			config.tornarMembroAdim(membro);
		}else{
			ControllerConfigurarAdim config = new ControllerConfigurarAdim(membro.getNome(), membro.getContaEmail(), membro.getEmail(), membro.getMatricula(), membro.getParticipacao());
			config.tornarMembroAdim(membro);
		}
	}
}
