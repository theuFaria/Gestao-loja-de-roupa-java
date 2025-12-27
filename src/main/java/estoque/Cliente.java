package estoque;

public class Cliente implements Exibivel {
    private String nome;
    private String idCliente;
    private String location;
    private int nPedidos = 0;
    private String emailCliente;
    private String telefoneCliente;

    public Cliente(String nome, String location, String emailCliente, String telefoneCliente, int clientesTotais) {
        setNome(nome);
        setLocation(location);
        setEmail(emailCliente);
        setTelefone(telefoneCliente);
        setIdCliente(clientesTotais);
    }

    public Cliente(){}

    void setIdCliente(int nClients) {
        if (nClients < 10) {
            this.idCliente = "0" + ++nClients;
        } else {
            this.idCliente = "" + nClients;
        }
    }

    int getPedidos() {
        return nPedidos;
    }

    String getId() {
        return idCliente;
    }

    String getNome() {
        return nome;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    String getLocation() {
        return location;
    }

    void setLocation(String locationNova) {
        location = locationNova;
    }

    String getEmail() {
        return emailCliente;
    }

    void setEmail(String emailNovo) {
        emailCliente = emailNovo;
    }

    void setTelefone(String tel) {
        telefoneCliente = tel;
    }

    String getTelefone() {
        return telefoneCliente;
    }

    @Override
    public void exibir() {
        System.out.println("Nome: " + getNome() + "\n" + "Id: " + getId() + "\n" + "Localização: " + getLocation()
                + "\n" + "Pedidos: " + getPedidos() +
                "\n" + "Email: " + getEmail()
                + "\n" + "Telefone: " + getTelefone()+ "\n"+
                "----------------------------------------------");
    }

    public void fazerPedido() {
        System.out.println("Não implementado.");
        nPedidos++;
    }

    @Override
    public String toString() {
        return getNome() + "|" + getId() + "|" + getLocation() + "|" + getPedidos() + "|" + getEmail() + "|" + getTelefone();
    }

}

