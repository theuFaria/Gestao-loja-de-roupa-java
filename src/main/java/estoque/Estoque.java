package estoque;

import produtos.Blusa;
import produtos.Calca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {

    public static int getQuantidadeBlusas() {
        return quantidadeBlusas;
    }

    public static int getQuantidadeCalcas() {
        return quantidadeCalcas;
    }

    private static int quantidadeBlusas;
    private static int quantidadeCalcas;
    private static int quantidadeClientes;
    public static List<Blusa> arrayBlusas = new ArrayList<>();
    public static List<Calca> arrayCalca = new ArrayList<>();
    public static List<Cliente> arrayClientes = new ArrayList<>();

    public static int getQuantidadeClientes() {
        return quantidadeClientes;
    }

    private static void addBlusa(Blusa b) {
        arrayBlusas.add(b);
        quantidadeBlusas++;
    }

    private static void addCalca(Calca c) {
        arrayCalca.add(c);
        quantidadeCalcas++;
    }

    private void removerBlusa(Calca c) {
        arrayCalca.remove(c);
        quantidadeBlusas--;
    }

    public void addQuantidadeBlusas(int n) {
        quantidadeBlusas += n;
    }

    private static void showArray(List<?> lista) {
        lista.forEach(e -> {
            System.out.println(e);
            System.out.println("------------------");
        });
    }

    public static void cadastrarRoupa() {
        Blusa b = new Blusa();
        Calca calca = new Calca();
        int opcao;
        Scanner in = new Scanner(System.in);
        boolean ok = true;
        do {
            System.out.println("Qual produto deseja cadastrar");
            System.out.println("1 - Blusa");
            System.out.println("2 - Calça");
            System.out.println("3 - Vestido");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    b.cadastrarRoupa();
                    addBlusa(b);
                    ok = false;
                    break;
                case 2:
                    calca.cadastrarRoupa();
                    addCalca(calca);
                    ok = false;
                    break;
                case 3:
                    System.out.println("Ainda não pronto");
                    ok = false;
                    break;
                default:
                    System.out.println("Escolha uma das opções");
            }
        } while (ok);
    }

    public static void mostrarEstoque() {
        Scanner in = new Scanner(System.in);
        int opcao;
        boolean ok = true;
        do {
            System.out.println("1 - Ver todo o estoque.");
            System.out.println("2 - Ver estoque de blusas.");
            System.out.println("3 - Ver estoque de Calças.");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    showArray(arrayBlusas);
                    showArray(arrayCalca);
                    ok = false;
                    break;
                case 2:
                    if (!arrayBlusas.isEmpty()) {
                        showArray(arrayBlusas);
                        ok = false;
                        break;
                    }
                    System.out.println("Não existe nenhum produto do tipo blusa.");
                    break;
                case 3:
                    if (!arrayCalca.isEmpty()) {
                        showArray(arrayCalca);
                        ok = false;
                        break;
                    }

                    System.out.println("Não existe nenhum produto do tipo calça.");
                    break;
                default:
                    System.out.println("Escolha uma das opções");
            }
        } while (ok);
    }

    public static void cadastrarCliente() {
        Cliente c = new Cliente();
        c.CadastrarCliente();
        arrayClientes.add(c);
    }

    public static void verClienteById(int id){
        System.out.println(arrayClientes.get(--id)+ "\n"+ "---------------------------");
    }

    public static void mostrarClientes(){
       boolean ok = true;
       Scanner in = new Scanner(System.in);
       int opcao;
       do{
           System.out.println("1 - Ver clinte por id");
           System.out.println("2 - Ver todos os clientes");
           opcao = in.nextInt();
           switch (opcao){
               case 1:
                   int id = 0;
                   do{
                       System.out.println("Qual o ID");
                       id = in.nextInt();
                       if(id > 0 && id <= arrayClientes.size()) {
                           verClienteById(id);
                           break;
                       } else {
                           System.out.println("ID não encontrado");
                       }
                   } while(false);
                   ok = false;
                   break;
               case 2:
                   showArray(arrayClientes);
                   ok = false;
                   break;
               default:
           }
       }while(ok);
    }

}

