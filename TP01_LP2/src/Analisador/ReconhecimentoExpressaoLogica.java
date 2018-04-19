/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisador;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author mathe
 * @param <E>
 */
public class ReconhecimentoExpressaoLogica<E> {

    private final String[] precedencia = {"||", "&&"};

    private final Stack<String> operandos;
    private final Stack<String> operadores;
    private final ConcurrentLinkedQueue<Boolean> resultados;
    private final CalculosLogicos calculos;

    private enum UltimoCaracter {
        operando, operador
    };

    private UltimoCaracter ultimoCaracter;

    public ReconhecimentoExpressaoLogica() {
        operandos = new Stack<>();
        operadores = new Stack<>();
        resultados = new ConcurrentLinkedQueue();
        calculos = new CalculosLogicos();
        ultimoCaracter = UltimoCaracter.operando;
    }

    public boolean calcularExpressao(String expressao) {
        String[] caracteresExpressao = expressao.split("");
        for (String caracter : caracteresExpressao) {
            switch (caracter) {
                case "=":
                    operadores.add(caracter);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case ">":
                    operadores.add(caracter);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "<":
                    operadores.add(caracter);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "|":
                    if (ultimoCaracter == UltimoCaracter.operador) {
                        this.desenpilhaResolveAnterior();
                        operadores.set(operadores.size() - 1, operadores.lastElement() + caracter);
                    } else {
                        operadores.add(caracter);
                    }
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "&":
                    if (ultimoCaracter == UltimoCaracter.operador) {
                        this.desenpilhaResolveAnterior();
                        operadores.set(operadores.size() - 1, operadores.lastElement() + caracter);
                    } else {
                        operadores.add(caracter);
                    }
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                default:
                    if (ultimoCaracter == UltimoCaracter.operando && !operandos.isEmpty()) {
                        operandos.set(operandos.size() - 1, operandos.lastElement() + caracter);
                    } else {
                        operandos.add(caracter);
                    }
                    ultimoCaracter = UltimoCaracter.operando;
            }
        }
        return this.resolverExpressao();
    }

    public void desenpilhaResolveAnterior() {
        String numero2 = operandos.pop();
        String numero1 = operandos.pop();
        resultados.add(calculos.calcularExpressaoLogicaBinaria(numero1, numero2, operadores.pop()));
    }

    public boolean resolverExpressao() {
        this.desenpilhaResolveAnterior();
        while (!operadores.empty()) {
            Boolean resultado = calculos.calcularExpressaoLogicaBinaria(resultados.remove(), resultados.remove(), operadores.pop());
            if (operadores.empty()) {
                resultados.add(resultado);
            }
            operandos.add(resultado.toString());
        }
        return Boolean.parseBoolean(operandos.lastElement());
    }

}
