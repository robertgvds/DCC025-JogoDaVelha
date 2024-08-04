
package com.robert.jogodavelha;

import java.util.Scanner;

public class Jogo {

    private Jogador jogador1;    
    private Jogador jogador2;

    private Tabuleiro tabuleiro;

    public static String Resultado;
    
    Jogo(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;

        this.tabuleiro = tabuleiro;
    }

    public void Jogar(Scanner teclado) {
        Jogador jogadorAtual = jogador1;

        if(Bot.dificuldade)
            jogadorAtual = jogador2;

        boolean fimDeJogo = false;

        while (!fimDeJogo) {
            limpar.clearConsole();
            System.out.println( "\n===================================================\n" +
                                Tabuleiro.getJogada() + "a Jogada! Vez do(a) " + jogadorAtual.getNome());
            
            tabuleiro.Imprimir();
            jogadorAtual.Jogada(teclado);
            
            if(tabuleiro.fimDeJogo(jogadorAtual.getSimbolo())) {
                if(jogadorAtual.getNome() == "Bot") {
                    Resultado = "Pelo visto o computador ganhou! >o<";
                    fimDeJogo = true;
                    break;
                }

                Resultado = "PARABÉNS " + jogadorAtual.getNome().toUpperCase() + "! VOCÊ GANHOU! :)";
                fimDeJogo = true;
                break;
            }

            if(tabuleiro.Empate()) {
                Resultado = "Deu empate, tente jogar de novo :(";
                fimDeJogo = true;
                break;
            }

            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }
    }
}
