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
        
        
    }

    @Override
    public Memoria executar(Memoria memoria) {
        
        expressao = new ReconhecimentoExpressaoLogica();
//        comandos = analisaComandos.comparaPalavras(vetorComandos);
        Integer index = null;
        Integer indexInicioIf = 1;
        condicional = vetorComandos.get(0).substring(4, (vetorComandos.get(0).length() - 5));
        for (String linha : vetorComandos) {
            if (linha.equals("else")) {
                index = vetorComandos.indexOf(linha);
                break;
            }
        }

        if (index != null) {
            List<String> aux = vetorComandos.subList(indexInicioIf, vetorComandos.size() - 2);
            aux.forEach((palavra) -> {
                listaElse.add(palavra);
            });
        } else {
            index = vetorComandos.size() - 1;
        }

        List<String> aux = vetorComandos.subList(indexInicioIf, index);
        aux.forEach((palavra) -> {
            listaIf.add(palavra);
        });

        

        if (expressao.calcularExpressao(condicional, memoria)) {
            comandos = analisaComandos.comparaPalavras(listaIf);
            comandos.forEach((comando) -> {
                comando.executar(memoria);
            });
        } else {
            comandos = analisaComandos.comparaPalavras(listaElse);
            comandos.forEach((comando) -> {
                comando.executar(memoria);
            });
        }

        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        return true;
    }

}
