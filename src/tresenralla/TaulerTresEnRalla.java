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
public class TaulerTresEnRalla extends Tauler {
    
    public TaulerTresEnRalla(int n) {
        super(n);
    }
    
    /**
     * Retorna cert si es compleix que en una fila, una columa o una de les dues diagonals hi ha el mateix caràcter
     * @return cert si es compleix, falç altrament.
     */
    public boolean esTresEnRalla(){
        boolean tresEnRalla = false;
        int i = 0;
        while(i < tauler.length && !tresEnRalla){
            tresEnRalla = mateixCaracterFila(i) ||  mateixCaracterColumna(i);
            i++;
        }
        return tresEnRalla || mateixCaracterDiagonals();
    }

}
