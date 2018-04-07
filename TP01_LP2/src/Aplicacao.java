
import model.Comando;
import model.ComandoAtribuicao;


/**
 *
 * @author Aluno
 */
public class Aplicacao {

    public static void main(String[] args) {
        String variavel = "nome";
        String valor = "1";
        Comando c = new ComandoAtribuicao(variavel, valor);
        c.executar();
        int i =(int) c.getVariavelMemoria(variavel)+1;
//        System.out.println(c.getVariavelMemoria(variavel));
System.out.println(i);
    }

}
