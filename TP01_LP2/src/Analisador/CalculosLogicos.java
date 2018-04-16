/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisador;

/**
 *
 * @author mathe
 * @param <E>
 */
public class CalculosLogicos<E> {

    public boolean calcularExpressaoLogicaBinaria(E operando1, E operando2, String operadorLogico) {
        switch (operadorLogico) {
            case "||":
                return this.Ou(Boolean.parseBoolean(operando1.toString()), Boolean.parseBoolean(operando2.toString()));
            case "&&":
                return this.E(Boolean.parseBoolean(operando1.toString()), Boolean.parseBoolean(operando2.toString()));
            case "=":
                return this.igual(operando1, operando2);
            case "<":
                return this.menor(operando1, operando2);
            case ">":
                return this.maior(operando1, operando2);
            default:
                return this.igual(operando1, operando2);
        }
    }

    public boolean igual(E operando1, E operando2) {
        return operando1.equals(operando2);
    }

    public boolean maior(E operando1, E operando2) {
        return Float.parseFloat(operando1.toString()) > Float.parseFloat(operando2.toString());
    }

    public boolean menor(E operando1, E operando2) {
        return Float.parseFloat(operando1.toString()) < Float.parseFloat(operando2.toString());
    }

    public boolean Ou(boolean operacao1, boolean operacao2) {
        return operacao1 || operacao2;
    }

    public boolean E(boolean operacao1, boolean operacao2) {
        return operacao1 && operacao2;
    }
}
