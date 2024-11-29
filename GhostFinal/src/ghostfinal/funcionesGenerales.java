/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ghostfinal;

/**
 *
 * @author chung
 */
public class funcionesGenerales {

    public static int validarPosicion(Player player,String usuarioBusqueda,String[][] usuariosInfo ){
    int posicionUsuario=-1;
    
    for(int i=0;i<player.getUsuariosInfo()[0].length;i++){
    if(usuarioBusqueda.equals(player.getUsuariosInfo()[0][i])){
    posicionUsuario = i;
    break;
    }
    }
    
    
    return posicionUsuario;}
    
    public static void validarUsuario(Player player, int posicionUsuario, String usuarioBusqueda){
    if(posicionUsuario>=0){
                player.setUsuario(usuarioBusqueda);
                System.out.println("Usuario encontrado");
                
                }
                else{
                System.out.println("Usuario no encontrado.");
                
                }

    
    }
    public static void validarPassword(Player player, String passwordBusqueda){
    boolean passwordValida;
    passwordValida = (passwordBusqueda.length()==8);
    
    if(passwordValida){
    System.out.println("Password valida\nCreacion de perfil exitosa.");
    player.setPassword(passwordBusqueda);
    }
    else{
    System.out.println("Esa password no cumple con el requisito de 8 caracteres");
    }   
    
    if(passwordBusqueda.equals(player.getUsuariosInfo()[1][posicionUsuario])){
                player.setPassword(passwordBusqueda);
                System.out.println("Bienvenido " + player.usuario);
                }
                else{
                System.out.println("Password incorrecta");
    
    }
 
    }}
