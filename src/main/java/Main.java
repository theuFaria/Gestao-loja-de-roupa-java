import clientes.Cliente;
import produtos.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Cliente cliente1 = new Cliente();

        System.out.print("Nome do cliente: ");
        cliente1.setNome(in.nextLine());

        System.out.print("Location do cliente: ");
        cliente1.setLocation(in.nextLine());

        System.out.print("Numero de pedidos do cliente: ");
        cliente1.setPedidos(in.nextInt());

        System.out.print("Id do Cliente: ");
        cliente1.setId(in.nextInt());
        in.nextLine();
        System.out.print("Email do Cliente: ");
        cliente1.setEmail(in.nextLine());

        cliente1.dadosCliente();

        Produto blusa = new Produto();

        System.out.print("Valor da blusa: ");
        blusa.setValor(in.nextDouble());
        in.nextLine();

        blusa.dadosProduto();

        in.close();
    }
}
