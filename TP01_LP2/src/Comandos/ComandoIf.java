/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Analisador.ReconhecimentoExpressaoLogica;
import Memoria.Memoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ComandoIf extends Comando {

    private ArrayList<String> vetorComandos;
    private String condicional;
    private ReconhecimentoExpressaoLogica expressao;
    private AnalisaComandos analisaComandos;
    private ArrayList<Comando> comandos;
    private ArrayList<String> listaElse;
    private ArrayList<String> listaIf;

    public ComandoIf(ArrayList<String> vetorComandos) {
        this.vetorComandos = vetorComandos;
        listaIf = new ArrayList<>();
        listaElse = new ArrayList<>();
        analisaComandos = new AnalisaComandos();
//        comandos = analisaComandos.comparaPalavras(vetorComandos);
    }

    @Override
    public Memoria executar(Memoria memoria) {
        Integer index = null;
        
        for (String linha : vetorComandos) {
            if(linha.equals("else")){
                index = vetorComandos.indexOf(linha);
            }
        }
        
        if(index != null){
            listaIf = (ArrayList<String>) vetorComandos.subList(1, index - 1);
            listaElse = (ArrayList<String>) vetorComandos.subList(index + 1, vetorComandos.size() - 2);
        }
        condicional = vetorComandos.get(0).substring(3, (vetorComandos.get(0).length() - 4));

        if (expressao.calcularExpressao(condicional, memoria)) {

        } else {

        }

        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        return true;
    }

}
