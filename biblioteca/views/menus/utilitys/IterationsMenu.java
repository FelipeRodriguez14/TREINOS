package biblioteca.views.menus.utilitys;

import javax.swing.JOptionPane;
import biblioteca.views.menus.MainAdmin;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import biblioteca.entity.Livro;
import biblioteca.entity.User;
import java.awt.GridLayout;

/*
    Essa classe acredito que seja a mais complexa dentre todas as outras.
    Além de ter um método somente para gerar um menu de escolhas definidas, 
    ela foi criada para disparar menus personalizados para que o administrador altere seus próprios dados
    cadastrais OU que ele alterar os dados cadastrais de um livro já existente na lista.
*/
public class IterationsMenu {
    private JTextField nomeField = new JTextField();
    private JPasswordField senhaFiled = new JPasswordField();
    private User novoAdmin = new User();

    public IterationsMenu(){} 
    
    //Menu de escolhas iterativo. Recebe a string de opções como parâmetro e gera o menu.
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

    //Método que receber os dados para atualizar as credenciais do administrador.
    public User newCredenciaisAdmin(String[] op, boolean admin){
        JPanel painel = new JPanel(new GridLayout(0,1));
            novoAdmin.setAdmin(admin);
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

    /*
        Nesse método fica lógica para alterar as credenciais do administrador. Ficou um pouco 
        confuso porque utilizei switch case, e deixou o código muito grande. Além disso, a lógica
        construída para alterar as credenciais do administrador é diferente da lógica de alterar as 
        credenciais do livro, sendo que ambas poderiam ser a mesma. Porém, somente no meio de desenvolvimento
        em diante eu consegui pensar diferente kkkkk e como funcionava, eu preferi deixar diferente entre si. Mas
        o importante é entender que para altera as credenciais, cada um (administrador e livro) tem dois métodos:
        um para coletar as informações e outro com a lógica para realizar a alteração.

    */
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

    

    //Coletandos dados para atualizar o livro.
    public Livro newCredenciaisLivro(String[] op, Livro livro){

        String titulo = chooseJPanelLivro(op,"NOVO TITULO:");
        if (titulo != null && !titulo.isBlank()){
            livro.setTitulo(titulo); 
        }
            

    
        String autor = chooseJPanelLivro(op, "NOVO AUTOR:");
        if (autor != null && !autor.isBlank()){
            livro.setAutor(autor);
        }
            

       
        String precoStr = chooseJPanelLivro(op, "NOVO PREÇO:");
        if (precoStr != null && !precoStr.isEmpty()) {
            try {
                livro.setPrice(Double.parseDouble(precoStr));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "VALORES INCORRETOS !");
            }
        }
        return livro;
        
    }

    //Painel de escolhas referente as credenciais do livro.
    public String chooseJPanelLivro(String[] op, String msg){

        JPanel painel = new JPanel(new GridLayout(0,1));
        JTextField campo = new JTextField();

        painel.add(new JLabel(msg));
        painel.add(campo);

        int choose = JOptionPane.showOptionDialog(
            null,
            painel,
            "ALTERAR CREDENCIAIS", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            op,
            op[0]);

            if(choose == 0){
                return campo.getText();
            } else if(choose == 1 )
                return "";

            return null;
    }

}
