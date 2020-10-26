package model.projetos.ponto;

import java.util.Set;

import model.projetos.Projeto;

public interface InterfaceAcessoRemotoPonto {
	
	public boolean registrarPonto(Projeto projeto, char[] login);
	
	public Set<Projeto> getProjetosAtivos(char[] login);
	
	public float horasTrabalhadasValidas(long dataInicio, long dataTermino, char[] login);
	
	public float deficitHoras(long dataInicio, long dataTermino, long login);
	
	public Set<PontoTrabalhado> getPontosInvalidos(char[] login);
	
	public void justificarPontoInvalido(PontoTrabalhado ponto, char[] justificativa, char[] login);
	
	public void justificarPontoNaoBatido(PontoTrabalhado ponto, char[] justificativa, char[] login);

}
