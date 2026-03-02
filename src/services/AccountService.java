package services;

import entities.Account;
import entities.Client;
import impl.AccountRepositoryImpl;
import impl.ClientRepositoryImpl;
import repository.ClientRepository;
import javax.swing.*;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class AccountService {
    private AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
    //Construtora vazio caso seja necessário utilizar.
    public AccountService(){}

    /*
    * Como eu nçao criei um banco de dados que implementasse de forma automática os ID,
    * que são valores únicos, tiver que criar um método que verifica a unicidade de um ID, e
    * que faça a atribuição de um valor que não seja repetido.
    * */
    private int definedID(Map<Integer, Account> accounts){
        int id = 0;

        for(Account ac : accounts.values()){
            if(ac.getId() == id){
                id++;
            }
        }
        return id;
    }

    //Método que cria um nova conta.
    public void createAccount(Client client, String password){
        int number = ThreadLocalRandom.current().nextInt(10000,100000);
        int id = definedID(accountRepository.getAccounts());
        Account newAccount = new Account(id,client, password,0.00,number);
        accountRepository.createAccount(newAccount);
    }

    //Método que deleta a conta do usuário.
    public void deleteAccount(Account conta){
        if(conta.getSenha().equals(conta)){
            accountRepository.deleteAccount(conta);
        }
    }

    //Método para alterar as credenciais do usuário
    public void setAccountCredentials(Account account, String newPassword){
        if(account.getSenha().equals(newPassword)){
            JOptionPane.showMessageDialog(null,"THE PASSWORD MUST BE DIFFERENT FROM THE CURRENT ONE");
        } else{
            accountRepository.updateAccount(account, newPassword);
        }
    }

    //Método que retorna as credenciais do usuário.
    public void myAccount(Account conta){
       String msg =  accountRepository.myAccount(conta);
       JOptionPane.showMessageDialog(null, msg);
    }


    //Método que inciiar o "Banco de dados volátil"
    public void initRepository(){
        accountRepository.initDatas();
    }

    //Método que retorna uma conta existente com base no nome e cpf
    public Account findAccount(String nome, String passWord){
       return accountRepository.findAccount(nome,passWord);
    }

    //Método para sacar um valor da conta.
    public void sacar(Account conta, double valor){
        if(conta.getSaldo() > valor && valor > 0){
            accountRepository.sacar(conta.getId(),valor);
            System.out.println("saque realizado com sucesso !");
        }

    }
    //Método para depositar um valor na conta.
    public void depositar(Account conta, double valor){
        if(valor > 0){
            accountRepository.depositar(conta.getId(), valor);
            System.out.println("depósito realizado com sucesso !");

        }
    }

    //Método para transferir o valor da conta do usuário para outro usuário existente.
    public void transferir(Account conta, String nome, String cpf, double valor){
        Account destination = accountRepository.findAccount(nome,cpf);
        if(conta.getSaldo() > valor && valor > 0){
            accountRepository.transferir(conta.getId(), destination.getId(), valor);
            System.out.println("transferência realizada com sucesso !");

        }
    }

    //Método para retornar o saldo do usuário.
    public void getSaldo(Account account){
        accountRepository.getSaldo(account);
    }
}
