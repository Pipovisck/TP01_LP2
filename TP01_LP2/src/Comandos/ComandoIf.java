/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Memoria.Memoria;

/**
 *
 * @author Aluno
 */
public class ComandoIf extends Comando {
    
    public ComandoIf (String[] vetorComandos){
        int aux = 0;
        
        if(/* Teste de expressão lógica */ true){
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
        
    }

    @Override
    public Memoria executar(Memoria memoria) {
        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        return true;
    }

}
