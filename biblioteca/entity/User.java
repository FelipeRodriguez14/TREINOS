package biblioteca.entity;
public class User {
    
    private String nome;
    private String senha;
    private boolean admin;
    private int id;

    public User(){}

    public User(int id, String nome, String senha, boolean admin){
        this.nome = nome;
        this.senha = senha;
        this.admin = admin;
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }

    
    public void setAdmin(boolean admin){
        this.admin = admin;
    }

    public boolean getAdmin(){
        return this.admin;
    }

    public int getId(){
        return this.id; 
    }

    public void setId(int i){
        this.id = i;
    }

}
