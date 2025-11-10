import clientes.Cliente;
import produtos.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        int rep = 0;
        Scanner in = new Scanner(System.in);
        Produto p1 = new Produto();
        Cliente c1 = new Cliente();
        do {
            if (rep > 0) {
                System.out.println("Deseja fazer mais alguma coisa?");
            } else {
                System.out.println("O que deseja fazer?");
            }
            System.out.println("1 - Cadastrar Cliente");

            System.out.println("2 - Cadastrar produto");

            System.out.println("3 - Ver cliente");

            System.out.println("4 - Ver produto");

            System.out.println("0 - Sair");

            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    c1.CadastrarCliente();
                    break;
                case 2:
                    p1.CadastrarProduto();
                    break;
                case 3:
                    System.out.println("--------------------------------------");
                    if (c1.GetNome() == null) {
                        System.out.println("Não há clientes cadastrados.");
                    } else {
                        c1.dadosCliente();
                    }
                    System.out.println("--------------------------------------");
                    break;
                case 4:
                    System.out.println("--------------------------------------");
                    if (p1.GetNome() == null) {
                        System.out.println("Não há produtos cadastrados.");
                    } else {
                        p1.dadosProduto();
                    }
                    System.out.println("--------------------------------------");
                    break;
                default:
                    System.out.println("Encerrando...");
            }
            rep = 1;
        } while (opcao != 0);
        in.close();
    }
}
