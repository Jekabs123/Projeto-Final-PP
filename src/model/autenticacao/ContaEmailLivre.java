package model.autenticacao;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.apache.commons.mail.EmailException;

public class ContaEmailLivre extends ContaEmail{

	public ContaEmailLivre(Conta conta) {
		super(conta);
	}
	
	
	public String criptografarSenha(String senha) { 
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			SecretKey keyDes = keyGenerator.generateKey();
			Cipher cifraDes = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cifraDes.init(Cipher.ENCRYPT_MODE, keyDes);
			byte[] senhaCriptografada = cifraDes.doFinal(senha.getBytes());
			
			return new String(senhaCriptografada);
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	//TODO sobrescrevi esses dois métodos como ele pediu no UML
	@Override
	public Membro autenticar(String login, String senha) throws EmailException {
		String senhaCriptografadas = criptografarSenha(senha);
		if(validarlogin(login)== true){
			return super.autenticar(login, senhaCriptografadas);
		}
		return null;
	}
	@Override
	public boolean validarlogin(String login) {
		String regex = "[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+\\.[A-Za-z]+";
		if(login.matches(regex)==true){
			return super.validarlogin(login);
		}
		return false;
	}
}
