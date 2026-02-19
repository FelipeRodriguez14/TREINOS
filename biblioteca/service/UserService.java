package biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import biblioteca.entity.User;
import biblioteca.exceptions.UserNotFoundException;
import biblioteca.views.menus.MainIniciar;

public class UserService {
    
    private static List<User> usuarios = new ArrayList<User>();

    public UserService(){}

    public void initStock(){
        usuarios.add(new User(1,"felipe","123", true));
        usuarios.add(new User(2,"bia","123", false));
        usuarios.add(new User(3,"ana","123", false));
    }

    //Listar todos os usuários.
    public List<User> getAllUsers(){
        return usuarios;
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

    //Buscar usuário por id.
    public String getUserId(int id){
        List<User> users = new ArrayList<User>();
        for(User user : usuarios){
            if(user.getId() == id){
                users.add(user);
            }
        }
        if(users.isEmpty()){
            throw new UserNotFoundException("USUÁRIO NÃO ENCONTRADO");
        }
        return new ListToString().userToString(users);
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

    //Função que permite o administrador alterar o próprio usuário
    public void setMyUser(User user, String nome, String senha, boolean admin){
        for(User usuario : usuarios ){
            if(
                usuario.getNome().equalsIgnoreCase(user.getNome()) &&
                usuario.getSenha().equals(user.getSenha()) &&
                usuario.getAdmin() == user.getAdmin()
            ){
                usuario.setNome(nome);
                usuario.setSenha(senha);
                usuario.setAdmin(admin);

                JOptionPane.showMessageDialog(
                    null,
                    "CREDENCIAIS ALTERADAS. O SISTEMA IRÁ PARA A TELA DE LOGIN.\n\n" +
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
