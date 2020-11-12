package persistenciaXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.projetos.Edital;

public class DAOXMLEdital {
	
	private ArrayList<Edital> persistidos = carregarXML();
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	
	public void criar(Edital edital) {   										                        
				persistidos.add(edital);                   
				salvarXML();                                                                 
	}
	
	public void remover(int id) { 
		for (Edital edital : persistidos) {
			if(edital.getId()==id) {
				persistidos.remove(edital);
				break;
			}
		}
                                
		salvarXML();                                         
	}
	
	public void atualizar() {           
		salvarXML();                                     			                                          
	}
	
	public Edital pesquisarEdital(int id){
		for (Edital edital : persistidos) {
			if(edital.getId()==id) {
				return edital;
			}
		}
		return null;
		
	}
	public ArrayList<Edital> getEdital(){
		return carregarXML();
	}
	public ArrayList<Edital> consultarAnd(String[] atributos, Object[] respectivosValoresAtributos) {
		ArrayList<Edital> editaisAnd = new ArrayList<Edital>();

		for (Edital i : persistidos) {
			for (int x = 0; x<atributos.length;x++) {
				if(atributos[x].equalsIgnoreCase("Nome")) {
					if(!respectivosValoresAtributos[x].equals(i.getNome())){
						return editaisAnd;
					}
			}
			else if(atributos[x].equalsIgnoreCase("CapitalReaisNaoGastoTotal")){
				if((float) respectivosValoresAtributos[x] != i.getCapitalReaisNaoGastoTotal()){
					return editaisAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("CusteioReaisNaoGastoTotal")){
				if((float) respectivosValoresAtributos[x] != i.getCusteioReaisNaoGastoTotal()){
					return editaisAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("CustoTotal")){
				if((float) respectivosValoresAtributos[x] != i.getCustoTotal()){
					return editaisAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("DataInicio")){
				if((long) respectivosValoresAtributos[x] != i.getDataInicio()){
					return editaisAnd;
				}
			}
			else if(atributos[x].equalsIgnoreCase("DataTermino")){
				if((long) respectivosValoresAtributos[x] != i.getDataTermino()){
					return editaisAnd;
				}
			}else{
				return editaisAnd;
			}
		  }
			editaisAnd.add(i);
		}
		return editaisAnd;
	}
	
	public ArrayList<Edital> consultarOr(String[] atributos, Object[] respectivosValoresAtributos) {
		ArrayList<Edital> editais = new ArrayList<Edital>();

		for (Edital i : persistidos) {
			for (int j = 0; j < atributos.length; j++) {
				//consulta os atributos
				if(atributos[j].equalsIgnoreCase("Nome") || 
						atributos[j].equalsIgnoreCase("CapitalReaisNaoGastoTotal") ||
						atributos[j].equalsIgnoreCase("CusteioReaisNaoGastoTotal") ||
						atributos[j].equalsIgnoreCase("CustoTotal") ||
						atributos[j].equalsIgnoreCase("DataInicio") ||
						atributos[j].equalsIgnoreCase("DataTermino")) {
					
					//compara o valor dos atributos respectivamente
					if(respectivosValoresAtributos[j].equals(i.getNome()) ||
							(float) respectivosValoresAtributos[j] == i.getCapitalReaisNaoGastoTotal() ||
							(float) respectivosValoresAtributos[j] == i.getCusteioReaisNaoGastoTotal() ||
							(float) respectivosValoresAtributos[j] == i.getCustoTotal() ||
							(long) respectivosValoresAtributos[j] == i.getDataInicio() ||
							(long) respectivosValoresAtributos[j] == i.getDataTermino()) {
						editais.add(i);
					}
				}
			}
		}
		return editais;
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
	
	private ArrayList<Edital> carregarXML() {                       
		arquivoColecao = new File("Edital.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (ArrayList<Edital>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Edital>();
	}

}
