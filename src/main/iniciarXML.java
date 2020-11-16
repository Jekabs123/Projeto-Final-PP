package main;

import java.util.ArrayList;

import fachadas.Fachada1Membro;
import fachadas.Fachada3Grupo;
import fachadas.Fachada4Edital;
import fachadas.Fachada5Projeto;
import model.autenticacao.ContaAutenticacaoProvedorEmailSMTP;
import model.autenticacao.ContaEmail;
import model.autenticacao.ContaEmailIFPB;
import model.autenticacao.Membro;
import model.projetos.Edital;
import model.projetos.Grupo;
import model.projetos.Participacao;
import model.projetos.Projeto;

public class iniciarXML {

	public static void main(String[] args) {
		
		//Membro
		
		Fachada1Membro fachadaMembro = new Fachada1Membro();
		
		//Paulo

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
		
		//Inathan
		
		Participacao p2 = new Participacao();
		p2.setAporteCusteioMensalReais(200);
		p2.setAtivo(true);
		p2.setCoordenador(true);
		p2.setDataInicio(20);
		p2.setDataTermino(30);
		p2.setId(2);
		p2.setQtdMesesCusteados((short) 10);
		p2.setQtdMesesPagos((short) 5);
		
		ContaAutenticacaoProvedorEmailSMTP conta2 = new ContaAutenticacaoProvedorEmailSMTP();
		ContaEmail contaEmail2 = new ContaEmailIFPB(conta2);
		contaEmail2.setLogin("inathanmoreira@gmail.com");
		contaEmail2.setSenha("sasagayo");
		
		conta.setProvedorHost("smtp.gmail.com");
		conta.setProvedorPorta("465");
		
		Membro membro2 = new Membro();
		membro2.setAdministrador(true);
		membro2.setAtivo(true);
		membro2.setEmail("inathan@gmail.com");
		membro2.setMatricula(10203040);
		membro2.setNome("Inathan Moreira da Silva");
		p2.setNome(membro2.getNome());
		membro2.setParticipacao(p);
		membro2.setContaEmail(contaEmail2);
		fachadaMembro.adicionarMembroNoSistema(membro2, contaEmail2);
		contaEmail.autenticar(contaEmail2.getLogin(), contaEmail2.getSenha());
		
		ArrayList<Membro> membros = new ArrayList();
		membros.add(membro1);
		membros.add(membro2);
		
		
		//Grupo
		
		Fachada3Grupo fachadaGrupo = new Fachada3Grupo();
		
		Grupo grupo = new Grupo();
		grupo.setAtivo(true);
		grupo.setDataInicio(2020);
		grupo.setDataTermino(2020);
		grupo.setId(1);
		grupo.setNome("TATAKAE!");
		fachadaGrupo.adicionarGrupo(grupo);
		
		
		//Edital
		
		Fachada4Edital fachadaEdital = new Fachada4Edital();
		
		Edital edital = new Edital();
		edital.setAtivo(true);
		edital.setDataInicio(2020);
		edital.setDataTermino(2020);
		edital.setId(1);
		edital.setNome("Edital Porjeto PP");
		fachadaEdital.adicionarEdital(edital);
		
		
		//Projeto
		
		Fachada5Projeto fachadaProjeto = new Fachada5Projeto();
		
		Projeto projeto = new Projeto();
		projeto.setAporteCapitalReais(300);
		projeto.setAporteCusteioReais(700);
		projeto.setAtivo(true);
		projeto.setDataInicio(2020);
		projeto.setDataTermino(2020);
		projeto.setGastoExecutadoCapitalReais(200);
		projeto.setGastoExecutadoCusteioReais(600);
		projeto.setId(1);
		projeto.setNome("Projeto PP");
		projeto.setMembros(membros);
		fachadaProjeto.adicionarMembroNoProjeto(membro1, 1);
		fachadaProjeto.adicionarMembroNoProjeto(membro2, 1);
		fachadaProjeto.adicionarProjeto(projeto);
		
		
		
	}
}
