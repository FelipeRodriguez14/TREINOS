package views;

import entities.Account;
import entities.Client;
import services.AccountService;
import services.ClientService;
import utilities.Painel;
import javax.swing.*;

public class ClientMenu {

    private Client client = new Client();
    private Account accountClient = new Account();
    private Painel painel = new Painel();
    private Menu voltar = new Menu();
    private AccountService accountService = new AccountService();
    private ClientService clientService = new ClientService();

    //Construtor
    public ClientMenu(Client client, Account accountClient){
        this.client = client;
        this.accountClient = accountClient;
    }

    //Método que apresenta o menu principal do cliente.
    public void main(){

        String[] op =
                {
                        "TRANSFER",
                        "WITHDRAW",
                        "DEPOSIT",
                        "VIEW BALANCE",
                        "CREDENTIALS",
                        "CHANGE DATA",
                        "EXIT",
                        "DELETE ACCOUNT"
                };
        boolean control = true;
        do{
            String action = painel.show(
                    op,
                    "WELCOME " + this.client.getNome(),
                    this.client.getNome()
            );
            if(action.equals("EXIT"))
                control = false;
            fluxoController(action);
        }while(control);

    }

    //Método que direciona as ações que o cliente toma, de acordo com os botões que ele clicar.
    private void fluxoController(String action){
        if(action.equals("TRANSFER"))
            transfer();
        if(action.equals("WITHDRAW"))
            withdraw();
        if(action.equals("DEPOSIT"))
            deposit();
        if(action.equals("VIEW BALANCE"))
            balance();
        if(action.equals("CREDENTIALS"))
            profile();
        if(action.equals("CHANGE DATA"))
            setMyCredenciais();
        if(action.equals("EXIT"))
            exit();
        if(action.equals("DELETE ACCOUNT"))
            deleteClient();
    }

    //Método para o cliente tranSferir dinheiro da sua conta para outro cliente existente.
    private void transfer(){
        Painel painel = new Painel();
        painel.definedCampos(new String[]{"NAME","CPF"});
        painel.createOptions();
        painel.showPainelOptions("TRANSFER", new String[]{"OK", "CANCEL"});
        String[] values = painel.getCampos();
        String nome = values[0];
        String cpf = values[1];
        double valor = Double.parseDouble(JOptionPane.showInputDialog("WHAT IS THE TRANSFER AMOUNT:"));

        accountService.transferir(this.accountClient, nome,cpf,valor);
    }

    //Método para o cliente sacar
    private void withdraw(){
        double saque = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE WITHDRAW AMOUNT:"));
        accountService.sacar(this.accountClient,saque);
    }

    //Método para o cliente depositar
    private void deposit(){
        double deposito = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE DEPOSIT AMOUNT"));
        accountService.depositar(this.accountClient, deposito);
    }

    //Método para o cliente ver o saldo
    private void balance(){
        accountService.getSaldo(this.accountClient);
    }

    //Método para ver o próprio perfil
    private void profile(){
        accountService.myAccount(this.accountClient);
    }

    //Método para alterar as credenciais do cliente
    private void setMyCredenciais(){
        String[] values = painel.getCampos();
        Painel menuCredentials = new Painel();
        menuCredentials.definedCampos(new String[]{"NAME", "AGE","PASSWORD"});
        menuCredentials.createOptions();
        menuCredentials.showPainelOptions("SET CREDENTIALS", new String[]{"OK", "CANCEL"});

        String name = menuCredentials.getCampos()[0];
        int age = Integer.parseInt(menuCredentials.getCampos()[1]);
        String password = menuCredentials.getCampos()[2];

        Client newClientCredentials = new Client(this.accountClient.getTitular().getId(), age,name,
                this.accountClient.getTitular().getCpf());
        clientService.setMyCredentials(newClientCredentials);
        accountService.setAccountCredentials(this.accountClient, password);
    }

    //Método para deletar o perfil do cliente
    private void deleteClient(){
        String senha = JOptionPane.showInputDialog("ENTER YOUR PASSWORD: ");
        if(this.accountClient.getSenha().equals(senha)){
            accountService.deleteAccount(this.accountClient);
            clientService.deleteClient(this.client);
            JOptionPane.showMessageDialog(null,"ACCOUNT DELETED !");
            exit();
        } else {
            JOptionPane.showMessageDialog(null,"INCORRECT PASSWORD");
        }

    }

    //Método para retornar ao menu inicial
    private void exit(){
        voltar.main();
    }
}
