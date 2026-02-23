package biblioteca.views;

import biblioteca.entity.User;
import biblioteca.views.menus.MainAdmin;
import biblioteca.views.menus.MainIniciar;
import biblioteca.views.menus.MainUser;

// Classe que gerencia os menus que serão utilizados.
public class MenuServices{
    private static User user;
    public MenuServices(){}
    
    public MenuServices(User logado){
        user = logado;
    }

    //Direcionamento para o menu principal
    public void menuIniciar(){
        new MainIniciar(true);
    }

    //Direcionamento para o menu do usuário
    public void menuUser(){
        new MainUser().initHome();
    }

    //Direcionamento para o menu do admin
    public void menuAdmin(){
        new MainAdmin(user).initHome();
    }

}