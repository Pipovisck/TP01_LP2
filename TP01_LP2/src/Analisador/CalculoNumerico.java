package Analisador;

import Memoria.Memoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aluno
 */
public class CalculoNumerico<E> {

    public float calcularBinario(String operador, E operando1, E operando2, Memoria memoria) {
        float resultado;
        switch (operador) {
            case "*":
                resultado = this.multiplica(operando1, operando2, memoria);
                break;
            case "/":
                resultado = this.divide(operando1, operando2, memoria);
                break;
            case "+":
                resultado = this.soma(operando1, operando2, memoria);
                break;
            case "-":
                resultado = this.subtrai(operando1, operando2, memoria);
                break;
            default:
                resultado = this.potencia(operando1, operando2, memoria);
                break;
        }
        return resultado;
    }

    public float soma(E operando1, E operando2, Memoria memoria) {
        float valor1 = 0;
        float valor2 = 0;
        if (memoria.getVariavel(operando1.toString()) != null) {
            valor1 = Float.parseFloat(memoria.getVariavel(operando1.toString()).toString());
        }
        else{
            valor1 = Float.parseFloat(operando1.toString());
        }

        if (memoria.getVariavel(operando2.toString()) != null) {
            valor2 = Float.parseFloat(memoria.getVariavel(operando2.toString()).toString());
        }
        else{
            valor2 = Float.parseFloat(operando2.toString());
        }
        return valor1 + valor2;
    }

    public float subtrai(E operando1, E operando2, Memoria memoria) {
        float valor1 = 0;
        float valor2 = 0;
        if (memoria.getVariavel(operando1.toString()) != null) {
            valor1 = Float.parseFloat(memoria.getVariavel(operando1.toString()).toString());
        }
        else{
            valor1 = Float.parseFloat(operando1.toString());
        }

        if (memoria.getVariavel(operando2.toString()) != null) {
            valor2 = Float.parseFloat(memoria.getVariavel(operando2.toString()).toString());
        }
        else{
            valor2 = Float.parseFloat(operando2.toString());
        }
        return valor1 - valor2;
    }

    public float multiplica(E operando1, E operando2, Memoria memoria) {
        float valor1 = 0;
        float valor2 = 0;
        if (memoria.getVariavel(operando1.toString()) != null) {
            valor1 = Float.parseFloat(memoria.getVariavel(operando1.toString()).toString());
        }
        else{
            valor1 = Float.parseFloat(operando1.toString());
        }

        if (memoria.getVariavel(operando2.toString()) != null) {
            valor2 = Float.parseFloat(memoria.getVariavel(operando2.toString()).toString());
        }
        else{
            valor2 = Float.parseFloat(operando2.toString());
        }
        return valor1 * valor2;
    }

    public float divide(E numerador, E divisor, Memoria memoria) {
        float valor1 = 0;
        float valor2 = 0;
        if (memoria.getVariavel(numerador.toString()) != null) {
            valor1 = Float.parseFloat(memoria.getVariavel(numerador.toString()).toString());
        }
        else{
            valor1 = Float.parseFloat(numerador.toString());
        }

        if (memoria.getVariavel(divisor.toString()) != null) {
            valor2 = Float.parseFloat(memoria.getVariavel(divisor.toString()).toString());
        }
        else{
            valor2 = Float.parseFloat(divisor.toString());
        }
        return valor1 / valor2;
    }

    public float potencia(E operando, E expoente, Memoria memoria) {
        float valor1 = 0;
        float valor2 = 0;
        if (memoria.getVariavel(operando.toString()) != null) {
            valor1 = Float.parseFloat(memoria.getVariavel(operando.toString()).toString());
        }
        else{
            valor1 = Float.parseFloat(operando.toString());
        }

        if (memoria.getVariavel(expoente.toString()) != null) {
            valor2 = Float.parseFloat(memoria.getVariavel(expoente.toString()).toString());
        }
        else{
            valor2 = Float.parseFloat(expoente.toString());
        }
        float resultado = valor1;
        for (int i = 0; i < valor2 - 1; i++) {
            resultado *= valor1;
        }
        return resultado;
    }
}
