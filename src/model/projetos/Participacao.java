package model.projetos;

import java.util.ArrayList;

import model.autenticacao.Membro;

public class Participacao {
	
	private long dataInicio;
	private long dataTermino;
	private boolean ativo;
	private float aporteCusteioMensalReais;
	private short qtdMesesCusteados;
	private short qtdMesesPagos;
	private boolean coordenador;
	private ArrayList<Membro> membros = new ArrayList<Membro>();
	private ArrayList<Projeto> projetos = new ArrayList<Projeto>();

}
