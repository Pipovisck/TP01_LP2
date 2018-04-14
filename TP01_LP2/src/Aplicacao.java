
import Arquivo.LeituraArquivo;
import Compilador.Compilador;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Aluno
 */
public class Aplicacao {

    public static void main(String[] args) {
        //Compilador compilador = new Compilador();
        //compilador.rodarPrograma();
        
        LeituraArquivo leitura = new LeituraArquivo();
        leitura.setDiretorio("C:\\Users\\augus\\Desktop\\TP01_LP2\\TP01_LP2\\cefetiny.txt");
        
        List a = new LinkedList();
        a = leitura.retornaLista();
    }

}
