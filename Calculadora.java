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
		System.out.println("Quantos reais voc� deseja investir?");
		valorInvestido = ler.nextInt();
		int numeroDeVisualizIniciais;
		numeroDeVisualizIniciais = valorInvestido * 30;
		System.out.println("O n�mero de visualiza��es iniciais s�o aprox. " + numeroDeVisualizIniciais);

		visualizar(compartilhar(clicar(numeroDeVisualizIniciais)));
		for (Integer contador : listaDeVisualizacoes) {
			qtdTotalDeVisualizacoes = qtdTotalDeVisualizacoes + contador;
		}

		int totalFinalDeVisualizacoes = qtdTotalDeVisualizacoes + numeroDeVisualizIniciais;
		System.out.println("VISUALIZA��ES TOTAIS totais:  " + totalFinalDeVisualizacoes);
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
			System.out.println("VISUALIZA��ES:  " + novasVisualizacoes);
			listaDeVisualizacoes.add(novasVisualizacoes);
			return clicar(novasVisualizacoes);
		}
		return novasVisualizacoes;
	}

}
