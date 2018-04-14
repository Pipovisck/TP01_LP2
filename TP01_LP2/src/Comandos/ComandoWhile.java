package Comandos;

import Memoria.Memoria;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ComandoWhile extends Comando {

    private List<Comando> listaComandos;
    private String[] vetorLinhas; //Vetor que recebe todas as linhas do bloco de comando While
    private String expressao;

    public ComandoWhile(String[] vetorLinhas, List<Comando> listaComandos) {
        this.vetorLinhas = vetorLinhas;
        this.listaComandos = listaComandos;
        this.expressao = this.retornaExpressao();
    }

    @Override
    public Memoria executar(Memoria memoria) {
        this.memoria = memoria;
//        while(){
//            listaComandos.forEach((comando) -> {
//                comando.executar();
//            });
//        }
        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        return false;
    }

    private String retornaExpressao() {
        String linha = vetorLinhas[0];
        String express = new String();
        char[] vetor = linha.toCharArray();
        int inicio = 0;
        int fim = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == '(') {
                inicio = i + 1;
            }
        }
        
        for (int i = vetor.length; i >= 0; i--) {
            if (vetor[i] == ')') {
                fim = i;
            }
        }

        for (int i = inicio; i < fim; i++) {
            express += vetor[i];
        }

        return express;
    }

}
