package biblioteca.views.auth;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import biblioteca.entity.User;
import biblioteca.exceptions.UserNotFoundException;
import biblioteca.views.MenuServices;
import biblioteca.views.menus.MainIniciar;
import java.util.List;
import biblioteca.service.UserService;

public class Login {
    private JPanel panel = new JPanel(new GridLayout(0,1));
    private JTextField campoUser = new JTextField();
    private JPasswordField campoSenha = new JPasswordField();

    public Login(boolean admin){
        init(admin);
    }

    public void init(boolean admin){
        panel.add(new JLabel("Usuário: "));
        panel.add(campoUser);
        panel.add(new JLabel("Senha: "));
        panel.add(campoSenha);

        int opcao = JOptionPane.showConfirmDialog(
            null, panel, "FAÇA LOGIN PARA ENTRAR",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );
        if(opcao == 0){
            String nome = campoUser.getText();
            String senha = new String(campoSenha.getPassword());
            autenticar(nome, senha,admin);
        } else{
            new MainIniciar(false).init();
        }
    }

    private void autenticar(String nome, String senha, boolean admin){
        List<User> usuarios = new UserService().getAllUsers();
        for(User usuario : usuarios){
            if(usuario.getNome().equalsIgnoreCase(nome) && usuario.getSenha().equals(senha)){
                if(usuario.getAdmin() != admin){
                    JOptionPane.showMessageDialog(null, "VOCÊ NÃO POSSUI CADASTRO PARA ESSE TIPO DE CONTA.");
                    new MainIniciar(false);
                } else{
                    direction(admin, new User(0,nome,senha,admin));
                }
            }
        }
        throw new UserNotFoundException("USUÁRIO NÃO CADASTRADO. SOLICITE QUE UM ADMINISTRADOR CADASTRE VOCÊ.");
    }

    private void direction(boolean admin, User user){
        if(admin){
            new MenuServices(user).menuAdmin();
        } else {
            new MenuServices().menuUser();
        }
    }
}
