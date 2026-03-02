package impl;

import entities.Account;
import entities.Client;
import repository.AccountRepository;
import repository.ClientRepository;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class AccountRepositoryImpl implements AccountRepository {

    private static Map<Integer, Account> accounts = new HashMap<Integer, Account>();
    private static ClientRepositoryImpl clients = new ClientRepositoryImpl();

    //Getters and Setters
    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, Account> accounts) {
        accounts = accounts;
    }

    //Construtor
    @Override
    public void AccountRepository() {}

    //Métodos da classe

    //Método para iniciar o banco de dados.
    @Override
    public void initDatas() {
        int number = 0;
        int id = 0;
        for (Client c : clients.getClients().values()) {
            Account newAccount = new Account();
            newAccount.setSaldo(0);
            newAccount.setTitular(c);
            newAccount.setId(id);
            newAccount.setNumero(ThreadLocalRandom.current().nextInt(10000,100000));
            newAccount.setSenha("0000");
            accounts.put(newAccount.getId(), newAccount);
            id++;
        }

    }


    //Método para criar uma conta
    @Override
    public void createAccount(Account account){
        accounts.put(account.getId(), account);
    }

    //Método para deletar uma conta
    @Override
    public void deleteAccount(Account conta){
        accounts.remove(conta.getId(),conta);
    }

    //Método para ver as credenciais da conta
    @Override
    public String myAccount(Account account){
        String formated = "" +
                "NAME: " + account.getTitular().getNome().toUpperCase() +
                "\nAGE: " + account.getTitular().getAge() +
                "\nCPF: " + account.getTitular().getCpf() +
                "\nACCOUNT NUMBER: " + account.getNumero()
                ;
        return formated;
    }

    //Método para ver o saldo da conta
    @Override
    public void getSaldo(Account c){
        JOptionPane.showMessageDialog(null,"SALDO TOTAL\n\nR$ " + c.getSaldo());
    }

    //Método para encontra uma conta pelo nome e cpf (Utilizado na operação de tranferência)
    @Override
    public Account findAccount(String nome, String password){
        Account findConta = new Account();
        for(Account conta : accounts.values()){
            if(conta.getSenha().equals(password) && conta.getTitular().getNome().equals(nome)){
                findConta = conta;
                break;
            }
        }
        if(findConta != null){
            return findConta;
        } else {
            JOptionPane.showMessageDialog(null, "ACCOUNT NOT FOUND");
            return null;
        }
    }

    //Método para atualizar uma conta
    @Override
    public void updateAccount(Account account, String newPassword){
        accounts.get(account.getId()).setSenha(newPassword);
    }

    //Método para sacar um valor
    @Override
    public void sacar(int idConta, double valor){
        Account conta = accounts.get(idConta);
        if(conta != null)
            conta.setSaldo(conta.getSaldo() - valor);
    }

    //Métoddo para depositar uma valor
    @Override
    public void depositar(int idConta, double valor){
        Account conta = accounts.get(idConta);
        if(conta != null){
            conta.setSaldo(conta.getSaldo() + valor);
        }
    }

    //Método para tranferir um valor
    @Override
    public void transferir(int idConta, int idContaTransfer, double valor){
        Account conta = accounts.get(idConta);
        Account destination = accounts.get(idContaTransfer);
        if(conta.getSaldo() < valor){
            JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE");
        }
        if(conta!= null && destination!= null){
            conta.setSaldo(conta.getSaldo() - valor);
            destination.setSaldo(destination.getSaldo() + valor);
        }
    }
}
