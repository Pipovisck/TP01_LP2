package Compilador;

import Analisador.ReconhecimentoExpressaoLogica;
import Excecoes.ExcecaoArquivoVazio;
import Memoria.Memoria;

/**
 *
 * @author Aluno
 */
public class Aplicacao {

    public static void main(String[] args) throws ExcecaoArquivoVazio {
//        Compilador compilador = new Compilador();
//        compilador.rodarPrograma();
        Memoria memoria = new Memoria();
        memoria.add("matheus", 5);
        memoria.add("suehtam", -5);
        ReconhecimentoExpressaoLogica x = new ReconhecimentoExpressaoLogica();
        System.out.println(x.calcularExpressao("10 = 9 || matheus <> suehtam", memoria));
//O programa esta imprimindo para teste duas vezes. 
//Para parar com esse teste, comentar as linhas 47, 48, 49, 50 e 51 da classe LeituraArquivo
//Para parar com esse teste, comentar as linhas 32, 33 e 34 da classe AnalisaPrograma
    }

}
