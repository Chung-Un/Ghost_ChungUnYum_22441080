/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ghostfinal;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chung
 */

public class ghostGame {
 
String[][] fantasmas;
String player2Nombre;
int fantasmasplayer1=0;
int fantasmasplayer2=0;
Random randomfilaPlayer1 = new Random((1-0)+0);
Random randomfilaPlayer2 = new Random((5-4) + 4);
Random randomcolumna = new Random((4-1) + 1);
int turnos=1;
Scanner entrada = new Scanner(System.in);


String[][] tablero = new String[][]{
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"}
};
    
   
    public String[][] hacerTablero(){   
    fantasmas = new String [tablero.length][tablero[0].length];
    
    for(int i = 0 ; i<fantasmas.length; i++){
        for (int j=0; j<fantasmas[i].length;j++){
        fantasmas[i][j] ="-";
        }
    }
    
return tablero;
}

public String modo(int opcionUsuario){
String modo="";

switch(opcionUsuario){
    case 1:
        modo="aleatorio";
        break;
        
    case 2:
        modo= "manual";

}
return modo;
}


public void separador(){
System.out.println();
System.out.println();
  }

public void configuracion(int opcionUsuario, Player player1) {

    switch (opcionUsuario) {
        case 1:
            player1.maxFantasmas = 8;
            break;
        case 2:
            player1.maxFantasmas = 4;
            break;
        case 3:
            player1.maxFantasmas =2;
            break;
        default:
            System.out.println("Opcion invalida");
            break;
    }

}


public void cantFantasmasTipo(int maxFantasmas, Player player1, Player player2) {
    int cantFantasmasTipo = maxFantasmas / 2;

    player1.setCantFantasmasBuenos(cantFantasmasTipo);
    player1.setCantFantasmasMalos(cantFantasmasTipo);
    player2.setCantFantasmasBuenos(cantFantasmasTipo);
    player2.setCantFantasmasMalos(cantFantasmasTipo);
}

public String player2(){
String jugador2;

System.out.println("Ingrese el nombre del jugador contra el que desea jugar: ");
jugador2 = entrada.nextLine();

return jugador2;
}

public void jugar(String modo, Player player1, Player player2){
    switch(modo){
        case "aleatorio":
            break;
        case "manual":
            iniciarJuegoManual(player1, player2);
    }
    
}

public void iniciarJuegoManual(Player player1, Player player2){
    
    player2.setCantFantasmas(player1.cantFantasmas);
    player2.setMaxFantasmas(player1.maxFantasmas);
    
    String turnoJugador;
    turnoJugador = player1.usuario;
    System.out.println("==========Colocacion de fantasmas==========");
    
    while (player1.cantFantasmas < player1.maxFantasmas || player2.cantFantasmas < player2.maxFantasmas) {
        if (turnos == 1 && player1.cantFantasmas < player1.maxFantasmas) {
            System.out.println("Turno de: " + player1.usuario);
            imprimirTablero();
            tablero = colocarFantasmas(turnos, player1, player2);
            turnos = 2;
        } else if (turnos == 2 && player2.cantFantasmas < player2.maxFantasmas) {
            System.out.println("Turno de: " + player2.usuario);
            imprimirTablero();
            tablero = colocarFantasmas(turnos, player1, player2);
            turnos = 1;
        }
        separador();
        
    }
    
    System.out.println("Colocacion de fantasmas terminada");
    separador();
    
    }
    public void iniciarJuegoAleatorio(Player player1, Player player2){
    player2.setCantFantasmas(player1.cantFantasmas);
    player2.setMaxFantasmas(player1.maxFantasmas);
    int fila=0,columna=0;
    
    for(int i=0; player1.cantFantasmas<=i;i++){
    do{
    
    
    }while(!coordenadaValida(fila,columna));
    tablero[randomfilaPlayer1.nextInt()][randomcolumna.nextInt()] = "F1";
    
    
    }
    for(int i=0; player2.cantFantasmas<=i;i++){
    tablero[randomfilaPlayer2.nextInt()][randomcolumna.nextInt()] = "F2";
    }
    
    
    }

    public void juego(Player player1, Player player2){
    int nuevaFila=0,nuevaColumna=0,columna, fila=0;
    String turnoJugador = player1.usuario;
    
    System.out.println("=======GAME START========");
    
    while(!ganar(player1,player2)){
    System.out.println("Turno de: " + turnoJugador);
    imprimirTablero();    
    
    fila = pedirFilaCambio();
    columna = pedirColumnaCambio();
    nuevaFila = moverFantasmasFila();
    nuevaColumna = moverFantasmasColumna();
    
    while (true){
    if(!fantasmaSobreescrito(nuevaFila,nuevaColumna) && movimientoValido(fila, columna, nuevaFila,nuevaColumna)){
    movimiento(columna,fila,nuevaFila,nuevaColumna);
    comer(columna,fila,nuevaFila,nuevaColumna,player1,player2);
    break;
    }
    else{
    System.out.println("1.Ingresar otra coordenada\n2.Seleccionar otro fantasma a mover");
    int opcion= entrada.nextInt();
    
    switch(opcion){
    
        case 1:
            nuevaFila = moverFantasmasFila();
            nuevaColumna = moverFantasmasColumna();
            continue;
            
        case 2:
            fila = pedirFila();
            columna=pedirColumna();
            nuevaFila= moverFantasmasFila();
            nuevaColumna = moverFantasmasColumna();
            continue;
                    
    
    }
   
    }}
    turnos = ((turnos==1) ? 2 : 1);
    turnoJugador = (turnos==1) ? player1.usuario : player2.usuario;
    separador();
        
    }}
    
