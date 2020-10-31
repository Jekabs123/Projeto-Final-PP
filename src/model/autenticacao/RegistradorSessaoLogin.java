package model.autenticacao;

import java.util.ArrayList;

public class RegistradorSessaoLogin {
	
	private static RegistradorSessaoLogin registrador;
	
	
	private RegistradorSessaoLogin() {
		
	}
	
	public synchronized static RegistradorSessaoLogin getInstance(){
		if(registrador==null){
			registrador = new RegistradorSessaoLogin();
		}
		return registrador;
	}
	
	public void RegistradorOnline(Membro membro){
		//FALTA IMPLEMENTAR
	}
	public void RegistradorOffline(char[] login){
		//FALTA IMPLEMENTAR
	}
	public boolean isOnline(char[] login){
		//FALTA IMPLEMENTAR
		return false;
	}
}
