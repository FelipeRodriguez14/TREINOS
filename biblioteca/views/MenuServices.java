package biblioteca.views;
import biblioteca.entity.User;
import biblioteca.views.menus.MainAdmin;
import biblioteca.views.menus.MainIniciar;
import biblioteca.views.menus.MainUser;

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