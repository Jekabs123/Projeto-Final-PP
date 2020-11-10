package model.projetos.ponto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.projetos.Projeto;

public interface InterfaceAcessoRemotoPonto extends Remote {
	
	public abstract boolean registrarPonto(Projeto projeto, String login) throws RemoteException;
	
	public abstract ArrayList<Projeto> getProjetosAtivos() throws RemoteException;
	
	public abstract int horasTrabalhadasValidas(long dataInicio, long dataTermino, String login) throws RemoteException;
	
	public abstract float deficitHoras(long dataInicio, long dataTermino, String login) throws RemoteException;
	
	public abstract ArrayList<PontoTrabalhado> getPontosInvalidos(String login) throws RemoteException;

	public abstract void justificarPontoInvalido(PontoTrabalhado ponto, HorarioPrevisto horario, ArrayList<ValidarPontoIvalido> tratadores) throws RemoteException;
	
}
