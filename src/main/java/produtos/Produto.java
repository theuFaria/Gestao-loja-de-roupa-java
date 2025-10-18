package produtos;

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


    public void dadosProduto() {
        System.out.println("Id: " + id);
        System.out.println("Valor: " + valor);
        System.out.println("Em Estoque: " + emEstoque);
    }

}


