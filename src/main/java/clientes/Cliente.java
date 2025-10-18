package clientes;

public class Cliente {
    private String nome;
    private int idCliente;
    private String location;
    private int nPedidos;
    private String emailCliente;
    private String telefoneCliente;


    public void adicionarPedido(int n) {
        nPedidos += n;
    }

    public int getPedidos() {
        return nPedidos;
    }

    public void setPedidos(int n) {
        nPedidos = n;
    }

    public int getId() {
        return idCliente;
    }

    public void setId(int idNovo) {
        idCliente = idNovo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeNovo) {
        nome = nomeNovo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String locationNova) {
        location = locationNova;
    }

    public String getEmail() {
        return emailCliente;
    }

    public void setEmail(String emailNovo) {
        emailCliente = emailNovo;
    }

    public void dadosCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("Id: " + idCliente);
        System.out.println("Location: " + location);
        System.out.println("Pedidos: " + nPedidos);
        System.out.println("Email: " + emailCliente);
    }
}


