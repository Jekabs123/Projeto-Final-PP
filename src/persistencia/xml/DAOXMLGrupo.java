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

import model.projetos.Edital;
import model.projetos.Grupo;

public class DAOXMLGrupo {
	
	private HashMap<Long, Grupo> persistidos = carregarXML();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public boolean criar(Grupo grupo) { 
		for (int i = 0; i <= persistidos.size(); i++) {            //PERCORRO A LISTA
			if(persistidos.size() == i) {                          //SE O TAMANHO DA LISTA FOR IGUAL AO I
				persistidos.put((long) (i+1), grupo);                      //ADICIONO O PROJETO NA POSIÇÃO(CHAVE) I+1
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
	public HashMap<Long, Grupo> getGrupo(){
		return carregarXML();
	}
	public HashSet<Grupo> consultarAnd(Object[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Grupo> grupoAnd = new HashSet<Grupo>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int x = 0; x < atributos.length; x++) {
				//consulta os atributos
				if(atributos[x].equals(persistidos.get(i).getNome()) && 
						atributos[x].equals(persistidos.get(i).getCapitalReaisNaoGastoTotal()) &&
						atributos[x].equals(persistidos.get(i).getCusteioReaisNaoGastoTotal()) &&
						atributos[x].equals(persistidos.get(i).getCustoTotal()) &&
						atributos[x].equals(persistidos.get(i).getDataInicio()) &&
						atributos[x].equals(persistidos.get(i).getDataTermino())&&
						atributos[x].equals(persistidos.get(i).getDataCriacao())&&
						atributos[x].equals(persistidos.get(i).getLinkCNPq())) {
					
					//compara o valor dos atributos respectivamente
					if(respectivosValoresAtributos[x].equals(persistidos.get(i).getNome()) &&
							(float) respectivosValoresAtributos[x] == persistidos.get(i).getCapitalReaisNaoGastoTotal() &&
							(float) respectivosValoresAtributos[x] == persistidos.get(i).getCusteioReaisNaoGastoTotal() &&
							(float) respectivosValoresAtributos[x] == persistidos.get(i).getCustoTotal() &&
							(long) respectivosValoresAtributos[x] == persistidos.get(i).getDataInicio() &&
							(long) respectivosValoresAtributos[x] == persistidos.get(i).getDataTermino()&&
							(long) respectivosValoresAtributos[x] == persistidos.get(i).getDataCriacao()&&
							respectivosValoresAtributos[x].equals(persistidos.get(i).getLinkCNPq())) {
						grupoAnd.add(persistidos.get(i));
					}
				}
			}
		 }
		return grupoAnd;
	}
	
	public HashSet<Grupo> consultarOr(Object[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Grupo> grupoOr = new HashSet<Grupo>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int j = 0; j < atributos.length; j++) {
				//consulta os atributos
				if(atributos[j].equals(persistidos.get(i).getNome()) || 
						atributos[j].equals(persistidos.get(i).getCapitalReaisNaoGastoTotal()) ||
						atributos[j].equals(persistidos.get(i).getCusteioReaisNaoGastoTotal()) ||
						atributos[j].equals(persistidos.get(i).getCustoTotal()) ||
						atributos[j].equals(persistidos.get(i).getDataInicio()) ||
						atributos[j].equals(persistidos.get(i).getDataTermino())||
						atributos[j].equals(persistidos.get(i).getDataCriacao())||
						atributos[j].equals(persistidos.get(i).getLinkCNPq())) {
					
					//compara o valor dos atributos respectivamente
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
