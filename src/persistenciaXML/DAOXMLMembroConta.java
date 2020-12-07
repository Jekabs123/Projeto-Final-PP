package persistenciaXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.autenticacao.Membro;

public class DAOXMLMembroConta {

	private DAOMembro persistidos;
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));

	public DAOXMLMembroConta() {
		persistidos = carregarXML();
	}

	public void criar(Membro membro) {   
		persistidos.add(membro);
		salvarXML();
	}

	public void remover(long matricula) {
		for(Membro m : persistidos.getMembros()){
			if(m.getMatricula()== matricula){
				persistidos.remove(m);
				break;
			}
		}
		salvarXML();                                              
	}

	public void atualizar() { 
		salvarXML();                                     
	}
	public Membro pesquisarMembro(long matricula){
		for(Membro m: persistidos.getMembros()){
			if(m.getMatricula() == matricula){
				return m;
			}
		}
		return null;
	}
	public ArrayList<Membro> getMembro(){
		return persistidos.getMembros();
	}
	public HashSet<Membro> consultarAnd(String[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Membro> membroAnd = new HashSet<Membro>();

		for (Membro m: persistidos.getMembros()) {
			for (int x = 0; x < atributos.length; x++) {
				//consulta os atributos
				if(atributos[x].equalsIgnoreCase("Matricula")){
					if((long)respectivosValoresAtributos[x] != m.getMatricula()){
						return membroAnd;
					}
				}
				else if(atributos[x].equalsIgnoreCase("Nome")){
					if(!respectivosValoresAtributos[x].equals(m.getNome())){
						return membroAnd;
					}
				}
				else if(atributos[x].equalsIgnoreCase("Ativo")){
					if((boolean) respectivosValoresAtributos[x] != m.isAtivo()){
						return membroAnd;
					}
				}
				else if(atributos[x].equals(m.getEmail())){
					if(!respectivosValoresAtributos[x].equals(m.getEmail())){
						return membroAnd;
					}
				}
				else if(atributos[x].equals(m.getAdministrador())){
					if((boolean)respectivosValoresAtributos[x] != m.getAdministrador()){
						return membroAnd;
					}
				}else{
					return membroAnd;
				}

			}
			membroAnd.add(m);
		}
		return membroAnd;
	}

	public HashSet<Membro> consultarOr(String[] atributos, Object[] respectivosValoresAtributos) {
		HashSet<Membro> membroOr = new HashSet<Membro>();

		for (Membro m: persistidos.getMembros()) {
			for (int j = 0; j < atributos.length; j++) {
				//consulta os atributos
				if(atributos[j].equalsIgnoreCase("Matricula") ||
						atributos[j].equalsIgnoreCase("Nome") ||
						atributos[j].equalsIgnoreCase("Ativo") ||
						atributos[j].equalsIgnoreCase("Email") ||
						atributos[j].equalsIgnoreCase("Administrador")) {

					//compara o valor dos atributos respectivamente
					if((long) respectivosValoresAtributos[j] == m.getMatricula() ||
							respectivosValoresAtributos[j].equals(m.getNome()) ||
							(boolean) respectivosValoresAtributos[j] == m.isAtivo()||
							respectivosValoresAtributos[j].equals(m.getEmail()) ||
							(boolean) respectivosValoresAtributos[j] == m.getAdministrador()) {
						membroOr.add(m);
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

	private DAOMembro carregarXML() {                        
		arquivoColecao = new File("MembroConta.xml");
		try {
			if(arquivoColecao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoColecao);
				return (DAOMembro) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new DAOMembro();
	}

}
