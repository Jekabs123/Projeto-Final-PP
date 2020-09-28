package persistencia.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.autenticacao.Membro;
import model.projetos.Projeto;

public class DAOXMLMembroConta {
	
	private HashMap<Long, Membro> persistidos = new HashMap<>();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	
	public boolean criar(Membro membro) {   //FALTA IMPLEMENTAR
		return true;
	}
	
	public void remover(long id) {   //FALTA IMPLEMENTAR
		
	}
	
	public boolean atualizar(long id, Membro membro) {   //FALTA IMPLEMENTAR
		return true;
	}
	
	public int consultarAnd(char[] atributos, char[] respectivosValoresAtributos) {   //FALTA IMPLEMENTAR
		return 1;
	}
	
	public int consultarOr(char[] atributos, char[] respectivosValoresAtributos) {   //FALTA IMPLEMENTAR
		return 1;
	}
	
	private void salvarXML() {
		arquivoColecao = new File("MembroConta.xml");
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
	
	private HashMap<Long, Membro> carregarXML() {                        //NO UML O MÉTODO TÁ VOID, MAS O COMUM É RETORNAR UMA COLECAO
		arquivoColecao = new File("MembroConta.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (HashMap<Long, Membro>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<Long, Membro>();
	}

}
