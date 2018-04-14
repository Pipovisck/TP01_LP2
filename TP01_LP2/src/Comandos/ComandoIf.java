/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Memoria.Memoria;

/**
 *
 * @author Aluno
 */
public class ComandoIf extends Comando {

    @Override
    public Memoria executar(Memoria memoria) {
        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        return true;
    }

}
