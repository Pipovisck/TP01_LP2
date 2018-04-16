package Compilador;

import Excecoes.ExcecaoArquivoVazio;

/**
 *
 * @author Aluno
 */
public class Aplicacao {

    public static void main(String[] args) throws ExcecaoArquivoVazio {
        Compilador compilador = new Compilador();
        compilador.rodarPrograma();

//O programa esta imprimindo para teste duas vezes. 
//Para parar com esse teste, comentar as linhas 47, 48, 49, 50 e 51 da classe LeituraArquivo
//Para parar com esse teste, comentar as linhas 32, 33 e 34 da classe AnalisaPrograma
    }

}
