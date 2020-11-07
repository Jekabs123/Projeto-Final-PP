package model.projetos.ponto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Set;

import model.autenticacao.Membro;
import model.projetos.CompositorProjeto;
import model.projetos.Projeto;

public class RegistradorPontoCentral extends UnicastRemoteObject implements InterfaceAcessoRemotoPonto {
	
	private CompositorProjeto projeto;
	private HashMap<String,Projeto> projetoAtivos = new HashMap<String, Projeto>();
	private RegistradorPontoCentralServer registrador = new RegistradorPontoCentralServer();
	
	public RegistradorPontoCentral() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean registrarPonto(Projeto projeto, String login) {
		for(Membro m: projeto.getMembros()){
			if(m.getLogin().equals(login)){
				return registrador.registrarPonto(this);
			}
		}
		return false;
	}

	@Override
	public HashMap<String, Projeto> getProjetosAtivos(String login) { //Também não entendi bem deixei assim kkkk
		
		for (int i = 0; i < projetoAtivos.size(); i++) {
			if(projetoAtivos.get(login)!=null) {
				return projetoAtivos;
			}
		}
		return null;
	}

	@Override
	public float horasTrabalhadasValidas(long dataInicio, long dataTermino, char[] login) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float deficitHoras(long dataInicio, long dataTermino, char[] login) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<PontoTrabalhado> getPontosInvalidos(char[] login) {
		return null;
	}

	@Override
	public void justificarPontoNaoBatido(PontoTrabalhado ponto, TratadorDePontoIvalido tratador, char[] login) {
		
	}

	@Override
	public void justificarPontoInvalido(PontoTrabalhado ponto, TratadorDePontoIvalido tratador, char[] login) {
		
	}

}
