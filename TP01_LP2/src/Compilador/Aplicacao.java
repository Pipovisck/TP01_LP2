package Compilador;

import Analisador.ReconhecimentoExpressaoLogica;
import Arquivo.AnalisaPrograma;
import Arquivo.LeituraArquivo;
import Excecoes.ExcecaoArquivoVazio;
import Memoria.Memoria;

/**
 *
 * @author Aluno
 */
public class Aplicacao {

    public static void main(String[] args) throws ExcecaoArquivoVazio {
        LeituraArquivo teste = new LeituraArquivo();
        teste.setDiretorio("cefetiny.txt");
        AnalisaPrograma analisa = new AnalisaPrograma(teste.retornaLista());
        analisa.separaComandos();
    }

}
