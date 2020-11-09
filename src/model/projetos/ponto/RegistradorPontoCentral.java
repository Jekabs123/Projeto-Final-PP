package model.projetos.ponto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import model.autenticacao.Membro;
import model.projetos.CompositorProjeto;
import model.projetos.Projeto;

public class RegistradorPontoCentral extends UnicastRemoteObject implements InterfaceAcessoRemotoPonto {
	
	private ArrayList<Projeto> projetoAtivos = new ArrayList<>();
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
	public ArrayList<Projeto> getProjetosAtivos() { //Eu deixei assim faz mais sentido
		//TODO Paulo - fiz assim essa parte
		return projetoAtivos;
	}

	@Override
	public int horasTrabalhadasValidas(long dataInicio, long dataTermino, String login) {
		//TODO Paulo - terminei de implementar
		for(Projeto pro: projetoAtivos){
			for(Membro m: pro.getMembros()){
				if(m.getLogin().equals(login)){
					m.getParticipacao().getPontoTrabalhado().setDataHoraEntrada(dataInicio);
					m.getParticipacao().getPontoTrabalhado().setDataHoraSaida(dataTermino);
					return m.getParticipacao().getPontoTrabalhado().getHorasTrabalhadas();
				}
			}
		}
		return -1;
	}

	@Override
	public float deficitHoras(long dataInicio, long dataTermino, char[] login) {
		return 0;
	}

	@Override
	public Set<PontoTrabalhado> getPontosInvalidos(char[] login) {
		return null;
	}

	@Override
	public void justificarPontoInvalido(PontoTrabalhado ponto, HorarioPrevisto horario,ArrayList<TratadorDePontoIvalido> tratadores) {
		//TODO Paulo - Terminei esse método, ele está usando o chain
		for(TratadorDePontoIvalido tratador: tratadores){
			tratador.setPonto(ponto);
			tratador.setHorario(horario);
			tratador.justificarPontoInvalido();
		}
		//Coloquei um array de Tratadores no parametro para que o cliente possa escolher a ordem
	}
}
