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

    public void AdicionarPedido(int n) {
        nPedidos += n;
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

    private void CadastrarNome() {
        String nomeTest;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Nome: ");
            nomeTest = in.nextLine();

            nome = nomeTest;
            if (nome.isEmpty()) {
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
                emailCliente = email;
                ok = false;
            } else {
                System.out.println("Email inválido");
            }
        } while (ok);
    }

    private void CadastrarLocation() {
        Scanner in = new Scanner(System.in);

        System.out.print("Localização: ");
        location = in.nextLine();
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
                telefoneCliente = tel;
                ok = false;
            } else {
                System.out.println("Número inválido");
            }
        } while (ok);
    }

    public void CadastrarCliente() {
        CadastrarNome();
        CadastrarEmail();
        CadastrarTelefone();
        CadastrarLocation();
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

    public String getTelefone() {
        return telefoneCliente;
    }

    public void dadosCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("Id: " + idCliente);
        System.out.println("Location: " + location);
        System.out.println("Pedidos: " + nPedidos);
        System.out.println("Email: " + emailCliente);
    }
}


