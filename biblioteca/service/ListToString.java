package biblioteca.service;

import java.util.List;
import biblioteca.entity.Livro;
import biblioteca.entity.User;

public class ListToString {

    int cont = 0;

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
