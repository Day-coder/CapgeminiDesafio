package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {
	static List<Integer> listaDeVisualizacoes = new ArrayList<Integer>();
	static int qtdTotalDeVisualizacoes = 0;

	public static void main(String args[]) {
		Scanner ler = new Scanner(System.in);
		int valorInvestido;
		System.out.println("Quantos reais você deseja investir?");
		valorInvestido = ler.nextInt();
		int numeroDeVisualizIniciais;
		numeroDeVisualizIniciais = valorInvestido * 30;
		System.out.println("O número de visualizações iniciais são aprox. " + numeroDeVisualizIniciais);

		visualizar(compartilhar(clicar(numeroDeVisualizIniciais)));
		for (Integer contador : listaDeVisualizacoes) {
			qtdTotalDeVisualizacoes = qtdTotalDeVisualizacoes + contador;
		}

		int totalFinalDeVisualizacoes = qtdTotalDeVisualizacoes + numeroDeVisualizIniciais;
		System.out.println("VISUALIZAÇÕES TOTAIS totais:  " + totalFinalDeVisualizacoes);
	}

	public static int clicar(int visualizacoes) {
		int qtdDeVisualizacoes = visualizacoes;
		float numeroDeCliques = (float) (qtdDeVisualizacoes / 8.3);
		
		return compartilhar((int) numeroDeCliques);
	}

	public static int compartilhar(int clique) {
		float qtdDeCompartilhamentos = (float) (clique / 6.6);
		int compartilhamentos = (int) qtdDeCompartilhamentos;

		return visualizar(compartilhamentos);
	}

	public static int visualizar(int compartilhamento) {
		int novasVisualizacoes = (compartilhamento * 30);
		
		while (novasVisualizacoes >= 8.8 && compartilhamento >= 1) {
			System.out.println("VISUALIZAÇÕES:  " + novasVisualizacoes);
			listaDeVisualizacoes.add(novasVisualizacoes);
			return clicar(novasVisualizacoes);
		}
		return novasVisualizacoes;
	}

}
