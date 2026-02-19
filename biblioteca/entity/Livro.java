package biblioteca.entity;
public class Livro{

    private String titulo;
    private String autor;
    private boolean disponivel;
    private double price;

    public Livro(String titulo, String autor, boolean disponivel, double price){
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.price = price;
    }

    public Livro(){}

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        this.titulo = autor;
    }

    public boolean getDisponivel(){
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    



}
