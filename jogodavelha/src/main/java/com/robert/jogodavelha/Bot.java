package com.robert.jogodavelha;

import java.util.Random;
import java.util.Scanner;

public class Bot extends Jogador {

    private Random random;
    private Tabuleiro tabuleiro;
    private Gerador gerador;

    public static boolean inteligencia;
    public static boolean dificuldade;

    public Bot(String nome, char simbolo) {
        super(nome, simbolo);
        random = new Random();

        this.tabuleiro = new Tabuleiro();
        this.gerador = new Gerador(simbolo);
    }

    private int[] pontosAleatorios() {
        int[] posicao = new int[2];

        posicao[0] = random.nextInt(3) + 1;
        posicao[1] = random.nextInt(3) + 1;

        return posicao;
    }

    private int[] pontosInteligentes() {
        if(gerador.posicaoInteligente() != null)
            return gerador.posicaoInteligente();
        return pontosAleatorios();
    }

    @Override
    public void Jogada(Scanner teclado) {
        
        int[] posicao;
        
        if(inteligencia)
            posicao = pontosInteligentes();
        else
            posicao = pontosAleatorios();

        while(!tabuleiro.Valido(getSimbolo(), posicao[0], posicao[1])) {
            if(inteligencia)
                posicao = pontosInteligentes();
            else
                posicao = pontosAleatorios();
        }
        System.out.println("\nPosições escolhidas pelo Bot são (" + posicao[0] + "," + posicao[1] + ")");
    }
}
