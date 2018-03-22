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
public class ComandoAtribuicao {

    private final Memoria memoriaVariaveis;

    public ComandoAtribuicao() {
        memoriaVariaveis = new Memoria();
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

        if (valorPartes[0].equals("")) {
            tipoDado = TipoDado.String;
        }

        return tipoDado;
    }

    public void armazenaVariavel(String linha) {
        String[] partesLinha = this.quebraLinha(linha);
        TipoDado tipo = this.descobreTipo(partesLinha[1]);
        if (tipo == TipoDado.Integer) {
            memoriaVariaveis.add(partesLinha[0], Integer.parseInt(partesLinha[1]));
        } else {
            memoriaVariaveis.add(partesLinha[0], partesLinha[1]);
        }
    }
    
    public Memoria getMemoriaVariaveis(){
        return memoriaVariaveis;
    }
}
