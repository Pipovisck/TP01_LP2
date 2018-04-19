package Comandos;

import static Constantes.Constantes.PALAVRAS_CONHECIDAS;
import java.util.List;

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

    String[] palavrasReservadas;

    public AnalisaComandos() {
    }

    public Comando comparaPalavras(List<String> comando) {
        String[] auxComando = comando.get(0).split("");
        String[] vetorComandos = new String[comando.size()];
        int i = 0;
        
        
        if (auxComando[0] == PALAVRAS_CONHECIDAS[12] || auxComando[0] == PALAVRAS_CONHECIDAS[13]){
            // return new ComandoPrint(comando.get(0)); 
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[14]){
            // return new ComandoReadInt(comando.get(0));
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[1]){            
            while(!comando.isEmpty()){
            vetorComandos[i] = comando.remove(i);
            i++;
            }            
            // return new ComandoIf(vetorComandos);
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[5]){
            while(!comando.isEmpty()){
            vetorComandos[i] = comando.remove(i);
            i++;
            }  
            // return new ComandoWhile(vetorComandos); 
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[8]){
            while(!comando.isEmpty()){
            vetorComandos[i] = comando.remove(i);
            i++;
            }  
            // return new ComandoFor(vetorComandos);
        } else if (auxComando [1] == ":="){
            // return new ComandoAtribuicao(comando.get(0));
        } else if (auxComando[auxComando.length - 1] == PALAVRAS_CONHECIDAS[15]){
            // return new ComandoEnd();
        }    

        return null;
    }

}
