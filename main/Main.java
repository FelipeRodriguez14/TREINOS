package main;
import entity.User;
import service.LibraryService;
import service.UserService;
import views.MenuServices;


public class Main {
    
    public static void main(String[] args){
        new UserService();
        new LibraryService();
        new MenuServices().menuAdmin(new User("felipe","123",true));
        

    }

}
