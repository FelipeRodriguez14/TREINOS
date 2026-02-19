package biblioteca.views;
import biblioteca.entity.User;
import biblioteca.views.menus.MainAdmin;
import biblioteca.views.menus.MainIniciar;
import biblioteca.views.menus.MainUser;

public class MenuServices{
    private static User user;
    public MenuServices(){}
    
    public MenuServices(User logado){
        user = logado;
    }

    //Direcionamento pra a tela do menu principal
    public void menuIniciar(){
        new MainIniciar(true);
    }

    //Direcionando para o menu do usuário
    public void menuUser(){
        new MainUser().initHome();
    }

    //Direcionando para o menu do admin
    public void menuAdmin(){
        new MainAdmin(user).initHome();
    }

}