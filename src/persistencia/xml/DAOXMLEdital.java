package persistencia.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.projetos.Edital;

public class DAOXMLEdital {
	
	private HashMap<Long, Edital> persistidos = carregarXML();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public boolean criar(Edital edital) {   
		for (int i = 0; i <= persistidos.size(); i++) {            //PERCORRO A LISTA
			if(persistidos.size() == i) {                          //SE O TAMANHO DA LISTA FOR IGUAL AO I
				persistidos.put((long) (i+1), edital);                     //ADICIONO O PROJETO NA POSIÇÃO(CHAVE) I+1
				salvarXML();                                       //SALVO O ARQUIVO   
				return true;                                       //RETORNO TRUE SE DEU CERTO
			}
		}
		return false;      
	}
	
	public void remover(long id) { 
		persistidos.remove(id);                                   //REMOVE PELA CHAVE
		salvarXML();                                              //SALVA
	}
	
	public boolean atualizar(long id, Edital edital) {   
		for (int i = 0; i < persistidos.size(); i++) {           //PERCORRO A LISTA
			if(id <= persistidos.size()) {                       //SE O ID FOR MENOR QUE O TAMANHO DA LISTA, SIGNIFICA QUE O OBJETO ESTÁ NELA
				persistidos.put(id, edital);                     //ATUALIZO O OBJETO PARA O ID DESEJADO
				salvarXML();                                     //SALVO O ARQUIVO
				return true;                                     //RETORNO TRUE SE DEU CERTO
			}
		}
		return false;                                            //RETORNO FALSE SE DEU ERRADO
	}
	public Edital pesquisarEdital(long idEdital){
		return persistidos.get(idEdital);
	}
	public HashMap<Long,Edital> getEdital(){
		return carregarXML();
	}
	public int consultarAnd(char[] atributos, char[] respectivosValoresAtributos) {   //FALTA IMPLEMENTAR
		return 1;
	}
	
	public int consultarOr(char[] atributos, char[] respectivosValoresAtributos) {   //FALTA IMPLEMENTAR
		return 1;
	}
	
	private void salvarXML() {
		arquivoColecao = new File("Edital.xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(persistidos);
		try {
			arquivoColecao.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivoColecao);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private HashMap<Long, Edital> carregarXML() {                        //NO UML O MÉTODO TÁ VOID, MAS O COMUM É RETORNAR UMA COLECAO
		arquivoColecao = new File("Edital.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (HashMap<Long, Edital>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<Long, Edital>();
	}

}
