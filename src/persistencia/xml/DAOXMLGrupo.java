package persistencia.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import model.projetos.Grupo;

public class DAOXMLGrupo {
	
	private HashMap<Long, Grupo> persistidos = carregarXML();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public boolean criar(Grupo grupo) { 
		for (int i = 0; i <= persistidos.size(); i++) {            //PERCORRO A LISTA
			if(persistidos.size() == i) {                          //SE O TAMANHO DA LISTA FOR IGUAL AO I
				persistidos.put(i+1l, grupo);                      //ADICIONO O PROJETO NA POSIÇÃO(CHAVE) I+1
				salvarXML();                                       //SALVO O ARQUIVO   
				return true;                                       //RETORNO TRUE SE DEU CERTO
			}
		}
		return false;                                              //RETORNO FALSE SE DEU ERRADO
	}
	
	public void remover(long id) {  
		persistidos.remove(id);                                   //REMOVE PELA CHAVE
		salvarXML();                                              //SALVA
	}
	
	public boolean atualizar(long id, Grupo grupo) {  
		for (int i = 0; i < persistidos.size(); i++) {           //PERCORRO A LISTA
			if(id <= persistidos.size()) {                       //SE O ID FOR MENOR QUE O TAMANHO DA LISTA, SIGNIFICA QUE O OBJETO ESTÁ NELA
				persistidos.put(id, grupo);                      //ATUALIZO O OBJETO PARA O ID DESEJADO
				salvarXML();                                     //SALVO O ARQUIVO
				return true;                                     //RETORNO TRUE SE DEU CERTO
				
			}
		}
		return false;             
	}
	public Grupo pesquisarGrupo(long id){
			return persistidos.get(id);
	}
	public int consultarAnd(char[] atributos, char[] respectivosValoresAtributos) {   //FALTA IMPLEMENTAR
		return 1;
	}
	
	public int consultarOr(char[] atributos, char[] respectivosValoresAtributos) {   //FALTA IMPLEMENTAR
		return 1;
	}
	
	private void salvarXML() {
		arquivoColecao = new File("Grupo.xml");
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
	
	private HashMap<Long, Grupo> carregarXML() {                        //NO UML O MÉTODO TÁ VOID, MAS O COMUM É RETORNAR UMA COLECAO
		arquivoColecao = new File("Grupo.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (HashMap<Long, Grupo>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<Long, Grupo>();
	}

}
