package com.mygdx.game;

import java.util.Random;

public class Individuo {
    private String genes = "";
    private int aptidao = 0;
    private int pontuacao = 0;

    //gera um indiv�duo aleat�rio
    public Individuo(int numGenes) {
        genes = "";
        Random r = new Random();
        
        String caracteres = Algoritimo.getCaracteres();
       
        
       /* for (int i = 0; i < numGenes; i++) {
            genes += caracteres.charAt(r.nextInt(caracteres.length()));
        }*/
        
        geraAptidao();        
    }

    //cria um indiv�duo com os genes definidos
    public Individuo(String genes) {    
        this.genes = genes;
        
        Random r = new Random();
        //se for mutar, cria um gene aleat�rio
        if (r.nextDouble() <= Algoritimo.getTaxaDeMutacao()) {
            String caracteres = Algoritimo.getCaracteres();
            String geneNovo="";
            int posAleatoria = r.nextInt(genes.length());
            for (int i = 0; i < genes.length(); i++) {
                if (i==posAleatoria){
                    geneNovo += caracteres.charAt(r.nextInt(caracteres.length()));
                }else{
                    geneNovo += genes.charAt(i);
                }
                
            }
            this.genes = geneNovo;   
        }
        geraAptidao();
    }

    //gera o valor de aptid�o, ser� calculada pelo n�mero de bits do gene iguais ao da solu��o
    private void geraAptidao() {
        String solucao = Algoritimo.getSolucao();
        for (int i = 0; i < solucao.length(); i++) {
            if (solucao.charAt(i) == genes.charAt(i)) {
                aptidao++;
            }
        }
    }

    public int getAptidao() {
        return aptidao;
    }

    public String getGenes() {
        return genes;
    }
}
