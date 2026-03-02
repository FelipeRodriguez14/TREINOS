package utilities;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Painel {
    List<String> opcoes = new ArrayList<String>();
    JPanel painel = new JPanel (new GridLayout(0,1));
    List<JTextField> campos = new ArrayList<JTextField>();
    List<JLabel> labels = new ArrayList<JLabel>();

    public Painel(){}

    // Método que defini quantas labels e quantos campos o painel de opções terá.
    public void definedCampos(String[] opcoes){
        /*
        * Para cada opção de String que chegar por parâmetro, eu adiciono a List de labels
        * e campos, para depois criar o painel.
        * */
        for(String op : opcoes){
            if(op != null)
                this.labels.add(new JLabel(op));
                this.campos.add(new JTextField());
                this.opcoes.add(op);
        }

    }

    // Método de criação de um painel com opções e campos de inserção de texto definidos.
    // Insere os componentes labels e campos dentro do painel.
    public void createOptions(){
        /*
        * labels e campos tem o mesmo tamanho, pois isso é definido no método definedCampos.
        * Dessa forma, para cada campo existente, eu adiciona a label e o campo no painel.
        * */

        for(int i = 0; i < this.labels.size();i++){
            this.painel.add(labels.get(i));
            this.painel.add(campos.get(i));
        }
    }

    // Método que defini um painel de opções sem campos de inserção de texto.
    // Somente apresenta uma mensagem e retorna a opção do usuário.
    public String show(String[] op, String msg, String title){
        String selecao = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma opção:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                op,
                op[0]);
        return selecao;
    }

    /*
     Método que apresenta o painel de opçoes com campos de inserção.
     A diferença desse método para o show, é que esse você deve chamar em conjunto
     com os outros métodos (definedCampos() e createOption()), pois eles vão
     construir o painel para ser apresentado nesse método. Poderia ter criado somente um método,
     e criar uma verificação, mas optei por fazer dessa forma, fica mais organizado.

     */
    public int showPainelOptions(String title, String[] op) {
        int i = JOptionPane.showOptionDialog(
                null,
                painel,
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                op,
                op[0]);
        return i;
    }

    //Método que retorna o que o usuário digitou dentro dos campos definidos.
    //Ele limpa o painel depois de coletar os dados.
    public String[] getCampos(){
        List<String> camposValues = new ArrayList<String>();
        for(JTextField c : campos){
            camposValues.add(c.getText());
        }
        painel.removeAll();
        return camposValues.toArray(new String[0]);
    }

}
