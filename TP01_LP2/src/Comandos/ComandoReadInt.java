package Comandos;

import Memoria.Memoria;
import java.util.Scanner;

public class ComandoReadInt extends Comando<Integer>{
    Scanner scanner;
    String nomeVar;
    
    public ComandoReadInt(String nomeVar){
        scanner = new Scanner(System.in);
        this.nomeVar = nomeVar;
    }
    
    @Override
    public Memoria executar(Memoria memoria){
//        memoria.add(nomeVar, memoria);
        memoria.setVariavel(nomeVar, Integer.parseInt(scanner.next()));
        return memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        if(null == memoria.getVariavel(nomeVar))
            return false;
        return true;
    }
}
