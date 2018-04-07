/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    public boolean comparaPalavras(String palavra){
        switch (palavra) {
        case "print":
            System.out.println ("print"); break;
            // chama comando print
            // return true
        case "println":
            System.out.println ("println"); break;
            // ""
            // return true
        case ":=":
            System.out.println (":="); break;
            // ""
            // return true
        case "readInt":
            System.out.println ("readInt"); break;
            // ""
            // return true
        case "for":
            System.out.println ("for"); break;
            // aciona lanço for 
            // return true
        case "while":
            System.out.println ("while"); break;
            // ""
            // return true
        case "if":
            System.out.println ("if"); break;
            // ""
            // return true
        }
        return false;
    }
    
    
    
}
