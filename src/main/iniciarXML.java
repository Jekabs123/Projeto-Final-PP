package main;

import fachadas.Fachada1Membro;
import model.autenticacao.ContaAutenticacaoProvedorEmailSMTP;
import model.autenticacao.ContaEmail;
import model.autenticacao.ContaEmailIFPB;
import model.autenticacao.Membro;
import model.projetos.Participacao;

public class iniciarXML {

	public static void main(String[] args) {
		Fachada1Membro fachadaMembro = new Fachada1Membro();

		Participacao p = new Participacao();
		p.setAporteCusteioMensalReais(200);
		p.setAtivo(true);
		p.setCoordenador(true);
		p.setDataInicio(20);
		p.setDataTermino(30);
		p.setId(1);
		p.setQtdMesesCusteados((short) 10);
		p.setQtdMesesPagos((short) 5);
		
		ContaAutenticacaoProvedorEmailSMTP conta = new ContaAutenticacaoProvedorEmailSMTP();
		ContaEmail contaEmail = new ContaEmailIFPB(conta);
		contaEmail.setLogin("paulohenrique8190@gmail.com");
		contaEmail.setSenha("wuyang50");
		
		conta.setProvedorHost("smtp.gmail.com");
		conta.setProvedorPorta("465");
		
		
		Membro membro1 = new Membro();
		membro1.setAdministrador(true);
		membro1.setAtivo(true);
		membro1.setEmail("paulo@gmail.com");
		membro1.setMatricula(1029938);
		membro1.setNome("Paulo Henrique Pereira de Sousa");
		p.setNome(membro1.getNome());
		membro1.setParticipacao(p);
		membro1.setContaEmail(contaEmail);
		fachadaMembro.adicionarMembroNoSistema(membro1, contaEmail);
		contaEmail.autenticar(contaEmail.getLogin(), contaEmail.getSenha());
		
	}
}
