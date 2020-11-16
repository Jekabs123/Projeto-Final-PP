package persistenciaXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.projetos.Projeto;

public class DAOXMLProjetoParticipacao {

	private DAOProjeto persistidos;
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public DAOXMLProjetoParticipacao() {
		persistidos = carregarXML();
	}

	public void criar(Projeto projeto) {                         
		persistidos.add(projeto);                   
		salvarXML();                                          
	}


	public void remover(long id) {   
		for (Projeto projeto : persistidos.getProjetos()) {
			if(projeto.getId()==id) {
				persistidos.remove(projeto);
				break;
			}
		}
		salvarXML();                                                                                      
	}

	public void atualizar() {        
		salvarXML();                                          
	}
	public Projeto pesquisarProjeto(int id){
		for (Projeto projeto : persistidos.getProjetos()) {
			if(projeto.getId()==id) {
				return projeto;
			}
		}
		return null;
	}
	
//	public HashSet<Projeto> consultarAnd(String[] atributos, Object[] respectivosValoresAtributos) {
//		HashSet<Projeto> projetoAnd = new HashSet<Projeto>();
//
//		for (int i = 0; i < persistidos.size(); i++) {
//			for (int x = 0; x < atributos.length; x++) {
//				if(atributos[x].equalsIgnoreCase("Nome")){
//					if(!respectivosValoresAtributos[x].equals(persistidos.get(i).getNome())){
//						return projetoAnd;
//					}
//				}else if(atributos[x].equalsIgnoreCase("AporteCapitalReais")){
//					if((float) respectivosValoresAtributos[x] != persistidos.get(i).getAporteCapitalReais()){
//						return projetoAnd;
//					}
//				}else if(atributos[x].equalsIgnoreCase("AporteCusteioReais")){
//					if((float) respectivosValoresAtributos[x] != persistidos.get(i).getAporteCusteioReais()){
//						return projetoAnd;
//					}
//				}else if(atributos[x].equalsIgnoreCase("GastoExecutadoCapitalReais")){
//					if((float) respectivosValoresAtributos[x] != persistidos.get(i).getGastoExecutadoCapitalReais()){
//						return projetoAnd;
//					}
//				}else if(atributos[x].equalsIgnoreCase("GastoExecutadoCusteioReais")){
//					if((float) respectivosValoresAtributos[x] != persistidos.get(i).getGastoExecutadoCusteioReais()){
//						return projetoAnd;
//					}
//				}else if(atributos[x].equalsIgnoreCase("DataInicio")){
//					if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataInicio()){
//						return projetoAnd;
//					}
//				}else if(atributos[x].equalsIgnoreCase("DataTermino")) {
//					if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataTermino()){
//						return projetoAnd;
//					}
//				}else{
//					return projetoAnd;
//				}
//			}
//			projetoAnd.add(persistidos.get(i));
//		}
//		return projetoAnd;
//	}
//
//	public HashSet<Projeto> consultarOr(String[] atributos, Object[] respectivosValoresAtributos) {
//		HashSet<Projeto> projetoOr = new HashSet<Projeto>();
//
//		for (int i = 0; i < persistidos.size(); i++) {
//			for (int x = 0; x < atributos.length; x++) {
//				if(atributos[x].equalsIgnoreCase("Nome")||
//						atributos[x].equalsIgnoreCase("AporteCapitalReais")||
//						atributos[x].equalsIgnoreCase("AporteCusteioReais")||
//						atributos[x].equalsIgnoreCase("GastoExecutadoCapitalReais")||
//						atributos[x].equalsIgnoreCase("GastoExecutadoCusteioReais")||
//						atributos[x].equalsIgnoreCase("DataInicio")||
//						atributos[x].equalsIgnoreCase("DataTermino")) {
//
//					//compara o valor dos atributos respectivamente
//					if(respectivosValoresAtributos[x].equals(persistidos.get(i).getNome())||
//							(float) respectivosValoresAtributos[x] == persistidos.get(i).getAporteCapitalReais()||
//							(float) respectivosValoresAtributos[x] == persistidos.get(i).getAporteCusteioReais()||
//							(float) respectivosValoresAtributos[x] == persistidos.get(i).getGastoExecutadoCapitalReais()||
//							(float) respectivosValoresAtributos[x] == persistidos.get(i).getGastoExecutadoCusteioReais()||
//							(long) respectivosValoresAtributos[x] == persistidos.get(i).getDataInicio()||
//							(long) respectivosValoresAtributos[x] == persistidos.get(i).getDataTermino()) {
//						projetoOr.add(persistidos.get(i));
//					}
//				}
//			}
//		}
//		return projetoOr;
//	}

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

	private DAOProjeto carregarXML() {                        
		arquivoColecao = new File("ProjetoParticipacao.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (DAOProjeto) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new DAOProjeto();
	}


	public ArrayList<Projeto> getPersistidos() {
		return persistidos.getProjetos();
	}

}
