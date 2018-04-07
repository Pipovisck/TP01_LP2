/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mathe
 * @param <E>
 */
public abstract class Comando<E> {

    protected Memoria memoria;

    public Comando() {
        memoria = new Memoria();
    }

    public E getVariavelMemoria(String nome) {
        return (E) memoria.getVariavel(nome);
    }

    public abstract void executar();

    public abstract void verificarSintaxe();
}
