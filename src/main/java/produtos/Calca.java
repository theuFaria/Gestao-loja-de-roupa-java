package produtos;

public class Calca extends Roupa{

    public Calca(String nome, double valor, String t, int est, Categoria categoria){
        super(nome, valor, t, est, categoria);
    }

    public Calca(){}

    @Override
    protected double calcularPreco(Roupa roupa) {
        int fixo = taxa * 2;  // Nenhuma calça pode custar menos que 100.
        return (fixo + roupa.getPrecoBase());
    }


    public Roupa cadastrarRoupa() {
        super.setId();
        Calca calca = new Calca(cadastrarNome(), cadastrarPrecoBase(), cadastrarTamanho(), cadastrarQEmEstoque(), Categoria.Calca);
        calca.disponivel = true;
        calca.setPrecoBase(calcularPreco(calca));
        return calca;
    }

}
