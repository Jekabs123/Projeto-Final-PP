package controller;

import fachadas.Fachada1Membro;
import model.autenticacao.Conta;
import model.autenticacao.ContaEmail;
import model.autenticacao.ContaEmailLivre;
import model.autenticacao.Membro;
import model.projetos.Participacao;

public class ControllerCadastrarContaMembro {
	
	private Fachada1Membro fachadaMembro = new Fachada1Membro();
	private Membro membro;
	private Participacao participacao;
	private ContaEmail contaEmail;
	private Conta conta;
	
	public void addMembro(String email, long matricula, String nome, String login, String senha) {
		
		membro = new Membro();
		membro.setAtivo(true);
		membro.setEmail(email);
		membro.setMatricula(matricula);
		membro.setNome(nome);
		membro.setParticipacao(participacao);
		
		
		contaEmail = new ContaEmail(conta);
		contaEmail.setConta(conta);
		contaEmail.setLogin(login);
		contaEmail.setSenha(senha);
		
		fachadaMembro.adicionarMembroNoSistema(membro, contaEmail);

	}
	
	public void addParticipacao(float aporteCusteioMensalReais, boolean coordenador, long dataInicio, long dataTermino, String nome, short qtdMesesCusteados, short qtdMesesPagos) {
		participacao = new Participacao();
		participacao.setAporteCusteioMensalReais(aporteCusteioMensalReais);
		participacao.setAtivo(true);
		participacao.setCoordenador(coordenador);
		participacao.setDataInicio(dataInicio);
		participacao.setDataTermino(dataTermino);
		participacao.setId(Fachada1Membro.getMembros().size()+1);
		participacao.setNome(nome);
		participacao.setQtdMesesCusteados(qtdMesesCusteados);
		participacao.setQtdMesesPagos(qtdMesesPagos);
	}

}
