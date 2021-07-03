import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.joda.time.DateTime;
import org.joda.time.Days;


public class CadastroAnuncio {
	private Connection connection;
	 
	 static Scanner scanner= new Scanner(System.in);
	
	 
	 	 int Id;
	 	 int investimentoPorDia;
		 String nomeDoAnuncio;
		 String nomeDoCliente;
		 int diaInicio;
		 int mesInicio;
		 int anoInicio;
		 int diaFim;
		 int mesFim;
		 int anoFim;

	 
	 
		Anuncio anuncio= new Anuncio();
	    private void openConnection() {
	        connection = Conexao.C();
	    }
	    
	   

	    public boolean cadastrar() throws Exception {
		    
	        openConnection();
	        String sql;
	     
	        
	        try {
	            sql = "INSERT INTO ANUNCIOC (Investimento, Nome_Anuncio,Nome_Cliente, Dia_Inicio, Mes_Inicio, Ano_Inicio, Dia_Fim, Mes_Fim, Ano_Fim)"
	            		//+ "VALUES (?, ?, ?, '"+dataInicioFormatada.format(c.getTime())+"','"+dataTerminoFormatada.format(c.getTime())+"')";
	           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            		
	            PreparedStatement ps = connection.prepareStatement(sql);
	       
	           System.out.println("Digite o nome do Anuncio: ");
	           nomeDoAnuncio= scanner.next();	
	           anuncio.setNomeDoAnuncio(nomeDoAnuncio);
	           System.out.println("Digite o nome do Cliente: ");
	           nomeDoCliente= scanner.next();	
	           anuncio.setNomeDoCliente(nomeDoCliente);
	           System.out.println("Digite o valor que será investido por dia: ");
	           investimentoPorDia= scanner.nextInt();
	           anuncio.setInvestimentoPorDia(investimentoPorDia);
	           System.out.println("Digite o dia de início: ");
	           diaInicio= scanner.nextInt();
	           anuncio.setDiaInicio(diaInicio);
	           System.out.println("Digite o mês de início: ");
	           mesInicio= scanner.nextInt();
	           anuncio.setMesInicio(mesInicio);
	           System.out.println("Digite o ano de início: ");
	           anoInicio= scanner.nextInt();
	           anuncio.setAnoInicio(anoInicio);
	           
	           System.out.println("Digite o dia do término de exibição do anúncio: ");
	           diaFim= scanner.nextInt();
	           anuncio.setDiaFim(diaFim);
	           System.out.println("Digite o mês do término de exibição do anúncio: ");
	           mesFim= scanner.nextInt();
	           anuncio.setMesFim(mesFim);
	           System.out.println("Digite o ano do término de exibição do anúncio: ");
	           anoFim= scanner.nextInt();
	           anuncio.setAnoFim(anoFim);
	           
	           
	           DateTime dataInicio = new DateTime(anoInicio, mesInicio, diaInicio, 0, 0);
		        // System.out.println("dateeeeeee " + dataInicio);
		 	   	 DateTime dataTermino = new DateTime(anoFim, mesFim, diaFim, 0, 0);


		 	   	 int dias = Days.daysBetween(dataInicio, dataTermino).getDays();
		 	   	// System.out.println("dataaa " + dias);
	         
	          // int i=2;
	            ps.setInt(1, anuncio.getInvestimentoPorDia() * dias);
	            ps.setString(2, anuncio.getNomeDoAnuncio()); 
	            ps.setString(3, anuncio.getNomeDoCliente());
	            ps.setInt(4, anuncio.getDiaInicio());
	            ps.setInt(5, anuncio.getMesInicio());
	            ps.setInt(6, anuncio.getAnoInicio());
	            ps.setInt(7, anuncio.getDiaFim());
	            ps.setInt(8, anuncio.getMesFim());
	            ps.setInt(9, anuncio.getMesFim());
 
	          ps.execute();
	            System.out.println("Cadastro Realizado!");
	            
	            return true;
	        } catch (Exception e) {
	        	  System.out.println(e);
	        	  return false;
	        } finally {
	            connection.close(); 
	        }
	        
	        
	      
			
	    }
	    
	    
	    
	    static List<Integer> listaDeVisualizacoes = new ArrayList<Integer>();
		static int qtdTotalDeVisualizacoes = 0;
		
		static List<Integer> listaDeCliques = new ArrayList<Integer>();
		static int qtdTotalDeCliques = 0;
		
		static List<Integer> listaDeCompartilhamentos = new ArrayList<Integer>();
		static int qtdTotalDeCompartilhamentos = 0;
	    
