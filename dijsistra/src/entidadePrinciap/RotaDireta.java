package entidadePrinciap;


import java.util.Scanner;

public class RotaDireta {
	private static final int arad = 0;
	private static final int craiova = 1;
	private static final int dobreva = 2;
	private static final int eforie = 3;
	private static final int bucharest = 4;
	private static final int lasi = 5;
	private static final int giurgiu = 6;
	private static final int hisova = 7;
	private static final int fagaras = 8;
	private static final int orades = 9;
	private static final int mehandia = 10;
	private static final int lugoj = 11;
	private static final int neamf = 12;
	private static final int timisoara = 13;
	private static final int rimnicu_vikea = 14;
	private static final int pitesti = 15;
	private static final int sibiu = 16;
	private static final int zerind = 17;
	private static final int urziceni = 18;
	private static final int vaslui = 19;

	private static int Estrada(String type, Scanner in) {
		while (true) {
			System.out.println(type + ":");
			String line = in.nextLine().trim();
			if (line.isEmpty()) {
				System.out.println("Vai com deus!");
				System.exit(0);
			}
			try {
				int cidade = Integer.parseInt(line);
				if (cidade >= 1 && cidade <= 20)
					return cidade - 1;
			} catch (NumberFormatException e) {
			}
			System.out.println("Esta cidade não esta catalogada");
			
		}
	}

	public static void main(String[] args) {

		Dijkstra teste = new Dijkstra(20);

		teste.dis(urziceni, vaslui, 142);
		teste.dis(arad, timisoara, 118);
		teste.dis(orades, zerind, 71);
		teste.dis(zerind, arad, 75);
		teste.dis(craiova, rimnicu_vikea, 146);
		teste.dis(arad, sibiu, 140);
		teste.dis(timisoara, lugoj, 111);
		teste.dis(lugoj, mehandia, 70);
		teste.dis(mehandia, dobreva, 75);
		teste.dis(dobreva, craiova, 120);
		teste.dis(craiova, pitesti, 138);
		teste.dis(sibiu, fagaras, 99);
		teste.dis(fagaras, bucharest, 211);
		teste.dis(pitesti, bucharest, 101);
		teste.dis(bucharest, giurgiu, 90);
		teste.dis(orades, sibiu, 151);
		teste.dis(bucharest, urziceni, 85);
		teste.dis(urziceni, hisova, 98);
		teste.dis(vaslui, lasi, 92);
		teste.dis(lasi, neamf, 87);
		teste.dis(hisova, eforie, 86);
		teste.dis(rimnicu_vikea, pitesti, 97);
		teste.dis(rimnicu_vikea, sibiu, 80);

		Scanner in = new Scanner(System.in);
		System.out.println("Seja bem vindo ao Calculo de Rota:");
		System.out.println("Escolha as rotas que quer comacar e terminar que calcularemos a melhor rota\r\n" + "1-arad 2-craiova 3-dobreva \r\n" + 
				"4-eforie 5-bucharest 6-lasi \r\n" + 
				"7-giurgiu 8-hisova 9-fagaras \r\n" + 
				"10-orades 11-mehandia 12-lugoj \r\n" + 
				"13-neamf 14-timisoara 15-rimnicu_vikea \r\n" + 
				"16-pitesti 17-sibiu 18-zerind \r\n" + 
				"19-vaslue 20-urziceni");
			
		while (true) {
			
			int or = Estrada("Local de partida", in);
				

			int des = Estrada("Local de chegada", in);

			
			System.out.println("Rota completamente calculada:");
			for (Integer station : teste.cam(or, des)) {
				System.out.print((station + 1) + " -> ");
			}
			System.out.println("Chegada");
		}
	}
}