package estoque;

import produtos.Blusa;
import produtos.Calca;
import produtos.Categoria;
import produtos.Roupa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {

    public Estoque() {
        atualizarArrays();
    }

    public static int getQuantidadeCalcas() {
        return quantidadeCalcas;
    }

    public static int getQuantidadeBlusas() {
        return quantidadeBlusas;
    }

    private static int quantidadeBlusas;
    private static int quantidadeCalcas;
    private int quantidadeClientes = 0;
    public List<Roupa> arrayBlusas = new ArrayList<>();
    public List<Roupa> arrayCalca = new ArrayList<>();
    public List<Cliente> arrayClientes = new ArrayList<>();

    public static Scanner in = new Scanner(System.in);

    private int getQuantidadeClientes() {
        return quantidadeClientes;
    }

    private void addBlusa(Roupa b) {
        arrayBlusas.add(b);
        quantidadeBlusas++;
    }

    private void addCalca(Roupa c) {
        arrayCalca.add(c);
        quantidadeCalcas++;
    }

    private boolean showArray(List<? extends Exibivel> lista) {
        if (lista == null || lista.isEmpty()) {
            return false;
        }

        for (Exibivel item : lista) {
            item.exibir();
        }

        return true;
    }

    public void cadastrarRoupa() {
        Calca calca = new Calca();
        Blusa blusa = new Blusa();
        int opcao;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Qual produto deseja cadastrar");
            System.out.println("1 - Blusa");
            System.out.println("2 - Calça");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    addBlusa(blusa.cadastrarRoupa());
                    return;
                case 2:
                    addCalca(calca.cadastrarRoupa());
                    return;
                default:
                    System.out.println("Escolha uma das opções");
            }
        } while (true);
    }

    public void mostrarEstoque() {
        int opcao;
        do {
            System.out.println("1 - Ver todo o estoque.");
            System.out.println("2 - Ver estoque de blusas.");
            System.out.println("3 - Ver estoque de Calças.");
            System.out.println("0 - Voltar");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:

                    if (arrayCalca.isEmpty() & arrayBlusas.isEmpty()) {
                        System.out.println("Estoque vazio!");
                        break;
                    }

                    showArray(arrayCalca);
                    showArray(arrayBlusas);
                    continue;
                case 2:
                    if (showArray(arrayBlusas)) {
                        continue;
                    }
                    System.out.println("Não existe nenhum produto do tipo Blusa.");
                    continue;
                case 3:
                    if (showArray(arrayCalca)) {
                        continue;
                    }

                    System.out.println("Não existe nenhum produto do tipo calça.");
                    continue;
                case 0:
                    return;
                default:
                    System.out.println("Escolha uma das opções");
            }
        } while (true);
    }

    public void cadastrarClientEstoque() {
        CadastroCliente p = new CadastroCliente();
        arrayClientes.add(p.cadastrarCliente(arrayClientes.size()));
        quantidadeClientes++;
    }

    private void verClienteById(int id) {
        System.out.println(arrayClientes.get(--id) + "\n" + "---------------------------");
    }

    private void removerCliente(Cliente c) {
        arrayClientes.remove(c);
        quantidadeClientes--;
    }

    public void removerClienteById(int id) {
        if (id > 0 && id <= arrayClientes.size()) {
            removerCliente(arrayClientes.get(--id));
        } else {
            System.out.println("ID não encontrado");
        }
    }

    public void mostrarClientes() {
        int opcao;
        do {
            System.out.println("1 - Exibir cliente por id.");
            System.out.println("2 - Exibir todos os clientes.");
            System.out.println("0 - Voltar.");
            opcao = in.nextInt();
            in.nextLine();
            File caminho = new File("C:\\Documentos_fora_do_oneDrive\\Estudos\\Facul\\BackEnd\\JAVA\\Atividades_facul\\NewFlow\\src\\main\\java\\estoque\\clientes.txt");
            switch (opcao) {
                case 1:
                    int id;
                    do {

                        if (caminho.length() == 0 & arrayClientes.isEmpty()) {
                            System.out.println("Não há clientes cadastrados");
                            break;
                        }

                        System.out.println("Qual o ID");
                        id = in.nextInt();
                        if (id > 0 && id <= arrayClientes.size()) {
                            verClienteById(id);
                            break;
                        } else {
                            System.out.println("ID não encontrado");
                        }
                    } while (false);
                    continue;
                case 2:
                    if (caminho.length() == 0 & arrayClientes.isEmpty()) {
                        System.out.println("Não há clientes cadastrados");
                        break;
                    }

                    if (showArray(arrayClientes)) {
                        System.out.println("Total de Clientes: " + getQuantidadeClientes());
                    } else {
                        System.out.println("Não há clientes cadastrados!");
                    }
                    continue;
                case 0:
                    return;
                default:
                    System.out.println("Escolha uma das opções!");
                    break;
            }
        } while (true);
    }

    public static int quantidadeDeRoupas() {
        return getQuantidadeCalcas() + getQuantidadeBlusas();
    }

    private void salvarArray(List<?> lista, BufferedWriter arq) throws IOException {
        for (int i = 0; i < lista.size(); i++) {
            String item = lista.get(i).toString();
            arq.write(item);
            arq.newLine();
        }
    }

    public void salvamento(List<?> lista) {
        if (lista.isEmpty()) {
            return;
        }

        if (lista.get(0) instanceof Cliente) {
            try (BufferedWriter arq = new BufferedWriter(new FileWriter("C:\\Documentos_fora_do_oneDrive\\Estudos\\Facul\\BackEnd\\JAVA\\Atividades_facul\\NewFlow\\src\\main\\java\\estoque\\clientes.txt"))) {
                salvarArray(lista, arq);
            } catch (FileNotFoundException e) {
                System.out.println("Erro: Arquivo não encontrado ou inacessível. Verifique se o caminho está correto e se há permissão de acesso.");
            } catch (IOException e) {
                System.out.println("Erro de entrada/saída: ocorreu uma falha durante a leitura ou escrita do arquivo.");
            }
        } else {
            try (BufferedWriter arq = new BufferedWriter(new FileWriter("C:\\Documentos_fora_do_oneDrive\\Estudos\\Facul\\BackEnd\\JAVA\\Atividades_facul\\NewFlow\\src\\main\\java\\estoque\\roupas.txt"))) {
                salvarArray(lista, arq);
                salvarArray(arrayCalca, arq);
            } catch (FileNotFoundException e) {
                System.out.println("Erro: Arquivo não encontrado ou inacessível. Verifique se o caminho está correto e se há permissão de acesso.");
            } catch (IOException e) {
                System.out.println("Erro de entrada/saída: ocorreu uma falha durante a leitura ou escrita do arquivo.");
            }
        }
    }

    // Toda vez que o programa é executado, ele lê os arquivos e transforma cada linha em um objeto correspondente e salva no array.
    private void incluirNoArquivo(File caminho) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(caminho));

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] itens = linha.split("\\|");

                if (linha.contains("Blusa")) {
                    arrayBlusas.add(new Blusa(itens[0], Double.parseDouble(itens[3]), itens[5], Integer.parseInt(itens[4]), Categoria.Blusa));
                    quantidadeBlusas++;
                } else if (linha.contains("Brasil")) {
                    arrayClientes.add(new Cliente(itens[0], itens[2], itens[4], itens[5], arrayClientes.size()));
                    quantidadeClientes++;
                } else if (linha.contains("Calca")) {
                    arrayCalca.add(new Calca(itens[0], Double.parseDouble(itens[3]), itens[5], Integer.parseInt(itens[4]), Categoria.Calca));
                    quantidadeCalcas++;
                } else {
                    throw new IOException("Erro de entrada/saída: ocorreu uma falha durante a leitura ou escrita do arquivo.");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado ou inacessível. Verifique se o caminho está correto e se há permissão de acesso.");
        } catch (IOException e) {
            System.out.println("Erro de entrada/saída: ocorreu uma falha durante a leitura ou escrita do arquivo.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo.");
                }
            }
        }
    }

    private void atualizarArrays() {
        File caminhoClientes = new File("C:\\Documentos_fora_do_oneDrive\\Estudos\\Facul\\BackEnd\\JAVA\\Atividades_facul\\NewFlow\\src\\main\\java\\estoque\\clientes.txt");
        File caminhoRoupa = new File("C:\\Documentos_fora_do_oneDrive\\Estudos\\Facul\\BackEnd\\JAVA\\Atividades_facul\\NewFlow\\src\\main\\java\\estoque\\roupas.txt");

        incluirNoArquivo(caminhoClientes);
        incluirNoArquivo(caminhoRoupa);
    }

}


