package model.autenticacao;

public class ContaAutenticacaoProvedorEmailSMTP extends Conta{
	
	private char[] provedorHost;
	private char[] provedorPorta;

	@Override
	public Membro autenticar(char[] login, char[] senha) {  //FALTA IMPLEMENTAR
		
//		email.setHostName( "smtp.gmail.com" );
//		email.setSslSmtpPort( "465" );
//		email.setAuthenticator( new DefaultAuthenticator( "" , "" ) );
		
		return null;
	}

	public char[] getProvedorHost() {
		return provedorHost;
	}

	public void setProvedorHost(char[] provedorHost) {
		this.provedorHost = provedorHost;
	}

	public char[] getProvedorPorta() {
		return provedorPorta;
	}

	public void setProvedorPorta(char[] provedorPorta) {
		this.provedorPorta = provedorPorta;
	}

}
