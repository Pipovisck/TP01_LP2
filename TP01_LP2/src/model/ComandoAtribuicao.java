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
public class ComandoAtribuicao implements Comando {

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

    public void armazenaVariavel(String linha, Memoria memoriaVariaveis) {
        String[] partesLinha = this.quebraLinha(linha);
        TipoDado tipo = this.descobreTipo(partesLinha[1]);
        if (tipo == TipoDado.Integer) {
            memoriaVariaveis.add(partesLinha[0], Integer.parseInt(partesLinha[1]));
        } else {
            memoriaVariaveis.add(partesLinha[0], partesLinha[1]);
        }
    }

    @Override
    public void executar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean varificacarSintaxe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
