package views;
import entity.User;
import views.menus.MainAdmin;
import views.menus.MainIniciar;
import views.menus.MainUser;

public class MenuServices{
    User user;
    public MenuServices(){}
    
    public MenuServices(User user){
        this.user = user;
    }

    public void menuIniciar(){
        new MainIniciar(true);
    }

    public void menuUser(){
        new MainUser().initHome();
    }

    public void menuAdmin(){
        new MainAdmin(this.user).initHome();
    }

}