package com.robert.jogodavelha;

import java.util.Scanner;

public class Ponto {

    private int[] ponto;
    private String pontoString;

    public Ponto() {
        ponto = new int[2];
    }

    private boolean verificacao(String pontoString) {
        if(pontoString.charAt(0) != '(' || pontoString.charAt(pontoString.length()-1) != ')')
            return false;
        
        String[] coordenadas = pontoString.substring(1, pontoString.length()-1).split(",");
        if(coordenadas.length != 2 || coordenadas[0].length() != 1 || coordenadas[1].length() != 1)
            return false;
        
        for(int i = 0; i < 2; i++) {
            if(coordenadas[i].charAt(0) < '1' || coordenadas[i].charAt(0) > '3')
                return false;

            ponto[i] = Integer.parseInt(coordenadas[i]);
        }
        return true;
    }
    
    public int[] Posicao(Scanner teclado) {
        pontoString = teclado.next();

        while(!verificacao(pontoString)) {
            System.out.println("\nDigite uma posição válida: ");
            System.out.println("Escreva desta forma (linha,coluna) com os () e sem espaços.");
            pontoString = teclado.next();
        }

        return ponto;
    }
}
