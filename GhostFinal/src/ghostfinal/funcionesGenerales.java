/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ghostfinal;


import java.util.Set;


/**
 *
 * @author chung
 */
public class funcionesGenerales {
    
    public static int validarPosicion(String usuarioBusqueda,String[][] usuariosInfo ){
    int posicionUsuario=-1;
    
    for(int i=0;i<usuariosInfo[0].length;i++){
    if(usuarioBusqueda.equals(usuariosInfo[0][i])){
    posicionUsuario = i;
    break;
    }
    }
    
    
    return posicionUsuario;
    }
    
    
    public static boolean validarUsuario( int posicionUsuario){
    if(posicionUsuario>=0){
                System.out.println("Usuario encontrado");
                return true;
                }
                else{
                System.out.println("Usuario no encontrado.");
                return false;
                }

    }
    
    
    
    public static void validarUsuarioNuevo(int posicionUsuario){
    if(posicionUsuario==-1){
    System.out.println("Usuario valido.");
    }
    else{
    System.out.println("Ese usuario ya se encuentra en uso");
    }
    
    }
    
    public static boolean validarPassword(String passwordBusqueda, int posicionUsuario, String[][] usuariosInfo){
    boolean passwordValida=false;
    
    if(passwordBusqueda.equals(usuariosInfo[1][posicionUsuario])){
                passwordValida=true;
                return passwordValida;
                }
                else{
                System.out.println("Password incorrecta");
                passwordValida= false;
                return passwordValida;
    
    }}
 
    public static boolean validarPasswordNueva (String passwordBusqueda){
    boolean passwordValida = (passwordBusqueda.length()==8);
    
    if(passwordValida){
    System.out.println("Password valida.");
    return true;
    }
    else{
    System.out.println("Esa password no cumple con el requisito de 8 caracteres");
    return false;
    }   
    
    }
    
    public static String[][] crearPlayer(String[][] usuariosInfo,String usuarioBusqueda,String passwordBusqueda){
   
    String[][] usuariosconCreados = new String[usuariosInfo.length][usuariosInfo[0].length+1]; //se crea un nuevo arreglo con una posicion mas que el original
    
    for(int i=0; i< usuariosInfo.length;i++){ //se recorre el arreglo original para reemplazar esos valores en el nuevo
      for(int x=0; x<usuariosInfo[i].length;x++){
        usuariosconCreados[i][x] = usuariosInfo[i][x];
        
        }
    }
    
    usuariosconCreados[0][usuariosconCreados[0].length-1] = usuarioBusqueda;//se establece el usuario como el ultimo agregado
    usuariosconCreados[1][usuariosconCreados[1].length-1]=passwordBusqueda ;//se hace lo mismo con la password
    
    
    System.out.println("Usuario creado exitosamente!");
    return usuariosconCreados;
    }

    public static void mostrarDatos(Player player){
    System.out.println("Usuario: " + player.usuario);
    System.out.println("Partidas ganadas: " + player.partidasGanadas);
    System.out.println("Partidas perdidas: " + player.partidasPerdidas);
    System.out.println("Partidas empatadas: " + player.partidasEmpatadas);
    
    }

    public static void cambiarPassword(Player player, int posicionUsuario, String passwordBusqueda){
    player.setPassword(passwordBusqueda);
    player.getUsuariosInfo()[1][posicionUsuario] = passwordBusqueda;
        
    System.out.println("Password cambiada con exito!");
    
    }
    
    public static void eliminarCuenta(Player player){
    String[][] arregloNuevo =new String [player.usuariosInfo.length][player.usuariosInfo[0].length-1];
    String usuarioPrueba;
    
    int indice=0;
            
    for(int i=0; i<player.usuariosInfo[0].length;i++){
        usuarioPrueba =  player.getUsuariosInfo()[0][i];
        
        if(!usuarioPrueba.equals(player.usuario)){
        for(int x=0; x< arregloNuevo.length;x++){
        arregloNuevo[x][indice] = player.getUsuariosInfo()[x][i];
        }
        
        }
          
    }
    player.setUsuariosInfo(arregloNuevo);  
    System.out.println("Perfil eliminado exitosamente");
    }
    
   
   
    
}
