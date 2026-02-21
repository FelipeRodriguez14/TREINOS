package biblioteca.views.menus;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import biblioteca.service.LibraryService;
import biblioteca.views.menus.utilitys.IterationsMenu;

public class MainUser {

    public MainUser(){}
    private IterationsMenu menuIterativo = new IterationsMenu();
    private LibraryService lib = new LibraryService();
    private List<String> msg = new ArrayList<String>();
    private String[] op;
    private int action;

    
    //Menu principal
    public void initHome(){
        msg.add("BUSCAR PELO AUTOR.");
        msg.add("BUSCAR PELO NOME.");
        msg.add("BUSCAR PELO PREÇO.");
        msg.add("VER TODOS OS LIVROS");
        msg.add("SAIR");
        op = msg.toArray(new String[0]);
        msg.clear();
        this.action = menuIterativo.choose
        (op,"OLÁ. SEJA MUITO BEM VINDO(A) A NOSSA BIBLIOTECA.\n\n" +
            "SELECIONE COMO DESEJA ENCONTRAR O SEU LIVRO.\n\n"
        );

        switch (action) {
            case 0:
                findAutor();
                break;
            case 1:
                findNome();
                break;
            case 2:
                findPrice();
                break;
            case 3:
                verAll();
                initHome();
                break;
            case 4:
                goBack();
            break;
            default:
                break;
        }
    }

    //Menu para buscar o livro pelo autor
    private void findAutor(){
        String autor = JOptionPane.showInputDialog("ESCREVA O NOME DO AUTOR: ");
        msg.add("VOLTAR");
        op = msg.toArray(new String[0]);
        msg.clear();
        action = menuIterativo.choose(op, lib.getLivroAutor(autor));
        if(action == 0) 
            initHome();
    }

    //Menu para ver todos os ivros
    private void verAll (){
        JOptionPane.showMessageDialog(null,  lib.getAllLivros(), "LIVROS", 1);
        //JOptionPane.showOptionDialog(null, painel, "TODOS OS LIVROS", 0, 0, null, op, lib);
    }

    //Menu para buscar o livro pelo nome
    private void findNome(){
        String nome = JOptionPane.showInputDialog("ESCREVA O NOME DO LIVRO: ");
        msg.add("VOLTAR");
        op = msg.toArray(new String[0]);
        msg.clear();
        action = menuIterativo.choose(op, lib.getLivro(nome));
        if(action == 0) 
            initHome();
    }
    
    //Menu para buscar o livro pelo preço
    private void findPrice(){
        Float price = Float.parseFloat(JOptionPane.showInputDialog(
            "DIGITE O PREÇO DO LIVRO\n\n " + 
            "UTILIZE ' . ' PARA CASAS DECIMAIS."
        )); 
        msg.add("VOLTAR");
        op = msg.toArray(new String[0]);
        msg.clear();
        action = menuIterativo.choose(op, lib.getLivrosPrice(price));
        if(action == 0) 
            initHome();
    }
    
    //Método para voltar para a tela de início.
    private void goBack(){
        new MainIniciar(false);
    }

}
