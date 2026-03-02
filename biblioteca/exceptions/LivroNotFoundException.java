package biblioteca.exceptions;


/**
 * Exceção que dispara se o livro não foi encontrado. Usei poucas vezes, apenas crier para relembrar os conceitos. 
**/

public class LivroNotFoundException extends RuntimeException {

    public LivroNotFoundException(){
        super("LIVRO NÃO ENCONTRADO !");
    }

    public LivroNotFoundException(String msg){
        super(msg);
    }
        
    
}
