/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisador;

import Memoria.Memoria;

/**
 *
 * @author mathe
 * @param <E>
 */
public class CalculosLogicos<E> {
    private final ReconhecimentoExpressoesNumericas expressaoAritimetica;
    
    public CalculosLogicos(){
        expressaoAritimetica = new ReconhecimentoExpressoesNumericas();
    }

    public boolean calcularExpressaoLogicaBinaria(E operando1, E operando2, String operadorLogico, Memoria memoria) {
        switch (operadorLogico) {
            case "||":
                return this.Ou(Boolean.parseBoolean(operando1.toString()), Boolean.parseBoolean(operando2.toString()), memoria);
            case "&&":
                return this.E(Boolean.parseBoolean(operando1.toString()), Boolean.parseBoolean(operando2.toString()), memoria);
            case "=":
                return this.igual(operando1, operando2, memoria);
            case "<":
                return this.menor(operando1, operando2, memoria);
            case ">":
                return this.maior(operando1, operando2, memoria);
            case "<>":
                return !this.igual(operando1, operando2, memoria);
            default:
                return this.igual(operando1, operando2, memoria);
        }
    }

    public boolean igual(E operando1, E operando2, Memoria memoria) {
        if (memoria.getVariavel(operando1.toString()) != null) {
            operando1 = (E) memoria.getVariavel(operando1.toString());
        }

        if (memoria.getVariavel(operando2.toString()) != null) {
            operando2 = (E) memoria.getVariavel(operando2.toString());
        }
        return operando1.toString().equals(operando2.toString());
    }

    public boolean maior(E operando1, E operando2, Memoria memoria) {
        if (memoria.getVariavel(operando1.toString()) != null) {
            operando1 = (E) memoria.getVariavel(operando1.toString());
        }

        if (memoria.getVariavel(operando2.toString()) != null) {
            operando2 = (E) memoria.getVariavel(operando2.toString());
        }
        return Float.parseFloat(operando1.toString()) > Float.parseFloat(operando2.toString());
    }

    public boolean menor(E operando1, E operando2, Memoria memoria) {
        if (memoria.getVariavel(operando1.toString()) != null) {
            operando1 = (E) memoria.getVariavel(operando1.toString());
        }

        if (memoria.getVariavel(operando2.toString()) != null) {
            operando2 = (E) memoria.getVariavel(operando2.toString());
        }
        return Float.parseFloat(operando1.toString()) < Float.parseFloat(operando2.toString());
    }

    public boolean Ou(boolean operacao1, boolean operacao2, Memoria memoria) {
        return operacao1 || operacao2;
    }

    public boolean E(boolean operacao1, boolean operacao2, Memoria memoria) {
        return operacao1 && operacao2;
    }
}
