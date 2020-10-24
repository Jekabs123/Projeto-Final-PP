package model.autenticacao;

public abstract class Observer {

	public abstract void notifyObserver(Membro membro);
	public abstract void notifyObserver(char[] login);
}
