package views.menus.utilitys;

import javax.swing.JOptionPane;

import service.LibraryService;
import views.menus.MainAdmin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entity.User;

import java.awt.GridLayout;

public class IterationsMenu {
    LibraryService lib = new LibraryService();
    JTextField nomeField = new JTextField();
    JPasswordField senhaFiled = new JPasswordField();

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

    User novo = new User();
    
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
                        novo.setNome(nomeField.getText());
                    break;

                    case 1:
                        novo.setNome(null);
                    break;

                    default:
                        new MainAdmin().initHome();
                    break;
                }
            break;

            case "senha":
                switch (choose) {
                    case 0:
                        novo.setSenha(new String (senhaFiled.getPassword()));
                    break;

                    case 1:
                        novo.setSenha(null);
                    break;

                    default:
                        new MainAdmin().initHome();
                    break;
                }
            break;
        }
        
        return novo;
    }

    public User newCredenciais(String[]op, String msg, String credencial){
        novo = new User();
        JPanel painel = new JPanel(new GridLayout(0,1));
        
        switch (credencial) {
            case "nome":
                painel.add(new JLabel(msg));
                painel.add(nomeField);
                chooseJPanel(op, painel, credencial);
            break;

            case "senha":
                painel.add(new JLabel(msg));
                painel.add(senhaFiled);
                chooseJPanel(op, painel, credencial);
            break;
        } 
        return novo;
    }

}
