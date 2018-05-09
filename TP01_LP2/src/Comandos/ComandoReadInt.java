package Comandos;

import Memoria.Memoria;
import java.util.Scanner;

public class ComandoReadInt extends Comando<Integer>{
    Scanner scanner;
    char[] linhaComando;
    String nomeVar;
    
    public ComandoReadInt(String linhaComando){
        scanner = new Scanner(System.in);
        this.linhaComando = linhaComando.toCharArray();
        nomeVar="";
    }
    
    @Override
    public Memoria executar(Memoria memoria){
        for(int i=0; i<linhaComando.length; i++){
            if(linhaComando[i]=='('){
                i++;
                while(linhaComando[i]!=')'){
                    nomeVar+=String.valueOf(linhaComando[i]);
                    i++;
                }
                break;
            }
        }
        memoria.setVariavel(nomeVar, Integer.parseInt(scanner.next()));
        return memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        for(int i=0; i<linhaComando.length; i++){
            if(linhaComando[i]=='('){
                while(linhaComando[i]!=')'){
                    nomeVar+=String.valueOf(linhaComando[i]);
                    i++;
                }
                break;
            }
        }
        if(null == memoria.getVariavel(nomeVar))
            return false;
        return true;
    }
}
