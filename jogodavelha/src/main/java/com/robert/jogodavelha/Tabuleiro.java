
package com.robert.jogodavelha;

public class Tabuleiro {
    private static char[][] tabuleiro;
    private static int numJogadas;

    Tabuleiro() {
        tabuleiro = new char[3][3];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                tabuleiro[i][j] = ' ';
            }
        }
        
        numJogadas = 1;
    }

    public static int getJogada() {
        return numJogadas;
    }

    public char getValor(int i, int j) {
        return tabuleiro[i][j];
    }

    public void Imprimir() {

        System.out.println("\n   1   2   3");

        for(int i = 0; i < 3; i++) {
            System.out.print((i+1) + " ");

            for(int j = 0; j < 3; j++) {

                System.out.print(" " + tabuleiro[i][j] + " ");
                if(j != 2)
                    System.out.print("|");
            }

            if(i != 2)
                System.out.println("\n  ---|---|---");
        }

        System.out.println();
    }

    public boolean Valido(char simbolo, int linha, int coluna) {
        
        if( linha >= 1 && linha <= 3 &&
            coluna >= 1 && coluna <= 3 &&
            tabuleiro[linha-1][coluna-1] == ' ') {
            
            tabuleiro[linha-1][coluna-1] = simbolo;
            numJogadas+=1;

            Registro.setJogada(simbolo, linha, coluna);

            return true;
        }

        return false;
    }

    public boolean fimDeJogo(char simbolo) {

        for(int i = 0; i < 3; i++) {

            if( tabuleiro[i][0] == simbolo &&
                (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2]))
                return true;

            if( tabuleiro[0][i] == simbolo &&
                (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i]))
                return true;
        }
        
        if( tabuleiro[0][0] == simbolo &&
            (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2]))
            return true;

        if( tabuleiro[0][2] == simbolo &&
            (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0]))
            return true;

        return false;
    }

    public boolean Empate() {
        if(numJogadas > 9)
            return true;

        return false;
    }

    public void reset(char simbolo, int linha, int coluna) {
        tabuleiro[linha-1][coluna-1] = simbolo;
    }
}
