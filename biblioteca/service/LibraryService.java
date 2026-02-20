package biblioteca.service;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import biblioteca.entity.Livro;
import biblioteca.exceptions.LivroNotFoundException;
import biblioteca.views.menus.utilitys.IterationsMenu;
public class LibraryService {

    private static List<Livro> livros = new ArrayList<Livro>();

    //Construtor que inicia a biblioteca alimentada.
    public LibraryService(){}

    //Alimentar a biblioteca
    public void initStock(){
        livros.add(new Livro("O Código Fantasma", "Alan Turing", true, 45.90));
        livros.add(new Livro("Java: Do Zero ao Herói", "Bruno Souza", true, 89.90));
        livros.add(new Livro("Algoritmos da Felicidade", "Ada Lovelace", true, 35.00));
        livros.add(new Livro("O Mistério do Objeto Perdido", "Sherlock Holmes", true, 29.90));
        livros.add(new Livro("Herança Maldita", "Robert Martin", true, 110.00));
        livros.add(new Livro("Compilando Sonhos", "Grace Hopper", true, 52.50));
        livros.add(new Livro("A Lógica do Caos", "Edward Lorenz", true, 41.00));
        livros.add(new Livro("Interfaces do Destino", "Margaret Hamilton", true, 64.90));
        livros.add(new Livro("Recursividade Infinita", "Douglas Hofstadter", true, 78.00));
        livros.add(new Livro("O Último Byte", "Isaac Asimov", true, 39.90));
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

    //Retorna uma String com todos os livros encontrados
    public String getLivro(String titulo){
        List<Livro> livrosDisponiveis = new ArrayList<Livro>();
        for(Livro livro: livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                livrosDisponiveis.add(livro);
            }
        }

        if(livrosDisponiveis.isEmpty()){
            throw new LivroNotFoundException("NÃO HÁ LIVROS DISPONÍVEIS.");
        }
        return new ListToString().libraryToString(livrosDisponiveis);
    }

    //Retorna o objeto Livro que foi encontrado
    public Livro getLivroObject(String titulo){
        Livro livroEncontrado = new Livro();
        for(Livro livro: livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                livroEncontrado = livro;
            }
        }

        return livroEncontrado;
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
    
    //Cadastrar um novo livro
    public void createLivro(Livro livro){
        for(Livro lv : livros){
            if(lv.getTitulo().equalsIgnoreCase(livro.getTitulo())){
                JOptionPane.showMessageDialog(null, "LIVRO JÁ CADASTRADO. !","ERRO", 0);
                return;
            }
        }
        livros.add(livro);
        JOptionPane.showMessageDialog(null, "LIVRO CADASTRADO!", "SUCESSO", 1);
        System.out.println(livros.size());
    }

    //Remover um livro cadastrado do sistema
    public void deleteLivro(String titulo){
        for(int i = 0; i < livros.size();i++){
            if(livros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                livros.remove(i);
                JOptionPane.showMessageDialog(null, "LIVRO REMOVIDO !","SUCESSO", 1);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "LIVRO NÃO ENCONTRADO !", "ERRO", 0);

    }

    //Método para alterar os dados do livro
    public void alterLivro(String livro, String[]op){
        
        for(Livro lv : livros){
            if(lv.getTitulo().equalsIgnoreCase(livro)){
                lv = new IterationsMenu().newCredenciaisLivro(op, lv);
                JOptionPane.showMessageDialog(null, "LIVRO ALTERADO !", "SUCESSO", 1);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "LIVRO NÃO ENCONTRADO !", "ERRO", 0);
    }
}
