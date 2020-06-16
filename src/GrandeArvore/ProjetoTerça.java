package GrandeArvore;

import java.util.Scanner;

class ArvoreDeBusca {
	  public static void main(String[] args) {
	    Scanner le = new Scanner(System.in);
	    ArvoreGalho arv = new ArvoreGalho();
	    int opcao;
	    long x;
	    System.out.print("\n Arvore binaria:");
	    do {
	        System.out.print("\n***********************************");
	        System.out.print("\n Opções:");
		System.out.print("\n ----1: Inserir:");
		System.out.print("\n ----2: Pesquisar:");
		System.out.print("\n ----3: Excluir:");
		System.out.print("\n ----4: Exibir:");
		System.out.print("\n ----5: Sair.");
		System.out.print("\n***********************************");
		System.out.print("\n-> ");
		opcao = le.nextInt();
		switch(opcao) {
		 	case 1: {
			       System.out.print("\n Informe o valor em numero inteiro: ");
			       x = le.nextLong();
			       arv.inserir(x);
			       break;
			}
		 	case 2: {
			       System.out.print("\n Informe o valor em numero inteiro: ");
	                       x = le.nextLong();
		      	       if( arv.buscar(x) != null )
			          System.out.print("\n Valor Encontrado");
			       else 
			          System.out.print("\n Valor nao encontrado!");
			       break;
			}	 
			case 3: {
			       System.out.print("\n Informe o valor em numero inteiro: ");
			       x = le.nextLong();
			       if ( !arv.remover(x) )
	                          System.out.print("\n Valor nao encontrado!");;
			       break;
			}
			
			case 4: {
			      arv.exibir();
			      break; 
			}
	        } 
	    } while(opcao != 5);

	  }
	}