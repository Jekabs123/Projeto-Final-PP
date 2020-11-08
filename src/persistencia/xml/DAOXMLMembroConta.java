package persistencia.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.autenticacao.Membro;
import model.projetos.Grupo;
import model.projetos.Projeto;

public class DAOXMLMembroConta {
	
	private HashMap<Long, Membro> persistidos = carregarXML();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	
	public boolean criar(Membro membro) {   
		for (int i = 0; i <= persistidos.size(); i++) {            //PERCORRO A LISTA
			if(persistidos.size() == i) {                          //SE O TAMANHO DA LISTA FOR IGUAL AO I
				persistidos.put((long) (i+1), membro);                     //ADICIONO O PROJETO NA POSIÇÃO(CHAVE) I+1
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
	public void remover(Membro membro){
		persistidos.remove(membro);
		salvarXML();
	}
	public boolean atualizar(long id, Membro membro) { 
		for (int i = 0; i < persistidos.size(); i++) {           //PERCORRO A LISTA
			if(id <= persistidos.size()) {                       //SE O ID FOR MENOR QUE O TAMANHO DA LISTA, SIGNIFICA QUE O OBJETO ESTÁ NELA
				persistidos.put(id, membro);                     //ATUALIZO O OBJETO PARA O ID DESEJADO
				salvarXML();                                     //SALVO O ARQUIVO
				return true;                                     //RETORNO TRUE SE DEU CERTO
			}
		}
		return false;                                            //RETORNO FALSE SE DEU ERRADO
	}
	public Membro pesquisarMembro(long idMembro){
		return persistidos.get(idMembro);
	}
	public HashMap<Long, Membro> getMembro(){
		return carregarXML();
	}
	public HashSet<Membro> consultarAnd(String[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Membro> membroAnd = new HashSet<Membro>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int x = 0; x < atributos.length; x++) {
				//consulta os atributos
				if(atributos[x].equalsIgnoreCase("Matricula")){
					if((long)respectivosValoresAtributos[x] != persistidos.get(i).getMatricula()){
						return null;
					}
				}
				else if(atributos[x].equalsIgnoreCase("Nome")){
					if(!respectivosValoresAtributos[x].equals(persistidos.get(i).getNome())){
						return null;
					}
				}
				else if(atributos[x].equalsIgnoreCase("Ativo")){
					if((boolean) respectivosValoresAtributos[x] != persistidos.get(i).isAtivo()){
						return null;
					}
				}
				else if(atributos[x].equals(persistidos.get(i).getEmail())){
					if(!respectivosValoresAtributos[x].equals(persistidos.get(i).getEmail())){
						return null;
					}
				}
				else if(atributos[x].equals(persistidos.get(i).getAdministrador())){
					if((boolean)respectivosValoresAtributos[x] != persistidos.get(i).getAdministrador()){
						return null;
					}
				}else{
					return null;
				}
				
			  }
				membroAnd.add(persistidos.get(i));
			}
		return membroAnd;
	}
	
	public HashSet<Membro> consultarOr(Object[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Membro> membroOr = new HashSet<Membro>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int j = 0; j < atributos.length; j++) {
				//consulta os atributos
				if(atributos[j].equals(persistidos.get(i).getMatricula()) ||
						atributos[j].equals(persistidos.get(i).getNome()) ||
						atributos[j].equals(persistidos.get(i).isAtivo()) ||
						atributos[j].equals(persistidos.get(i).getEmail()) ||
						atributos[j].equals(persistidos.get(i).getAdministrador())) {
					
					//compara o valor dos atributos respectivamente
					if((long) atributos[j] == persistidos.get(i).getMatricula() ||
							respectivosValoresAtributos[j].equals(persistidos.get(i).getNome()) ||
							(boolean) atributos[j] == persistidos.get(i).isAtivo()||
							atributos[j].equals(persistidos.get(i).getEmail()) ||
							(boolean) atributos[j] == persistidos.get(i).getAdministrador()) {
						membroOr.add(persistidos.get(i));
					}
				}
			}
		 }
		return membroOr;
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
