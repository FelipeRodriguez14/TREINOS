package biblioteca.service;

import java.util.List;
import biblioteca.entity.Livro;
import biblioteca.entity.User;

/*
    Essa classe foi criada para trsnformar as Listas de objetos em String personalizadas
    para caber dentro das telas da JOptionPane.

*/
public class ListToString {

    int cont = 0;

    //Método que tranforma uma lista de usuários em string.
    public String userToString (List<?> list){
        StringBuilder sb = new StringBuilder();
        sb.append("CADASTROS ENCONTRADOS\n\n");
        for(Object obj : list){
            if(obj instanceof User){
                User user = (User) obj;
                sb.append("[ " +(cont + 1)+" ] - ").append(user.getNome() + " - ").append("ADMIN: " + user.getAdmin() + "\n");
            }
            cont++;  
        }
        this.cont = 0;
        return sb.toString();
    }

    //Método que tranforma uma lista de livros em string.
    public String libraryToString (List<?> list){
        StringBuilder sb = new StringBuilder();
        sb.append("LIVROS DISPONÍVEIS\n\n");
        for(Object obj : list){
            if(obj instanceof Livro){
                Livro livro = (Livro) obj;
                sb.append("[ " +(cont + 1)+" ] - ").append(livro.getTitulo() + " - ").append("AUTOR: " + livro.getAutor()).append(
                    " - PREÇO: " + livro.getPrice()+"\n");
            }
            cont++;
        }
        this.cont = 0;
        return sb.toString();
    }

}
