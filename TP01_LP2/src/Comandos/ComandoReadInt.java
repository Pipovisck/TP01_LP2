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
        nomeVar="";
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
        if(memoria.getVariavel(nomeVar) == null){
            memoria.add(nomeVar, scanner.nextInt());
        }
        else{
            memoria.setVariavel(nomeVar, scanner.nextInt());
        }
        return memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        for(int i=0; i<linhaComando.length; i++){
            if(linhaComando[i]=='('){
                if(linhaComando[i+1]>='0' && linhaComando[i+1]<='9')
                    return false;
            }
        }
        return true;
    }
}
