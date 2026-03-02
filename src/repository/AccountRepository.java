package repository;

import entities.Account;
import entities.Client;

import java.util.Map;

public interface AccountRepository {
    //Construtor
    public void AccountRepository();

    //CRUD
    void createAccount(Account account);
    String myAccount(Account account);
    void updateAccount(Account account, String newPassword);
    void deleteAccount(Account account);

    //Método para iniciar um banco de dados volátil
    void initDatas();

    //Métodos essenciais que uma conta deve ter
    Account findAccount(String nome, String cpf);
    void sacar(int idConta,double valor);
    void depositar(int idConta, double valor);
    void transferir(int idConta, int idContaTransfer, double valor);
    void getSaldo(Account conta);
}
