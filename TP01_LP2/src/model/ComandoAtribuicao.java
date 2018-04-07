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

    private String linha;

    public enum TipoDado {
        Integer, String, Float
    }

    public ComandoAtribuicao(String linha) {
        this.linha = linha;
    }

    public String[] quebraLinha(String linha) {
        String[] partesLinha;
        partesLinha = linha.split(":=");
        String[] vetorPartes = {partesLinha[0], partesLinha[1]};
        return vetorPartes;
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
        String[] partesLinha = this.quebraLinha(getLinha());
        TipoDado tipo = this.descobreTipo(partesLinha[1]);

        switch (tipo) {
            case Integer:
                this.memoria.add(partesLinha[0], Integer.parseInt(partesLinha[1]));
                break;
            case Float:
                this.memoria.add(partesLinha[0], Float.parseFloat(partesLinha[1]));
                break;
            default:
                this.memoria.add(partesLinha[0], partesLinha[1]);
                break;
        }
    }

    @Override
    public void verificarSintaxe() {

    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

}
