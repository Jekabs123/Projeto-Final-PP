package model.autenticacao;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

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
}
