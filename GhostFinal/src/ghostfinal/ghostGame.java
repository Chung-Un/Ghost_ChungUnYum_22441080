/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ghostfinal;

import java.util.Scanner;

/**
 *
 * @author chung
 */

public class ghostGame {
 
String[][] tablero;
String[][] fantasmas;
String player2;
int fantasmasplayer1=0;
int fantasmasplayer2=0;
int turnos=1;
Scanner entrada = new Scanner(System.in);



public String[][] hacerTablero(int opcionUsuario){
String[][] tablero = null;
    
    switch (opcionUsuario) {
        case 1:
            tablero = new String[][]{{"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                
            };      break;
        case 2:
            tablero = new String[][] {
                {"-","-","-","-",},
                {"-","-","-","-",},
                {"-","-","-","-",},
                {"-","-","-","-",},
                {"-","-","-","-",},
                {"-","-","-","-",}
            };
            break;
        case 3:
            tablero = new String[][]{
                {"-","-","-"},
                {"-","-","-"},
                {"-","-","-"}
            };
            break;
        default:
            
            break;
    }
    
    fantasmas = new String [tablero.length][tablero[0].length];
    
    for(int i = 0 ; i<fantasmas.length; i++){
        for (int j=0; j<fantasmas[i].length;j++){
        fantasmas[i][j] ="-";
        }
    }
    
return tablero;
}
 

public int configuracion(int opcionUsuario){
   int maxFantasmas=0;
   
   if(opcionUsuario==1){
   maxFantasmas=8;
   }
   else if(opcionUsuario == 2){
   maxFantasmas=4;
   }
   else if(opcionUsuario==3){
   maxFantasmas=2;
   }
   return maxFantasmas;
}
   

public String player2(){
String jugador2;

System.out.println("Ingrese el nombre del jugador contra el que desea jugar: ");
jugador2 = entrada.nextLine();

return jugador2;
}


public void iniciarJuego(Player player, Player player2, int maxFantasmas ){
    int turnos =2;
    String turnoJugador;
    turnoJugador = (turnos==1) ? player.usuario : player2.usuario;
    
    while(player.cantFantasmas<maxFantasmas && player2.cantFantasmas<maxFantasmas){
    imprimirTablero();
    System.out.println("Turno de: " + turnoJugador);
    
    tablero = colocarFantasmas(turnos);
    
    turnos = (turnos==1) ? 2 :1;
    }


}


public String[][] colocarFantasmas(int turnos){
    
int fila, columna;
String tipo=""; 

System.out.println("Ingrese la fila en la que desea colocar su fantasma: ");
fila = entrada.nextInt()-1;
entrada.nextLine();

System.out.println("Ingrese la columna en la cual desea colocar su fantasma: ");
columna = entrada.nextInt()-1;
entrada.nextLine();

while(!tipo.equals("bueno") && !tipo.equals("malo")){
System.out.println("Ingrese el tipo de fanstama que desea colocar(bueno/malo)");
tipo= entrada.nextLine().toLowerCase();
}

if(tablero[fila][columna].equals("-")){
if(tipo.equals("bueno") || tipo.equals("malo")){
fantasmas[fila][columna] = tipo.equals("bueno") ? "b" : "m";
tablero[fila][columna] = "X";


}}  
else if(fila<=0 || columna<=0 || fila>=tablero.length || columna >= tablero[0].length){
System.out.println("Las coordenadas no existen.");
return tablero;
}
else if(!tablero[fila][columna].equals("-")){
System.out.println("La coordenada ya se encuentra en uso.");
return tablero;
}

    

return tablero;
}




 public void imprimirTablero(){
 for (int i=0 ; i < tablero.length;i++){
     for (int x=0 ; x<tablero[i].length; x++){
     System.out.print(tablero[i][x] + " ");
     }
 System.out.println();
 }

 }
 
 
 
 
 
 
}
