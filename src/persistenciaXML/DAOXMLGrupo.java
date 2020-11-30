package persistenciaXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.projetos.Grupo;

public class DAOXMLGrupo {
	
	private DAOGrupo persistidos;
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public DAOXMLGrupo() {
		persistidos = carregarXML();
	}
	
	public void criar(Grupo grupo) { 
		persistidos.add(grupo);
		salvarXML();                                      
	}
	
	public void remover(int id) {  
		for(Grupo g : persistidos.getGrupos()){
			if(g.getId() == id){
				persistidos.remove(g);
				break;
			}
		}
		salvarXML();                                                 
	}
	
	public void atualizar() {  
		salvarXML();       
	}
	public Grupo pesquisarGrupo(int id) throws Exception{
		for(Grupo g: persistidos.getGrupos()){
			if(g.getId() == id){
				return g;
			}
		}
		throw new Exception("id invalido");
	}
	public ArrayList<Grupo> getPersistidos(){
		return persistidos.getGrupos();
	}
	

//	public HashSet<Grupo> consultarAnd(String[] atributos, Object[] respectivosValoresAtributos) {
//		HashSet<Grupo> grupoAnd = new HashSet<Grupo>();
//		for (int i = 0; i < persistidos.getGrupos().size(); i++) {
//			for (int x = 0; x<atributos.length;x++) {
//				if(atributos[x].equalsIgnoreCase("Nome")) {
//					if(!respectivosValoresAtributos[x].equals(persistidos.get(i).getNome())){
//						return grupoAnd;
//					}
//			}
//			else if(atributos[x].equalsIgnoreCase("CapitalReaisNaoGastoTotal")){
//				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCapitalReaisNaoGastoTotal()){
//					return grupoAnd;
//				}
//			}
//			else if(atributos[x].equalsIgnoreCase("CusteioReaisNaoGastoTotal")){
//				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCusteioReaisNaoGastoTotal()){
//					return grupoAnd;
//				}
//			}
//			else if(atributos[x].equalsIgnoreCase("CustoTotal")){
//				if((float) respectivosValoresAtributos[x] != persistidos.get(i).getCustoTotal()){
//					return grupoAnd;
//				}
//			}
//			else if(atributos[x].equalsIgnoreCase("DataInicio")){
//				if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataInicio()){
//					return grupoAnd;
//				}
//			}
//			else if(atributos[x].equalsIgnoreCase("DataTermino")){
//				if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataTermino()){
//					return grupoAnd;
//				}
//			}
//			else if(atributos[x].equalsIgnoreCase("DataCriacao")){
//				if((long) respectivosValoresAtributos[x] != persistidos.get(i).getDataCriacao()){
//					return grupoAnd;
//				}
//			}
//			else if(atributos[x].equalsIgnoreCase("LinkCNPq")){
//				if(!respectivosValoresAtributos[x].equals(persistidos.get(i).getLinkCNPq())){
//					return grupoAnd;
//				}
//			}else{
//				return grupoAnd;
//			}
//		  }
//			grupoAnd.add(persistidos.get(i));
//		}
//		return grupoAnd;
//	  }
//	
//
//	public HashSet<Grupo> consultarOr(String[] atributos, Object[] respectivosValoresAtributos) {
//		HashSet<Grupo> grupoOr = new HashSet<Grupo>();
//
//		for (int i = 0; i < persistidos.size(); i++) {
//			for (int j = 0; j < atributos.length; j++) {
//				if(atributos[j].equalsIgnoreCase("Nome") || 
//						atributos[j].equalsIgnoreCase("CapitalReaisNaoGastoTotal") ||
//						atributos[j].equalsIgnoreCase("CusteioReaisNaoGastoTotal") ||
//						atributos[j].equalsIgnoreCase("CustoTotal") ||
//						atributos[j].equalsIgnoreCase("DataInicio") ||
//						atributos[j].equalsIgnoreCase("DataTermino")||
//						atributos[j].equalsIgnoreCase("DataCriacao")||
//						atributos[j].equalsIgnoreCase("LinkCNPq")) {
//					
//					if(respectivosValoresAtributos[j].equals(persistidos.get(i).getNome()) ||
//							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCapitalReaisNaoGastoTotal() ||
//							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCusteioReaisNaoGastoTotal() ||
//							(float) respectivosValoresAtributos[j] == persistidos.get(i).getCustoTotal() ||
//							(long) respectivosValoresAtributos[j] == persistidos.get(i).getDataInicio() ||
//							(long) respectivosValoresAtributos[j] == persistidos.get(i).getDataTermino()||
//							(long) respectivosValoresAtributos[j] == persistidos.get(i).getDataCriacao()||
//							respectivosValoresAtributos[j].equals(persistidos.get(i).getLinkCNPq())) {
//						grupoOr.add(persistidos.get(i));
//					}
//				}
//			}
//		 }
//		return grupoOr;
//	}
	
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
	
	private DAOGrupo carregarXML() {                        
		arquivoColecao = new File("Grupo.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (DAOGrupo) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new DAOGrupo();
	}

}
