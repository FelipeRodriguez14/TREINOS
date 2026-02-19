package biblioteca.views.menus;

import java.util.ArrayList;
import java.util.List;
import biblioteca.entity.User;
import biblioteca.service.LibraryService;
import biblioteca.service.UserService;
import biblioteca.views.menus.utilitys.IterationsMenu;

public class MainAdmin {
    private User admin = new User();

    public MainAdmin(User user){
        this.admin = user;
    }
    public MainAdmin(){}

    private IterationsMenu menuIterativo = new IterationsMenu();
    private LibraryService lib = new LibraryService();
    private UserService users = new UserService();
    private List<String> msg = new ArrayList<String>();
    private String[] op;
    private int action;

    public void initHome(){
        msg.add("USUÁRIOS COMUNS.");
        msg.add("ADMINISTRADORES");
        msg.add("LIVROS.");
        msg.add("ALTERAR MEU CADASTRO.");
        msg.add("SAIR");
        op = msg.toArray(new String[0]);
        msg.clear();
        this.action = menuIterativo.choose
        (op,"BEM VINDO ADMIN\n\nO QUE DESEJA FAZER ?");

        switch (action) {
            case 0:
                usuarios();
                break;
            case 1:
                admins();
                break;
            case 2:
                livros();
                break;
            case 3:
                alterCadastro();
                break;
            default:
                goBack();
                break;
        }
    }

    private void usuarios(){
        msg.add("ALTERAR USUÁRIO");
        msg.add("EXCLUIR USUÁRIO");
        msg.add("ADICIONAR USUÁRIO");
        msg.add("VOLTAR");
        op = msg.toArray(new String[0]);
        msg.clear();

        action = menuIterativo.choose(op, users.getUserType(false));

        switch (action) {
            case 0:
                
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                initHome();
                break;
            default:
                break;
        }
    }

    private void admins(){
        msg.add("ALTERAR ADMINISTRADOR");
        msg.add("EXCLUIR ADMINISTRADOR");
        msg.add("ADICIONAR ADMINISTRADOR");
        msg.add("VOLTAR");
        op = msg.toArray(new String[0]);
        msg.clear();

        action = menuIterativo.choose(op, users.getUserType(true));

        switch (action) {
            case 0:
                
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                initHome();
                break;
            default:
                break;
        }
    }
        
    private void livros(){
        msg.add("ALTERAR LIVRO");
        msg.add("EXCLUIR LIVRO");
        msg.add("ADICIONAR LIVRO");
        msg.add("VOLTAR");
        op = msg.toArray(new String[0]);
        msg.clear();

        action = menuIterativo.choose(op, lib.getAllLivros());

        switch (action) {
            case 0:
                
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                initHome();
                break;
            default:
                break;
        }
    }
        
    private void alterCadastro(){
        msg.add("OK");
        msg.add("MANTER O ATUAL.");
        msg.add("CANCELAR");
        op = msg.toArray(new String[0]);
        msg.clear();
        User newUser = new IterationsMenu().newCredenciais(op);
        users.setMyUser
        (
            admin, 
            newUser.getNome(),
            newUser.getSenha(),
            admin.getAdmin()
        );
    }

    private void goBack(){
        new MainIniciar(false);
    }


}
