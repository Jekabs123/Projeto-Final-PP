package controller;

import fachadas.Fachada9MembroRealizarLogout;
import model.autenticacao.Membro;

public class ControllerLoginELogout {

	
	public void realizarLogin(Membro membro){
		Fachada9MembroRealizarLogout.realizarLogin(membro);
	}
	public void realizarLogout(String login){
		Fachada9MembroRealizarLogout.realizarLogout(login);
	}
	public boolean isOnline(String login){
		return Fachada9MembroRealizarLogout.isOnline(login);
	}
}
