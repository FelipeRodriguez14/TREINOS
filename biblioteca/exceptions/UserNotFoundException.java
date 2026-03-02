package biblioteca.exceptions;

import javax.swing.JOptionPane;


/**
 * Exceção que dispara se o livro não foi encontrado. Usei poucas vezes, apenas crier para relembrar os conceitos. 
**/
public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(){}
    
    public UserNotFoundException(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
}
