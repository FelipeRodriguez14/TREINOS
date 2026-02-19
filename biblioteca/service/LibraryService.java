package biblioteca.service;
import java.util.ArrayList;
import java.util.List;
import biblioteca.entity.Livro;
import biblioteca.exceptions.LivroNotFoundException;
public class LibraryService {

    private List<Livro> livros = new ArrayList<Livro>();

    //Construtor que inicia a biblioteca alimentada.
    public LibraryService(){
        initStock();
    }

    //Alimentar a biblioteca
    public void initStock(){
        this.livros.add(new Livro("O Código Fantasma", "Alan Turing", true, 45.90));
        this.livros.add(new Livro("Java: Do Zero ao Herói", "Bruno Souza", true, 89.90));
        this.livros.add(new Livro("Algoritmos da Felicidade", "Ada Lovelace", true, 35.00));
        this.livros.add(new Livro("O Mistério do Objeto Perdido", "Sherlock Holmes", true, 29.90));
        this.livros.add(new Livro("Herança Maldita", "Robert Martin", true, 110.00));
        this.livros.add(new Livro("Compilando Sonhos", "Grace Hopper", true, 52.50));
        this.livros.add(new Livro("A Lógica do Caos", "Edward Lorenz", true, 41.00));
        this.livros.add(new Livro("Interfaces do Destino", "Margaret Hamilton", true, 64.90));
        this.livros.add(new Livro("Recursividade Infinita", "Douglas Hofstadter", true, 78.00));
        this.livros.add(new Livro("O Último Byte", "Isaac Asimov", true, 39.90));
    }

    //Listar todos os livros disponíveis.
    public String getAllLivros(){
        List<Livro> livrosDisponiveis = new ArrayList<Livro>();
        for(Livro livro : livros){
            if(livro.getDisponivel()){
                livrosDisponiveis.add(livro);
            }
        }

        if(livrosDisponiveis.isEmpty()){
            throw new LivroNotFoundException("NÃO HÁ LIVROS DISPONÍVEIS.");
        }
        return new ListToString().libraryToString(livrosDisponiveis);
    }

    //Buscar livros pelo nome.
    public String getLivro(String nome){
        List<Livro> livrosDisponiveis = new ArrayList<Livro>();
        for(Livro livro: livros){
            if(livro.getTitulo().equalsIgnoreCase(nome)){
                livrosDisponiveis.add(livro);
            }
        }

        if(livrosDisponiveis.isEmpty()){
            throw new LivroNotFoundException("NÃO HÁ LIVROS DISPONÍVEIS.");
        }
        return new ListToString().libraryToString(livrosDisponiveis);
    }

    //Buscar livros pelo autor.
    public String getLivroAutor(String autor){
        List<Livro> livrosAutor = new ArrayList<Livro>();
        for(Livro livro : livros){
            if(livro.getAutor().equalsIgnoreCase(autor)){
                livrosAutor.add(livro);
            }
        }
        if(livrosAutor.isEmpty()){
            throw new LivroNotFoundException("NÃO HÁ LIVROS COM ESSE AUTOR");
        }
        return new ListToString().libraryToString(livrosAutor);
        
    }

    //Buscar livros pelo preço
    public String getLivrosPrice(double price){
        List<Livro> livrosDisponiveis = new ArrayList<Livro>();
        for(Livro livro : livros){
            if(livro.getPrice() == price){
                livrosDisponiveis.add(livro);
            }
        }
        if(livrosDisponiveis.isEmpty()){
            throw new LivroNotFoundException("NÃO HÁ LIVROS COM ESSE VALOR.");
        }
        return new ListToString().libraryToString(livrosDisponiveis);
    } 




}
