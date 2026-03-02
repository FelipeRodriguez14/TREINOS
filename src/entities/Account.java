package entities;

public class Account {
    private int id;
    private int numero;
    private Client titular;
    private String senha;
    private double saldo;

    public Account(int id, Client titular, String senha, double saldo,int numero) {
        this.id = id;
        this.numero = numero;
        this.titular = titular;
        this.senha = senha;
        this.saldo = saldo;
    };

    public Account() {};

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Client getTitular() {
        return titular;
    }

    public void setTitular(Client titular) {
        this.titular = titular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void set() {

    }
}
