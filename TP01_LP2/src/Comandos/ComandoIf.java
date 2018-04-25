/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Analisador.ReconhecimentoExpressaoLogica;
import Memoria.Memoria;

/**
 *
 * @author Aluno
 */
public class ComandoIf extends Comando {
    
        String[] vetorComandos;
        String condicional;
        ReconhecimentoExpressaoLogica expressao;
    
    public ComandoIf (String[] vetorComandos){
        this.vetorComandos = vetorComandos;
    }

    @Override
    public Memoria executar(Memoria memoria) {
        int aux = 0;
        
        condicional = vetorComandos[0].substring(3, (vetorComandos[0].length() - 4));
        
        if(expressao.calcularExpressao(condicional, memoria)){
            for(int i = 0; i<vetorComandos.length;i++){
                if(vetorComandos[i] == "endif" || vetorComandos[i] == "else"){
                    aux = 1;
                }
                else if(aux == 0){
                    // executa qualquer outro comando
                }
            }
        }else{
            for(int i = 0; i<vetorComandos.length;i++){
                if(vetorComandos[i] == "endif"){
                    aux = 1;
                }
                else if(aux == 0){
                    // executa qualquer outro comando
                }
            }
        }
        
        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        return true;
    }

}
