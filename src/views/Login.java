package views;

import entities.Account;
import entities.Client;
import services.AccountService;
import services.ClientService;
import utilities.Painel;
import javax.swing.*;

public class Login {
    AccountService accountService = new AccountService();
    ClientService clientService = new ClientService();

    public Login(){
        main();
    }

    //Método que apresenta o painel e coleta as credencais de Login.
    public void main(){
        Painel painel = new Painel();
        String[] credenciais = {"NAME", "PASSWORD"};
        painel.definedCampos(credenciais);
        painel.createOptions();
        painel.showPainelOptions("LOGIN", new String[]{"OK", "CANCEL"});
        painel.createOptions();

        for(String c : painel.getCampos()){
            if(c == null){
                JOptionPane.showMessageDialog(null,"INVALID. TRY AGAIN.");
                return;
            }
        }

        String name = painel.getCampos()[0];
        String password = painel.getCampos()[1];
        auth(name,password);
    }

    //Método que verifica se o usuário está cadastrado e redireciona para o menu principal.
    private void auth(String name, String password){
        Account conta = accountService.findAccount(name,password);
        if(conta != null){
            ClientMenu menu = new ClientMenu(conta.getTitular(),conta);
            menu.main();
        }
        else
            JOptionPane.showMessageDialog(null,"CLIENT NOT FOUND");
    }

}
