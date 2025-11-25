package produtos;

import estoque.Estoque;

import java.util.Scanner;

public abstract class Roupa {
    protected String id;
    protected double valor;
    protected int emEstoque;
    protected String nome;
    protected int tamanho;
    // 0 - pp
    // 1 - p
    // 2 - m
    // 3 - g
    // 4 - gg

    public Roupa() {

    }
    private void setId(){
        int n = Estoque.getQuantidadeBlusas() + Estoque.getQuantidadeCalcas() + 1;
        if (n < 10){
            this.id = "0"+n;
        } else{
            this.id = ""+n;
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getId() {
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

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    private void cadastrarValor() {
        boolean ok = false;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Valor: ");
            double valor = in.nextDouble();
            if (valor > 0) {
                setValor(valor);
                ok = true;
            } else if (valor <= 0) {
                System.out.println("Valor não pode ser negativo ou 0");
            } else {
                System.out.println("Valor inválido");
            }
        } while (!ok);
    }

    private void cadastrarQEmEstoque() {
        int pedidos;
        Scanner in = new Scanner(System.in);
       do {
           System.out.print("Quantidade a ser adicionada ao estoque: ");
           pedidos = in.nextInt();
           if(pedidos > 0) {
               setEmEstoque(pedidos);
           } else {
               System.out.println("Quantidade a ser adicionada não pode ser negativa.");
           }
       } while(this.emEstoque != pedidos);
    }

    private void cadastrarNome() {
        String nome;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Nome do produto: ");
            nome = in.nextLine();

            setNome(nome);
            if (nome.isBlank()) {
                System.out.println("Nome inválido, por favor digite novamente");
            }
        } while (nome.isBlank());
    }

    private void cadastrarTamanho(){
        Scanner in = new Scanner(System.in);
        int opcao;
        boolean ok = true;
        do {
            System.out.println("Qual tamanho?");
            System.out.println("1 - pp");
            System.out.println("2 - p");
            System.out.println("3 - m");
            System.out.println("4 - g");
            System.out.println("5 - gg");
            opcao = in.nextInt();

            switch (opcao){
                case 1:
                    setTamanho(0);
                    ok = false;
                    break;
                case 2:
                    setTamanho(1);
                    ok = false;
                    break;
                case 3:
                    setTamanho(2);
                    ok = false;
                    break;
                case 4:
                    setTamanho(3);
                    ok = false;
                    break;
                case 5:
                    setTamanho(4);
                    ok = false;
                    break;
                default:
                    System.out.println("Escolha um tamanho");
            }
        } while(ok);
    }

    protected void cadastrarRoupa() {
        cadastrarNome();
        cadastrarValor();
        cadastrarTamanho();
        cadastrarQEmEstoque();
        setId();
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +"\n"+"Id: "+ getId()+"\n"+ "Valor: " + getValor() +"\n"+ "Em Estoque: " + getEstoque()
                +"\n"+ "Tamanho: "+ getTamanho() + "\n"+ "------------------------";
    }
}