    public void movimiento(int columna, int fila, int nuevaFila, int nuevaColumna){
    
     switch(turnos){
         
         case 1: 
         tablero[fila][columna] = "-";
         tablero[nuevaFila][nuevaColumna] = "F1";
         
         case 2:
         tablero[fila][columna] = "-";
         tablero[nuevaFila][nuevaColumna] = "F2";
    
     }
    }
    
    public void comer (int columna, int fila, int nuevaFila, int nuevaColumna, Player player1, Player player2){
        String tipo="";
        switch(turnos){
        case 1:
        if(tablero[nuevaFila][nuevaColumna].equals("F2")){
            if (fantasmas[nuevaFila][nuevaColumna].equals("b1")){
            player1.fantasmasBuenosCapturados++;
            tipo = "bueno";
            System.out.println(player1.usuario + "se ha comido un fantasma " + tipo + "de " + player2.usuario);
            }
        else if(fantasmas[nuevaFila][nuevaColumna].equals("m1")){
            player1.fantasmasMalosCapturados++;
            tipo= "malo";
            System.out.println(player1.usuario + "se ha comido un fantasma " + tipo + "de " + player2.usuario);
            }
        }
        else{
        break;
        }
        
        break;
            
        case 2:
        if(tablero[nuevaFila][nuevaColumna].equals("F1")){
            if(fantasmas[nuevaFila][nuevaColumna].equals("b2")){
            player2.fantasmasBuenosCapturados++;
            tipo="bueno";
            System.out.println(player2.usuario + "se ha comida un fantasma " + tipo + "de " + player1.usuario);
            }
            else if(fantasmas[nuevaFila][nuevaColumna].equals("m2")){
            player2.fantasmasMalosCapturados++;
            tipo="malo";
            System.out.println(player2.usuario + "se ha comida un fantasma " + tipo + "de " + player1.usuario);
            }
            else{
            break;
            }
        }
        break;
        }}
    
    
    
    
    public boolean fantasmaSale(Player player1, Player player2){
       
    if(tablero[5][0].equals("F1") || tablero[5][5].equals("F1")){
    System.out.println(player1.usuario + "ha salido del castilo!");
    return true;
    }
    else if(tablero[0][0].equals("F2") || tablero[0][5].equals("F2")){
    System.out.println(player2.usuario + "ha salido del castillo!");
    return true;
    }
    else{   
        
    return false;
    }
    }
    
    public boolean ganar(Player player1, Player player2){
    
    if(player1.fantasmasBuenosCapturados ==(player2.maxFantasmas/2)){
    return true;
    }
    else if(player1.cantFantasmasMalos == 0 || player2.cantFantasmasMalos==0){
    return true;
    }
    else if(player1.fantasmaSale || player2.fantasmaSale){
    return true;
    }
    else if(player2.fantasmasBuenosCapturados == (player1.maxFantasmas/2)){
    return true;
    }
    else if(player2.cantFantasmasMalos ==0){
    return true;
    }
    
    return false;    
    }
    
    int pedirFila(){
    int fila=0;
    System.out.println("Ingrese la fila donde desea colocar su fantasma: ");
    fila = entrada.nextInt() - 1;
    entrada.nextLine();

    return fila;
    
    }

    int pedirColumna(){
    System.out.println("Ingrese la columna donde desea colocar su fantasma: ");
    int columna = entrada.nextInt() - 1;
    entrada.nextLine();
    return columna;
}

    int pedirFilaCambio(){
    int fila=0;
    
    System.out.println("Ingrese la fila del fantasma que desea mover: ");
    fila = entrada.nextInt()-1;
    entrada.nextLine();
    
    return fila;
    }
    
