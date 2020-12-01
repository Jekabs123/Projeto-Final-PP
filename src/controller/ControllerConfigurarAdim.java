package controller;

import fachadas.Fachada7MembroAdministrador;
import model.autenticacao.ContaEmail;
import model.autenticacao.Membro;
import model.projetos.Participacao;

public class ControllerConfigurarAdim {

	private Fachada7MembroAdministrador fachadaMembro;
	
	public ControllerConfigurarAdim(String nome,ContaEmail contaEmail,String email,long matricula,Participacao participacao){
		Membro membro = new Membro();
		membro.ativar();
		membro.setAdministrador(true);
		membro.setContaEmail(contaEmail);
		membro.setEmail(email);
		membro.setMatricula(matricula);
		membro.setNome(nome);
		membro.setParticipacao(participacao);
		fachadaMembro = new Fachada7MembroAdministrador(membro);
	}
	public void tornarMembroAdim(Membro membro){
		fachadaMembro.tornarMembroAdministrador(membro);
	}
}
