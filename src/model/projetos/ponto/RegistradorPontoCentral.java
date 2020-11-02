package model.projetos.ponto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

import model.projetos.InterfaceComum;
import model.projetos.Projeto;

public class RegistradorPontoCentral extends UnicastRemoteObject implements InterfaceAcessoRemotoPonto {
	
	private InterfaceComum projeto;
	private Set<Projeto> projetoAtivos = new HashSet<Projeto>();
	
	protected RegistradorPontoCentral() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean registrarPonto(Projeto projeto, String login) {
		
		return false;
	}

	@Override
	public Set<Projeto> getProjetosAtivos(String login) {         //NÃO TÔ ENTENDENDO PARA QUE SERVE O LOGIN PASSADO COMO PARAMETRO
		projeto = new Projeto();
		for (int i = 0; i < projeto.getInterfaces().size(); i++) {
			if(projeto.getInterfaces().get(i).getAtivo()) {
				projetoAtivos.add((Projeto) projeto.getInterfaces().get(i));
			}
		}
		return projetoAtivos;
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
