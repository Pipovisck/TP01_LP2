package Comandos;

import Analisador.ReconhecimentoExpressoesNumericas;
import Constantes.Constantes;
import Memoria.Memoria;

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

    private final String nomeVariavel;
    private String conteudoVariavel;

    public enum TipoDado {
        Integer, String, Float
    }

    public ComandoAtribuicao(String linha) {
        super();
        String[] partesLinha = separaLinha(linha);
        this.nomeVariavel = partesLinha[0];
        this.conteudoVariavel = partesLinha[1];
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
    public Memoria executar(Memoria memoria) {
        this.memoria = memoria;
        
        String novoValor = this.calcularConteudo(conteudoVariavel);
        
        TipoDado tipoVariavel = this.descobreTipo(novoValor);
        switch (tipoVariavel) {
            case Integer:
                this.memoria.add(this.nomeVariavel, Integer.parseInt(novoValor));
                break;
            case Float:
                this.memoria.add(this.nomeVariavel, Float.parseFloat(novoValor));
                break;
            default:
                novoValor = this.conteudoVariavel.replace("\"", "");
                this.memoria.add(this.nomeVariavel, novoValor);
        }
        return this.memoria;
    }

    @Override
    public boolean verificarSintaxe() {
        return this.verificaSintaxeVariavel();
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

    public final String[] separaLinha(String linha) {
        String[] caracteres;
        caracteres = linha.split("");
        String linhaSemEspaco = "";
        for (String caracter : caracteres) {
            if (!caracter.equalsIgnoreCase(" ")) {
                linhaSemEspaco += caracter;
            }
        }
        String[] partesLinha = linhaSemEspaco.split(":=");
        return partesLinha;
    }

    public String calcularConteudo(String conteudo) {
        ReconhecimentoExpressoesNumericas reconhecedor = new ReconhecimentoExpressoesNumericas();
        String conteudoNovo = reconhecedor.calcularExpressao(conteudo, this.memoria);
        return conteudoNovo;
    }
}