    int pedirColumnaCambio(){
        
    System.out.println("Ingrese la columna del fantasma que desea mover: ");
    int columna = entrada.nextInt() - 1;
    entrada.nextLine();
    return columna;
    
    }
    public String[][] colocarFantasmas(int turnos, Player player1, Player player2) {
    int fila=-1, columna=-1;
    String tipo;
    
    if (turnos == 1){
       tipo = (player1.cantFantasmas % 2 == 0) ? "bueno" : "malo";
        } 
    else {
        tipo = (player2.cantFantasmas % 2 == 0) ? "bueno" : "malo";
      }
    
    
    if ((turnos == 1 && player1.cantFantasmas >= player1.maxFantasmas) || 
        (turnos == 2 && player2.cantFantasmas >= player2.maxFantasmas)) {
        return tablero; 
    }
    
    do{
    System.out.println("Ingrese su fantasma " + tipo);
    fila = pedirFila();
    columna = pedirColumna();
   
        
        boolean valida = coordenadaValida(fila, columna);
        
        if(valida){
        registroColocar(player1, player2, turnos);
        break;
        }
        else if(!valida){
        continue;
        }
     
        else {
            System.out.println("La coordenada no es valida, intente de nuevo");
            continue;
        }
        } while (true);
    
        return tablero;
    
        
        
    }
    
    
    public String[][] colocar(String[][] fantasmas, int fila, int columna, String tipo){
    
        
        if(turnos==1){
        fantasmas[fila][columna] = tipo.equals("bueno") ? "b1" : "m1";
        tablero[fila][columna] = "F1";
        }
        
        if(turnos==2){
        fantasmas[fila][columna] = tipo.equals("bueno") ? "b2" : "m2";
        tablero[fila][columna] = "F2";
        }
        return tablero;
        }

    void registroColocar(Player player1, Player player2,int turnos){
    switch (turnos) {
        case 1:
            
            player1.cantFantasmas++;
            System.out.println("Cantidad de fantasmas por colocar de " + player1.usuario + ": " + (player1.maxFantasmas - player1.cantFantasmas));
            break;
            
        
        case 2:
   
            player2.cantFantasmas++;
            System.out.println("Cantidad de fantasmas por colocar de " + player2.usuario + ": " + (player2.maxFantasmas - player2.cantFantasmas));
            break;

    }
    
    }



    public boolean coordenadaValida(int fila, int columna) {
        
    if (fila < 0 || columna < 0 || fila >= tablero.length || columna >= tablero[0].length) {
        System.out.println("Las coordenadas no existen.");
        
        return false;
    } 
    if (!tablero[fila][columna].equals("-")) {
        System.out.println("La coordenada ya se encuentra en uso.");
        return false;
        
    } 
    if ((columna == 0 || columna == 5) && (fila == 0 || fila == 5)) {
        System.out.println("La coordenada es una salida y no puede colocar fantasmas en ellas.");
        return false;
        
    } 
    if (turnos == 1 && fila > 2) {
        System.out.println("No puede inicializar fantasmas fuera de su area (filas 1 a 2).");
        return false;
        
    } else if (turnos == 2 && fila < 3) {
        System.out.println("No puede inicializar fantasmas fuera de su area (filas 5 a 6).");
        return false;
        
    }
    
    colocar(fantasmas, fila, columna, tipo); 
    return true;
    
}



    public void imprimirTablero(){
    for (int i=0 ; i < tablero.length;i++){
        for (int x=0 ; x<tablero[i].length; x++){
        System.out.print(tablero[i][x] + " ");
        }
    System.out.println();
    }

    }

    public int moverFantasmasFila(){
    int fila, nuevaFila;
    
    System.out.println("Ingrese la fila donde desea mover el fantasma: ");
    nuevaFila = entrada.nextInt()-1;

    return nuevaFila;
    }

    public int moverFantasmasColumna(){
    int columna, nuevaColumna;
    
    System.out.println("Ingrese la columna donde desea mover el fantasma: ");
    nuevaColumna = entrada.nextInt()-1;

    return nuevaColumna;
    }

   public boolean fantasmaSobreescrito(int nuevaFila, int nuevaColumna) {
   
       switch (turnos) {
           case 1:
               if (tablero[nuevaFila][nuevaColumna].equals("F1")) {
                   System.out.println("Ya hay un fantasma de su propiedad en esa coordenada");
                   return true;
               } else {
                   return false;
               }

           case 2:
               if (tablero[nuevaFila][nuevaColumna].equals("F2")) {
                   System.out.println("Ya hay un fantasma de su propiedad en esa coordenada");
                   return true;
               }
               return false;

           default: 
               return false;
       }
   }

    public boolean movimientoValido(int fila, int columna,int nuevaFila, int nuevaColumna){
       int restasFilas =Math.abs( fila - nuevaFila);
       int restasColumnas = Math.abs(columna-nuevaColumna);
       
       if (nuevaFila < 0 || nuevaColumna < 0 || nuevaFila >= tablero.length || nuevaColumna >= tablero[0].length) {
           System.out.println("Las coordenadas no existen. ");
           return false;
       } 
       else if((restasFilas == 1 && restasColumnas==0) || (restasColumnas == 1 && restasFilas == 0)){
       return true;
       }
       else {
       System.out.println("Movimiento no valido");
       }
       return true;
        }
        }
