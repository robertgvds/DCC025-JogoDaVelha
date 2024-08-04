package com.robert.jogodavelha;

import java.util.ArrayList;
import java.util.Scanner;

public class Registro {

    private static class RegistroJogada {
        char simbolo;
        int x;
        int y;

        RegistroJogada(char simbolo, int x, int y) {
            this.simbolo = simbolo;
            this.x = x;
            this.y = y;
        }
    }

    private static ArrayList<RegistroJogada> Jogadas;

    public Registro() {
        Jogadas = new ArrayList<>();
    }

    public static void setJogada(char simbolo, int x, int y) {
        RegistroJogada Jogada = new RegistroJogada(simbolo, x, y);
        Jogadas.add(Jogada);
    }

    private int opcaoEscolhida(Scanner teclado, int jogada, int numJogadas) {
        char escolha;

        if(jogada == 1) {
            System.out.println("\n(>) para avançar.");
            System.out.println("(S) para sair.");
            escolha = teclado.next().toUpperCase().charAt(0);
        
            while(escolha != '>' && escolha != 'S') {
                System.out.println("\nDigite um valor válido. (>/S) ");
                escolha = teclado.next().toUpperCase().charAt(0);
            }
        } else if(jogada == numJogadas-1) {
            System.out.println("\n(<) para voltar.");
            System.out.println("(S) para sair.");
            escolha = teclado.next().toUpperCase().charAt(0);
        
            while(escolha != '<' && escolha != 'S') {
                System.out.println("\nDigite um valor válido. (</S) ");
                escolha = teclado.next().toUpperCase().charAt(0);
            }
        } else {
            System.out.println("\n(>) para avançar.");
            System.out.println("(<) para voltar.");
            System.out.println("(S) para sair.");
            escolha = teclado.next().toUpperCase().charAt(0);
        
            while(escolha != '>' && escolha != '<' && escolha != 'S') {
                System.out.println("\nDigite um valor válido. (>/</S) ");
                escolha = teclado.next().toUpperCase().charAt(0);
            }
        }

        switch (escolha) {
            case '>':
                return 1;
            case '<':
                return -1;
            case 'S':
                return 0;
        }

        return 0;
    }

    public void revisarJogadas(Scanner teclado, Tabuleiro tabuleiro) {

        for(int i = 0; i < Jogadas.size(); i++)
            tabuleiro.reset(' ', Jogadas.get(i).x, Jogadas.get(i).y);

        int numJogadas = Tabuleiro.getJogada();
        int numJogadasAtual = 1;
        int opcao = 1;

        RegistroJogada jogadaAtual;

        while(opcao != 0) {
            limpar.clearConsole();

            System.out.println( "==============================================\n" +
                                "Revendo a " + numJogadasAtual + "a jogada!\n");

            if(opcao == 1) {
                jogadaAtual = Jogadas.get(numJogadasAtual-1);
                tabuleiro.reset(jogadaAtual.simbolo, jogadaAtual.x, jogadaAtual.y);
            }
            if(opcao == -1) {
                jogadaAtual = Jogadas.get(numJogadasAtual);
                tabuleiro.reset(' ', jogadaAtual.x, jogadaAtual.y);
            }

            tabuleiro.Imprimir();
            
            opcao = opcaoEscolhida(teclado, numJogadasAtual, numJogadas);
            numJogadasAtual=numJogadasAtual+opcao;
        }
    }
}
