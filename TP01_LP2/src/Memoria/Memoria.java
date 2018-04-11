package Memoria;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;

/**
 *
 * @author matheus
 * @param <E>
 */
public class Memoria<E> {

    private final HashMap<String, E> variaveis;

    public Memoria() {
        variaveis = new HashMap<>();
    }

    public void add(String nomeVariavel, E valorVariavel) {
        this.variaveis.put(nomeVariavel, valorVariavel);
    }

    public void remove(String nomeVariavel) {
        this.variaveis.remove(nomeVariavel);
    }

    public E getVariavel(String nomeVariavel) {
        return variaveis.get(nomeVariavel);
    }

    public void setVariavel(String nomeVariavel, E valorVariavel) {
        variaveis.replace(nomeVariavel, valorVariavel);
    }
}
