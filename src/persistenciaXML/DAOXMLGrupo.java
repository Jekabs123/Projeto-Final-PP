package persistenciaXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.projetos.Edital;
import model.projetos.Grupo;

public class DAOXMLGrupo {
	
	private HashMap<Long, Grupo> persistidos = carregarXML();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public boolean criar(Grupo grupo) { 
		for (int i = 0; i <= persistidos.size(); i++) {            //PERCORRO A LISTA
			if(persistidos.size() == i) {                          //SE O TAMANHO DA LISTA FOR IGUAL AO I
				persistidos.put((long) (i+1), grupo);                      //ADICIONO O PROJETO NA POSI��O(CHAVE) I+1
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
			if(id <= persistidos.size()) {                       //SE O ID FOR MENOR QUE O TAMANHO DA LISTA, SIGNIFICA QUE O OBJETO EST� NELA
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
	public HashMap<Long, Grupo> getGrupo(){
		return carregarXML();
	}
	
	/*
	 * TODO FEITO
	 * 1. Devem verificar o nome do atributo de cada posicao do array e verificar o valor cooresponente
	 * bate. 
	 * 2. Corrigir demais DAOs
	 */
	public HashSet<Grupo> consultarAnd(String[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Grupo> grupoAnd = new HashSet<Grupo>();
		for (int i = 0; i < persistidos.size(); i++) {
			for (int x = 0; x<atributos.length;x++) {
				if(atributos[x].equalsIgnoreCase("Nome")) {
					if(!respectivosValoresAtributos[x].equals(persistidos.get(i).getNome())){
						return grupoAnd;
					}
			}
			else if(atributos[x].equalsIgnoreCase("CapitalReaisNaoGastoTotal")){
				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCapitalReaisNaoGastoTotal()){
					return grupoAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("CusteioReaisNaoGastoTotal")){
				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCusteioReaisNaoGastoTotal()){
					return grupoAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("CustoTotal")){
				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCustoTotal()){
					return grupoAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("DataInicio")){
				if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataInicio()){
					return grupoAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("DataTermino")){
				if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataTermino()){
					return grupoAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("DataCriacao")){
				if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataCriacao()){
					return grupoAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("LinkCNPq")){
				if(!respectivosValoresAtributos[x].equals(persistidos.get(i).getLinkCNPq())){
					return grupoAnd;
				}
			}else{
				return grupoAnd;
			}
		  }
			grupoAnd.add(persistidos.get(i));
		}
		return grupoAnd;
	  }
	
	/*
	 * TODO Feito
	 * 1. Devem verificar o nome do atributo de cada posicao do arraye verificar o valor cooresponente
	 * bate.
	 * 2. Corrigir demais DAOs
	 */
	public HashSet<Grupo> consultarOr(String[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Grupo> grupoOr = new HashSet<Grupo>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int j = 0; j < atributos.length; j++) {
				if(atributos[j].equalsIgnoreCase("Nome") || 
						atributos[j].equalsIgnoreCase("CapitalReaisNaoGastoTotal") ||
						atributos[j].equalsIgnoreCase("CusteioReaisNaoGastoTotal") ||
						atributos[j].equalsIgnoreCase("CustoTotal") ||
						atributos[j].equalsIgnoreCase("DataInicio") ||
						atributos[j].equalsIgnoreCase("DataTermino")||
						atributos[j].equalsIgnoreCase("DataCriacao")||
						atributos[j].equalsIgnoreCase("LinkCNPq")) {
					
					if(respectivosValoresAtributos[j].equals(persistidos.get(i).getNome()) ||
							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCapitalReaisNaoGastoTotal() ||
							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCusteioReaisNaoGastoTotal() ||
							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCustoTotal() ||
							(long) respectivosValoresAtributos[j] == persistidos.get(i).getDataInicio() ||
							(long) respectivosValoresAtributos[j] == persistidos.get(i).getDataTermino()||
							(long) respectivosValoresAtributos[j] == persistidos.get(i).getDataCriacao()||
							respectivosValoresAtributos[j].equals(persistidos.get(i).getLinkCNPq())) {
						grupoOr.add(persistidos.get(i));
					}
				}
			}
		 }
		return grupoOr;
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
	
	private HashMap<Long, Grupo> carregarXML() {                        //NO UML O M�TODO T� VOID, MAS O COMUM � RETORNAR UMA COLECAO
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
