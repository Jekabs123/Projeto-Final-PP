package model.projetos.ponto;

public class ValidarJustificativa extends ValidarPontoIvalido{

	@Override
	public void validarPontoInvalido() {
		if(ponto.getJustificativa().length()>30 && ponto.getJustificativa().toLowerCase().contains(ponto.getParticipacao().getNome())){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}

}
