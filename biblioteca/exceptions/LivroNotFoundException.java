package biblioteca.exceptions;

public class LivroNotFoundException extends RuntimeException {

    public LivroNotFoundException(){
        super("LIVRO NÃO ENCONTRADO !");
    }

    public LivroNotFoundException(String msg){
        super(msg);
    }
        
    
}
