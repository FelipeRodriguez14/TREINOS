package biblioteca.main;
import biblioteca.service.LibraryService;
import biblioteca.service.UserService;
import biblioteca.views.MenuServices;

public class Main {
    
    public static void main(String[] args){
        new UserService().initStock();
        new LibraryService().initStock();
        new MenuServices().menuIniciar();

    }

}
