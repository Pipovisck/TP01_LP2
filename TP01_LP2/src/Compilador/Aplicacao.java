package Compilador;

import Comandos.ComandoIf;
import Excecoes.ExcecaoArquivoVazio;
import Memoria.Memoria;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Aluno
 */
public class Aplicacao {

    public static void main(String[] args) throws ExcecaoArquivoVazio {
//        LeituraArquivo teste = new LeituraArquivo();
//        teste.setDiretorio("cefetiny.txt");
//        AnalisaPrograma analisa = new AnalisaPrograma(teste.retornaLista());
//        analisa.separaComandos();
        String x = "if(5>3) then x:=10 else x:=5 endif";
        String[] xx = x.split(" ");
        ArrayList<String> palavras = new ArrayList<>();
        palavras.addAll(Arrays.asList(xx));
        ComandoIf iff = new ComandoIf(palavras);
        Memoria m = new Memoria();
        m = iff.executar(m);
    }

}
