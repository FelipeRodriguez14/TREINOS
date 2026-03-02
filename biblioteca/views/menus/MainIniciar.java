package biblioteca.views.menus;

import javax.swing.JOptionPane;

import biblioteca.views.auth.Login;

//Classe que gerencia os menus
public class MainIniciar {

    //Esse parâmetro do coonstrutor é somente para dizer se a mensagem de boas - vindas deve ser disparada.
    public MainIniciar(boolean welcome){
        if(welcome){
            welcome();
            init();
        }else{
            init();
        }
        
    };

    //Mensagem de boas vindas
    private void welcome(){
        JOptionPane.showMessageDialog(null, "BEM VINDO(A) A BIBLIOTECA", "WELCOME", 1);
    }
    
    //Método que apresenta o menu com as opções de login.
    public void init(){
        int typeMenu = 0;

        String[] op = {" MENU USUARIO ", "MENU ADMINISTRADOR", "SAIR"};
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
                    System.exit(0);
                    break;
                }
            }while(typeMenu < 0 || typeMenu > 2);
        }

}
