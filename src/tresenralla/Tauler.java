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
    
    /**
     * Instancia tots els caràcters de la matriu tauler amb un càrcater en blanc. 
     */
    private void inicialitza(){
        for(int i = 0; i < tauler.length; i++){
            for(int j = 0; j < tauler[i].length; j++){
                tauler[i][j] = ' ';
            }
        }
    }
    
    /**
     * Insereix c a la fila fila i columna columna.
     * @param fila Fila del tauler a inserir
     * @param columna Columna del tauler a inserir
     * @param c Caràcters que s'inserirà
     * @throws Exception En cas que s'intenti accedir a una posició de la matriu que no existeix. 
     */
    public void inserta(int fila, int columna, char c) throws Exception{
        if(fila < 0 || fila >= tauler.length){
            throw new Exception("la Fila a inserir és incorrecte");
        }
        if(columna < 0 || columna >= tauler[0].length){
            throw new Exception("la Columna0 a inserir és incorrecte");            
        }
        
        tauler[fila][columna] = c;
    }
    
    
    /**
     * Verifica que a la fila número f tots els caràcters siguin iguals (diferent de un espai.)
     * @param f fila que s'ha de vigilar
     * @return cert si es compleix. falç altrament.
     */
    public boolean mateixCaracterFila(int f){
        boolean mateixCaracter = true;
        int i = 0;
        while(mateixCaracter && i+1 < tauler.length){
            mateixCaracter = tauler[f][i] == tauler[f][i+1] && tauler[f][i] != ' '; 
            i++;
        }
        return mateixCaracter;
    }
    
    /**
     * Verifica que a la columna número c tots els caràcters siguin iguals (diferent de un espai.)
     * @param c columna que s'ha de vigilar
     * @return cert si es compleix. falç altrament.
     */
    public boolean mateixCaracterColumna(int c){
        boolean mateixCaracter = true;
        int i = 0;
        while(mateixCaracter && i+1 < tauler[i].length){
            mateixCaracter = tauler[i][c] == tauler[i+1][c] && tauler[i][c] != ' '; 
            i++;
        }
        return mateixCaracter;
    }
    
    /**
     * Verifica que a tota la diagonal de la matriu hi ha el mateix caràter. (la diagonal inversa també)
     * @return cert si es compleix, falç altrament.
     */
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
