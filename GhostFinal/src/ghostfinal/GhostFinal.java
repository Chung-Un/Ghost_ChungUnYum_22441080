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
    
    static Player player = new Player();
    static funcionesGenerales funciones= new funcionesGenerales(); 
    
    public static void main(String[] args) {
    
        Scanner entrada = new Scanner(System.in);
        int opcionUsuario=0, posicionUsuario=0;
        String usuarioBusqueda="", passwordBusqueda="";
        
        
        
        System.out.println("**Bienvenido a Ghost**\n===========Menu de Inicio===========\nDigite el numero de la opcion que desea acceder\n1.Login\n2.Crear player\n3.Salir");
        opcionUsuario = entrada.nextInt();
       
        
        switch(opcionUsuario){
        
            case 1:
                
                System.out.println("--->Login\nIngrese su usuario:");
                usuarioBusqueda=entrada.next();
                posicionUsuario = funciones.validarPosicion(player,usuarioBusqueda,player.getUsuariosInfo());
                funciones.validarUsuario(player,posicionUsuario,usuarioBusqueda);
                
                System.out.println("Ingrese su password:");
                passwordBusqueda = entrada.next();
                funciones.validarPassword(player,passwordBusqueda,posicionUsuario);
                
                break;
                
                
            case 2: 
                
                System.out.println("-->Crear Player\nIngrese un nombre de usuario sin espacios:");
                usuarioBusqueda = entrada.next();
                posicionUsuario = funciones.validarPosicion(player,usuarioBusqueda,player.getUsuariosInfo());
                funciones.validarUsuarioNuevo(player,posicionUsuario,usuarioBusqueda); //nuevo debe ser 
                    
                System.out.println("Ingrese una password de 8 caracteres:");
                passwordBusqueda = entrada.next(); 
                funciones.validarPasswordNueva(player,passwordBusqueda);
                
                funciones.crearPlayer(player);
                break;
                
            case 3:
                System.out.println("Hasta luego...");
                System.exit(0);
            }
                
              
        System.out.println("===========Menu principal===========\n1.Jugar\n2.Configuracion\n3.Reportes\n4.Mi perfil\n5.Cerrar sesion");
        opcionUsuario = entrada.nextInt();
        entrada.nextLine();
        
        switch(opcionUsuario){
        
            case 1:
                break;
                
            case 2:
                break;
                
            case 3:
                System.out.println("-->Reportes\n1.Descripcion de mis ultimos 10 juegos\n2.Ranking de jugadores");
                opcionUsuario = entrada.nextInt();
                entrada.nextLine();
                
                switch(opcionUsuario){
                
                    case 1:
                       System.out.println("El resumen de las ultimas 10 partidas de: " + player.getUsuario());
                     
                       for (String i : player.getResumenPartidas()){
                           System.out.println(i);
                       }
                       break;
                       
                    case 2:
                    System.out.println("El ranking de jugadores actuales es:");  
                }
                
               
                
                break;
                
            case 4:
                System.out.println("-->Mi Perfil\n1.Ver mis datos\n2.Cambiar password\n3.Eliminar cuenta\n4.Regresar al menu principal\n5.Cerrar Sesion");
                opcionUsuario = entrada.nextInt();
                entrada.nextLine();
                
                switch(opcionUsuario){
                    
                    case 1:
                        funciones.mostrarDatos(player);
                        break;
                        
                    case 2:
                        
                        System.out.println("Confirme su password actual: ");
                        passwordBusqueda = entrada.nextLine();
                        funciones.validarPassword(player,passwordBusqueda, posicionUsuario);
                        
                        System.out.println("Ingrese su nueva password: ");
                        passwordBusqueda = entrada.nextLine();
                        funciones.validarPasswordNueva(player,passwordBusqueda);
                        
                        funciones.cambiarPassword(player, posicionUsuario,passwordBusqueda);
                        break;
                        
                    case 3:
                        System.out.println("Esta seguro que quiere eliminar su cuenta?(s/n)");
                        String decision;
                        decision = entrada.next().toLowerCase();
                        
                        if(decision.equals("s")){
                        funciones.eliminarCuenta(player);
                        }
                        break;
                       
                    case 4:
                        break;
                        
                    case 5:
                        player.setUsuario(null);
                        player.setPassword(null);
                        break;
                
                }
                
                
                break;
                
            case 5:
                
                
                
                break;
        
         }
        
                
                
        
        
        
        
        }
        
    }
    

