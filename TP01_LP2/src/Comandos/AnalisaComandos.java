package Comandos;

import static Constantes.Constantes.PALAVRAS_CONHECIDAS;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Augusto
 */
public class AnalisaComandos {

    private ArrayList<Comando> comandos;
    private ArrayList<String> listaComandos;
    private ArrayList<String> linhas;

    public AnalisaComandos() {
        this.comandos = new ArrayList<>();
        this.listaComandos = new ArrayList<>();
    }

    public ArrayList<Comando> comparaPalavras(ArrayList<String> linhas) {
        this.linhas = linhas;

        for (int i= 0; i < this.linhas.size(); i++) {
            if (this.linhas.get(i).equals(PALAVRAS_CONHECIDAS[14])) {
//                comandos.add(this.isEnd(i));
            } else if (this.linhas.get(i).substring(0, 3).contains(PALAVRAS_CONHECIDAS[0])) {
                comandos.add(this.isIf(i));
            } else if (this.linhas.get(i).substring(0, 4).contains(PALAVRAS_CONHECIDAS[7])) {
                comandos.add(this.isFor(i));
            } else if (this.linhas.get(i).contains(":=")) {
                comandos.add(this.isAtribuicao(i));
            } else if (this.linhas.get(i).substring(0, 5).contains(PALAVRAS_CONHECIDAS[11])) {
                comandos.add(this.isPrint(i));
            } else if (this.linhas.get(i).substring(0, 6).contains(PALAVRAS_CONHECIDAS[4])) {
                comandos.add(this.isWhile(i));
            } else if (this.linhas.get(i).substring(0, 8).contains(PALAVRAS_CONHECIDAS[13])) {
                comandos.add(this.isReadint(i));
            }
        }
        return comandos;
    }

    public Comando isIf(int indexLinha) {
        listaComandos.clear();
        listaComandos.add(linhas.get(indexLinha));
        while (!linhas.get(indexLinha + 1).equals(PALAVRAS_CONHECIDAS[3])) {
            listaComandos.add(linhas.remove(indexLinha + 1));
        }
        listaComandos.add(linhas.remove(indexLinha + 1));

        ArrayList auxLista = new ArrayList();
        auxLista.addAll(listaComandos);
        return new ComandoIf(auxLista);
    }

    public Comando isFor(int indexLinha) {
        listaComandos.clear();
        listaComandos.add(linhas.get(indexLinha));
        while (!linhas.get(indexLinha + 1).equals(PALAVRAS_CONHECIDAS[10])) {
            listaComandos.add(linhas.remove(indexLinha + 1));
        }
        listaComandos.add(linhas.remove(indexLinha + 1));

        String[] auxLista = new String[listaComandos.size()];
        for (int i = 0; i < listaComandos.size(); i++) {
            auxLista[i] = listaComandos.get(i);
        }
        return new ComandoFor(auxLista);
    }

    public Comando isWhile(int indexLinha) {
        listaComandos.clear();
        listaComandos.add(linhas.get(indexLinha));
        while (!linhas.get(indexLinha + 1).equals(PALAVRAS_CONHECIDAS[6])) {
            listaComandos.add(linhas.remove(indexLinha + 1));
        }
        listaComandos.add(linhas.remove(indexLinha + 1));

        String[] auxLista = new String[listaComandos.size()];
        for (int i = 0; i < listaComandos.size(); i++) {
            auxLista[i] = listaComandos.get(i);
        }
        return new ComandoWhile(auxLista);
    }

    public Comando isPrint(int indexLinha) {
        return new ComandoPrint(linhas.get(indexLinha));
    }

    public Comando isAtribuicao(int indexLinha) {
        return new ComandoAtribuicao(linhas.get(indexLinha));
    }

    public Comando isReadint(int indexLinha) {
        return new ComandoReadInt(linhas.get(indexLinha));
    }

    public boolean isEnd(int indexLinha) {
//        comandos.add(new ComandoEnd());
//        i = linhas.size();
        return true;
    }
}
