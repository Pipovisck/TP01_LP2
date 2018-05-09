/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisador;

import Memoria.Memoria;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author mathe
 * @param <E>
 */
public class ReconhecimentoExpressaoLogica<E> {

    private final Stack<String> operandos;
    private final List<String> operadores;
    private final List<Boolean> resultados;
    private final CalculosLogicos calculos;

    private enum UltimoCaracter {
        operando, operador
    };

    private UltimoCaracter ultimoCaracter;

    public ReconhecimentoExpressaoLogica() {
        operandos = new Stack<>();
        operadores = new LinkedList<>();
        resultados = new LinkedList();
        calculos = new CalculosLogicos();
        ultimoCaracter = UltimoCaracter.operando;
    }

    public boolean calcularExpressao(String expressao, Memoria memoria) {
        String[] caracteresExpressao = expressao.split("");
        for (String caracter : caracteresExpressao) {
            switch (caracter) {
                case "(":
                    operadores.add(caracter);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case ")":
                    this.desempilhaParenteses(memoria);
                    break;
                case "=":
                    operadores.add(caracter);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case ">":
                    if (ultimoCaracter == UltimoCaracter.operador && operadores.get(operadores.size() - 1).equals("<")) {
                        operadores.set(operadores.size() - 1, operadores.get(operadores.size() - 1) + caracter);
                    }
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "<":
                    operadores.add(caracter);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "|":
                    if (ultimoCaracter == UltimoCaracter.operador && operadores.get(operadores.size() - 1).equals("|")) {
                        operadores.set(operadores.size() - 1, operadores.get(operadores.size() - 1) + caracter);
                    } else {
                        this.desenpilhaResolveAnterior(memoria);
                        operadores.add(caracter);
                    }
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "&":
                    if (ultimoCaracter == UltimoCaracter.operador && operadores.get(operadores.size() - 1).equals("&")) {
                        operadores.set(operadores.size() - 1, operadores.get(operadores.size() - 1) + caracter);
                    } else {
                        this.desenpilhaResolveAnterior(memoria);
                        operadores.add(caracter);
                    }
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case " ":
                    break;
                default:
                    if (ultimoCaracter == UltimoCaracter.operando && !operandos.isEmpty()) {
                        operandos.set(operandos.size() - 1, operandos.get(operandos.size() - 1) + caracter);
                    } else {
                        operandos.add(caracter);
                    }
                    ultimoCaracter = UltimoCaracter.operando;
            }
        }
        return this.resolverExpressao(memoria);
    }

    public void desenpilhaResolveAnterior(Memoria memoria) {
        String numero2 = operandos.pop();
        String numero1 = operandos.pop();
        resultados.add(calculos.calcularExpressaoLogicaBinaria(numero1, numero2, operadores.remove(operadores.size() - 1), memoria));
    }

    public void resolveExpressaoAnteriorFinal(Memoria memoria) {
        Boolean resultado = calculos.calcularExpressaoLogicaBinaria(resultados.remove(0), resultados.get(0), operadores.remove(0), memoria);
        resultados.set(0, resultado);
    }

    public boolean resolverExpressao(Memoria memoria) {
        this.desenpilhaResolveAnterior(memoria);
        while (!operadores.isEmpty()) {
            this.resolveExpressaoAnteriorFinal(memoria);
        }
        return resultados.get(resultados.size()-1);
    }

    public void desempilhaParenteses(Memoria memoria) {
        do {
            this.resolveExpressaoAnteriorFinal(memoria);
        } while (!operadores.get(operadores.size() - 1).equals("("));
        operadores.remove(operadores.size() - 1);
    }

}
