package main;

import entities.Account;
import entities.Client;
import impl.AccountRepositoryImpl;
import impl.ClientRepositoryImpl;
import repository.ClientRepository;
import services.AccountService;
import services.ClientService;
import views.ClientMenu;
import views.Login;
import views.Menu;

public class Main {
    public static void main(String[] args) {

        AccountService accountRepository = new AccountService();
        ClientService clientRepository = new ClientService();

        clientRepository.initRepository();
        accountRepository.initRepository();

        Menu tester = new Menu();
        //ClientMenu tester = new ClientMenu();
        tester.main();
    }
}