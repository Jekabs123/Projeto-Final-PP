package fachadasCasoDeUso;

import model.autenticacao.Membro;

public class Fachada7MembroAdministrador {
	
	private Membro membroAdministrador;
	
	public Fachada7MembroAdministrador(Membro membroAdministrador) {
		this.membroAdministrador = membroAdministrador;
	}
	
	public void tornarMembroAdministrador(Membro membro) {
		if(membroAdministrador.getAdministrador() == true) {
			membro.setAdministrador(true);
		}
	}

}
