package com.robert.jogodavelha;

import java.util.Scanner;

public class Jogador {
    private String nome;
    private char simbolo;

    private Tabuleiro tabuleiro;

    Jogador(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;

        this.tabuleiro = new Tabuleiro();
    }
    
    public String getNome() {
        return nome;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void Jogada(Scanner teclado) {
        System.out.println("\nJogador(a) " + nome + ", digite a posição escolhida (linha,coluna): ");
        int[] posicao = new Ponto().Posicao(teclado);
            
        while(!tabuleiro.Valido(simbolo, posicao[0], posicao[1])) {
            System.out.println("\nDigite uma posição válida:");
            System.out.println("Escreva desta forma (linha,coluna) com os () e sem espaços.");
            posicao = new Ponto().Posicao(teclado);
        }
    }
}
