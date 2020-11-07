package model.autenticacao;

import java.util.HashMap;

import fachadas.Fachada1Membro;
import fachadas.Fachada6MembroEmail;

public class ContaAutenticacaoProvedorInterno extends Conta{

	@Override
	public Membro autenticar(char[] login, char[] senha) { 
		HashMap<Long, Membro> membros = Fachada1Membro.getMembro();
		for(int i = 0;i<=membros.size();i++){
			if(membros.get(i).getLogin().equals(login)&&
			   membros.get(i).getSenha().equals(senha)){
				return membros.get(i);
			}
		}
		return null;
	}

}
