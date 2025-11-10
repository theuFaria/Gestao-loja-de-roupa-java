package produtos;

import java.util.Scanner;

public class Produto {
    private int id;
    private double valor;
    private int emEstoque;
    private String nome;


    public Produto() {
        SetId(1);
        // Definir o ID com base no array de produtos.
    }

    public void SetId(int idNovo) {
        id = idNovo;
    }

    public int GetId() {
        return id;
    }

    public void SetValor(double valorNovo) {
        valor = valorNovo;
    }

    public double GetValor() {
        return valor;
    }

    public void SetEmEstoque(int emEstoqueNovo) {
        emEstoque = emEstoqueNovo;
    }

    public int GetEstoque() {
        return emEstoque;
    }

    public String GetNome() {return nome;}

    public void SetNome(String nome) {this.nome = nome;}

    private void CadastrarValor() {
        boolean ok = false;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Valor: ");
            double valor = in.nextDouble();
            if (valor > 0) {
                SetValor(valor);
                ok = true;
            } else if (valor <= 0) {
                System.out.println("Valor não pode ser negativo ou 0");
            } else {
                System.out.println("Valor inválido");
            }
        } while (!ok);
    }

    private void CadastrarQEmEstoque() {
        int pedidos;
       do {
           Scanner in = new Scanner(System.in);
           System.out.print("Quantidade em estoque: ");
           pedidos = in.nextInt();
           if(pedidos > 0) {
               SetEmEstoque(pedidos);
           } else {
               System.out.println("Quantidade em estoque não pode ser negativa.");
           }
       } while(this.emEstoque != pedidos);
    }

    private void CadastrarNome() {
        String nome;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Nome do produto: ");
            nome = in.nextLine();

            SetNome(nome);
            if (nome.isBlank()) {
                System.out.println("Nome inválido, por favor digite novamente");
            }
        } while (nome.isBlank());
    }


    public void CadastrarProduto() {
        CadastrarNome();
        CadastrarValor();
        CadastrarQEmEstoque();
    }

    public void dadosProduto() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Id: " + this.id);
        System.out.println("Valor: " + this.valor);
        System.out.println("Em Estoque: " + this.emEstoque);
    }
}


