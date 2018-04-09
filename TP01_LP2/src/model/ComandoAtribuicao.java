package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matheus
 */
public class ComandoAtribuicao extends Comando {

    private String nomeVariavel;
    private String conteudoVariavel;

    public enum TipoDado {
        Integer, String, Float
    }

    public ComandoAtribuicao(String nomeVariavel, String conteudoVariavel) {
        super();
        this.nomeVariavel = nomeVariavel;
        this.conteudoVariavel = conteudoVariavel;
    }

    public TipoDado descobreTipo(String valor) {
        TipoDado tipoDado = TipoDado.Integer;
        String[] valorPartes;
        valorPartes = valor.split("");

        if (valorPartes[0].equals("\"")) {
            tipoDado = TipoDado.String;
        }

        for (String caracter : valorPartes) {
            if (caracter.equalsIgnoreCase(".")) {
                tipoDado = TipoDado.Float;
            }
        }
        return tipoDado;
    }

    @Override
    public void executar() {
        TipoDado tipoVariavel = this.descobreTipo(this.conteudoVariavel);
        switch (tipoVariavel) {
            case Integer:
                this.memoria.add(this.nomeVariavel, Integer.parseInt(this.conteudoVariavel));
                break;
            case Float:
                this.memoria.add(this.nomeVariavel, Float.parseFloat(this.conteudoVariavel));
                break;
            default:
                this.conteudoVariavel = this.conteudoVariavel.replace("\"", "");
                this.memoria.add(this.nomeVariavel, this.conteudoVariavel);
        }
    }

    @Override
    public boolean verificarSintaxe() {
        return this.verificaSintaxeVariavel() && this.verificaSintaxeExpressao();
    }

    public boolean verificaSintaxeVariavel() {
        String[] partesNome;
        partesNome = this.nomeVariavel.split("");
        boolean primeiraLetraCerta = false;
        for (String letra : Constantes.LETRAS) {
            if (letra.equalsIgnoreCase(partesNome[0])) {
                primeiraLetraCerta = true;
                break;
            }
        }
        if (!primeiraLetraCerta) {
            return false;
        }

        for (int i = 1; i < partesNome.length; i++) {
            boolean caracterCorreto = false;
            for (String letra : Constantes.LETRAS) {
                if (letra.equalsIgnoreCase(partesNome[i])) {
                    caracterCorreto = true;
                    break;
                }
            }
            if (!caracterCorreto) {
                for (Integer digito : Constantes.DIGITOS) {
                    if (partesNome[i].equalsIgnoreCase(digito.toString())) {
                        caracterCorreto = true;
                        break;
                    }
                }
            }
            if (!caracterCorreto) {
                return false;
            }
        }
        return true;
    }

    public boolean verificaSintaxeExpressao() {

        return true;
    }
}
