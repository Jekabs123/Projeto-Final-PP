package model.autenticacao;

public class ContaEmailIFPB extends ContaEmail{

	public ContaEmailIFPB(Conta conta) {
		super(conta);
	}
	//TODO sobrescrevi esses dois métodos como ele pediu no UML
	@Override
	public boolean validarlogin(String login) {
		if(login.contains("@academico.ifpb.edu.br")){
			return super.validarlogin(login);
		}
		return false;
	}
	@Override
	public Membro autenticar(String login, String senha) {
		if(validarlogin(login) == true){
			return super.autenticar(login, senha);
		}
		return null;
	}
}
