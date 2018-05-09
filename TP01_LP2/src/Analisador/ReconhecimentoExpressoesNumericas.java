package Analisador;

import Excecoes.ExcecaoEntradaDados;
import Memoria.Memoria;
import java.util.Stack;

public class ReconhecimentoExpressoesNumericas {

    private final String[] precedencia = {"^", "*", "/"};
    private final CalculoNumerico calculadora;

    private final Stack<String> operandos;
    private final Stack<String> operadores;

    private enum UltimoCaracter {
        numero, operador
    };

    private UltimoCaracter ultimoCaracter;

    public ReconhecimentoExpressoesNumericas() {
        ultimoCaracter = UltimoCaracter.operador;
        calculadora = new CalculoNumerico();
        operandos = new Stack();
        operadores = new Stack();
    }

    public void verificaEntradas(String expressao, String entrada) throws ExcecaoEntradaDados {
        String entradasPermitidas[] = entrada.split("");
        String caracteresEntrada[] = expressao.split("");
        int verificadorCompat = 0;

        for (String caracteresEntrada1 : caracteresEntrada) {
            for (String entradasPermitida : entradasPermitidas) {
                if (!caracteresEntrada1.equals(entradasPermitida)) {
                    verificadorCompat++;
                }
            }
            if (verificadorCompat == entradasPermitidas.length) {
                throw new ExcecaoEntradaDados();
            }
            verificadorCompat = 0;
        }
    }

    public String calcularExpressao(String expressao1, Memoria memoria) {
        String[] expressao = expressao1.split("");
        for (String caracterer : expressao) {
            switch (caracterer) {
                case "(":
                case "^":
                    operadores.add(caracterer);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case ")":
                    this.desempilhaParenteses(memoria);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "*":
                case "/":
                    if (!operadores.empty() && operadores.lastElement().equals("^")) {
                        float valor2 = Float.parseFloat(operandos.pop());
                        float valor1 = Float.parseFloat(operandos.pop());
                        float resultado = calculadora.calcularBinario(operadores.pop(), valor1, valor2, memoria);
                        operandos.add(Float.toString(resultado));
                    }
                    operadores.add(caracterer);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case "+":
                case "-":
                    while (!operadores.empty() && operadores.lastElement() != null && (operadores.lastElement().equals(precedencia[0])
                            || operadores.lastElement().equals(precedencia[1])
                            || operadores.lastElement().equals(precedencia[2]))) {
                        float valor2 = Float.parseFloat(operandos.pop());
                        float valor1 = Float.parseFloat(operandos.pop());
                        float resultado = calculadora.calcularBinario(operadores.pop(), valor1, valor2, memoria);
                        operandos.add(Float.toString(resultado));
                    }
                    operadores.add(caracterer);
                    ultimoCaracter = UltimoCaracter.operador;
                    break;
                case ",":
                    caracterer = ".";
                default:
                    if (ultimoCaracter.equals(UltimoCaracter.numero)) {
                        String numero = operandos.pop();
                        numero += caracterer;
                        operandos.add(numero);
                    } else {
                        operandos.add(caracterer);
                        ultimoCaracter = UltimoCaracter.numero;
                    }
            }
        }
        this.desempilha(memoria);
        return operandos.pop();
    }

    public void desempilhaParenteses(Memoria memoria) {
        do {
            this.calculaUmAntecessor(memoria);
        } while (!operadores.lastElement().equals("("));
        operadores.pop();
    }

    public void desempilha(Memoria memoria) {
        while (!operadores.empty()) {
            this.calculaUmAntecessor(memoria);
        }
    }

    public void calculaUmAntecessor(Memoria memoria) {
        String segundoNumero = operandos.pop();
        String primeiroNumero = operandos.pop();
        String operador = operadores.pop();
        float resultado = calculadora.calcularBinario(operador, primeiroNumero, segundoNumero, memoria);
        operandos.add(Float.toString(resultado));
    }

}
