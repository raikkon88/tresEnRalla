/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenralla;

/**
 *
 * @author marc
 */
public class Tauler {

    protected char[][] tauler;
    
    public Tauler(int n){
        tauler = new char[n][n];
        inicialitza();
    }
    
    public Tauler(int files, int columnes){
        tauler = new char[files][columnes];
        inicialitza();
    }
    
    private void inicialitza(){
        for(int i = 0; i < tauler.length; i++){
            for(int j = 0; j < tauler[i].length; j++){
                tauler[i][j] = ' ';
            }
        }
    }
    
    public void inserta(int fila, int columna, char c) throws Exception{
        if(fila < 0 || fila >= tauler.length){
            throw new Exception("la Fila a inserir és incorrecte");
        }
        if(columna < 0 || columna >= tauler[0].length){
            throw new Exception("la Columna0 a inserir és incorrecte");            
        }
        
        tauler[fila][columna] = c;
    }
    
    
    
    public boolean mateixCaracterFila(int f){
        boolean mateixCaracter = true;
        int i = 0;
        while(mateixCaracter && i+1 < tauler.length){
            mateixCaracter = tauler[f][i] == tauler[f][i+1] && tauler[f][i] != ' '; 
            i++;
        }
        return mateixCaracter;
    }
    
    public boolean mateixCaracterColumna(int c){
        boolean mateixCaracter = true;
        int i = 0;
        while(mateixCaracter && i+1 < tauler[i].length){
            mateixCaracter = tauler[i][c] == tauler[i+1][c] && tauler[i][c] != ' '; 
            i++;
        }
        return mateixCaracter;
    }
    
    public boolean mateixCaracterDiagonals(){
        boolean mateixCaracterEsqDre = true;
        boolean mateixCaracterDreEsq = true;
        int i = 0;
        while((i+1 < tauler.length) && (mateixCaracterEsqDre || mateixCaracterDreEsq)){
            if(mateixCaracterEsqDre)
                mateixCaracterEsqDre = tauler[i][i] == tauler[i+1][i+1] && tauler[i][i] != ' '; 
            
            if (mateixCaracterDreEsq)
                mateixCaracterDreEsq = tauler[i][tauler.length - i - 1] == tauler[i + 1][tauler.length - (i + 1) - 1] && tauler[i][tauler.length - i - 1] != ' '; 
            
            i++;
        }
        return (mateixCaracterEsqDre || mateixCaracterDreEsq);
    }
    
    @Override
    public String toString(){
        String t = "";
        for(int i = 0; i < tauler.length * 2 + 1; i++){
            t+="-";
        }
        for(int i = 0; i < tauler.length; i++){
            t += "\n|";
            for(int j = 0; j < tauler.length; j++){
                t += tauler[i][j] + "|";
            }
            t += "\n";
            for(int k = 0; k < tauler.length * 2 + 1; k++){
                t+="-";
            }   
        }
        return t;
    }
    
    
}
