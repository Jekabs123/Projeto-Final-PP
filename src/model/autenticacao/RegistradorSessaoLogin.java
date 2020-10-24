package model.autenticacao;

import java.util.ArrayList;

public class RegistradorSessaoLogin {
	private static RegistradorSessaoLogin registrador;
	private ArrayList<Observer> observeres = new ArrayList<>();
	
	private RegistradorSessaoLogin() {
	}
	
	public void RegistradorOnline(Membro membro){
		//FALTA IMPLEMENTAR
		//AQUI VAI DISPARAR O OBSERVER
	}
	public void RegistradorOffline(char[] login){
		//FALTA IMPLEMENTAR
		//AQUI VAI DISPARAR O OBSERVER
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
	public void notifyObserveres(){
		for(Observer obs: observeres){
			obs.notifyObserver();
		}
	}
}
