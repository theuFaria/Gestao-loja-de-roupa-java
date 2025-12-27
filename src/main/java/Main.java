
import estoque.Cliente;
import estoque.Estoque;

public class Main {
    public static void main(String[] args) {
        int opcao;
        int rep = 0;
        Estoque estoque = new Estoque();
        Cliente c = new Cliente();

        do {
            if (rep > 0) {
                System.out.println("Deseja fazer mais alguma coisa?");
            } else {
                System.out.println("O que deseja fazer?");
            }
            System.out.println("1 - Cadastrar Cliente");

            System.out.println("2 - Cadastrar produto");

            System.out.println("3 - Clientes");

            System.out.println("4 - Ver Estoque de produtos");

            System.out.println("5 - Fazer pedido!");

            System.out.println("0 - Sair");

            opcao = Estoque.in.nextInt();

            switch (opcao) {
                case 1:
                    estoque.cadastrarClientEstoque();
                    break;
                case 2:
                    estoque.cadastrarRoupa();
                    break;
                case 3:
                    menu:
                    while (true) {
                        System.out.println("1 - Ver clientes.");
                        System.out.println("2 - Excluir cliente pelo id.");
                        System.out.println("0 - Voltar.");
                        int opcao2 = Estoque.in.nextInt();
                        switch (opcao2) {
                            case 1:
                                estoque.mostrarClientes();
                                continue;
                            case 2:
                                System.out.println("Informe o id:");
                                estoque.removerClienteById(Estoque.in.nextInt());
                                continue;
                            case 0:
                                break menu;
                            default:
                                System.out.println("Escolha uma das opções.");
                        }
                    }
                    break;
                case 4:
                    estoque.mostrarEstoque();
                    break;
                case 5:
                    c.fazerPedido();
                    break;
                case 0:
                    Estoque.in.nextLine();
                    menu:

                    while (true) {
                        System.out.println("Deseja Salvar? (sim ou não), se deseja sair,digite sair.");
                        String resp = Estoque.in.nextLine();
                        if ("sim".equalsIgnoreCase(resp)) {
                            estoque.salvamento(estoque.arrayClientes);
                            estoque.salvamento(estoque.arrayBlusas);
                            System.out.println("Encerrando...Tudo foi salvo com sucesso!");

                            return;
                        } else if ("não".equalsIgnoreCase(resp)) {
                            System.out.println("Encerrando...");
                            return;
                        } else if ("sair".equalsIgnoreCase(resp)) {
                            break menu;
                        }
                    }

                    break;
                default:
                    System.out.println("Escolha uma das opções.");
            }
            rep = 1;
        } while (true);
    }
}
