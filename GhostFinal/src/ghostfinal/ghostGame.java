/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ghostfinal;

/**
 *
 * @author chung
 */
public class ghostGame {
 String[][] tablero = {{"-","-","-","-","-","-"},
                       {"-","-","-","-","-","-"},
                       {"-","-","-","-","-","-"},
                       {"-","-","-","-","-","-"},
                       {"-","-","-","-","-","-"},
                       {"-","-","-","-","-","-"}
                     };
 
 
// public String player2verif(){
// String usuarioBusqueda;
// 
// 
// }
// 
 
 public void imprimirTablero(){
 for (int i=0 ; i < tablero.length;i++){
     for (int x=0 ; x<tablero[i].length; x++){
     System.out.print(tablero[i][x] + " ");
     }
 System.out.println();
 }

 }
 
 
 
 
 
 
}
