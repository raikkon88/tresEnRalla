/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenralla;

import java.util.Scanner;

/**
 *
 * @author marc
 */
public class TresEnRalla {

    private static final char CARACTER_JUGADOR_1 = 'X';
    private static final char CARACTER_JUGADOR_2 = 'O';
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        TaulerTresEnRalla tauler  =new TaulerTresEnRalla(3);
        Scanner scanner = new Scanner(System.in);
        //System.out.println(tauler.toString());
        String jugador1 = demanaNomJugador(scanner, 1);
        String jugador2 = demanaNomJugador(scanner, 2);
        
        juga(jugador1, jugador2, tauler, scanner);
    }
    
    
    public static String demanaNomJugador(Scanner scanner, int n){
        System.out.println("Entra el nom del jugador " + n);
        return scanner.nextLine();
    }
    
    public static void juga(String jugador1, String jugador2, TaulerTresEnRalla tauler, Scanner scanner) throws Exception{
        
        int tirada = 0;
        boolean tresEnRalla = false;
        while(!tresEnRalla && tirada < 9){
            int jugadorQueTira = tirada % 2 + 1;
            System.out.println(tauler.toString());
            if(jugadorQueTira == 1){
                tresEnRalla = tira(jugador1, scanner, tauler, CARACTER_JUGADOR_1);
            }
            else{
                tresEnRalla = tira(jugador2, scanner, tauler, CARACTER_JUGADOR_2);
            }
           
            tirada++;
        }
        if(tresEnRalla){
            if((tirada - 1) % 2 == 0) 
                System.out.println("El/La guanyador/a és : "+ jugador1);
            else 
                System.out.println("El/La guanyador/a és : "+ jugador2);
            
        }
        else{
            System.out.println("Hi ha hagut un empat.");
        }
        
    }
    
    public static boolean tira(String jugador, Scanner scanner, TaulerTresEnRalla tauler, char caracater) throws Exception{
        System.out.println("Li toca tirar al jugador " + jugador);
        System.out.println("Insereix la fila, recorda que ha de ser entre [0 i 2]");
        String fila = scanner.nextLine();
        System.out.println("Insereix la columna, recorda que ha de ser entre [0 i 2]");
        String columna = scanner.nextLine();
        tauler.inserta(Integer.parseInt(fila), Integer.parseInt(columna), caracater);
        return tauler.esTresEnRalla();
    }
    
    
    
    
}
