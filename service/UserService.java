package service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.User;
import exceptions.UserNotFoundException;
import views.menus.MainIniciar;

public class UserService {
    
    private List<User> usuarios = new ArrayList<User>();

    public UserService(){
        initStock();
    }

    public void initStock(){
        this.usuarios.add(new User("felipe","123", true));
        this.usuarios.add(new User("bia","123", false));
        this.usuarios.add(new User("ana","123", false));
    }

    //Listar todos os usuários.
    public List<User> getAllUsers(){
        return this.usuarios;
    }

    //Buscar usuário por nome.
    public User getUser(String nome){
        for(User user : usuarios){
            if(user.getNome().equalsIgnoreCase(nome)){
                return user;
            }
        }
        throw new UserNotFoundException("USUÁRIO NÃO ENCONTRADO");

    }

    //Listar usuários por tipo de acesso.
    public String getUserType(boolean admin){
        List<User> users = new ArrayList<User>();
        for(User user : usuarios){
            if(user.getAdmin() == admin){
                users.add(user);
            }
        }
        if(users.isEmpty()){
            throw new UserNotFoundException("USUÁRIO NÃO ENCONTRADO");
        }
        return new ListToString().userToString(users);
    }

    //Alterar usuario
    public void setMyUser(User user, String nome, String senha, boolean admin){
        for(User usuario : usuarios ){
            if(
                usuario.getNome().equalsIgnoreCase(user.getNome()) &&
                usuario.getSenha().equals(user.getSenha()) &&
                usuario.getAdmin() == user.getAdmin()
            ){
                user.setNome(nome);
                user.setSenha(senha);
                user.setAdmin(admin);

                JOptionPane.showMessageDialog(
                    null,
                    "CREDENCIAIS ALTERADAS. O SISTEMA PARA A TELA DE LOGIN.\n\n" +
                    "FAÇA LOGIN COM AS NOVAS CREDENCIAIS."
                    ,
                    senha,
                    0
                    );
                new MainIniciar(false);
                break;
            }
        }
        
        
    }


}
