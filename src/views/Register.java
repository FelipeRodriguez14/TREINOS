package views;

import entities.Client;
import repository.AccountRepository;
import services.AccountService;
import services.ClientService;
import utilities.Painel;

import javax.swing.*;

public class Register {
    AccountService accountService = new AccountService();
    ClientService clientService = new ClientService();

    public Register(){
        main();
    }

    public void main(){
        Painel painel = new Painel();
        String[] credenciais = {"NAME", "AGE", "CPF", "PASSWORD"};
        painel.definedCampos(credenciais);
        painel.createOptions();
        painel.show(new String[]{"OK", "CANCEL"},"ENTER YOUR CREDENTIALS","LOGIN");
        painel.createOptions();

        for(String c : painel.getCampos()){
            if(c == null){
                JOptionPane.showMessageDialog(null,"INVALID. TRY AGAIN.");
                return;
            }
        }

        String name = painel.getCampos()[0];
        int age = Integer.parseInt(painel.getCampos()[1]);
        String cpf = painel.getCampos()[2];
        String password = painel.getCampos()[3];
        Client client = new Client(age,name,cpf);
        createAccount(client, password);

    }

    //Método cria um novo usuário e uma nova senha.
    private void createAccount(Client client, String password){
        clientService.createClient(client);
        accountService.createAccount(client,password);
    }
}
