import clientes.Cliente;
import produtos.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        int rep = 0;
        Scanner in = new Scanner(System.in);
        do {
            if(rep > 0) {
                System.out.println("Deseja fazer mais alguma coisa");
            } else{
                System.out.println("Deseja fazer oq");
            }
            System.out.println("0 - Cadastrar Cliente");

            System.out.println("1 - Cadastrar produto");

            System.out.println("2 - Sair");

            opcao = in.nextInt();

            Cliente cliente01 = new Cliente();
            Produto produto01 = new Produto();
            switch (opcao) {
                case 0:
                    cliente01.CadastrarCliente();
                    break;
                case 1:
                    produto01.CadastrarProduto();
                    break;
                default:
                    System.out.println("Encerrando");
            }
            rep++;
        } while (opcao != 2);
        in.close();
    }
}
