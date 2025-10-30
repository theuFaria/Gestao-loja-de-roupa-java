package produtos;

import java.util.Scanner;

public class Produto {
    private int id;
    private double valor;
    private int emEstoque;

    public void setId(int idNovo) {
        id = idNovo;
    }

    public int getId() {
        return id;
    }

    public void setValor(double valorNovo) {
        valor = valorNovo;
    }

    public double getValor() {
        return valor;
    }

    public void setEmEstoque(int emEstoqueNovo) {
        emEstoque = emEstoqueNovo;
    }

    public int getEstoque() {
        return emEstoque;
    }

    private void CadastrarValor(Produto p) {
        boolean ok = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Valor: ");
            double valor = in.nextDouble();
            if (valor > 0) {
                p.valor = valor;
                ok = false;
            } else if (valor <= 0) {
                System.out.println("Valor não pode ser negativo ou 0");
            } else {
                System.out.println("Valor inválido");
            }
        } while (ok);
    }

    public void CadastrarEstoque(Produto p) {
        boolean ok = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Quantos: ");
            int q = in.nextInt();
            if (q > 0) {
                p.emEstoque = q;
                ok = false;
            } else if (q == 0) {
                System.out.println("Não se pode cadastrar 0 produtos.");
            } else {
                System.out.println("Número inválido");
            }
        } while (ok);
    }


    public void CadastrarProduto() {
        Produto novoP = new Produto();
        CadastrarValor(novoP);
        CadastrarEstoque(novoP);
    }

    public void dadosProduto() {
        System.out.println("Id: " + id);
        System.out.println("Valor: " + valor);
        System.out.println("Em Estoque: " + emEstoque);
    }
}


