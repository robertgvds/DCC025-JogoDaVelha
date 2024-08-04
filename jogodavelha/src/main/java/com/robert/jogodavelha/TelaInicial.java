package com.robert.jogodavelha;

import java.util.Scanner;

public class TelaInicial {
    
    private Tabuleiro tabuleiro;
    private Registro registro;

    private boolean primeiraPartida;

    private Jogador Jogador1;
    private Jogador Jogador2;

    private Jogo jogo;
    
    TelaInicial() {

        tabuleiro = new Tabuleiro();
        registro = new Registro();

        primeiraPartida = true;
    }

    private void criarBot(Scanner teclado, char simbolo) {
        this.Jogador2 = new Bot("Bot", simbolo);
            
        System.out.println("\nVocê quer um Bot inteligente? (S/N): ");
        char escolha = teclado.next().toUpperCase().charAt(0);
    
        while(escolha != 'S' && escolha != 'N') {
            System.out.println("\nDigite um valor válido (S/N): ");
            escolha = teclado.next().toUpperCase().charAt(0);
        }

        Bot.inteligencia = (escolha == 'S') ? true : false;

        System.out.println("\nQual o nível de dificuldade do Bot? (1/2): ");
        escolha = teclado.next().toUpperCase().charAt(0);
    
        while(escolha != '1' && escolha != '2') {
            System.out.println("\nDigite um valor válido (S/N): ");
            escolha = teclado.next().toUpperCase().charAt(0);
        }

        Bot.dificuldade = (escolha == '2') ? true : false;
    }

    private void criarJogadores(Scanner teclado) {

        System.out.println( "\nDigite o modo de jogo:\n" +
                            "(1) 1 Jogador (jogando com o Bot).\n" +
                            "(2) 2 Jogadores.\n");

        char modoDeJogo = teclado.next().toUpperCase().charAt(0);
        while(modoDeJogo != '1' && modoDeJogo != '2') {
            System.out.println("Digite um valor válido (1 ou 2): ");
            modoDeJogo = teclado.next().toUpperCase().charAt(0);
        }

        System.out.println("\nDigite o nome do Jogador 1: ");
        String nomeJogador1 = teclado.next();
    
        System.out.println("\nDigite seu símbolo (X/O): ");
        char simboloJogador1 = teclado.next().toUpperCase().charAt(0);
        
        while(simboloJogador1 != 'X' && simboloJogador1 != 'O') {
            System.out.println("\nDigite um valor válido (X ou O): ");
            simboloJogador1 = teclado.next().toUpperCase().charAt(0);
        }
        
        this.Jogador1 = new Jogador(nomeJogador1, simboloJogador1);

        char simboloJogador2 = (simboloJogador1 == 'X') ? 'O' : 'X';

        if(modoDeJogo == '2') {
            System.out.println("\nDigite o nome do Jogador 2: ");
            String nomeJogador2 = teclado.next();

            this.Jogador2 = new Jogador(nomeJogador2, simboloJogador2);
        }
        else {
            criarBot(teclado, simboloJogador2);
        }
    }

    private void novoJogo(Scanner teclado) {
        limpar.clearConsole();
        System.out.println( "==============================================\n" +
                            "===== Seja bem-vindo ao Jogo da Velha!!! =====\n" +
                            "==============================================");
        
        tabuleiro.Imprimir();

        criarJogadores(teclado);

        jogo = new Jogo(Jogador1, Jogador2, tabuleiro);
        jogo.Jogar(teclado);

        primeiraPartida = false;
        
        Iniciar();
    }

    public void Iniciar() {

        Scanner teclado = new Scanner(System.in);
        
        if(primeiraPartida)
            novoJogo(teclado);
        else {
            limpar.clearConsole();
            System.out.println( "\n==============================================\n" +
                                "===== " + Jogo.Resultado + " =====\n" +
                                "==============================================");
        
            tabuleiro.Imprimir();

            System.out.println( "\nDigite o que deseja fazer:\n" +
                                "(1) Jogar novamente.\n" +
                                "(2) Rever partida anterior.\n" +
                                "(S) Sair.\n");

            char escolha = teclado.next().toUpperCase().charAt(0);

            while(escolha != '1' && escolha != '2' && escolha != 'S') {
                System.out.println("Digite um valor válido: ");
                escolha = teclado.next().toUpperCase().charAt(0);
            }

            switch (escolha) {
                case '1':
                    novoJogo(teclado);
                    break;
                case '2':
                    registro.revisarJogadas(teclado, tabuleiro);
                    Iniciar();
                    break;
                case 'S':
                    System.out.println("Obrigado por jogar! <3\n\n");

                    teclado.close();
                    return;
            }
        }
    }
}
