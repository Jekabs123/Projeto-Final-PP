package Exception;
/**
 * @author PAULO E INATHAN
 * Essa classe é uma exceção de membros duplicados
 */
public class ExceptionMembroDuplicado extends Exception{
	
	/**
	 * Esse é o construtor que seta uma mensagem do tipo String
	 * @param menssage: é a mensagem de erro que vai ser exibido
	 */
	public ExceptionMembroDuplicado(String menssage) {
		super(menssage);
	}
}
