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
Random random = new Random();
int turnos=1;
Scanner entrada = new Scanner(System.in);


String[][] tablero = new String[][]{
                {"X","-","-","-","-","X"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"-","-","-","-","-","-"},
                {"X","-","-","-","-","X"}
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


public void cantFantasmasTipo(Player player1, Player player2) {
    int cantFantasmasTipo = player1.maxFantasmas / 2;
    player1.cantFantasmasBuenos = cantFantasmasTipo;
    player1.cantFantasmasMalos = (cantFantasmasTipo);
    player2.cantFantasmasBuenos = (cantFantasmasTipo);
    player2.cantFantasmasMalos = (cantFantasmasTipo);
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
            cantFantasmasTipo(player1,player2) ;
            iniciarJuegoAleatorio(player1, player2);
            juego(player1, player2);
            break;
        case "manual":
            cantFantasmasTipo(player1,player2) ;
            iniciarJuegoManual(player1, player2);
            juego(player1, player2);
            break;
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
   
    colocarFantasmasAleatorios(player1,player2);
    
    
    }

    public void juego(Player player1, Player player2){
    int nuevaFila=0,nuevaColumna=0,columna, fila=0;
    String turnoJugador = player1.usuario;
    turnos=1;
    
    System.out.println("=======GAME START========");
    
    while(!ganar(player1,player2)){
    System.out.println("Turno de: " + turnoJugador);
    imprimirTablero();    
    mostrarFantasmas();
    progreso(player1,player2);

    fila = pedirFilaCambio();
    columna = pedirColumnaCambio();
    nuevaFila = moverFantasmasFila();
    nuevaColumna = moverFantasmasColumna();
    fantasmaSale(player1,player2);
    if(player1.fantasmaSale || player2.fantasmaSale){
    break;
    }
    
    
    while (true){
    if(!fantasmaSobreescrito(nuevaFila,nuevaColumna) && movimientoValido(fila, columna, nuevaFila,nuevaColumna)){
    comer(columna,fila,nuevaFila,nuevaColumna,player1,player2);
    movimiento(columna,fila,nuevaFila,nuevaColumna);
    turnos = ((turnos==1) ? 2 : 1);
    turnoJugador = (turnos==1) ? player1.usuario : player2.usuario;

    separador();
        
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
            fila = pedirFilaCambio();
            columna=pedirColumnaCambio();
            nuevaFila= moverFantasmasFila();
            nuevaColumna = moverFantasmasColumna();
            continue;
            
                    
    
    }
   
    }}
    
    }}
    
    public void movimiento(int columna, int fila, int nuevaFila, int nuevaColumna){
    String tipo="";
    
    if (turnos == 1) {
        tipo = (fantasmas[fila][columna].equals("b1") || fantasmas[fila][columna].equals("b2")) ? "bueno" : "malo";
    } else {
        tipo = (fantasmas[fila][columna].equals("b1") || fantasmas[fila][columna].equals("b2")) ? "bueno" : "malo";
    }
        
     switch(turnos){
         
         case 1: 
         tablero[fila][columna] = "-";
         fantasmas[fila][columna] = "-";
         tablero[nuevaFila][nuevaColumna] = "F1";
         fantasmas[nuevaFila][nuevaColumna] = tipo.equals("bueno") ? "b1" : "m1";
         break;
         
         case 2:
         tablero[fila][columna] = "-";
         fantasmas[fila][columna]="-";
         tablero[nuevaFila][nuevaColumna] = "F2";
         fantasmas[nuevaFila][nuevaColumna] = tipo.equals("bueno") ? "b2" : "m2";
         break;
    
     }
    }
    
    public void comer (int columna, int fila, int nuevaFila, int nuevaColumna, Player player1, Player player2){
       String tipo="";
       
        switch(turnos){
        case 1:
        if(tablero[nuevaFila][nuevaColumna].equals("F2")){
            if (fantasmas[nuevaFila][nuevaColumna].equals("b2")){
            player1.fantasmasBuenosCapturados++;
            player2.cantFantasmasBuenos--;
            tipo = "bueno";
            System.out.println(player1.usuario + "  se ha comido un fantasma " + tipo + "  de  " + player2.usuario);
            separador();
            }
        else if(fantasmas[nuevaFila][nuevaColumna].equals("m2")){
            player1.fantasmasMalosCapturados++;
            player2.cantFantasmasMalos--;
            tipo= "malo";
            System.out.println(player1.usuario + "  se ha comido un fantasma  " + tipo + "  de  " + player2.usuario);
            separador();
            }
        }
        else{
        break;
        }
        
        break;
            
        case 2:
        if(tablero[nuevaFila][nuevaColumna].equals("F1")){
            if(fantasmas[nuevaFila][nuevaColumna].equals("b1")){
            player2.fantasmasBuenosCapturados++;
            player1.cantFantasmasBuenos--;
            tipo="bueno";
            System.out.println(player2.usuario + " se ha comida un fantasma " + tipo + " de " + player1.usuario);
            separador();
            }
            else if(fantasmas[nuevaFila][nuevaColumna].equals("m1")){
            player2.fantasmasMalosCapturados++;
            player1.cantFantasmasMalos--;
            tipo="malo";
            System.out.println(player2.usuario + " se ha comida un fantasma " + tipo + " de " + player1.usuario);
            separador();
            }
            else{
            break;
            }
        }
        break;
        }}
    
    
    
    
    public boolean fantasmaSale(Player player1, Player player2){
    
    if (tablero[5][0].equals("F1") || tablero[5][5].equals("F1")) {
        
    if(fantasmas[5][0].equals("b1") || fantasmas[5][5].equals("b1")){
        System.out.println(player1.usuario + " ha salido del castillo!");
        player1.partidasGanadas++;
        player2.partidasPerdidas++;
        return player1.fantasmaSale;
    }}
     else if (tablero[0][0].equals("F2") || tablero[0][5].equals("F2")) {
     if(fantasmas[0][0].equals("b2") || fantasmas[0][5].equals("b2")){
        System.out.println(player2.usuario + " ha salido del castillo!");
        player2.partidasGanadas++;
        player1.partidasPerdidas++;
        return player2.fantasmaSale;
    }}

    return false;
}
    public void resultadoRegistro(String resultado, Player player1, Player player2){
        player1.registrarPartida(resultado);
        player2.registrarPartida(resultado);
        
    }
    public boolean empate(Player player1, Player player2){
    String resultado="";
        resultado = "Empate!";
        System.out.println("Empate!");
        resultadoRegistro(resultado, player1, player2);
    
    return true;
    }
    
    public boolean ganar(Player player1, Player player2){
    String resultado="";
    
    if(player1.fantasmasBuenosCapturados ==(player2.maxFantasmas/2)){
    player1.partidasGanadas++;
    player2.partidasPerdidas++;
    resultado = player1.usuario + " triunfo sobre " + player2.usuario + "porque capturo todos sus fantasmas buenos!";
    System.out.println(resultado);
    resultadoRegistro(resultado,player1,player2);
    return true;
    }
    
    if(player1.cantFantasmasMalos == 0 || player2.cantFantasmasMalos==0){
    if(player1.cantFantasmasMalos==0){
    player1.partidasGanadas++;
    player2.partidasPerdidas++;
    resultado = player1.usuario + " triunfo sobre " + player2.usuario + " porque este comio todos sus fantasmas malos!";
    System.out.println(resultado);
    resultadoRegistro(resultado,player1,player2);
    
    }
    else if(player2.cantFantasmasMalos==0){
    player2.partidasGanadas++;
    player1.partidasPerdidas++;
    resultado = player2.usuario + " triunfo sobre " + player1.usuario + " porque este comio todos sus fantasmas malos!";
    System.out.println(resultado);
    resultadoRegistro(resultado,player1,player2);
    
    }
    return true;
    }
    
    if(player1.fantasmaSale || player2.fantasmaSale){
    if(player1.fantasmaSale){
    player1.partidasGanadas++;
    player2.partidasPerdidas++;
    resultado = player1.usuario + " triunfo sobre " + player2.usuario + " porque logro salir del castillo con un fantasma bueno! ";
    System.out.println(resultado);
    resultadoRegistro(resultado,player1,player2);
    
    }
    else if(player2.fantasmaSale){
    player2.partidasGanadas++;
    player2.partidasPerdidas++;
    resultado=player1.usuario + " triunfo sobre " + player2.usuario + " porque logro salir del castillo con un fantasma bueno! " ;
    System.out.println(resultado);
    player1.registrarPartida(resultado);
    resultadoRegistro(resultado,player1,player2);
    }
    return true;
    }
    else if(player2.fantasmasBuenosCapturados == (player1.maxFantasmas/2)){
    player2.partidasGanadas++;
    player1.partidasPerdidas++;
    resultado = player2.usuario + " triunfo sobre " + player1.usuario + "porque capturo todos sus fantasmas buenos!";
    System.out.println(resultado);
    player1.registrarPartida(resultado);
    resultadoRegistro(resultado,player1,player2);
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
   
        
        boolean valida = coordenadaValida(fila, columna,tipo);
        
        if(valida){
        colocar(fila,columna,tipo);
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
    
    public void colocarFantasmasAleatorios(Player player1, Player player2){
    int fila, columna;
    
    String tipo = "bueno";
    
    turnos=1;

    for (int i = 0; i < player1.maxFantasmas; i++) {
        do {
            fila = random.nextInt(2); 
            columna = random.nextInt(6); 
        } while (!coordenadaValidaSilenciosa(fila, columna,tipo));

        tipo = (i % 2 == 0) ? "bueno" : "malo";
        colocar(fila,columna,tipo);
    }
    
    turnos=2;

    for (int i = 0; i < player2.maxFantasmas; i++) {
        do {
            fila = random.nextInt(2) + 4; 
            columna = random.nextInt(6); 
        } while (!coordenadaValidaSilenciosa(fila, columna,tipo));

        tipo = (i % 2 == 0) ? "bueno" : "malo";
        colocar(fila,columna,tipo);
    }

    System.out.println("Fantasmas colocados aleatoriamente.");
    imprimirTablero();
}

    
    
    public String[][] colocar(int fila, int columna, String tipo){
    
        
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



    public boolean coordenadaValida(int fila, int columna,String tipo) {
        
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
    
    return true;
    
}

    public boolean coordenadaValidaSilenciosa(int fila, int columna,String tipo) {
    if (fila < 0 || columna < 0 || fila >= tablero.length || columna >= tablero[0].length) { 
        return false;
    } 
    if (columna == 5 || columna==0){
    return false;
    } 
    else if(tablero[fila][columna].equals("-")){
    return true;
    }
    
   return false;  
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
       else if(tablero[fila][columna].equals("-") || tablero[fila][columna].equals("X")){
        System.out.println("Coordinadas invalidas");
        return false;
               }
       else{
       System.out.println("Movimiento no valido");
       return false;
        }}
    
    public void mostrarFantasmas(){
    String[][] fantasmasTemp = new String [fantasmas.length][fantasmas[0].length];
    System.out.println();
    System.out.println("Sus fantasmas actuales: ");
    
    for (int i = 0; i < fantasmas.length; i++) {
        for (int x = 0; x < fantasmas[i].length; x++) {
            fantasmasTemp[i][x] = fantasmas[i][x];  
        }
        }
    
    switch (turnos){
    
        case 1:
            for (int i = 0; i < fantasmas.length; i++) {
            for (int x = 0; x < fantasmas[i].length; x++) {
            if (fantasmas[i][x].equals("b2") || fantasmas[i][x].equals("m2")) {
                fantasmasTemp[i][x] = "0";  
                }
                    System.out.print(fantasmasTemp[i][x] + " ");  
                }
            System.out.println();
            }
            break;
                
        case 2:
            for (int i = 0; i < fantasmas.length; i++) {
            for (int x = 0; x < fantasmas[i].length; x++) {
            if (fantasmas[i][x].equals("b1") || fantasmas[i][x].equals("m1")) {
                fantasmasTemp[i][x] = "0";  
                }
                    System.out.print(fantasmasTemp[i][x] + " ");  
                }
            System.out.println();
            }
            break;
            
            
    
            }}
    
    public void progreso(Player player1, Player player2){
             separador();
             System.out.println("=========================\nFantasmas buenos restantes de \n" + player1.usuario + ": " + player1.cantFantasmasBuenos );
             System.out.println(player2.usuario + ": " +  player2.cantFantasmasBuenos);
             
             System.out.println("\nFantasmas malos restantes de \n" + player1.usuario + ": " + player1.cantFantasmasMalos);
             System.out.println(player2.usuario + ": " + player2.cantFantasmasMalos + "\n=========================");
             separador();
    
    
            }
            }
    
    
   
    
    
    
    
        
