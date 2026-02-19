package views.menus;

import javax.swing.JOptionPane;

import views.auth.Login;

public class MainIniciar {

    public MainIniciar(boolean welcome){
        if(welcome){
            welcome();
            init();
        }else{
            init();
        }
        
    };

    private void welcome(){
        JOptionPane.showMessageDialog(null, "BEM VINDO(A) A BIBLIOTECA", "WELCOME", 1);
    }
    
    public void init(){
        int typeMenu = 0;

        String[] op = {" MENU USUARIO ", "MENU ADMINITRADOR", "SAIR"};
        typeMenu = JOptionPane.showOptionDialog(
            null,
            "ESCOLHA O MENU QUE DESEJA LOGAR",
            "ESCOLHER", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            op,
            op[0]);

        do{  
            switch (typeMenu) {
                case 0:
                    new Login(false);
                    break;
            
                case 1:
                    new Login(true);
                    break;
            
                case 2:
                    JOptionPane.showMessageDialog(null, "OPERAÇÃO CANCELADA. VOLTE SEMPRE !", null, 1);
                    System.exit(0);
                    break;
                }
            }while(typeMenu < 0 || typeMenu > 2);
        }

}
