package Compilador;

import Excecoes.ExcecaoArquivoVazio;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Aplicacao {

    public static void main(String[] args) throws ExcecaoArquivoVazio {
        Compilador compilador = new Compilador();
        compilador.rodarPrograma();
        
//O programa esta imprimindo para teste. 
//Para parar com esse teste, comentar as linhas 47, 48 e 49 da classe LeituraArquivo
    }

}
