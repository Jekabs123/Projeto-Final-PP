package fachadasCasoDeUso;

import java.rmi.RemoteException;

import model.projetos.ponto.PontoTrabalhado;
import model.projetos.ponto.RegistradorPontoCentral;
import model.projetos.ponto.TratadorDePontoIvalido;

public class Fachada12JustificarPonto {

	private RegistradorPontoCentral registrarPonto;
	
	public Fachada12JustificarPonto() {
		try {
			registrarPonto = new RegistradorPontoCentral();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void justificarPontoInvalido(PontoTrabalhado ponto, TratadorDePontoIvalido tratador, char[] login){
		registrarPonto.justificarPontoInvalido(ponto, tratador, login);
	}
	public void justificarPontoNaoBatido(PontoTrabalhado ponto, TratadorDePontoIvalido tratador, char[] login){
		registrarPonto.justificarPontoNaoBatido(ponto, tratador, login);
	}
}
