
import model.Comando;
import model.ComandoAtribuicao;


/**
 *
 * @author Aluno
 */
public class Aplicacao {

    public static void main(String[] args) {
        String variavel = "n(";
        String valor = "1";
        Comando c = new ComandoAtribuicao(variavel, valor);
        if(!c.verificarSintaxe()){
            System.out.println("false");
        }
        else{
        c.executar();
        int i =(int) c.getVariavelMemoria(variavel)+1;
        //System.out.println(c.getVariavelMemoria(variavel));
        System.out.println(i);
        }
    }

}
