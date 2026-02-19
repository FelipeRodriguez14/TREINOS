package biblioteca.views.menus.utilitys;

import javax.swing.JOptionPane;
import biblioteca.service.LibraryService;
import biblioteca.views.menus.MainAdmin;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import biblioteca.entity.Livro;
import biblioteca.entity.User;
import java.awt.GridLayout;

public class IterationsMenu {
    private LibraryService lib = new LibraryService();
    private JTextField nomeField = new JTextField();
    private JPasswordField senhaFiled = new JPasswordField();
    private User novoAdmin = new User();
    private Livro livro = new Livro();

    public IterationsMenu(){} 
    
    //Menu de escolhas iterativo
    public int choose(String[]op, String msg){
        int choose = JOptionPane.showOptionDialog(
            null,
            msg,
            "BIBLIOTECA", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            op,
            op[0]);
        return choose;
    }

    
    
    //Menu exclusivo para alterar as credenciais do admin.
    public User chooseJPanel(String[] op, JPanel msg, String credencial){
        int choose = JOptionPane.showOptionDialog(
            null,
            msg,
            "ALTERAR CREDENCIAIS", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            op,
            op[0]);
            switch (credencial) {
            case "nome":
                switch (choose) {
                    case 0:
                        novoAdmin.setNome(nomeField.getText());
                    break;

                    case 1:
                        novoAdmin.setNome(null);
                    break;

                    default:
                        new MainAdmin().initHome();
                    break;
                }
            break;
            case "senha":
                switch (choose) {
                    case 0:
                        novoAdmin.setSenha(new String (senhaFiled.getPassword()));
                    break;

                    case 1:
                        novoAdmin.setSenha(null);
                    break;

                    default:
                        new MainAdmin().initHome();
                    break;
                }
            break;
        }
        
        return novoAdmin;
    }

    public User newCredenciaisAdmin(String[] op){
        JPanel painel = new JPanel(new GridLayout(0,1));

            painel.add(new JLabel("INSIRA O NOVO NOME:"));
            painel.add(nomeField);
            novoAdmin.setNome(chooseJPanel(op, painel, "nome").getNome());
            painel.removeAll();

            painel.add(new JLabel("INSIRA A NOVA SENHA:"));
            painel.add(senhaFiled);
            chooseJPanel(op, painel, "senha");
            painel.removeAll();

        return novoAdmin;
    }

    //Personalizando o menu e coletando os dados para atualizar o livro.
    public Livro newCredenciaisLivro(String[] op){
        JPanel painel = new JPanel(new GridLayout(0,1));

        painel.add(new JLabel("INSIRA O NOVO TITULO:"));
        painel.add(nomeField);
        livro.setTitulo(chooseJPanelLivro(op, painel, "titulo").getTitulo());
        painel.removeAll();
        nomeField.setText("");

        painel.add(new JLabel("INSIRA O NOVO AUTOR:"));
        painel.add(nomeField);
        livro.setAutor(chooseJPanelLivro(op, painel, "autor").getAutor());
        painel.removeAll();
        nomeField.setText("");

        painel.add(new JLabel("INSIRA O NOVO PREÇO:"));
        painel.add(nomeField);
        livro.setPrice(chooseJPanelLivro(op, painel, "preco").getPrice());
        painel.removeAll();
        nomeField.setText("");

        return livro;
        
    }

    //Painel de escolhas referente as credenciais do livro.
    public Livro chooseJPanelLivro(String[] op, JPanel msg, String credencial){
        int choose = JOptionPane.showOptionDialog(
            null,
            msg,
            "ALTERAR CREDENCIAIS", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            op,
            op[0]);

            switch (credencial) {
            case "titulo":
                switch (choose) {
                    case 0:
                        livro.setTitulo(nomeField.getText());
                    break;

                    case 1:
                        livro.setTitulo(null);
                    break;

                    default:
                        new MainAdmin().initHome();
                    break;
                }
            break;
            case "autor":
                switch (choose) {
                    case 0:
                        livro.setAutor(nomeField.getText());
                    break;

                    case 1:
                        livro.setAutor(null);
                    break;

                    default:
                        new MainAdmin().initHome();
                    break;
                }
            break;
            case "preco":
                switch (choose) {
                    case 0:
                        livro.setPrice(Float.parseFloat(nomeField.getText()));
                    break;

                    case 1:
                        
                    break;

                    default:
                        new MainAdmin().initHome();
                    break;
                }
            break;
        }
        System.out.println(livro.getTitulo());
        System.out.println(livro.getAutor());
        return livro;
    }

}
