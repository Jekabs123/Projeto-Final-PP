package model.projetos.ponto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import model.projetos.Projeto;

public class RegistradorPontoCentral extends UnicastRemoteObject implements InterfaceAcessoRemotoPonto {

	protected RegistradorPontoCentral() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean registrarPonto(Projeto projeto, char[] login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Projeto> getProjetosAtivos(char[] login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float horasTrabalhadasValidas(long dataInicio, long dataTermino, char[] login) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float deficitHoras(long dataInicio, long dataTermino, long login) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<PontoTrabalhado> getPontosInvalidos(char[] login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void justificarPontoInvalido(PontoTrabalhado ponto, char[] justificativa, char[] login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void justificarPontoNaoBatido(PontoTrabalhado ponto, char[] justificativa, char[] login) {
		// TODO Auto-generated method stub
		
	}

}
