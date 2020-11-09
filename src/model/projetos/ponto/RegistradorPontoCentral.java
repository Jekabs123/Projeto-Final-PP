package model.projetos.ponto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JOptionPane;

import fachadas.Fachada5Projeto;
import model.autenticacao.Membro;
import model.projetos.Projeto;

public class RegistradorPontoCentral extends UnicastRemoteObject implements InterfaceAcessoRemotoPonto {
	
	private ArrayList<Projeto> projetoAtivos = new ArrayList<>();
//	private RegistradorPontoCentralServer registrador = new RegistradorPontoCentralServer();
	
	public RegistradorPontoCentral() throws RemoteException {
		super();
		for(Projeto pro: Fachada5Projeto.getProjetosPersistidos()){
			if(pro.getAtivo() == true){
				projetoAtivos.add(pro);
			}
		}
	}

	@Override
	public boolean registrarPonto(Projeto projeto, String login) {
		for(Membro m: projeto.getMembros()){
			if(m.getLogin().equals(login) && projeto.getAtivo()){
				return true;
			}
			
		}
		return false;
	}

	@Override
	public ArrayList<Projeto> getProjetosAtivos() { //Eu deixei assim faz mais sentido
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
	public float deficitHoras(long dataInicio, long dataTermino, String login) { //Inathan - acho que é mais ou menos assim kkkk
		for (Projeto projeto : projetoAtivos) {                                  //Só tô achando meio estranho esse ArrayList de
			for (Membro membro : projeto.getMembros()) {                         //projetosAtivos pois ele tá vazio, acho que tem
				if(membro.getLogin().equals(login)) {                            // que fazer uma lógica pra povoar ele.
					if((dataTermino - dataInicio) < 8) {   						 //TODO Paulo - realmente, eu peguei os projetos ativos da fachada para repovoar
						return (8 - (dataTermino - dataInicio));
					}
				} else {
					JOptionPane.showMessageDialog(null, "Login não reconhecido");
				}
			}
		}
		return 0;
	}

	@Override
	public Set<PontoTrabalhado> getPontosInvalidos(String login) {
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

	@Override
	public void justificarPontoNaoBatido(PontoTrabalhado ponto, String justificativa, String login) {
		// TODO Auto-generated method stub
		
	}
}
