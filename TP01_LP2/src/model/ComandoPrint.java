package model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ComandoPrint extends Comando<String>{
    private String linhaComando;
    char[] vetorComando;
    String impressao;
    int inicioParametros;

    public ComandoPrint(String linhaComando){
        super();
        this.linhaComando = linhaComando;
        vetorComando = linhaComando.toCharArray();
        impressao = new String();
        
        if(vetorComando[5]=='l'){
            inicioParametros=8;
        }
        else if(vetorComando[5]==' '){
            for(int i=5; i<vetorComando.length; i++){
                if(vetorComando[i]=='('){
                    inicioParametros = i+1;
                    break;
                }
            }
        }
        else{
            inicioParametros=6;
        }
    }

    @Override
    public void executar() {
        int contaStrings = 0;
        int contaVariaveis = 0;
        boolean concatenaVariavel = false;
        boolean ehVariavel = false;
        boolean ehString = false;
        String nomeVariavel = new String();

        for(int i=inicioParametros; i<vetorComando.length; i++){
            if(i==inicioParametros && vetorComando[i]!='"'){
                concatenaVariavel=true;
                contaVariaveis++;
            }
            else if(vetorComando[i]=='+' && concatenaVariavel==false){
                concatenaVariavel=true;
                if(vetorComando[i+1]!='"'){
                    contaVariaveis++;
                }
                else{
                    concatenaVariavel=false;
                }
            }
            else if(vetorComando[i]=='+' && concatenaVariavel==true){
                concatenaVariavel=false;
            }
            else if(vetorComando[i]=='"'&&vetorComando[i-1]!='\\'){
                contaStrings++;
            }
        }

        contaStrings=contaStrings/2;

        for (int i = inicioParametros; i < vetorComando.length; i++) {
            if(vetorComando[i]=='"'&&ehString==false){
                ehString = true;
            }
            else if(ehString==true&&vetorComando[i]!='"'){
                impressao+=String.valueOf(vetorComando[i]);
            }
            else if(ehString==true&&vetorComando[i]=='"'){
                ehString=false;
            }
            else if(i==inicioParametros && vetorComando[i]!='"'){
                ehVariavel=true;
                nomeVariavel+=String.valueOf(vetorComando[i]);
            }
            else if(vetorComando[i] == '+' && ehVariavel == false){
                ehVariavel=true;
            }
            else if(ehVariavel == true && vetorComando[i] != '+' && i != vetorComando.length-1){
                nomeVariavel += String.valueOf(vetorComando[i]);
            }
            else if(ehVariavel == true&&vetorComando[i] == '+'){
                ehVariavel=false;
                impressao += String.valueOf(memoria.getVariavel(nomeVariavel));
            }
            else if(i==vetorComando.length-1 && ehVariavel==true){
                ehVariavel=false;
                impressao += String.valueOf(memoria.getVariavel(nomeVariavel));
            }
        }
        System.out.println(impressao);
    }

    @Override
    public boolean verificarSintaxe() {
        int contaStrings = 0;
        int contaVariaveis = 0;
        boolean concatenaVariavel = false;
        boolean ehVariavel = false;
        boolean ehString = false;

        for(int i=inicioParametros; i<vetorComando.length; i++){
            if(i==inicioParametros && vetorComando[i]!='"'){
                concatenaVariavel=true;
                contaVariaveis++;
            }
            else if(vetorComando[i]=='+' && concatenaVariavel==false){
                concatenaVariavel=true;
                if(vetorComando[i+1]!='"'){
                    contaVariaveis++;
                }
                else{
                    concatenaVariavel=false;
                }
            }
            else if(vetorComando[i]=='+' && concatenaVariavel==true){
                if(vetorComando[i+1]==' '){
                    for(int j = i+1; vetorComando[j]==' '; j++){
                        if(vetorComando[j+1]!='"'){
                            return false;
                        }
                    }
                }
                else if(vetorComando[i+1]!='"'){
                    return false;
                }
                concatenaVariavel=false;
            }
            else if(vetorComando[i]=='"'&&vetorComando[i-1]!='\\'){
                contaStrings++;
            }
        }

        if(contaStrings%2!=0){
            return false;
        }

        contaStrings=contaStrings/2;

        for (int i = inicioParametros; i < vetorComando.length; i++) {
            if(vetorComando[i]=='"'&&ehString==false){
                if(ehVariavel==true){
                    return false;
                }
                ehString = true;
            }
            else if(ehString==true&&vetorComando[i]=='"'){
                ehString=false;
                if(vetorComando[i+1]!='+' && i!=vetorComando.length-2){
                    return false;
                }
            }
            else if(i==inicioParametros && vetorComando[i]!='"'){
                ehVariavel=true;
            }
            else if(vetorComando[i] == '+' && ehVariavel == false){
                ehVariavel=true;
            }
            else if(ehVariavel == true&&vetorComando[i] == '+'){
                ehVariavel=false;
            }
            else if(i==vetorComando.length-1 && ehVariavel==true){
                ehVariavel=false;
            }
        }
        return true;
    }
}