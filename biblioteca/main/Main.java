package biblioteca.main;
import biblioteca.service.LibraryService;
import biblioteca.service.UserService;
import biblioteca.views.MenuServices;


/**
 * Essa é a classe principal que inicia o programa. Ela chama o userService e LibraryService primeiro para poder
 * inciar o "banco de dados vólatil" dos livros e usuários.
**/
public class Main {
    
    public static void main(String[] args){
        new UserService().initStock();
        new LibraryService().initStock();
        new MenuServices().menuIniciar();

    }

}
