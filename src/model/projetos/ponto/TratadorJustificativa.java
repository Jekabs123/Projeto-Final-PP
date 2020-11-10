package model.projetos.ponto;

public class TratadorJustificativa extends TratadorDePontoIvalido{

	@Override
	public void justificarPontoInvalido() {
		if(ponto.getJustificativa().length()>30 && ponto.getJustificativa().toLowerCase().contains(ponto.getParticipacao().getNome())){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}

}
