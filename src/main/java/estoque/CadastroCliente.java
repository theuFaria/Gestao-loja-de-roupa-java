package estoque;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroCliente {

    private String cadastrarNome() {
        String nomeTest;
        do {
            Estoque.in.nextLine();
            System.out.print("Nome: ");
            nomeTest = Estoque.in.nextLine();
            if(!nomeTest.isBlank()){
                return nomeTest;
            }
            System.out.println("Nome inválido, por favor digite novamente");
        } while (true);
    }

    private String cadastrarEmail() {
        do {
            System.out.print("Email: ");
            String email =  Estoque.in.nextLine();

            Pattern p = Pattern.compile("^[a-zA-Z+._%-]+\\d*[a-zA-Z]*@\\d*[a-zA-Z]*\\d*\\.[a-z]{2,4}$");
            Matcher m = p.matcher(email);

            if (m.find()) {
                return email;
            } else {
                System.out.println("Email inválido");
            }
        } while (true);
    }

    private String cadastrarLocation() {
        do {
            System.out.print("Localização (Sem acentos: Brasil,UF,Cidade,cep): ");
            String location = Estoque.in.nextLine();

            Pattern pattern = Pattern.compile("^[Bb]rasil,[a-zA-Z]{2},[a-zA-Z ]+,\\d{8}$");
            Matcher matcher = pattern.matcher(location);

            if (matcher.find()) {
                return location;
            } else {
                System.out.println("Localização não segue o padrão, certifique-se de colocar as virgulas.");
            }
        } while (true);
    }

    private String cadastrarTelefone() {
        do {
            System.out.print("Telefone (xx xxxxxxxxx): ");
            String tel =  Estoque.in.nextLine();

            Pattern padrao = Pattern.compile("^\\d{2} \\d{9}$");
            Matcher teste = padrao.matcher(tel);

            if (teste.matches()) {
                return tel;
            } else {
                System.out.println("Número inválido");
            }
        } while (true);
    }

     Cliente cadastrarCliente(int clientesTotais) {
        return new Cliente(cadastrarNome(), cadastrarLocation(),cadastrarEmail(),cadastrarTelefone(), clientesTotais);
    }

}