        public void mostrarRelatorio() throws SQLException {
        	 openConnection();
        	String sql = "SELECT Investimento, Nome_Anuncio,Nome_Cliente, Dia_Inicio, Mes_Inicio, Ano_Inicio, Dia_Fim, Mes_Fim, Ano_Fim FROM ANUNCIOC "
    	 			+ "WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            System.out.println("Digite o Id do usuário a ser consultado:");
	           Id= scanner.nextInt();	
	           anuncio.setId(Id);
         ps.setInt(1, anuncio.getId());
         ps.execute();
 		
         ResultSet set1= ps.getResultSet();
         while(set1.next()) {
        	
        	 //System.out.println ("Resultado " + set1.getInt("Investimento"));
        	 int i= set1.getInt("Investimento")*30;
        	// System.out.println("O número de visualizações iniciais são aprox. " + i);
        	 visualizar(compartilhar(clicar(i)));
     		for (Integer contador : listaDeVisualizacoes) {
     			qtdTotalDeVisualizacoes = qtdTotalDeVisualizacoes + contador;
     		}
     		for (Integer contadorCl : listaDeCliques) {
				qtdTotalDeCliques = qtdTotalDeCliques + contadorCl;
			}
     		for (Integer contadorCompt : listaDeCompartilhamentos) {
				qtdTotalDeCompartilhamentos = qtdTotalDeCompartilhamentos + contadorCompt;
			}
     		 int o= set1.getInt("Investimento");
     		int totalFinalDeVisualizacoes = qtdTotalDeVisualizacoes + i;
     		//System.out.println("VISUALIZAÇÕES TOTAIS:  " + qtdTotalDeVisualizacoes);
     		System.out.println("Invetimento de " + o + " R$.");
     		System.out.println( totalFinalDeVisualizacoes + " visualizações!");
     		System.out.println( qtdTotalDeCliques + " cliques! ");
     		System.out.println( qtdTotalDeCompartilhamentos + " compartilhamentos! ");
     		 listaDeCliques.clear();
             listaDeCompartilhamentos.clear();
             listaDeVisualizacoes.clear();
             qtdTotalDeCliques= 0;
             qtdTotalDeCompartilhamentos=0;
             qtdTotalDeVisualizacoes =0;
         }
       
        

        }
        
        
        
        
        
        public static int clicar(int visualizacoes) {
    		int qtdDeVisualizacoes = visualizacoes;
    		float numeroDeCliques = (float) (qtdDeVisualizacoes / 8.3);
    		listaDeCliques.add((int) numeroDeCliques);
    		return compartilhar((int) numeroDeCliques);
    	}

    	public static int compartilhar(int clique) {
    		float qtdDeCompartilhamentos = (float) (clique / 6.6);
    		int compartilhamentos = (int) qtdDeCompartilhamentos;
    		listaDeCompartilhamentos.add(compartilhamentos);
    		return visualizar(compartilhamentos);
    	}

    	public static int visualizar(int compartilhamento) {
    		int novasVisualizacoes = (compartilhamento * 30);
    		
    		while (novasVisualizacoes >= 8.8 && compartilhamento >= 1) {
    			//System.out.println("VISUALIZAÇÕES:  " + novasVisualizacoes);
    			listaDeVisualizacoes.add(novasVisualizacoes);
    			return clicar(novasVisualizacoes);
    		}
    		return novasVisualizacoes;
    	}
        
    	 public void menu() throws Exception {
 	    	int opcao;
 	    	int opcao2;
 	    	Scanner ler= new Scanner (System.in);
 	    	
 	    	System.out.println("Escolha a opção que você deseja:");
 	    	System.out.println("1-Cadastrar");
 	    	System.out.println("2-Mostrar Relatório");
 
 	    	opcao=ler.nextInt();
 	    	
 	    	switch(opcao) {
 	    	case 1:
 	    		cadastrar();
 	    		break;
 	    	case 2:
 	    		mostrarRelatorio();
 	    		break;
 	         default:
 	    		System.out.println("Opcão inválida");
 	    	
 	    	}
 	    	System.out.println("Deseja fazer outra operação? 1-SIM 2-NÃO");
 	    	opcao2=ler.nextInt();
 	    	if(opcao2==1) {
 	    		menu();
 	    	}
 	    	else if(opcao2==2) {
 	    		System.out.println("Saindo...");
 	    	}
 	    	else {
 	    		System.out.println("Opcão inválida, saindo...");
 	    	}
 	    	
 	    }
 }

        

