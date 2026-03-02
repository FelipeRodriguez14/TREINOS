package entities;

public class Client {

    private int id;
    private int age;
    private String nome;
    private String cpf;

    public Client(int id, int age, String nome, String cpf){
        this.id = id;
        this.age = age;
        this.nome = nome;
        this.cpf = cpf;
    }

    //Somente para teste
    public Client( int age, String nome, String cpf){
        this.age = age;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Client(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



}
