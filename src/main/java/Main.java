import estoque.Cliente;
import estoque.Estoque;
import produtos.Blusa;
import produtos.Calca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        int rep = 0;
        Cliente c1 = new Cliente();
        Blusa b1 = new Blusa();
        Calca calça = new Calca();
        Scanner in = new Scanner(System.in);

        do {
            if (rep > 0) {
                System.out.println("Deseja fazer mais alguma coisa?");
            } else {
                System.out.println("O que deseja fazer?");
            }
            System.out.println("1 - Cadastrar Cliente");

            System.out.println("2 - Cadastrar produto");

            System.out.println("3 - Ver clientes");

            System.out.println("4 - Ver produtos");

            System.out.println("5 - Ver Estoque");

            System.out.println("0 - Sair");

            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    Estoque.cadastrarCliente();
                    break;
                case 2:
                    Estoque.cadastrarRoupa();
                    break;
                case 3:
                    Estoque.mostrarClientes();
                    break;
                case 4:
                    System.out.println("--------------------------------------");
                    // Mesma coisa dos Clientes.
                    System.out.println("--------------------------------------");
                    break;
                case 5:
                    Estoque.mostrarEstoque();
                    break;
                default:
                    System.out.println("Encerrando...");
            }
            rep = 1;
        } while (opcao != 0);
    }
}
