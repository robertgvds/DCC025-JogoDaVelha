package com.robert.jogodavelha;

public class Gerador {

    private Tabuleiro tabuleiro;
    private char simbolo;

    public Gerador(char simbolo) {
        this.tabuleiro = new Tabuleiro();
        this.simbolo = simbolo;
    }

    private int[] verificaLinha(char simbolo) {
    
        for(int linha = 0; linha < 3; linha++) {

            if((tabuleiro.getValor(linha, 0) == simbolo &&
                tabuleiro.getValor(linha, 0) == tabuleiro.getValor(linha, 1) && tabuleiro.getValor(linha, 2) == ' '))
                return new int[]{linha+1, 3};

            if((tabuleiro.getValor(linha, 1) == simbolo &&
                tabuleiro.getValor(linha, 1) == tabuleiro.getValor(linha, 2) && tabuleiro.getValor(linha, 0) == ' '))
                return new int[]{linha+1, 1};

            if((tabuleiro.getValor(linha, 2) == simbolo &&
                tabuleiro.getValor(linha, 2) == tabuleiro.getValor(linha, 0) && tabuleiro.getValor(linha, 1) == ' '))
                return new int[]{linha+1, 2};
        }
        
        return null;
    }

    private int[] verificaColuna(char simbolo) {
    
        for(int coluna = 0; coluna < 3; coluna++) {

            if((tabuleiro.getValor(0, coluna) == simbolo &&
                tabuleiro.getValor(0, coluna) == tabuleiro.getValor(1, coluna) && tabuleiro.getValor(2, coluna) == ' '))
                return new int[]{3, coluna+1};
            
            if((tabuleiro.getValor(1, coluna) == simbolo &&
                tabuleiro.getValor(1, coluna) == tabuleiro.getValor(2, coluna) && tabuleiro.getValor(0, coluna) == ' '))
                return new int[]{1, coluna+1};
            
            if((tabuleiro.getValor(2, coluna) == simbolo &&
                tabuleiro.getValor(2, coluna) == tabuleiro.getValor(0, coluna) && tabuleiro.getValor(1, coluna) == ' '))
                return new int[]{2, coluna+1};
        }
        
        return null;
    }

    private int[] verificaDiagonal(char simbolo) {
        if((tabuleiro.getValor(0,0) == simbolo &&
            tabuleiro.getValor(0, 0) == tabuleiro.getValor(1, 1) && tabuleiro.getValor(2, 2) == ' '))
            return new int[]{3, 3};
        
        if((tabuleiro.getValor(1, 1) == simbolo &&
            tabuleiro.getValor(1, 1) == tabuleiro.getValor(2, 2) && tabuleiro.getValor(0, 0) == ' '))
            return new int[]{1, 1};
        
        if((tabuleiro.getValor(2, 2) == simbolo &&
            tabuleiro.getValor(2, 2) == tabuleiro.getValor(0, 0) && tabuleiro.getValor(1, 1) == ' '))
            return new int[]{2, 2};
        
        if((tabuleiro.getValor(0,2) == simbolo &&
            tabuleiro.getValor(0, 2) == tabuleiro.getValor(1, 1) && tabuleiro.getValor(2, 0) == ' '))
            return new int[]{3, 1};
        
        if((tabuleiro.getValor(1, 1) == simbolo &&
            tabuleiro.getValor(1, 1) == tabuleiro.getValor(2, 0) && tabuleiro.getValor(0, 2) == ' '))
            return new int[]{1, 3};
        
        if((tabuleiro.getValor(2, 0) == simbolo &&
            tabuleiro.getValor(2, 0) == tabuleiro.getValor(0, 2) && tabuleiro.getValor(1, 1) == ' '))
            return new int[]{2, 2};
        
        return null;
    }

    public int[] posicaoInteligente() {
        char[] simbolos = new char[2];

        simbolos[0] = this.simbolo;
        simbolos[1] = (this.simbolo == 'X') ? 'O' : 'X';

        //Primeiro tenta ganhar, depois tenta atrapalhar o jogador
        for(char simbolo : simbolos) {
            if(verificaLinha(simbolo) != null) {
                return verificaLinha(simbolo);}

            if(verificaColuna(simbolo) != null) {
                return verificaColuna(simbolo);}

            if(verificaDiagonal(simbolo) != null) {
                return verificaDiagonal(simbolo);}
        }

        return null;
    }
}
