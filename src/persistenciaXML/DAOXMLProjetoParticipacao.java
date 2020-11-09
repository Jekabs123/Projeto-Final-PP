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

import model.autenticacao.Membro;
import model.projetos.Participacao;
import model.projetos.Projeto;

public class DAOXMLProjetoParticipacao {
	
	private HashMap<Long, Projeto> persistidos = carregarXML();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public boolean criar(Projeto projeto) {                        //RECEBO UM PROJETO 
		for (int i = 0; i <= persistidos.size(); i++) {            //PERCORRO A LISTA
			if(persistidos.size() == i) {                          //SE O TAMANHO DA LISTA FOR IGUAL AO I
				persistidos.put((long) (i+1), projeto);                    //ADICIONO O PROJETO NA POSIÇÃO(CHAVE) I+1
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
	
	public boolean atualizar(long id, Projeto projeto) {         //RECEBO UM ID E UM PROJETO
		for (int i = 0; i < persistidos.size(); i++) {           //PERCORRO A LISTA
			if(id <= persistidos.size()) {                       //SE O ID FOR MENOR QUE O TAMANHO DA LISTA, SIGNIFICA QUE O OBJETO ESTÁ NELA
				persistidos.put(id, projeto);                    //ATUALIZO O OBJETO PARA O ID DESEJADO
				salvarXML();                                     //SALVO O ARQUIVO
				return true;                                     //RETORNO TRUE SE DEU CERTO
			}
		}
		return false;                                            //RETORNO FALSE SE DEU ERRADO
	}
	public Projeto pesquisarProjeto(long idDoProjeto){
		return persistidos.get(idDoProjeto);
	}
	public HashSet<Projeto> consultarAnd(Object[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Projeto> projetoAnd = new HashSet<Projeto>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int x = 0; x < atributos.length; x++) {
				//consulta os atributos
				if(atributos[x].equals(persistidos.get(i).getNome())&&
				   atributos[x].equals(persistidos.get(i).getAporteCapitalReais())&&
				   atributos[x].equals(persistidos.get(i).getAporteCusteioReais())&&
				   atributos[x].equals(persistidos.get(i).getGastoExecutadoCapitalReais())&&
				   atributos[x].equals(persistidos.get(i).getGastoExecutadoCusteioReais())&&
				   atributos[x].equals(persistidos.get(i).getDataInicio())&&
				   atributos[x].equals(persistidos.get(i).getDataTermino())) {
					
					//compara o valor dos atributos respectivamente
					if(atributos[x].equals(persistidos.get(i).getNome())&&
							   (float) atributos[x] == persistidos.get(i).getAporteCapitalReais()&&
							   (float) atributos[x] == persistidos.get(i).getAporteCusteioReais()&&
							   (float) atributos[x] == persistidos.get(i).getGastoExecutadoCapitalReais()&&
							   (float) atributos[x] == persistidos.get(i).getGastoExecutadoCusteioReais()&&
							   (long) atributos[x] == persistidos.get(i).getDataInicio()&&
							   (long) atributos[x] == persistidos.get(i).getDataTermino()) {
						projetoAnd.add(persistidos.get(i));
					}
				}
			}
		 }
		return projetoAnd;
	}
	
	public HashSet<Projeto> consultarOr(Object[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Projeto> projetoOr = new HashSet<Projeto>();

		for (int i = 0; i < persistidos.size(); i++) {
			for (int j = 0; j < atributos.length; j++) {
				//consulta os atributos
				if(atributos[j].equals(persistidos.get(i).getNome())||
				   atributos[j].equals(persistidos.get(i).getAporteCapitalReais())||
				   atributos[j].equals(persistidos.get(i).getAporteCusteioReais())||
				   atributos[j].equals(persistidos.get(i).getGastoExecutadoCapitalReais())||
				   atributos[j].equals(persistidos.get(i).getGastoExecutadoCusteioReais())||
				   atributos[j].equals(persistidos.get(i).getDataInicio())||
				   atributos[j].equals(persistidos.get(i).getDataTermino())) {
					
					//compara o valor dos atributos respectivamente
					if(atributos[j].equals(persistidos.get(i).getNome())||
							   (float) atributos[j] == persistidos.get(i).getAporteCapitalReais()||
							   (float) atributos[j] == persistidos.get(i).getAporteCusteioReais()||
							   (float) atributos[j] == persistidos.get(i).getGastoExecutadoCapitalReais()||
							   (float) atributos[j] == persistidos.get(i).getGastoExecutadoCusteioReais()||
							   (long) atributos[j] == persistidos.get(i).getDataInicio()||
							   (long) atributos[j] == persistidos.get(i).getDataTermino()) {
						projetoOr.add(persistidos.get(i));
					}
				}
			}
		 }
		return projetoOr;
	}
	
	private void salvarXML() {
		arquivoColecao = new File("ProjetoParticipacao.xml");
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
	
	private HashMap<Long, Projeto> carregarXML() {                        //NO UML O MÉTODO TÁ VOID, MAS O COMUM É RETORNAR UMA COLECAO
		arquivoColecao = new File("ProjetoParticipacao.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (HashMap<Long, Projeto>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<Long, Projeto>();
	}


	public HashMap<Long, Projeto> getPersistidos() {
		return persistidos;
	}
	
}
