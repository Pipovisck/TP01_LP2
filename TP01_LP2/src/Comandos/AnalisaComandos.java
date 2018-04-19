package Comandos;

import static Constantes.Constantes.PALAVRAS_CONHECIDAS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author augus
 */
public class AnalisaComandos {

    String[] palavrasReservadas;

    public AnalisaComandos() {
        setPalavrasReservadas();
    }

    public void setPalavrasReservadas() {
        // seta todas as palavras reservadas da linguagem cefetiny
    }

    public Comando comparaPalavras(String comando) {
        String[] auxComando = comando.split("");
        
        if (auxComando[0] == PALAVRAS_CONHECIDAS[12]){
            return new ComandoPrint(comando); 
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[13]){
            // return new ComandoPrintln(); (?)
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[14]){
            // return new ComandoReadInt(); (?)
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[1]){
            // return new ComandoIf();
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[5]){
            // return new ComandoWhile(Falta definir a assinatura dos parametros); 
        } else if (auxComando[0] == PALAVRAS_CONHECIDAS[8]){
            // return new ComandoFor();
        } else if (auxComando [1] == ":="){
            // return new ComandoAtribuicao(comando);
        } else if (auxComando[auxComando.length - 1] == PALAVRAS_CONHECIDAS[15]){
            // return new ComandoEnd();(?)
        }    

        return null;
    }

}
