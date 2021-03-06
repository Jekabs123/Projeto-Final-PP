package model.projetos.ponto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import fachadas.Fachada5Projeto;
import model.autenticacao.Membro;
import model.projetos.Projeto;

public class RegistradorPontoCentral extends UnicastRemoteObject implements InterfaceAcessoRemotoPonto {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Projeto> projetoAtivos = new ArrayList<>();
	private RegistradorPontoCentralServer server;
	
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
				server = new RegistradorPontoCentralServer(this);
				return true;
			}
			
		}
		return false;
	}

	@Override
	public ArrayList<Projeto> getProjetosAtivos() { 
		return projetoAtivos;
	}

	@Override
	public int horasTrabalhadasValidas(long dataInicio, long dataTermino, String login) {
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
	public float deficitHoras(long dataInicio, long dataTermino, String login) { 
		for (Projeto projeto : projetoAtivos) {                                 
			for (Membro membro : projeto.getMembros()) {                         
				if(membro.getLogin().equals(login)) {                            
					if((dataTermino - dataInicio) < 8) {   						 
						return (8 - (dataTermino - dataInicio));
					}
				} else {
//					JOptionPane.showMessageDialog(null, "Login n�o reconhecido");
				}
			}
		}
		return 0;
	}

	@Override
	public ArrayList<PontoTrabalhado> getPontosInvalidos(String login) {
		ArrayList<PontoTrabalhado> pontosInvalidos = new ArrayList<>();
		for(Projeto p: projetoAtivos){
			for(Membro m: p.getMembros()){
				if(m.getParticipacao().getPontoTrabalhado().isJustificativaAceita() == false){
					pontosInvalidos.add(m.getParticipacao().getPontoTrabalhado());
				}
			}
		}
		return pontosInvalidos;
	}

	@Override
	public void justificarPontoInvalido(PontoTrabalhado ponto, HorarioPrevisto horario,ArrayList<ValidarPontoIvalido> tratadores) {
		for(ValidarPontoIvalido tratador: tratadores){
			tratador.setPonto(ponto);
			tratador.setHorario(horario);
			tratador.validarPontoInvalido();
		}
	}
}
