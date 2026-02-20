package biblioteca.views.menus;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import biblioteca.entity.User;
import biblioteca.service.LibraryService;
import biblioteca.service.UserService;
import biblioteca.views.menus.utilitys.IterationsMenu;
import biblioteca.entity.Livro;

public class MainAdmin {
    private User admin = new User();
    private IterationsMenu menuIterativo = new IterationsMenu();
    private LibraryService lib = new LibraryService();
    private UserService users = new UserService();
    private List<String> msg = new ArrayList<String>();
    private String[] op;
    private int action;

    public MainAdmin(){}

    public MainAdmin(User user){
        this.admin = user;
    }

    //Menu principal
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
    
    //Menu para tratar os usuários do sistema
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
                String nome = JOptionPane.showInputDialog("NOME: ");

                break;
            case 2:
                nome = JOptionPane.showInputDialog("NOME: ");
                String senha = JOptionPane.showInputDialog( "SENHA: ");
                users.createUserComum(nome, senha);
                initHome();
                break;
            case 3:
                initHome();
                break;
            default:
                break;
        }
    }

    //Menu para tratar os outros admins do sistema
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
    
    //Menu para tratar os livros do sistema
    private void livros(){
        msg.add("ALTERAR LIVRO");
        msg.add("EXCLUIR LIVRO");
        msg.add("ADICIONAR LIVRO");
        msg.add("VOLTAR");
        op = msg.toArray(new String[0]);
        msg.clear();

        action = menuIterativo.choose(op, lib.getAllLivros());
        String titulo;
        String autor = "";
        float price;

        switch (action) {
            case 0:
                msg.add("OK");
                msg.add("MANTER ATUAL");
                msg.add("CANCELAR");
                op = msg.toArray(new String[0]);
                msg.clear();
                
                String nomeLivro = JOptionPane.showInputDialog
                ("QUAL O NOME DO LIVRO QUE DESEJA ALTERAR ?");

                lib.alterLivro(nomeLivro, op);
                initHome();
                break;
            case 1:
                titulo =  JOptionPane.showInputDialog("QUAL O TÍTULO DO LIVRO ?");
                lib.deleteLivro(titulo);
                initHome();
                break;
            case 2:
                titulo =  JOptionPane.showInputDialog("QUAL O TÍTULO DO LIVRO ?");
                autor = JOptionPane.showInputDialog("QUAL O AUTOR DO LIVRO ?");
                price = Math.round(Float.parseFloat(JOptionPane.showInputDialog("QUAL O PREÇO DO LIVRO ?")));
                
                lib.createLivro(new Livro(titulo,autor,true,price));
                initHome();
                break;
            case 3:
                initHome();
                break;
            default:
                break;
        }
    }
    
    //Menu para alterar o próprio cadastro
    private void alterCadastro(){
        msg.add("OK");
        msg.add("MANTER O ATUAL.");
        msg.add("CANCELAR");
        op = msg.toArray(new String[0]);
        msg.clear();
        User newUser = new IterationsMenu().newCredenciaisAdmin(op);
        users.setMyUser
        (
            admin, 
            newUser.getNome(),
            newUser.getSenha(),
            admin.getAdmin()
        );
    }

    //Método para retornar ao menu de início
    private void goBack(){
        new MainIniciar(false);
    }


}
