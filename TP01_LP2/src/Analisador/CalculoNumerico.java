package Analisador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aluno
 */
public class CalculoNumerico {

    public float calcularBinario(String operando, float valor1, float valor2) {
        float resultado;
        switch (operando) {
            case "*":
                resultado = this.multiplica(valor1, valor2);
                break;
            case "/":
                resultado = this.divide(valor1, valor2);
                break;
            case "+":
                resultado = this.soma(valor1, valor2);
                break;
            case "-":
                resultado = this.subtrai(valor1, valor2);
                break;
            default:
                resultado = this.potencia(valor1, valor2);
                break;
        }
        return resultado;
    }

    public float soma(float valor1, float valor2) {
        return valor1 + valor2;
    }

    public float subtrai(float valor1, float valor2) {
        return valor1 - valor2;
    }

    public float multiplica(float valor1, float valor2) {
        return valor1 * valor2;
    }

    public float divide(float numerador, float divisor) {
        return numerador / divisor;
    }

    public float potencia(float operando, float expoente) {
        float resultado = operando;
        for (int i = 0; i < expoente - 1; i++) {
            resultado *= operando;
        }
        return resultado;
    }
}
