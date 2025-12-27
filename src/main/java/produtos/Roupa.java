package produtos;

import estoque.Estoque;
import estoque.Exibivel;

public abstract class Roupa implements Exibivel {
    protected String id;
    protected double precoBase;
    protected int emEstoque;
    protected String nome;
    protected String tamanho;
    protected boolean disponivel;
    protected final int taxa = 50;

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Roupa(String nome, Double valor, String tamanho, int emEstoque, Categoria categoria) {
        setTamanho(tamanho);
        setNome(nome);
        setPrecoBase(valor);
        setEmEstoque(emEstoque);
        setCategoria(categoria);
        setId();
    }

    public Roupa() {
    }

    protected void setId() {
        int nRoupas = Estoque.quantidadeDeRoupas();
        if (nRoupas < 10) {
            this.id = "0" + nRoupas;
        } else {
            this.id = "" + nRoupas;
        }
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getId() {
        return id;
    }

    public void setPrecoBase(double valorNovo) {
        precoBase = valorNovo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setEmEstoque(int emEstoqueNovo) {
        if (emEstoqueNovo == 0) {
            disponivel = false;
        }
        emEstoque = emEstoqueNovo;
    }

    public int getEstoque() {
        return emEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    protected double cadastrarPrecoBase() {
        do {
            System.out.print("Valor: ");
            double valor = Estoque.in.nextDouble();
            if (valor > 0) {
                return valor;
            } else if (valor <= 0) {
                System.out.println("Valor não pode ser negativo ou 0");
            } else {
                System.out.println("Valor inválido");
            }
        } while (true);

    }

    protected int cadastrarQEmEstoque() {
        int pedidos;
        do {
            System.out.print("Quantidade a ser adicionada ao estoque: ");
            pedidos = Estoque.in.nextInt();
            if (pedidos > 0) {
                return pedidos;
            } else {
                System.out.println("Quantidade a ser adicionada não pode ser negativa.");
            }
        } while (true);
    }

    protected String cadastrarNome() {
        String nome;
        do {
            Estoque.in.nextLine();
            System.out.print("Nome do produto: ");
            nome = Estoque.in.nextLine();

            if (nome.isBlank()) {
                System.out.println("Nome inválido, por favor digite novamente");
            } else {
                return nome;
            }
        } while (nome.isBlank());
        return "Erro";
    }

    protected String cadastrarTamanho() {
        int opcao;
        do {
            System.out.println("Qual tamanho?");
            System.out.println("1 - pp");
            System.out.println("2 - p");
            System.out.println("3 - m");
            System.out.println("4 - g");
            System.out.println("5 - gg");
            opcao = Estoque.in.nextInt();

            switch (opcao) {
                case 1:
                    return "PP";
                case 2:
                    return "P";
                case 3:
                    return "M";
                case 4:
                    return "G";
                case 5:
                    return "GG";
                default:
                    System.out.println("Escolha um tamanho");
            }
        } while (true);
    }

    @Override
    public void exibir() {
        System.out.println("Nome: " + getNome() + "\n"
                + "Categoria: " + getCategoria() + "\n"
                + "ID: " + getId() + "\n"
                + "Valor: R$ " + getPrecoBase() + "\n"
                + "Em Estoque: " + getEstoque() + "\n"
                + "Tamanho: " + getTamanho()+ "\n"+
                "-------------------------------");
    }

    protected abstract double calcularPreco(Roupa b);

    @Override
    public String toString() {
        return getNome() + "|" + getCategoria() + "|" + getId() + "|" + getPrecoBase() + "|" + getEstoque() + "|" + getTamanho();
    }
}


