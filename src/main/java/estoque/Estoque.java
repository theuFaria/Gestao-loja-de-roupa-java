package estoque;

import clientes.Cliente;
import produtos.Produto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Estoque {
    public ArrayList<Produto> estoqueProdutos = new ArrayList<>();
    public ArrayList<Cliente> listaClientes = new ArrayList<>();

    public void AdicionarProduto(Produto p) {
        estoqueProdutos.add(p);
    }
    public ArrayList<Produto> GetProdutos() {
        return estoqueProdutos;
    }
}
