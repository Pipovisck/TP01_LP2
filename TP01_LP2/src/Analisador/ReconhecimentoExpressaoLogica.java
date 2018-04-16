/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisador;

import java.util.Stack;

/**
 *
 * @author mathe
 */
public class ReconhecimentoExpressaoLogica {

    private final Stack<String> operandos;
    private final Stack<String> operadores;
    private final CalculosLogicos calculos;

    private enum UltimoCaracter {
        operando, operador
    };

    private UltimoCaracter ultimoCaracter;

    public ReconhecimentoExpressaoLogica() {
        operandos = new Stack<>();
        operadores = new Stack<>();
        calculos = new CalculosLogicos();
        ultimoCaracter = UltimoCaracter.operando;
    }

    public boolean calcularExpressao(String expressao) {
        String[] caracteresExpressao = expressao.split("");
        for (String caracter : caracteresExpressao) {
            switch (caracter) {
                case "=":
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case ">":
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "<":
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "|":
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                default:
                    ultimoCaracter = UltimoCaracter.operando;
            }
        }
        return false;
    }
}
