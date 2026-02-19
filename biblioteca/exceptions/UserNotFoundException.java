package biblioteca.exceptions;

import javax.swing.JOptionPane;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(){}
    
    public UserNotFoundException(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
}
