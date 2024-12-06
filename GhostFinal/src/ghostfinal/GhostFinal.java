/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ghostfinal;

import java.util.Scanner;

/**
 *
 * @author chung
 */
public class GhostFinal {

    /**
     * @param args the command line arguments
     */
    
    static funcionesGenerales funciones= new funcionesGenerales(); 
    static ghostGame game = new ghostGame();
    static boolean passwordValida = false;
    static boolean usuarioValido =false;
    static String[][] usuariosInfo = {{"chungun23","pollochuco24","mellzx"},
                            {"mcr4ever","pollochu","gatos001"},
                            };
    static Player player1 =null;
    static Player player2 = null;
    static int maxFantasmas=8;
    
    static Scanner entrada = new Scanner(System.in);
    static int opcionUsuario=0, posicionUsuario=0;
    static String usuarioBusqueda="", passwordBusqueda="";
    static String jugador2;
    static String modo = "aleatorio";
    
    public static void main(String[] args) {
    
        
        
        
        while(true){
        System.out.println("**Bienvenido a Ghost**\n===========Menu de Inicio===========\nDigite el numero de la opcion que desea acceder\n1.Login\n2.Crear player\n3.Salir");
        opcionUsuario = entrada.nextInt();
       
        
        switch(opcionUsuario){
        
            case 1:
                
                System.out.println("--->Login\nIngrese su usuario:");
                usuarioBusqueda=entrada.next();
                posicionUsuario = funciones.validarPosicion(usuarioBusqueda,usuariosInfo);
                funciones.validarUsuario(posicionUsuario);
                
                if (posicionUsuario>-1){
                System.out.println("Ingrese su password:");
                passwordBusqueda = entrada.next();
                passwordValida = funciones.validarPassword(passwordBusqueda,posicionUsuario,usuariosInfo);
                
                }
                if (passwordValida){
                player1 = new Player(usuarioBusqueda, passwordBusqueda);
                System.out.println("Bienvenido " + player1.usuario);
                menuPrincipal();
                }
                else{
                System.out.println("Login fallido");
                continue;
                }
                break;
                
                
            case 2: 
                
                System.out.println("-->Crear Player\nIngrese un nombre de usuario sin espacios:");
                usuarioBusqueda = entrada.next();
                posicionUsuario = funciones.validarPosicion(usuarioBusqueda,usuariosInfo);
               
                if(posicionUsuario==-1){
                funciones.validarUsuarioNuevo(posicionUsuario); 
                  
                System.out.println("Ingrese una password de 8 caracteres:");
                passwordBusqueda = entrada.next(); 
                passwordValida = funciones.validarPasswordNueva(passwordBusqueda);
                
                }
                if(passwordValida){
                usuariosInfo = funciones.crearPlayer(usuariosInfo,usuarioBusqueda,passwordBusqueda);
                player1 = new Player(usuarioBusqueda, passwordBusqueda);
                menuPrincipal();
                
                }
                else{
                System.out.println("Creacion de perfil fallida");
                continue;
                }
                break;
                
            case 3:
                System.out.println("Hasta luego...");
                System.exit(0);
            }
              
    }
    }   
        static void menuPrincipal(){
        while(true){
        System.out.println("===========Menu principal===========\n1.Jugar\n2.Configuracion\n3.Reportes\n4.Mi perfil\n5.Cerrar sesion");
        opcionUsuario = entrada.nextInt();
        entrada.nextLine();
        
        switch(opcionUsuario){
        
            case 1:
                jugador2 = game.player2();
                posicionUsuario = funciones.validarPosicion(jugador2 , usuariosInfo);
                usuarioValido = funciones.validarUsuario(posicionUsuario);
                
                
                if (usuarioValido){
             
                player2 = new Player (jugador2, null);
                game.hacerTablero();
                game.jugar(modo, player1, player2);
                
                
                } 
                else{
                System.out.println("Jugador no existente.");
                continue;
                
                }
                
                break;
                
            case 2:
                System.out.println("-->Configuracion\n1.Dificultad\n2.Modo de juego\n3.Regresar al menu principal");
                opcionUsuario = entrada.nextInt();
                entrada.nextLine();
                
                switch(opcionUsuario){
                
                  case 1:
                    System.out.println("Elija la dificultad deseada: \n1.Normal \n2.Expert\n3.Genius ");
                    opcionUsuario = entrada.nextInt();
                    entrada.nextLine();
                    game.configuracion(opcionUsuario, player1);
        
    
                    break;
                    
                  case 2:
                      System.out.println("Modo de juego: \n1.Aleatorio\n2.Manual");
                      opcionUsuario=entrada.nextInt();
                      entrada.nextLine();
                      modo = game.modo(opcionUsuario);
                     
                
                }
                break;
                
            case 3:
                System.out.println("-->Reportes\n1.Descripcion de mis ultimos 10 juegos\n2.Ranking de jugadores");
                opcionUsuario = entrada.nextInt();
                entrada.nextLine();
                
                switch(opcionUsuario){
                
                    case 1:
                       System.out.println("El resumen de las ultimas 10 partidas de: " + player1.usuario);
                       
                       player1.mostrarPartidas();
                       
                       
                       break;
                       
                    case 2:
                    System.out.println("El ranking de jugadores actuales no esta disponible");  
                    break;
                }
                
               
                
                break;
                
            case 4:
                System.out.println("-->Mi Perfil\n1.Ver mis datos\n2.Cambiar password\n3.Eliminar cuenta\n4.Regresar al menu principal\n5.Cerrar Sesion");
                opcionUsuario = entrada.nextInt();
                entrada.nextLine();
                
                switch(opcionUsuario){
                    
                    case 1:
                        funciones.mostrarDatos(player1);
                        break;
                        
                    case 2:
                        
                        System.out.println("Confirme su password actual: ");
                        passwordBusqueda = entrada.nextLine();
                        funciones.validarPassword(passwordBusqueda,posicionUsuario,usuariosInfo);
                        
                        if(passwordValida){
                        System.out.println("Ingrese su nueva password: ");
                        passwordBusqueda = entrada.nextLine();
                        funciones.validarPasswordNueva(passwordBusqueda);
                        
                        funciones.cambiarPassword(player1, posicionUsuario, passwordBusqueda);
                        }
                        else{
                        System.out.println("Datos no validos");
                        continue;
                        }
                       
                        break;
                        
                    case 3:
                        System.out.println("Esta seguro que quiere eliminar su cuenta?(s/n)");
                        String decision;
                        decision = entrada.next().toLowerCase();
                        
                        if(decision.equals("s")){
                        funciones.eliminarCuenta(player1);
                        continue;
                        }
                        break;
                       
                    case 4:
                        continue;
                        
                    case 5:
                        player1.setUsuario(null);
                        player1.setPassword(null);
                        break;
                
                }
                
                
                break;
                
            case 5:
                
                
                
                break;
        
         }
        
        }     
                
        
        
        
        
        }
        
    }


