package model.projetos.ponto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import model.projetos.Projeto;

public interface InterfaceAcessoRemotoPonto extends Remote {
	
	public boolean registrarPonto(Projeto projeto, String login) throws RemoteException;
	
	public Set<Projeto> getProjetosAtivos(String login);
	
	public float horasTrabalhadasValidas(long dataInicio, long dataTermino, char[] login);
	
	public float deficitHoras(long dataInicio, long dataTermino, char[] login);
	
	public Set<PontoTrabalhado> getPontosInvalidos(char[] login);
	
	public void justificarPontoInvalido(PontoTrabalhado ponto, char[] justificativa, char[] login);
	
	public void justificarPontoNaoBatido(PontoTrabalhado ponto, char[] justificativa, char[] login);

}
