package model.autenticacao;

import java.util.ArrayList;

import fachadas.Fachada1Membro;

public class ContaAutenticacaoProvedorInterno extends Conta{

	@Override
	public Membro autenticar(String login, String senha) { 
		ArrayList<Membro> membros = Fachada1Membro.getMembro();
		for(Membro m : membros){
			if(m.getLogin().equals(login)&&
			   m.getSenha().equals(senha)){
				return m;
			}
		}
		return null;
	}

}
