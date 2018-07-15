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
