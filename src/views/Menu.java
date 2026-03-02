package views;
import utilities.Painel;
import javax.swing.*;

public class Menu {
    private Painel painel = new Painel();
    private String action = "";


    public Menu(){};

    //Método que apresenta o Menu inicial
    public void main(){
       this.action = this.painel.show(
                new String[]{"LOGIN ACCOUNT",
                        "CREATE CLIENT", "EXIT"},
                "SEJA BEM - VINDO",
                "INÍCIO");
       direction();
    }

    /*
    * Método que define qual será o próximo menu a ser apresentado, de acordo
    * com a variável action, que é alterada no método inicial.
    */
    public void direction(){
        if(action.equals("LOGIN ACCOUNT"))
            new Login();
        if(action.equals("CREATE CLIENT"))
            new Register();
        if(action.equals("EXIT"))
            JOptionPane.showMessageDialog(null,"PROGRAM CLOSED");
            System.exit(0);
    }
}
