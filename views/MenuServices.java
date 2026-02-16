package views;
import entity.User;
import views.menus.MainAdmin;
import views.menus.MainIniciar;
import views.menus.MainUser;

public class MenuServices{

    public MenuServices(){

    }

    public void menuIniciar(){
        new MainIniciar(true);
    }

    public void menuUser(){
        new MainUser().initHome();
    }

    public void menuAdmin(User user){
        new MainAdmin(user).initHome();
    }

}