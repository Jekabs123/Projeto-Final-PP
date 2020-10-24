package model.autenticacao;

import java.util.ArrayList;

public class RegistradorSessaoLogin {
	private static RegistradorSessaoLogin registrador;
	private ArrayList<Observer> observeres = new ArrayList<>();
	
	private RegistradorSessaoLogin() {
	}
	
	public void RegistradorOnline(Membro membro){
		notifyObserveres(membro);
	}
	public void RegistradorOffline(char[] login){
		notifyObserveres(login);
	}
	public boolean isOnline(char[] login){
		//FALTA IMPLEMENTAR
		return false;
	}
	public synchronized static RegistradorSessaoLogin getInstance(){
		if(registrador==null){
			registrador = new RegistradorSessaoLogin();
		}
		return registrador;
	}
	public void addObserver(Observer observer){
		observeres.add(observer);
	}
	public void removeObserver(Observer observer){
		observeres.remove(observer);
	}
	public void notifyObserveres(Membro membro){
		for(Observer obs: observeres){
			obs.notifyObserver(membro);
		}
	}
	public void notifyObserveres(char[] login){
		for(Observer obs: observeres){
			obs.notifyObserver(login);
		}
	}
}
