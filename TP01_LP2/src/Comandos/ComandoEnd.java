package Comandos;

import Memória.Memoria;

public class ComandoEnd extends Comando{

    @Override
    public Memoria executar(Memoria memoria) {
        System.exit(0);
        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        throw new UnsupportedOperationException("End!"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
