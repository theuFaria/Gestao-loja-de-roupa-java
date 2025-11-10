package clientes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
    private String nome;
    private int idCliente;
    private String location;
    private int nPedidos;
    private String emailCliente;
    private String telefoneCliente;

    public Cliente() {
        SetId(1);
        SetPedidos(0);

        // Fazer o ID com base no array de clientes.
    }

    public void AdicionarPedido(int n) {
        if (n > 0){
            nPedidos += n;
        } else {
            System.out.println("Não se pode adicionar 0 ou números negativas à quantidade de pedidos.");
        }
    }

    public int GetPedidos() {
        return nPedidos;
    }

    public void SetPedidos(int n) {
        nPedidos = n;
    }

    public int GetId() {
        return idCliente;
    }

    public void SetId(int idNovo) {
        idCliente = idNovo;
    }

    public String GetNome() {
        return nome;
    }

    public void SetNome(String nome) {
        this.nome = nome;
    }

    public String GetLocation() {
        return location;
    }

    public void SetLocation(String locationNova) {
        location = locationNova;
    }

    public String GetEmail() {
        return emailCliente;
    }

    public void SetEmail(String emailNovo) {
        emailCliente = emailNovo;
    }

    public void SetTelefone(String tel) {
        telefoneCliente = tel;
    }

    public String GetTelefone() {
        return telefoneCliente;
    }

    private void CadastrarNome() {
        String nomeTest;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Nome: ");
            nomeTest = in.nextLine();

            SetNome(nomeTest);
            if (nome.isBlank()) {
                System.out.println("Nome inválido, por favor digite novamente");
            }
        } while (nomeTest.isBlank());
    }

    private void CadastrarEmail() {
        boolean ok = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Email: ");
            String email = in.nextLine();

            Pattern p = Pattern.compile("^[a-zA-Z]+\\d*[a-zA-Z]*@\\d*[a-zA-Z]*\\d*\\.[a-z]{2,3}$");
            Matcher m = p.matcher(email);

            if (m.find()) {
                SetEmail(email);
                ok = false;
            } else {
                System.out.println("Email inválido");
            }
        } while (ok);
    }

    private void CadastrarLocation() {
        Scanner in = new Scanner(System.in);

        System.out.print("Localização: ");
        SetLocation(in.nextLine());

        // Sem ideia de como fazer uma validação para isso ainda.
    }

    private void CadastrarTelefone() {
        boolean ok = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Telefone: ");
            String tel = in.nextLine();

            Pattern padrao = Pattern.compile("^(\\d{13}|\\d{11}|\\d{2}[- ](\\d{9}|\\d{11}|\\d{2}[- ]\\d{9}))$");
            Matcher teste = padrao.matcher(tel);

            if (teste.matches()) {
                SetTelefone(tel);
                ok = false;
            } else {
                System.out.println("Número inválido");
            }
        } while (ok);
    }

    public void CadastrarCliente () {
        CadastrarNome();
        CadastrarEmail();
        CadastrarTelefone();
        CadastrarLocation();

        // Adicionar esse cliente cadastrado em um array, para guardar a informação.
    }


    public void dadosCliente() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Id: " + this.idCliente);
        System.out.println("Location: " + this.location);
        System.out.println("Pedidos: " + this.nPedidos);
        System.out.println("Email: " + this.emailCliente);
        System.out.println("Telefone: " + this.telefoneCliente);
    }
}


