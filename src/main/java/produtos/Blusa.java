package produtos;

public class Blusa extends Roupa {

    public Blusa(String nome, double valor, String tamanho, int estoque, Categoria categoria) {
        super(nome, valor, tamanho, estoque, categoria);
    }

    public Blusa() {
    }

    @Override
    protected double calcularPreco(Roupa roupa) {
        // Nenhuma blusa pode custar menos que 50;
        return (taxa + roupa.getPrecoBase());
    }

    public Roupa cadastrarRoupa() {
        super.setId();
        Blusa blusa = new Blusa(cadastrarNome(), cadastrarPrecoBase(), cadastrarTamanho(), cadastrarQEmEstoque(), Categoria.Blusa);
        blusa.disponivel = true;
        blusa.setPrecoBase(calcularPreco(blusa));
        return blusa;
    }
}
